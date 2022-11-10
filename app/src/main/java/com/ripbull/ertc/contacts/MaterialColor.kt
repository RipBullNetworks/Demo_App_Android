package com.ripbull.ertc.contacts

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.ripbull.ertc.R
import java.util.HashMap

enum class MaterialColor private constructor(
  @param:ColorRes @field:ColorRes private val mainColor: Int,
  @param:ColorRes @field:ColorRes private val tintColor: Int,
  @param:ColorRes @field:ColorRes private val shadeColor: Int,
  private val serialized: String
) {
  CRIMSON(
    R.color.conversation_crimson,
    R.color.conversation_crimson_tint,
    R.color.conversation_crimson_shade,
    "red"
  ),
  VERMILLION(
    R.color.conversation_vermillion,
    R.color.conversation_vermillion_tint,
    R.color.conversation_vermillion_shade,
    "orange"
  ),
  BURLAP(
    R.color.conversation_burlap,
    R.color.conversation_burlap_tint,
    R.color.conversation_burlap_shade,
    "brown"
  ),
  FOREST(
    R.color.conversation_forest,
    R.color.conversation_forest_tint,
    R.color.conversation_forest_shade,
    "green"
  ),
  WINTERGREEN(
    R.color.conversation_wintergreen,
    R.color.conversation_wintergreen_tint,
    R.color.conversation_wintergreen_shade,
    "light_green"
  ),
  TEAL(
    R.color.conversation_teal,
    R.color.conversation_teal_tint,
    R.color.conversation_teal_shade,
    "teal"
  ),
  BLUE(
    R.color.conversation_blue,
    R.color.conversation_blue_tint,
    R.color.conversation_blue_shade,
    "blue"
  ),
  INDIGO(
    R.color.conversation_indigo,
    R.color.conversation_indigo_tint,
    R.color.conversation_indigo_shade,
    "indigo"
  ),
  VIOLET(
    R.color.conversation_violet,
    R.color.conversation_violet_tint,
    R.color.conversation_violet_shade,
    "purple"
  ),
  PLUM(
    R.color.conversation_plumb,
    R.color.conversation_plumb_tint,
    R.color.conversation_plumb_shade,
    "pink"
  ),
  TAUPE(
    R.color.conversation_taupe,
    R.color.conversation_taupe_tint,
    R.color.conversation_taupe_shade,
    "blue_grey"
  ),
  STEEL(
    R.color.conversation_steel,
    R.color.conversation_steel_tint,
    R.color.conversation_steel_shade,
    "grey"
  ),
  GROUP(
    R.color.conversation_group,
    R.color.conversation_group_tint,
    R.color.conversation_group_shade,
    "blue"
  );

  @ColorInt
  fun toConversationColor(context: Context): Int {
    return ContextCompat.getColor(context, mainColor)
  }

  @ColorInt
  fun toAvatarColor(context: Context): Int {
    return ContextCompat.getColor(context, mainColor)
  }

  @ColorInt
  fun toActionBarColor(context: Context): Int {
    return ContextCompat.getColor(context, mainColor)
  }

  @ColorInt
  fun toStatusBarColor(context: Context): Int {
    return ContextCompat.getColor(context, shadeColor)
  }

  fun represents(
    context: Context, colorValue: Int
  ): Boolean {
    return ContextCompat.getColor(context, mainColor) == colorValue || context.resources.getColor(
      tintColor
    ) == colorValue || ContextCompat.getColor(context, shadeColor) == colorValue
  }

  fun serialize(): String {
    return serialized
  }

  class UnknownColorException(message: String) : Exception(message)

  companion object {

    private val COLOR_MATCHES = object : HashMap<String, MaterialColor>() {
      init {
        put("red", CRIMSON)
        put("deep_orange", CRIMSON)
        put("orange", VERMILLION)
        put("amber", VERMILLION)
        put("brown", BURLAP)
        put("yellow", BURLAP)
        put("pink", PLUM)
        put("purple", VIOLET)
        put("deep_purple", VIOLET)
        put("indigo", INDIGO)
        put("blue", BLUE)
        put("light_blue", BLUE)
        put("cyan", TEAL)
        put("teal", TEAL)
        put("green", FOREST)
        put("light_green", WINTERGREEN)
        put("lime", WINTERGREEN)
        put("blue_grey", TAUPE)
        put("grey", STEEL)
        put("group_color", GROUP)
      }
    }

    @Throws(MaterialColor.UnknownColorException::class)
    fun fromSerialized(serialized: String): MaterialColor? {
      if (COLOR_MATCHES.containsKey(serialized)) {
        return COLOR_MATCHES[serialized]
      }

      throw UnknownColorException("Unknown color: $serialized")
    }
  }
}
