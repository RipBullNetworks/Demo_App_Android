package com.ripbull.coreattachment.emoji.lists.recent

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.ripbull.coreattachment.emoji.icons.IconInGrid
import com.ripbull.coreattachment.emoji.lists.IconsAdapterBase
import com.ripbull.coreattachment.emoji.popup.IconActions

class RecentIconsAdapter(private val iconActions: IconActions) :
  IconsAdapterBase<RecentIconViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentIconViewHolder =
    RecentIconViewHolder(parent.context, parent, iconActions)

  override fun updateData(data: List<IconInGrid>) {
    val newItems = data.filter { it.icon.isValid() }

    val diffCallback = EmojiDiffAlg(items, newItems)
    val diffResult = DiffUtil.calculateDiff(diffCallback)

    items = newItems
    diffResult.dispatchUpdatesTo(this)
  }
}