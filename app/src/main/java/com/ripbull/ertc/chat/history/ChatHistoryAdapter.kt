package com.ripbull.ertc.chat.history

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.core.type.AvailabilityStatus
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageUpdateType
import com.ripbull.coresdk.core.type.NotificationSettingsType
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.coresdk.utils.Constants
import com.ripbull.ertc.R
import com.ripbull.ertc.components.CircleImageView
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.TimestampUtil

/**
 * @author Sagar
 */
class ChatHistoryAdapter(
  private val context: Context,
  private val chatHistoryList: ArrayList<ThreadRecord>,
  private val glide: GlideRequests,
  private val listener: ChatHistoryAdapterListener
) : RecyclerView.Adapter<ChatHistoryAdapter.MyViewHolder>(), Filterable {

  private var chatListFiltered: List<ThreadRecord>? = null

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvUserName: AppCompatTextView =
      view.findViewById<View>(R.id.tvUserName) as AppCompatTextView
    var tvChatPreview: AppCompatTextView =
      view.findViewById<View>(R.id.tvChatPreview) as AppCompatTextView
    var tvChatTime: AppCompatTextView =
      view.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    var ivUserProfile: CircleImageView =
      view.findViewById<View>(R.id.ivUserProfile) as CircleImageView
    var ivMsgType: AppCompatImageView =
      view.findViewById<View>(R.id.ivMsgType) as AppCompatImageView
    var ivUserStatus: AppCompatImageView =
      view.findViewById<View>(R.id.ivUserStatus) as AppCompatImageView
    var ivMute: AppCompatImageView =
      view.findViewById<View>(R.id.ivMute) as AppCompatImageView
    var tvChatCount: AppCompatTextView =
      view.findViewById<View>(R.id.tvChatCount) as AppCompatTextView
    var ivContactBlocked: AppCompatImageView =
      view.findViewById<View>(R.id.ivContactBlocked) as AppCompatImageView

    init {

      view.setOnClickListener {
        // send selected contact in callback
        listener.onChatSelected(chatListFiltered!![adapterPosition])
      }
    }
  }

  init {
    this.chatListFiltered = chatHistoryList
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_chat_history, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val threadRecord = chatListFiltered!![position]
    if (threadRecord.type == ChatType.SINGLE.type) {
      holder.tvUserName.text = threadRecord.recipient?.name
      threadRecord.recipient?.let {
        if (it.profileThumb != null) {
          glide.load(it.profileThumb).into(holder.ivUserProfile)
        } else {
          holder.ivUserProfile.setImageResource(R.drawable.ic_chat_user_default)
        }
      }
      holder.tvChatCount.visibility = if (threadRecord.unReadCount > 0) View.VISIBLE else View.GONE
      holder.tvChatCount.text = threadRecord.unReadCount.toString()

      threadRecord.recipient?.availabilityStatus?.let {
        when (it) {
          AvailabilityStatus.ONLINE.status    -> {
            holder.ivUserStatus.setImageResource(R.drawable.ic_status_active)
          }
          AvailabilityStatus.AWAY.status      -> {
            holder.ivUserStatus.setImageResource(R.drawable.ic_status_away)
          }
          AvailabilityStatus.DND.status       -> {
            holder.ivUserStatus.setImageResource(R.drawable.ic_status_dnd)
          }
          AvailabilityStatus.INVISIBLE.status -> {
            holder.ivUserStatus.setImageResource(R.drawable.ic_status_invisible)
          }
        }
      }

      threadRecord.recipient?.let {
        if (it.blockedStatus == AppConstants.USER_BLOCKED) {
          holder.ivContactBlocked.visibility = View.VISIBLE
        } else {
          holder.ivContactBlocked.visibility = View.GONE
        }
      }
    } else {
      holder.tvChatCount.visibility = if (threadRecord.unReadCount > 0) View.VISIBLE else View.GONE
      holder.tvChatCount.text = threadRecord.unReadCount.toString()
      holder.tvUserName.text = threadRecord.groupRecipient?.name
      threadRecord.groupRecipient?.let {
        if (it.groupThumb != null && it.groupThumb.isNotEmpty()) {
          glide.load(it.groupThumb).into(holder.ivUserProfile)
        } else {
          holder.ivUserProfile.setImageResource(R.drawable.ic_group_default)
        }
      }
    }

    when (threadRecord.lastMessage.msgType) {
      MessageType.TEXT.type                        -> {
        val pattern = Regex("<@+[a-zA-Z0-9._ @-]+>|<@channel>|<@here>")
        if (pattern.containsMatchIn(threadRecord.lastMessage.message.toString())) {
          val parsedMessage =
            pattern.replace(threadRecord.lastMessage.message.toString()) { matchResult ->
              matchResult.value.substring(1, matchResult.value.length - 1)
            }
          holder.tvChatPreview.text = parsedMessage
        } else {
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        }
        holder.ivMsgType.visibility = View.GONE
      }
      MessageType.IMAGE.type                       -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_image_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_image)
        }
      }
      MessageType.VIDEO.type                       -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_video_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_video)
        }
      }
      MessageType.AUDIO.type                       -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_audio_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_audio)
        }
      }
      MessageType.CONTACT.type                     -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.tvChatPreview.text = threadRecord.lastMessage.message
          holder.ivMsgType.visibility = View.GONE
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_contacts_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_contact)
        }
      }
      MessageType.LOCATION.type                    -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_location_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_location)
        }
      }
      MessageType.FILE.type                        -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_document_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_doc)
        }
      }
      MessageType.GIPHY.type, MessageType.GIF.type -> {
        if (threadRecord.lastMessage.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = threadRecord.lastMessage.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_gif_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_gif)
        }
      }
    }
    holder.tvChatTime.text = threadRecord.lastMessage.timestamp?.let {
      TimestampUtil.convertTime(it)
    }

    if (threadRecord.notificationSettings == NotificationSettingsType.NONE.mute ||
      threadRecord.notificationSettings == NotificationSettingsType.MENTIONS.mute
    ) {
      holder.ivMute.visibility = View.VISIBLE
    } else if (threadRecord.notificationSettings == NotificationSettingsType.ALL.mute) {
      holder.ivMute.visibility = View.GONE
    }
  }

  override fun getItemCount(): Int {
    return if (chatListFiltered != null) {
      chatListFiltered!!.size
    } else {
      0
    }
  }

  class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ThreadRecord>() {
    override fun areItemsTheSame(p0: ThreadRecord, p1: ThreadRecord): Boolean {
      return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: ThreadRecord, p1: ThreadRecord): Boolean {
      return p0 == p1
    }
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun performFiltering(charSequence: CharSequence): FilterResults {
        val charString = charSequence.toString()
        if (charString.isEmpty()) {
          chatListFiltered = chatHistoryList
        } else {
          val filteredList = ArrayList<ThreadRecord>()
          for (row in chatHistoryList) {
            // name match condition. this might differ depending on your requirement
            // here we are looking for name or phone number match
            if (row.type == ChatType.SINGLE.type) {
              row.recipient?.name?.let {
                if (isMatched(charString, it)) {
                  filteredList.add(row)
                }
              }
            } else {
              row.groupRecipient?.name?.let {
                if (isMatched(charString, it)) {
                  filteredList.add(row)
                }
              }
            }
          }
          chatListFiltered = filteredList
        }

        val filterResults = FilterResults()
        filterResults.values = chatListFiltered
        return filterResults
      }

      override fun publishResults(charSequence: CharSequence, filterResults: FilterResults?) {
        chatListFiltered = filterResults!!.values as? ArrayList<ThreadRecord>?
        notifyDataSetChanged()
      }
    }
  }

  interface ChatHistoryAdapterListener {
    fun onChatSelected(threadRecord: ThreadRecord)
  }

  private fun isMatched(charString: String, name: String): Boolean {
    val nameArray = name.split(" ").toTypedArray()
    for (name in nameArray) {
      if (charString.toLowerCase().equals(name.substring(0, charString.length).toLowerCase())) {
        return true
      }
    }
    return false
  }

  fun notifyUserStatusChanged(userRecord: UserRecord) {
    for ((index, threadRecord) in chatHistoryList.withIndex()) {
      if (threadRecord.recipient?.id == userRecord.id) {
        chatHistoryList[index].recipient = userRecord
        notifyItemChanged(index)
        break
      }
    }
  }

  fun notifyGroupStatusChanged(groupRecord: GroupRecord) {
    for ((index, threadRecord) in chatHistoryList.withIndex()) {
      if (threadRecord.groupRecipient?.groupId == groupRecord.groupId) {
        chatHistoryList[index].groupRecipient = groupRecord
        notifyItemChanged(index)
        break
      }
    }
  }
}