package com.ripbull.ertc.chat.history

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.thread.mapper.ThreadRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.chat.search.SearchHistoryActivity
import com.ripbull.ertc.core.BaseFragment
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.group.list.GroupListActivity
import com.ripbull.ertc.group.search.ChannelSearchActivity
import com.ripbull.ertc.group.update.ChannelPrivacyActivity
import com.ripbull.ertc.util.MyDividerItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.fragment_chat_history.rvChatHistory
import kotlinx.android.synthetic.main.fragment_chat_history.tvNoChat

/**
 * @author Sagar
 */
class ChatHistoryFragment : BaseFragment(), ChatHistoryAdapter.ChatHistoryAdapterListener {

  private val disposable = CompositeDisposable()
  private var chatList = ArrayList<ThreadRecord>()
  private val glide by lazy { GlideApp.with(this) }

  companion object {
    var chatAdapter: ChatHistoryAdapter? = null
    @JvmStatic
    fun newInstance(): ChatHistoryFragment {
      return ChatHistoryFragment()
    }

    @JvmStatic
    fun tag() = "ChatHistoryFragment"
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    rlToolbar.gravity = Gravity.LEFT
    tvTitle.setPadding(50, 0, 0, 0)
    tvTitle.text = getString(R.string.title_messages)
    imgToolbarDP.visibility = View.GONE

    toolbar.inflateMenu(R.menu.chat_history_menu)

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_search -> {
          startActivity(activity?.let { it1 -> SearchHistoryActivity.newIntent(it1) })
        }
        R.id.action_channel -> {
          startActivity(activity?.let { it1 -> GroupListActivity.getIntent(it1) })
        }
        R.id.action_create_channel -> {
          startActivity(activity?.let { it1 -> ChannelPrivacyActivity.getIntent(it1) })
        }
        R.id.action_search_channel -> {
          startActivity(activity?.let { activity -> ChannelSearchActivity.getChannelSearchIntent(activity) })
        }
        else -> {
        }
      }
      true
    }

    rvChatHistory.layoutManager = LinearLayoutManager(context)
    rvChatHistory.itemAnimator = DefaultItemAnimator()
    rvChatHistory.addItemDecoration(
      MyDividerItemDecoration(
        this.requireContext(),
        DividerItemDecoration.VERTICAL,
        66
      )
    )

    disposable.add(eRTCSDK.chat().getThreads().subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        this::onThreadListSuccess, this::onThreadListError
      )
    )

    disposable.add(eRTCSDK.user().subscribeToUserMetaData().subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        chatAdapter?.notifyUserStatusChanged(it)
      }, {
        setErrorAlert(it)
      })
    )

    disposable.add(eRTCSDK.group().subscribeToGroupUpdate().subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        chatAdapter?.notifyGroupStatusChanged(it)
      }, {
        setErrorAlert(it)
      })
    )
  }

  override fun onDestroyView() {
    super.onDestroyView()
    disposable.dispose()
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_chat_history, container, false)
  }

  private fun onThreadListSuccess(threadList: List<ThreadRecord>) {
    this.chatList = threadList as ArrayList<ThreadRecord>
    if (chatList.isNullOrEmpty()) {
      rvChatHistory.visibility = View.GONE
      tvNoChat.visibility = View.VISIBLE
      return
    }

    tvNoChat.visibility = View.GONE
    rvChatHistory.visibility = View.VISIBLE
    chatAdapter = this.activity?.let { ChatHistoryAdapter(it, chatList, glide, this) }
    rvChatHistory.adapter = chatAdapter
  }

  private fun onThreadListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onChatSelected(threadRecord: ThreadRecord) {
    startActivity(activity?.applicationContext?.let {
      if (threadRecord.type == ChatType.SINGLE.type) {
        threadRecord.recipient?.id?.let { it1 ->
          ChatActivity.getChatIntent(it,
            it1, threadRecord.id)
        }
      } else {
        threadRecord.groupRecipient?.let { it1 -> ChatActivity.getGroupChatIntent(it, it1, threadRecord.id) }
      }
    })
  }

}