package com.ripbull.ertc.group.detail

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.ScrollTo
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.chat.gallery.MediaGalleryActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.group.update.GroupActivity
import com.ripbull.ertc.group.userselect.UserSelectActivity
import com.ripbull.ertc.onboard.NotificationsSettingActivity
import com.ripbull.ertc.user.details.UserDetailsActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.StickyHeaderDecoration
import com.ripbull.ertc.util.recyclerview.AdapterCallback
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_group_details.*
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.dialog_alert_info.*

class GroupDetailsActivity : BaseActivity(), AdapterCallback<UserRecord>, ParticipantListAdapter.UserAdminAdapterListener {

  private lateinit var group: GroupRecord
  private var menu: Menu? = null
  private var groupId: String? = null

  private var participants = ArrayList<UserRecord>()
  val adapter by lazy { ParticipantListAdapter(
    participants, glide as GlideRequests, this, this, this
  ) }
  var selectedUser: ArrayList<UserRecord> = ArrayList()
  private val disposable = CompositeDisposable()

  private var threadID: String? = null

  companion object {

    @JvmStatic
    fun getGroupViewIntent(
      id: String,
      context: Context,
      threadId: String? = null
    ): Intent {
      val intent = Intent(context, GroupDetailsActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      return intent
    }

    const val TYPE_UPDATE = 1
    const val REQUEST_REMOVED = 24
  }

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_group_details)

    if (eRTCSDK.tenant().projectType() == AppConstants.FREE_SAMPLE_APP) {
      rvGallery.visibility = View.GONE
    }

    if (intent.hasExtra(AppConstants.EXTRA_ID)) {
      groupId = intent.getStringExtra(AppConstants.EXTRA_ID)
    }

    if (groupId == null) {
      shortToast(getString(R.string.cant_fetch_group))
      finish()
    }

    if (intent.hasExtra(AppConstants.EXTRA_THREAD_ID)) {
      threadID = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    }

    exitGroup.setOnClickListener {
      var isOnlyAdmin = true
      if (participants.isNotEmpty()) {
        for (user in participants) {
          if (ERTCApplication.getSession(this).getUserId() != user.id && user.role == AppConstants.ADMIN) {
            isOnlyAdmin = false
          }
        }
      }

      when {
        isOnlyAdmin -> {
          showExitAdminDialog()
        }
        group.groupType == GroupRecord.TYPE_PUBLIC -> {
          leaveChannelDialog(getString(R.string.admin_leave_public_channel))
        }
        else -> {
          leaveChannelDialog(getString(R.string.admin_leave_private_channel))
        }
      }
    }

