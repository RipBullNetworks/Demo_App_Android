package com.ripbull.ertc.chat.starred

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.view.ActionMode
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coresdk.chat.mapper.ChatReactionRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.chat.chat.ChatCommonAdapter
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.hideKeyBoard
import com.ripbull.ertc.util.showToastLong
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_starred_messages.rvStarredChat
import kotlinx.android.synthetic.main.activity_starred_messages.tvNoStarredMsg
import kotlinx.android.synthetic.main.activity_starred_messages.root_view
import kotlinx.android.synthetic.main.all_toolbar_dark.*

class StarredMessagesActivity: BaseActivity(), ChatCommonAdapter.ChatCommonAdapterListener {

  private val disposable = CompositeDisposable()
  private var messageList = ArrayList<MessageRecord>()
  private var msgSelectedList = ArrayList<MessageRecord>()
  private var chatCommonAdapter: ChatCommonAdapter? = null
  private val glideLazy by lazy { GlideApp.with(this) }
  var multiSelectorActionMode: ActionMode? = null
  private var isMultiSelect: Boolean = false
  private var threadID: String? = null
  private var mSearchView : SearchView? = null
  private var parentMsgId: String? = null

  companion object {
    @JvmStatic
    fun newIntent(context: Context, threadId: String? = null, parentMsgId: String? = null): Intent {
      val intent = Intent(context, StarredMessagesActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.PARENT_MESSAGE_ID, parentMsgId)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_starred_messages)

    loadUI()
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
    chatCommonAdapter?.stopMedia()
  }

