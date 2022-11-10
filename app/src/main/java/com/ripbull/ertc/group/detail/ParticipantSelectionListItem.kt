package com.ripbull.ertc.group.detail

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.ripbull.ertc.R
import com.ripbull.ertc.components.AvatarImageView
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.recepients.Recipient
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.ViewUtil

class ParticipantSelectionListItem : LinearLayout {

  private var contactPhotoImage: AvatarImageView? = null
  private var txtEmail: TextView? = null
  private var nameView: TextView? = null
  private var labelView: TextView? = null

  var email: String? = null
    private set

  constructor(context: Context) : super(context)

  constructor(
    context: Context, attrs: AttributeSet
  ) : super(context, attrs)

  override fun onFinishInflate() {
    super.onFinishInflate()
    this.contactPhotoImage = findViewById(R.id.contact_photo_image)
    this.txtEmail = findViewById(R.id.email)
    this.labelView = findViewById(R.id.label)
    this.nameView = findViewById(R.id.name)

    ViewUtil.setTextViewGravityStart(this.nameView!!, context)
  }

  operator fun set(
    glideRequests: GlideRequests, type: Int, name: String?, email: String?, label: String?, profilePic: String?
  ) {
    this.email = email
    //this.nameView.setTextColor(color);
    //this.numberView.setTextColor(color);
    val recipient = Recipient(name, null, null)
    if (profilePic != null && profilePic.isNotEmpty()){
      this.contactPhotoImage?.let { glideRequests.load(profilePic).circleCrop().into(it) }
    } else {
      this.contactPhotoImage?.setAvatar(glideRequests, recipient)
    }

    setText(type, name, email, label)

  }

  fun unbind(glideRequests: GlideRequests) {
    contactPhotoImage!!.clear(glideRequests)
  }

  private fun setText(
    type: Int, name: String?, email: String?, label: String?
  ) {
    this.txtEmail!!.text = email
    this.nameView!!.isEnabled = true
    if (TextUtils.isEmpty(label) || label.equals(AppConstants.USER)) {
      this.labelView!!.visibility = View.GONE
    } else {
      this.labelView!!.text = label
      this.labelView!!.visibility = View.VISIBLE
    }

    this.nameView!!.text = name
  }

  companion object {

    private val TAG = ParticipantSelectionListItem::class.java.simpleName
  }
}