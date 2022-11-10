package com.ripbull.coreattachment.emoji.icons

import com.ripbull.coreattachment.emoji.emojies.Emoji

/**
 * Set of relative icons (for example a man with various skin colors)
 */
class ComplexIcon(private val icons: List<IconInGrid>) : GroupIconInGrid {

  override val icon: Emoji
    get() = icons[0].icon

  override fun getChildIcons(): List<IconInGrid> = icons
}