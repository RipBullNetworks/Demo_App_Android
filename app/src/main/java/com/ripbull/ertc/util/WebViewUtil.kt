package com.ripbull.ertc.util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.ripbull.ertc.hyperlink.LinkPreviewCallback
import com.ripbull.ertc.hyperlink.SourceContent
import com.ripbull.ertc.hyperlink.TextCrawler
import java.util.regex.*

/*This class is for showing the WebView in chat*/
class WebViewUtil {
  companion object {
    private var textCrawler: TextCrawler? = null

    fun checkHyperLink(message: String): Boolean {
      val urls = ArrayList<String>()
      val urlPattern = "(?:(?:https?|ftp):\\/\\/)?[\\w/\\-?=%.]+\\.[\\w/\\-?=%.]+"
      val pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE)
      val urlMatcher = pattern.matcher(message)
      while (urlMatcher.find()) {
        urls.add(
          message.substring(
            urlMatcher.start(0),
            urlMatcher.end(0)
          )
        )
      }
      return urls.size == 1
    }

    fun showPreview(
      context : Context,
      textOriginalMsg: AppCompatTextView,
      imageView: AppCompatImageView,
      constraintLayout: ConstraintLayout,
      textViewPreview: AppCompatTextView,
      msg: String,
      tvMessage: AppCompatTextView,
      isMessageEdit: Boolean = false
    ) {

      textCrawler = TextCrawler()
      val callback: LinkPreviewCallback =  object : LinkPreviewCallback{
        override fun onPre() {
          if (isMessageEdit) {
            textOriginalMsg.text = "$msg (edited)"
          } else {
            textOriginalMsg.text = msg
          }
        }

        override fun onPos(sourceContent: SourceContent?, isNull: Boolean) {
          if (!isNull && sourceContent!!.finalUrl.isNotEmpty()){
            textViewPreview.visibility = View.VISIBLE
            textOriginalMsg.visibility = View.VISIBLE
            tvMessage.visibility = View.GONE
            constraintLayout.visibility = View.VISIBLE
            if (sourceContent.images.size > 0) {
              if (sourceContent.images.size > 1) {
                textViewPreview.setText(
                  "1 " + "of" + " " + sourceContent.images.size
                )
              }
              imageView.visibility = View.VISIBLE
              if (isContextAvailable(context)){
                Glide.with(context).load(sourceContent.images[0]).into(imageView)
              }
            } else {
              imageView.visibility = View.GONE
            }
            textViewPreview.text = sourceContent.description
          } else {
            constraintLayout.visibility = View.GONE
            tvMessage.visibility = View.VISIBLE
            if (isMessageEdit) {
              tvMessage.text = "$msg (edited)"
            } else {
              tvMessage.text = msg
            }
          }
        }

      }
      val urlPattern = "(?:(?:https?|ftp):\\/\\/)?[\\w/\\-?=%.]+\\.[\\w/\\-?=%.]+"
      val pattern = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE)
      val urlMatcher = pattern.matcher(msg)
      val urlBuilder = StringBuffer()
      while (urlMatcher.find()) {
       val finalurl =  msg.substring(
            urlMatcher.start(0),
            urlMatcher.end(0)
          )

        if (!finalurl.contains("https://") && !finalurl.contains("www.")){
          urlMatcher.appendReplacement(urlBuilder,"https://www.$finalurl")
        }else if (!finalurl.contains("https://")){
          urlMatcher.appendReplacement(urlBuilder,"https://$finalurl")
        }

        urlMatcher.appendTail(urlBuilder)
      }
      Log.d("IMAGEURLSS",urlBuilder.toString())
      textCrawler!!.makePreview(callback, urlBuilder.toString())
    }

    /**
     * Return true if this [Context] is available.
     * Availability is defined as the following:
     * + [Context] is not null
     * + [Context] is not destroyed (tested with [FragmentActivity.isDestroyed] or [Activity.isDestroyed])
     */
    fun isContextAvailable(context: Context): Boolean {
      if (context == null) {
        return false
      } else if (context !is Application) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
          if (context is FragmentActivity) {
            return !context.isDestroyed
          } else if (context is Activity) {
            return !context.isDestroyed
          }
        }
      }
      return true
    }
  }

  private class MyWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(
      view: WebView,
      url: String
    ): Boolean {
      var url = url
      if (url.contains(".pdf") && !url.contains("docs.google.com")) {
        url = "http://docs.google.com/gview?embedded=true&url=$url"
      }
      view.loadUrl(url)
      return true
    }

    override fun onPageFinished(
      view: WebView,
      url: String
    ) {
      super.onPageFinished(view, url)
    }

    override fun onPageStarted(
      view: WebView,
      url: String,
      favicon: Bitmap
    ) {
      super.onPageStarted(view, url, favicon)
    }
  }
}