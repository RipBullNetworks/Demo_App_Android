package com.ripbull.ertc.util

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout

public class ForwardTagUtil {

  companion object{
    public fun setForwardTagMedia(context: Context, isIncoming: Boolean, ivSendImage: AppCompatImageView,
                                  rlSendImage: RelativeLayout, ivForwardTag: View,
                                  tvForwardTag: AppCompatTextView, isForwardMessage: Boolean) {
      val layout = FrameLayout.LayoutParams(convertDpToPixel(244f, context), FrameLayout.LayoutParams.MATCH_PARENT)
      val imageViewParams = ConstraintLayout.LayoutParams(
        ConstraintLayout.LayoutParams.MATCH_PARENT,
        ConstraintLayout.LayoutParams.MATCH_PARENT)
      val margin = convertDpToPixel(8f, context)
      if (isIncoming){
        layout.setMargins(margin, 0, 0, 0)
      }else{
        layout.setMargins(0, 0, margin, 0)
      }

      if (isForwardMessage) {
        val padding = convertDpToPixel(10f, context)
        val margin1 = convertDpToPixel(15f, context)

        imageViewParams.setMargins(margin1, margin1, margin1, margin1)
        rlSendImage.layoutParams = layout
        ivSendImage.layoutParams = imageViewParams
        rlSendImage.setPadding(padding, padding, 0 ,0)
        tvForwardTag.visibility = View.VISIBLE
        ivForwardTag.visibility = View.VISIBLE
      } else {
        val padding = convertDpToPixel(2f, context)
        rlSendImage.setPadding(padding, padding, padding ,padding)
        rlSendImage.layoutParams = layout
        ivSendImage.layoutParams = imageViewParams
        tvForwardTag.visibility = View.GONE
        ivForwardTag.visibility = View.GONE
      }
    }

    private fun convertDpToPixel(dp: Float,context: Context): Int{
      return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.resources.displayMetrics).toInt()
    }
  }

}