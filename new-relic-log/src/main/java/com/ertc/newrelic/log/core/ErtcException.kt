package com.ertc.newrelic.log.core



/**
 * @author meeth
 */

data class ErtcException @JvmOverloads constructor(
  val error: Error,
  override val message: String = "",
  val exception: Throwable? = null
) :
  Throwable(message, exception) {
  sealed class Error(val code: Int) {
    class Failure : Error(222)
    class UnknownError(code: Int) : Error(code)
    class SocketTimeout(code: Int) : Error(code)
  }


}