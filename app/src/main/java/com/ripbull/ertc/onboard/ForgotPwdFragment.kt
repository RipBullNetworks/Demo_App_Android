package com.ripbull.ertc.onboard

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ripbull.coresdk.core.type.AccountDetails
import com.ripbull.coresdk.data.common.Result
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.util.ViewUtil
import com.ripbull.ertc.util.replaceFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_forgot_pwd.*
import kotlinx.android.synthetic.main.fragment_forgot_pwd.btnAction
import kotlinx.android.synthetic.main.fragment_forgot_pwd.tvError
import kotlinx.android.synthetic.main.fragment_forgot_pwd.txtMoveBack
import kotlinx.android.synthetic.main.fragment_forgot_pwd.username

class ForgotPwdFragment : BaseFragment() {

  private var mViewModel: NameSpaceViewModel? = null

  private val disposable = CompositeDisposable()

  private var error = Error<Throwable>(Error.ErrorCallback { _, _, message ->
    tvError.visibility= View.VISIBLE
    tvError.text=message
    dismissProgressbar()
  })

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_forgot_pwd, container, false)
  }

  private fun loadUI() {
    btnAction.setOnClickListener {
      val namespace = username!!.text.toString().trim()
      if (!TextUtils.isEmpty(namespace)) {
        showProgressbar()
        disposable.add(
          eRTCSDK.tenant().forgotPassword(AccountDetails.forgotPwd(namespace))
            .subscribeOn(Schedulers.io()).observeOn(
              AndroidSchedulers.mainThread()
            ).subscribe(Consumer<Result> { this.success(it) }, error
          )
        )
      } else {
        tvError.visibility= View.VISIBLE
        tvError.text=activity!!.resources.getString(R.string.empty_username_validation_message)
      }
    }
    txtMoveBack.setOnClickListener {
      replaceFragment(
        R.id.container,
        LoginFragment.newInstance("", "")
      )
    }

    ViewUtil.setGlobalLayoutListener(scrollForgetPassword, forgetPassword, btnAction)
  }

  override fun onViewCreated(
    view: View, savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    loadUI()
  }

  private fun success(result: Result) {
    dismissProgressbar()

    replaceFragment(R.id.container, LoginFragment.newInstance("", ""))

    tvError.visibility= View.INVISIBLE
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  companion object {

    fun newInstance(): ForgotPwdFragment {
      return ForgotPwdFragment()
    }
  }
}
