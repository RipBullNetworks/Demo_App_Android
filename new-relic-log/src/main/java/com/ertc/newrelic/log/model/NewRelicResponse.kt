package com.ertc.newrelic.log.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NewRelicResponse(
  @SerializedName("requestId") @Expose val requestId:String
)