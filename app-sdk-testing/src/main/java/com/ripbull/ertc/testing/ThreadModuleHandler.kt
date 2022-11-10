package com.ripbull.ertc.testing

import android.widget.Toast
import com.ripbull.coresdk.core.type.RestoreType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.coresdk.utils.Error
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.ArrayCompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by DK on 16/01/21.
 */

interface ThreadModuleListener{
  fun onThread(threadId : String)
}
class ThreadModuleController(
  private val disposable: CompositeDisposable,
  private val context : MainActivity,
  private val threadModuleListener: ThreadModuleListener,) {



  private fun onThreadListSuccess(threadList: List<ThreadRecord>) {
    Toast.makeText(context, "thread success", Toast.LENGTH_LONG).show()

  }

  fun getThreads() { //success
    disposable.add(
      eRTCSDK.chat().getThreads().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onThreadListSuccess, error
        )
    )

  }


  fun createThread() {   // "5ec25d9dfd06b3075ccfc1b5"
    disposable.add(
      eRTCSDK.chat().createThread("1001") //1001 //3209
        .subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe({
          Toast.makeText(context, "thread id: $it", Toast.LENGTH_LONG).show()
          threadModuleListener.onThread(it)
        }, {
          it.printStackTrace()
        })
    )
  }

  fun threadRestore() {
    disposable.add(
      eRTCSDK.chat().restore(RestoreType.THREAD)
        .subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe({
          Toast.makeText(context, "thread restore: $it", Toast.LENGTH_LONG).show()
        }, {
          it.printStackTrace()
        })
    )
  }

  fun chatRestore() {
    disposable.add(
      eRTCSDK.chat().restore(RestoreType.CHAT)
        .subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe({
          Toast.makeText(context, "chat restore: $it", Toast.LENGTH_LONG).show()
        }, {
          it.printStackTrace()
        })
    )
  }

  private var error = Error<Throwable> { _, _, message ->
    Toast.makeText(context, "error: $message", Toast.LENGTH_LONG).show()
  }


}