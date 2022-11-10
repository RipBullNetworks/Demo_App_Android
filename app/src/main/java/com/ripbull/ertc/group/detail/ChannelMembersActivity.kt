package com.ripbull.ertc.group.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.setTitleColor
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.group.update.GroupActivity
import com.ripbull.ertc.group.userselect.UserSelectActivity
import com.ripbull.ertc.user.details.UserDetailsActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.StickyHeaderDecoration
import com.ripbull.ertc.util.recyclerview.AdapterCallback
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_channel_members.*

class ChannelMembersActivity: BaseActivity(), AdapterCallback<UserRecord>, ParticipantListAdapter.UserAdminAdapterListener {

  private lateinit var group: GroupRecord
  private lateinit var menu: Menu
  private var groupId: String? = null

  private var participants = ArrayList<UserRecord>()
  val adapter by lazy { ParticipantListAdapter(participants, glide as GlideRequests, this, this, this) }
  var selectedUser: ArrayList<UserRecord> = ArrayList()
  private val disposable = CompositeDisposable()

  private var threadID: String? = null

  companion object {

    @JvmStatic
    fun getChannelMemberIntent(id: String, context: Context, threadId: String? = null): Intent {
      val intent = Intent(context, ChannelMembersActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      return intent
    }
  }

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_channel_members)
    val toolbar = setTitleToolBar(getString(R.string.participants))

    toolbar.inflateMenu(R.menu.group_edit_menu)
    toolbar.setNavigationOnClickListener {
      onBackPressed()
    }
    menu = toolbar.menu
    menu.findItem(R.id.action_add_participants).setTitleColor(Color.WHITE)

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        android.R.id.home            -> {
          finish()
        }
        R.id.action_edit             -> {
          startActivity(group.let { GroupActivity.getGroupUpdateIntent(it, applicationContext) })
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

    disposable.add(
      eRTCSDK.group().subscribeToGroupUpdate().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if(group.groupId == it.groupId) {
            group = it
            loadUI(group)
          }
        }, {
          setErrorAlert(it)
        })
    )

  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  override fun onStart() {
    super.onStart()
    fetchData()
  }

  private fun fetchData() {
    groupId?.let {
      showProgressbar()
      getOnStartDisposable()?.add(
        eRTCSDK.group().getGroupById(it).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread()).subscribe(
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
  }

  private fun onGroupSuccess(groupRecord: GroupRecord) {
    loadUI(groupRecord)
    dismissProgressbar()
  }

  private fun initList() {
    if (participants.isEmpty()) {
      rvGroupUsers.visibility = View.GONE
    } else {
      rvGroupUsers.visibility = View.VISIBLE
      rvGroupUsers.layoutManager = LinearLayoutManager(applicationContext)
      rvGroupUsers.adapter = adapter
      rvGroupUsers.addItemDecoration(StickyHeaderDecoration(adapter, true, true))
      adapter.submitList(participants)

      if (group.groupType == GroupRecord.TYPE_PUBLIC) {
        menu.findItem(R.id.action_add_participants).isVisible = true
      } else menu.findItem(R.id.action_add_participants).isVisible = adapter.isAdmin
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
  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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
            eRTCSDK.group().addParticipants(groupId, userList).subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread()).subscribe({
                showToastShort(getString(R.string.add_participant_group))
                dismissProgressbar()
              },{
                setErrorAlert(it)
                dismissProgressbar()
              }
              )
          )
        }
      }
    }
  }

  override fun onAdminTrue(isAdmin: Boolean) {
    adapter.isAdmin = isAdmin
    invalidateOptionsMenu()
    if (adapter.isAdmin) {
      menu.findItem(R.id.action_add_participants).isVisible = true
    } else if (group.groupType == GroupRecord.TYPE_PRIVATE) {
      menu.findItem(R.id.action_add_participants).isVisible = false
    }
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

}