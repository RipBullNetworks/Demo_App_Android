package com.ripbull.ertc.group.search

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.giphy.sdk.analytics.GiphyPingbacks.context
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.NotificationSettingsType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.glide.GlideApp
import com.ripbull.ertc.group.detail.SelectAdminActivity
import com.ripbull.ertc.group.userselect.UserSelectActivity
import com.ripbull.ertc.onboard.NotificationsSettingActivity
import com.ripbull.ertc.util.MediaUtil
import com.ripbull.ertc.util.MyDividerItemDecoration
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_channel_search.*
import kotlinx.android.synthetic.main.dialog_alert_info.btnCancel
import kotlinx.android.synthetic.main.dialog_alert_info.btnSubmit
import kotlinx.android.synthetic.main.dialog_alert_info.tvAlertInfo
import kotlinx.android.synthetic.main.dialog_alert_info.tvAlertTitle
import kotlinx.android.synthetic.main.dialog_notification_settings.view.*

class ChannelSearchActivity: BaseActivity(), ChannelSearchAdapter.ChannelSearchAdapterListener {

  var adapter: ChannelSearchAdapter? = null
  private val disposable = CompositeDisposable()
  private var mSearchView: SearchView? = null
  private val glideLazy by lazy { GlideApp.with(this) }
  private var searchedText = ""
  private var group: GroupRecord? = null
  private var index = 0
  var selectedUser: ArrayList<UserRecord> = ArrayList()

