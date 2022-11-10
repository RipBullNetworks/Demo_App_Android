package com.ripbull.ertc.util.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * @author meeth
 */
abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder>(private val mutableList: MutableList<T>, private val callback: AdapterCallback<T>?) :
    RecyclerView.Adapter<VH>() {

  override fun onBindViewHolder(holder: VH, position: Int) {
    AdapterBinder.bind(holder, callback, mutableList, position)
  }

  override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
    super.onBindViewHolder(holder, position, payloads)
    AdapterBinder.bind(holder, callback, mutableList, position)
  }

  final override fun getItemCount() = mutableList.size

  fun getItem(position: Int): T {
    return mutableList[position]
  }

  fun submitList(list: List<T>) {
    mutableList.clear()
    mutableList.addAll(list)
    notifyDataSetChanged()
  }
}