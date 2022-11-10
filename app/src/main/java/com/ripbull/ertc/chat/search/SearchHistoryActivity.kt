package com.ripbull.ertc.chat.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatEventType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.chat.thread.ThreadActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.data.ApplicationSession
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.MyDividerItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search_history.*
import kotlin.collections.ArrayList

class SearchHistoryActivity: BaseActivity(), SearchHistoryAdapter.SearchHistoryAdapterListener {

  private val disposable = CompositeDisposable()
  private var searchAdapter: SearchHistoryAdapter? = null
  private val glideLazy by lazy { GlideApp.with(this) }
  private var query = ""

  companion object {
    @JvmStatic
    fun newIntent(context: Context): Intent {
      return Intent(context, SearchHistoryActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_search_history)

    val mSearchView = searchToolBar("Messages")

    rvSearchHistory.layoutManager = LinearLayoutManager(this)
    rvSearchHistory.itemAnimator = DefaultItemAnimator()
    rvSearchHistory.addItemDecoration(
      MyDividerItemDecoration(this, DividerItemDecoration.VERTICAL, 66)
    )

    // listening to search query text change
    mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        if (ApplicationSession(this@SearchHistoryActivity).isGlobalSearch() && query.isNotEmpty()) {
          var searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
          if (searchedText.isNullOrEmpty()) {
            searchedText = query
            ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(searchedText)
          } else {
            val list: MutableList<String> = searchedText.trim()
              .split("<!&!>")
              .filter { it.isNotEmpty() }
              .toList() as MutableList<String>
            if (list.contains(query)) {
              //Update index value
            } else {
              val newSearchData: MutableList<String> = mutableListOf()
              newSearchData.add(0, query)
              for ((index, strText) in list.withIndex()) {
                if (index < 4) {
                  newSearchData.add(index + 1, strText)
                }
              }
              val newSearchedData = newSearchData.joinToString("<!&!>")
              ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(newSearchedData)
            }
          }
          searchMessage(query)
        }
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        if (query.isNullOrEmpty()) {
          tvNoMessages.text = getString(R.string.no_search)
          tvNoMessages.visibility = View.VISIBLE
          llSearch.visibility = View.GONE
          rvSearchHistory.visibility = View.GONE
          setSearchHistory(query)
        } else {
          if (!ApplicationSession(this@SearchHistoryActivity).isGlobalSearch()) {
            searchMessage(query)
          }
        }
        return false
      }
    })

    tvClearHistory.setOnClickListener {
      ApplicationSession(this@SearchHistoryActivity).setGlobalSearch("")
      llSearch.visibility = View.GONE
      tvNoMessages.visibility = View.VISIBLE
    }

    tvSearch1.setOnClickListener {
      searchMessage(tvSearch1.text.toString())
    }

    tvSearch2.setOnClickListener {
      searchMessage(tvSearch2.text.toString())
    }

    tvSearch3.setOnClickListener {
      searchMessage(tvSearch3.text.toString())
    }

    tvSearch4.setOnClickListener {
      searchMessage(tvSearch4.text.toString())
    }

    tvSearch5.setOnClickListener {
      searchMessage(tvSearch5.text.toString())
    }

    tvSearch1.setOnTouchListener(OnTouchListener { v, event ->
      val DRAWABLE_RIGHT = 2
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= tvSearch1.right - tvSearch1.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
          // your action here
          val searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
          if (searchedText == tvSearch1.text.toString()) {
            tvSearch1.visibility = View.GONE
            ApplicationSession(this@SearchHistoryActivity).setGlobalSearch("")
            setSearchHistory()
            return@OnTouchListener true
          }
          val list: MutableList<String> = searchedText.trim().split("<!&!>")
            .filter { it.isNotEmpty() }
            .toList() as MutableList<String>

          val newSearchData: MutableList<String> = mutableListOf()
          for ((index, strText) in list.withIndex()) {
            if (index != 0) {
              newSearchData.add(strText)
            }
          }
          tvSearch1.visibility = View.GONE
          val newSearchedData = newSearchData.joinToString("<!&!>")
          ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(newSearchedData)
          setSearchHistory()
          return@OnTouchListener true
        }
      }
      false
    })

    tvSearch2.setOnTouchListener(OnTouchListener { v, event ->
      val DRAWABLE_RIGHT = 2
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= tvSearch2.right - tvSearch2.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
          // your action here
          val searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
          val list: MutableList<String> = searchedText.trim()
            .split("<!&!>")
            .filter { it.isNotEmpty() }
            .toList() as MutableList<String>
          list.removeAt(1)
          tvSearch2.visibility = View.GONE
          val newSearchedData = list.joinToString("<!&!>")
          ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(newSearchedData)
          setSearchHistory()
          return@OnTouchListener true
        }
      }
      false
    })

    tvSearch3.setOnTouchListener(OnTouchListener { v, event ->
      val DRAWABLE_RIGHT = 2
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= tvSearch3.right - tvSearch3.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
          // your action here
          val searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
          val list: MutableList<String> = searchedText.trim()
            .split("<!&!>")
            .filter { it.isNotEmpty() }
            .toList() as MutableList<String>
          list.removeAt(2)
          tvSearch3.visibility = View.GONE
          val newSearchedData = list.joinToString("<!&!>")
          ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(newSearchedData)
          setSearchHistory()
          return@OnTouchListener true
        }
      }
      false
    })

    tvSearch4.setOnTouchListener(OnTouchListener { v, event ->
      val DRAWABLE_RIGHT = 2
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= tvSearch4.right - tvSearch4.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
          // your action here
          val searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
          val list: MutableList<String> = searchedText.trim()
            .split("<!&!>")
            .filter { it.isNotEmpty() }
            .toList() as MutableList<String>
          list.removeAt(3)
          tvSearch4.visibility = View.GONE
          val newSearchedData = list.joinToString("<!&!>")
          ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(newSearchedData)
          setSearchHistory()
          return@OnTouchListener true
        }
      }
      false
    })

    tvSearch5.setOnTouchListener(OnTouchListener { v, event ->
      val DRAWABLE_RIGHT = 2
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= tvSearch5.right - tvSearch5.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
          // your action here
          val searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
          val list: MutableList<String> = searchedText.trim()
            .split("<!&!>")
            .filter { it.isNotEmpty() }
            .toList() as MutableList<String>
          list.removeAt(4)
          tvSearch5.visibility = View.GONE
          val newSearchedData = list.joinToString("<!&!>")
          ApplicationSession(this@SearchHistoryActivity).setGlobalSearch(newSearchedData)
          setSearchHistory()
          return@OnTouchListener true
        }
      }
      false
    })

    disposable.add(
      eRTCSDK.user()
        .subscribeToUserMetaData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          searchAdapter?.notifyUserStatusChanged(it)
        }, {
          setErrorAlert(it)
        })
    )

    disposable.add(
      eRTCSDK.group()
        .subscribeToGroupUpdate()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          searchAdapter?.notifyGroupStatusChanged(it)
        }, {
          setErrorAlert(it)
        })
    )
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun onSearchedListSuccess(messageList: ArrayList<MessageRecord>) {
    if (messageList.isNullOrEmpty()) {
      tvNoMessages.text = getString(R.string.no_result_found)
      rvSearchHistory.visibility = View.GONE
      llSearch.visibility = View.GONE
      tvNoMessages.visibility = View.VISIBLE
      searchAdapter = SearchHistoryAdapter(query, this, messageList, glideLazy, this)
      rvSearchHistory.adapter = searchAdapter
    } else {
      tvNoMessages.visibility = View.GONE
      llSearch.visibility = View.GONE
      rvSearchHistory.visibility = View.VISIBLE
      searchAdapter = SearchHistoryAdapter(query, this, messageList, glideLazy, this)
      rvSearchHistory.adapter = searchAdapter
    }
  }

  private fun onSearchedListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onMessageSelected(messageRecord: MessageRecord) {
    if (messageRecord.type == ChatType.SINGLE.type || messageRecord.type == ChatType.GROUP.type) {
      startActivity(if (messageRecord.type == ChatType.SINGLE.type) {
        val userRecord = if (messageRecord.chatEventType == ChatEventType.INCOMING) {
          messageRecord.senderRecord
        } else if (messageRecord.chatEventType == ChatEventType.OUTGOING) {
          messageRecord.receiverRecord
        } else {
          null
        }

        userRecord?.id?.let { it ->
          messageRecord.threadId?.let { it1 ->
            ChatActivity.getChatIntent(
              this, it, it1, messageRecord.id, ApplicationSession(this).isGlobalSearch()
            )
          }
        }
      } else {
        messageRecord.groupRecord?.let { it ->
          messageRecord.threadId?.let { threadId ->
            ChatActivity.getGroupChatIntent(
              this, it, threadId, messageRecord.id, ApplicationSession(
                this
              ).isGlobalSearch()
            )
          }
        }
      })
    } else {
      startActivity(if (messageRecord.type == ChatType.SINGLE_CHAT_THREAD.type) {
        val userRecord = if (messageRecord.chatEventType == ChatEventType.INCOMING) {
          messageRecord.senderRecord
        } else if (messageRecord.chatEventType == ChatEventType.OUTGOING) {
          messageRecord.receiverRecord
        } else {
          null
        }

        userRecord?.id?.let { it ->
          messageRecord.threadId?.let { threadId ->
            messageRecord.chatThreadMetadata?.parentMsgId?.let { parentMsgId ->
              ThreadActivity.getThreadIntent(
                this, messageRecord.senderId!!, threadId, parentMsgId, it
              )
            }
          }
        }
      } else {
        messageRecord.groupRecord?.let { it ->
          messageRecord.threadId?.let { threadId ->
            messageRecord.chatThreadMetadata?.parentMsgId?.let { parentMsgId ->
              ThreadActivity.getGroupThreadIntent(
                this, it, threadId, parentMsgId
              )
            }
          }
        }
      })
    }
  }

  private fun searchMessage(searchedText: String) {
    query = searchedText
    if (ApplicationSession(this).isGlobalSearch()) {
      disposable.add(
        eRTCSDK.chat()
          .globalSearch(searchedText)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(
            this::onSearchedListSuccess, this::onSearchedListError
          )
      )
    } else {
      disposable.add(
        eRTCSDK.chat()
          .searchMessages(searchedText)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(
            this::onSearchedListSuccess, this::onSearchedListError
          )
      )
    }
  }

  private fun setSearchHistory(query: String = "") {
    if (ApplicationSession(this@SearchHistoryActivity).isGlobalSearch()) {
      val searchedText = ApplicationSession(this@SearchHistoryActivity).getGlobalSearch()
      if (searchedText.isNullOrEmpty()) {
        llSearch.visibility = View.GONE
      } else {
        val list: MutableList<String> = searchedText.trim()
          .split("<!&!>")
          .filter { it.isNotEmpty() }
          .toList() as MutableList<String>
        if (list.contains(query)) {
          //Update index value
        } else {
          llSearch.visibility = View.VISIBLE
          tvNoMessages.visibility = View.GONE
          tvSearch1.visibility = View.GONE
          tvSearch2.visibility = View.GONE
          tvSearch3.visibility = View.GONE
          tvSearch4.visibility = View.GONE
          tvSearch5.visibility = View.GONE
          for ((index, strText) in list.withIndex()) {
            when (index) {
              0 -> {
                tvSearch1.visibility = View.VISIBLE
                tvSearch1.text = strText
                tvSearch1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0)
              }
              1 -> {
                tvSearch2.visibility = View.VISIBLE
                tvSearch2.text = strText
                tvSearch2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0)
              }
              2 -> {
                tvSearch3.visibility = View.VISIBLE
                tvSearch3.text = strText
                tvSearch3.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0)
              }
              3 -> {
                tvSearch4.visibility = View.VISIBLE
                tvSearch4.text = strText
                tvSearch4.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0)
              }
              4 -> {
                tvSearch5.visibility = View.VISIBLE
                tvSearch5.text = strText
                tvSearch5.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close, 0)
              }
            }
          }
        }
      }
    }
  }
}