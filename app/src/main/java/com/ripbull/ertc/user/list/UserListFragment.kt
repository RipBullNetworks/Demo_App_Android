package com.ripbull.ertc.user.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.StickyHeaderDecoration
import com.ripbull.ertc.util.recyclerview.AdapterCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_user_list.rvUserList
import kotlinx.android.synthetic.main.fragment_user_list.tvNoUser

/**
 * @author meeth
 */
class UserListFragment : BaseFragment(), AdapterCallback<UserRecord>, UserListAdapter.UserListAdapterListener {

  companion object {
    @JvmStatic
    fun newInstance(): UserListFragment {
      return UserListFragment()
    }

    @JvmStatic
    fun tag() = "UserListFragment"
  }

  var mSearchView: SearchView? = null
  var rootView: View? = null
  private var contactList = ArrayList<UserRecord>()
  private val glide by lazy { GlideApp.with(this) }
  private val adapter by lazy { UserListAdapter(contactList, glide, this, userListener = this) }
  private val disposable = CompositeDisposable()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    rootView = inflater.inflate(R.layout.fragment_user_list, container, false)
    return rootView
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    mSearchView = searchToolBar("Contacts")

    // listening to search query text change
    mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        adapter.filter.filter(query)
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        adapter.filter.filter(query)
        return false
      }
    })
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
    showProgressbar()
    getOnStartDisposable()?.add(
      eRTCSDK.user().chatUsers.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
        Consumer<List<UserRecord>> { onUserListSuccess(it) }, sdkError
      )
    )

    disposable.add(
      eRTCSDK.user().subscribeToUserMetaData().subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        dismissProgressbar()
        for((index, userItem) in contactList.withIndex()) {
          if(userItem.id == it.id) {
            contactList[index] = it
            adapter.notifyItemChanged(index)
            break
          }
        }
      }, {
        setErrorAlert(it)
      })
    )
  }

  private fun onUserListSuccess(userList: List<UserRecord>?) {
    dismissProgressbar()
    contactList = userList as ArrayList<UserRecord>
    if (userList.isNullOrEmpty()) {
      rvUserList.visibility = View.GONE
      tvNoUser.visibility = View.VISIBLE
      return
    }
    tvNoUser.visibility = View.GONE
    rvUserList.visibility = View.VISIBLE
    userList.sortBy { it.name?.toUpperCase() }
    rvUserList.layoutManager = LinearLayoutManager(context)
    rvUserList.addItemDecoration(StickyHeaderDecoration(adapter, true, true))
    rvUserList.adapter = adapter
    adapter.submitList(userList)
  }

  private fun onUserListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onItemClick(user: UserRecord) {

    showProgressbar()
    disposable.add(
      eRTCSDK.chat().createThread(user.id!!).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        (mSearchView!!.findViewById(androidx.appcompat.R.id.search_src_text) as EditText).setText("")
        // start your next activity
        startActivity(activity?.applicationContext?.let { it1 ->
          user.id?.let { it2 ->
            ChatActivity.getChatIntent(
              it1, it2, it
            )
          }
        })
        dismissProgressbar()
      }, {
        setErrorAlert(it)
        dismissProgressbar()
      })
    )
  }

  override fun onItemLongClick(t: UserRecord): Boolean {
    return true
  }

  override fun onUserListChanged(isDataEmpty: Boolean) {
    val tvNoUser= rootView!!.findViewById<AppCompatTextView>(R.id.tvNoUser)
    if (tvNoUser!=null){
      if (isDataEmpty) {
        tvNoUser.visibility = View.VISIBLE
      } else {
        tvNoUser.visibility = View.GONE
      }
    }
  }

  override fun onStop() {
    super.onStop()
    dismissProgressbar()
  }
}