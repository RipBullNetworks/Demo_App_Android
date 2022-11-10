package com.ripbull.ertc.testing

import android.annotation.SuppressLint
import android.widget.Toast
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.RestoreType
import com.ripbull.coresdk.core.type.TypingState
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.coresdk.utils.Error
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by DK on 16/01/21.
 */

interface MqttModuleListener{
}
class MqttModuleHandler(
  private val disposable: CompositeDisposable,
  private val context : MainActivity,
  private val mqttModuleListener: MqttModuleListener) {


  fun typingIndicatorOn(threadID: String){
    disposable.add(
      eRTCSDK.typing().publish(threadID, TypingState.START_TYPING)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ }, { it.printStackTrace() })
    )
  }

  fun typingIndicatorOff(threadID: String){
    disposable.add(
      eRTCSDK.typing().publish(threadID, TypingState.STOP_TYPING)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ }, { it.printStackTrace() })
    )
  }

  @SuppressLint("TimberArgCount")
  fun typingIndicatorSubscribe(threadID: String){
    disposable.add(
      eRTCSDK.typing().subscribe(threadID).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        Timber.d("mqtt", "Typing Indicator : ${it.typingStatus}")
      }, { it.printStackTrace() })
    )
  }

  fun markAsRead(threadID : String,messageRecord: MessageRecord) {
    threadID.let { it ->
      eRTCSDK.chat().markAsRead(it, messageRecord.id).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        Toast.makeText(context, "" + it, Toast.LENGTH_LONG).show()
        //this.messageSuccess(it)
      }, { it ->
        it.printStackTrace()
      })
    }
  }
  
  fun messageReadStatus(threadID : String,messageRecord: MessageRecord) {
    var chatType: ChatType = ChatType.SINGLE
    disposable.add(
      eRTCSDK.chat().msgReadStatus(threadID, messageRecord.id, chatType)
        .subscribeOn(Schedulers.io())
        .observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe({
          //networkEvent ->
          Toast.makeText(context, "success", Toast.LENGTH_LONG).show()
        }, { //throwable ->
          it.printStackTrace()
        })
    )
  }


  fun downloadMediaOn( threadID : String, parentMessageId: String) {
    val chatType: ChatType = ChatType.SINGLE
    disposable.add(
      eRTCSDK.chat().downloadOn(threadID!!, parentMessageId, chatType)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          Toast.makeText(context, "downloadSuccess", Toast.LENGTH_LONG).show()
        }, {
          it.printStackTrace()
        })
    )
  }

}