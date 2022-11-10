package com.ripbull.ertc.contacts.avatars

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.text.TextUtils
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import com.ripbull.ertc.R
import com.ripbull.ertc.util.TextDrawable
import com.ripbull.ertc.util.ViewUtil
import java.util.regex.Pattern

class GeneratedPhoto(private val name: String, @param:DrawableRes private val fallbackResId: Int) :
    FallbackPhoto {

  override fun asDrawable(
    context: Context,
    color: Int
  ): Drawable {
    return asDrawable(context, color, false)
  }

  override fun asDrawable(
    context: Context,
    color: Int,
    inverted: Boolean
  ): Drawable {
    val targetSize = context.resources.getDimensionPixelSize(R.dimen.contact_photo_target_size)
    val character = getAbbreviation(name)

    if (!TextUtils.isEmpty(character)) {
      val base = TextDrawable.builder()
          .beginConfig()
          .width(targetSize)
          .height(targetSize)
          .useFont(TYPEFACE)
          .fontSize(ViewUtil.dpToPx(context, 24))
          .textColor(if (inverted) color else Color.WHITE)
          .endConfig()
          .buildRound(character, if (inverted) Color.WHITE else color)

      val gradient = context.resources.getDrawable(R.drawable.avatar_gradient_light)
      return LayerDrawable(arrayOf(base, gradient))
    }

    return ResourcePhoto(fallbackResId)
        .asDrawable(context, color, inverted)
  }

  private fun getAbbreviation(name: String): String? {
    val parts = name.split(" ".toRegex())
        .dropLastWhile { it.isEmpty() }
        .toTypedArray()
    val builder = StringBuilder()
    var count = 0

    var i = 0
    while (i < parts.size && count < 2) {
      val cleaned = PATTERN.matcher(parts[i])
          .replaceFirst("")
      if (!TextUtils.isEmpty(cleaned)) {
        builder.appendCodePoint(cleaned.codePointAt(0))
        count++
      }
      i++
    }

    return if (builder.length == 0) {
      null
    } else {
      builder.toString()
    }
  }

  override fun asCallCard(context: Context): Drawable {
    return AppCompatResources.getDrawable(context, R.drawable.ic_person_large)!!

  }

  companion object {

    private val PATTERN = Pattern.compile("[^\\p{L}\\p{Nd}\\p{S}]+")
    private val TYPEFACE = Typeface.create("sans-serif-medium", Typeface.NORMAL)
  }
}
