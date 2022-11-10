package com.ertc.newrelic.log

class Constants {
  companion object{

    const val HTTP_CODE_CLIENT_TIMEOUT = 111
    const val HTTP_CODE_UNEXPECTED = 333
    var ANDROID = "ANDROID"
    var ANDROID_OS = ":android"
    var ANDROID_QA = "AndroidQADevice"
    var CLINET_MSG_SENT = "clientMsgSent"
    var CLINET_MSG_E2E_SENT = "clientMsgE2ESent"
    var CLINET_REACTION_SENT = "clientReactionSent"
  }
}