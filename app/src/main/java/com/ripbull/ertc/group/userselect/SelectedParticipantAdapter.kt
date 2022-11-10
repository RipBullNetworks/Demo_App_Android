package com.ripbull.ertc.group.userselect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.AvatarImageView
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.recepients.Recipient

class SelectedParticipantAdapter(
  private val selectedUserList : ArrayList<UserRecord>,
  private val glide: GlideRequests,
  private val listener: SelectedParticipantAdapterListener
) : RecyclerView.Adapter<SelectedParticipantAdapter.MyViewHolder>() {

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvParticipantName: AppCompatTextView =
      view.findViewById<View>(R.id.tvParticipantName) as AppCompatTextView
    var ivParticipantDP: AvatarImageView =
      view.findViewById<View>(R.id.ivParticipantDP) as AvatarImageView
    var ivRemoveUser: AppCompatImageView = view.findViewById<View>(R.id.ivRemoveUser) as AppCompatImageView
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_selected_participant, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val userRecord = selectedUserList[position]

    holder.tvParticipantName.text = userRecord.name

    val recipient = Recipient(userRecord.name, null, null)
    if (userRecord.profileThumb.isNullOrEmpty()) {
      holder.ivParticipantDP.setAvatar(glide, recipient)
    } else {
      glide.load(userRecord.profileThumb).circleCrop().into(holder.ivParticipantDP)
    }

    holder.ivRemoveUser.setOnClickListener {
      listener.onUserRemoved(userRecord)
    }
  }

  override fun getItemCount(): Int {
    return selectedUserList.size
  }

  interface SelectedParticipantAdapterListener {
    fun onUserRemoved(userRecord: UserRecord)
  }
}