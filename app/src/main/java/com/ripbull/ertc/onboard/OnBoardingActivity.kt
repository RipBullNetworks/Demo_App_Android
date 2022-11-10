package com.ripbull.ertc.onboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ripbull.ertc.R
import com.ripbull.ertc.util.AppConstants

class OnBoardingActivity : AppCompatActivity() {

  companion object {
    @JvmStatic
    fun newIntent(context: Context, eventType: String) : Intent {
      val intent = Intent(context, OnBoardingActivity::class.java)
      intent.putExtra(AppConstants.EVENT_TYPE, eventType)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_on_boarding)

    when (intent.getStringExtra(AppConstants.EVENT_TYPE)) {
      AppConstants.CHANGE_PASSWORD       -> {
        supportFragmentManager.beginTransaction()
          .replace(R.id.container, ChangePwdFragment.newInstance())
          .commitNow()
      }
      AppConstants.SPLASH                -> {
        supportFragmentManager.beginTransaction()
          .replace(R.id.container, NameSpaceFragment.newInstance())
          .commitNow()
      }
      AppConstants.NOTIFICATION_SETTINGS -> {
        supportFragmentManager.beginTransaction()
          .replace(R.id.container, NotificationsSettingFragment.newInstance())
          .commitNow()
      }
      AppConstants.LOGIN                -> {
        supportFragmentManager.beginTransaction()
          .replace(R.id.container,  LoginFragment.newInstance("", ""))
          .commitNow()
      }
    }
  }
}
