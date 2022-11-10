package com.ripbull.coreattachment.emoji.icons

import com.ripbull.coreattachment.emoji.emojies.Emoji

/**
 * A set of icons
 */
class IconsSet(
  override val icon: Emoji,
  private val icons: List<IconInGrid>
) : GroupIconInGrid {

  override fun getChildIcons(): List<IconInGrid> = icons
}