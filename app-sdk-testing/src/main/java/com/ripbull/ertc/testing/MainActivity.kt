package com.ripbull.ertc.testing

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.chat.mapper.ChatMetaDataRecord
import com.ripbull.coresdk.chat.mapper.ChatReactionRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.chat.model.Message
import com.ripbull.coresdk.chat.model.MessageMetaData
import com.ripbull.coresdk.core.type.ChatEventType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.EventType
import com.ripbull.coresdk.core.type.MessageStatus
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.NetworkEvent
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.testing.attachment.AttachmentManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_edit_text.view.*
import org.apache.commons.lang.RandomStringUtils
import timber.log.Timber

class MainActivity : AppCompatActivity(), ApiCallAdapter.ApiCallAdapterListener, ChatModuleListener,
  ThreadModuleListener, GroupModuleListener, UserModuleListener, AuthModuleListener, MqttModuleListener {
  private var recyclerView: RecyclerView? = null
  private val disposable = CompositeDisposable()
  private var apiCallAdapter: ApiCallAdapter? = null
  private var apidataList = ArrayList<RequestValues>()
  private var group: GroupRecord? = null
  private var messageList = ArrayList<MessageRecord>()
  private var userList: ArrayList<UserRecord> = ArrayList()

  private val TAG = MainActivity::class.java.simpleName
  private val namespace = "blesstest.qa.ertc.com"
  private var participantsList = mutableListOf(
    "sagar.ertc@gmail.com",
    "ninjacoderrakesh@gmail.com",
    "sagar.patel2790@gmail.com",
  )
  private val staticGroupId = "5ec97f7113a8bf000980cf6a"
  private val getGroupByGroupId = "5ec97f7113a8bf000980cf6a"

  private var threadID: String? = null //"5efe0a703961e800080be950"
  private var messageRecord: MessageRecord? = null

  private var threadModuleController: ThreadModuleController? = null
  private var chatModuleHandler: ChatModuleHandler? = null
  private var groupModuleHandler: GroupModuleHandler? = null
  private var userModuleHandler: UserModuleHandler? = null
  private var authModuleHandler: AuthModuleHandler? = null
  private var mqttModuleHandler: MqttModuleHandler? = null

  private var messageMetaData: MessageMetaData? = null
  private var chatList = ArrayList<ThreadRecord>()
  private var groupList = ArrayList<GroupRecord>()
  private var msgSelectedList = ArrayList<MessageRecord>()
  private var contactList = ArrayList<UserRecord>()
  private val accessCode = "gm100l5o"
  private var selectedUser: ArrayList<UserRecord> = ArrayList()
  private val username = "manidinesh89@gmail.com"
  private val msgId = "5fdc4116c029ee000895766e"   //originalMsgUniqueId
  //val parentMsgId = "5fdb46bf1b4e080009964adf"
  private var parentMessageId: String? = null
  private var userRecord: UserRecord? = null
  private var groupId: String? = null
  private var filePath: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    threadModuleController = ThreadModuleController(disposable = disposable, this, this)
    chatModuleHandler = ChatModuleHandler(disposable = disposable, this, this)
    groupModuleHandler = GroupModuleHandler(disposable = disposable, this, this)
    userModuleHandler = UserModuleHandler(disposable = disposable, this, this)
    authModuleHandler = AuthModuleHandler(disposable = disposable, this, this)
    mqttModuleHandler = MqttModuleHandler(disposable = disposable, this, this)

    recyclerView = findViewById<View>(R.id.rvCallUi) as RecyclerView

    //Tenant Auth Module
    apidataList.add(RequestValues(title = AppConstants.ONBOARD, isHeader = true))
    apidataList.add(RequestValues(AppConstants.NAMESPACE))
    apidataList.add(RequestValues(AppConstants.CONNECT))
    apidataList.add(RequestValues(AppConstants.CHANGE_PASSWORD))
    apidataList.add(RequestValues(AppConstants.FORGOT_PASSWORD))

    //User Module
//    apidataList.add(RequestValues(title = AppConstants.USER, isHeader = true))
//    apidataList.add(RequestValues(AppConstants.GET_CHAT_USERS))
//    apidataList.add(RequestValues(AppConstants.MENTIONED_USERS))

    //Thread Module
    apidataList.add(RequestValues(title = AppConstants.THREAD, isHeader = true))
    apidataList.add(RequestValues(AppConstants.THREAD_HISTORY))
    apidataList.add(RequestValues(AppConstants.CHAT_HISTORY))
    apidataList.add(RequestValues(AppConstants.CREATE_THREAD))
    apidataList.add(RequestValues(AppConstants.GET_THREADS))

    //Chat Module
    apidataList.add(RequestValues(title = AppConstants.CHAT, isHeader = true))
    apidataList.add(RequestValues(AppConstants.SEND_MESSAGE))
    apidataList.add(RequestValues(AppConstants.SEND_IMAGE_MESSAGE))
    apidataList.add(RequestValues(AppConstants.SEND_VIDEO_MESSAGE))
    apidataList.add(RequestValues(AppConstants.SEND_AUDIO_MESSAGE))
    apidataList.add(RequestValues(AppConstants.GET_MESSAGES))
    apidataList.add(RequestValues(AppConstants.SEND_CHAT_THREAD_MESSAGE))
    apidataList.add(RequestValues(AppConstants.GET_CHAT_THREAD_MESSAGES))
    apidataList.add(RequestValues(AppConstants.EDIT_MESSAGE))
    apidataList.add(RequestValues(AppConstants.FORWARD_MESSAGES))
    apidataList.add(RequestValues(AppConstants.ADD_REACTION))
    apidataList.add(RequestValues(AppConstants.BLOCK_USER))
    apidataList.add(RequestValues(AppConstants.UN_BLOCK_USER))
    apidataList.add(RequestValues(AppConstants.DELETE_MESSAGES))
    apidataList.add(RequestValues(AppConstants.MARK_FAVOURITE))
    apidataList.add(RequestValues(AppConstants.GET_ALL_FAV_MESSAGES))
    apidataList.add(RequestValues(AppConstants.GET_ALL_FAV_THREAD_MSG))
    apidataList.add(RequestValues(AppConstants.GLOBAL_SEARCH))
    apidataList.add(RequestValues(AppConstants.LOCAL_SEARCH))


    //Group Module
    // items.add(InputRequest.RequestValues("Group Metadata On"))
    apidataList.add(RequestValues(title = AppConstants.GROUP, isHeader = true))
    apidataList.add(RequestValues(AppConstants.ALL_GROUPS))
    apidataList.add(RequestValues(AppConstants.CREATE_GROUP))
    apidataList.add(RequestValues(AppConstants.GROUP_BY_ID))
    apidataList.add(RequestValues(AppConstants.UPDATE_GROUP_DETAILS))
    apidataList.add(RequestValues(AppConstants.ADD_PARTICIPANTS))
    apidataList.add(RequestValues(AppConstants.REMOVE_PARTICIPANTS))
    apidataList.add(RequestValues(AppConstants.ADD_ADMIN))
    apidataList.add(RequestValues(AppConstants.REMOVE_ADMIN))
    apidataList.add(RequestValues(AppConstants.EXIT_GROUP))

    apidataList.add(RequestValues(title = AppConstants.MQTT_PUBLISH, isHeader = true))
    apidataList.add(RequestValues(AppConstants.MQTT_CONNECT))
    apidataList.add(RequestValues(AppConstants.MARK_AS_READ))
    apidataList.add(RequestValues(AppConstants.MESSAGE_READ_STATUS))
    apidataList.add(RequestValues(AppConstants.TYPING_PUBLISH))

    apidataList.add(RequestValues(title = AppConstants.MQTT_SUBSCRIBE, isHeader = true))
    apidataList.add(RequestValues(AppConstants.TYPING_SUBSCRIBE))
    apidataList.add(RequestValues(AppConstants.THREAD_METADATA_ON))
    apidataList.add(RequestValues(AppConstants.MESSAGE_METADATA_ON))

    loadUI()

    // Subscribe
    subscribeMessageUpdate()
    subscribeGroupUpdate()
    subscribeUserMetaDataOn()
  }

  private fun logt(tag: String? = TAG, value: String? = "log result") {
    Timber.d(tag, value)
  }

  private fun loadUI() {
    recyclerView!!.layoutManager = LinearLayoutManager(this)
    recyclerView!!.setHasFixedSize(true)
    apiCallAdapter = ApiCallAdapter(apidataList, this)
    recyclerView!!.adapter = apiCallAdapter
    recyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    val divider = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
    divider.setDrawable(
      ContextCompat.getDrawable(
        this@MainActivity,
        R.drawable.horizantal_divider
      )!!
    )
    recyclerView!!.addItemDecoration(divider)
  }



  private fun subscribeMessageUpdate() {
    disposable.add(
      eRTCSDK.chat().messageOn()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .filter(NetworkEvent.filterType(EventType.MESSAGE_UPDATED))
        .subscribe({
          //networkEvent ->
          Toast.makeText(this, "message on", Toast.LENGTH_LONG).show()
          // this.notifyMessageStatusChanged(it.messageRecord())
        }, { // throwable ->
          setErrorAlert(it)
        })
    )
  }

  private fun subscribeGroupUpdate() {
    disposable.add(
      eRTCSDK.group().subscribeToGroupUpdate().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          Toast.makeText(this, "" + it, Toast.LENGTH_LONG).show()
          //this::onGroupSuccess
          /*// if(group.groupId.equals(it.groupId)) {}
          userGroupId = group.groupId*/
        }, {
          it.printStackTrace()
          setErrorAlert(it)
        })
    )
  }

  private fun subscribeThreadMetadataOn() {
    disposable.add(
      eRTCSDK.chat().chatMetaDataOn(threadID!!).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        Toast.makeText(this, "" + it, Toast.LENGTH_LONG).show()
        this::successChatMetaDataRecord
        // it.notificationSettings?.let { it1 -> setMuteNotificationSettings(it1) }
      }, {
        it.printStackTrace()
        setErrorAlert(it)
      }
      )
    )
  }

  private fun subscribeMessageMetadataOn() {
    disposable.add(
      eRTCSDK.chat().messageMetaDataOn(threadID!!)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          //this::successChatMetaDataRecord
          Toast.makeText(this, "" + it, Toast.LENGTH_LONG).show()
          // it.chatReactionRecord?.let { it1 -> this.notifyMessageMetaDataUpdated(it1) }
        }, {
          it.printStackTrace()
          setErrorAlert(it)
        })
    )
  }

  private fun subscribeUserMetaDataOn() {
    disposable.add(
      eRTCSDK.user().subscribeToUserMetaData().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          Toast.makeText(this, "user metadata on", Toast.LENGTH_LONG).show()
        }, { //throwable ->
          it.printStackTrace()
          setErrorAlert(it)
        })
    )
  }

  override fun onApiButtonClicked(position: Int, list: RequestValues) {
    logt(value = list.requestName)
    when (list.requestName) {

      // User Auth
      AppConstants.NAMESPACE -> authModuleHandler?.nameSpace(namespace)
      AppConstants.CONNECT -> authModuleHandler?.connect()
      AppConstants.CHANGE_PASSWORD -> changePasswordDialog()
      AppConstants.FORGOT_PASSWORD -> forgotPasswordDialog()

      // Users
      AppConstants.GET_CHAT_USERS -> userModuleHandler?.getChatUsers()
      AppConstants.MENTIONED_USERS -> userModuleHandler?.getMentionedUsers()
      AppConstants.REACTIONED_USERS -> userModuleHandler?.getReactionUsers("", "")
      AppConstants.REMOVE_PROFILE_PIC -> groupModuleHandler?.removeGroupPic(staticGroupId)
      AppConstants.LOGOUT -> authModuleHandler?.logout()

      // Thread
      AppConstants.GET_THREADS -> threadModuleController?.getThreads()
      AppConstants.CREATE_THREAD -> threadModuleController?.createThread()
      AppConstants.THREAD_HISTORY -> threadModuleController?.threadRestore()
      AppConstants.CHAT_HISTORY -> threadModuleController?.chatRestore()

      // Chat

      AppConstants.SEND_MESSAGE -> chatModuleHandler?.sendMessage(
        this.threadID!!,
        Message(
          message = "Hello, Single chat - " + RandomStringUtils.randomNumeric(3),
          chatType = ChatType.SINGLE
        )
      )
      AppConstants.SEND_IMAGE_MESSAGE -> chatModuleHandler?.addAttachment(
        AttachmentManager.PICK_PHOTO
      )
      AppConstants.SEND_AUDIO_MESSAGE -> chatModuleHandler?.addAttachment(
        AttachmentManager.PICK_AUDIO
      )
      AppConstants.SEND_VIDEO_MESSAGE -> chatModuleHandler?.addAttachment(
        AttachmentManager.TAKE_VIDEO
      )
      AppConstants.GET_MESSAGES -> chatModuleHandler?.fetchMessageList(this.threadID!!)
      AppConstants.EDIT_MESSAGE ->  chatModuleHandler?.editMessage(this.threadID!!,"Test message to edit")
      AppConstants.DELETE_MESSAGES -> chatModuleHandler?.fetchMessageList(this.threadID!!)
      AppConstants.FORWARD_MESSAGES -> chatModuleHandler?.fetchMessageList(this.threadID!!)
      AppConstants.ADD_REACTION -> chatModuleHandler?.fetchMessageList(this.threadID!!)
      AppConstants.BLOCK_USER -> chatModuleHandler?.fetchMessageList(this.threadID!!)
      AppConstants.UN_BLOCK_USER -> chatModuleHandler?.fetchMessageList(this.threadID!!)
      AppConstants.MARK_FAVOURITE -> chatModuleHandler?.markAsFavorite(true, messageList, 0, this.threadID!!)
      AppConstants.GET_ALL_FAV_MESSAGES -> chatModuleHandler?.getallFavoriteMessages()
      AppConstants.GET_ALL_FAV_THREAD_MSG -> chatModuleHandler?.getallfavoritethreadspecificmessages(this.threadID!!)

      // Chat thread and search
      AppConstants.SEND_CHAT_THREAD_MESSAGE -> chatModuleHandler?.sendChatThreadMessage(
        this.threadID!!,
        "Hello, chat thread - "+RandomStringUtils.randomNumeric(3),
        this.messageRecord!!
      )
      AppConstants.GET_CHAT_THREAD_MESSAGES -> chatModuleHandler?.getChatThreadMessages(
        this.threadID!!,
        this.messageRecord!!
      )
      AppConstants.GLOBAL_SEARCH -> chatModuleHandler?.getChatThreadMessages(
        this.threadID!!,
        this.messageRecord!!
      )
      AppConstants.LOCAL_SEARCH -> chatModuleHandler?.getChatThreadMessages(
        this.threadID!!,
        this.messageRecord!!
      )

      // Group
      AppConstants.ALL_GROUPS -> groupModuleHandler?.getAllGroups()
      //"Group Metadata On" ->  groupMetaDataOn()
      AppConstants.CREATE_GROUP -> createGroupDialog()
      AppConstants.GROUP_BY_ID -> groupModuleHandler?.getGroupById(
        getGroupByGroupId
      )
      AppConstants.UPDATE_GROUP_DETAILS -> updateGroupDialog()
      AppConstants.ADD_PARTICIPANTS -> groupModuleHandler?.addParticipants(
        getGroupByGroupId,
        participantsList
      )
      AppConstants.REMOVE_PARTICIPANTS -> groupModuleHandler?.addParticipants(
        getGroupByGroupId,
        participantsList
      )
      AppConstants.ADD_ADMIN -> groupModuleHandler?.addParticipants(
        getGroupByGroupId,
        participantsList
      )
      AppConstants.REMOVE_ADMIN -> groupModuleHandler?.addParticipants(
        getGroupByGroupId,
        participantsList
      )
      AppConstants.EXIT_GROUP -> groupModuleHandler?.addParticipants(
        getGroupByGroupId,
        participantsList
      )
      AppConstants.REMOVE_GROUP_PIC -> groupModuleHandler?.addParticipants(
        getGroupByGroupId,
        participantsList
      )

      // MQTT Events
      // MQTT Publish
      AppConstants.MQTT_CONNECT -> eRTCSDK.connect()
      AppConstants.MARK_AS_READ -> mqttModuleHandler?.markAsRead(
        this.threadID!!,
        this.messageRecord!!
      )
      AppConstants.TYPING_PUBLISH -> mqttModuleHandler?.typingIndicatorOn(
        this.threadID!!
      )
      // MQTT Subscribe
      AppConstants.MESSAGE_READ_STATUS -> mqttModuleHandler?.messageReadStatus(
        this.threadID!!,
        this.messageRecord!!
      )
      AppConstants.TYPING_SUBSCRIBE -> mqttModuleHandler?.typingIndicatorSubscribe(
        this.threadID!!
      )

      AppConstants.THREAD_METADATA_ON -> subscribeThreadMetadataOn()
      AppConstants.MESSAGE_METADATA_ON -> subscribeMessageMetadataOn()

    }
  }


  private fun successChatMetaDataRecord(chatMetaDataRecord: ChatMetaDataRecord) {
    Toast.makeText(this, "" + chatMetaDataRecord, Toast.LENGTH_LONG).show()
    //showToastShort(it)
  }

  private fun successChaReactionRecord(chatReactionRecord: ChatReactionRecord) {
    Toast.makeText(this, "" + chatReactionRecord, Toast.LENGTH_LONG).show()
  }

  private fun onMessageListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  private fun setErrorAlert(throwable: Throwable) {
    throwable.printStackTrace()
    throwable.message?.let {
      Toast.makeText(this, "" + it, Toast.LENGTH_LONG).show()
      //showToastShort(it)
    }
  }

  private fun showLoginDialog() {
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_text, null)
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    mDialogView.tvInput1.visibility = View.VISIBLE
    mDialogView.tvInput2.visibility = View.VISIBLE
    mDialogView.tvInput1.hint = "username"
    mDialogView.tvInput2.hint = "password"
    mDialogView.tvInput1.setText("manidinesh89@gmail.com")
    mDialogView.tvInput2.setText("Z6MHwFtM")
    //login"manidinesh89@gmail.com", "Z6MHwFtM")
    val mAlertDialog = mBuilder.show()
    mAlertDialog.setCancelable(true)

    mDialogView.btnProceed.setOnClickListener {
      val username = mDialogView.tvInput1.text.toString().trim()
      val password = mDialogView.tvInput2.text.toString().trim()
      authModuleHandler?.login(username, password)
      mAlertDialog.dismiss()
    }

  }

  private fun changePasswordDialog() {
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_text, null)
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    mDialogView.tvInput1.visibility = View.VISIBLE
    mDialogView.tvInput2.visibility = View.VISIBLE
    mDialogView.tvInput1.hint = "old password"
    mDialogView.tvInput2.hint = "new password"
    val mAlertDialog = mBuilder.show()
    mAlertDialog.setCancelable(true)

    mDialogView.btnProceed.setOnClickListener {
      val oldPassword = mDialogView.tvInput1.text.toString().trim()
      val newPassword = mDialogView.tvInput2.text.toString()
      authModuleHandler?.changePassword(oldPassword, newPassword)
      mAlertDialog.dismiss()
    }

  }

  private fun forgotPasswordDialog() {
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_text, null)
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    mDialogView.tvInput1.visibility = View.VISIBLE
    mDialogView.tvInput1.hint = "username"
    val mAlertDialog = mBuilder.show()
    mAlertDialog.setCancelable(true)
    mDialogView.btnProceed.setOnClickListener {
      val email = mDialogView.tvInput1.text.toString()
      authModuleHandler?.forgotPassword(email)
      mAlertDialog.dismiss()
    }

  }


  private fun createGroupDialog() {
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_text, null)
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    mDialogView.tvInput1.visibility = View.VISIBLE
    mDialogView.tvInput2.visibility = View.VISIBLE
    //mDialogView.tvInput3.visibility = View.VISIBLE
    mDialogView.tvInput1.setHint(R.string.group_name)
    mDialogView.tvInput2.setHint(R.string.group_desc)
    //mDialogView.tvInput3.setHint("Group Memebers")
    val mAlertDialog = mBuilder.show()
    mAlertDialog.setCancelable(true)

    mDialogView.btnProceed.setOnClickListener {
      val groupName = mDialogView.tvInput1.text.toString().trim()
      val groupDescription = mDialogView.tvInput2.text.toString().trim()
      groupModuleHandler?.createGroup(groupName, groupDescription, "", userList)
      mAlertDialog.dismiss()
    }
  }

  private fun updateGroupDialog() {
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_text, null)
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    mDialogView.tvInput1.visibility = View.VISIBLE
    mDialogView.tvInput2.visibility = View.VISIBLE
    mDialogView.tvInput1.setHint(R.string.group_name)
    mDialogView.tvInput2.setHint(R.string.group_desc)
    val mAlertDialog = mBuilder.show()
    mAlertDialog.setCancelable(true)

    mDialogView.btnProceed.setOnClickListener {
      val groupName = mDialogView.tvInput1.text.toString().trim()
      val groupDescription = mDialogView.tvInput2.text.toString().trim()
      groupModuleHandler?.updateGroupDetail(groupName, groupDescription, "", this.group!!)
      mAlertDialog.dismiss()
    }
  }

  @SuppressLint("TimberArgCount")
  private fun sendReactionDialog() {
    val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_text, null)
    val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
    mDialogView.tvInput1.visibility = View.VISIBLE
    mDialogView.tvInput1.hint = "enter reaction"
    val mAlertDialog = mBuilder.show()
    mAlertDialog.setCancelable(true)

    mDialogView.btnProceed.setOnClickListener {
      /* val emojiIcon = EmojiActionsText(this, mDialogView, mDialogView.tvInput1)
       emojiIcon.setUpEmojiKeyboard()*/
      val typedreaction = mDialogView.tvInput1.text.toString().trim()
      Timber.v("reaction", "Reaction = $typedreaction")
      //sendReaction(
      //          strReaction = view.tvReaction.text.toString().trim(),
      //          messageRecord = messageRecord
      //        )
      //messageRecord?.let { it1 -> sendReaction(typedreaction, it1,"") }
      val messageRecord = MessageRecord(
        id = "5ff6f04d7fad910009b12dce",
        timestamp = System.currentTimeMillis(),
        message = typedreaction,
        type = ChatType.SINGLE.type,
        threadId = threadID,
        status = MessageStatus.SENDING.status,
        msgType = MessageType.TEXT.type,
        senderId = ERTCTestApplication.getSession(this).getUserId(),
        chatEventType = ChatEventType.OUTGOING
      )
      chatModuleHandler?.sendReaction(typedreaction, messageRecord,this.threadID!!)
      mAlertDialog.dismiss()
    }

  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    chatModuleHandler?.onActivityResult(requestCode, resultCode, data)
  }

  override fun onMessageSuccess(messageRecord: MessageRecord) {
    this.messageRecord = messageRecord
  }

  override fun onMedia(uri: Uri?, mediaType: AttachmentManager.MediaType) {
    chatModuleHandler?.setMedia(this.threadID!!, uri, mediaType)
  }

  override fun onThread(threadId: String) {
    this.threadID = threadId
  }

  override fun onMessageList(messageList: List<MessageRecord>) {
    this.messageList = messageList as ArrayList<MessageRecord>
  }
}










