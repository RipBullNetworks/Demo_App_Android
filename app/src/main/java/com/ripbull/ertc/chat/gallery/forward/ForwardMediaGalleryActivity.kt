package com.ripbull.ertc.chat.gallery.forward

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
import com.ripbull.coresdk.chat.model.Giphy
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

class ForwardMediaGalleryActivity: BaseActivity() {

  private val disposable = CompositeDisposable()
  var isGroupDataSelected = false
  var isContactDataSelected = false
  var contactIdList = ArrayList<UserRecord>()
  var groupThreadIdList = ArrayList<GroupRecord>()
  var contactCount = 0
  var groupCount = 0

  companion object {
    @JvmStatic
    fun getForwardMediaIntent(context: Context, id: String?, path: String?, msgType: String?, chatType: ChatType): Intent {
      val intent = Intent(context, ForwardMediaGalleryActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      intent.putExtra(AppConstants.EXTRA_URL, path)
      intent.putExtra(AppConstants.CHAT_TYPE, msgType)
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
    val msgId = intent.getStringExtra(AppConstants.EXTRA_ID)
    val mediaPath = intent.getStringExtra(AppConstants.EXTRA_URL)
    val msgType = intent.getStringExtra(AppConstants.CHAT_TYPE)
    fabNext.setOnClickListener {
      if (isGroupDataSelected || isContactDataSelected) {
        if (contactCount+groupCount < 11 ){
          showProgressbar()
          fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_enable_bg)))
          val message = generateMessage(msgId ?: "", mediaPath ?: "", msgType ?: "", chatType)

          disposable.add(
            eRTCSDK.chat()
              .forwardMediaChat(message, contactIdList, groupThreadIdList, chatType)
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
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun setupViewPager(viewPager: ViewPager) {
    val adapter = ViewPagerAdapter(supportFragmentManager)
    adapter.addFragment(SelectMediaContactFragment.newInstance(),"CONTACTS")
    adapter.addFragment(SelectMediaGroupFragment.newInstance(), "CHANNELS")
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

  private fun generateMessage(msgId: String, mediaPath: String, msgType: String, chatType: ChatType): Message {
    if (msgType == MessageType.IMAGE.type) {
      return Message(
        media = Media(mediaPath, MessageType.IMAGE),
        chatType = chatType,
        forwardMsgId = msgId
      )
    } else if (msgType == MessageType.GIF.type) {
      return Message(
        media = Media(mediaPath, MessageType.GIF),
        chatType = chatType,
        forwardMsgId = msgId
      )
    } else if (msgType == MessageType.VIDEO.type) {
      return Message(
        media = Media(mediaPath, MessageType.VIDEO),
        chatType = chatType,
        forwardMsgId = msgId
      )
    } else if (msgType == MessageType.AUDIO.type) {
      return Message(
        media = Media(mediaPath, MessageType.AUDIO),
        chatType = chatType,
        forwardMsgId = msgId
      )
    } else if (msgType == MessageType.FILE.type) {
      return Message(
        file = com.ripbull.coresdk.chat.model.File(mediaPath, MessageType.FILE),
        chatType = chatType,
        forwardMsgId = msgId
      )
    } else if (msgType == MessageType.GIPHY.type) {
      return Message(
        giphy = Giphy(mediaPath, MessageType.GIPHY),
        chatType = chatType,
        forwardMsgId = msgId
      )
    } else {
      return Message(
        message = "",
        chatType = chatType,
        forwardMsgId = msgId
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