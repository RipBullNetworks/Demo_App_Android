package com.ripbull.ertc.chat.gallery.forward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.MyDividerItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_select_group.rvGroupList
import kotlinx.android.synthetic.main.fragment_select_group.tvNoGroup

/**
 * @author Sagar
 */
class SelectMediaGroupFragment : BaseFragment(), SelectMediaGroupAdapter.SelectMediaGroupAdapterListener {

  companion object {
    var selectGroupAdapter: SelectMediaGroupAdapter? = null
    @JvmStatic
    fun newInstance(): SelectMediaGroupFragment {
      return SelectMediaGroupFragment()
    }

    @JvmStatic
    fun tag() = "SelectMediaGroupFragment"
  }

  private val disposable = CompositeDisposable()
  private val glide by lazy { GlideApp.with(this) }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_select_group, container, false)
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

    loadGroups()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  private fun loadGroups() {
    disposable.add(
      eRTCSDK.group().activeGroups.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
          this::onListSuccess, this::onListError
        )
    )
  }

  private fun onListSuccess(list: List<GroupRecord>) {
    list as ArrayList<GroupRecord>
    if (list.isNullOrEmpty()) {
      rvGroupList.visibility = View.GONE
      tvNoGroup.visibility = View.VISIBLE
      return
    }
    rvGroupList.visibility = View.VISIBLE
    tvNoGroup.visibility = View.GONE
    list.sortBy { it.name.toUpperCase() }
    selectGroupAdapter = SelectMediaGroupAdapter(list, glide, this)
    rvGroupList.adapter = selectGroupAdapter
  }

  private fun onListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onGroupSelected() {
    (activity as ForwardMediaGalleryActivity).isGroupDataSelected = !selectGroupAdapter?.selectedGroups.isNullOrEmpty()
    (activity as ForwardMediaGalleryActivity).updateFabNext()
    (activity as ForwardMediaGalleryActivity).groupThreadIdList = ArrayList(selectGroupAdapter?.selectedGroups!!)
    (activity as ForwardMediaGalleryActivity).onGroupSelected()
  }
}