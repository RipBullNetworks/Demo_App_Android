package com.ripbull.ertc.group.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.CircleImageView
import com.ripbull.ertc.glide.GlideRequests

/**
 * @author vik
 */
class GroupListAdapter(
  private val groupList: ArrayList<GroupRecord>,
  private val glide: GlideRequests,
  private val listener: GroupListAdapterListener
) : RecyclerView.Adapter<GroupListAdapter.MyViewHolder>(), Filterable {

  private var groupListFiltered: List<GroupRecord>? = null

  init {
    this.groupListFiltered = groupList
  }

  interface GroupListAdapterListener {
    fun onGroupSelected(groupRecord: GroupRecord)
    fun onGroupListChanged(isDataEmpty: Boolean)
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.tvName) as AppCompatTextView
    var ivImage: CircleImageView =
      view.findViewById<View>(R.id.ivImage) as CircleImageView
    var tvMembers: AppCompatTextView =
      view.findViewById<View>(R.id.tvMembers) as AppCompatTextView


    init {

      view.setOnClickListener {
        // send selected contact in callback
        listener.onGroupSelected(groupListFiltered!![adapterPosition])
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_group_list, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val groupRecord = groupListFiltered!![position]
    holder.tvName.text = groupRecord?.name
    holder.tvMembers.text = "" + groupRecord.participantsCount + " members"
    groupRecord.groupPic?.let {
      if (it != null && it.isNotEmpty()) {
        glide.load(it).into(holder.ivImage)
      } else {
        holder.ivImage.setImageResource(R.drawable.ic_group_default)
      }
    }

    groupRecord.groupThumb?.let {
      if (it != null && it.isNotEmpty()) {
        glide.load(it).into(holder.ivImage)
      } else {
        holder.ivImage.setImageResource(R.drawable.ic_group_default)
      }
    }
  }

  override fun getItemCount(): Int {
    return if (groupListFiltered != null){
      groupListFiltered!!.size
    }else{
      0
    }
  }

  class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<GroupRecord>() {
    override fun areItemsTheSame(p0: GroupRecord, p1: GroupRecord): Boolean {
      return p0.groupId == p1.groupId
    }

    override fun areContentsTheSame(p0: GroupRecord, p1: GroupRecord): Boolean {
      return p0.groupId == p1.groupId
    }
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun performFiltering(charSequence: CharSequence): FilterResults {
        val charString = charSequence.toString()
        if (charString.isEmpty()) {
          groupListFiltered = groupList
        } else {
          val filteredList = ArrayList<GroupRecord>()
          for (row in groupList) {
            if (row.name.toLowerCase().contains(charString.toLowerCase())) {
              filteredList.add(row)
            }
          }
          groupListFiltered = filteredList
        }

        val filterResults = FilterResults()
        filterResults.values = groupListFiltered
        return filterResults
      }

      override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
        groupListFiltered = filterResults.values as ArrayList<GroupRecord>
        if (groupListFiltered.isNullOrEmpty()) {
          listener.onGroupListChanged(true)
        } else {
          listener.onGroupListChanged(false)
        }
        notifyDataSetChanged()
      }
    }
  }

  fun notifyGroupUpdated(groupRecord: GroupRecord) {
    for((index, record) in groupList.withIndex()) {
      if(record.groupId == groupRecord.groupId) {
        groupList[index] = groupRecord
        notifyItemChanged(index)
        break
      }
    }
  }
}