  private fun loadUI() {
    threadID = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    parentMsgId = intent.getStringExtra(AppConstants.PARENT_MESSAGE_ID)
    initMessageList()

    mSearchView = searchToolBar(getString(R.string.starred_messages))

    // listening to search query text change
    mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        chatCommonAdapter?.filter?.filter(query)
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        chatCommonAdapter?.filter?.filter(query)
        return false
      }
    })

    rvStarredChat!!.addOnItemTouchListener(RecyclerTouchListener(
        applicationContext, rvStarredChat!!, object : ClickListener {

          override fun onClick(view: View, position: Int) {
            if (isMultiSelect) {
              selectMessage(view, position)
            }
          }

          override fun onLongClick(view: View?, position: Int) {
            if (!isMultiSelect) {
              msgSelectedList = ArrayList()
              isMultiSelect = true

              if (multiSelectorActionMode == null) {
                multiSelectorActionMode = startSupportActionMode(ActionModeCallback())
              }
            }

            selectMessage(view, position)
          }
        })
    )
  }

  private fun initMessageList() {
    if (!parentMsgId.isNullOrEmpty()) {
      disposable.add(
        eRTCSDK.chat().getAllFavoriteMessages(threadID!!, parentMsgId!!).subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          this::onMessageListSuccess, this::onMessageListError
        )
      )
    } else if (threadID != null && threadID!!.isNotEmpty()) {
      disposable.add(
        eRTCSDK.chat().getAllFavoriteMessages(threadID!!).subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          this::onMessageListSuccess, this::onMessageListError
        )
      )
    } else {
      disposable.add(
        eRTCSDK.chat().getAllFavoriteMessages().subscribeOn(Schedulers.io()).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe(
          this::onMessageListSuccess, this::onMessageListError
        )
      )
    }
  }

  private fun onMessageListSuccess(messageList: List<MessageRecord>?) {
    this.messageList = messageList as ArrayList<MessageRecord>
    if (messageList.isNullOrEmpty()) {
      rvStarredChat.visibility = View.GONE
      tvNoStarredMsg.visibility = View.VISIBLE
      return
    }
    rvStarredChat.visibility = View.VISIBLE
    tvNoStarredMsg.visibility = View.GONE

    val linearLayoutManager = LinearLayoutManager(this)
    linearLayoutManager.stackFromEnd = java.lang.Boolean.TRUE
    rvStarredChat!!.layoutManager = linearLayoutManager
    chatCommonAdapter = ChatCommonAdapter(
      messageList, glideLazy, this, AppConstants.TYPE_FAV_MESSAGES,
      ChatType.SINGLE.type, this
    )
    rvStarredChat!!.adapter = chatCommonAdapter
  }

  private fun onMessageListError(throwable: Throwable) {
    rvStarredChat.visibility = View.GONE
    tvNoStarredMsg.visibility = View.VISIBLE
    setErrorAlert(throwable)
  }

  override fun onMessageSelected(messageRecord: MessageRecord) {
    if (messageRecord.type.equals(ChatType.SINGLE_CHAT_THREAD.type) || messageRecord.type.equals(ChatType.GROUP_CHAT_THREAD.type)) {
      val intent = Intent()
      intent.putExtra(AppConstants.STAR_MESSAGE_ID, messageRecord.id)
      setResult(RESULT_OK, intent)
      finish()
      return
    }
    startActivity(
      if (messageRecord.type.equals(ChatType.SINGLE.type)) {
        if (messageRecord.senderId == ERTCApplication.getSession(this).getUserId()){
          messageRecord.receiverRecord?.id?.let { it1 ->
            ChatActivity.getChatIntent(
              this, it1, messageRecord.threadId!!, messageRecord.id
            )
          }
        } else {
          messageRecord.senderRecord?.id?.let { it1 -> ChatActivity.getChatIntent(this, it1, messageRecord.threadId!!, messageRecord.id) }
        }
      } else {
        messageRecord.groupRecord?.let { it1 ->
          ChatActivity.getGroupChatIntent(
            this, it1, messageRecord.groupRecord!!.threadId,  messageRecord.id
          )
        }
      }
    )
    chatCommonAdapter?.stopMedia()
  }

  @Suppress("DEPRECATION")
  internal class RecyclerTouchListener(
    context: Context,
    recyclerView: RecyclerView,
    private val clickListener: ClickListener?
  ) : RecyclerView.OnItemTouchListener {

    private val gestureDetector: GestureDetector

    init {
      gestureDetector =
        GestureDetector(context, object : SimpleOnGestureListener() {
          override fun onSingleTapUp(e: MotionEvent): Boolean {
            return true
          }

          override fun onLongPress(e: MotionEvent) {
            val child = recyclerView.findChildViewUnder(e.x, e.y)
            if (child != null && clickListener != null) {
              clickListener.onLongClick(child, recyclerView.getChildPosition(child))
            }
          }
        })
    }

    override fun onInterceptTouchEvent(
      rv: RecyclerView,
      e: MotionEvent
    ): Boolean {

      val child = rv.findChildViewUnder(e.x, e.y)
      if (child != null && clickListener != null) {
        if (gestureDetector.onTouchEvent(e)){
          clickListener.onClick(child, rv.getChildPosition(child))
        }
      }
      return false
    }

    override fun onTouchEvent(
      rv: RecyclerView,
      e: MotionEvent
    ) {
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
  }

  interface ClickListener {
    fun onClick(
      view: View,
      position: Int
    )

    fun onLongClick(
      view: View?,
      position: Int
    )
  }

  private fun selectMessage(view: View?, position: Int) {
      if (multiSelectorActionMode != null) {
        if (msgSelectedList.contains(chatCommonAdapter?.filteredChatList?.get(position))) {
          msgSelectedList.remove(chatCommonAdapter?.filteredChatList?.get(position))
          view!!.setBackgroundResource(0)
        } else {
          chatCommonAdapter?.filteredChatList?.get(position)?.let { msgSelectedList.add(it) }
          threadID = chatCommonAdapter?.filteredChatList?.get(position)?.threadId!!
          view!!.setBackgroundResource(R.color.chat_star_msg_bg)
        }

        if (msgSelectedList.size > 0) {
          multiSelectorActionMode!!.title = "" + msgSelectedList.size
        } else {
          msgSelectedList = ArrayList()
          multiSelectorActionMode?.finish()
          isMultiSelect = false
        }
    }
  }

  inner class ActionModeCallback : ActionMode.Callback {
    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
      when (item?.itemId) {
        R.id.action_star -> {
          setFavourite(true)
          return true
        }
        R.id.action_unstar -> {
          setFavourite(false)
          return true
        }
      }
      return false
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
      val inflater = mode!!.menuInflater
      inflater.inflate(R.menu.action_mode_menu, menu)
      menu!!.findItem(R.id.action_star).isVisible = false
      return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
      menu?.findItem(R.id.action_star)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
      return true
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
      multiSelectorActionMode = null
      isMultiSelect = false
      chatCommonAdapter?.notifyDataSetChanged()
    }
  }

  private fun setFavourite(isFavorite: Boolean) {
    if (msgSelectedList.size > 0) {
      dismissProgressbar()
      showProgressbar()
      threadID?.let {
        disposable.add(
          eRTCSDK.chat()
            .markAsFavorite(it, msgSelectedList, isFavorite)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              dismissProgressbar()
            }, {
                throwable -> setErrorAlert(throwable)
            })
        )
      }
      msgSelectedList = ArrayList()
      multiSelectorActionMode?.finish()
      isMultiSelect = false
      mSearchView?.setQuery("", true)
      toolbar.collapseActionView()
    } else {
      showToastLong(getString(R.string.alert_select_message))
    }
  }

  override fun downloadMedia(
    msgId: String,
    serverUrl: String,
    dirPath: String,
    mediaType: String
  ) {
    disposable.add(
      eRTCSDK.chat().downloadMedia(msgId, serverUrl, dirPath, mediaType)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
        }, {
          setErrorAlert(it)
        })
    )
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

  override fun onBackPressed() {
    hideKeyBoard(root_view)
    super.onBackPressed()
  }

  override fun onStarredListChanged(isDataEmpty: Boolean) {
    if (tvNoStarredMsg!=null){
      if (isDataEmpty) {
        tvNoStarredMsg.visibility = View.VISIBLE
      } else {
        tvNoStarredMsg.visibility = View.GONE
      }
    }
  }

  override fun onChatTryAgain(messageRecord: MessageRecord, position: Int) {

  }
}