package com.ripbull.coreattachment.emoji.icons

interface GroupIconInGrid : IconInGrid {

  fun getChildIcons(): List<IconInGrid>
}