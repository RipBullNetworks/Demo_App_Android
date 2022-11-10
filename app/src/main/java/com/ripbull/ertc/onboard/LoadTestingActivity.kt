package com.ripbull.ertc.onboard

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import com.ripbull.coresdk.chat.model.Message
import com.ripbull.coresdk.core.type.AvailabilityStatus
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.TypingState
import com.ripbull.coresdk.core.type.TypingState.START_TYPING
import com.ripbull.coresdk.core.type.TypingState.STOP_TYPING
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.hideKeyBoard
import com.ripbull.ertc.util.showToastShort
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_load_testing.btnStart
import kotlinx.android.synthetic.main.activity_load_testing.clLoadTesting
import kotlinx.android.synthetic.main.activity_load_testing.etCounter
import kotlinx.android.synthetic.main.activity_load_testing.etTimeDelay
import kotlinx.android.synthetic.main.activity_load_testing.spinnerEvent
import kotlinx.android.synthetic.main.activity_load_testing.tvSenderCounter
import java.util.concurrent.TimeUnit

class LoadTestingActivity : BaseActivity() {

  private val tag = "LoadTesting"
  private var userId: String? = null
  private var threadId: String? = null
  private var chatType: ChatType = ChatType.SINGLE
  private val disposable = CompositeDisposable()
  private var eventPosition =  0
  private var counter = 0
  private var delay: Long = 1000
  private var typingTimerDisposable: Disposable? = null
  private var isTypingState = false

  companion object {
    @JvmStatic
    fun getLoadTestingIntent(context: Context, id: String): Intent {
      var intent = Intent(context, LoadTestingActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      return intent
    }
  }

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_load_testing)

    setTitleToolBar("Load Testing")

    showProgressbar()
    if (intent.hasExtra(AppConstants.EXTRA_ID)) {
      userId = intent.getStringExtra(AppConstants.EXTRA_ID)
    }

    if (userId == null) {
      showToastShort(getString(R.string.user_failure_message))
      finish()
    }

    val stringArr: Array<String> = resources.getStringArray(R.array.event);
    val dataAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, stringArr)
    dataAdapter.setDropDownViewResource(R.layout.simple_spinner_drop_down)
    spinnerEvent.adapter = dataAdapter

    spinnerEvent.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
      override fun onNothingSelected(parent: AdapterView<*>?) {
      }

      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        eventPosition = position
      }
    }

    btnStart.setOnClickListener {
      hideKeyBoard(currentFocus)
      btnStart.visibility = View.GONE
      etCounter.visibility = View.GONE
      counter = etCounter.text.toString().toInt()
      delay = etTimeDelay.text.toString().toLong()
      if (counter == 0) return@setOnClickListener

      when (eventPosition) {
        0 -> {
          Snackbar.make(clLoadTesting, "Please select event type", Snackbar.LENGTH_SHORT).show()
          btnStart.visibility = View.VISIBLE
          etCounter.visibility = View.VISIBLE
        }
        1 -> {
          fireChatMessages(counter)
        }
        2 -> {
          fireUserStatus(counter)
        }
        3 -> {
          fireTypingStatus(counter)
        }
      }

      if (threadId == null) {
        btnStart.visibility = View.VISIBLE
        etCounter.visibility = View.VISIBLE
      }
    }

    disposable.add(eRTCSDK.chat().getThreads().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            this::onThreadListSuccess, this::onThreadListError
        )
    )

  }

  private fun onThreadListSuccess(threadList: List<ThreadRecord>) {
    if (threadList.isNullOrEmpty()) {
      Snackbar.make(clLoadTesting, "You don't have any thread please create thread first.", Snackbar.LENGTH_SHORT).show()
      dismissProgressbar()
      return
    }
    threadId = threadList[0].id
    chatType = if (threadList[0].type == ChatType.SINGLE.type) {
      ChatType.SINGLE
    } else {
      ChatType.GROUP
    }

    disposable.add(
        eRTCSDK.chat().messageOn(threadId!!,"", chatType).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe({
          Log.d("Load Testing", "messageOn : ${it.text}")
        }, { setErrorAlert(it) })
    )

    dismissProgressbar()
  }

  private fun onThreadListError(throwable: Throwable) {
    dismissProgressbar()
    setErrorAlert(throwable)
  }

  private fun fireChatMessages(count: Int) {
    threadId?.let { threadId ->
      for (i in 1..count) {
        val message = Message(
            message = "message no. $i",
            chatType = chatType
        )
        sentTextMessage(message, i, threadId)
        tvSenderCounter.text = "Chat no. ==> $i"
      }
    }
  }

  private fun fireUserStatus(count: Int) {
    for (i in 1..count) {
      sentUserStatus(i)
      tvSenderCounter.text = "User Status no. ==> $i"
    }
  }

  private fun fireTypingStatus(count: Int) {
    threadId?.let { threadId ->
      for (i in 1..count) {
        startTyping(threadId, i)
        tvSenderCounter.text = "Typing Status MQTT ==> $i"
      }
    }

  }

  private fun sentTextMessage(message: Message, count: Int, threadId: String) {
    disposable.add(eRTCSDK.chat()
        .sendMessage(threadId, message)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .delay(delay, TimeUnit.MILLISECONDS)
        .subscribe({
          Log.d(tag, "Chat API res No. ==> $count")
        }, {
          setErrorAlert(it)
        })
    )

    if (count == counter) {
      btnStart.visibility = View.VISIBLE
      etCounter.visibility = View.VISIBLE
    }
  }

  private fun sentUserStatus(count: Int) {
    try {
      val status = when(count%4){
        0 -> AvailabilityStatus.AUTO
        1 -> AvailabilityStatus.AWAY
        2 -> AvailabilityStatus.INVISIBLE
        3 -> AvailabilityStatus.DND
        else -> AvailabilityStatus.AUTO
      }
      disposable.add(eRTCSDK.user().setUserAvailability(status)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .delay(delay, TimeUnit.MILLISECONDS)
          .subscribe({
            Log.d(tag, "User Status API res no. ==> $count")
          }, {
            setErrorAlert(it as Throwable)
          }))
    } catch (e: IllegalArgumentException) {
      e.printStackTrace()
    } finally {
      if (count == counter) {
        btnStart.visibility = View.VISIBLE
        etCounter.visibility = View.VISIBLE
      }
    }
  }

  private fun startTyping(threadId: String, count: Int) {
    isTypingState = true
    setChatState(START_TYPING, threadId, count)
    typingTimerDisposable =
      Observable.just(true).delay(5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())
          .subscribe {
            setChatState(STOP_TYPING, threadId, count)
            isTypingState = false
          }
  }

  @SuppressLint("CheckResult")
  fun setChatState(state: TypingState, threadId: String, count: Int) {
    disposable.add(
        eRTCSDK.typing().publish(threadId, state)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              Log.d(tag, "Typing $state ==> $count")
            }, { it.printStackTrace() })
    )

    if (count == counter) {
      btnStart.visibility = View.VISIBLE
      etCounter.visibility = View.VISIBLE
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
    typingTimerDisposable?.dispose()
  }
}