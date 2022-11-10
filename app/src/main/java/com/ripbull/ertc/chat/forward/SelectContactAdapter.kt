package com.ripbull.ertc.chat.forward

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.components.AvatarImageView
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.recepients.Recipient

/**
 * @author Sagar
 */
class SelectContactAdapter(
  private val contactList: List<UserRecord>,
  private val glide: GlideRequests,
  private val listener: SelectContactAdapterListener
) : RecyclerView.Adapter<SelectContactAdapter.MyViewHolder>(), Filterable {

  private var contactListFiltered: List<UserRecord>? = null
  var selectedContact: HashSet<UserRecord?> = HashSet<UserRecord?>()

  init {
    this.contactListFiltered = contactList
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var cbUser: AppCompatCheckBox =
      view.findViewById<View>(R.id.cbUser) as AppCompatCheckBox
    var tvName: AppCompatTextView =
      view.findViewById<View>(R.id.name) as AppCompatTextView
    var tvEmail: AppCompatTextView =
      view.findViewById<View>(R.id.email) as AppCompatTextView
    var tvLabel: AppCompatTextView =
      view.findViewById<View>(R.id.label) as AppCompatTextView
    var contactPhotoImage: AvatarImageView =
      view.findViewById<View>(R.id.contact_photo_image) as AvatarImageView
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_select_user, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val userRecord = contactListFiltered!![position]

    holder.tvName.text = userRecord.name
    holder.tvEmail.text = userRecord.id

    val recipient = Recipient(userRecord.name, null, null)
    if (userRecord.profileThumb.isNullOrEmpty()){
      holder.contactPhotoImage.setAvatar(glide, recipient)
    } else {
      holder.contactPhotoImage.let { glide.load(userRecord.profileThumb).circleCrop().into(it) }
    }

    //in some cases, it will prevent unwanted situations
    holder.cbUser.setOnCheckedChangeListener(null)

    holder.cbUser.isChecked = selectedContact.contains(userRecord)

    holder.cbUser.setOnCheckedChangeListener { buttonView, isChecked ->
      if (isChecked) {
        selectedContact.add(userRecord)
      } else {
        selectedContact.remove(userRecord)
      }
      listener.onContactSelected()
    }
  }

  override fun getItemCount(): Int {
    return if (contactListFiltered != null) {
      contactListFiltered!!.size
    } else {
      0
    }
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun performFiltering(charSequence: CharSequence): FilterResults {
        val charString = charSequence.toString()
        if (charString.isEmpty()) {
          contactListFiltered = contactList
        } else {
          val filteredList = ArrayList<UserRecord>()
          for (row in contactList) {
            if (row.name!!.toLowerCase().contains(charString.toLowerCase())) {
              filteredList.add(row)
            }
          }
          contactListFiltered = filteredList
        }

        val filterResults = FilterResults()
        filterResults.values = contactListFiltered
        return filterResults
      }

      override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
        contactListFiltered = filterResults.values as ArrayList<UserRecord>
        notifyDataSetChanged()
      }
    }
  }

  interface SelectContactAdapterListener {
    fun onContactSelected()
  }
}