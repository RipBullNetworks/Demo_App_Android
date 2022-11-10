package com.ertc.newrelic.log

import com.ertc.newrelic.log.model.NewRelicRequest
import com.ertc.newrelic.log.model.NewRelicResponse
import io.reactivex.Single

interface ApiHandler{
  fun pushNewRelicEvents(request: NewRelicRequest) : Single<NewRelicResponse>
}