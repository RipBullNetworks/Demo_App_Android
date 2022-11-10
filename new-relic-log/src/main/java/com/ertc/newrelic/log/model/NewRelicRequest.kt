package com.ertc.newrelic.log.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NewRelicRequest(
  @SerializedName("timestamp") @Expose val timestamp:String,
  @SerializedName("message") @Expose val message:String,
  @SerializedName("service") @Expose val service:String,
  @SerializedName("device") @Expose val device:String
)