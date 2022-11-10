package com.ripbull.ertc.onboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ripbull.coresdk.Configuration
import com.ripbull.coresdk.data.common.Result
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.BuildConfig
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.util.ViewUtil
import com.ripbull.ertc.util.replaceFragment
import com.ripbull.ertc.util.toggleKeyboard
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_name_space.*

class NameSpaceFragment : BaseFragment() {

  private var mViewModel: NameSpaceViewModel? = null

  private val disposable = CompositeDisposable()

  private var error = Error<Throwable>(Error.ErrorCallback { _, _, message ->
    tvError.visibility = View.VISIBLE
    tvError.text = message
    dismissProgressbar()
  })

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_name_space, container, false)
  }

  private fun loadUI() {
    clearAllFields()

    btnValidateName.setOnClickListener {
      val namespace = edtNamespace.text.toString().trim()
      val etAccessCode = edtAccessCode.text.toString().trim()
      if (TextUtils.isEmpty(namespace)) {
        tvError.visibility = View.VISIBLE
        tvError.text = resources.getString(R.string.empty_namespace_validation_message)
        return@setOnClickListener
      } else if (TextUtils.isEmpty(etAccessCode)) {
        tvError.visibility = View.VISIBLE
        tvError.text = resources.getString(R.string.empty_access_code_validation_message)
        return@setOnClickListener
      } else {
        //Config builder
        // TODO set your api key here
        val config = activity?.applicationContext?.let { it1 ->
          Configuration.Builder().context(it1).apiKey(etAccessCode).build()
        }

        // SDK initialize
        if (config != null) {
          eRTCSDK.initializeWithConfig(config)
          val session = activity?.applicationContext?.let { ERTCApplication.getSession(it) }
          session?.setAccessCode(etAccessCode)
        } else return@setOnClickListener
      }

      if (!TextUtils.isEmpty(namespace)) {
        showProgressbar()
        disposable.add(
            eRTCSDK.tenant()
                .validate(namespace)
                .subscribeOn(Schedulers.io())
                .observeOn(
                    AndroidSchedulers.mainThread()
                )
                .subscribe(
                    Consumer<Result> { this.success(it) }, error
                )
        )
      }
    }

    tvGoToAdminPortal.setOnClickListener {
      val url = when (BuildConfig.VERSION_NAME) {
        "-qa" -> {
           "https://qa.inappchat.io/"
        }
        "-Stage" -> {
          "https://stage.inappchat.io/"
        }
        else -> {
          "https://inappchat.io/"
        }
      }
      val i = Intent(Intent.ACTION_VIEW)
      i.data = Uri.parse(url)
      startActivity(i)
    }

    ViewUtil.setGlobalLayoutListener(scrollNameSpace, namespace, btnValidateName)
  }

  private fun clearAllFields() {
    if (BuildConfig.FLAVOR != "dev") {
      edtNamespace.setText("")
      edtAccessCode.setText("")
      }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    loadUI()
  }

  private fun success(result: Result) {

    dismissProgressbar()
    toggleKeyboard(false)
    replaceFragment(R.id.container, LoginFragment.newInstance("", ""))

    tvError.visibility = View.INVISIBLE

  }

  companion object {

    fun newInstance(): NameSpaceFragment {
      return NameSpaceFragment()
    }
  }
}