    disposable.add(
      eRTCSDK.group()
        .subscribeToGroupUpdate()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (group.groupId.equals(it.groupId)) {
            group = it
            loadUI(group)
          }
        }, {
          setErrorAlert(it)
        })
    )

    tvNotificationSettings.setOnClickListener {
      muteNotifications(ChatType.GROUP)
    }

  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  override fun onStart() {
    super.onStart()

    groupId?.let {
      showProgressbar()
      getOnStartDisposable()?.add(
        eRTCSDK.group()
          .getGroupById(it)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(
            this::onGroupSuccess, this::onGroupError
          )
      )
    }
  }

  private fun loadUI(groupRecord: GroupRecord) {
    if (groupRecord.groupStatus == GroupRecord.STATUS_FROZEN) {
      finish()
    }
    this.group = groupRecord
    participants = (group.groupUsers as ArrayList<UserRecord>?)!!
    initList()
    setToolBar()

    if (group.groupPic != null && group.groupPic!!.isNotEmpty()) {
      glide.load(group.groupPic).into(ivUserProfile)
    } else {
      ivUserProfile.setImageResource(R.drawable.ic_group)
    }

    tvDesc.text = group.groupDesc
    tvChannelName.text = group.name

    if (group.groupType == GroupRecord.TYPE_PUBLIC) {
      tvGroupType.text = getString(R.string.public_channel)
    } else {
      tvGroupType.text = getString(R.string.private_channel)
    }

    tvAddParticipants.setOnClickListener {
      startActivityForResult(
        UserSelectActivity.getIntent(context = applicationContext, groupId = groupId),
        UserSelectActivity.REQUEST_CODE_ADD_PARTICIPANTS
      )
    }

    tvViewAll.setOnClickListener {
      startActivity(groupId?.let { groupId ->
        ChannelMembersActivity.getChannelMemberIntent(groupId, this, threadID)
      })
    }

    tvViewGallery.setOnClickListener {
      startActivity(
        group.name?.let {
          MediaGalleryActivity.getIntent(this, it, threadID!!, ChatType.GROUP.type, group.groupId)
        }
      )
    }

    if (eRTCSDK.tenant().projectType() != AppConstants.FREE_SAMPLE_APP) {
      disposable.add(
        eRTCSDK.chat()
          .getMediaGallery(threadID!!, null, ScrollTo.PAST.type, 10)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            val msgList = it as ArrayList<MessageRecord>
            if (msgList.isNullOrEmpty()) {
              gridView.visibility = View.GONE
              tvViewGallery.visibility = View.INVISIBLE
              tvNoMedia.visibility = View.VISIBLE
              return@subscribe
            }

            val galleryAdapter = GalleryAdapter(this, msgList)
            gridView.adapter = galleryAdapter
            gridView.setOnItemClickListener { _, _, position, _ ->
              val messageRecord = msgList[position]
              if (messageRecord.msgType == MessageType.IMAGE.type) {
                openImage(
                  messageRecord.id, messageRecord.mediaPath, msgList[position].senderId, "",
                  messageRecord.type, messageRecord.timestamp
                )
              } else if (messageRecord.msgType == MessageType.VIDEO.type) {
                openVideo(
                  messageRecord.id, messageRecord.mediaPath, messageRecord.senderId,
                  messageRecord.type, messageRecord.timestamp, messageRecord.msgType
                )
              } else {
                openVideo(
                  messageRecord.id, messageRecord.mediaPath, messageRecord.senderId,
                  messageRecord.type, messageRecord.timestamp, messageRecord.msgType
                )
              }
            }
          }) {
            setErrorAlert(it)
          }
      )
    }
  }

  private fun setToolBar() {
    val toolbar = setTitleToolBar("Channel Info")
    tvSubTitle.visibility = View.VISIBLE
    tvSubTitle.text = "" + (group.groupUsers as ArrayList<UserRecord>).size + " participants"
    toolbar.setNavigationOnClickListener {
      onBackPressed()
    }

    toolbar.inflateMenu(R.menu.group_edit_menu)
    if (group.groupType == GroupRecord.TYPE_PUBLIC) {
      tvAddParticipants.visibility = View.VISIBLE
    }

    if (adapter.isAdmin) {
      tvAddParticipants.visibility = View.VISIBLE
    } else if (group.groupType == GroupRecord.TYPE_PRIVATE) {
      tvAddParticipants.visibility = View.GONE
    }
    toolbar.menu.findItem(R.id.action_edit).isVisible = adapter.isAdmin

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        android.R.id.home -> {
          finish()
        }
        R.id.action_edit -> {
          startActivityForResult(group.let {
            GroupActivity.getGroupUpdateIntent(
              it,
              applicationContext
            )
          }, TYPE_UPDATE)
        }
        R.id.action_add_participants -> {
          startActivityForResult(
            UserSelectActivity.getIntent(context = applicationContext, groupId = groupId),
            UserSelectActivity.REQUEST_CODE_ADD_PARTICIPANTS
          )
        }
      }
      true
    }
  }

  private fun onGroupSuccess(groupRecord: GroupRecord) {
    loadUI(groupRecord)
    dismissProgressbar()
  }

  private fun initList() {
    if (participants.isEmpty()) {
      //      tvNoParticipants.visibility = View.VISIBLE
      rvGroupUsers.visibility = View.GONE
    } else {
      //      tvNoParticipants.visibility = View.GONE
      rvGroupUsers.visibility = View.VISIBLE
      rvGroupUsers.layoutManager = LinearLayoutManager(applicationContext)
      rvGroupUsers.adapter = adapter
      rvGroupUsers.addItemDecoration(StickyHeaderDecoration(adapter, true, true))
      adapter.isAdmin = false
      if (participants.size < 4) {
        adapter.submitList(participants)
      } else {
        val list = participants.sortedBy { it.role }
        adapter.submitList(list.take(3))
      }

      if (group.groupType == GroupRecord.TYPE_PUBLIC) {
        tvAddParticipants.visibility = View.VISIBLE
      } else if (adapter.isAdmin) {
        tvAddParticipants.visibility = View.VISIBLE
      } else {
        tvAddParticipants.visibility = View.GONE
      }
    }
  }

  private fun onGroupError(throwable: Throwable) {
    setErrorAlert(throwable)
    dismissProgressbar()
  }

  override fun onItemClick(userRecord: UserRecord) {
    if (ERTCApplication.getSession(this).getUserId() != userRecord.id) {
      if (adapter.isAdmin) {
        userRecord.role?.let {
          if (it.equals(AppConstants.USER)) {
            showDialog(userRecord, AppConstants.arrayGroupAddAdminAction)
          } else {
            showDialog(userRecord, AppConstants.arrayGroupDismissAdminAction)
          }
        }
      } else {
        showDialog(userRecord, AppConstants.arrayGroupUserAction)
      }
    }
  }

  override fun onItemLongClick(t: UserRecord): Boolean {
    return true
  }

  @SuppressLint("CheckResult")
  override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == REQUEST_REMOVED && resultCode != RESULT_OK) {
      finish()
      return
    }

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
              .addParticipants(groupId, userList)
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
                .addAdmin(groupId, user.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  dismissProgressbar()
                  if (index == (selectedUser.size - 1)) {
                    exitGroup()
                    /*if (group.groupType == GroupRecord.TYPE_PUBLIC) {
                      leaveChannelDialog(getString(R.string.admin_leave_public_channel))
                    } else {
                      leaveChannelDialog(getString(R.string.admin_leave_private_channel))
                    }*/
                    loadUI(it)
                  }
                }, {
                  setErrorAlert(it)
                })
            )
          }
        }
      }  else if (requestCode == TYPE_UPDATE) {
        val isAdmin = data.getBooleanExtra(AppConstants.REMOVE_FROM_ADMIN, true)
        adapter.isAdmin = isAdmin
        setToolBar()
      }
    }
  }

  private fun onAddAdminSuccess(groupRecord: GroupRecord) {
    shortToast(getString(R.string.add_as_admin))
    dismissProgressbar()
    loadUI(groupRecord)
  }

  private fun onRemoveAdminSuccess(groupRecord: GroupRecord) {
    shortToast(getString(R.string.remove_from_admin))
    dismissProgressbar()
    loadUI(groupRecord)
  }

  private fun onRemoveParticipantSuccess(groupRecord: GroupRecord) {
    shortToast(getString(R.string.remove_participant_group))
    dismissProgressbar()
    loadUI(groupRecord)
  }

  private fun onGroupUpdateError(throwable: Throwable) {
    dismissProgressbar()
    setErrorAlert(throwable)
  }

  private fun exitGroup() {
    showProgressbar()
    disposable.add(
      eRTCSDK.group()
        .exitGroup(groupId)
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
    val intent = Intent()
    intent.putExtra(AppConstants.EXTRA_EXIT_TYPE, AppConstants.TYPE_EXIT)
    setResult(AppConstants.GROUP_REQUEST_CODE, intent)
    finish()
  }

  private fun onGroupExitError(throwable: Throwable) {
    dismissProgressbar()
    if (throwable.message?.contains("at least one admin present in channel") == true) {
      showExitAdminDialog()
    } else setErrorAlert(throwable)
  }

  private fun showDialog(
    userRecord: UserRecord,
    arrayContactOption: Array<String>
  ) {
    val builder = AlertDialog.Builder(this)
    builder.setItems(arrayContactOption) { _, which ->
      try {
        when (which) {
          0 -> {
            showProgressbar()
            disposable.add(
              eRTCSDK.chat()
                .createThread(userRecord.id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(
                  AndroidSchedulers.mainThread()
                )
                .subscribe({
                  startActivity(userRecord.id?.let { it1 ->
                    ChatActivity.getChatIntent(applicationContext, it1, it)
                  })
                  dismissProgressbar()
                }, {
                  setErrorAlert(it)
                  dismissProgressbar()
                })
            )
          }
          1 -> {
            userRecord.id?.let { userId ->
              startActivity(UserDetailsActivity.getUserDetailIntent(this, userId))
            }
          }
          2 -> {
            if (!TextUtils.isEmpty(userRecord.role) && userRecord.role == AppConstants.USER) {
              showProgressbar()
              disposable.add(
                eRTCSDK.group()
                  .addAdmin(groupId, userRecord.id)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(
                    this::onAddAdminSuccess, this::onGroupUpdateError
                  )
              )
            } else {
              showProgressbar()
              disposable.add(
                eRTCSDK.group()
                  .removeAdmin(groupId, userRecord.id)
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(
                    this::onRemoveAdminSuccess, this::onGroupUpdateError
                  )
              )
            }
          }
          3 -> {
            AlertDialog.Builder(this)
              .setTitle(R.string.remove_user)
              .setMessage("Remove " + userRecord.name + " from the group?")
              .setPositiveButton(R.string.logout_yes) { _, _ ->
                val userList = ArrayList<String?>()
                userList.add(userRecord.id)
                showProgressbar()
                disposable.add(
                  eRTCSDK.group()
                    .removeParticipants(group.groupId, userList)
                    .subscribeOn(
                      Schedulers.io()
                    )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                      this::onRemoveParticipantSuccess, this::onGroupUpdateError
                    )
                )
              }
              .setNegativeButton(R.string.logout_no, null)
              .show()
          }
        }
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
      }
    }
    val dialog = builder.create()
    dialog.show()
  }

  override fun onAdminTrue(isAdmin: Boolean) {
    adapter.isAdmin = isAdmin
    setToolBar()
  }

  private fun muteNotifications(chatType: ChatType) {
    threadID?.let {
      startActivityForResult(
        NotificationsSettingActivity.getIntent(this, it, chatType.type), REQUEST_REMOVED
      )
    }
  }

  private fun showExitAdminDialog() {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.admin_exit_alert)
    dialog.tvAlertInfo.text = getString(R.string.admin_exit_info)

    dialog.btnSubmit?.setOnClickListener {
      startActivityForResult(groupId?.let { groupId ->
        SelectAdminActivity.getSelectAdminIntent(this, groupId)
      }, SelectAdminActivity.REQUEST_CODE_MAKE_ADMIN)
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }

  private fun leaveChannelDialog(alertInfo: String) {
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
      exitGroup()
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }
}