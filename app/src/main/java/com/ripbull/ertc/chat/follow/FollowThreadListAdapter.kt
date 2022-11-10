package com.ripbull.ertc.chat.follow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.chat.mapper.FollowThreadRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatCommonAdapter
import com.ripbull.ertc.components.CircleImageView
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.util.AppConstants

/**
 * @author Sagar
 */
class FollowThreadListAdapter(
  private val context: Context,
  private var followThreadList: ArrayList<FollowThreadRecord>,
  private val glide: GlideRequests,
  private val listener: FollowThreadListAdapterListener,
  private val chatListener: ChatCommonAdapter.ChatCommonAdapterListener
) : RecyclerView.Adapter<FollowThreadListAdapter.MyViewHolder>() {

  interface FollowThreadListAdapterListener {
    fun onUnFollowThread(index: Int, followThreadRecord: FollowThreadRecord)
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var ivDP: CircleImageView =
      view.findViewById<View>(R.id.ivUserProfile) as CircleImageView
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.tvUserName) as AppCompatTextView
    var tvParticipants: AppCompatTextView =
      view.findViewById<View>(R.id.tvParticipants) as AppCompatTextView
    var ivThreadOption: AppCompatImageView =
      view.findViewById<View>(R.id.ivThreadOption) as AppCompatImageView
    var rvReplies: RecyclerView =
      view.findViewById<View>(R.id.rvReplies) as RecyclerView
    var btnReply: AppCompatButton =
      view.findViewById<View>(R.id.btnReply) as AppCompatButton

    init {
      view.setOnClickListener {
        // redirect to thread screen
      }

      ivThreadOption.setOnClickListener {
        if (adapterPosition == -1) return@setOnClickListener
        listener.onUnFollowThread(adapterPosition, followThreadList[adapterPosition])
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_follow_thread, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val followThreadRecord = followThreadList[position]
    holder.tvName.text = followThreadRecord.name
    if (followThreadRecord.participants.isNotEmpty() && followThreadRecord.participants.size > 3) {
      var participant = ""
      for ((index, participantName) in followThreadRecord.participants.withIndex()) {
        if (index == 2) break
        participant += "$participantName, "
      }
      participant += "and " + (followThreadRecord.participants.size - 2) + " others"
      holder.tvParticipants.text = participant
    } else {
      val participants = followThreadRecord.participants.toString()
      holder.tvParticipants.text = participants.substring(1, participants.length-1)
    }

    if (followThreadRecord.type == ChatType.SINGLE.type) {
      followThreadRecord.recipient?.let {
        if (it.profileThumb != null) {
          glide.load(it.profileThumb).into(holder.ivDP)
        } else {
          holder.ivDP.setImageResource(R.drawable.ic_chat_user_default)
        }
      }
    } else {
      followThreadRecord.group?.let {
        if (it.groupThumb != null) {
          glide.load(it.groupThumb).into(holder.ivDP)
        } else {
          holder.ivDP.setImageResource(R.drawable.ic_group_default)
        }
      }
    }

    var mAdapter: ChatCommonAdapter? = null
    holder.rvReplies.layoutManager = LinearLayoutManager(context)
    holder.rvReplies.itemAnimator = DefaultItemAnimator()
    mAdapter = ChatCommonAdapter(
      followThreadRecord.replies as ArrayList<MessageRecord>, null, context,
      AppConstants.TYPE_FOLLOW_THREAD, followThreadRecord.type, chatListener,
      replyCount = followThreadRecord.replyCount
    )

    holder.rvReplies.adapter = mAdapter
  }

  override fun getItemCount(): Int {
    return followThreadList.size
  }

  class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<FollowThreadRecord>() {
    override fun areItemsTheSame(p0: FollowThreadRecord, p1: FollowThreadRecord): Boolean {
      return p0.parentMsgId == p1.parentMsgId
    }

    override fun areContentsTheSame(p0: FollowThreadRecord, p1: FollowThreadRecord): Boolean {
      return p0.parentMsgId == p1.parentMsgId
    }
  }

  fun notifyOnUnFollowThread(index: Int, followThreadRecord: FollowThreadRecord) {
    followThreadList.removeAt(index)
    notifyItemRemoved(index)
    notifyItemRangeChanged(index, followThreadList.size)
  }

  fun update(threadList: ArrayList<FollowThreadRecord>){
    followThreadList = threadList
    notifyDataSetChanged()
  }
}