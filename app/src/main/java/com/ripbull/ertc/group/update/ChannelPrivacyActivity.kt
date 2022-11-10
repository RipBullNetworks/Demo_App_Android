package com.ripbull.ertc.group.update

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import kotlinx.android.synthetic.main.activity_channel_privacy.*
import kotlinx.android.synthetic.main.all_toolbar_dark.*

class ChannelPrivacyActivity: BaseActivity() {

  companion object {
    @JvmStatic
    fun getIntent(
      context: Context
    ): Intent {
      return Intent(context, ChannelPrivacyActivity::class.java)
    }

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_channel_privacy)
    setTitleToolBar(getString(R.string.channel_privacy))
    rlToolbar.gravity = Gravity.LEFT
    val param = rlToolbar.layoutParams as ViewGroup.MarginLayoutParams
    param.setMargins(20,0,0,0)
    rlToolbar.layoutParams = param

    rbPublic.isChecked = true
    rbPrivate.isChecked = false

    rbPublic.setOnClickListener {
      rbPublic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.selected, 0, 0, 0)
      rbPrivate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unchecked, 0, 0, 0)
      rbPublic.isChecked = true
      rbPrivate.isChecked = false
      rbPublic.setTextColor(Color.parseColor("#457FCA"))
      rbPrivate.setTextColor(Color.parseColor("#212429"))
    }

    rbPrivate.setOnClickListener {
      rbPublic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unchecked, 0, 0, 0)
      rbPrivate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.selected, 0, 0, 0)
      rbPublic.isChecked = false
      rbPrivate.isChecked = true
      rbPublic.setTextColor(Color.parseColor("#212429"))
      rbPrivate.setTextColor(Color.parseColor("#457FCA"))
    }

    tvPublic.setOnClickListener {
      rbPublic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.selected, 0, 0, 0)
      rbPrivate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unchecked, 0, 0, 0)
      rbPublic.isChecked = true
      rbPrivate.isChecked = false
      rbPublic.setTextColor(Color.parseColor("#457FCA"))
      rbPrivate.setTextColor(Color.parseColor("#212429"))
    }

    tvPrivate.setOnClickListener {
      rbPublic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.unchecked, 0, 0, 0)
      rbPrivate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.selected, 0, 0, 0)
      rbPublic.isChecked = false
      rbPrivate.isChecked = true
      rbPublic.setTextColor(Color.parseColor("#212429"))
      rbPrivate.setTextColor(Color.parseColor("#457FCA"))
    }

    fabNext.setOnClickListener {
      startActivity(GroupActivity.getGroupCreateIntent(ArrayList(), this, rbPrivate.isChecked))
      finish()
    }
  }
}