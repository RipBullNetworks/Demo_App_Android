package com.ripbull.ertc.util.recyclerview

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @author meeth
 */
abstract class BasePagedListAdapter<T, VH : ViewHolder>(diffCallback: DiffUtil.ItemCallback<T>, private val callback: AdapterCallback<T>? = null) :
    PagedListAdapter<T, VH>(diffCallback) {

  override fun onBindViewHolder(holder: VH, position: Int) {
    AdapterBinder.bind(holder, callback, getItem(position))
  }

  override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
    super.onBindViewHolder(holder, position, payloads)
    AdapterBinder.bind(holder, callback, getItem(position))
  }
}