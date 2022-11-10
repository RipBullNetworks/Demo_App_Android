package com.ripbull.ertc.chat.chat

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import kotlin.math.min

class UserMentionAdapter(
  context: Context,
  @LayoutRes private val layoutResource: Int,
  private val userMentionList: ArrayList<UserRecord>
) : ArrayAdapter<UserRecord>(context, layoutResource, userMentionList), Filterable {

  private var userFilteredList = userMentionList

  override fun getCount(): Int {
    return if (userFilteredList != null){
      userFilteredList!!.size
    }else{
      0
    }
  }

  override fun getItem(p0: Int): UserRecord {
    userFilteredList?.let {
      return it[p0]
    }
    return UserRecord()
  }

  override fun getItemId(p0: Int): Long {
    // Or just return p0
    return p0.toLong()
  }

  override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
    val view: TextView = convertView as TextView? ?: LayoutInflater.from(context)
      .inflate(layoutResource, parent, false) as TextView

    val userRecord = getItem(position)
    val user = "${userRecord.name}\n${userRecord.id}"
    val spanString = SpannableString(user)
    if (userRecord.name != null && userRecord.id != null) {
      spanString.setSpan(
        RelativeSizeSpan(0.75f),
        userRecord.name!!.length + 1,
        user.length, 0) // set size
      spanString.setSpan(
        ForegroundColorSpan(Color.parseColor(context.getString(R.string.auto_text_id_color))),
        userRecord.name!!.length + 1,
        user.length, 0) // set color
    }
    view.text = spanString

    return view
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      override fun publishResults(charSequence: CharSequence?, filterResults: Filter.FilterResults) {
        if (filterResults.values != null) {
          userFilteredList = filterResults.values as ArrayList<UserRecord>
          notifyDataSetChanged()
        }
      }

      override fun performFiltering(charSequence: CharSequence?): Filter.FilterResults {
        val queryString = charSequence?.toString()

        val filterResults = Filter.FilterResults()
        filterResults.values = if (queryString==null || queryString.isEmpty())
          userMentionList
        else
          userMentionList.filter {
            queryString.equals(it.name?.substring(0, min(queryString.length, it.name!!.length)), true) ||
                queryString.equals(it.id?.substring(0, min(queryString.length, it.id!!.length)), true)
          }

        return filterResults
      }

    }
  }

}