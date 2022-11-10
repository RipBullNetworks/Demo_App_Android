package com.ripbull.ertc

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.ripbull.coresdk.Configuration
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.ertc.BuildConfig.VERSION_CODE
import com.ripbull.ertc.BuildConfig.VERSION_NAME
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.onboard.OnBoardingActivity
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

  private val disposable = CompositeDisposable()
  private val handler by lazy { Handler(Looper.getMainLooper()) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)
    val session = ApplicationSession(this)
    /*if(BuildConfig.DEBUG) {
      txtVersion.text = "Version : $VERSION_CODE : $VERSION_NAME"
    }*/

    when {
      AppConstants.IN_GRAM -> {
        imgLogo.setBackgroundResource(R.drawable.ic_banner_ingram)
      }
      AppConstants.BLESS   -> {
        imgLogo.setBackgroundResource(R.drawable.ic_banner_bless)
      }
      AppConstants.WE_WORK   -> {
        imgLogo.setBackgroundResource(R.drawable.ic_banner_we_work_whitelogo)
      }
    }

    if(eRTCSDK.tenant().isUserAuthenticated && session.isLoggedIn())
      authenticated()
    else
      handler.postDelayed({ exitSplash() }, AppConstants.DELAY)
  }

  private fun authenticated(){
    startActivity(MainActivity.newIntent(this))
    finish()
  }

  private fun exitSplash() {
    if (packageName.contains("com.ripbull.ertc")) {
      startActivity(OnBoardingActivity.newIntent(this, AppConstants.SPLASH))
      finish()
    } else {
      //Config builder
      // TODO set your api key here
      val config = Configuration.Builder().context(this).apiKey(getString(R.string.access_token)).build()

      // SDK initialize
      if (config != null) {
        eRTCSDK.initializeWithConfig(config)
        ERTCApplication.getSession(this).setAccessCode(getString(R.string.access_token))
      }

      disposable.add(
        eRTCSDK.tenant().validate("thirdpartyapp_pkg_name")
          .subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
          ).subscribe({
            startActivity(OnBoardingActivity.newIntent(this, AppConstants.LOGIN))
            finish()
          }, {
            setErrorAlert(throwable = it)
            finish()
          })
      )
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
    handler.removeCallbacksAndMessages(null)
  }
}
