package com.ripbull.ertc.components

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ripbull.ertc.R
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.recepients.Recipient

class AvatarImageView : AppCompatImageView {

  private var inverted: Boolean = false
  private var outlinePaint: Paint? = null
  private var listener: View.OnClickListener? = null

  constructor(context: Context) : super(context) {
    initialize(context, null)
  }

  constructor(
    context: Context,
    attrs: AttributeSet
  ) : super(context, attrs) {
    initialize(context, attrs)
  }

  private fun initialize(
    context: Context,
    attrs: AttributeSet?
  ) {
    scaleType = ImageView.ScaleType.CENTER_CROP

    if (attrs != null) {
      val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.AvatarImageView, 0, 0)
      inverted = typedArray.getBoolean(0, false)
      typedArray.recycle()
    }

    outlinePaint = LIGHT_THEME_OUTLINE_PAINT
  }

  override fun dispatchDraw(canvas: Canvas) {
    super.dispatchDraw(canvas)

    val cx = (canvas.width / 2).toFloat()
    val cy = (canvas.height / 2).toFloat()
    val radius = canvas.width / 2 - outlinePaint!!.strokeWidth / 2

    canvas.drawCircle(cx, cy, radius, outlinePaint!!)
  }

  override fun setOnClickListener(listener: View.OnClickListener?) {
    this.listener = listener
    super.setOnClickListener(listener)
  }

  fun setAvatar(requestManager: GlideRequests, recipient: Recipient) {
    requestManager.load(recipient.contactPhoto)
        .fallback(recipient.getFallbackContactPhotoDrawable(context,inverted))
        .error(recipient.getFallbackContactPhotoDrawable(context,inverted))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .circleCrop()
        .into(this)
  }

  fun clear(glideRequests: GlideRequests) {
    glideRequests.clear(this)
  }

  companion object {

    private val TAG = AvatarImageView::class.java.simpleName

    private val LIGHT_THEME_OUTLINE_PAINT = Paint()
    private val DARK_THEME_OUTLINE_PAINT = Paint()

    init {
      LIGHT_THEME_OUTLINE_PAINT.color = Color.argb((255 * 0.2).toInt(), 0, 0, 0)
      LIGHT_THEME_OUTLINE_PAINT.style = Paint.Style.STROKE
      LIGHT_THEME_OUTLINE_PAINT.strokeWidth = 1f
      LIGHT_THEME_OUTLINE_PAINT.isAntiAlias = true

      DARK_THEME_OUTLINE_PAINT.color = Color.argb((255 * 0.2).toInt(), 255, 255, 255)
      DARK_THEME_OUTLINE_PAINT.style = Paint.Style.STROKE
      DARK_THEME_OUTLINE_PAINT.strokeWidth = 1f
      DARK_THEME_OUTLINE_PAINT.isAntiAlias = true
    }
  }

}
