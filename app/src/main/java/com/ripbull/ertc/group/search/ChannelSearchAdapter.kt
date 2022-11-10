package com.ripbull.ertc.group.search

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.CircleImageView
import com.ripbull.ertc.glide.GlideRequests
import timber.log.Timber

class ChannelSearchAdapter(
  private val groupList: ArrayList<GroupRecord>,
  private val glide: GlideRequests,
  private val listener: ChannelSearchAdapterListener
) : RecyclerView.Adapter<ChannelSearchAdapter.MyViewHolder>() {

  interface ChannelSearchAdapterListener {
    fun onChannelSelected(groupRecord: GroupRecord)
    fun onJoin(index: Int, groupRecord: GroupRecord)
    fun onLeaveChannel(index: Int, groupRecord: GroupRecord)
    fun onClearChat(index: Int, groupRecord: GroupRecord)
    fun onMuteChannel(index: Int, groupRecord: GroupRecord)
    fun onAddMember(index: Int, groupRecord: GroupRecord)
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.tvName) as AppCompatTextView
    var ivImage: CircleImageView =
      view.findViewById<View>(R.id.ivImage) as CircleImageView
    var tvMembers: AppCompatTextView =
      view.findViewById<View>(R.id.tvMembers) as AppCompatTextView
    var tvJoin: AppCompatTextView =
      view.findViewById<View>(R.id.tvJoin) as AppCompatTextView
    var ivPrivate: AppCompatImageView =
      view.findViewById<View>(R.id.ivPrivate) as AppCompatImageView
    var ivOptionMenu: AppCompatImageView =
      view.findViewById<View>(R.id.ivOptionMenu) as AppCompatImageView
    var tvPrivate: AppCompatTextView =
      view.findViewById<View>(R.id.tvPrivate) as AppCompatTextView

    init {
      tvJoin.setOnClickListener {
        listener.onJoin(adapterPosition, groupList[adapterPosition])
      }

      view.setOnClickListener {
        // send selected contact in callback
        listener.onChannelSelected(groupList[adapterPosition])
      }

      ivOptionMenu.setOnClickListener {
        showPopupMenu(view, adapterPosition, groupList[adapterPosition])
      }
    }
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_group_list, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(
    holder: MyViewHolder,
    position: Int
  ) {
    val groupRecord = groupList[position]
    holder.tvMembers.visibility = View.VISIBLE
    holder.tvName.text = groupRecord.name
    holder.tvMembers.text = "" + groupRecord.participantsCount + " members"
    if (groupRecord.groupType == GroupRecord.TYPE_PUBLIC) {
      holder.ivPrivate.visibility = View.GONE
      holder.tvPrivate.visibility = View.GONE
      if (groupRecord.isNotInGroup) {
        holder.tvJoin.visibility = View.VISIBLE
        holder.ivOptionMenu.visibility = View.GONE
      } else {
        holder.tvJoin.visibility = View.GONE
        holder.ivOptionMenu.visibility = View.VISIBLE
      }
    } else {
      holder.tvJoin.visibility = View.GONE
      holder.ivOptionMenu.visibility = View.GONE
      holder.ivPrivate.visibility = View.VISIBLE
      holder.tvPrivate.visibility = View.VISIBLE
    }

    groupRecord.groupPic?.let {
      if (it.isNotEmpty()) {
        glide.load(it).into(holder.ivImage)
      } else {
        holder.ivImage.setImageResource(R.drawable.ic_group_default)
      }
    }

    groupRecord.groupThumb?.let {
      if (it.isNotEmpty()) {
        glide.load(it).into(holder.ivImage)
      } else {
        holder.ivImage.setImageResource(R.drawable.ic_group_default)
      }
    }
  }

  override fun getItemCount(): Int {
    return groupList.size
  }

  fun notifyOnJoined(
    index: Int,
    groupRecord: GroupRecord
  ) {
    if (index < groupList.size) {
      groupList[index] = groupRecord
      notifyItemChanged(index)
    }
  }

  fun notifyOnExit(
    index: Int,
    groupRecord: GroupRecord
  ) {
    groupList.removeAt(index)
    notifyItemRemoved(index)
    notifyItemRangeChanged(index, groupList.size)
  }

  private fun showPopupMenu(view: View, index: Int, groupRecord: GroupRecord) {
    val popupMenu = PopupMenu(view.context, view, Gravity.RIGHT)
    popupMenu.setOnMenuItemClickListener { item ->
      when (item.itemId){
        R.id.action_mute_notification -> {
          listener.onMuteChannel(index, groupRecord)
          true
        }
        R.id.action_add_participants -> {
          listener.onAddMember(index, groupRecord)
          true
        }
        R.id.action_clear_chat -> {
          listener.onClearChat(index, groupRecord)
          true
        }
        R.id.action_leave_channel -> {
          listener.onLeaveChannel(index, groupRecord)
          true
        }
        else -> false
      }
    }

    popupMenu.inflate(R.menu.channel_popup_menu)
    if (groupRecord.groupType == GroupRecord.TYPE_PRIVATE) {
      popupMenu.menu.findItem(R.id.action_add_participants).isVisible = false
    }

    if (groupRecord.groupStatus == GroupRecord.STATUS_FROZEN) {
      popupMenu.menu.findItem(R.id.action_mute_notification).isVisible = false
      popupMenu.menu.findItem(R.id.action_add_participants).isVisible = false
      popupMenu.menu.findItem(R.id.action_leave_channel).isVisible = false
    }

    try {
      val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
      fieldMPopup.isAccessible = true
      val mPopup = fieldMPopup.get(popupMenu)
      mPopup.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java).invoke(mPopup, true)
    } catch (e: Exception) {
      Timber.e("Adapter-> Exception: $e")
    } finally {
      popupMenu.show()
    }
  }
}