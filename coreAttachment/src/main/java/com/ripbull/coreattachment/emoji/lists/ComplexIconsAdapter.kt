package com.ripbull.coreattachment.emoji.lists

import android.view.ViewGroup
import com.ripbull.coreattachment.emoji.popup.IconActions

class ComplexIconsAdapter(private val iconActions: IconActions) :
  IconsAdapterBase<ComplexIconViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComplexIconViewHolder =
    ComplexIconViewHolder(parent.context, parent, iconActions)
}