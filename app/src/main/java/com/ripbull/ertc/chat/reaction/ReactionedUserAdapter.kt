package com.ripbull.ertc.chat.reaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.glide.GlideRequests

class ReactionedUserAdapter(
  private val userRecord: HashSet<UserRecord>
) : RecyclerView.Adapter<ReactionedUserAdapter.MyViewHolder>() {

  private var userList: HashSet<UserRecord>? = null

  init {
    this.userList = userRecord
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ReactionedUserAdapter.MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_mention_user, parent, false)
    return MyViewHolder(itemView)
  }

  override fun getItemCount(): Int {
    return userRecord.size
  }

  override fun onBindViewHolder(holder: ReactionedUserAdapter.MyViewHolder, position: Int) {
    holder.tvName.text = userRecord.elementAt(position).name
    holder.tvEmail.text = userRecord.elementAt(position).id
    holder.tvEmail.text = userRecord.elementAt(position).id
    if (userList!!.elementAt(position).profileThumb != null) {
      Glide.with(holder.ivUserPicture.context).load(userList!!.elementAt(position).profileThumb)
        .into(holder.ivUserPicture)
    } else {
      holder.ivUserPicture.setImageResource(R.drawable.ic_chat_user_default)
    }
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.tvName) as AppCompatTextView
    var tvEmail: AppCompatTextView =
      view.findViewById<View>(R.id.tvEmail) as AppCompatTextView
    var ivUserPicture: AppCompatImageView =
      view.findViewById<View>(R.id.ivUserPicture) as AppCompatImageView
  }

}