package com.ripbull.coreattachment.emoji.lists

import android.view.ViewGroup
import com.ripbull.coreattachment.emoji.popup.IconActions

class GridIconsAdapter(private val iconActions: IconActions) :
  IconsAdapterBase<GridIconViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridIconViewHolder =
    GridIconViewHolder(parent.context, parent, iconActions)
}