package com.ripbull.ertc.glide

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory

import java.io.InputStream
import okhttp3.OkHttpClient

/**
 * A simple model loader for fetching media over http/https using OkHttp.
 */
class OkHttpUrlLoader private constructor(private val client: OkHttpClient) : ModelLoader<GlideUrl, InputStream> {

  override fun buildLoadData(
    glideUrl: GlideUrl,
    width: Int,
    height: Int,
    options: Options
  ): ModelLoader.LoadData<InputStream>? {
    return ModelLoader.LoadData(glideUrl, OkHttpStreamFetcher(client, glideUrl))
  }

  override fun handles(glideUrl: GlideUrl): Boolean {
    return true
  }

  class Factory private constructor(private val client: OkHttpClient) : ModelLoaderFactory<GlideUrl, InputStream> {

    constructor() : this(getInternalClient())

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<GlideUrl, InputStream> {
      return OkHttpUrlLoader(client)
    }

    override fun teardown() {
      // Do nothing, this instance doesn't own the client.
    }

    companion object {
      @Volatile private var internalClient: OkHttpClient? = null

      private fun getInternalClient(): OkHttpClient {
        if (internalClient == null) {
          synchronized(Factory::class.java) {
            if (internalClient == null) {
              internalClient = OkHttpClient.Builder()
                  //.proxySelector(new GiphyProxySelector())
                  .build()
            }
          }
        }
        return this.internalClient!!
      }
    }
  }
}