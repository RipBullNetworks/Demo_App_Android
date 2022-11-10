package com.ripbull.ertc.chat.chat

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.provider.ContactsContract
import android.text.Editable
import android.text.Layout
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.webkit.MimeTypeMap
import android.widget.MultiAutoCompleteTextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.giphy.sdk.ui.GPHContentType
import com.giphy.sdk.ui.GPHSettings
import com.giphy.sdk.ui.themes.GPHTheme.Light
import com.giphy.sdk.ui.themes.GridType.waterfall
import com.giphy.sdk.ui.views.GiphyDialogFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jakewharton.rxbinding2.widget.textChanges
import com.ripbull.coreattachment.compressor.image.Compressor
import com.ripbull.coreattachment.compressor.image.constraint.format
import com.ripbull.coreattachment.compressor.image.constraint.quality
import com.ripbull.coreattachment.compressor.image.constraint.resolution
import com.ripbull.coreattachment.compressor.video.CompressionListener
import com.ripbull.coreattachment.compressor.video.VideoCompressor
import com.ripbull.coreattachment.compressor.video.VideoQuality
import com.ripbull.coreattachment.compressor.video.config.Configuration
import com.ripbull.coreattachment.emoji.EmojiActions
import com.ripbull.coresdk.chat.mapper.ChatEvent
import com.ripbull.coresdk.chat.mapper.ChatReactionRecord
import com.ripbull.coresdk.chat.mapper.DomainDataRecord
import com.ripbull.coresdk.chat.mapper.EmailContactRecord
import com.ripbull.coresdk.chat.mapper.LocationRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.chat.mapper.PhoneContactRecord
import com.ripbull.coresdk.chat.mapper.ProfanityDataRecord
import com.ripbull.coresdk.chat.model.Contact
import com.ripbull.coresdk.chat.model.Giphy
import com.ripbull.coresdk.chat.model.Location
import com.ripbull.coresdk.chat.model.Media
import com.ripbull.coresdk.chat.model.Message
import com.ripbull.coresdk.chat.model.MessageMetaData
import com.ripbull.coresdk.chat.model.Reaction
import com.ripbull.coresdk.core.type.ChatEventType
import com.ripbull.coresdk.core.type.ChatEventType.INCOMING
import com.ripbull.coresdk.core.type.ChatEventType.OUTGOING
import com.ripbull.coresdk.core.type.ChatReactionType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.ChatType.GROUP
import com.ripbull.coresdk.core.type.EventType
import com.ripbull.coresdk.core.type.MentionType
import com.ripbull.coresdk.core.type.MessageStatus
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.MessageType.CONTACT
import com.ripbull.coresdk.core.type.MessageType.GIPHY
import com.ripbull.coresdk.core.type.MessageType.IMAGE
import com.ripbull.coresdk.core.type.MessageType.LOCATION
import com.ripbull.coresdk.core.type.MessageUpdateType
import com.ripbull.coresdk.core.type.NetworkEvent
import com.ripbull.coresdk.core.type.NotificationSettingsType
import com.ripbull.coresdk.core.type.ScrollTo
import com.ripbull.coresdk.core.type.TypingState
import com.ripbull.coresdk.core.type.TypingState.START_TYPING
import com.ripbull.coresdk.core.type.TypingState.STOP_TYPING
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.typing.mapper.TypingIndicatorRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.attachment.AttachmentManager
import com.ripbull.ertc.chat.forward.ForwardChatActivity
import com.ripbull.ertc.chat.reaction.ReactionedUserAdapter
import com.ripbull.ertc.chat.starred.StarredMessagesActivity
import com.ripbull.ertc.chat.thread.ThreadActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.longToast
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.group.detail.GroupDetailsActivity
import com.ripbull.ertc.group.detail.SelectAdminActivity
import com.ripbull.ertc.onboard.NotificationsSettingActivity
import com.ripbull.ertc.ui.location.ShareLocationActivity
import com.ripbull.ertc.user.details.UserDetailsActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.CompressUtil
import com.ripbull.ertc.util.FileUtils
import com.ripbull.ertc.util.MediaUtil
import com.ripbull.ertc.util.ViewUtil
import com.ripbull.ertc.util.hideKeyBoard
import com.ripbull.ertc.util.showToastLong
import com.ripbull.ertc.util.showToastShort
import com.ripbull.permissions.Permissions
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_chat.blockedUserTextView
import kotlinx.android.synthetic.main.activity_chat.fabScrollBottom
import kotlinx.android.synthetic.main.activity_chat.rvChatHistory
import kotlinx.android.synthetic.main.activity_chat.scrollToBottom
import kotlinx.android.synthetic.main.activity_chat.tvAlertUser
import kotlinx.android.synthetic.main.activity_chat.tvFreezeChannel
import kotlinx.android.synthetic.main.activity_chat.tvMsgCount
import kotlinx.android.synthetic.main.all_toolbar_dark.toolbar
import kotlinx.android.synthetic.main.all_toolbar_dark.tvSubTitle
import kotlinx.android.synthetic.main.chat_bottom_dialog.view.*
import kotlinx.android.synthetic.main.chat_box.*
import kotlinx.android.synthetic.main.chat_box_attachment.attacheDummyView
import kotlinx.android.synthetic.main.chat_box_attachment.rlAttachment
import kotlinx.android.synthetic.main.chat_box_attachment.shareAudio
import kotlinx.android.synthetic.main.chat_box_attachment.shareContact
import kotlinx.android.synthetic.main.chat_box_attachment.shareDocument
import kotlinx.android.synthetic.main.chat_box_attachment.shareGIF
import kotlinx.android.synthetic.main.chat_box_attachment.shareImage
import kotlinx.android.synthetic.main.chat_box_attachment.shareLocation
import kotlinx.android.synthetic.main.chat_box_attachment.shareVideo
import kotlinx.android.synthetic.main.dialog_alert_info.*
import kotlinx.android.synthetic.main.dialog_image_preview.ivCancel
import kotlinx.android.synthetic.main.dialog_image_preview.ivPlay
import kotlinx.android.synthetic.main.dialog_image_preview.ivSelect
import kotlinx.android.synthetic.main.dialog_image_preview.ivShowImage
import kotlinx.android.synthetic.main.dialog_image_preview.progressBarGif
import kotlinx.android.synthetic.main.dialog_message_report.view.*
import kotlinx.android.synthetic.main.dialog_reacted_users.view.rvReactionedUser
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.File
import java.util.Date
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/**
 * @author Sagar
 */
