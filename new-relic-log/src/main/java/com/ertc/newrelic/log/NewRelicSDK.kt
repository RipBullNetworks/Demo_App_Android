package com.ertc.newrelic.log

import com.ertc.newrelic.log.model.NewRelicRequest
import io.reactivex.schedulers.Schedulers
import java.util.UUID

class NewRelicSDK {


  companion object {
    const val ENABLE = false
    private var netWorkManagerImpl: NetWorkManagerImpl = NetWorkManagerImpl()
    @JvmStatic
    fun publishNewRelic(eventName: String, deviceId: String , chatUserId: String) {
      val clientID =
        "${chatUserId}:${deviceId}${Constants.ANDROID_OS}"
      val timestamp = System.currentTimeMillis()
          .toString()
      val messageNewRelic =
        "[ANDROID] [MSG_TRACE] [" + UUID.randomUUID() + "]," + eventName + ", {\\\"sendMethod\\\":\\\"http\\\", \\\"clientId\\\":\\\"" + clientID + "\\}\""
      val service = Constants.ANDROID_QA
      val device = Constants.ANDROID
      when {
        ENABLE -> {
          netWorkManagerImpl.api()
            .pushNewRelicEvents(NewRelicRequest(timestamp, messageNewRelic, service, device))
            .subscribeOn(Schedulers.io())
            .subscribe()
        }
      }
    }
  }

}