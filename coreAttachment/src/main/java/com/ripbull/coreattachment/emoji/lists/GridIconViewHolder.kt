package com.ripbull.coreattachment.emoji.lists

import android.content.Context
import android.view.ViewGroup
import com.ripbull.coreattachment.R
import com.ripbull.coreattachment.emoji.icons.IconInGrid
import com.ripbull.coreattachment.emoji.popup.IconActions
import kotlinx.android.synthetic.main.popup_emoji_grid_item.view.*

/**
 * Holder for one icon in a grid
 */
class GridIconViewHolder(
  context: Context,
  parentView: ViewGroup,
  iconActions: IconActions
) : IconViewHolderBase(context, parentView, R.layout.popup_emoji_grid_item, iconActions) {

  /**
   * UI elements must be initialized here
   */
  override fun init(item: IconInGrid) {
    super.init(item)
    itemView.emojiIcon.text = item.icon.toEmoji()
  }
}