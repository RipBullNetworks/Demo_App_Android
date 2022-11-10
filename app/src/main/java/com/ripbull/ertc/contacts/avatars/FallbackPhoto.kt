package com.ripbull.ertc.contacts.avatars

import android.content.Context
import android.graphics.drawable.Drawable

interface FallbackPhoto {

  fun asDrawable(
    context: Context,
    color: Int
  ): Drawable

  fun asDrawable(
    context: Context,
    color: Int,
    inverted: Boolean
  ): Drawable

  fun asCallCard(context: Context): Drawable

}
