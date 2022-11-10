package com.ripbull.ertc.chat.forward

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.chat.model.Contact
import com.ripbull.coresdk.chat.model.File
import com.ripbull.coresdk.chat.model.Giphy
import com.ripbull.coresdk.chat.model.Location
import com.ripbull.coresdk.chat.model.Media
import com.ripbull.coresdk.chat.model.Message
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_forward_chat.*
import kotlinx.android.synthetic.main.all_toolbar_dark.*

class ForwardChatActivity: BaseActivity() {

  private val disposable = CompositeDisposable()
  var isGroupDataSelected = false
  var isContactDataSelected = false
  var contactIdList = ArrayList<UserRecord>()
  var groupThreadIdList = ArrayList<GroupRecord>()
  var messageRecord: MessageRecord? = null
  var contactCount = 0
  var groupCount = 0

  companion object {
    @JvmStatic
    fun getForwardChatIntent(context: Context, id: String, threadId: String, chatType: ChatType): Intent {
      val intent = Intent(context, ForwardChatActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      intent.putExtra(AppConstants.EXTRA_CHAT_TYPE, chatType)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_forward_chat)
    chatToolBar(getString(R.string.forward))
    imgToolbarDP.visibility = View.GONE

    setupViewPager(viewpager)

    tabs!!.setupWithViewPager(viewpager)

    val chatType = intent.getSerializableExtra(AppConstants.EXTRA_CHAT_TYPE) as ChatType
    val forwardMessageId = intent.getStringExtra(AppConstants.EXTRA_ID)
    val threadId = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    fabNext.setOnClickListener {
      if (isGroupDataSelected || isContactDataSelected) {
        if (contactCount+groupCount < 11 ){
          showProgressbar()
          fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_enable_bg)))
          val messageList = ArrayList<Message>()
          messageRecord?.let { it1 -> generateMessage(it1, chatType) }?.let { it2 -> messageList.add(it2) }

          disposable.add(
            eRTCSDK.chat()
              .forwardChat(messageList, contactIdList, groupThreadIdList, chatType)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe({
                dismissProgressbar()
                shortToast(getString(R.string.msgForwarded))
                finish()
              }, {
                dismissProgressbar()
                setErrorAlert(it)
              })
          )
        } else {
          shortToast(getString(R.string.forward_chat_max_limit))
        }
      } else {
        fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_disable_bg)))
        shortToast(getString(R.string.select_forward_chat_contact_or_group))
      }
    }

    getMessageRecord(threadId ?: "", forwardMessageId ?: "", chatType)
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun setupViewPager(viewPager: ViewPager) {
    val adapter = ViewPagerAdapter(supportFragmentManager)
    adapter.addFragment(SelectContactFragment.newInstance(),"CONTACTS")
    adapter.addFragment(SelectGroupFragment.newInstance(), "CHANNELS")
    viewPager.adapter = adapter
  }

  @SuppressLint("WrongConstant")
  internal inner class ViewPagerAdapter(
    manager: FragmentManager
  ): FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
      return mFragmentList[position]
    }

    override fun getCount(): Int {
      return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
      mFragmentList.add(fragment)
      mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
      return mFragmentTitleList[position]
    }
  }

  fun updateFabNext(){
    if (isGroupDataSelected || isContactDataSelected) {
      fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_enable_bg)))
    } else {
      fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_disable_bg)))
    }
  }

  private fun getMessageRecord(threadId: String, forwardMessageId: String, chatType: ChatType) {
    if (chatType == ChatType.SINGLE || chatType == ChatType.GROUP) {
      disposable.add(
        eRTCSDK.chat()
          .getMessage(threadId, forwardMessageId)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            messageRecord = it
          }, {
            setErrorAlert(it)
          })
      )
    } else {
      disposable.add(
        eRTCSDK.chat()
          .getChatThreadMessage(threadId, forwardMessageId)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            messageRecord = it
          }, {
            setErrorAlert(it)
          })
      )
    }
  }

  private fun generateMessage(messageRecord: MessageRecord, chatType: ChatType): Message {
    if (messageRecord.msgType == MessageType.IMAGE.type) {
      return Message(
        media = messageRecord.mediaPath?.let { Media(it, MessageType.IMAGE) },
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.GIF.type) {
      return Message(
        media = messageRecord.mediaPath?.let { Media(it, MessageType.GIF) },
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.VIDEO.type) {
      return Message(
        media = messageRecord.mediaPath?.let { Media(it, MessageType.VIDEO) },
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.AUDIO.type) {
      return Message(
        media = messageRecord.mediaPath?.let { Media(it, MessageType.AUDIO) },
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.FILE.type) {
      return Message(
        file = messageRecord.mediaPath?.let { File(it, MessageType.FILE) },
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.CONTACT.type) {
      return Message(
        contact = Contact(
          messageRecord.contactName,
          messageRecord.phoneContactRecord,
          messageRecord.emailContactRecord,
          MessageType.CONTACT
        ),
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.LOCATION.type) {
      return Message(
        location = Location(
          messageRecord.locationRecord?.address,
          messageRecord.locationRecord?.latitude,
          messageRecord.locationRecord?.longitude,
          MessageType.LOCATION
        ),
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else if (messageRecord.msgType == MessageType.GIPHY.type) {
      return Message(
        giphy = messageRecord.gifPath?.let { Giphy(it, MessageType.GIPHY) },
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    } else {
      return Message(
        message = messageRecord.message,
        chatType = chatType,
        forwardMsgId = messageRecord.id
      )
    }
  }

   fun onContactSelected() {
    this.contactCount = contactIdList.size
     chatToolBar(title = getString(R.string.forward), contactCount = contactCount, groupCount = groupCount)
  }

   fun onGroupSelected() {
    this.groupCount = groupThreadIdList.size
     chatToolBar(title = getString(R.string.forward), contactCount = contactCount, groupCount = groupCount)
   }
}