package com.ripbull.ertc.testing

import android.net.Uri
import android.widget.Toast
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.testing.attachment.AttachmentManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.File

/**
 * Created by DK on 18/01/21.
 */
interface GroupModuleListener{
  fun onMedia(uri: Uri?, mediaType: AttachmentManager.MediaType)
  fun onMessageSuccess(messageRecord: MessageRecord)
}

class GroupModuleHandler(private val disposable: CompositeDisposable,
                         private val context : MainActivity,
                         private val groupModuleListener: GroupModuleListener,
                         private val attachmentManager: AttachmentManager = AttachmentManager(context)) {

  private var cameraImage: File? = null

  fun createGroup(
    groupName: String,
    groupDesc: String,
    filePath: String,
    groupMembers: ArrayList<UserRecord> = ArrayList()
  ) {

    val groupRecord = GroupRecord(
      groupName,
      groupDesc,
      filePath,
      groupMembers
    )
    disposable.add(
      eRTCSDK.group().createPrivateGroup(groupRecord)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onGroupSuccess, this::onGroupError
        )
    )

  }

  fun getGroupById(groupId: String) {
    disposable.add(
      eRTCSDK.group().getGroupById(groupId).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          onGroupSuccess(it)
        }, {
          onGroupError(it)
        })
    )
  }

  fun getAllGroups() {
    disposable.add(
      eRTCSDK.group().groups
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(
          this::onGroupListSuccess, this::onGroupError
        )
    )
  }

  fun addParticipants(groupId: String, userList : List<String>){
    disposable.add(eRTCSDK.group().addParticipants(groupId,userList)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ groupRecord ->

      },{ throwable ->

      }))

  }

  private fun removeParticipants(groupId: String, userList : List<String>){
    disposable.add(eRTCSDK.group().removeParticipants(groupId, userList)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ groupRecord ->

      },{ throwable ->

      }))

  }

  private fun addAdmin(groupId: String, user : String){

    disposable.add( eRTCSDK.group().addAdmin(groupId,"user")
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({ groupRecord ->

      },{ throwable ->

      }))

  }

  private fun exitGroup(groupId: String) {
    disposable.add(
      eRTCSDK.group().exitGroup(groupId).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ groupRecord ->

        },{ throwable ->

        })
    )
  }

  fun updateGroupDetail(
    groupName: String,
    groupDesc: String,
    filePath: String,
    group : GroupRecord
  ) {
    disposable.add(
      eRTCSDK.group().updateGroupDetail(
        group.groupId,
        groupName,
        groupDesc,
        filePath
      ).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onGroupUpdateSuccess, this::onGroupError
        )
    )
  }


  fun removeGroupPic(groupId: String) {
    disposable.add(
      eRTCSDK.group().removeGroupPic(groupId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
        }, { //throwable ->
          it.printStackTrace()
        })
    )

  }


  private fun onGroupUpdateSuccess(groupRecord: GroupRecord) {
    Toast.makeText(context, "success: group updated", Toast.LENGTH_LONG).show()
  }


  private fun onGroupListSuccess(list: List<GroupRecord>) {
    Toast.makeText(context, "success: group", Toast.LENGTH_SHORT).show()
  }

  private fun onGroupSuccess(groupRecord: GroupRecord) {
    Toast.makeText(context, "success: group", Toast.LENGTH_SHORT).show()
  }

  private fun onGroupError(throwable: Throwable) {
    throwable.printStackTrace()
    throwable.message?.let {
      Toast.makeText(context, "" + it, Toast.LENGTH_LONG).show()
    }
  }


  private fun showToastShort(message: String?) {
    if (message != null) {
      Toast.makeText(context, message, Toast.LENGTH_SHORT)
        .show()
    }
  }

}