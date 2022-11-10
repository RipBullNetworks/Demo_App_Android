package com.ripbull.coreattachment.emoji.dto

import android.graphics.Point



data class TouchPoint(
  val absolute: Point,
  val inView: Point
)