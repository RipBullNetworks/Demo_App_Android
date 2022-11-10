package com.ripbull.coreattachment.emoji.popup

import com.ripbull.coreattachment.emoji.dto.TouchPoint
import com.ripbull.coreattachment.emoji.icons.IconInGrid

/**
 * Actions from icons
 */
interface IconActions {

  fun onIconClick(icon: IconInGrid, touchPoint: TouchPoint)
}