class ChatActivity : BaseActivity(), ChatCommonAdapter.ChatCommonAdapterListener,
    ViewUtil.DeleteMessageDialogClickListener {

  var mAdapter: ChatCommonAdapter? = null
  private var isAttachmentHidden = true
  private lateinit var user: UserRecord
  private lateinit var group: GroupRecord

  //For animation of Attachment pop-up
  private var animStart: Animation? = null
  private var animEnd: Animation? = null

  private var strRecipientId: String? = null

  private lateinit var attachmentManager: AttachmentManager

  private val disposable = CompositeDisposable()

  private var messageList = ArrayList<MessageRecord>()

  private var threadID: String? = null

  private var starMessageId: String? = null

  private var isMenuSet: Boolean = false

  private var typingTimerDisposable: Disposable? = null
  private var isTypingState = false
  private var cameraImage: File? = null

  private var type: Int? = null
  private var threadType: String? = null
  private var isLoaded: Boolean = false
  private var chatType: ChatType = ChatType.SINGLE
  private var isScrollAtBottom = true
  private var msgCount = 0
  private var isUserInactive = false
  private var chatMenu: Menu? = null

  private var editMessageRecord: MessageRecord? = null
  private var editMessagePosition = -1
  private var muteSettings = NotificationSettingsType.NONE.mute
  private var userList = ArrayList<UserRecord>()
  private var settings = GPHSettings(gridType = waterfall, theme = Light, stickerColumnCount = 3)
  private var lastMsgId: String = ""
  private var isDataLoaded = true
  private var domainFilterList = ArrayList<DomainDataRecord>()
  private var profanityFilterList = ArrayList<ProfanityDataRecord>()

  companion object {
    @JvmStatic
    fun getChatIntent(
      context: Context,
      strRecipientId: String,
      threadId: String,
      starMessageId: String,
      isGlobalSearched: Boolean? = false
    ): Intent {
      val intent = Intent(context, ChatActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_CHAT_TYPE, AppConstants.TYPE_SINGLE)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.STAR_MESSAGE_ID, starMessageId)
      intent.putExtra(AppConstants.EXTRA_ID, strRecipientId)
      intent.putExtra(AppConstants.IS_GLOBAL_SEARCH, isGlobalSearched)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
      return intent
    }

    @JvmStatic
    fun getChatIntent(
      context: Context,
      strRecipientId: String,
      threadId: String,
      senderId: String? = null,
      parentMsgId: String? = null
    ): Intent {
      val intent = Intent(context, ChatActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_CHAT_TYPE, AppConstants.TYPE_SINGLE)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.EXTRA_ID, strRecipientId)
      intent.putExtra(AppConstants.SENDER_ID, senderId)
      intent.putExtra(AppConstants.PARENT_MESSAGE_ID, parentMsgId)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
      return intent
    }

    @JvmStatic
    fun getGroupChatIntent(
      context: Context,
      group: GroupRecord,
      threadId: String,
      parentMsgId: String? = null
    ): Intent {
      val intent = Intent(context, ChatActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_CHAT_TYPE, AppConstants.TYPE_GROUP)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.EXTRA_GROUP_RECORD, group)
      intent.putExtra(AppConstants.PARENT_MESSAGE_ID, parentMsgId)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
      return intent
    }

    @JvmStatic
    fun getGroupChatIntent(
      context: Context,
      group: GroupRecord,
      threadId: String,
      starMessageId: String,
      isGlobalSearched: Boolean? = false
    ): Intent {
      val intent = Intent(context, ChatActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_CHAT_TYPE, AppConstants.TYPE_GROUP)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.STAR_MESSAGE_ID, starMessageId)
      intent.putExtra(AppConstants.EXTRA_GROUP_RECORD, group)
      intent.putExtra(AppConstants.IS_GLOBAL_SEARCH, isGlobalSearched)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
      return intent
    }

    const val INIT_MESSAGE_LIST = 27
    const val INIT_MESSAGE_LIST_TO_BOTTOM = 28
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_chat)

    Permissions.with(this).request(
      Manifest.permission.CAMERA,
      Manifest.permission.WRITE_EXTERNAL_STORAGE,
      Manifest.permission.READ_CONTACTS,
      Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.ACCESS_COARSE_LOCATION,
      Manifest.permission.RECORD_AUDIO
    ).ifNecessary()
      .withPermanentDenialDialog(this.getString(R.string.attachment_permissions_denied))
      .onAllGranted {}.execute()

    attachmentManager = AttachmentManager(this)

    threadID = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    if (intent.hasExtra(AppConstants.STAR_MESSAGE_ID))
      starMessageId = intent.getStringExtra(AppConstants.STAR_MESSAGE_ID)
    type = intent.getIntExtra(AppConstants.EXTRA_CHAT_TYPE, AppConstants.TYPE_SINGLE)
    if (intent.hasExtra(AppConstants.EXTRA_ID)) {
      strRecipientId = intent.getStringExtra(AppConstants.EXTRA_ID)
    } else if (intent.hasExtra(AppConstants.EXTRA_GROUP_RECORD)) {
      group = intent.getSerializableExtra(AppConstants.EXTRA_GROUP_RECORD) as GroupRecord
    }

    if (type == AppConstants.TYPE_GROUP) {
      chatType = ChatType.GROUP
    }

    val parentMsgId = intent.getStringExtra(AppConstants.PARENT_MESSAGE_ID)
    if (parentMsgId != null) {
      startActivityForResult(
        if (type == AppConstants.TYPE_SINGLE) {
          val senderId = intent.getStringExtra(AppConstants.SENDER_ID)
          senderId?.let { it1 ->
            threadID?.let { it2 ->
              ThreadActivity.getThreadIntent(this, it1, it2, parentMsgId, strRecipientId!!)
            }
          }
        } else {
          threadID?.let { it1 ->
            ThreadActivity.getGroupThreadIntent(this, group, it1, parentMsgId)
          }
        }, INIT_MESSAGE_LIST_TO_BOTTOM)
    }

    loadUI()
    initSubscribeMethods()
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
    mAdapter?.stopMedia()
  }

  override fun onResume() {
    super.onResume()
    markAsRead()
    loadDetail()
  }

  override fun onStop() {
    super.onStop()
    typingTimerDisposable?.dispose()
  }

  private fun onUserSuccess(user: UserRecord) {
    this.user = user
    initActionbar()
  }

  private fun onUserError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  private fun onGroupSuccess(groupRecord: GroupRecord) {
    group = groupRecord
    if (groupRecord.isNotInGroup) {
      blockedUserTextView.visibility = View.VISIBLE
      blockedUserTextView.text = getString(R.string.blocked_group_toast)
      hideKeyBoard(relChatType)
      relChatType.visibility = View.INVISIBLE
    } else if (groupRecord.groupStatus == GroupRecord.STATUS_DELETED) {
      hideKeyBoard(relChatType)
      tvFreezeChannel.text = getString(R.string.txt_delete_alert)
      tvFreezeChannel.visibility = View.VISIBLE
      relChatType.visibility = View.INVISIBLE
      if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.txt_delete_alert))
          .setCancelable(false)
          .setPositiveButton("OK") { dialog, id ->
            finish()
          }.create().show()
      }
    } else if (groupRecord.groupStatus == GroupRecord.STATUS_DEACTIVATED) {
      hideKeyBoard(relChatType)
      tvFreezeChannel.text = getString(R.string.txt_deactivated_alert)
      tvFreezeChannel.visibility = View.VISIBLE
      relChatType.visibility = View.INVISIBLE
      if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.txt_deactivated_alert))
          .setCancelable(false)
          .setPositiveButton("OK") { dialog, id ->
            finish()
          }.create().show()
      }
    } else if (groupRecord.groupStatus == GroupRecord.STATUS_FROZEN) {
      hideKeyBoard(relChatType)
      tvFreezeChannel.text = getString(R.string.txt_frozen_alert)
      tvFreezeChannel.visibility = View.VISIBLE
      relChatType.visibility = View.INVISIBLE
    } else {
      tvFreezeChannel.visibility = View.GONE
      blockedUserTextView.visibility = View.GONE
      relChatType.visibility = View.VISIBLE
    }
    initGroupActionbar()
  }

  private fun onGroupError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  private fun loadDetail() {
    if (type == AppConstants.TYPE_SINGLE) {
      threadType = ChatType.SINGLE.type
      getOnStartDisposable()?.add(
        eRTCSDK.user().getUserById(this.strRecipientId!!).subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          this::onUserSuccess, this::onUserError
        )
      )
    } else if (type == AppConstants.TYPE_GROUP) {
      if (!isLoaded) {
        threadType = ChatType.GROUP.type
        disposable.add(
          eRTCSDK.group().getGroupById(group.groupId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              onGroupSuccess(it)
            }, {
              onGroupError(it)
            })
        )
      }
    }

    disposable.add(
      eRTCSDK.notification().getSettings(threadID!!).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        it.allowFrom?.let { it1 -> setMuteNotificationSettings(it1) }
      }, {
        setErrorAlert(it, false)
      }
      )
    )

    disposable.add(
      eRTCSDK.user().mentionedUsers
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          userList = it as ArrayList<UserRecord>
          setMentionAutoCompleteTextView(userList)
        }, {
          setMentionAutoCompleteTextView()
          setErrorAlert(it)
        })
    )
  }

  private fun loadUI() {
    MediaUtil.createDirectories()
    initMessageList()
    initAnim()

    disposable.add(et_message.textChanges().debounce(
      100, TimeUnit.MILLISECONDS
    ).filter { et_message.length() > 0 }.observeOn(AndroidSchedulers.mainThread()).subscribe({
      if (!isTypingState) {
        typingTimerDisposable = null
        startTyping()
      }
    }, {})
    )

    //OnCLick event listener and Focus changed listener
    iv_send.setOnClickListener {
      hideAttachmentView()
      when {
        rlAudio.visibility == View.VISIBLE                     -> {
          sendRecordedAudio()
        }
        et_message.text?.trim().toString().trim().isNotEmpty() -> {
          onSendClicked()
        }
        else                                                   -> {
          showToastShort(getString(R.string.hold_to_record))
        }
      }
    }

    et_message.setOnClickListener {
      hideAttachmentView()
      openSoftKeyBoard()
    }

    et_message.setOnFocusChangeListener { _, _ ->
      hideAttachmentView()
      openSoftKeyBoard()
    }

    iv_send.setOnFocusChangeListener { _, _ -> hideAttachmentView() }

    attacheDummyView.setOnClickListener {
      hideAttachmentView()
    }

    shareImage.setOnClickListener {
      hideAttachmentView()
      showDialog()
    }

    shareVideo.setOnClickListener {
      hideAttachmentView()
      showVideoDialog()
    }

    shareAudio.setOnClickListener {
      hideAttachmentView()
      addAttachment(AttachmentManager.PICK_AUDIO)
    }

    shareContact.setOnClickListener {
      hideAttachmentView()
      addAttachment(AttachmentManager.PICK_CONTACT)
    }

    shareLocation.setOnClickListener {
      hideAttachmentView()
      addAttachment(AttachmentManager.PICK_LOCATION)
    }

    shareDocument.setOnClickListener {
      hideAttachmentView()
      addAttachment(AttachmentManager.PICK_FILE)
    }

    shareGIF.setOnClickListener {
      hideAttachmentView()
      val dialog = GiphyDialogFragment.newInstance(settings)
      dialog.gifSelectionListener = getGifSelectionListener()
      dialog.show(supportFragmentManager, "giphy_dialog")
    }

    iv_send.setOnLongClickListener {
      if (et_message.text?.trim().toString().isEmpty()) {
        hideAttachmentView()
        recordAudio()
      }
      return@setOnLongClickListener true
    }

    rvChatHistory.isNestedScrollingEnabled = false

    rvChatHistory.addOnScrollListener(object : RecyclerView.OnScrollListener() {
      override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (!recyclerView.canScrollVertically(1)) {
          isScrollAtBottom = true
          msgCount = 0
          scrollToBottom.visibility = View.GONE
        } else {
          isScrollAtBottom = false
          scrollToBottom.visibility = View.VISIBLE
          if (msgCount == 0) {
            tvMsgCount.visibility = View.GONE
          }

          if (!recyclerView.canScrollVertically(-1) && isDataLoaded && eRTCSDK.chat().isChatRestored()) {
            isDataLoaded = false
            if (lastMsgId == messageList[0].id) {
              return
            }
            lastMsgId = messageList[0].id
            disposable.add(
              eRTCSDK.chat().getMessages(threadId = threadID!!, currentMsgId = lastMsgId, direction = ScrollTo.PAST.type, pageSize = 15)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  val msgList = it as ArrayList<MessageRecord>
                  msgList.addAll(messageList)
                  messageList = msgList
                  isDataLoaded = true
                  if (mAdapter != null) {
                    mAdapter?.update(messageList)
                  }
                }) {
                  isDataLoaded = true
                  setErrorAlert(it)
                }
            )
          }
        }
      }
    })

    fabScrollBottom.setOnClickListener {
      this.rvChatHistory?.scrollToPosition(this.mAdapter?.itemCount?.minus(1)!!)
      msgCount = 0
      isScrollAtBottom = true
      scrollToBottom.visibility = View.GONE
      tvMsgCount.visibility = View.GONE
    }

    // Not including the following line in production code increases performance
    // See the javadoc (control click runListenerInBackground) for more information
    et_message.runListenerInBackground = false

    // The following line sets the listener that is called when rich content is received
    et_message.setOnRichContentListener { contentUri, description ->
      setGifFile(contentUri, description)
    }

  }

  private fun initMessageList() {
    showProgressbar()
    var currentMsgId: String? = null
    if (intent.hasExtra(AppConstants.IS_GLOBAL_SEARCH)) {
      if (intent.getBooleanExtra(AppConstants.IS_GLOBAL_SEARCH, false)) {
        currentMsgId = starMessageId
      }
    }

    disposable.add(
      eRTCSDK.chat().getMessages(threadId = threadID!!, currentMsgId = currentMsgId, direction = ScrollTo.PAST.type, pageSize = 15, isGlobalSearched = true)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onMessageListSuccess, this::onMessageListError
        )
    )
  }

  private fun fetchMessageList() {
    disposable.add(
      eRTCSDK.chat().getMessages(threadId = threadID!!, direction = ScrollTo.PAST.type, pageSize = 15)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onMessageListFetched, this::onMessageListError
        )
    )
  }

  private fun initSubscribeMethods() {
    disposable.add(
      eRTCSDK.chat().messageOn(threadID!!, "", chatType).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        this.mAdapter?.notifyMessageAdded(it.messageRecord())
        markAsRead()
        if (isScrollAtBottom) {
          this.rvChatHistory?.scrollToPosition(this.mAdapter?.itemCount?.minus(1)!!)
        } else {
          if (msgCount == 0) {
            scrollToBottom.visibility = View.VISIBLE
            tvMsgCount.visibility = View.VISIBLE
          }
          msgCount += 1
          if (msgCount < 10) {
            tvMsgCount.text = "$msgCount"
          } else {
            tvMsgCount.text = "9+"
          }
        }

        Log.d("mqtt", "size : ${it.text}")
      }, { setErrorAlert(it) })
    )

    disposable.add(
      eRTCSDK.typing().subscribe(threadID).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        Log.d("mqtt", "Typing Indicator : ${it.typingStatus}")
        if (!(chatType == ChatType.SINGLE && user.blockedStatus.equals(AppConstants.USER_BLOCKED))) {
          setSubTitleText(it)
        }
      }, { it.printStackTrace() })
    )

    if (chatType == ChatType.SINGLE) {
      disposable.add(
        eRTCSDK.chat().msgReadStatus(threadID!!, "", chatType).subscribeOn(Schedulers.io())
          .observeOn(
            AndroidSchedulers.mainThread()
          ).subscribe({
            this.mAdapter?.notifyMessageStatusChanged(it.messageRecord())
            markAsRead()
          }, {
            setErrorAlert(it)
          })
      )
    }

    disposable.add(
      eRTCSDK.chat().downloadOn(threadID!!, "", chatType).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        this.mAdapter?.notifyMessageStatusChanged(it.messageRecord())
      }, {
        setErrorAlert(it)
      })
    )

    if (chatType == ChatType.GROUP) {
      disposable.add(
        eRTCSDK.group().subscribeToGroupUpdate().subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            if (group.groupId == it.groupId) {
              onGroupSuccess(it)
            }
          }, {
            setErrorAlert(it)
          })
      )
    }

    disposable.add(
      eRTCSDK.chat().chatMetaDataOn(threadID!!).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        it.notificationSettings?.let { it1 -> setMuteNotificationSettings(it1) }
      }, {
        setErrorAlert(it)
      }
      )
    )

    disposable.add(
      eRTCSDK.chat().messageMetaDataOn(threadID!!)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          it.chatReactionRecord?.let { it1 -> this.mAdapter?.notifyMessageMetaDataUpdated(it1) }
        }, {
          setErrorAlert(it)
        })
    )

    disposable.add(
      eRTCSDK.chat().sourceOnMain()
        .filter(ChatEvent.filterType(EventType.THREAD_MESSAGE_METADATA))
        .filter { it.threadId == threadID }
        .subscribe({
          Log.d("Chat", "ChatEvent: $it")
          it.threadMetadata?.let { it1 -> this.mAdapter?.notifyThreadMetadataChanged(it1) }
        }, {
          setErrorAlert(it)
        })
    )

    disposable.add(
      eRTCSDK.chat().messageOn()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .filter(NetworkEvent.filterType(EventType.MESSAGE_UPDATED)).subscribe ({
          val messageRecord = it.messageRecord()
          if (messageRecord.type == ChatType.SINGLE_CHAT_THREAD.type || messageRecord.type == ChatType.GROUP_CHAT_THREAD.type) {
            return@subscribe
          }

          if(messageRecord.updateType == MessageUpdateType.DELETE){
            // update UI for delete
            this.mAdapter?.notifyMessageUpdated(it.messageRecord())
          } else if (messageRecord.updateType == MessageUpdateType.EDIT){
            // update UI for edit
            this.mAdapter?.notifyMessageUpdated(it.messageRecord())
          } else if (messageRecord.updateType == MessageUpdateType.FAVORITE){
            // update UI for favourite
            this.mAdapter?.notifyMessageUpdated(it.messageRecord())
          }
        },{
          setErrorAlert(it)
        })
    )

    disposable.add(
      eRTCSDK.chat().getProfanityFilters()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          profanityFilterList = it as ArrayList<ProfanityDataRecord>
        }, {
          setErrorAlert(it)
        })
    )

    disposable.add(
      eRTCSDK.chat().getDomainFilters()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          domainFilterList = it as ArrayList<DomainDataRecord>
        }, {
          setErrorAlert(it)
        })
    )
  }

  private fun onMessageListSuccess(messageList: List<MessageRecord>) {
    dismissProgressbar()
    this.messageList = messageList as ArrayList<MessageRecord>
    if (mAdapter != null) {
      mAdapter?.update(messageList)
    } else {
      initChatAdapter(messageList)
      var scrollPosition = if (this.messageList.size > 0) (this.messageList.size - 1) else 0
      when {
        !starMessageId.isNullOrEmpty() -> {
          0.until(messageList.size).forEach { i ->
            when (starMessageId) {
              messageList[i].id -> {
                scrollPosition = i
              }
            }
          }
          mAdapter?.highlightPosition(scrollPosition)
          (rvChatHistory.layoutManager as LinearLayoutManager).scrollToPosition(scrollPosition)
        }
      }
    }

    markAsRead()
  }

  private fun onMessageListFetched(messageList: List<MessageRecord>) {
    this.messageList = messageList as ArrayList<MessageRecord>
    if (mAdapter != null) {
      mAdapter?.update(messageList)
      this.mAdapter?.itemCount?.minus(1)?.let { rvChatHistory.scrollToPosition(it) }
    }

    markAsRead()
  }

  private fun onMessageListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  private fun onSendClicked() {
    var textMessage = et_message.text.toString().trim()
    val pattern = Regex("@+[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+|@channel|@here")
    val userPattern = Regex("@+[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
    val genericPattern = Regex("@channel|@here")
    val userHashSet = HashSet<String>()
    var mention: MentionType? = null

    if (isEdit && textMessage == editMessageRecord?.message) {
      isEdit = false
      toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
      updateMenuItemsForEdit(true)
      clEdit.visibility = View.GONE
      et_message.setText("")
      return
    }

    if (chatType == ChatType.SINGLE) {
      if (userPattern.containsMatchIn(textMessage)) {
        textMessage = userPattern.replace(textMessage) { matchResult ->
          if (matchResult.toString().toLowerCase() == "@channel" || matchResult.toString()
              .toLowerCase() == "@here"
          ) {
            matchResult.value
          } else {
            userHashSet.add(matchResult.value.substring(1, matchResult.value.length))
            getMentionedUser(matchResult.value)
          }
        }
      }
    } else {
      if (pattern.containsMatchIn(textMessage)) {
        textMessage = pattern.replace(textMessage) { matchResult ->
          if (genericPattern.containsMatchIn(matchResult.value)) {
            if (mention != null && mention == MentionType.CHANNEL) {
              //You are done
            } else if (matchResult.value == "@channel") {
              mention = MentionType.CHANNEL
            } else if (matchResult.value == "@here") {
              mention = MentionType.HERE
            }
            "<" + matchResult.value + ">"
          } else {
            if (matchResult.toString().toLowerCase() == "@channel" || matchResult.toString()
                .toLowerCase() == "@here"
            ) {
              matchResult.value
            } else {
              userHashSet.add(matchResult.value.substring(1, matchResult.value.length))
              getMentionedUser(matchResult.value)
            }
          }
        }
      }
    }

    val mentionList = ArrayList<String>()
    if (userHashSet.isNotEmpty()) {
      mentionList.addAll(userHashSet)
    }

    //add profanity and domain filter
    textMessage = " $textMessage "
    domainFilterList?.let {
      val dfList = it.sortedWith(compareBy { it.domain }).reversed().toCollection(ArrayList())
      for (domain in dfList) {
        val domainPattern = Regex("(?i)" + " " + domain.domain + " ")
        if (domainPattern.containsMatchIn(textMessage)) {
          if (domain.actionType == AppConstants.REPLACE) {
            textMessage = textMessage.replace(domainPattern, " ***** ")
          } else if (domain.actionType == AppConstants.BLOCK) {
            tvAlertUser.text = getString(R.string.domain_alert)
            tvAlertUser.visibility = View.VISIBLE
            return
          }
        }
      }
    }

    profanityFilterList?.let {
      val pfList = it.sortedWith(compareBy { it.keyword }).reversed().toCollection(ArrayList())
      for (profanity in pfList) {
        val profanityPattern = Regex("(?i)" + " " + profanity.keyword + " ")
        if (profanityPattern.containsMatchIn(textMessage)) {
          if (profanity.actionType == "replace") {
            textMessage = textMessage.replace(profanityPattern, " ***** ")
          } else if (profanity.actionType == AppConstants.BLOCK) {
            tvAlertUser.text = getString(R.string.profanity_alert)
            tvAlertUser.visibility = View.VISIBLE
            return
          }
        }
      }
    }
    textMessage = textMessage.trim()

    val messageRecord = MessageRecord(
      id = AppConstants.EXTRA_MSG_ID,
      timestamp = System.currentTimeMillis(),
      message = textMessage,
      type = threadType,
      threadId = threadID,
      status = MessageStatus.SENDING.status,
      msgType = MessageType.TEXT.type,
      senderId = ERTCApplication.getSession(this).getUserId(),
      chatEventType = ChatEventType.OUTGOING
    )

    val message = Message(
      message = textMessage,
      chatType = chatType,
      mentions = mention,
      mentioned_users = mentionList
    )

    if (isEdit) {
      val messageRecord = editMessageRecord
      val message: Message = if (chatType == ChatType.GROUP || chatType == ChatType.SINGLE){
        Message(
          msgId = messageRecord!!.id,
          message = textMessage,
          chatType = chatType,
          mentions = mention,
          mentioned_users = mentionList
        )
      } else {
        Message(
          parentMsgId = messageRecord!!.chatThreadMetadata!!.parentMsgId,
          msgId = messageRecord.id,
          message = textMessage,
          chatType = chatType,
          mentions = mention,
          mentioned_users = mentionList
        )
      }
      this.updateEditMessageList(messageRecord, message)
      isEdit = false
      toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
      updateMenuItemsForEdit(true)
      clEdit.visibility = View.GONE
    } else {
      this.updateMessageList(messageRecord, message)
    }
    et_message.setText("")
  }

  private fun updateMessageList(
    messageRecord: MessageRecord, message: Message
  ) {
    if(mAdapter == null) {
      initChatAdapter(messageList)
    }

    val position = this.mAdapter?.notifyMessageAdded(messageRecord)
    this.rvChatHistory?.scrollToPosition(this.mAdapter?.itemCount?.minus(1)!!)
    disposable.add(
      eRTCSDK.chat()
        .sendMessage(threadID!!, message)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (it.status == MessageStatus.FAILED.status) {
            tryAgainMessage(it, position)
          }
          position?.let { it1 -> this.mAdapter?.notifyMessageUpdated(it1, it) }
          this.rvChatHistory?.scrollToPosition(this.mAdapter?.itemCount?.minus(1)!!)
        }, {
          setErrorAlertAndRemoveRecord(it, messageRecord)
        })
    )
  }

  private fun updateEditMessageList(
    messageRecord: MessageRecord, message: Message
  ) {
    if (editMessagePosition != -1) {
      val msgRecord = messageRecord.copy(
        message = message.message,
        updateType = MessageUpdateType.EDIT
      )
      editMessagePosition.let { it1 -> this.mAdapter?.notifyMessageUpdated(it1, msgRecord) }
    }
    disposable.add(
      eRTCSDK.chat()
        .editMessage(threadID!!, message)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (editMessagePosition != -1) {
            editMessagePosition.let { it1 -> this.mAdapter?.notifyMessageUpdated(it1, it) }
          }
        }, {
          setErrorAlert(it, true)
          if (editMessagePosition != -1) {
            editMessagePosition.let { it1 -> this.mAdapter?.notifyMessageUpdated(it1, messageRecord) }
          }
        })
    )
  }

  private fun initAnim() {
    animStart = AnimationUtils.loadAnimation(this, R.anim.bottom_top)
    this.animStart!!.setAnimationListener(object : Animation.AnimationListener {
      override fun onAnimationStart(animation: Animation) {
        rlAttachment.visibility = View.VISIBLE
      }

      override fun onAnimationEnd(animation: Animation) {
        rlAttachment.clearAnimation()
      }

      override fun onAnimationRepeat(animation: Animation) = Unit
    })

    animEnd = AnimationUtils.loadAnimation(this, R.anim.top_bottom)
    this.animEnd!!.setAnimationListener(object : Animation.AnimationListener {
      override fun onAnimationStart(animation: Animation) = Unit

      override fun onAnimationEnd(animation: Animation) {
        rlAttachment.clearAnimation()
        rlAttachment.visibility = View.GONE
      }

      override fun onAnimationRepeat(animation: Animation) = Unit
    })

  }

  private fun handleAttachment() {
    hideKeyBoard(currentFocus)

    if (isAttachmentHidden) {
      rlAttachment.startAnimation(animStart)
    } else {
      rlAttachment.startAnimation(animEnd)
    }
    isAttachmentHidden = !isAttachmentHidden
  }

  private fun hideAttachmentView() {

    if (!isAttachmentHidden) {
      isAttachmentHidden = true
      rlAttachment.startAnimation(animEnd)
    }
  }

  private fun openSoftKeyBoard() {
    if (VERSION.SDK_INT <= VERSION_CODES.O) {
      val mHandler = Handler()
      mHandler.post {
        val inputMethodManager: InputMethodManager =
          getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(
          et_message.applicationWindowToken, InputMethodManager.SHOW_IMPLICIT, 0
        )
        et_message.requestFocus()
      }
    }
  }

  private fun addAttachment(type: Int) {
    when (type) {
      AttachmentManager.PICK_PHOTO    -> AttachmentManager.selectGallery(this)
      AttachmentManager.PICK_AUDIO    -> AttachmentManager.selectAudio(this)
      AttachmentManager.PICK_CONTACT  -> AttachmentManager.selectContactInfo(this)
      AttachmentManager.PICK_LOCATION -> {
        //AttachmentManager.selectLocation(this)
        Permissions.with(this).request(
          Manifest.permission.ACCESS_FINE_LOCATION,
          Manifest.permission.ACCESS_COARSE_LOCATION,
          Manifest.permission.ACCESS_WIFI_STATE
        ).ifNecessary()
          .withPermanentDenialDialog(this.getString(R.string.attachment_location_denied))
          .onAllGranted {
            val intent = Intent(this, ShareLocationActivity::class.java)
            startActivityForResult(intent, AttachmentManager.PICK_LOCATION)
          }.execute()
      }
      AttachmentManager.TAKE_PHOTO    -> {
        cameraImage = attachmentManager.getPhotoImageFile(this)
        attachmentManager.capturePhoto(
          this, cameraImage!!
        )
      }
      AttachmentManager.PICK_VIDEO    -> AttachmentManager.selectVideo(this)
      AttachmentManager.TAKE_VIDEO    -> attachmentManager.captureVideo(this)
      AttachmentManager.PICK_FILE     -> AttachmentManager.selectDocument(this)
    }
  }

  override fun onActivityResult(
    reqCode: Int, resultCode: Int, data: Intent?
  ) {
    super.onActivityResult(reqCode, resultCode, data)

    if (data != null && data.getBooleanExtra(AppConstants.CHANNEL_DELETE, false)) {
      finish()
      return
    }

    if (data == null) {
      if (reqCode == INIT_MESSAGE_LIST) {
        initMessageList()
        msgCount = 0
      } else if (reqCode == INIT_MESSAGE_LIST_TO_BOTTOM) {
        fetchMessageList()
        msgCount = 0
      } else if (reqCode != AttachmentManager.TAKE_PHOTO || resultCode != Activity.RESULT_OK) {
        return
      }
    }

    when (reqCode) {
      AttachmentManager.PICK_PHOTO    -> {
        showMediaPreview(data!!.data, AttachmentManager.MediaType.IMAGE)
      }
      AttachmentManager.PICK_FILE     -> setMedia(data!!.data, AttachmentManager.MediaType.FILE)
      AttachmentManager.PICK_AUDIO    -> setMedia(data!!.data, AttachmentManager.MediaType.AUDIO)
      AttachmentManager.PICK_CONTACT  -> {
        setContact(data!!.data)
      }
      AttachmentManager.TAKE_PHOTO    -> {
        if ((data == null || data.data == null) && resultCode != Activity.RESULT_OK) {
          return
        } else if (cameraImage != null) {
          lifecycleScope.launch {
            val compressedImageFile = Compressor.compress(this@ChatActivity, cameraImage!!) {
              resolution(1280, 720)
              quality(80) // combine with compressor constraint
              format(Bitmap.CompressFormat.JPEG)
            }
            setMedia(Uri.fromFile(compressedImageFile), AttachmentManager.MediaType.IMAGE)
          }
        } else {
          showToastShort(getString(R.string.failure_message))
        }
      }
      AttachmentManager.PICK_LOCATION -> {
        //showToastLong(data!!.getStringExtra("address"))
        setLocation(
          data?.getParcelableExtra(AppConstants.EXTRA_LAT_LNG),
          data?.getStringExtra(AppConstants.EXTRA_ADDRESS)
        )
      }
      AttachmentManager.PICK_GIF      -> {
        if (resultCode == Activity.RESULT_OK) {
          showMediaPreview(mediaType = AttachmentManager.MediaType.GIPHY, url = data?.getStringExtra(AppConstants.EXTRA_URL))
        } else {
          showToastShort(getString(R.string.alert_gif_file_select))
        }
      }
      AttachmentManager.PICK_VIDEO    -> {
        data?.data?.let { uri -> processVideo(uri) }
      }
      AttachmentManager.TAKE_VIDEO    -> {
        if (resultCode == RESULT_OK && data != null) {
          data.data?.let { uri -> processVideo(uri) }
        }
      }
      AppConstants.GROUP_REQUEST_CODE -> {
        val type = data?.getIntExtra(AppConstants.EXTRA_EXIT_TYPE, 0)
        if (type == AppConstants.TYPE_EXIT) {
          finish()
        }
      }
      SelectAdminActivity.REQUEST_CODE_MAKE_ADMIN -> {
        if (data != null) {
          val selectedUser =
            data.getSerializableExtra(SelectAdminActivity.EXTRA_MAKE_ADMIN) as ArrayList<UserRecord>

          if (selectedUser.isNotEmpty()) {
            for ((index, user) in selectedUser.withIndex()) {
              disposable.add(
                eRTCSDK.group()
                  .addAdmin(group.groupId, user.id)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe({
                    dismissProgressbar()
                    if (index == (selectedUser.size - 1)) {
                      exitGroup(group.groupId)
                      /*if (group.groupType == GroupRecord.TYPE_PUBLIC) {
                        leaveChannelDialog(getString(R.string.admin_leave_public_channel), group.groupId)
                      } else {
                        leaveChannelDialog(getString(R.string.admin_leave_private_channel), group.groupId)
                      }*/
                    }
                  }, {
                    setErrorAlert(it)
                  })
              )
            }
          }
        }
      }
    }
  }

  private fun setMedia(
    uri: Uri?, mediaType: AttachmentManager.MediaType, filePath: String? = null
  ) {
    var filePath = filePath
    if (mediaType != AttachmentManager.MediaType.VIDEO) {
      val oldFilePath = FileUtils.getPath(this, uri)
      if (oldFilePath == null) {
        showToastShort(getString(R.string.invalid_file_format))
        return
      }
      filePath = MediaUtil.moveToSentFolder(File(oldFilePath), mediaType)
    }
    Log.d("Chat", "path: $filePath")

    when (mediaType) {
      AttachmentManager.MediaType.IMAGE -> {

        if (MediaUtil.isValidImageExt(filePath)) {
          val messageRecord = MessageRecord(
            id = AppConstants.EXTRA_MSG_ID,
            timestamp = System.currentTimeMillis(),
            type = threadType,
            threadId = threadID,
            status = MessageStatus.SENDING.status,
            msgType = MessageType.IMAGE.type,
            senderId = ERTCApplication.getSession(this).getUserId(),
            mediaPath = filePath,
            mediaThumbnail = filePath,
            localMediaPath = filePath,
            chatEventType = ChatEventType.OUTGOING
          )
          val message = Message(
            media = Media(filePath!!, IMAGE),
            chatType = chatType
          )
          this.updateMessageList(messageRecord, message)
        } else if (MediaUtil.isValidGifExt(filePath)) {
          val messageRecord = MessageRecord(
            id = AppConstants.EXTRA_MSG_ID,
            timestamp = System.currentTimeMillis(),
            type = threadType,
            threadId = threadID,
            status = MessageStatus.SENDING.status,
            msgType = MessageType.GIF.type,
            senderId = ERTCApplication.getSession(this).getUserId(),
            mediaPath = filePath,
            mediaThumbnail = filePath,
            localMediaPath = filePath,
            chatEventType = ChatEventType.OUTGOING
          )
          val message = Message(
            media = Media(filePath!!, MessageType.GIF),
            chatType = chatType
          )
          this.updateMessageList(messageRecord, message)
        } else {
          showToastShort(getString(R.string.invalid_file_format))
        }
      }
      AttachmentManager.MediaType.VIDEO -> {

        if (MediaUtil.isValidVideoExt(filePath)) {
          val messageRecord = MessageRecord(
            id = AppConstants.EXTRA_MSG_ID,
            timestamp = System.currentTimeMillis(),
            type = threadType,
            threadId = threadID,
            status = MessageStatus.SENDING.status,
            msgType = MessageType.VIDEO.type,
            senderId = ERTCApplication.getSession(this).getUserId(),
            mediaPath = filePath,
            mediaThumbnail = filePath,
            localMediaPath = filePath,
            chatEventType = ChatEventType.OUTGOING
          )
          val message = Message(
            media = Media(filePath!!, MessageType.VIDEO),
            chatType = chatType
          )
          this.updateMessageList(messageRecord, message)
        } else {
          showToastShort(getString(R.string.invalid_file_format))
        }
      }
      AttachmentManager.MediaType.AUDIO -> {
        if (MediaUtil.isValidAudioExt(filePath)) {
          val messageRecord = MessageRecord(
            id = AppConstants.EXTRA_MSG_ID,
            timestamp = System.currentTimeMillis(),
            type = threadType,
            threadId = threadID,
            status = MessageStatus.SENDING.status,
            msgType = MessageType.AUDIO.type,
            senderId = ERTCApplication.getSession(this).getUserId(),
            mediaPath = filePath,
            mediaThumbnail = filePath,
            localMediaPath = filePath,
            chatEventType = ChatEventType.OUTGOING
          )
          val message = Message(
            media = Media(filePath!!, MessageType.AUDIO),
            chatType = chatType
          )
          this.updateMessageList(messageRecord, message)
        } else {
          showToastShort(getString(R.string.invalid_file_format))
        }
      }
      AttachmentManager.MediaType.FILE  -> {
        if (MediaUtil.isValidDocExt(filePath)) {
          val messageRecord = MessageRecord(
            id = AppConstants.EXTRA_MSG_ID,
            timestamp = System.currentTimeMillis(),
            type = threadType,
            threadId = threadID,
            status = MessageStatus.SENDING.status,
            msgType = MessageType.FILE.type,
            senderId = ERTCApplication.getSession(this).getUserId(),
            mediaPath = filePath,
            mediaThumbnail = filePath,
            localMediaPath = filePath,
            chatEventType = ChatEventType.OUTGOING
          )
          val message = Message(
            file = com.ripbull.coresdk.chat.model.File(filePath!!, MessageType.FILE),
            chatType = chatType
          )
          this.updateMessageList(messageRecord, message)
        } else {
          showToastShort("Invalid File Format")
        }
      }
    }
  }

  private fun showDialog() {
    val builder = AlertDialog.Builder(this)
    builder.setItems(AppConstants.array) { _, which ->
      try {
        if (which == 0) {
          addAttachment(AttachmentManager.TAKE_PHOTO)
        } else if (which == 1) {
          addAttachment(AttachmentManager.PICK_PHOTO)
        }
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
      }
    }
    val dialog = builder.create()
    dialog.show()
  }

  private fun showVideoDialog() {
    val builder = AlertDialog.Builder(this)
    builder.setItems(AppConstants.arrayVideo) { _, which ->

      try {
        if (which == 0) {
          addAttachment(AttachmentManager.TAKE_VIDEO)
        } else if (which == 1) {
          addAttachment(AttachmentManager.PICK_VIDEO)
        }
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
      }
    }

    val dialog = builder.create()

    dialog.show()
  }

  private fun recordAudio() {
    if (!Permissions.hasAll(this, Manifest.permission.RECORD_AUDIO)) {
      shortToast(getString(R.string.allow_audio))
      Permissions.with(this).request(
        Manifest.permission.RECORD_AUDIO
      ).ifNecessary()
        .withPermanentDenialDialog(this.getString(R.string.attachment_record_audio_denied))
        .onAllGranted {  }
        .execute()

      return
    } else if (!Permissions.hasAll(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
      shortToast(getString(R.string.allow_storage))
      Permissions.with(this)
        .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        .ifNecessary()
        .withPermanentDenialDialog(this.getString(R.string.attachment_photos_videos_or_audio_denied))
        .onAllGranted { }
        .execute()

      return
    }

    rlAudio.visibility = View.VISIBLE
    et_message.visibility = View.GONE

    chronometerTimer.base = SystemClock.elapsedRealtime()
    attachmentManager.startRecordAudio(this)
    chronometerTimer.start()
    iv_send.setImageResource(R.drawable.ic_chat_send)
    iv_send.setBackgroundResource(R.drawable.chat_send_bg_green)

    tvCancelAudio.setOnClickListener {
      chronometerTimer.stop()
      attachmentManager.deleteRecordedAudio()
      rlAudio.visibility = View.GONE
      et_message.visibility = View.VISIBLE
      iv_send.setImageResource(R.drawable.ic_chat_audio)
      iv_send.setBackgroundResource(R.drawable.chat_send_bg)
    }
  }

  private fun sendRecordedAudio() {
    chronometerTimer.stop()
    rlAudio.visibility = View.GONE
    et_message.visibility = View.VISIBLE
    iv_send.setImageResource(R.drawable.ic_chat_audio)
    iv_send.setBackgroundResource(R.drawable.chat_send_bg)

    val file = attachmentManager.getRecordedAudio()
    if (file != null) {
      setMedia(Uri.fromFile(file), AttachmentManager.MediaType.AUDIO)
    } else {
      showToastShort(getString(R.string.alert_short_audio))
    }
  }

  private fun initActionbar() {
    val toolbar = chatToolBarEditFeature(user.name, user.profileThumb)

    toolbar.setNavigationOnClickListener {
      if (isEdit) {
        isEdit = false
        toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
        updateMenuItemsForEdit(true)
        clEdit.visibility = View.GONE
        et_message.setText("")
      } else {
        finish()
      }
    }

    if (user.appState.equals(AppConstants.USER_INACTIVE)) {
      isUserInactive = true
      blockedUserTextView.visibility = View.VISIBLE
      blockedUserTextView.text = getString(R.string.deactivated_user)
      blockedUserTextView.setBackgroundResource(R.color.colorAccent)
      hideKeyBoard(relChatType)
      relChatType.visibility = View.INVISIBLE
      chatMenu?.let {
        it.findItem(R.id.action_block_user).isVisible = false
        it.findItem(R.id.action_attachment).isVisible = false
        it.findItem(R.id.action_view_profile).isVisible = false
      }
    } else if (user.blockedStatus.equals(AppConstants.USER_BLOCKED)) {
      blockedUserTextView.visibility = View.VISIBLE
      blockedUserTextView.text = getString(R.string.blocked_user_toast)
      hideKeyBoard(relChatType)
      relChatType.visibility = View.INVISIBLE
      chatMenu?.let {
        it.findItem(R.id.action_block_user).title =
          this.getString(R.string.menu_title_unblock_user)
        it.findItem(R.id.action_attachment).isVisible = false
      }
      if (isUserInactive) {
        isUserInactive = false
        blockedUserTextView.setBackgroundResource(R.color.toolbar_background_color)
        chatMenu?.let {
          it.findItem(R.id.action_view_profile).isVisible = true
          it.findItem(R.id.action_block_user).isVisible = true
        }
      }
    } else if (isUserInactive) {
      isUserInactive = false
      blockedUserTextView.visibility = View.GONE
      relChatType.visibility = View.VISIBLE
      chatMenu?.let {
        it.findItem(R.id.action_block_user).isVisible = true
        it.findItem(R.id.action_attachment).isVisible = true
        it.findItem(R.id.action_view_profile).isVisible = true
      }
    } else {
      blockedUserTextView.visibility = View.GONE
      relChatType.visibility = View.VISIBLE
      chatMenu?.let {
        it.findItem(R.id.action_block_user).isVisible = true
        it.findItem(R.id.action_attachment).isVisible = true
        it.findItem(R.id.action_view_profile).isVisible = true
        it.findItem(R.id.action_block_user).title =
          this.getString(R.string.menu_title_block_user)
      }
    }

    if (!isMenuSet) {
      isMenuSet = true
      toolbar.inflateMenu(R.menu.chat_menu)
      chatMenu = toolbar.menu

      if (eRTCSDK.tenant().projectType() == AppConstants.FREE_SAMPLE_APP) {
        toolbar.menu.findItem(R.id.action_starred_messages).isVisible = false
      }

      user.let {
        when {
          it.appState.equals(AppConstants.USER_INACTIVE)     -> {
            toolbar.menu.findItem(R.id.action_block_user).isVisible = false
            toolbar.menu.findItem(R.id.action_attachment).isVisible = false
            toolbar.menu.findItem(R.id.action_view_profile).isVisible = false
          }
          it.blockedStatus.equals(AppConstants.USER_BLOCKED) -> {
            toolbar.menu.findItem(R.id.action_block_user).title =
              this.getString(R.string.menu_title_unblock_user)
            toolbar.menu.findItem(R.id.action_attachment).isVisible = false
            toolbar.menu.findItem(R.id.action_block_user).icon = getDrawable(R.drawable.ic_unblock_menu)
          }
          else                                               -> {
            toolbar.menu.findItem(R.id.action_block_user).title =
              this.getString(R.string.menu_title_block_user)
            toolbar.menu.findItem(R.id.action_attachment).isVisible = true
            toolbar.menu.findItem(R.id.action_block_user).icon = getDrawable(R.drawable.ic_block_menu)
          }
        }
      }

      if (muteSettings == NotificationSettingsType.ALL.mute) {
        toolbar.menu.findItem(R.id.action_mute_notification).icon = getDrawable(R.drawable.ic_mute_notification_menu)
      } else if (muteSettings == NotificationSettingsType.NONE.mute) {
        toolbar.menu.findItem(R.id.action_mute_notification).icon = getDrawable(R.drawable.ic_unmute)
      }

      toolbar.setOnMenuItemClickListener {
        when (it.itemId) {
          R.id.action_attachment        -> {
            handleAttachment()
          }
          R.id.action_view_profile      -> {
            user.id?.let { it1 ->
              startActivityForResult(
                UserDetailsActivity.getUserDetailIntent(
                  applicationContext,
                  it1,
                  threadID
                ), INIT_MESSAGE_LIST)
            }
          }
          R.id.action_block_user        -> {
            val action: String
            if (user.blockedStatus.equals(AppConstants.USER_BLOCKED)) {
              action = this.getString(R.string.unblock_user_action)
            } else {
              action = this.getString(R.string.block_user_action)
            }
            disposable.add(
              eRTCSDK.chat().blockUnblock(action, user.id!!).subscribeOn(
                Schedulers.io()
              ).observeOn(
                AndroidSchedulers.mainThread()
              ).subscribe({
                if (action.equals(this.getString(R.string.block_user_action), true)) {
                  this.showToastShort(this.getString(R.string.block_user_message))
                  blockedUserTextView.visibility = View.VISIBLE
                  hideKeyBoard(relChatType)
                  relChatType.visibility = View.INVISIBLE
                  toolbar.menu.findItem(R.id.action_block_user).title =
                    this.getString(R.string.menu_title_unblock_user)
                  toolbar.menu.findItem(R.id.action_attachment).isVisible = false
                  toolbar.menu.findItem(R.id.action_block_user).icon = getDrawable(R.drawable.ic_unblock_menu)
                } else {
                  this.showToastShort(this.getString(R.string.unblock_user_message))
                  blockedUserTextView.visibility = View.GONE
                  relChatType.visibility = View.VISIBLE
                  toolbar.menu.findItem(R.id.action_block_user).title =
                    this.getString(R.string.menu_title_block_user)
                  toolbar.menu.findItem(R.id.action_attachment).isVisible = true
                  toolbar.menu.findItem(R.id.action_block_user).icon = getDrawable(R.drawable.ic_block_menu)
                }
              }, { setErrorAlert(it) })
            )

          }
          R.id.action_mute_notification -> {
            muteNotifications(ChatType.SINGLE)
          }
          R.id.action_starred_messages  -> {
            startActivityForResult(
              StarredMessagesActivity.newIntent(this, threadID), INIT_MESSAGE_LIST
            )
            mAdapter?.stopMedia()
          }
          R.id.action_clear_chat  -> {
            if (MediaUtil.isOnline(this)) {
              clearChatHistory()
            } else {
              shortToast(getString(R.string.no_internet))
            }
          }
          else                          -> {
          }
        }
        true
      }
    }
  }

  private fun initGroupActionbar() {
    val toolbar = chatToolBarEditFeature(group.name, group.groupThumb, true)
    toolbar.setNavigationOnClickListener {
      if (isEdit) {
        isEdit = false
        toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
        updateMenuItemsForEdit(true)
        clEdit.visibility = View.GONE
        et_message.setText("")
      } else {
        finish()
      }
    }
    if (!isMenuSet) {
      isMenuSet = true
      toolbar.inflateMenu(R.menu.chat_menu)
      chatMenu = toolbar.menu
    }

    toolbar.menu.findItem(R.id.action_block_user).isVisible = false
    toolbar.menu.findItem(R.id.action_view_profile).title =
      getString(R.string.view_group)
    if (group.isNotInGroup) {
      toolbar.menu.findItem(R.id.action_view_profile).isVisible = false
      toolbar.menu.findItem(R.id.action_attachment).isVisible = false
      toolbar.menu.findItem(R.id.action_mute_notification).isVisible = false
      toolbar.menu.findItem(R.id.action_leave_channel).isVisible = false
    } else if (AppConstants.groupStatus.contains(group.groupStatus)) {
      toolbar.menu.findItem(R.id.action_view_profile).isVisible = false
      toolbar.menu.findItem(R.id.action_attachment).isVisible = false
      toolbar.menu.findItem(R.id.action_mute_notification).isVisible = false
      toolbar.menu.findItem(R.id.action_leave_channel).isVisible = false
      toolbar.menu.findItem(R.id.action_starred_messages).isVisible = false
    } else {
      toolbar.menu.findItem(R.id.action_view_profile).isVisible = true
      toolbar.menu.findItem(R.id.action_attachment).isVisible = true
      toolbar.menu.findItem(R.id.action_mute_notification).isVisible = true
      toolbar.menu.findItem(R.id.action_leave_channel).isVisible = true
      toolbar.menu.findItem(R.id.action_starred_messages).isVisible = true
    }

    if (eRTCSDK.tenant().projectType() == AppConstants.FREE_SAMPLE_APP) {
      toolbar.menu.findItem(R.id.action_starred_messages).isVisible = false
    }

    if (muteSettings == NotificationSettingsType.NONE.mute ||
      muteSettings == NotificationSettingsType.MENTIONS.mute
    ) {
      toolbar.menu.findItem(R.id.action_mute_notification).icon = getDrawable(R.drawable.ic_unmute)
    } else if (muteSettings == NotificationSettingsType.ALL.mute) {
      toolbar.menu.findItem(R.id.action_mute_notification).icon = getDrawable(R.drawable.ic_mute_notification_menu)
    }

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_attachment        -> {
          handleAttachment()
        }
        R.id.action_view_profile      -> {
          startActivityForResult(
            GroupDetailsActivity.getGroupViewIntent(
              group.groupId, applicationContext, threadID
            ), AppConstants.GROUP_REQUEST_CODE
          )
        }
        R.id.action_mute_notification -> {
          muteNotifications(ChatType.GROUP)
        }
        R.id.action_starred_messages  -> {
          startActivityForResult(
            StarredMessagesActivity.newIntent(this, threadID), INIT_MESSAGE_LIST
          )
          mAdapter?.stopMedia()
        }
        R.id.action_clear_chat  -> {
          if (MediaUtil.isOnline(this)) {
            clearChatHistory()
          } else {
            shortToast(getString(R.string.no_internet))
          }
        }
        R.id.action_leave_channel  -> {
          var isOnlyAdmin = true
          if (!group.groupUsers.isNullOrEmpty()) {
            for (user in group.groupUsers) {
              if (ERTCApplication.getSession(this).getUserId() != user.id && user.role == AppConstants.ADMIN) {
                isOnlyAdmin = false
              }
            }
          }

          when {
            isOnlyAdmin -> {
              showExitAdminDialog(group.groupId)
            }
            group.groupType == GroupRecord.TYPE_PUBLIC -> {
              leaveChannelDialog(getString(R.string.admin_leave_public_channel), group.groupId)
            }
            else -> {
              leaveChannelDialog(getString(R.string.admin_leave_private_channel), group.groupId)
            }
          }
        }
        else                          -> {
        }
      }
      true
    }
  }

  private fun setSubTitleText(typing: TypingIndicatorRecord) {
    tvSubTitle.visibility = View.VISIBLE
    if (type == AppConstants.TYPE_GROUP) {
      tvSubTitle.text = typing.name + " is " + AppConstants.GROUP_TYPING_STATUS
    } else {
      tvSubTitle.text = AppConstants.TYPING_STATUS
    }
    //Log.e("ChatActivity","Typing Indicator for ThreadID : $threadID")
    Handler().postDelayed({
      tvSubTitle.visibility = View.INVISIBLE
    }, 5000)
  }

  private fun startTyping() {
    isTypingState = true
    setChatState(START_TYPING)
    typingTimerDisposable =
      Observable.just(true).delay(5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
        .subscribe {
          setChatState(STOP_TYPING)
          isTypingState = false
        }
  }

  @SuppressLint("CheckResult")
  fun setChatState(state: TypingState) {
    //Log.e("Typing Indicator", "setChatState " + state)
    disposable.add(
      eRTCSDK.typing().publish(threadID, state)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ }, { it.printStackTrace() })
    )
  }

  /*fun stopTyping(inactive: Boolean) {
    if (typingTimerDisposable != null) {
      typingTimerDisposable!!.dispose()
      typingTimerDisposable = null
    }
    if (inactive) {
      setChatState(STOP_TYPING)
    } else {
      setChatState(STOP_TYPING)
    }
  }*/

  private fun setContact(contactUri: Uri?) {
    contactUri?.let { contactData ->
      val cursor = contentResolver.query(contactData, null, null, null, null)

      cursor?.let { cursor ->
        var contactName = ""
        var phoneRecords: ArrayList<PhoneContactRecord>? = ArrayList()
        var emailRecords: ArrayList<EmailContactRecord>? = ArrayList()

        while (cursor.moveToNext()) {
          val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
          contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))

          phoneRecords = MediaUtil.getPhoneNumbers(cursor, contentResolver, id)
          emailRecords = MediaUtil.getEmails(contentResolver, id)
        }

        if (phoneRecords!!.size > 0 || emailRecords!!.size > 0) {
          val messageRecord = MessageRecord(
            id = AppConstants.EXTRA_MSG_ID,
            timestamp = System.currentTimeMillis(),
            type = threadType,
            threadId = threadID,
            status = MessageStatus.SENDING.status,
            msgType = MessageType.CONTACT.type,
            senderId = ERTCApplication.getSession(this).getUserId(),
            contactName = contactName,
            phoneContactRecord = phoneRecords,
            emailContactRecord = emailRecords,
            chatEventType = ChatEventType.OUTGOING
          )
          val message = Message(
            contact = Contact(contactName, phoneRecords, emailRecords, CONTACT),
            chatType = chatType
          )
          this.updateMessageList(messageRecord, message)
        } else {
          showToastShort(getString(R.string.invalid_contact))
        }

        cursor.close()
      }
    }
  }

  private fun setLocation(
    latLng: LatLng?, address: String?
  ) {
    val locationRecord = LocationRecord(address, latLng?.latitude, latLng?.longitude)
    val messageRecord = MessageRecord(
      id = AppConstants.EXTRA_MSG_ID,
      timestamp = System.currentTimeMillis(),
      type = threadType,
      threadId = threadID,
      status = MessageStatus.SENDING.status,
      msgType = MessageType.LOCATION.type,
      senderId = ERTCApplication.getSession(this).getUserId(),
      locationRecord = locationRecord,
      chatEventType = ChatEventType.OUTGOING
    )
    val message = Message(
      location = Location(address, latLng?.latitude, latLng?.longitude, LOCATION),
      chatType = chatType
    )
    this.updateMessageList(messageRecord, message)
  }

  private fun setGiphyRecord(url: String?) {
    if (url != null) {
      val messageRecord = MessageRecord(
        id = AppConstants.EXTRA_MSG_ID,
        timestamp = System.currentTimeMillis(),
        type = threadType,
        threadId = threadID,
        status = MessageStatus.SENDING.status,
        msgType = MessageType.GIPHY.type,
        senderId = ERTCApplication.getSession(this).getUserId(),
        mediaPath = url,
        mediaThumbnail = url,
        gifPath = url,
        chatEventType = ChatEventType.OUTGOING
      )
      val message = Message(
        giphy = Giphy(url, GIPHY),
        chatType = chatType
      )
      this.updateMessageList(messageRecord, message)
    }
  }

  private fun setImageRecord(url: String?) {
    if (url != null && MediaUtil.isValidImageExt(url)) {
      val messageRecord = MessageRecord(
        id = AppConstants.EXTRA_MSG_ID,
        timestamp = System.currentTimeMillis(),
        type = threadType,
        threadId = threadID,
        status = MessageStatus.SENDING.status,
        msgType = MessageType.IMAGE.type,
        senderId = ERTCApplication.getSession(this).getUserId(),
        mediaPath = url,
        mediaThumbnail = url,
        localMediaPath = url,
        chatEventType = ChatEventType.OUTGOING
      )
      val message = Message(
        media = Media(url, MessageType.IMAGE),
        chatType = chatType
      )
      this.updateMessageList(messageRecord, message)
    } else {
      showToastShort(getString(R.string.invalid_file_format))
    }
  }

  private fun setGifRecord(url: String?) {
    if (url != null) {
      val messageRecord = MessageRecord(
        id = AppConstants.EXTRA_MSG_ID,
        timestamp = System.currentTimeMillis(),
        type = threadType,
        threadId = threadID,
        status = MessageStatus.SENDING.status,
        msgType = MessageType.GIF.type,
        senderId = ERTCApplication.getSession(this).getUserId(),
        mediaPath = url,
        mediaThumbnail = url,
        localMediaPath = url,
        chatEventType = ChatEventType.OUTGOING
      )
      val message = Message(
        media = Media(url, MessageType.GIF),
        chatType = chatType
      )
      this.updateMessageList(messageRecord, message)
    }
  }

  private fun setFavourite(
    isFavorite: Boolean,
    msgFavList: ArrayList<MessageRecord>,
    position: Int
  ) {
    if (msgFavList.size > 0) {
      dismissProgressbar()
      showProgressbar()
      threadID?.let {
        disposable.add(
          eRTCSDK.chat()
            .markAsFavorite(it, msgFavList, isFavorite)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ messageList ->
              dismissProgressbar()
              this.mAdapter?.notifyMessageUpdated(position, messageList[0])
            }, {
              setErrorAlert(it)
            })
        )
      }
    } else {
      showToastLong(getString(R.string.alert_select_message))
    }
  }

  override fun onMessageSelected(messageRecord: MessageRecord) = Unit

  private fun setErrorAlertAndRemoveRecord(throwable: Throwable, messageRecord: MessageRecord) {
    messageList.remove(messageRecord)
    this.mAdapter?.notifyDataSetChanged()
    throwable.printStackTrace()

    if (throwable.cause != null) {
      if (throwable.cause?.message.isNullOrEmpty()) {
        showToastShort(throwable.message)
      } else {
        showToastShort(throwable.cause?.message)
      }

      if (throwable.cause?.message?.contains(getString(R.string.user_deactivated)) == true) {
        logoutApp()
      }
    } else if (throwable.message != null) {
      showToastShort(throwable.message)

      if (throwable.message?.contains(getString(R.string.user_deactivated)) == true) {
        logoutApp()
      }
    }
  }

  private fun setGifFile(contentUri: Uri, description: ClipDescription) {
    if (description.mimeTypeCount > 0) {
      val filename: String
      var richContentFile: File? = null
      val fileExtension = MimeTypeMap.getSingleton()
        .getExtensionFromMimeType(description.getMimeType(0))

      if (description.hasMimeType(MediaUtil.IMAGE_GIF)) {
        filename = Date().time.toString() + "_my_gif." + fileExtension!!
        richContentFile = File(MediaUtil.getGifSentPath(), filename)
      } else if (description.hasMimeType(MediaUtil.IMAGE_PNG) ||
        description.hasMimeType(MediaUtil.IMAGE_JPEG)
      ) {
        filename = Date().time.toString() + "_my_image." + fileExtension!!
        richContentFile = File(MediaUtil.getImagesSentPath(), filename)
      }

      if (!FileUtils.writeToFileFromContentUri(this, richContentFile, contentUri)) {
        Log.d("Chat", "Failed to get the rich content")
      } else {
        // try to touch View of UI thread
        this.runOnUiThread {
          if (description.hasMimeType(MediaUtil.IMAGE_GIF)) {
            showMediaPreview(mediaType = AttachmentManager.MediaType.GIF, url = richContentFile?.absolutePath)
          } else if (description.hasMimeType(MediaUtil.IMAGE_PNG) ||
            description.hasMimeType(MediaUtil.IMAGE_JPEG)
          ) {
            showMediaPreview(mediaType = AttachmentManager.MediaType.STICKER, url = richContentFile?.absolutePath)
          }
        }
      }
    }
  }

  override fun downloadMedia(
    msgId: String,
    serverUrl: String,
    dirPath: String,
    mediaType: String
  ) {
    disposable.add(
      eRTCSDK.chat().downloadMedia(msgId, serverUrl, dirPath, mediaType)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
        }, {
          setErrorAlert(it)
        })
    )
  }

  private fun showBottomSheetDialog(messageRecord: MessageRecord, position: Int) {
    val view = layoutInflater.inflate(R.layout.chat_bottom_dialog, null)
    val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)
    dialog.setContentView(view)

    if (eRTCSDK.tenant().projectType() == AppConstants.FREE_SAMPLE_APP) {
      view.tvFollowThread.visibility = View.GONE
      view.tvAddToFav.visibility = View.GONE
      view.tvReaction.visibility = View.GONE
      view.tvStartThread.visibility = View.GONE
    }

    if (messageRecord.msgType != MessageType.TEXT.type) {
      view.tvCopy.visibility = View.GONE
    }

    if (messageRecord.isFavoriteMessage!!) {
      view.tvAddToFav.text = getString(R.string.remove_fav)
    }
    val message = Message(
      chatType = chatType,
      parentMsgId = messageRecord.id
    )

    if (messageRecord.isFollowThread) {
      view.tvFollowThread.text = getString(R.string.unfollow_thread)
      view.tvFollowThread.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unfollow_thread, 0, 0, 0)
    }

    view.tvEdit.visibility = if (messageRecord.chatEventType == OUTGOING &&
      messageRecord.msgType == MessageType.TEXT.type) View.VISIBLE else View.GONE

    view.tvEdit.setOnClickListener {
      editMessagePosition = position
      editMessageRecord = messageRecord
      isEdit = true
      toolbar?.setNavigationIcon(R.drawable.cross)
      updateMenuItemsForEdit(false)
      dialog.dismiss()
      openSoftKeyBoard()
      clEdit.visibility = View.VISIBLE
      var txtMessage = messageRecord.message
      messageRecord.message?.let { message ->
        if (AppConstants.copyPattern.containsMatchIn(message)) {
          txtMessage = AppConstants.pattern.replace(message) { matchResult ->
            matchResult.value.substring(1, matchResult.value.length - 1).replace("_", " ")
          }
        }
      }

      messageRecord.mentionedUsers?.let {
        for(user in userList) {
          txtMessage = user.id?.let { id ->
            txtMessage?.replace("@" + user.name, "@$id")
          }
        }
      }
      tvEditMessage.text = txtMessage
      et_message.setText(txtMessage)
      et_message.setSelection(et_message.text.length)
    }

    view.tvDelete.setOnClickListener {
      val messageList = ArrayList<Message>()
      messageList.add(message)
      ViewUtil.deleteMessageDialog(position,this,this,messageList,messageRecord.threadId, messageRecord.chatEventType == INCOMING)
      dialog.dismiss()
    }

    messageRecord.chatThreadMetadata?.let { ctData ->
      if (!ctData.parentMsgId.isNullOrEmpty()) {
        view.tvStartThread.visibility = View.GONE
      }
    }

    if (messageRecord.chatEventType == INCOMING && messageRecord.msgType == MessageType.TEXT.type) {
      view.tvReportMessage.visibility = View.GONE
    }

    chatMenu?.let {
      if (!it.findItem(R.id.action_attachment).isVisible) {
        view.tvStartThread.visibility = View.GONE
        view.tvReaction.visibility = View.GONE
        view.tvEdit.visibility = View.GONE
        view.tvDelete.visibility = View.GONE
        view.tvFollowThread.visibility = View.GONE
        view.tvReportMessage.visibility = View.GONE
      }
    }

    view.tvCopy.setOnClickListener {
      messageRecord.message?.let {
        disposable.add(
          eRTCSDK.chat()
            .copyMessage(this, it)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ copiedMessage ->
              dismissProgressbar()
              shortToast(getString(R.string.text_copied))
            }, {
              setErrorAlert(it)
            })
        )
      }
      dialog.dismiss()
    }

    view.tvStartThread.setOnClickListener {
      if (messageRecord.status == MessageStatus.SENDING.status || messageRecord.status == MessageStatus.FAILED.status) {
        shortToast(getString(R.string.start_a_thread_error_message))
        dialog.dismiss()
        return@setOnClickListener
      }
      startActivityForResult(
        if (type == AppConstants.TYPE_SINGLE) {
          messageRecord.senderId?.let { it1 ->
            threadID?.let { it2 ->
              ThreadActivity.getThreadIntent(this, it1, it2, messageRecord.id, strRecipientId!!)
            }
          }
        } else {
          threadID?.let { it1 ->
            ThreadActivity.getGroupThreadIntent(this, group, it1, messageRecord.id)
          }
        }, INIT_MESSAGE_LIST_TO_BOTTOM)
      mAdapter?.stopMedia()
      dialog.dismiss()
    }

    view.tvAddToFav.setOnClickListener {
      val favMessageList = ArrayList<MessageRecord>()
      favMessageList.add(messageRecord)
      setFavourite(!messageRecord.isFavoriteMessage!!, favMessageList, position)
      dialog.dismiss()
    }

    val emojiIcon = EmojiActions(this, view, view.tvReaction, view.bottomSheet)
    emojiIcon.setUpEmojiKeyboard()

    view.tvReaction.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(p0: Editable?) {
        sendReaction(
          strReaction = view.tvReaction.text.toString().trim(),
          messageRecord = messageRecord
        )
        dialog.dismiss()
      }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    })

    view.tvForward.setOnClickListener {
      startActivityForResult(
        threadID?.let { it1 ->
          ForwardChatActivity.getForwardChatIntent(this, messageRecord.id, it1, chatType)
        }, INIT_MESSAGE_LIST)
      mAdapter?.stopMedia()
      dialog.dismiss()
    }

    view.tvFollowThread.setOnClickListener {
      followThread(!messageRecord.isFollowThread, messageRecord, position)
      dialog.dismiss()
    }

    view.tvReportMessage.setOnClickListener {
      reportMessage(messageRecord, position)
      dialog.dismiss()
    }

    dialog.show()
  }

  private fun followThread(
    isFollowed: Boolean,
    messageRecord: MessageRecord,
    position: Int
  ) {
    threadID?.let {
      disposable.add(
        eRTCSDK.chat()
          .followThread(it, messageRecord, isFollowed)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({ messageRecord ->
            if (isFollowed) {
              shortToast(getString(R.string.follow_chat))
            } else {
              shortToast(getString(R.string.unfollow_chat))
            }
            this.mAdapter?.notifyMessageUpdated(position, messageRecord)
          }, {
            setErrorAlert(it)
          })
      )
    }
  }

  private fun reportMessage(
    messageRecord: MessageRecord,
    position: Int
  ) {
    val view = layoutInflater.inflate(R.layout.dialog_message_report, null)
    val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
    dialog.setContentView(view)
    dialog.show()

    var reportType = getString(R.string.spam_value)

    view.rgMsgReport.setOnCheckedChangeListener { group, checkedId ->
      when (checkedId) {
        R.id.rbSpam -> {
          reportType = getString(R.string.spam_value)
        }
        R.id.rbInappropriate -> {
          reportType = getString(R.string.inappropriate_value)
        }
        R.id.rbAbuse -> {
          reportType = getString(R.string.abuse_value)
        }
        R.id.rbOther -> {
          reportType = getString(R.string.other_value)
        }
      }
    }

    view.btnSubmit.setOnClickListener {
      val reason = view.etReportReason.text.toString()
      if (reason.isEmpty()) {
        shortToast("please add reason to submit this report")
        return@setOnClickListener
      }

      threadID?.let {
        disposable.add(
          eRTCSDK.chat()
            .reportMessage(it, messageRecord, reportType, reason)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ messageRecord ->
              this.mAdapter?.notifyReportMessage(position, messageRecord)
            }, {
              setErrorAlert(it)
            })
        )
        dialog.dismiss()
      }
    }

    view.ivCancel.setOnClickListener {
      dialog.dismiss()
    }
  }

  private fun markAsRead() {
    this.threadID?.let {
      eRTCSDK.chat().markAsRead(it, "").subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({ }, { it.printStackTrace() })
    }
  }

  override fun onAddToFav(messageRecord: MessageRecord) = Unit

  override fun goToThread(messageRecord: MessageRecord) {
    var parentMsgId = messageRecord.id
    messageRecord.chatThreadMetadata?.let { ctData ->
      if (!ctData.parentMsgId.isNullOrEmpty()) {
        parentMsgId = ctData.parentMsgId!!
      }
    }

    startActivityForResult(
      if (type == AppConstants.TYPE_SINGLE) {
        messageRecord.senderId?.let { it1 ->
          threadID?.let { it2 ->
            ThreadActivity.getThreadIntent(this, it1, it2, parentMsgId, strRecipientId!!)
          }
        }
      } else {
        threadID?.let { it1 ->
          ThreadActivity.getGroupThreadIntent(this, group, it1, parentMsgId)
        }
      }, INIT_MESSAGE_LIST_TO_BOTTOM)
    mAdapter?.stopMedia()
  }

  override fun onMessageLongPress(messageRecord: MessageRecord, position: Int) {
    if (chatType == GROUP && (AppConstants.groupStatus.contains(group.groupStatus))) {
      closeKeyPad()
      return
    } else if (messageRecord.updateType != MessageUpdateType.DELETE && (messageRecord.status == MessageStatus.DELIVERED.status ||
            messageRecord.status == MessageStatus.SENT.status || messageRecord.status == MessageStatus.SEEN.status )){
      closeKeyPad()
      showBottomSheetDialog(messageRecord, position)
    }
  }

  private fun closeKeyPad() {
    if (VERSION.SDK_INT <= VERSION_CODES.N_MR1) {
      val mHandler = Handler()
      mHandler.post {
        val inputMethodManager: InputMethodManager =
          getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInputFromWindow(
          et_message.applicationWindowToken, InputMethodManager.HIDE_IMPLICIT_ONLY, 0
        )
        et_message.clearFocus()
      }
    }
  }

  private fun muteNotifications(chatType: ChatType) {
    threadID?.let {
      startActivity(NotificationsSettingActivity.getIntent(this, it, chatType.type))
    }
  }

  private fun setMuteNotificationSettings(
    muteSettings: String = NotificationSettingsType.NONE.mute
  ) {
    this.muteSettings = muteSettings
    chatMenu?.let {
      if (muteSettings == NotificationSettingsType.NONE.mute ||
        muteSettings == NotificationSettingsType.MENTIONS.mute
      ) {
        toolbar.menu.findItem(R.id.action_mute_notification).icon =
          getDrawable(R.drawable.ic_unmute)
      } else if (muteSettings == NotificationSettingsType.ALL.mute) {
        toolbar.menu.findItem(R.id.action_mute_notification).icon =
          getDrawable(R.drawable.ic_mute_notification_menu)
      }
    }
  }

  override fun onMentionUserClicked(appUserId: String) {
    showUserMentionDialog(appUserId)
  }

  override fun onSelectReaction(
    chatReactionRecord: ChatReactionRecord,
    messageRecord: MessageRecord
  ) {
    if (tvFreezeChannel.visibility == View.GONE && blockedUserTextView.visibility == View.GONE) {
      sendReaction(messageRecord = messageRecord, emojiUniCode = chatReactionRecord.emojiCode)
    }
  }

  override fun onReactionLongClickListener(
    reactionUnicodes: List<String>,
    msgId: String,
    threadId: String,
    chatType: String
  ) {
    disposable.add(
      eRTCSDK.user().getReactionedUsers(reactionUnicodes, msgId, threadId, ChatType.CHAT_THREAD)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          displayReactionedUsers(it as ArrayList<UserRecord>)
        }, {
          displayReactionedUsers()
          setErrorAlert(it)
        })
    )
  }

  override fun onStarredListChanged(isDataEmpty: Boolean) {

  }

  override fun onChatTryAgain(messageRecord: MessageRecord, position: Int) {
    disposable.add(
      eRTCSDK.chat()
        .sendMessageAgain(threadID!!, messageRecord.id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (it.status == MessageStatus.FAILED.status) {
            tryAgainMessage(it, position)
          }
          position?.let { it1 -> this.mAdapter?.notifyMessageUpdated(it1, it) }
          this.rvChatHistory?.scrollToPosition(this.mAdapter?.itemCount?.minus(1)!!)
        }, {
          setErrorAlertAndRemoveRecord(it, messageRecord)
        })
    )
  }

  private fun displayReactionedUsers(reactionedUserRecord: ArrayList<UserRecord> = ArrayList()) {
    showReactionedBottomSheetDialog(reactionedUserRecord)
  }

  private fun showReactionedBottomSheetDialog(userList: ArrayList<UserRecord>) {
    val view = layoutInflater.inflate(R.layout.dialog_reacted_users, null)
    val dialog = BottomSheetDialog(this, R.style.BottomSheetDialog)
    dialog.setContentView(view)
    val userHashSet = HashSet<UserRecord>()
    for (i in 0.until(userList.size)) {
      userHashSet.add(userList[i])
    }
    val adapter = ReactionedUserAdapter(userHashSet)
    view.rvReactionedUser.layoutManager =
      LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    view.rvReactionedUser.adapter = adapter

    dialog.show()
  }

  private fun setMentionAutoCompleteTextView(mentionList: ArrayList<UserRecord> = ArrayList()) {
    if (chatType == ChatType.GROUP) {
      mentionList.add(
        UserRecord(
          id = "channel",
          name = "Channel"
        )
      )

      mentionList.add(
        UserRecord(
          id = "here",
          name = "Here"
        )
      )
    }

    val adapter = UserMentionAdapter(this, android.R.layout.simple_list_item_1, mentionList)
    et_message.setAdapter(adapter)
    et_message.threshold = 1 //Set number of characters before the dropdown should be shown

    //Create a new Tokenizer which will get text after '@' and terminate on ' '
    et_message.setTokenizer(object : MultiAutoCompleteTextView.Tokenizer {
      override fun terminateToken(text: CharSequence): CharSequence? {
        var i = text.length
        while (i > 0 && text[i - 1] == ' ') {
          i--
        }
        return if (i > 0 && text[i - 1] == ' ') {
          text
        } else {
          if (text is Spanned) {
            val sp = SpannableString("$text ")
            TextUtils.copySpansFrom(
              text as Spanned, 0, text.length,
              Any::class.java, sp, 0
            )
            sp
          } else {
            "$text "
          }
        }
      }

      override fun findTokenStart(text: CharSequence, cursor: Int): Int {
        var i = cursor
        while (i > 0 && text[i - 1] != '@') {
          i--
        }

        //Check if token really started with @, else we don't have a valid token
        return if (i < 1 || text[i - 1] != '@') {
          cursor
        } else i
      }

      override fun findTokenEnd(text: CharSequence, cursor: Int): Int {
        var i = cursor
        val len = text.length
        while (i < len) {
          if (text[i] == ' ') {
            return i
          } else {
            i++
          }
        }
        return len
      }
    })

    et_message.addTextChangedListener(object : TextWatcher {
      override fun onTextChanged(
        s: CharSequence,
        start: Int,
        before: Int,
        count: Int
      ) {
        val layout: Layout = et_message.layout
        val pos: Int = et_message.selectionStart
        val line: Int = layout.getLineForOffset(pos)
        val baseline: Int = layout.getLineBaseline(line)
        val bottom: Int = et_message.height
        et_message.dropDownVerticalOffset = if (line<12) baseline - bottom else bottom-75 // 65 is for 55dp height of editText and 20 dp margin
      }

      override fun beforeTextChanged(
        s: CharSequence,
        start: Int,
        count: Int,
        after: Int
      ) {
      }

      override fun afterTextChanged(s: Editable) {
        if (et_message.text.toString().trim().isNotEmpty()) {
          if (isEdit) {
            iv_send.setImageResource(R.drawable.ic_check_white_24dp)
            iv_send.setBackgroundResource(R.drawable.chat_send_bg_green)
          } else {
            iv_send.setImageResource(R.drawable.ic_chat_send)
            iv_send.setBackgroundResource(R.drawable.chat_send_bg_green)
          }
        } else {
          iv_send.setImageResource(R.drawable.ic_chat_audio)
          iv_send.setBackgroundResource(R.drawable.chat_send_bg)
        }

        //add profanity and domain filter
        val txtMessage = " " + et_message.text.toString().trim() + " "
        domainFilterList?.let {
          val dfList = it.sortedWith(compareBy { it.domain }).reversed().toCollection(ArrayList())
          for (domain in dfList) {
            val domainPattern = Regex("(?i)" + " " + domain.domain + " ")
            if (domainPattern.containsMatchIn(txtMessage)) {
              if (domain.actionType == AppConstants.BLOCK) {
                tvAlertUser.text = getString(R.string.domain_alert)
                tvAlertUser.visibility = View.VISIBLE
                return
              }
            }
          }
        }

        profanityFilterList?.let {
          val pfList = it.sortedWith(compareBy { it.keyword }).reversed().toCollection(ArrayList())
          for (profanity in pfList) {
            val profanityPattern = Regex("(?i)" + " " + profanity.keyword + " ")
            if (profanityPattern.containsMatchIn(txtMessage)) {
              if (profanity.actionType == AppConstants.BLOCK) {
                tvAlertUser.text = getString(R.string.profanity_alert)
                tvAlertUser.visibility = View.VISIBLE
                return
              }
            }
          }
        }

        tvAlertUser.visibility = View.GONE
      }
    })
  }

  private fun showUserMentionDialog(appUserId: String) {
    val builder = AlertDialog.Builder(this)
    builder.setItems(AppConstants.arrayMentionUserAction) { _, which ->
      try {
        when (which) {
          0 -> {
            if (appUserId == ERTCApplication.getSession(this).getUserId()) {
              shortToast(getString(R.string.logged_in_user_alert))
            } else {
              showProgressbar()
              disposable.add(
                eRTCSDK.chat().createThread(appUserId)
                  .subscribeOn(Schedulers.io()).observeOn(
                    AndroidSchedulers.mainThread()
                  ).subscribe({
                    startActivity(getChatIntent(applicationContext, appUserId, it))
                    dismissProgressbar()
                  }, {
                    setErrorAlert(it)
                    dismissProgressbar()
                  })
              )
            }
          }
          1 -> {
            startActivityForResult(
              UserDetailsActivity.getUserDetailIntent(this, appUserId), INIT_MESSAGE_LIST
            )
          }
        }
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
      }
    }
    val dialog = builder.create()
    dialog.show()
  }

  private fun sendReaction(
    strReaction: String = "",
    messageRecord: MessageRecord,
    emojiUniCode: String? = ""
  ) {
    val emojiCode = if (emojiUniCode.isNullOrEmpty()) {
      strReaction
    } else {
      emojiUniCode
    }
    var actionType = ChatReactionType.SET
    var reactionList = ArrayList<ChatReactionRecord>()
    messageRecord.reactions?.let {
      reactionList = messageRecord.reactions as ArrayList<ChatReactionRecord>
    }
    for (reactionData in reactionList) {
      if (emojiCode == reactionData.emojiCode) {
        reactionData.userRecord?.let {
          for ((index, userData) in it.withIndex()) {
            if (ERTCApplication.getSession(this).getUserId() == userData.id) {
              actionType = ChatReactionType.CLEAR
            }
          }
        }
      }
    }

    val messageMetaData: MessageMetaData?
    if (messageRecord.chatThreadMetadata?.parentMsgId != null) {
      messageMetaData = MessageMetaData(
        reaction = Reaction(
          msgId = messageRecord.id,
          parentMsgId = messageRecord.chatThreadMetadata?.parentMsgId,
          sendToChannel = 1,
          emojiCode = emojiCode,
          chatReactionType = actionType
        )
      )
    } else {
      messageMetaData = MessageMetaData(
        reaction = Reaction(
          msgId = messageRecord.id,
          emojiCode = emojiCode,
          chatReactionType = actionType
        )
      )
    }

    disposable.add(
      eRTCSDK.chat()
        .sendReaction(
          threadID!!,
          messageMetaData
        )
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          val chatReactionRecord = ChatReactionRecord(
            threadId = threadID,
            msgUniqueId = messageRecord.id,
            emojiCode = emojiCode,
            chatReactionType = actionType,
            count = it.count,
            userRecord = it.userRecord
          )

          this.mAdapter?.notifyMessageMetaDataUpdated(chatReactionRecord)
        }, {
          setErrorAlert(it)
        })
    )
  }

  private fun getMentionedUser(userId: String): String {
    for (userRecord in userList) {
      if (userRecord.id == userId.substring(1, userId.length)) {
        return getString(R.string.mention_user_regex, userRecord.name!!)
      }
    }
    return userId
  }

  override fun onBackPressed() {
    super.onBackPressed()
    closeKeyPad()
    finish()
  }

  override fun onDelete(
    messageRecords: ArrayList<Message>,
    threadId: String?,
    deleteType: String?,
    position: Int
  ) {
    disposable.add(
      eRTCSDK.chat().deleteMessage(deleteType!!,threadId!!,messageRecords)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          it?.let { it1 -> this.mAdapter?.notifyMessageDeleted(position,it1)
          }
        }, {
          setErrorAlert(it)
        })
    )
  }

  private fun getGifSelectionListener() = object : GiphyDialogFragment.GifSelectionListener {
    override fun onGifSelected(
      media: com.giphy.sdk.core.models.Media,
      searchTerm: String?,
      selectedContentType: GPHContentType
    ) {
      showMediaPreview(mediaType = AttachmentManager.MediaType.GIPHY, url = getString(R.string.giphy_url, media.id))
    }

    override fun onDismissed(selectedContentType: GPHContentType) {

    }

    override fun didSearchTerm(term: String) {

    }
  }

  private fun showMediaPreview(
    uri: Uri? = null,
    mediaType: AttachmentManager.MediaType,
    url: String? = null
  ) {
    //Inflate the dialog with custom view
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_image_preview, null)
    //AlertDialogBuilder
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    //show dialog
    val mAlertDialog = mBuilder.show()
    mAlertDialog.window?.setBackgroundDrawable(null)

    var filePath: String? = null
    if (url.isNullOrEmpty()) {
      filePath = FileUtils.getPath(this, uri)
      if (filePath == null) {
        showToastShort(getString(R.string.invalid_file_format))
        return
      }
    }

    when (mediaType) {
      AttachmentManager.MediaType.IMAGE   -> {
        mAlertDialog.ivPlay.visibility = View.GONE
        glide.load(File(filePath)).into(mAlertDialog.ivShowImage)
      }
      AttachmentManager.MediaType.VIDEO   -> {
        mAlertDialog.ivPlay.visibility = View.VISIBLE
        glide.load(File(filePath)).apply(RequestOptions().centerCrop())
          .into(mAlertDialog.ivShowImage)
      }
      AttachmentManager.MediaType.STICKER -> {
        mAlertDialog.ivPlay.visibility = View.GONE
        glide.load(url).into(mAlertDialog.ivShowImage)
      }
      else                                -> {
        mAlertDialog.ivPlay.visibility = View.GONE
        MediaUtil.previewGIF(this, url, mAlertDialog.ivShowImage, mAlertDialog.progressBarGif)
      }
    }

    mAlertDialog.ivPlay.setOnClickListener {
      MediaUtil.playVideo(this, filePath)
    }

    mAlertDialog.ivSelect.setOnClickListener {
      when (mediaType) {
        AttachmentManager.MediaType.GIPHY   -> {
          setGiphyRecord(url)
        }
        AttachmentManager.MediaType.GIF     -> {
          setGifRecord(url)
        }
        AttachmentManager.MediaType.STICKER -> {
          setImageRecord(url)
        }
        else                                -> {
          setMedia(uri, mediaType)
        }
      }
      mAlertDialog.dismiss()
    }

    mAlertDialog.ivCancel.setOnClickListener {
      mAlertDialog.dismiss()
    }
  }

  private fun updateMenuItemsForEdit(value: Boolean) {
    chatMenu?.let {
      it.findItem(R.id.action_attachment).isVisible = value
      it.findItem(R.id.action_more).isVisible = value
    }
  }

  private fun initChatAdapter(messageList: ArrayList<MessageRecord>) {
    val linearLayoutManager = LinearLayoutManager(this)
    linearLayoutManager.stackFromEnd = java.lang.Boolean.TRUE
    rvChatHistory.layoutManager = linearLayoutManager
    mAdapter = threadType?.let {
      ChatCommonAdapter(
        messageList, null, this,
        AppConstants.TYPE_CHAT, it, this
      )
    }

    rvChatHistory.adapter = mAdapter
    rvChatHistory.itemAnimator = null
  }

  private fun clearChatHistory() {
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Clear Chat History?")
    builder.setMessage("The conversation will only be cleared for you.")

    builder.setPositiveButton(R.string.clear) { dialog, which ->
      showProgressbar()
      threadID?.let { threadId ->
        disposable.add(eRTCSDK.chat()
          .clearChat(threadId)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({ result ->
            dismissProgressbar()
            result.message?.let { msg -> shortToast(msg) }
            initMessageList()
          }, { throwable -> setErrorAlert(throwable) })
        )
      }
    }

    builder.setNegativeButton(R.string.cancel) { dialog, which ->
    }

    builder.setCancelable(true)
    builder.show()
  }

  private fun showExitAdminDialog(groupId: String) {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.admin_exit_alert)
    dialog.tvAlertInfo.text = getString(R.string.admin_exit_info)

    dialog.btnSubmit?.setOnClickListener {
      startActivityForResult(
        SelectAdminActivity.getSelectAdminIntent(this, groupId),
        SelectAdminActivity.REQUEST_CODE_MAKE_ADMIN
      )
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }

  private fun leaveChannelDialog(alertInfo: String, groupId: String) {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.admin_leave_alert)
    dialog.tvAlertInfo.text = alertInfo
    dialog.btnSubmit.text = getString(R.string.btn_leave)
    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      dialog.btnSubmit.setTextColor(getColor(R.color.group_exit_color))
    } else {
      dialog.btnSubmit.setTextColor(resources.getColor(R.color.group_exit_color))
    }

    dialog.btnSubmit?.setOnClickListener {
      exitGroup(groupId)
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }

  private fun exitGroup(groupId: String) {
    showProgressbar()
    disposable.add(
      eRTCSDK.group()
        .exitGroup(groupId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          dismissProgressbar()
          shortToast(getString(R.string.left_group))
        }, { throwable ->
          dismissProgressbar()
          if (throwable.message?.contains("at least one admin present in channel") == true) {
            showExitAdminDialog(groupId)
          } else setErrorAlert(throwable)
        })
    )
  }

  private fun tryAgainMessage(messageRecord: MessageRecord, position: Int?) {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.failed_to_send)
    dialog.tvAlertInfo.text = getString(R.string.server_timeout_info)
    dialog.btnSubmit.text = getString(R.string.try_again)

    dialog.btnSubmit?.setOnClickListener {
      disposable.add(
        eRTCSDK.chat()
          .sendMessageAgain(threadID!!, messageRecord.id)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            if (it.status == MessageStatus.FAILED.status) {
              tryAgainMessage(it, position)
            }
            position?.let { it1 -> this.mAdapter?.notifyMessageUpdated(it1, it) }
            this.rvChatHistory?.scrollToPosition(this.mAdapter?.itemCount?.minus(1)!!)
          }, {
            setErrorAlertAndRemoveRecord(it, messageRecord)
          })
      )
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }

  @SuppressLint("SetTextI18n")
  private fun processVideo(uri: Uri?) {
    val oldFilePath = FileUtils.getPath(this, uri)
    if (oldFilePath == null) {
      showToastShort(getString(R.string.invalid_file_format))
      return
    }

    val file = File(oldFilePath)
    val length: Long = file.length()
    Log.d("Chat", "video file size: ${length / 1000000}")
    if (length > (25000000)) {
      longToast(getString(R.string.video_size_large))
      return
    }

    if (VERSION.SDK_INT <= VERSION_CODES.N) {
      // only for Nougat and older versions
      val filePath = MediaUtil.moveVideoToSentFolder(file)
      setMedia(uri, AttachmentManager.MediaType.VIDEO, filePath)
      return
    }

    showProgressbar(true)
    uri?.let {
      GlobalScope.launch {
        // run in background as it can take a long time if the video is big,
        // this implementation is not the best way to do it,
        // todo(abed): improve threading
        val job = async { CompressUtil.getMediaPath(applicationContext, uri) }
        val path = job.await()
        val desFile = CompressUtil.saveVideoFile(path, applicationContext, application)

        desFile?.let {
          VideoCompressor.start(
            context = applicationContext,
            srcUri = uri,
            destPath = desFile.path,
            listener = object : CompressionListener {
              override fun onProgress(percent: Float) {
                //Update UI
              }

              override fun onStart() {

              }

              override fun onSuccess() {
                val filePath = MediaUtil.moveVideoToSentFolder(desFile)
                dismissProgressbar()
                setMedia(uri, AttachmentManager.MediaType.VIDEO, filePath)
              }

              override fun onFailure(failureMessage: String) {
                val filePath = MediaUtil.moveVideoToSentFolder(desFile)
                dismissProgressbar()
                setMedia(uri, AttachmentManager.MediaType.VIDEO, filePath)
              }

              override fun onCancelled() {
                // make UI changes, cleanup, etc
                dismissProgressbar()
              }
            },
            configureWith = Configuration(
              quality = VideoQuality.HIGH,
              frameRate = 24,
              videoBitrate = 2500000,
              isMinBitrateCheckEnabled = true,
            )
          )
        }
      }
    }
  }
}