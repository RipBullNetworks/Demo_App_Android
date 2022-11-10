package com.ripbull.ertc.chat.search

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.AvailabilityStatus
import com.ripbull.coresdk.core.type.ChatEventType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.MessageUpdateType
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.CircleImageView
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.util.TimestampUtil
import java.util.Locale

/**
 * @author Sagar
 */
class SearchHistoryAdapter(
  private val querySearch: String,
  private val context: Context,
  private val searchedMessageList: ArrayList<MessageRecord>,
  private val glide: GlideRequests,
  private val listener: SearchHistoryAdapterListener
) : RecyclerView.Adapter<SearchHistoryAdapter.MyViewHolder>() {

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

    init {

      view.setOnClickListener {
        // send selected contact in callback
        listener.onMessageSelected(searchedMessageList[adapterPosition])
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_chat_history, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val messageRecord = searchedMessageList[position]
    if (messageRecord.type == ChatType.SINGLE.type || messageRecord.type == ChatType.SINGLE_CHAT_THREAD.type) {
      val userRecord = if (messageRecord.chatEventType == ChatEventType.INCOMING) {
        messageRecord.senderRecord
      } else if (messageRecord.chatEventType == ChatEventType.OUTGOING) {
        messageRecord.receiverRecord
      } else {
        null
      }

      holder.tvUserName.text = userRecord?.name
      userRecord?.let {
        if (it.profileThumb != null) {
          glide.load(it.profileThumb).into(holder.ivUserProfile)
        } else {
          holder.ivUserProfile.setImageResource(R.drawable.ic_chat_user_default)
        }
      }

      userRecord?.availabilityStatus?.let {
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
    } else {
      holder.tvUserName.text = messageRecord.groupRecord?.name
      messageRecord.groupRecord?.let {
        if (it.groupThumb != null && it.groupThumb.isNotEmpty()) {
          glide.load(it.groupThumb).into(holder.ivUserProfile)
        } else {
          holder.ivUserProfile.setImageResource(R.drawable.ic_group_default)
        }
      }
    }

    when (messageRecord.msgType) {
      MessageType.TEXT.type                        -> {
        val pattern = Regex("<@+[a-zA-Z0-9._ @-]+>|<@channel>|<@here>")
        if (pattern.containsMatchIn(messageRecord.message.toString())) {
          val parsedMessage =
            pattern.replace(messageRecord.message.toString()) { matchResult ->
              matchResult.value.substring(1, matchResult.value.length - 1)
            }
          holder.tvChatPreview.text = setSpannable(parsedMessage)
        } else {
          holder.tvChatPreview.text = setSpannable(messageRecord.message!!)
        }
        holder.ivMsgType.visibility = View.GONE
      }
      MessageType.IMAGE.type                       -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = messageRecord.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_image_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_image)
        }
      }
      MessageType.VIDEO.type                       -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = messageRecord.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_video_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_video)
        }
      }
      MessageType.AUDIO.type                       -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = messageRecord.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_audio_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_audio)
        }
      }
      MessageType.CONTACT.type                     -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.tvChatPreview.text = messageRecord.message
          holder.ivMsgType.visibility = View.GONE
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_contacts_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_contact)
        }
      }
      MessageType.LOCATION.type                    -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = messageRecord.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_location_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_location)
        }
      }
      MessageType.FILE.type                        -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = messageRecord.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_document_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_doc)
        }
      }
      MessageType.GIPHY.type, MessageType.GIF.type -> {
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          holder.ivMsgType.visibility = View.GONE
          holder.tvChatPreview.text = messageRecord.message
        } else {
          holder.tvChatPreview.text = context.getString(R.string.attachment_gif_title)
          holder.ivMsgType.visibility = View.VISIBLE
          holder.ivMsgType.setImageResource(R.drawable.ic_message_gif)
        }
      }
    }
    holder.tvChatTime.text = messageRecord.timestamp?.let {
      TimestampUtil.convertTime(it)
    }

  }

  private fun setSpannable(msg: String): Spannable{
    val spannable: Spannable = SpannableString(msg)

    if (msg.equals(querySearch, true)) {
      spannable.setSpan(
        BackgroundColorSpan(context.resources.getColor(R.color.thread_stroke_color)),
        0,
        msg.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
      )
      spannable.setSpan(
        ForegroundColorSpan(context.resources.getColor(R.color.chat_user_name_color)),
        0,
        msg.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
      )
      return spannable
    }

    val word: Array<String> = querySearch.toLowerCase()
        .split(" ".toRegex())
        .toTypedArray()

    for (s1 in word){
      if ( msg.toLowerCase(Locale.ROOT).contains(s1)) {
        spannable.setSpan(
          HighLighterSpanable(context),
          msg.toLowerCase().indexOf(s1),
          msg.toLowerCase().indexOf(s1) + s1.length,
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
      }
    }
    return spannable
  }

  override fun getItemCount(): Int {
    return searchedMessageList.size
  }

  interface SearchHistoryAdapterListener {
    fun onMessageSelected(messageRecord: MessageRecord)
  }

  fun notifyUserStatusChanged(userRecord: UserRecord) {
    for ((index, messageRecord) in searchedMessageList.withIndex()) {
      if (messageRecord.senderRecord?.id == userRecord.id) {
        searchedMessageList[index] = messageRecord.copy(senderRecord = userRecord)
        notifyItemChanged(index)
      } else if (messageRecord.receiverRecord?.id == userRecord.id) {
        searchedMessageList[index] = messageRecord.copy(receiverRecord = userRecord)
        notifyItemChanged(index)
      }
    }
  }

  fun notifyGroupStatusChanged(groupRecord: GroupRecord) {
    for ((index, messageRecord) in searchedMessageList.withIndex()) {
      if (messageRecord.groupRecord?.groupId == groupRecord.groupId) {
        searchedMessageList[index] = messageRecord.copy(groupRecord = groupRecord)
        notifyItemChanged(index)
        break
      }
    }
  }

}