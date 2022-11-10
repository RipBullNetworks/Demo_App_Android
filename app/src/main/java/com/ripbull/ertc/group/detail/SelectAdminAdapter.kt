package com.ripbull.ertc.group.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.AvatarImageView
import com.ripbull.ertc.extension.setDrawableLeft
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.recepients.Recipient
import com.ripbull.ertc.util.AppConstants

class SelectAdminAdapter(
  private val contactList: List<UserRecord>,
  private val glide: GlideRequests,
  private val listener: SelectAdminAdapterListener
) : RecyclerView.Adapter<SelectAdminAdapter.MyViewHolder>() {

  private var contactListFiltered: List<UserRecord>? = null
  var selectedUsers: HashSet<UserRecord> = HashSet()

  init {
    this.contactListFiltered = contactList
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var cbUser: AppCompatCheckBox =
      view.findViewById<View>(R.id.cbUser) as AppCompatCheckBox
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.name) as AppCompatTextView
    var tvEmail: AppCompatTextView =
      view.findViewById<View>(R.id.email) as AppCompatTextView
    var tvLabel: AppCompatTextView =
      view.findViewById<View>(R.id.label) as AppCompatTextView
    var contactPhotoImage: AvatarImageView =
      view.findViewById<View>(R.id.contact_photo_image) as AvatarImageView
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_select_user, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val userRecord = contactListFiltered!![position]

    holder.tvName.text = userRecord.name
    holder.tvEmail.text = userRecord.id

    val recipient = Recipient(userRecord.name, null, null)
    if (userRecord.profileThumb.isNullOrEmpty()){
      holder.contactPhotoImage.setAvatar(glide, recipient)
    } else {
      holder.contactPhotoImage.let { glide.load(userRecord.profileThumb).circleCrop().into(it) }
    }

    //in some cases, it will prevent unwanted situations
    //in some cases, it will prevent unwanted situations
    holder.cbUser.setOnCheckedChangeListener(null)
    holder.cbUser.isChecked = selectedUsers.contains(userRecord)

    holder.cbUser.setOnCheckedChangeListener { buttonView, isChecked ->
      if (isChecked) {
        selectedUsers.add(userRecord)
      } else {
        selectedUsers.remove(userRecord)
      }
      listener.onUserSelected()
    }

    if (userRecord.blockedStatus == AppConstants.USER_BLOCKED) {
      holder.tvName.setDrawableLeft(R.drawable.ic_blocked)
    }
  }

  override fun getItemCount(): Int {
    return if (contactListFiltered != null) {
      contactListFiltered!!.size
    } else {
      0
    }
  }

  interface SelectAdminAdapterListener {
    fun onUserSelected()
  }
}