package com.ripbull.ertc.onboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.ripbull.coresdk.UserConfiguration
import com.ripbull.coresdk.core.type.AccountDetails
import com.ripbull.coresdk.data.common.Result
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.BuildConfig
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.auth0.Auth0Manager
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.restore.RestoreChatActivity
import com.ripbull.ertc.util.ViewUtil
import com.ripbull.ertc.util.replaceFragment
import com.ripbull.ertc.util.toggleKeyboard
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber

class LoginFragment : BaseFragment() {

  private var mParam1: String? = null
  private var mParam2: String? = null

  private var mListener: OnFragmentInteractionListener? = null

  private val disposable = CompositeDisposable()
  private val auth0Manager by lazy { Auth0Manager.getInstance(requireContext()) }

  private var error = Error<Throwable> { _, _, message ->
    tvError.visibility = View.VISIBLE
    tvError.text = message
    dismissProgressbar()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (arguments != null) {
      mParam1 = arguments?.getString(ARG_PARAM1)
      mParam2 = arguments?.getString(ARG_PARAM2)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(
    view: View, savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    //create FCM token and store it to server.
    eRTCSDK.registerFCMToServer()
    loadUI()
  }

  private fun loadUI() {
    btnAuth0Login.setOnClickListener {
      loginWithBrowser()
    }
    btnAction.setOnClickListener {
      toggleKeyboard(false)
      //initializeWithConfigUser()
      val username = username.text.toString().trim()
      val password = password.text.toString()
      when {
        TextUtils.isEmpty(username) -> tvError.text = (getString(R.string.username_mandatory))
        TextUtils.isEmpty(password) -> tvError.text = (getString(R.string.password_mandatory))
        else                        -> {
          showProgressbar()
          disposable.add(
            eRTCSDK.tenant().login(AccountDetails.username(username, password))
              .subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
              ).subscribe({ this.success(it, username) }, error)
          )
        }
      }
    }

    tvForgotPassword.setOnClickListener {
      replaceFragment(R.id.container, ForgotPwdFragment.newInstance())
    }

    txtMoveBack.setOnClickListener {
      replaceFragment(R.id.container, NameSpaceFragment.newInstance())
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

    ViewUtil.setGlobalLayoutListener(scrollLogin, login, btnAction)
  }

  private fun loginWithBrowser() {
    auth0Manager.login(requireActivity(), onSuccess = {
      showUserProfile(it)
    }) {
      Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
    }
  }

  private fun showUserProfile(credentials: Credentials) {
    auth0Manager.showUserProfile(credentials, onError = {
      Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
    }, onSuccess = {
      activeUserAndSyncWithERTCSDK(it, credentials)
    })
  }

  private fun activeUserAndSyncWithERTCSDK(
    result: UserProfile,
    credentials: Credentials
  ) {
    showProgressbar()
    val userConfiguration = UserConfiguration.Builder()
      .appUserId(result.email ?: "")
      .name(result.nickname ?: "")
      .accessToken(credentials.idToken)
      .refreshToken(credentials.refreshToken ?: credentials.accessToken)
      .userId(result.getExtraInfo()["mongoId"] as? String ?: "")
      .profilePic(result.pictureURL ?: "")
      .loginType("email")
      .build()

    disposable.add(
      eRTCSDK.tenant().configureUser(userConfiguration)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          dismissProgressbar()
          activity?.applicationContext?.let {
            ERTCApplication.getSession(it)
              .createLoginSession(result.name ?: result.givenName ?: "")
          }
          startActivity(RestoreChatActivity.newIntent(requireContext()))
          //activity?.startService(UserListSyncService.newIntent(requireContext()))
          activity?.finish()
        }, {
          dismissProgressbar()
          Timber.e(it)
          Toast.makeText(context, it.message ?: "", Toast.LENGTH_SHORT).show()
        })

    )
  }
  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  private fun success(result: Result, username: String) {
    dismissProgressbar()
    activity?.applicationContext?.let { ERTCApplication.getSession(it).createLoginSession(username) }
    tvError.visibility = View.INVISIBLE
    startActivity(RestoreChatActivity.newIntent(requireContext()))
    //activity?.startService(UserListSyncService.newIntent(requireContext()))
    activity?.finish()
  }

  fun onButtonPressed(uri: Uri) {
    if (mListener != null) {
      mListener!!.onFragmentInteraction(uri)
    }
  }

  private fun initializeWithConfigUser() {
    //User Config builder
    // TODO set User details and token here
    val userConfig = activity?.let {
      UserConfiguration.Builder()
        .context(it.applicationContext)
        .name("Sagar")
        .status("enabled")
        .loginType("email")
        .profilePic("")
        .profilePicThumb("")
        .profileStatus("I am using eRTC")
        .appState("active")
        .appUserId("sagar@ertc.com")
        .userId("6270c512380e810013571d54")
        .accessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MjcwYzUxMjM4MGU4MTAwMTM1NzFkNTQiLCJzY29wZXMiOlsiY2hhdCJdLCJyb2xlcyI6WyJ1c2VyIl0sImdyYW50VHlwZSI6InBsYXRmb3JtIiwiYWNjb3VudElkIjoiNjI1ZDUyZjljMmI1MDYwNmU5YmRiYzA0IiwiaWF0IjoxNjUxNTcxNjI0LCJleHAiOjE2NTE1NzUyMjR9.0S25uO9tQ3rUlRM4VUHL_DGyo-6oU7Ng8dKK3CTcd9E")
        .refreshToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MjcwYzUxMjM4MGU4MTAwMTM1NzFkNTQiLCJzY29wZXMiOlsiY2hhdCJdLCJyb2xlcyI6WyJ1c2VyIl0sImdyYW50VHlwZSI6InBsYXRmb3JtIiwiYWNjb3VudElkIjoiNjI1ZDUyZjljMmI1MDYwNmU5YmRiYzA0IiwiaWF0IjoxNjUxNTcxNjI0LCJleHAiOjE2NTI4Njc2MjR9.l-D4LpBW9V4iFrOOmV7DFMT_BjqcpAIyZJwWwpTx7no")
        .build()
    }

    // SDK initialize
    if (userConfig != null){
      showProgressbar()
      disposable.add(eRTCSDK.tenant()
        .configureUser(userConfig)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          dismissProgressbar()
          activity?.applicationContext?.let { ERTCApplication.getSession(it).createLoginSession("sagar@ertc.com") }
          tvError.visibility = View.INVISIBLE
          startActivity(RestoreChatActivity.newIntent(requireContext()))
          //activity?.startService(UserListSyncService.newIntent(requireContext()))
          activity!!.finish()
        }, {
          dismissProgressbar()
          setErrorAlert(it)
        })
      )
    }
  }

  override fun onDetach() {
    super.onDetach()
    mListener = null
  }

  interface OnFragmentInteractionListener {
    fun onFragmentInteraction(uri: Uri)
  }

  companion object {
    private const val ARG_PARAM1 = "param1"
    private const val ARG_PARAM2 = "param2"

    fun newInstance(param1: String, param2: String): LoginFragment {
      val fragment = LoginFragment()
      val args = Bundle()
      args.putString(ARG_PARAM1, param1)
      args.putString(ARG_PARAM2, param2)
      fragment.arguments = args
      return fragment
    }
  }
} // Required empty public constructor
