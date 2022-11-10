package com.ripbull.ertc.extension

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ripbull.ertc.R

/**
 * Created by DK on 2019-10-20.
 */

fun ImageView.loadImage(
  url: String?,
  @DrawableRes placeholder: Int = R.drawable.ic_default_gif,
  @DrawableRes error: Int = R.drawable.ic_default_gif,
  @DrawableRes default: Int = R.drawable.ic_default_gif,
  circular: Boolean = false,
  roundedCorners: Int = 0,
  asGif: Boolean = false
) {
  with(Glide.with(context)){
    if(asGif) this.asGif()
    if (url != null) {
      if(url.isNotEmpty()) {
        load(url)
      }else{
        load(default)
      }
    }else{
      load(default)
    }.apply {
      placeholder.let { apply(RequestOptions().placeholder(it).error(error).centerCrop()) }
      if (circular) {
        apply(RequestOptions.circleCropTransform())
      } else if (roundedCorners != 0) {
        apply(RequestOptions.bitmapTransform(RoundedCorners(roundedCorners)))
      }
    }
  }.into(this@loadImage)
}

fun isEqual(value:String?) = (value == "1")

fun TextView.setDrawableLeft(drawable: Int) {
  this.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0)
}

fun Context.shortToast(message: CharSequence) =
  Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.longToast(message: CharSequence) =
  Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun MenuItem.setTitleColor(color: Int) {
  val hexColor = Integer.toHexString(color).toUpperCase().substring(2)
  val html = "<font color='#$hexColor'>$title</font>"
  this.title = html.parseAsHtml()
}

@Suppress("DEPRECATION")
fun String.parseAsHtml(): Spanned {
  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
  } else {
    Html.fromHtml(this)
  }
}