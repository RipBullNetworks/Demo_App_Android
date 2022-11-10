package com.ripbull.ertc.group.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.MyDividerItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_group_list.*

/**
 * @author vik
 */
class GroupListFragment : BaseFragment(), GroupListAdapter.GroupListAdapterListener {

  companion object {
    var adapter: GroupListAdapter? = null
    @JvmStatic
    fun newInstance(): GroupListFragment {
      return GroupListFragment()
    }

    @JvmStatic
    fun tag() = "GroupListFragment"
  }
  var rootView: View? = null
  private val disposable = CompositeDisposable()
  private var mSearchView: SearchView? = null
  private var groupList = ArrayList<GroupRecord>()
  private val glide by lazy { GlideApp.with(this) }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    rootView = inflater.inflate(R.layout.fragment_group_list, container, false)
    return rootView
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    rvGroupList.layoutManager = LinearLayoutManager(context)
    rvGroupList.itemAnimator = DefaultItemAnimator()
    rvGroupList.addItemDecoration(
      MyDividerItemDecoration(
        this.context!!,
        DividerItemDecoration.VERTICAL,
        66
      )
    )
    mSearchView = channelSearchToolBar("Channels")

    // listening to search query text change
    mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        adapter?.filter?.filter(query)
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        adapter?.filter?.filter(query)
        return false
      }
    })

    loadGroups()
    disposable.add(eRTCSDK.group().subscribeToGroupUpdate().subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        adapter?.notifyGroupUpdated(it)
      }, {
        setErrorAlert(it)
      })
    )
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  private fun loadGroups() {
    disposable.add(
      eRTCSDK.group().groups.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
          this::onListSuccess, this::onListError
        )
    )
  }

  private fun onListSuccess(list: List<GroupRecord>) {
    this.groupList = list as ArrayList<GroupRecord>
    if (groupList.isNullOrEmpty()) {
      rvGroupList.visibility = View.GONE
      tvNoGroup.visibility = View.VISIBLE
      return
    }
    rvGroupList.visibility = View.VISIBLE
    tvNoGroup.visibility = View.GONE
    groupList.sortBy { it.name.toUpperCase() }
    adapter = GroupListAdapter(groupList, glide, this)
    rvGroupList.adapter = adapter
  }

  private fun onListError(throwable: Throwable) {
    rvGroupList.visibility = View.GONE
    tvNoGroup.visibility = View.VISIBLE
    setErrorAlert(throwable)
  }

  override fun onGroupSelected(group: GroupRecord) {
    startActivity(activity?.applicationContext?.let {
      ChatActivity.getGroupChatIntent(activity!!.applicationContext, group, group.threadId)
    })
  }

  override fun onGroupListChanged(isDataEmpty: Boolean) {
    val tvNoGroup= rootView!!.findViewById<AppCompatTextView>(R.id.tvNoGroup)
    if (tvNoGroup!=null){
      if (isDataEmpty) {
        tvNoGroup.visibility = View.VISIBLE
      } else {
        tvNoGroup.visibility = View.GONE
      }
    }
  }
}