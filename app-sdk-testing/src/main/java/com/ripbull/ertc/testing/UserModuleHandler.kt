package com.ripbull.ertc.testing

import android.net.Uri
import android.widget.Toast
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.data.common.Result
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.testing.attachment.AttachmentManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.File

/**
 * Created by DK on 18/01/21.
 */
interface UserModuleListener{
  fun onMedia(uri: Uri?, mediaType: AttachmentManager.MediaType)
  fun onMessageSuccess(messageRecord: MessageRecord)
}

class UserModuleHandler(private val disposable: CompositeDisposable,
                        private val context : MainActivity,
                        private val userModuleListener: UserModuleListener,
                        private val attachmentManager: AttachmentManager = AttachmentManager(context)) {

  private var cameraImage: File? = null

  fun getChatUsers() {
    disposable.add(
      eRTCSDK.user().chatUsers.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          {
            //Toast.makeText(this, "" + it, Toast.LENGTH_LONG).show()
            this.onUserListSuccess(it)
            val userList = it as ArrayList<UserRecord>
            var selectedUser = userList as ArrayList<UserRecord>
          }, error
        )
    )
  }

  private fun onUserListSuccess(userList: List<UserRecord>) {
    Toast.makeText(context, "success", Toast.LENGTH_LONG).show()

  }

  private fun success(result: Result) {
    Toast.makeText(context, "" + result, Toast.LENGTH_LONG).show()
  }

  private var error = Error<Throwable> { _, _, message ->
    Toast.makeText(context, "error: $message", Toast.LENGTH_LONG).show()
  }

  fun getReactionUsers(msgId : String, threadID : String) {
    val reactionUnicodes: List<String> = ArrayList()

    disposable.add(
      eRTCSDK.user().getReactionedUsers(reactionUnicodes, msgId, threadID, ChatType.CHAT_THREAD)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          //userRecords ->
          onUserListSuccess(it)
        }, { throwable ->
          error
        })
    )
  }


  fun getMentionedUsers() {
    disposable.add(
      eRTCSDK.user().mentionedUsers
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          //userRecords ->
          onUserListSuccess(it)
        }, { _ ->
          error
        })
    )

  }
}