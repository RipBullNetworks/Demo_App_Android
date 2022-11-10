package com.ripbull.ertc.onboard

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.BuildConfig
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.starred.StarredMessagesActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.user.details.UserDetailsActivity
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.dialog_logout.*
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment() {

  private val disposable = CompositeDisposable()
  var user: UserRecord? = null
  private val glide: RequestManager by lazy { Glide.with(this) }

  companion object {
    @JvmStatic
    fun newInstance(): SettingsFragment {
      return SettingsFragment()
    }

    @JvmStatic
    fun tag() = "SettingsFragment"
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_settings, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    loadUI()
  }

  private fun loadUI() {
    if (eRTCSDK.tenant().projectType() == AppConstants.FREE_SAMPLE_APP) {
      llFavMessages.visibility = View.GONE
    }

    llChangePassword.setOnClickListener {
      startActivity(this.activity?.let { it1 ->
        OnBoardingActivity.newIntent(it1, AppConstants.CHANGE_PASSWORD)
      })
    }

    llMyProfile.setOnClickListener {
      startActivity(user?.id?.let { it1 ->
        this.activity?.let { it2 ->
          UserDetailsActivity.getUserDetailIntent(it2, it1)
        }
      })
    }

    llLogout.setOnClickListener {
      showLogOutDialog()
    }

    if (BuildConfig.DEBUG) {
      // do something for a debug build
      //llLoadTesting.visibility = View.VISIBLE
    } else {
      //llLoadTesting.visibility = View.GONE
    }

    llLoadTesting.setOnClickListener {
      startActivity(LoadTestingActivity.getLoadTestingIntent(this.activity!!, user!!.id!!))
    }

    llNotificationSettings.setOnClickListener {
      startActivity(this.activity?.let { it1 ->
        OnBoardingActivity.newIntent(it1, AppConstants.NOTIFICATION_SETTINGS)
      })
    }

    llFavMessages.setOnClickListener {
      startActivity(activity?.let { it -> StarredMessagesActivity.newIntent(it) })
    }

    activity?.let { activity ->
      val session = ApplicationSession(activity)
      setSearchSettings(session.isGlobalSearch())
    }

    cbSearchSettings.setOnClickListener {
      var action = cbSearchSettings.isChecked
      activity?.let { activity ->
        val session = ApplicationSession(activity)
        session.setGlobalSearch(!action)
        setSearchSettings(!action)
      }
    }
  }

  override fun onStart() {
    super.onStart()
    getOnStartDisposable()?.add(
      eRTCSDK.user().loggedInUser
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onUserSuccess,
          this::onUserError
        )
    )
  }

  private fun onUserSuccess(user: UserRecord) {
    this.user = user
    user.name?.let {
      tvProfileName.text = it
    }

    if (user.profilePic != null && user.profilePic!!.isNotEmpty()){
      with(user){
        glide.load(profilePic).into(ivProfilePic)
      }
    } else {
      ivProfilePic.setImageResource(R.drawable.ic_chat_user_default)
    }
  }

  private fun onUserError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  private fun showLogOutDialog() {
    val dialog = activity?.let { Dialog(it) }
    dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog?.setCancelable(false)
    dialog?.setContentView(R.layout.dialog_logout)

    dialog?.btnLogout?.setOnClickListener {
      showProgressbar()
      disposable.add(
        eRTCSDK.user().logout().subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            (activity as BaseActivity).clearSession()
            dismissProgressbar()
          }, {
            dismissProgressbar()
            setErrorAlert(it)
          })
      )
      dialog.dismiss()
    }

    dialog?.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog?.show()
  }

  private fun setSearchSettings(
    isGlobalSearch: Boolean = false
  ) {
    if (isGlobalSearch) {
      cbSearchSettings.isChecked = false
      cbSearchSettings.buttonDrawable = activity?.let { ContextCompat.getDrawable(it, R.drawable.slide_toggle) }
    } else {
      cbSearchSettings.isChecked = true
      cbSearchSettings.buttonDrawable =
        activity?.let { ContextCompat.getDrawable(it, R.drawable.off_slide) }
    }
  }
}