package com.ripbull.ertc.testing

import android.content.Context
import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.giphy.sdk.ui.Giphy
import com.ripbull.coreattachment.emoji.EmojiInitializer
import com.ripbull.coresdk.Configuration
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.AvailabilityStatus
import com.ripbull.coresdk.core.type.ChatEventType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.EventType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.NetworkEvent
import com.ripbull.coresdk.eRTCSDK
/*import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.notification.NotificationUtils.Companion.clearNotifications
import com.ripbull.ertc.notification.NotificationUtils.Companion.parseRegex
import com.ripbull.ertc.notification.NotificationUtils.Companion.showNotificationMessage
import com.ripbull.ertc.util.MediaUtil.uriDecoder*/
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by DK on 15/12/18.
 */
class ERTCTestApplication : MultiDexApplication(), LifecycleObserver {

  private var isAppInBackground: Boolean = true
  private val disposable = CompositeDisposable()

  companion object {
    @Volatile
    private var SESSION: ApplicationSession? = null
    private val TAG = ERTCTestApplication::class.java.simpleName

    fun getSession(context: Context): ApplicationSession = SESSION ?: synchronized(this) {
      SESSION ?: ApplicationSession(context).also { SESSION = it }
    }

  }

  override fun onCreate() {
    super.onCreate()

    /*val session = applicationContext?.let { getSession(it) }
    if (session?.getAccessCode() != null) {
      //Config builder
      // TODO set your api key here
      // SDK initialize
      //eRTCSDK.initializeWithConfig(config)
      val config = Configuration.Builder()
          .context(this)
          .apiKey("fg8j6smeqjcakfcjbxaml5buaxwnos4s")
          .namespace("blesstest.qa.ertc.com").build()

      // SDK initialize
      disposable.add(eRTCSDK.initializeWithConfigAsync(config).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            Timber.d(TAG, "Namespace result : $it")
          }, { it.printStackTrace() }))

      disposable.add(
        eRTCSDK.chat().messageOn()
          .filter(NetworkEvent.filterType(EventType.MESSAGE_ADDED))
          .filter { it.messageRecord().isSilent != true }
          .filter { AvailabilityStatus.DND.status != eRTCSDK.user().userAvailabilityStatus }
          .filter {
            !((it.messageRecord().type == ChatType.SINGLE_CHAT_THREAD.type || it.messageRecord().type == ChatType.GROUP_CHAT_THREAD.type)
                && (it.messageRecord().chatThreadMetadata?.sendToChannel != null && it.messageRecord().chatThreadMetadata?.sendToChannel == 1))
          }
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            Timber.e(TAG, "isAppInBackground: $isAppInBackground")
            if (isAppInBackground &&
              it.messageRecord().senderId != getSession(this).getUserId() &&
              it.messageRecord().chatEventType != ChatEventType.CHAT_META_DATA
            ) {
              handleDataMessage(it.messageRecord())
            }
          }, { it.printStackTrace() })
      )

    }

    if (BuildConfig.DEBUG) {
      //Stetho.initializeWithDefaults(this)
    }

    EmojiInitializer.init(this)
    RxJavaPlugins.setErrorHandler {}

    ProcessLifecycleOwner.get().lifecycle.addObserver(this)

    Giphy.configure(this, BuildConfig.GIPHY_SDK_API_KEY)*/
  }

  override fun attachBaseContext(base: Context?) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }

  private fun isInForeground(): Boolean {
    return ProcessLifecycleOwner.get().lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  fun onAppBackgrounded() {
    //App in background
    isAppInBackground = true
    Log.e(TAG, "************* backgrounded: $isAppInBackground")
    Log.e(TAG, "************* ${isInForeground()}")
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_START)
  fun onAppForegrounded() {
    // App in foreground
    isAppInBackground = false
    Log.e(TAG, "************* foregrounded: $isAppInBackground")
    Log.e(TAG, "************* ${isInForeground()}")
    //clearNotifications(this)
  }

  private fun handleDataMessage(messageRecord: MessageRecord) {
    Log.e(TAG, "handleDataMessage ***** ")

    //Log.d(TAG, "Availability status : "+ eRTCSDK.user().getUserAvailabilityStatus());
    try {
      var body: String = ""
      when (messageRecord.msgType) {
        MessageType.TEXT.type -> {
          body = messageRecord.message!!
        }
        MessageType.IMAGE.type -> {
          body = "&#55357;&#56567; " + MessageType.IMAGE.type
        }
        MessageType.VIDEO.type -> {
          body = "&#55357;&#56569; " + MessageType.VIDEO.type
        }
        MessageType.CONTACT.type -> {
          body = "&#55357;&#56542; " + MessageType.CONTACT.type
        }
        MessageType.LOCATION.type -> {
          body = "&#55357;&#56524; " + MessageType.LOCATION.type
        }
        MessageType.AUDIO.type -> {
          body = "&#55356;&#57252; " + MessageType.AUDIO.type
        }
        MessageType.STICKER.type -> {
          body = MessageType.STICKER.type
        }
        MessageType.FILE.type -> {
          body = MessageType.FILE.type
        }
        MessageType.GIPHY.type -> {
          body = "&#55357;&#56569; " + MessageType.GIPHY.type
        }
        MessageType.GIF.type -> {
          body = "&#55357;&#56569; " + MessageType.GIF.type
        }
        else                      -> {
          body = messageRecord.msgType!!
        }
      }
      if (!TextUtils.isEmpty(messageRecord.senderRecord?.name) && !TextUtils.isEmpty(body)
      ) {
        val threadId = messageRecord.threadId
        var title = messageRecord.senderRecord?.name
        /* var body = uriDecoder(body)
         body = parseRegex(body)
         if (messageRecord.type == ChatType.GROUP.type || messageRecord.type == ChatType.GROUP_CHAT_THREAD.type) {
           title = getString(R.string.notification_title, title, messageRecord.groupRecord?.name)
         }
         title?.let { showNotificationMessage(it, body, threadId!!, this) }*/
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}
