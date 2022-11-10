package com.ripbull.ertc.attachment

import android.animation.Animator
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.util.Pair
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewTreeObserver
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import com.ripbull.ertc.R
import com.ripbull.ertc.util.ViewUtil

class AttachmentTypeSelector(
  context: Context, private var listener: AttachmentClickedListener?
) : PopupWindow(context) {

  private val imageButton: ImageView
  private val audioButton: ImageView
  private val documentButton: ImageView
  private val contactButton: ImageView
  private val cameraButton: ImageView
  private val locationButton: ImageView
  private val gifButton: ImageView
  private val closeButton: ImageView

  private var currentAnchor: View? = null

  init {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.attachment_type_selector, null, true) as LinearLayout
    this.imageButton = ViewUtil.findById(layout, R.id.gallery_button)
    this.audioButton = ViewUtil.findById(layout, R.id.audio_button)
    this.documentButton = ViewUtil.findById(layout, R.id.document_button)
    this.contactButton = ViewUtil.findById(layout, R.id.contact_button)
    this.cameraButton = ViewUtil.findById(layout, R.id.camera_button)
    this.locationButton = ViewUtil.findById(layout, R.id.location_button)
    this.gifButton = ViewUtil.findById(layout, R.id.giphy_button)
    this.closeButton = ViewUtil.findById(layout, R.id.close_button)

    this.imageButton.setOnClickListener(ClickListener(ADD_GALLERY))
    this.audioButton.setOnClickListener(ClickListener(ADD_SOUND))
    this.documentButton.setOnClickListener(ClickListener(ADD_DOCUMENT))
    this.contactButton.setOnClickListener(ClickListener(ADD_CONTACT_INFO))
    this.cameraButton.setOnClickListener(ClickListener(TAKE_PHOTO))
    this.locationButton.setOnClickListener(ClickListener(ADD_LOCATION))
    this.gifButton.setOnClickListener(ClickListener(ADD_GIF))
    this.closeButton.setOnClickListener(CloseClickListener())

    ViewUtil.findById<View>(layout, R.id.location_linear_layout).visibility = View.INVISIBLE


    contentView = layout
    width = LinearLayout.LayoutParams.MATCH_PARENT
    height = LinearLayout.LayoutParams.WRAP_CONTENT
    setBackgroundDrawable(BitmapDrawable())
    animationStyle = 0
    inputMethodMode = PopupWindow.INPUT_METHOD_NOT_NEEDED
    isFocusable = true
    isTouchable = true
  }

  fun show(
    activity: Activity, anchor: View
  ) {

    this.currentAnchor = anchor

    showAtLocation(anchor, Gravity.BOTTOM, 0, 0)

    contentView.viewTreeObserver.addOnGlobalLayoutListener(object :
      ViewTreeObserver.OnGlobalLayoutListener {
      override fun onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 16) {
          contentView.viewTreeObserver.removeGlobalOnLayoutListener(this)
        } else {
          contentView.viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
        animateWindowInCircular(anchor, contentView)

      }
    })

    animateButtonIn(imageButton, ANIMATION_DURATION / 2)
    animateButtonIn(cameraButton, ANIMATION_DURATION / 2)

    animateButtonIn(audioButton, ANIMATION_DURATION / 3)
    animateButtonIn(locationButton, ANIMATION_DURATION / 3)
    animateButtonIn(documentButton, ANIMATION_DURATION / 4)
    animateButtonIn(gifButton, ANIMATION_DURATION / 4)
    animateButtonIn(contactButton, 0)
    animateButtonIn(closeButton, 0)
  }

  override fun dismiss() {
    animateWindowOutCircular(currentAnchor, contentView)
  }

  fun setListener(
    listener: AttachmentClickedListener?
  ) {
    this.listener = listener
  }

  private fun animateButtonIn(button: View, delay: Int) {
    val animation = AnimationSet(true)
    val scale = ScaleAnimation(
      0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f
    )

    animation.addAnimation(scale)
    animation.interpolator = OvershootInterpolator(1f)
    animation.duration = ANIMATION_DURATION.toLong()
    animation.startOffset = delay.toLong()
    button.startAnimation(animation)
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private fun animateWindowInCircular(
    anchor: View?, contentView: View
  ) {
    val coordinates = getClickOrigin(anchor, contentView)
    val animator = ViewAnimationUtils.createCircularReveal(
      contentView,
      coordinates.first,
      coordinates.second,
      0f,
      Math.max(contentView.width, contentView.height).toFloat()
    )
    animator.duration = ANIMATION_DURATION.toLong()
    animator.start()
  }

  private fun animateWindowInTranslate(
    contentView: View
  ) {
    val animation = TranslateAnimation(0f, 0f, contentView.height.toFloat(), 0f)
    animation.duration = ANIMATION_DURATION.toLong()

    getContentView().startAnimation(animation)
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  private fun animateWindowOutCircular(
    anchor: View?, contentView: View
  ) {
    val coordinates = getClickOrigin(anchor, contentView)
    val animator = ViewAnimationUtils.createCircularReveal(
      getContentView(),
      coordinates.first,
      coordinates.second,
      Math.max(getContentView().width, getContentView().height).toFloat(),
      0f
    )

    animator.duration = ANIMATION_DURATION.toLong()
    animator.addListener(object : Animator.AnimatorListener {
      override fun onAnimationStart(animation: Animator) {}

      override fun onAnimationEnd(animation: Animator) {
        super@AttachmentTypeSelector.dismiss()
      }

      override fun onAnimationCancel(animation: Animator) {}

      override fun onAnimationRepeat(animation: Animator) {}
    })

    animator.start()
  }

  private fun animateWindowOutTranslate(
    contentView: View
  ) {
    val animation = TranslateAnimation(0f, 0f, 0f, (contentView.top + contentView.height).toFloat())
    animation.duration = ANIMATION_DURATION.toLong()
    animation.setAnimationListener(object : Animation.AnimationListener {
      override fun onAnimationStart(animation: Animation) {}

      override fun onAnimationEnd(animation: Animation) {
        super@AttachmentTypeSelector.dismiss()
      }

      override fun onAnimationRepeat(animation: Animation) {}
    })

    getContentView().startAnimation(animation)
  }

  private fun getClickOrigin(
    anchor: View?, contentView: View
  ): Pair<Int, Int> {
    if (anchor == null) return Pair(0, 0)

    val anchorCoordinates = IntArray(2)
    anchor.getLocationOnScreen(anchorCoordinates)
    anchorCoordinates[0] += anchor.width / 2
    anchorCoordinates[1] += anchor.height / 2

    val contentCoordinates = IntArray(2)
    contentView.getLocationOnScreen(contentCoordinates)

    val x = anchorCoordinates[0] - contentCoordinates[0]
    val y = anchorCoordinates[1] - contentCoordinates[1]

    return Pair(x, y)
  }

  inner class ClickListener (private val type: Int) :
    View.OnClickListener {

    override fun onClick(v: View) {
      animateWindowOutTranslate(contentView)

      if (listener != null) listener!!.onClick(type)
    }
  }

  private inner class CloseClickListener : View.OnClickListener {
    override fun onClick(v: View) {
      dismiss()
    }
  }

  interface AttachmentClickedListener {
    fun onClick(type: Int)

    fun onQuickAttachment(uri: Uri)
  }

  companion object {

    val ADD_GALLERY = 1
    val ADD_DOCUMENT = 2
    val ADD_SOUND = 3
    val ADD_CONTACT_INFO = 4
    val TAKE_PHOTO = 5
    val ADD_LOCATION = 6
    val ADD_GIF = 7

    private val ANIMATION_DURATION = 300

    private val TAG = AttachmentTypeSelector::class.java.simpleName
  }
}
