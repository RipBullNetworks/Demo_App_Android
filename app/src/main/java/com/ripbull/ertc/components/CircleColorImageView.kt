package com.ripbull.ertc.components

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.ripbull.ertc.R

class CircleColorImageView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

  init {

    var circleColor = Color.WHITE

    if (attrs != null) {
      val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.CircleColorImageView, 0, 0)
      circleColor = typedArray.getColor(R.styleable.CircleColorImageView_circleColor, Color.WHITE)
      typedArray.recycle()
    }

    val circle = context.resources.getDrawable(R.drawable.circle_tint)
    circle.setColorFilter(circleColor, PorterDuff.Mode.SRC_IN)

    setBackgroundDrawable(circle)
  }
}
