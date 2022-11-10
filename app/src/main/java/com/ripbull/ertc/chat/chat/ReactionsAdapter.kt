package com.ripbull.ertc.chat.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.chat.mapper.ChatReactionRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.util.MediaUtil

/** Created by Sagar on 21/06/20.  */
class ReactionsAdapter(
  private var arrayList: ArrayList<ChatReactionRecord>,
  private val messageRecord: MessageRecord,
  private val listener: ReactionsAdapterListener
) : RecyclerView.Adapter<ReactionsAdapter.ItemHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
    val viewHolder = LayoutInflater.from(parent.context)
      .inflate(R.layout.item_reaction_grid_view, parent, false)
    return ItemHolder(viewHolder)
  }

  override fun getItemCount(): Int {
    return arrayList.size
  }

  override fun onBindViewHolder(holder: ItemHolder, position: Int) {
    val reactionItem = arrayList[position]
    reactionItem.count?.let {
      if (it > 0) {
        holder.tvReaction.text = MediaUtil.uriDecoder(reactionItem.emojiCode) + " " + it
      }
    }

    holder.tvReaction.setOnClickListener {
      listener.onReactionClick(reactionItem, messageRecord)
    }

    holder.tvReaction.setOnLongClickListener{
      val reactions= ArrayList<String>()
      reactions.add(reactionItem.emojiCode!!)
      listener.onReactionLongClick(
        reactions, messageRecord.id, messageRecord.threadId!!, messageRecord.chatEventType!!.type
      )
      true
    }
  }

  class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvReaction = itemView.findViewById<AppCompatTextView>(R.id.tvReaction)
  }

  interface ReactionsAdapterListener {
    fun onReactionClick(chatReactionRecord: ChatReactionRecord, messageRecord: MessageRecord)
    fun onReactionLongClick(reactionUnicodes: List<String>, msgId:String, threadId:String, chatType:String)
  }
}