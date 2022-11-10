package com.ripbull.ertc.util.recyclerview

import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @author meeth
 */
internal class AdapterBinder {

  companion object {

    @JvmStatic
    fun <T> bind(holder: ViewHolder, callback: AdapterCallback<T>?, list: List<T>, position: Int) {
      if (position >= 0 && position < list.size) {
        val t = list[position]
        bind(holder, callback, t)
      }
    }

    @JvmStatic
    fun <T> bind(holder: ViewHolder, callback: AdapterCallback<T>?, t: T?) {
      if (callback != null && t != null) {
        holder.itemView.setOnClickListener { callback.onItemClick(t) }
        holder.itemView.setOnLongClickListener { callback.onItemLongClick(t) }
      }
    }
  }
}