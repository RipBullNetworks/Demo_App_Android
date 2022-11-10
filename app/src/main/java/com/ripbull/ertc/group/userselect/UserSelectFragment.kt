package com.ripbull.ertc.group.userselect

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_user_select.*

/**
 * @author vik
 */
class UserSelectFragment : BaseFragment(), UserSelectAdapter.UserSelectAdapterListener, SelectedParticipantAdapter.SelectedParticipantAdapterListener {

  companion object {
    @JvmStatic
    fun newInstance(groupId: String?, selectedUsers: ArrayList<UserRecord>): UserSelectFragment {
      val fragment = UserSelectFragment()
      val args = Bundle()
      args.putString(AppConstants.EXTRA_ID, groupId)
      args.putSerializable(UserSelectActivity.EXTRA_SELECTED_PARTICIPANTS, selectedUsers)
      fragment.arguments = args
      return fragment
    }

    @JvmStatic
    fun tag() = "UserSelectFragment"

    var userSelectAdapter: UserSelectAdapter? = null
  }

  private var rootView: View? = null
  private var mSearchView: SearchView? = null
  private var contactList = ArrayList<UserRecord>()
  private val glide by lazy { GlideApp.with(this) }
  private val disposable = CompositeDisposable()
  private var exceptList = ArrayList<String>()
  private var selectedUsers = ArrayList<UserRecord>()
  private var groupId: String? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    groupId = arguments?.getString(AppConstants.EXTRA_ID)
    if (groupId != null) {
      showProgressbar()
      disposable.add(
        eRTCSDK.group()
          .getGroupById(groupId!!)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            dismissProgressbar()
            if (it.groupStatus == GroupRecord.STATUS_FROZEN) {
              activity?.finish()
            }
            for (user in it.groupUsers) {
              user.id?.let { exceptList.add(it) }
            }
          }, {
            setErrorAlert(it)
            dismissProgressbar()
          })
      )
    }

    selectedUsers =
      (arguments?.getSerializable(UserSelectActivity.EXTRA_SELECTED_PARTICIPANTS) as ArrayList<UserRecord>?)!!
    rootView = inflater.inflate(R.layout.fragment_user_select, container, false)
    return rootView
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    rvUserList.layoutManager = LinearLayoutManager(context)
    rvUserList.itemAnimator = DefaultItemAnimator()

    mSearchView = searchToolBar("Add members", isHomeEnabled = true)

    // listening to search query text change
    mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        userSelectAdapter?.filter?.filter(query)
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        userSelectAdapter?.filter?.filter(query)
        return false
      }
    })

    fabNext.setOnClickListener {
      if (userSelectAdapter == null || userSelectAdapter?.selectedUsers?.isEmpty()!!) {
        if (contactList.isNullOrEmpty()) {
          tvNoUser.visibility = View.VISIBLE
          rvUserList.visibility = View.GONE
        } else {
          fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_disable_bg)))
          Toast.makeText(activity, R.string.select_users, Toast.LENGTH_SHORT).show()
        }

      } else {
        val data = Intent()
        data.putExtra(
          UserSelectActivity.EXTRA_SELECTED_PARTICIPANTS,
          ArrayList(userSelectAdapter?.selectedUsers!!)
        )
        activity?.setResult(RESULT_OK, data)
        activity?.finish()
      }
    }
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
      eRTCSDK.user().chatUsers.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
          this::onUserListSuccess, this::onUserListError
        )
    )
  }

  private fun onUserListSuccess(userList: List<UserRecord>) {
    if (userList.isNullOrEmpty()) {
      tvNoUser.visibility = View.VISIBLE
      rvUserList.visibility = View.GONE
      return
    }
    tvNoUser.visibility = View.GONE
    rvUserList.visibility = View.VISIBLE

    contactList.clear()
    if (exceptList.isNotEmpty()) {
      for (user in userList) {
        if (!exceptList.contains(user.id)) {
          contactList.add(user)
        }
      }
    } else {
      this.contactList = userList as ArrayList<UserRecord>
    }

    if (contactList.isNullOrEmpty()) {
      rvUserList.visibility = View.GONE
      tvNoUser.visibility = View.VISIBLE
      fabNext.hide()
      tvNoUser.text = getString(R.string.all_user_added)
      return
    }
    val selectedUserSet = HashSet<UserRecord>()
    selectedUserSet.addAll(selectedUsers)
    userSelectAdapter = UserSelectAdapter(selectedUserSet,contactList, glide, this)
    rvUserList.adapter = userSelectAdapter
    onUserSelected()
  }

  private fun onUserListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onUserSelected() {
    if (userSelectAdapter?.selectedUsers.isNullOrEmpty()) {
      fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_disable_bg)))
      rvUsers.visibility = View.GONE
      divider.visibility = View.GONE
    } else {
      fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_enable_bg)))
      rvUsers.visibility = View.VISIBLE
      divider.visibility = View.VISIBLE
      var userRecords = arrayListOf<UserRecord>()
      for (userRecord in userSelectAdapter?.selectedUsers!!) {
        userRecords.add(userRecord)
      }
      rvUsers.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL, false)
      rvUsers.itemAnimator = DefaultItemAnimator()
      userRecords = userRecords.sortedWith(compareBy { it.name }).toCollection(ArrayList<UserRecord>())
      val adapter = SelectedParticipantAdapter(userRecords, glide, this)
      rvUsers.adapter = adapter
      rvUsers.scrollToPosition(adapter.itemCount.minus(1))
    }
  }

  override fun onUserListChanged(isDataEmpty: Boolean) {
    if (tvNoUser!=null){
      if (isDataEmpty) {
        tvNoUser.visibility = View.VISIBLE
        rvUserList.visibility = View.GONE
      } else {
        tvNoUser.visibility = View.GONE
        rvUserList.visibility = View.VISIBLE
      }
    } else {
      try {
        tvNoUser.visibility = View.GONE
      } catch (ex: Exception) {

      }
    }
  }

  override fun onUserRemoved(userRecord: UserRecord) {
    userSelectAdapter?.selectedUsers?.remove(userRecord)
    userSelectAdapter = UserSelectAdapter(userSelectAdapter?.selectedUsers!!, contactList, glide, this)
    rvUserList.adapter = userSelectAdapter
    onUserSelected()
  }
}