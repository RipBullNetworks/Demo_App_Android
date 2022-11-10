package com.ertc.newrelic.log

import com.ertc.newrelic.log.model.NewRelicRequest
import com.ertc.newrelic.log.model.NewRelicResponse
import com.ertc.newrelic.log.service.NewRelicApi
import io.reactivex.Single

internal class ApiHandlerImpl ( private  val newRelicApi: NewRelicApi) : ApiHandler{
  override fun pushNewRelicEvents(request: NewRelicRequest): Single<NewRelicResponse> {
    return newRelicApi.pushEvents(BuildConfig.LICENSE_KEY,request)
  }
}