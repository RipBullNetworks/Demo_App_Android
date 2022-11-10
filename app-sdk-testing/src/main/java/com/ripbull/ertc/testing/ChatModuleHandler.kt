package com.ripbull.ertc.testing

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.chat.model.Media
import com.ripbull.coresdk.chat.model.Message
import com.ripbull.coresdk.chat.model.MessageMetaData
import com.ripbull.coresdk.chat.model.Reaction
import com.ripbull.coresdk.core.type.ChatReactionType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.testing.attachment.AttachmentManager
import com.ripbull.ertc.testing.util.FileUtils
import com.ripbull.ertc.testing.util.MediaUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.io.File

/**
 * Created by DK on 18/01/21.
 */
interface ChatModuleListener{
  fun onMedia(uri: Uri?, mediaType: AttachmentManager.MediaType)
  fun onMessageSuccess(messageRecord: MessageRecord)
  fun onMessageList(messageList: List<MessageRecord>)
}

class ChatModuleHandler(val disposable: CompositeDisposable,
                        val context : MainActivity,
                        val chatModuleListener: ChatModuleListener,
                        val attachmentManager: AttachmentManager = AttachmentManager(context)) {

  var cameraImage: File? = null

  fun sendMessage(threadId : String, message : Message){
    disposable.add(
      eRTCSDK.chat()
        .sendMessage(threadId, message)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          //messageRecord ->
          this.messageSuccess(it)
        }, {
          it.printStackTrace()
        })
    )
  }
  fun fetchMessageList(threadID : String,) {
    disposable.add(
      eRTCSDK.chat().getMessages(threadID).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe(
        this::onMessageListSuccess, this::onMessageListError
      )
    )
  }

  fun editMessage(threadID : String, textMessage: String) {
    val message = Message(
      msgId = "message ID to edit",
      message = textMessage,
      chatType = ChatType.SINGLE,
    )
    disposable.add(
      eRTCSDK.chat()
        .sendMessage(threadID, message)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          //messageRecord ->
          this.messageSuccess(it)
        }, {
          it.printStackTrace()
          setErrorAlert(it)
        })
    )
  }


  fun sendChatThreadMessage(threadID : String, textMessage: String,messageRecord: MessageRecord){
    val message = Message(
      message = textMessage,
      parentMsgId = messageRecord.id,
      sendToChannel = 0,
      chatType = ChatType.SINGLE_CHAT_THREAD
    )
    sendMessage(threadID, message)
  }
  fun getChatThreadMessages(threadID: String, messageRecord: MessageRecord) {
    disposable.add(
      eRTCSDK.chat().getChatThreadMessages(threadID, messageRecord.id)
        .subscribeOn(Schedulers.io())
        .observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          this::onMessageListSuccess, this::onMessageListError
        )
    )

  }


  private fun onMessageListSuccess(messageList: List<MessageRecord>) {
    Toast.makeText(context, "messages success", Toast.LENGTH_LONG).show()
    chatModuleListener.onMessageList(messageList)
  }


  @SuppressLint("TimberArgCount")
  fun blockUnblockUser() {
    var action = "block"
    disposable.add(
      eRTCSDK.chat().blockUnblock(action, "") //user.id!!
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ // result ->
          Timber.d("block/Unblock user","Result = $it")
        }, { throwable ->
          throwable.printStackTrace()
        })
    )

  }

  fun getallFavoriteMessages() {
    disposable.add(
      eRTCSDK.chat().getAllFavoriteMessages()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onMessageListSuccess, this::onMessageListError
        )
    )

  }

  fun getallfavoritethreadspecificmessages(threadID : String) {
    disposable.add(
      eRTCSDK.chat().getAllFavoriteMessages(threadID!!).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe(
        this::onMessageListSuccess, this::onMessageListError
      )
    )

  }

  fun markAsFavorite(
    isFavorite: Boolean,
    msgFavList: ArrayList<MessageRecord>,
    position: Int,threadID : String
  ) {

    threadID.let {
      disposable.add(
        eRTCSDK.chat()
          .markAsFavorite(it, msgFavList, isFavorite)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            //messageList ->
            this.onMessageListSuccess(it)

          }, {
            // setErrorAlert(it)
            it.printStackTrace()
          })
      )
    }
  }


  fun sendReaction(
    emojiUniCode: String? = null,
    messageRecord: MessageRecord,
    threadID : String
  ) {
    val actionType = ChatReactionType.SET
    var messageMetaData: MessageMetaData? = null
      messageMetaData = MessageMetaData(
        reaction = Reaction(
          msgId = messageRecord.id,
          emojiCode = emojiUniCode.toString(),
          chatReactionType = actionType
        )
      )
    disposable.add(
      eRTCSDK.chat().sendReaction(threadID, messageMetaData)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ //
          // chatReactionRecord ->
          Toast.makeText(context, "" + it, Toast.LENGTH_LONG).show()

        }, {
          it.printStackTrace()
        })
    )
  }


  
  fun messageSuccess(messageRecord: MessageRecord) {
    chatModuleListener.onMessageSuccess(messageRecord)
    Toast.makeText(context, "success : $messageRecord", Toast.LENGTH_LONG).show()
  }


  fun addAttachment(type: Int) {
    when (type) {
      AttachmentManager.PICK_PHOTO    -> AttachmentManager.selectGallery(context)
      AttachmentManager.PICK_AUDIO    -> AttachmentManager.selectAudio(context)
      AttachmentManager.PICK_CONTACT  -> AttachmentManager.selectContactInfo(context)
      AttachmentManager.PICK_LOCATION -> {

      }
      AttachmentManager.TAKE_PHOTO    -> {
        cameraImage = attachmentManager.getPhotoImageFile(context)
        attachmentManager.capturePhoto(
          context, cameraImage!!
        )
      }
      AttachmentManager.PICK_VIDEO    -> AttachmentManager.selectVideo(context)
      AttachmentManager.TAKE_VIDEO    -> attachmentManager.captureVideo(context)
      AttachmentManager.PICK_FILE     -> AttachmentManager.selectDocument(context)
    }
  }

  fun onActivityResult(reqCode: Int, resultCode: Int, data: Intent?){
    when (reqCode) {
      AttachmentManager.PICK_PHOTO    -> {
        chatModuleListener.onMedia(data!!.data, AttachmentManager.MediaType.IMAGE)
      }
      AttachmentManager.PICK_FILE     ->  chatModuleListener.onMedia(data!!.data, AttachmentManager.MediaType.FILE)
      AttachmentManager.PICK_AUDIO    ->  chatModuleListener.onMedia(data!!.data, AttachmentManager.MediaType.AUDIO)
      AttachmentManager.PICK_CONTACT  -> {
        chatModuleListener.onMedia(data!!.data,AttachmentManager.MediaType.FILE)
      }
      AttachmentManager.TAKE_PHOTO    -> {
        if ((data == null || data.data == null) && resultCode != Activity.RESULT_OK) {
          return
        } else if (cameraImage != null) {
          chatModuleListener.onMedia(Uri.fromFile(cameraImage), AttachmentManager.MediaType.IMAGE)
        } else {
          showToastShort(context.getString(R.string.failure_message))
        }
      }
      AttachmentManager.PICK_LOCATION -> {
        //showToastLong(data!!.getStringExtra("address"))

      }
      AttachmentManager.PICK_GIF      -> {
        if (resultCode == Activity.RESULT_OK) {

        }
      }
      AttachmentManager.PICK_VIDEO    -> {
        data?.data?.let { it -> chatModuleListener.onMedia(it, AttachmentManager.MediaType.VIDEO) }
      }
      AttachmentManager.TAKE_VIDEO    -> {
        data?.data?.let { it -> chatModuleListener.onMedia(it, AttachmentManager.MediaType.VIDEO) }
      }
    }
  }

  private fun showToastShort(message: String?) {
    if (message != null) {
      Toast.makeText(context, message, Toast.LENGTH_SHORT)
        .show()
    }
  }


  fun setMedia(
    threadID : String, uri: Uri?, mediaType: AttachmentManager.MediaType
  ) {
    val oldFilePath = FileUtils.getPath(context, uri)
    if (oldFilePath == null) {
      showToastShort(context.getString(R.string.invalid_file_format))
      return
    }
    val filePath = MediaUtil.moveToSentFolder(File(oldFilePath), mediaType)
    Log.d("Chat", "path: $filePath")

    when (mediaType) {
      AttachmentManager.MediaType.IMAGE -> {

        when {
          MediaUtil.isValidImageExt(filePath) -> {
            val message = Message(
              media = Media(filePath, MessageType.IMAGE),
              chatType = ChatType.SINGLE
            )
            sendMessage(threadID, message)
          }
          MediaUtil.isValidGifExt(filePath)   -> {

            val message = Message(
              media = Media(filePath, MessageType.GIF),
              chatType = ChatType.SINGLE
            )
            sendMessage(threadID, message)
          }
          else                                -> {
            showToastShort(context.getString(R.string.invalid_file_format))
          }
        }
      }
      AttachmentManager.MediaType.VIDEO -> {

        if (MediaUtil.isValidVideoExt(filePath)) {

          val message = Message(
            media = Media(filePath, MessageType.VIDEO),
            chatType = ChatType.SINGLE
          )
          sendMessage(threadID, message)
        } else {
          showToastShort(context.getString(R.string.invalid_file_format))
        }
      }
      AttachmentManager.MediaType.AUDIO -> {
        if (MediaUtil.isValidAudioExt(filePath)) {

          val message = Message(
            media = Media(filePath, MessageType.AUDIO),
            chatType = ChatType.SINGLE
          )
          sendMessage(threadID, message)
        } else {
          showToastShort(context.getString(R.string.invalid_file_format))
        }
      }
      AttachmentManager.MediaType.FILE  -> {
        if (MediaUtil.isValidDocExt(filePath)) {
          val message = Message(
            file = com.ripbull.coresdk.chat.model.File(filePath, MessageType.FILE),
            chatType = ChatType.SINGLE
          )
          threadID?.let { sendMessage(it, message) }
        } else {
          showToastShort("Invalid File Format")
        }
      }
    }
  }

  private fun onMessageListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  
  private fun setErrorAlert(throwable: Throwable) {
    throwable.printStackTrace()
    throwable.message?.let {
      Toast.makeText(context, "" + it, Toast.LENGTH_LONG).show()
      //showToastShort(it)
    }
  }

  fun FragmentActivity.showToastShort(message: String?) {
    if (message != null) {
      Toast.makeText(context, message, Toast.LENGTH_SHORT)
        .show()
    }
  }

}