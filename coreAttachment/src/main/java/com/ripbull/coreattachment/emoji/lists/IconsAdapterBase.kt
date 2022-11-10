package com.ripbull.coreattachment.emoji.lists

import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coreattachment.emoji.icons.IconInGrid

abstract class IconsAdapterBase<TH : IconViewHolderBase> : RecyclerView.Adapter<TH>() {
  protected var items = listOf<IconInGrid>()

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: TH, position: Int) = holder.init(items[position])

  override fun onViewRecycled(holder: TH) = holder.release()

  open fun updateData(data: List<IconInGrid>) {
    items = data.filter { it.icon.isValid() }

    notifyDataSetChanged()
  }
}