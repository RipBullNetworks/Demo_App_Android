package com.ripbull.ertc.core

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.utils.Error
import com.ripbull.ertc.R
import com.ripbull.ertc.SplashActivity
import com.ripbull.ertc.chat.search.SearchHistoryActivity
import com.ripbull.ertc.chat.starred.StarredMessagesActivity
import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.util.hideKeyBoard
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.all_toolbar_dark.tvTitle

/**
 * @author meeth
 */
abstract class BaseFragment : Fragment() {

  private val logoutDisposable = CompositeDisposable()
  private var onCreateDisposable: CompositeDisposable? = null
  private var onStartDisposable: CompositeDisposable? = null
  private var onResumeDisposable: CompositeDisposable? = null
  private val glide: RequestManager by lazy { Glide.with(this) }
  private var pDialog: ProgressDialog? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = super.onCreateView(inflater, container, savedInstanceState)
    onCreateDisposable = CompositeDisposable()
    return view
  }

  override fun onStart() {
    super.onStart()
    onStartDisposable = CompositeDisposable()
  }

  override fun onStop() {
    super.onStop()
    onStartDisposable?.dispose()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    onCreateDisposable?.dispose()
    logoutDisposable.dispose()
  }

  protected fun getOnCreateDisposable() : CompositeDisposable? {
    return onCreateDisposable
  }

  protected fun getOnStartDisposable() : CompositeDisposable? {
    return onStartDisposable
  }

  protected fun getOnResumeDisposable() : CompositeDisposable? {
    return onResumeDisposable
  }

  protected fun searchToolBar(title: String, isStarredMenu: Boolean = false, isHomeEnabled: Boolean = false): SearchView {
    val toolbar : Toolbar = toolbar
    tvTitle.text = title
    imgToolbarDP.visibility = View.GONE
    rlToolbar.gravity = Gravity.LEFT
    if (isHomeEnabled) {
      toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
      toolbar.setNavigationOnClickListener {
        activity?.onBackPressed()
      }
    } else {
      tvTitle.setPadding(50, 0, 0, 0)
    }

    toolbar.inflateMenu(R.menu.search_menu)

    val menu: Menu
    menu = toolbar.menu
    if (!isStarredMenu){
      menu.findItem(R.id.action_starred_messages).isVisible = false
    }
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

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_search -> {
          if (isStarredMenu) {
            startActivity(activity?.let { it1 -> SearchHistoryActivity.newIntent(it1) })
            hideKeyBoard(searchTextView)
            it.collapseActionView()
          }
        }
        R.id.action_starred_messages -> {
          startActivity(activity?.let { it1 -> StarredMessagesActivity.newIntent(it1) })
        }
        else -> {
        }
      }
      true
    }

    return mSearchView
  }

  protected fun chatToolBar(title: String?, profilePic: String? = ""): Toolbar {
    val chatToolbar : Toolbar = toolbar
    rlToolbar.gravity = Gravity.LEFT
    tvTitle.text = title

    if (profilePic != null && profilePic.isNotEmpty()){
      glide.load(profilePic).into(imgToolbarDP)
    } else {
      imgToolbarDP.visibility = View.GONE
    }

    toolbar?.setNavigationIcon(R.drawable.ic_back_toolbar)
    toolbar?.setNavigationOnClickListener {
      activity?.finish()
    }

    return chatToolbar
  }

  protected fun channelSearchToolBar(title: String): SearchView {
    val toolbar : Toolbar = toolbar
    tvTitle.text = title
    imgToolbarDP.visibility = View.GONE

    toolbar.inflateMenu(R.menu.create_channel_menu)

    val menu: Menu
    menu = toolbar.menu
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

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_search -> {

        }
        else -> {
        }
      }
      true
    }

    toolbar.setNavigationIcon(R.drawable.ic_back_toolbar)
    toolbar.setNavigationOnClickListener {
      activity?.finish()
    }

    return mSearchView
  }

  fun showProgressbar() {
    pDialog = ProgressDialog.show(activity,null,null)
    pDialog!!.setContentView(R.layout.progress_dialog)
    pDialog!!.setCancelable(false)
  }

  fun dismissProgressbar() {
    if (pDialog != null) {
      if (pDialog!!.isShowing()) {
        pDialog!!.dismiss()
      }
    }
  }

  fun setErrorAlert(throwable: Throwable) {
    dismissProgressbar()
    throwable.message?.let {
      activity?.showToastShort(it)
    }
    throwable.printStackTrace()
  }

  var sdkError = Error<Throwable>(Error.ErrorCallback { code, _, message ->
    activity?.showToastShort(message)
    if (code == 403) {
      logoutApp()
    }
  })

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
    activity?.applicationContext?.let {
      val session = ApplicationSession(it)
      session.logoutUser()
    }

    // After logout redirect user to OnBoardingActivity
    val intent = Intent(activity, SplashActivity::class.java)
    // Add new Flag to start new Activity
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

    // Staring OnBoard Activity
    startActivity(intent)
    activity?.finish()
  }
}