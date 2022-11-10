package com.ripbull.ertc.util

import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author meeth
 */
fun View.toggleVisibility(isVisible: Boolean) {
  visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.toggleVisibilityWeak(isVisible: Boolean) {
  visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun ViewGroup.inflate(@LayoutRes resource: Int, attachToRoot: Boolean) : View {
  val layoutInflater = LayoutInflater.from(this.context)
  return layoutInflater.inflate(resource, this, attachToRoot)
}