package com.ripbull.ertc.chat.gallery.forward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_select_contact.*

/**
 * @author Sagar
 */
class SelectMediaContactFragment : BaseFragment(), SelectMediaContactAdapter.SelectMediaContactAdapterListener {

  companion object {
    @JvmStatic
    fun newInstance(): SelectMediaContactFragment {
      return SelectMediaContactFragment()
    }

    @JvmStatic
    fun tag() = "SelectMediaContactFragment"

    var selectContactAdapter: SelectMediaContactAdapter? = null
  }

  private val glide by lazy { GlideApp.with(this) }
  private val disposable = CompositeDisposable()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_select_contact, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    rvContactList.layoutManager = LinearLayoutManager(context)
    rvContactList.itemAnimator = DefaultItemAnimator()

  }

  override fun onStart() {
    super.onStart()
    loadUsers()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  private fun loadUsers() {
    getOnStartDisposable()?.add(
      eRTCSDK.user().chatUsers.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribe(
          this::onUserListSuccess, this::onUserListError
        )
    )
  }

  private fun onUserListSuccess(userList: List<UserRecord>) {
    if (userList.isNullOrEmpty()) {
      rvContactList.visibility = View.GONE
      tvNoContact.visibility = View.VISIBLE
      return
    }

    val unblockedUserList = ArrayList<UserRecord>()
    for (user in userList) {
      if (user.blockedStatus != AppConstants.USER_BLOCKED) {
        unblockedUserList.add(user)
      }
    }
    rvContactList.visibility = View.VISIBLE
    tvNoContact.visibility = View.GONE
    selectContactAdapter = SelectMediaContactAdapter(unblockedUserList, glide, this)
    rvContactList.adapter = selectContactAdapter
  }

  private fun onUserListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onContactSelected() {
    (activity as ForwardMediaGalleryActivity).isContactDataSelected =
      !selectContactAdapter?.selectedContact.isNullOrEmpty()
    (activity as ForwardMediaGalleryActivity).updateFabNext()

    val selectedContactHashSet = selectContactAdapter?.selectedContact
    val list: ArrayList<UserRecord> = ArrayList()
    if (selectedContactHashSet != null) {
      for (userRecord in selectedContactHashSet) {
        userRecord?.let { list.add(it) }
      }
      (activity as ForwardMediaGalleryActivity).contactIdList = list
    }

    (activity as ForwardMediaGalleryActivity).onContactSelected()
  }

}