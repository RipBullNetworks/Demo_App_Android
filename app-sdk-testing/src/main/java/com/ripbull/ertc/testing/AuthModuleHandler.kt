package com.ripbull.ertc.testing

import android.annotation.SuppressLint
import android.widget.Toast
import com.ripbull.coresdk.core.type.AccountDetails
import com.ripbull.coresdk.data.common.Result
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.tenant.AuthConfig
import com.ripbull.coresdk.utils.Error
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by DK on 16/01/21.
 */

interface AuthModuleListener{
}
class AuthModuleHandler(
  private val disposable: CompositeDisposable,
  private val context : MainActivity,
  private val authModuleListener: AuthModuleListener,) {



  // on-boarding ===========================
  fun nameSpace(namespace: String) {
    disposable.add(
      eRTCSDK.tenant().validate(namespace)
        .subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          {
            logt(value = "Namespace validation success")
            success(it)
          }, error
        )
    )
  }

  fun connect() {
    val payload = "{\"data\":{\"header\":" +
        " {" +
        "\"key\": \"220492hb22fe342a41370e16c1510ab9867031516bh1322\"" +
        "}," +
        "\"body\": " +
        "{" +
        "\"email\": \"mayank.kmphasis@gmail.com\"," +
        "\"token\": \"e10adc3949ba59abbe56e057f20f883e\"" +
        "}" +
        "}}"

    val payload1 =
      "{\"data\":{\"header\":{\"key\":\"220492hb22fe342a41370e16c1510ab9867031516bh1322\"},\"body\":{\"email\":\"mayank.kmphasis@gmail.com\",\"token\":\"e10adc3949ba59abbe56e057f20f883e\"}}}"

    val build = AuthConfig.Builder().fcmToken("NO TOKEN YET").payload(payload1).build()
    disposable.add(
      eRTCSDK.tenant().connect(AccountDetails.singleSignOn("3209", build)) //3209 //1001
        .subscribeOn(Schedulers.io())
        .observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          {
            logt(value = "Third party app connected :  success")
            success(it)
          }, error
        )
    )
  }

  fun login(username: String, password: String) {
    disposable.add(
      eRTCSDK.tenant().login(AccountDetails.username(username, password))
        .subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe({
          logt(value = "Login success!")
          val session = ERTCTestApplication.getSession(context)
          session.createLoginSession()
          session.setUserId(username)
          this.success(it)
        }, error)
    )

  }

  fun logout() {
    disposable.add(
      eRTCSDK.user().logout().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          this.success(it)

        }, {
          it.printStackTrace()
        })
    )
  }

  fun changePassword(oldPassword: String, newPassword: String) {
    disposable.add(
      eRTCSDK.tenant().changePassword(
        AccountDetails.changePwd(
          oldPassword, newPassword
        )
      ).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe(
        { this.success(it) }, error
      )
    )

  }

  fun forgotPassword(email: String) {
    disposable.add(
      eRTCSDK.tenant().forgotPassword(AccountDetails.forgotPwd(email))
        .subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          { this.success(it) }, error
        )
    )
  }

  private fun success(result: Result) {
    Toast.makeText(context, "" + result, Toast.LENGTH_LONG).show()
  }

  private var error = Error<Throwable> { _, _, message ->
    Toast.makeText(context, "error: $message", Toast.LENGTH_LONG).show()
  }

  fun removeProfilePic() {
    disposable.add(
      eRTCSDK.user().removeProfilePic()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          // result ->
          this.success(it)
        }, { _ ->
          error
        })
    )
  }

  @SuppressLint("TimberArgCount")
  private fun logt(tag: String? = "Auth Module", value: String? = "log result") {
    Timber.d(tag, value)
  }
}