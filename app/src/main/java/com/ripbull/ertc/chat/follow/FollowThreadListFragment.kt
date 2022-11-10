package com.ripbull.ertc.chat.follow

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ripbull.coresdk.chat.mapper.ChatReactionRecord
import com.ripbull.coresdk.chat.mapper.FollowThreadRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ScrollTo
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatCommonAdapter
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.all_toolbar_dark.imgToolbarDP
import kotlinx.android.synthetic.main.all_toolbar_dark.tvTitle
import kotlinx.android.synthetic.main.all_toolbar_dark.rlToolbar
import kotlinx.android.synthetic.main.chat_bottom_dialog.view.*
import kotlinx.android.synthetic.main.fragment_follow_thread_list.rvFollowThreadList
import kotlinx.android.synthetic.main.fragment_follow_thread_list.tvNoThread

/**
 * @author Sagar
 */
class FollowThreadListFragment : BaseFragment(), FollowThreadListAdapter.FollowThreadListAdapterListener, ChatCommonAdapter.ChatCommonAdapterListener {

  private var rootView: View? = null
  private val disposable = CompositeDisposable()
  private var followThreadList = ArrayList<FollowThreadRecord>()
  private val glide by lazy { GlideApp.with(this) }
  private var lastMsgId: String = ""
  private var isDataLoaded = true

  companion object {
    var adapter: FollowThreadListAdapter? = null
    @JvmStatic
    fun newInstance(): FollowThreadListFragment {
      return FollowThreadListFragment()
    }

    @JvmStatic
    fun tag() = "FollowThreadFragment"
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    rootView = inflater.inflate(R.layout.fragment_follow_thread_list, container, false)
    return rootView
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    rvFollowThreadList.layoutManager = LinearLayoutManager(context)
    rvFollowThreadList.itemAnimator = DefaultItemAnimator()
    val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
    divider.setDrawable(ContextCompat.getDrawable(this.context!!, R.drawable.grey_divider)!!)
    rvFollowThreadList.addItemDecoration(divider)

    rlToolbar.gravity = Gravity.LEFT
    tvTitle.setPadding(50, 0, 0, 0)
    tvTitle.text = getString(R.string.title_threads)
    imgToolbarDP.visibility = View.GONE

    loadReplyThreads()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  private fun loadReplyThreads() {
    showProgressbar()
    disposable.add(
      eRTCSDK.chat().getFollowThreads(
        followedThread = true,
        direction = ScrollTo.PAST.type,
        pageSize = 20
      ).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onListSuccess, this::onListError
        )
    )

    rvFollowThreadList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
      override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (followThreadList.size < 20) {
          return
        }

        if (!rvFollowThreadList.canScrollVertically(-1) && isDataLoaded) {
          isDataLoaded = false
          val index = followThreadList.size-1
          if (lastMsgId == followThreadList[index].parentMsgId) {
            return
          }
          lastMsgId = followThreadList[index].parentMsgId
          showProgressbar()
          disposable.add(
            eRTCSDK.chat().getFollowThreads(
              currentMsgId = lastMsgId,
              followedThread = true,
              direction = ScrollTo.PAST.type,
              pageSize = 20
            )
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe({
                dismissProgressbar()
                val threadList = it as ArrayList<FollowThreadRecord>
                followThreadList.addAll(threadList.reversed())
                isDataLoaded = true
                if (adapter != null) {
                  adapter?.update(followThreadList)
                }
              }) {
                isDataLoaded = true
                setErrorAlert(it)
              }
          )
        }
      }
    })
  }

  private fun onListSuccess(list: List<FollowThreadRecord>) {
    dismissProgressbar()
    if (list.isNullOrEmpty()) {
      rvFollowThreadList.visibility = View.GONE
      tvNoThread.visibility = View.VISIBLE
      return
    } else if (list.size == 1) {
      this.followThreadList = list as ArrayList<FollowThreadRecord>
    } else {
      this.followThreadList = list.reversed() as ArrayList<FollowThreadRecord>
    }

    rvFollowThreadList.visibility = View.VISIBLE
    tvNoThread.visibility = View.GONE
    adapter =
      activity?.let { FollowThreadListAdapter(it, followThreadList, glide, this, this) }
    rvFollowThreadList.adapter = adapter
  }

  private fun onListError(throwable: Throwable) {
    rvFollowThreadList.visibility = View.GONE
    tvNoThread.visibility = View.VISIBLE
    setErrorAlert(throwable)
  }

  override fun onUnFollowThread(index: Int, followThreadRecord: FollowThreadRecord) {
    showBottomSheetDialog(index, followThreadRecord)
  }

  override fun onMessageSelected(messageRecord: MessageRecord) {

  }

  override fun downloadMedia(msgId: String, serverUrl: String, dirPath: String, mediaType: String) {

  }

  override fun onAddToFav(messageRecord: MessageRecord) {

  }

  override fun goToThread(messageRecord: MessageRecord) {

  }

  override fun onMessageLongPress(messageRecord: MessageRecord, position: Int) {

  }

  override fun onMentionUserClicked(appUserId: String) {

  }

  override fun onSelectReaction(
    chatReactionRecord: ChatReactionRecord,
    messageRecord: MessageRecord
  ) {

  }

  override fun onReactionLongClickListener(
    reactionUnicodes: List<String>,
    msgId: String,
    threadId: String,
    chatType: String
  ) {

  }

  override fun onStarredListChanged(isDataEmpty: Boolean) {

  }

  override fun onChatTryAgain(messageRecord: MessageRecord, position: Int) {

  }

  private fun showBottomSheetDialog(position: Int, followThreadRecord: FollowThreadRecord) {
    val view = layoutInflater.inflate(R.layout.chat_bottom_dialog, null)
    val dialog = activity?.let { BottomSheetDialog(it, R.style.BottomSheetDialog) }
    dialog?.setContentView(view)

    view.tvFollowThread.text = getString(R.string.unfollow_thread)
    view.tvFollowThread.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_unfollow_thread, 0, 0, 0)
    view.tvAddToFav.visibility = View.GONE
    view.tvReaction.visibility = View.GONE
    view.tvForward.visibility = View.GONE
    view.tvStartThread.visibility = View.GONE
    view.tvCopy.visibility = View.GONE
    view.tvEdit.visibility = View.GONE
    view.tvDelete.visibility = View.GONE
    view.tvReportMessage.visibility = View.GONE

    view.tvFollowThread.setOnClickListener {
      disposable.add(
        eRTCSDK.chat()
          .followThread(followThreadRecord.threadId, followThreadRecord.parentMsgId, false)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({ messageRecord ->
            activity?.showToastShort(getString(R.string.unfollow_chat))
            adapter?.notifyOnUnFollowThread(position, followThreadRecord)
            if (adapter?.itemCount == 0) {
              rvFollowThreadList.visibility = View.GONE
              tvNoThread.visibility = View.VISIBLE
            }
          }, {
            setErrorAlert(it)
          })
      )
      dialog?.dismiss()
    }

    dialog?.show()
  }
}