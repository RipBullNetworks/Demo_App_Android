package com.ripbull.ertc.onboard

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.ripbull.coresdk.core.type.AccountDetails
import com.ripbull.coresdk.data.common.Result
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.R
import com.ripbull.ertc.SplashActivity
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.util.toggleKeyboard
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_change_pwd.btnAction
import kotlinx.android.synthetic.main.fragment_change_pwd.confirmPassword
import kotlinx.android.synthetic.main.fragment_change_pwd.newPassword
import kotlinx.android.synthetic.main.fragment_change_pwd.oldPassword
import kotlinx.android.synthetic.main.fragment_change_pwd.tvErrorMsg

class ChangePwdFragment : BaseFragment() {

  private var mViewModel: NameSpaceViewModel? = null

  private val disposable = CompositeDisposable()

  private var error = Error<Throwable>(Error.ErrorCallback { _, _, message ->
    tvErrorMsg.visibility= View.VISIBLE
    tvErrorMsg.text=message
    dismissProgressbar()
  })

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    chatToolBar(activity?.getString(R.string.change_password))
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_change_pwd, container, false)
  }

  private fun loadUI() {
    btnAction.setOnClickListener {
      toggleKeyboard(false)
      val oldPassword = oldPassword!!.text.toString()
      val newPassword = newPassword!!.text.toString()
      val confirmNewPassword = confirmPassword!!.text.toString()

      when {
        TextUtils.isEmpty(oldPassword) -> {
          tvErrorMsg.text = getString(R.string.cp_old_password_empty)
          tvErrorMsg.visibility = View.VISIBLE
          return@setOnClickListener
        }
        TextUtils.isEmpty(newPassword) -> {
          tvErrorMsg.text = getString(R.string.cp_new_password_empty)
          tvErrorMsg.visibility = View.VISIBLE
          return@setOnClickListener
        }
        oldPassword == newPassword -> {
          tvErrorMsg.text = getString(R.string.cp_old_and_new_password_are_same)
          tvErrorMsg.visibility = View.VISIBLE
          return@setOnClickListener
        }
        newPassword.length < 8 -> {
          tvErrorMsg.text = getString(R.string.new_password_length)
          tvErrorMsg.visibility = View.VISIBLE
          return@setOnClickListener
        }
        TextUtils.isEmpty(confirmNewPassword) -> {
          tvErrorMsg.text = getString(R.string.cp_confirm_new_password_empty)
          tvErrorMsg.visibility = View.VISIBLE
          return@setOnClickListener
        }
        newPassword != confirmNewPassword -> {
          tvErrorMsg.text = getString(R.string.cp_new_and_confirm_password_are_not_same)
          tvErrorMsg.visibility = View.VISIBLE
          return@setOnClickListener
        }
      }

      if (oldPassword != newPassword) {
        showProgressbar()
        disposable.add(
          eRTCSDK.tenant().changePassword(
            AccountDetails.changePwd(
              oldPassword, newPassword
            )
          ).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
          ).subscribe(
            Consumer<Result> { this.success(it) }, error
          )
        )
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  override fun onViewCreated(
    view: View, savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    loadUI()
  }

  private fun success(result: Result) {
    dismissProgressbar()
    val toast: Toast = Toast.makeText(activity, getString(R.string.change_password_success), Toast.LENGTH_SHORT)
    val toastMessage = toast.view?.findViewById(android.R.id.message) as TextView
    toast.view?.setBackgroundColor(Color.WHITE)
    activity?.let {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        toastMessage.setTextColor(it.getColor(R.color.green_toast))
      } else {
        toastMessage.setTextColor(Color.GREEN)
      }
    }
    toast.show()

    //Call a function to logout from all devices.
    showProgressbar()
    disposable.add(
      eRTCSDK.tenant()
        .logoutOtherDevices()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          dismissProgressbar()
          val session = activity?.applicationContext?.let { it1 -> ApplicationSession(it1) }
          session?.logoutUser()

          // After logout redirect user to OnBoardingActivity
          val intent = Intent(activity, SplashActivity::class.java)
          // Add new Flag to start new Activity
          intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

          // Staring OnBoard Activity
          activity?.startActivity(intent)
          activity?.finish()
        }, {
          dismissProgressbar()
          setErrorAlert(it)
        })
    )
  }

  companion object {

    fun newInstance(): ChangePwdFragment {
      return ChangePwdFragment()
    }
  }
}