  companion object {

    @JvmStatic
    fun getChannelSearchIntent(context: Context): Intent {
      return Intent(context, ChannelSearchActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_channel_search)

    rvChannelList.layoutManager = LinearLayoutManager(context)
    rvChannelList.itemAnimator = DefaultItemAnimator()
    rvChannelList.addItemDecoration(
      MyDividerItemDecoration(
        this,
        DividerItemDecoration.VERTICAL,
        66
      )
    )
    mSearchView = searchToolBar("Channels")

    // listening to search query text change
    mSearchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(query: String): Boolean {
        // filter recycler view when query submitted
        if (query.isNullOrEmpty()) {
          searchedText = ""
          tvNoChannel.text = getString(R.string.no_search)
          tvNoChannel.visibility = View.VISIBLE
          rvChannelList.visibility = View.GONE
        } else {
          searchedText = query
          searchChannel(query)
        }
        searchedText = query
        return false
      }

      override fun onQueryTextChange(query: String): Boolean {
        // filter recycler view when text is changed
        if (query.isNullOrEmpty()) {
          searchedText = ""
          tvNoChannel.text = getString(R.string.no_search)
          tvNoChannel.visibility = View.VISIBLE
          rvChannelList.visibility = View.GONE
        }
        return false
      }
    })
  }

  override fun onStart() {
    super.onStart()
    if (searchedText.isNotEmpty()) {
      searchChannel(searchedText)
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun searchChannel(searchedText: String) {
    dismissProgressbar()
    showProgressbar()
    disposable.add(
      eRTCSDK.group()
        .getSearchedChannels(searchedText, null, null)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onSearchedListSuccess, this::onSearchedListError
        )
    )
  }

  private fun onSearchedListSuccess(channelList: List<GroupRecord>) {
    dismissProgressbar()
    if (channelList.isNullOrEmpty()) {
      tvNoChannel.text = getString(R.string.no_result_found)
      rvChannelList.visibility = View.GONE
      tvNoChannel.visibility = View.VISIBLE
      adapter = ChannelSearchAdapter(channelList as ArrayList<GroupRecord>, glideLazy, this)
      rvChannelList.adapter = adapter
    } else {
      tvNoChannel.visibility = View.GONE
      rvChannelList.visibility = View.VISIBLE
      adapter = ChannelSearchAdapter(channelList as ArrayList<GroupRecord>, glideLazy, this)
      rvChannelList.adapter = adapter
    }
  }

  private fun onSearchedListError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  @SuppressLint("CheckResult")
  override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    super.onActivityResult(requestCode, resultCode, data)
    if (data != null) {
      if (requestCode == UserSelectActivity.REQUEST_CODE_ADD_PARTICIPANTS) {
        selectedUser =
          data.getSerializableExtra(UserSelectActivity.EXTRA_SELECTED_PARTICIPANTS) as ArrayList<UserRecord>
        if (selectedUser.isNotEmpty()) {
          val userList = ArrayList<String?>()
          for (user in selectedUser) {
            userList.add(user.id)
          }
          disposable.add(
            eRTCSDK.group()
              .addParticipants(group?.groupId, userList)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe({
                showToastShort(getString(R.string.add_participant_group))
                dismissProgressbar()
              }, {
                setErrorAlert(it)
                dismissProgressbar()
              })
          )
        }
      } else if (requestCode == SelectAdminActivity.REQUEST_CODE_MAKE_ADMIN) {
        val selectedUser =
          data.getSerializableExtra(SelectAdminActivity.EXTRA_MAKE_ADMIN) as ArrayList<UserRecord>

        if (selectedUser.isNotEmpty()) {
          for ((index, user) in selectedUser.withIndex()) {
            disposable.add(
              eRTCSDK.group()
                .addAdmin(group?.groupId, user.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  dismissProgressbar()
                  if (index == (selectedUser.size - 1)) {
                    group?.let { it ->
                      exitGroup(it)
                    }
                  }
                }, {
                  setErrorAlert(it)
                })
            )
          }
        }
      }
    }
  }

  override fun onChannelSelected(groupRecord: GroupRecord) {
    if (groupRecord.isNotInGroup) {
      shortToast(getString(R.string.please_join_channel))
    } else {
      startActivity(ChatActivity.getGroupChatIntent(this, groupRecord, groupRecord.threadId))
    }
  }

  override fun onJoin(index: Int, groupRecord: GroupRecord) {
    val userList = ArrayList<String?>()
    userList.add(ERTCApplication.getSession(this).getUserId())

    showProgressbar()
    disposable.add(
      eRTCSDK.group()
        .addParticipants(groupRecord.groupId, userList)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          showToastShort(getString(R.string.join_group))
          adapter?.notifyOnJoined(index, it)
          dismissProgressbar()
        }, {
          setErrorAlert(it)
          dismissProgressbar()
        })
    )
  }

  override fun onLeaveChannel(
    index: Int,
    groupRecord: GroupRecord
  ) {
    group = groupRecord
    this.index = index
    if (groupRecord.groupType == GroupRecord.TYPE_PUBLIC) {
      leaveChannelDialog(groupRecord, getString(R.string.admin_leave_public_channel))
    } else {
      leaveChannelDialog(groupRecord, getString(R.string.admin_leave_private_channel))
    }
  }

  override fun onClearChat(index: Int, groupRecord: GroupRecord) {
    group = groupRecord
    this.index = index
    clearChatHistory()
  }

  override fun onMuteChannel(index: Int, groupRecord: GroupRecord) {
    group = groupRecord
    this.index = index

    muteNotifications(ChatType.GROUP)
  }

  override fun onAddMember(index: Int, groupRecord: GroupRecord) {
    group = groupRecord
    this.index = index

    val list = ArrayList<String>()
    for (user in groupRecord.groupUsers) {
      user.id?.let { list.add(it) }
    }
    startActivityForResult(
      UserSelectActivity.getIntent(context = applicationContext, groupId = groupRecord.groupId),
      UserSelectActivity.REQUEST_CODE_ADD_PARTICIPANTS
    )
  }

  private fun showExitAdminDialog() {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.admin_exit_alert)
    dialog.tvAlertInfo.text = getString(R.string.admin_exit_info)

    dialog.btnSubmit?.setOnClickListener {
      startActivityForResult(group?.groupId?.let { groupId ->
        SelectAdminActivity.getSelectAdminIntent(this, groupId)
      }, SelectAdminActivity.REQUEST_CODE_MAKE_ADMIN)
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }

  private fun leaveChannelDialog(groupRecord: GroupRecord, alertInfo: String) {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.admin_leave_alert)
    dialog.tvAlertInfo.text = alertInfo
    dialog.btnSubmit.text = getString(R.string.btn_leave)
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
      dialog.btnSubmit.setTextColor(getColor(R.color.group_exit_color))
    } else {
      dialog.btnSubmit.setTextColor(resources.getColor(R.color.group_exit_color))
    }

    dialog.btnSubmit?.setOnClickListener {
      exitGroup(groupRecord)
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }

  private fun exitGroup(groupRecord: GroupRecord) {
    showProgressbar()
    disposable.add(
      eRTCSDK.group()
        .exitGroup(groupRecord.groupId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onGroupExitSuccess, this::onGroupExitError
        )
    )
  }

  private fun onGroupExitSuccess(groupRecord: GroupRecord) {
    dismissProgressbar()
    shortToast(getString(R.string.left_group))
    //notify data set changed
    adapter?.notifyOnExit(index, groupRecord)
  }

  private fun onGroupExitError(throwable: Throwable) {
    dismissProgressbar()
    if (throwable.message?.contains("at least one admin present in channel") == true) {
      showExitAdminDialog()
    } else setErrorAlert(throwable)
  }

  private fun clearChatHistory() {
    if (!MediaUtil.isOnline(this)) {
      shortToast(getString(R.string.no_internet))
      return
    }

    val builder = AlertDialog.Builder(this)
    builder.setTitle("Clear Chat History?")
    builder.setMessage("The conversation will only be cleared for you.")

    builder.setPositiveButton(R.string.clear) { dialog, which ->
      showProgressbar()
      group?.threadId?.let { threadId ->
        disposable.add(eRTCSDK.chat()
          .clearChat(threadId)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({ result ->
            dismissProgressbar()
            result.message?.let { msg -> shortToast(msg) }
          }, { throwable -> setErrorAlert(throwable) })
        )
      }
    }

    builder.setNegativeButton(R.string.cancel) { dialog, which ->
    }

    builder.setCancelable(true)
    builder.show()
  }

  private fun muteNotifications(chatType: ChatType) {
    group?.threadId?.let {
      startActivity(NotificationsSettingActivity.getIntent(this, it, chatType.type))
    }
  }
}