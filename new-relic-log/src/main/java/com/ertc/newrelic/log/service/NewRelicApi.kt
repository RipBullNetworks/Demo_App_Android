package com.ertc.newrelic.log.service

import com.ertc.newrelic.log.model.NewRelicRequest
import com.ertc.newrelic.log.model.NewRelicResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface NewRelicApi {

  companion object {
    const val PROV = "log/v1"
  }

  @POST(PROV)
  fun pushEvents(
    @Header("X-License-Key") apiKey: String,
    @Body request: NewRelicRequest
  ): Single<NewRelicResponse>
}