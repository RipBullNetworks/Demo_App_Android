package com.ripbull.ertc.contacts.avatars

import com.ripbull.ertc.contacts.MaterialColor
import java.util.ArrayList
import java.util.Arrays

object UserColors {

  val UNKNOWN_COLOR = MaterialColor.STEEL

  private val CONVERSATION_PALETTE = ArrayList(
      Arrays.asList(
          MaterialColor.PLUM, MaterialColor.CRIMSON, MaterialColor.VERMILLION, MaterialColor.VIOLET,
          MaterialColor.BLUE, MaterialColor.INDIGO, MaterialColor.FOREST, MaterialColor.WINTERGREEN,
          MaterialColor.TEAL, MaterialColor.BURLAP, MaterialColor.TAUPE
      )
  )

  fun generateFor(name: String): MaterialColor {
    return CONVERSATION_PALETTE[Math.abs(name.hashCode()) % CONVERSATION_PALETTE.size]
  }
}
