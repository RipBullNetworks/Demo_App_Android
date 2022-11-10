package com.ripbull.ertc.core

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.ripbull.coresdk.announcement.mapper.AnnouncementRecord
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.SplashActivity
import com.ripbull.ertc.announcement.AnnouncementActivity
import com.ripbull.ertc.auth0.Auth0Manager
import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.ui.ShowImageActivity
import com.ripbull.ertc.ui.VideoPlayerActivity
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.dialog_announcement.*
import kotlinx.android.synthetic.main.progress_dialog.*

/**
 * @author meeth
 */
abstract class BaseActivity : AppCompatActivity() {

  private val logoutDisposable = CompositeDisposable()
  private var onCreateDisposable: CompositeDisposable? = null
  private var onStartDisposable: CompositeDisposable? = null
  private var onResumeDisposable: CompositeDisposable? = null
  private var pDialog: ProgressDialog? = null
  var isEdit = false

  val glide: RequestManager by lazy { Glide.with(this) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    onCreateDisposable = CompositeDisposable()

    val session = applicationContext?.let { ERTCApplication.getSession(it) }
    if (session?.getAccessCode() != null) {
      logoutDisposable.add(
        eRTCSDK.announcement().subscribeToAnnouncement()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
              showAnnouncementDialog(it)
            }
          }, {
            it.printStackTrace()
          })
      )

      logoutDisposable.add(
        eRTCSDK.user().subscribeToLogout()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
              clearSession()
            }
          }, {
            it.printStackTrace()
          })
      )
    }
  }

  override fun onStart() {
    super.onStart()
    onStartDisposable = CompositeDisposable()
  }

  override fun onStop() {
    super.onStop()
    onStartDisposable?.dispose()
  }

  override fun onDestroy() {
    super.onDestroy()
    onCreateDisposable?.dispose()
    logoutDisposable.dispose()
  }

  override fun onResume() {
    super.onResume()
  }

  protected fun getOnCreateDisposable(): CompositeDisposable? {
    return onCreateDisposable
  }

  protected fun getOnStartDisposable(): CompositeDisposable? {
    return onStartDisposable
  }

  protected fun getOnResumeDisposable(): CompositeDisposable? {
    return onResumeDisposable
  }

  protected fun FragmentActivity?.chatToolBar(
    title: String?,
    profilePic: String? = "",
    isGroupThread: Boolean = false,
    isReplyThread: Boolean = false,
    contactCount: Int = 0,
    groupCount: Int = 0): Toolbar {
    val chatToolbar: Toolbar = toolbar
    if (contactCount == 0 && groupCount == 0 ){
      tvTitle.text = title
      if (isReplyThread) {
        imgToolbarDP.visibility = View.GONE
      } else if (profilePic != null && profilePic.isNotEmpty()){
        glide.load(profilePic).into(imgToolbarDP)
      } else {
        if (isGroupThread) {
          imgToolbarDP.setImageResource(R.drawable.ic_group_default)
        } else {
          imgToolbarDP.setImageResource(R.drawable.ic_chat_user_default)
        }
      }
    } else {
      if (groupCount >0 || contactCount >0) {
        var contact=  if (contactCount ==1 ) resources.getString(R.string.contact) else
         resources.getString(R.string.title_contacts)

        var group=  if (groupCount ==1 ) resources.getString(R.string.group) else
         resources.getString(R.string.title_groups)
        var countText = ""
        countText = when {
          groupCount == 0   -> {
            "$contactCount $contact"
          }
          contactCount == 0 -> {
            "$groupCount $group"
          }
          else              -> {
            "$contactCount $contact | $groupCount $group"
          }
        }
        tvTitle.text =countText
      }
    }

    toolbar?.setNavigationIcon(R.drawable.ic_back_toolbar)
    toolbar?.setNavigationOnClickListener {
      this!!.finish()
    }

    return chatToolbar
  }

  protected fun FragmentActivity?.chatToolBarEditFeature(
    title: String?,
    profilePic: String? = "",
    isGroupThread: Boolean = false,
    isReplyThread: Boolean = false): Toolbar {
    val chatToolbar: Toolbar = toolbar
    tvTitle.text = title
    tvSubTitle.visibility = View.INVISIBLE
    if (isReplyThread) {
      imgToolbarDP.visibility = View.GONE
    } else if (profilePic != null && profilePic.isNotEmpty()){
      glide.load(profilePic).into(imgToolbarDP)
    } else {
      if (isGroupThread) {
        imgToolbarDP.setImageResource(R.drawable.ic_group_default)
      } else {
        imgToolbarDP.setImageResource(R.drawable.ic_chat_user_default)
      }
    }

    toolbar?.setNavigationIcon(R.drawable.ic_back_toolbar)

    return chatToolbar
  }

  protected fun FragmentActivity?.setTitleToolBar(title: String): Toolbar {
    val chatToolbar: Toolbar = toolbar
    tvTitle.text = title
    imgToolbarDP.visibility = View.GONE

    toolbar?.setNavigationIcon(R.drawable.ic_back_toolbar)
    toolbar?.setNavigationOnClickListener {
      this!!.finish()
    }

    return chatToolbar
  }

  protected fun FragmentActivity?.searchToolBar(title: String): SearchView {
    val searchToolBar: Toolbar = toolbar
    tvTitle.text = title
    imgToolbarDP.visibility = View.GONE

    searchToolBar.setNavigationIcon(R.drawable.ic_back_toolbar)
    searchToolBar.setNavigationOnClickListener {
      this!!.finish()
    }

    searchToolBar.inflateMenu(R.menu.search_menu)

    val menu: Menu
    menu = searchToolBar.menu
    menu.findItem(R.id.action_starred_messages).isVisible = false
    val mSearch = menu.findItem(R.id.action_search)
    val mSearchView = mSearch.actionView as SearchView

    mSearchView.queryHint = getString(R.string.menu_search)

    val searchTextView = mSearchView.findViewById(androidx.appcompat.R.id.search_src_text) as AutoCompleteTextView
    try {
      searchTextView.setTextColor(resources.getColor(R.color.white))
      searchTextView.setHintTextColor(resources.getColor(R.color.edit_hint))
      val mCursorDrawableRes = TextView::class.java.getDeclaredField("mCursorDrawableRes")
      mCursorDrawableRes.isAccessible = true
      mCursorDrawableRes.set(searchTextView, R.drawable.toolbar_cursor)
    } catch (e: Exception) {
      e.printStackTrace()
    }

    searchToolBar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_search -> {

        }
        else -> {
        }
      }
      true
    }

    return mSearchView
  }

  fun showProgressbar(isVideoCompression: Boolean = false) {
    pDialog = ProgressDialog.show(this,null,null)
    pDialog!!.setContentView(R.layout.progress_dialog)
    if (isVideoCompression) {
      pDialog!!.tvVideoComp.text = getString(R.string.please_wait_video)
    }
    pDialog!!.setCancelable(true)
  }

  fun dismissProgressbar() {
    if (pDialog != null) {
      if (pDialog!!.isShowing()) {
        pDialog!!.dismiss()
      }
    }
  }

  fun setErrorAlert(throwable: Throwable, isToast: Boolean = true) {
    dismissProgressbar()
    throwable.printStackTrace()

    if (throwable.cause != null) {
      if (isToast) {
        if (throwable.cause?.message.isNullOrEmpty()) {
          showToastShort(throwable.message)
        } else {
          showToastShort(throwable.cause?.message)
        }
      }

      if (throwable.cause?.message?.contains(getString(R.string.user_deactivated)) == true) {
        logoutApp()
      }
    } else if (throwable.message != null) {
      if (isToast) {
        showToastShort(throwable.message)
      }

      if (throwable.message?.contains(getString(R.string.user_deactivated)) == true) {
        logoutApp()
      }
    }
  }

  fun logoutApp() {
    showProgressbar()
    logoutDisposable.add(
      eRTCSDK.user().deactivate().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          clearSession()
          dismissProgressbar()
        }, {
          dismissProgressbar()
          it.printStackTrace()
        })
    )
  }

    fun clearSession() {
        Auth0Manager.getInstance(this).clearCredentials()

        val session = ApplicationSession(this)
        session.logoutUser()

        // After logout redirect user to OnBoardingActivity
        val intent = Intent(this, SplashActivity::class.java)
        // Add new Flag to start new Activity
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

        // Staring OnBoard Activity
        startActivity(intent)
        finish()
    }

  private fun showAnnouncementDialog(announcement: AnnouncementRecord) {
    val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar)
    dialog.setCancelable(false)
    dialog.window?.setGravity(Gravity.TOP)
    dialog.setContentView(R.layout.dialog_announcement)
    dialog.window?.setBackgroundDrawableResource(R.color.transparent_black)

    dialog.tvAnnouncement.text = announcement.details
    announcement.name?.let {
      dialog.tvAnnouncementTitle.text = announcement.name
    }

    dialog.tvDismiss.setOnClickListener {
      dialog.dismiss()
    }

    dialog.tvViewFullAnnouncement.setOnClickListener {
      startActivity(AnnouncementActivity.getAnnouncementIntent(
        this, announcement.details, announcement.groupId, announcement.name
      ))
      dialog.dismiss()
    }

    dialog.show()
  }

  fun openImage(msgId: String, path: String?, userId: String?, chatType: String, threadType: String?, createdAt: Long?) {
    startActivity(ShowImageActivity.showImageIntent(
      this, msgId, path, userId, chatType, threadType, createdAt, true
    ))
  }

  fun openVideo(
    msgId: String, path: String?, userId: String?, threadType: String?,
    createdAt: Long?, msgType: String?
  ) {
    startActivity(VideoPlayerActivity.videoPlayerIntent(
      this, msgId, path, userId, threadType, createdAt, msgType
    ))
  }
}