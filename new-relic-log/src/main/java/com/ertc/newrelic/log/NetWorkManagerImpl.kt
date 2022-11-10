package com.ertc.newrelic.log

import com.ertc.newrelic.log.core.ErtcException
import com.ertc.newrelic.log.service.NewRelicApi
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetWorkManagerImpl : NetworkManager,Interceptor {
  private var apiHandler: ApiHandler? = null
  private var newRelicApi: NewRelicApi? = null
  private var host: String? = null

  override fun api(): ApiHandler {
    val newRelicServerUrl = BuildConfig.BASE_URL
    newRelicApi = newRelicApi(newRelicServerUrl)
    apiHandler = ApiHandlerImpl(newRelicApi!!)

   return this.apiHandler!!
  }
  private fun newRelicApi(newRelicServerUrl: String): NewRelicApi {
    return build(newRelicServerUrl).create(NewRelicApi::class.java)
  }

  private fun build(baseUrl: String): Retrofit {
    val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()
    val gsonConverterFactory = GsonConverterFactory.create(gson)
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  // interceptor for token and header
  // interceptor for logging
  private val okHttpClient: OkHttpClient
    private get() {
      val builder = OkHttpClient.Builder()
      builder.connectTimeout(
          CONNECT_TIME_OUT.toLong(),
          TimeUnit.SECONDS
      )
      builder.readTimeout(
          READ_TIME_OUT.toLong(),
          TimeUnit.SECONDS
      )

      // interceptor for token and header
      builder.addInterceptor(this::intercept)
      //if (BuildConfig.DEBUG) {
      val logging = HttpLoggingInterceptor()
      logging.level = HttpLoggingInterceptor.Level.BODY
      builder.addInterceptor(logging)
      //}
      // interceptor for logging
      return builder.build()
    }

  companion object {
    private const val CONNECT_TIME_OUT = 90
    private const val READ_TIME_OUT = 90
  }

  override fun intercept(chain: Chain): Response {
    synchronized(this) {
      try {
        var request = chain.request()
        val host = this.host
        if (host != null) {
          val newUrl = request.url()
              .newBuilder()
              .host(host)
              .build()
          request = request.newBuilder()
              .url(newUrl)
              .build()
        }

        val builder = request.newBuilder()
        builder.addHeader("Content-Type", "application/json")
        return chain.proceed(builder.build());
      } catch (ex: Exception) {
        throw when (ex) {
          is java.net.SocketTimeoutException -> {
            //callback.onError(111, com.jio.bapp.network.Status.TIMEOUT, "Socket exception")
            ErtcException(
              ErtcException.Error.SocketTimeout(Constants.HTTP_CODE_CLIENT_TIMEOUT),
                "Server timeout! Please try again!",
                ex
            )
          }
          else -> {
            //callback.onError(333, com.jio.bapp.network.Status.UNEXPECTED, e.message)
            ErtcException(
                ErtcException.Error.UnknownError(Constants.HTTP_CODE_UNEXPECTED),
                ex.message ?: "Unknown error",
                ex
            )
          }
        }
      }
    }

  }

}