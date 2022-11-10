package com.ripbull.ertc.glide

import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.data.DataFetcher
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.util.ContentLengthInputStream
import java.io.IOException
import java.io.InputStream
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

/**
 * Fetches an [InputStream] using the okhttp library.
 */
internal class OkHttpStreamFetcher(
  private val client: OkHttpClient,
  private val url: GlideUrl
) : DataFetcher<InputStream> {
  private var stream: InputStream? = null
  private var responseBody: ResponseBody? = null

  override fun loadData(
    priority: Priority,
    callback: DataFetcher.DataCallback<in InputStream>
  ) {
    try {
      val requestBuilder = Request.Builder()
          .url(url.toStringUrl())

      for ((key1, value) in url.headers) {
        requestBuilder.addHeader(key1,value)
      }

      val request = requestBuilder.build()
      val response = client.newCall(request)
          .execute()

      responseBody = response.body

      if (!response.isSuccessful) {
        throw IOException("Request failed with code: " + response.code)
      }

      val contentLength = responseBody!!.contentLength()
      stream = ContentLengthInputStream.obtain(responseBody!!.byteStream(), contentLength)

      callback.onDataReady(stream)
    } catch (e: IOException) {
      callback.onLoadFailed(e)
    }

  }

  override fun cleanup() {
    if (stream != null) {
      try {
        stream!!.close()
      } catch (e: IOException) {
        // Ignored
      }

    }
    if (responseBody != null) {
      responseBody!!.close()
    }
  }

  override fun cancel() {
    // TODO: call cancel on the client when this method is called on a background thread. See #257
  }

  override fun getDataClass(): Class<InputStream> {
    return InputStream::class.java
  }

  override fun getDataSource(): DataSource {
    return DataSource.REMOTE
  }

  companion object {

    private val TAG = OkHttpStreamFetcher::class.java.name
  }
}