package com.ripbull.ertc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.chat.follow.FollowThreadListFragment
import com.ripbull.ertc.chat.history.ChatHistoryFragment
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.notification.NotificationChannels
import com.ripbull.ertc.onboard.SettingsFragment
import com.ripbull.ertc.user.list.UserListFragment
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.addFragment
import com.ripbull.ertc.util.hideKeyBoard
import com.ripbull.ertc.util.replaceFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), OnNavigationItemSelectedListener {

  var fragment: Fragment? = null
  var tag: String? = null
  private val disposable = CompositeDisposable()

  companion object {
    @JvmStatic
    fun newIntent(context: Context, isChatRestoration: Boolean = false): Intent {
      val intent = Intent(context, MainActivity::class.java)
      intent.putExtra(CHAT_RESTORATION, isChatRestoration)
      return intent
    }

    const val CHAT_RESTORATION = "RESTORATION"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (intent != null) {
      eRTCSDK.fcm().clearNotification()
    }

    NotificationChannels.create(this)

    //create FCM token and store it to server.
    //eRTCSDK.registerFCMToServer()
    val myIntent = Intent(applicationContext, MainActivity::class.java)
    myIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
    eRTCSDK.getIntentForFCM(myIntent)

    if (intent.getBooleanExtra(CHAT_RESTORATION, false)) {
      showProgressbar()
    } else if (intent.getBooleanExtra(AppConstants.NOTIFICATION, false)) {
      val threadId = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
      val senderId = intent.getStringExtra(AppConstants.SENDER_ID)
      val parentMsgid = intent.getStringExtra(AppConstants.PARENT_MESSAGE_ID)

      threadId?.let {
        disposable.add(
          eRTCSDK.chat().getThread(it)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ threadRecord ->
              onNotificationClicked(threadRecord, senderId, parentMsgid)
            }, { throwable ->
              throwable.printStackTrace()
            })
        )
      }
    }

    //to Sync Chat User data.
    disposable.add(
      eRTCSDK.user().chatUsers
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (intent.getBooleanExtra(CHAT_RESTORATION, false)) {
            loadGroups()
          }
        }, {
          dismissProgressbar()
          it.printStackTrace()
        })
    )

    disposable.add(
      eRTCSDK.user().fetchLatestUserStatus()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ it }, { it.printStackTrace() })
    )

    disposable.add(
      eRTCSDK.chat().getChatSettings()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ it }, { it.printStackTrace() })
    )

    fragment = ChatHistoryFragment.newInstance()
    tag = ChatHistoryFragment.tag()

    if (fragment != null && tag != null) {
      addFragment(R.id.fragment_container, fragment!!, tag)
    }
    navigation.setOnNavigationItemSelectedListener(this)

    eRTCSDK.connect()
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.navigation_messages -> {
        if (fragment!!.tag == ChatHistoryFragment.tag()) {
          return false
        }
        fragment = ChatHistoryFragment.newInstance()
        tag = ChatHistoryFragment.tag()
      }
      R.id.navigation_contacts -> {
        if (fragment!!.tag == UserListFragment.tag()) {
          return false
        }
        //startService(UserListSyncService.newIntent(this))
        fragment = UserListFragment.newInstance()
        tag = UserListFragment.tag()
      }
      R.id.navigation_threads -> {
        if (fragment!!.tag == FollowThreadListFragment.tag()) {
          return false
        }
        fragment = FollowThreadListFragment.newInstance()
        tag = FollowThreadListFragment.tag()
      }
      R.id.navigation_more -> {
        if (fragment!!.tag == SettingsFragment.tag()) {
          return false
        }
        fragment = SettingsFragment.newInstance()
        tag = SettingsFragment.tag()
      }
    }

    hideKeyBoard(fragment?.view)
    if (fragment != null && tag != null) {
      replaceFragment(R.id.fragment_container, fragment!!, tag)
    }
    return true
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    if (intent != null) {
      eRTCSDK.fcm().clearNotification()
    }
  }

  private fun loadGroups() {
    //to sync Group data
    disposable.add(
      eRTCSDK.group().groups
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          dismissProgressbar()
        }, {
          dismissProgressbar()
          it.printStackTrace()
        })
    )
  }

  private fun onNotificationClicked(
    threadRecord: ThreadRecord,
    senderId: String?,
    parentMsgId: String? = null
  ) {
    startActivity(
      if (threadRecord.type == ChatType.SINGLE.type) {
        threadRecord.recipient?.id?.let { recipientId ->
          ChatActivity.getChatIntent(this, recipientId, threadRecord.id, senderId, parentMsgId)
        }
      } else {
        threadRecord.groupRecipient?.let { groupRecord ->
          ChatActivity.getGroupChatIntent(this, groupRecord, threadRecord.id, parentMsgId)
        }
      }
    )
  }

}