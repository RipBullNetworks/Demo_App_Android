package com.ripbull.ertc.group.detail

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.StickyHeaderDecoration
import com.ripbull.ertc.util.Util
import com.ripbull.ertc.util.inflate
import com.ripbull.ertc.util.recyclerview.AdapterCallback
import com.ripbull.ertc.util.recyclerview.BaseListAdapter

class ParticipantListAdapter(
  private val contactList: List<UserRecord>,
  private val glide: GlideRequests,
  callback: AdapterCallback<UserRecord>,
  private val listener: UserAdminAdapterListener? = null,
  private val context: Context? = null,
  private val userListener: UserListAdapterListener? = null
) : StickyHeaderDecoration.StickyHeaderAdapter<HeaderViewHolder>, BaseListAdapter<UserRecord, ViewHolder>(
  DiffUtil(), callback
), Filterable {

  private var contactListFiltered: List<UserRecord>? = null
  var isAdmin = false

  init {
    this.contactListFiltered = contactList
  }

  override fun getHeaderId(position: Int): Long {
    return Util.hashCode(getHeaderString(position)).toLong()
  }

  override fun onCreateHeaderViewHolder(parent: ViewGroup?): HeaderViewHolder {
    return HeaderViewHolder(
      LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_header, parent, false)
    )
  }

  override fun onBindHeaderViewHolder(
    viewHolder: HeaderViewHolder?, position: Int
  ) {
    (viewHolder?.itemView as TextView).visibility = View.GONE
  }

  private fun getSpannedHeaderString(position: Int): CharSequence {
    return getHeaderString(position)
  }

  @NonNull
  private fun getHeaderString(position: Int): String {
    val item = getItem(position)
    val letter = item.name!!
    if (!TextUtils.isEmpty(letter)) {
      val firstChar = letter.trim { it <= ' ' }.substring(0, 1).toUpperCase()
      if (Character.isLetterOrDigit(firstChar.codePointAt(0))) {
        return firstChar
      }
    }
    return "#"
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ContactViewHolder(parent.inflate(R.layout.item_participant_list, false))
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    super.onBindViewHolder(holder, position)
    val item = getItem(position)
    item?.apply {
      holder.unbind(glideRequests = glide)
      holder.bind(glide, 0, name, id, role, profilePic, availabilityStatus)
    }

    context?.let {
      if (ERTCApplication.getSession(it).getUserId() == item.id) {
        isAdmin = item.role.equals(AppConstants.ADMIN)
        listener?.onAdminTrue(isAdmin)
      }
    }
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
        val charString = charSequence.toString()
        if (charString.isEmpty()) {
          contactListFiltered = contactList
        } else {
          val filteredList = ArrayList<UserRecord>()
          for (row in contactList) {
            // name match condition. this might differ depending on your requirement
            // here we are looking for name or phone number match
            row.name?.let {
              if (isMatched(charString, it)) {
                filteredList.add(row)
              }
            }
          }
          contactListFiltered = filteredList
        }

        val filterResults = Filter.FilterResults()
        filterResults.values = contactListFiltered
        return filterResults
      }

      override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
        contactListFiltered = filterResults.values as? ArrayList<UserRecord>
        submitList(contactListFiltered)
        notifyDataSetChanged()
        if (contactListFiltered.isNullOrEmpty()) {
          userListener?.onUserListChanged(true)
        } else {
          userListener?.onUserListChanged(false)
        }
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

  interface UserAdminAdapterListener {
    fun onAdminTrue(isAdmin: Boolean)
  }

  interface UserListAdapterListener {
    fun onUserListChanged(isDataEmpty: Boolean)
  }
}

class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<UserRecord>() {
  override fun areItemsTheSame(p0: UserRecord, p1: UserRecord): Boolean {
    return p0.id == p1.id
  }

  override fun areContentsTheSame(p0: UserRecord, p1: UserRecord): Boolean {
    return p0 == p1
  }
}

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class ContactViewHolder constructor(@NonNull itemView: View) : ViewHolder(itemView) {

  val view: ParticipantSelectionListItem
    get() = itemView as ParticipantSelectionListItem

  override fun bind(
    @NonNull glideRequests: GlideRequests, type: Int,
    name: String?,
    number: String?,
    label: String?,
    profilePic: String?,
    userAvailabilityStatus: String?
  ) {
    view.set(glideRequests, type, name, number, label, profilePic)
  }

  override fun unbind(@NonNull glideRequests: GlideRequests) {
    view.unbind(glideRequests)
  }

}

abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  abstract fun bind(
    @NonNull glideRequests: GlideRequests, type: Int,
    name: String?,
    number: String?,
    label: String?,
    profilePic: String?,
    userAvailabilityStatus: String?
  )

  abstract fun unbind(@NonNull glideRequests: GlideRequests)
}