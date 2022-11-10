package com.ripbull.coreattachment.emoji.lists.recent

import androidx.recyclerview.widget.DiffUtil
import com.ripbull.coreattachment.emoji.icons.IconInGrid

class EmojiDiffAlg(private val oldList: List<IconInGrid>, private val newList: List<IconInGrid>) :
  DiffUtil.Callback() {

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
    oldList[oldItemPosition].icon == newList[newItemPosition].icon

  override fun getOldListSize(): Int = oldList.size

  override fun getNewListSize(): Int = newList.size

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
    oldList[oldItemPosition].icon.hashCode() == newList[newItemPosition].icon.hashCode()
}