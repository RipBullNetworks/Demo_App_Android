package com.ripbull.ertc.chat.forward

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.CircleImageView
import com.ripbull.ertc.glide.GlideRequests

/**
 * @author Sagar
 */
class SelectGroupAdapter(
  private val groupList: ArrayList<GroupRecord>,
  private val glide: GlideRequests,
  private val listener: SelectGroupAdapterListener

) : RecyclerView.Adapter<SelectGroupAdapter.MyViewHolder>(), Filterable {

  private var groupListFiltered: List<GroupRecord>? = null
  var selectedGroups: HashSet<GroupRecord> = HashSet<GroupRecord>()

  init {
    this.groupListFiltered = groupList
  }

  interface SelectGroupAdapterListener {
    fun onGroupSelected()
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.tvName) as AppCompatTextView
    var ivImage: CircleImageView =
      view.findViewById<View>(R.id.ivImage) as CircleImageView
    var tvMembers: AppCompatTextView =
      view.findViewById<View>(R.id.tvMembers) as AppCompatTextView
    var cbGroup: AppCompatCheckBox =
      view.findViewById<AppCompatCheckBox>(R.id.cbGroup)
  }

  init {
    this.groupListFiltered = groupList
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_select_group, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val groupRecord = groupListFiltered!![position]
    holder.tvName.text = groupRecord?.name
    holder.tvMembers.text = "" + groupRecord.groupUsers.size + " members"
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

    //in some cases, it will prevent unwanted situations
    holder.cbGroup.setOnCheckedChangeListener(null)

    holder.cbGroup.isChecked = selectedGroups.contains(groupRecord)

    holder.cbGroup.setOnCheckedChangeListener { buttonView, isChecked ->
      if (isChecked) {
        selectedGroups.add(groupRecord)
      } else {
        selectedGroups.remove(groupRecord)
      }
      listener.onGroupSelected()
    }
  }

  override fun getItemCount(): Int {
    return if (groupListFiltered != null){
      groupListFiltered!!.size
    }else{
      0
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
            // name match condition. this might differ depending on your requirement
            // here we are looking for name or phone number match
              row.groupId?.let {
                if (isMatched(charString, it)) {
                  filteredList.add(row)
                }
              }
          }
          groupListFiltered = filteredList
        }

        val filterResults = FilterResults()
        filterResults.values = groupListFiltered
        return filterResults
      }

      override fun publishResults(charSequence: CharSequence, filterResults: FilterResults?) {
        groupListFiltered = filterResults!!.values as? ArrayList<GroupRecord>?
        notifyDataSetChanged()
      }
    }
  }

  private fun isMatched(charString: String, name: String): Boolean{
    val nameArray = name.split(" ").toTypedArray()
    for (name in nameArray){
      if (charString.toLowerCase().equals(name.substring(0, charString.length).toLowerCase())) {
        return true
      }
    }
    return false
  }

}