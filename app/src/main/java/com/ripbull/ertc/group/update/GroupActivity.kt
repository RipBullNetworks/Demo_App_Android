package com.ripbull.ertc.group.update

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coreattachment.compressor.image.Compressor
import com.ripbull.coreattachment.compressor.image.constraint.format
import com.ripbull.coreattachment.compressor.image.constraint.quality
import com.ripbull.coreattachment.compressor.image.constraint.resolution
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.attachment.AttachmentManager
import com.ripbull.ertc.chat.chat.ChatActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.group.detail.ParticipantListAdapter
import com.ripbull.ertc.group.userselect.UserSelectActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.FileUtils
import com.ripbull.ertc.util.MediaUtil
import com.ripbull.ertc.util.StickyHeaderDecoration
import com.ripbull.ertc.util.recyclerview.AdapterCallback
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_group.btnUpdate
import kotlinx.android.synthetic.main.activity_group.edt_group_desc
import kotlinx.android.synthetic.main.activity_group.edt_group_name
import kotlinx.android.synthetic.main.activity_group.fabDone
import kotlinx.android.synthetic.main.activity_group.ivUserProfile
import kotlinx.android.synthetic.main.activity_group.rvGroupUsers
import kotlinx.android.synthetic.main.activity_group.tvGroupType
import kotlinx.android.synthetic.main.activity_group.tvNoParticipants
import kotlinx.android.synthetic.main.all_toolbar_dark.tvSubTitle
import kotlinx.coroutines.launch
import java.io.File

class GroupActivity : BaseActivity(), AdapterCallback<UserRecord> {

  var fragment: Fragment? = null
  var tag: String? = null
  var participants = ArrayList<UserRecord>()
  var groupDetail: GroupRecord? = null

  val adapter by lazy { ParticipantListAdapter(participants, glide as GlideRequests, this) }
  var selectedUser: ArrayList<UserRecord> = ArrayList()

  var type: Int = 0
  private lateinit var attachmentManager: AttachmentManager
  private var cameraImage: File? = null
  private var filePath: String? = null
  private val disposable = CompositeDisposable()

  companion object {
    @JvmStatic
    fun getGroupCreateIntent(
      participants: ArrayList<UserRecord>, context: Context, isPrivate: Boolean
    ): Intent {
      val intent = Intent(context, GroupActivity::class.java)
      intent.putExtra(EXTRA_TYPE, TYPE_CREATE)
      intent.putExtra(EXTRA_PARTICIPANTS, participants)
      intent.putExtra(EXTRA_GROUP_TYPE, isPrivate)
      return intent
    }

    @JvmStatic
    fun getGroupUpdateIntent(groupDetail: GroupRecord, context: Context): Intent {
      val intent = Intent(context, GroupActivity::class.java)
      intent.putExtra(EXTRA_TYPE, TYPE_UPDATE)
      intent.putExtra(EXTRA_GROUP_DETAIL, groupDetail)
      return intent
    }

    const val EXTRA_TYPE = "type"
    const val EXTRA_PARTICIPANTS = "participants"
    const val EXTRA_GROUP_DETAIL = "group_detail"
    const val EXTRA_GROUP_TYPE = "group_type"

    const val TYPE_UPDATE = 1
    const val TYPE_CREATE = 2
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_group)

    type = intent.getIntExtra(EXTRA_TYPE, TYPE_CREATE);
    if (type == TYPE_UPDATE) {
      initUpdateGroup()
    } else if (type == TYPE_CREATE) {
      initCreateGroup()
    }

    initRecyclerView()

    btnUpdate.setOnClickListener {
      val groupName = edt_group_name.text.toString().trim()
      val groupDesc = edt_group_desc.text.toString().trim()
      if (groupName.isEmpty()){
        shortToast(getString(R.string.group_name_mandatory))
        return@setOnClickListener
      }

      showProgressbar()
      getOnStartDisposable()?.add(eRTCSDK.group().updateGroupDetail(
        groupDetail?.groupId,
        groupName,
        groupDesc,
        this.filePath.let { if(it.isNullOrEmpty()) "" else it }
      ).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::onGroupUpdateSuccess, this::onGroupUpdateError)
      )
    }

    fabDone.setOnClickListener {
      val groupName = edt_group_name.text.toString().trim()
      val groupDesc = edt_group_desc.text.toString().trim()
      if (groupName.isEmpty()){
        shortToast(getString(R.string.group_name_mandatory))
        return@setOnClickListener
      }

      if (selectedUser.isEmpty()) {
        Toast.makeText(applicationContext, R.string.select_users, Toast.LENGTH_SHORT).show()
      } else {
        val groupRecord = GroupRecord(
          groupName,
          groupDesc,
          this.filePath.let { if(it.isNullOrEmpty()) "" else it },
          selectedUser
        )
        showProgressbar()
        if (intent.getBooleanExtra(EXTRA_GROUP_TYPE, false)) {
          getOnStartDisposable()?.add(
            eRTCSDK.group().createPrivateGroup(groupRecord)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(
                this::onGroupCreateSuccess, this::onGroupCreateError
              )
          )
        } else {
          getOnStartDisposable()?.add(
            eRTCSDK.group().createPublicGroup(groupRecord)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(
                this::onGroupCreateSuccess, this::onGroupCreateError
              )
          )
        }
      }
    }

    edt_group_desc.setOnTouchListener { v, event ->
      if (v.id == R.id.edt_group_desc) {
        v.parent.requestDisallowInterceptTouchEvent(true)
        when (event.action and MotionEvent.ACTION_MASK) {
          MotionEvent.ACTION_UP -> v.parent.requestDisallowInterceptTouchEvent(false)
        }
      }
      false
    }

    edt_group_desc.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(p0: Editable?) {
        if (edt_group_desc.length() == 240) {
          edt_group_desc.error = getString(R.string.max_limit)
        }
      }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    })

    attachmentManager = AttachmentManager(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun onGroupCreateSuccess(groupRecord: GroupRecord) {
    dismissProgressbar()
    Toast.makeText(applicationContext, R.string.group_create_success, Toast.LENGTH_SHORT).show()
    startActivity(ChatActivity.getGroupChatIntent(this, groupRecord, groupRecord.threadId))
    finish()
  }

  private fun onGroupCreateError(throwable: Throwable) {
    dismissProgressbar()
    setErrorAlert(throwable)
  }

  private fun onGroupUpdateSuccess(groupRecord: GroupRecord) {
    dismissProgressbar()
    shortToast(getString(R.string.group_update_success))
    finish()
  }

  private fun onAddParticipantsSuccess(groupRecord: GroupRecord) {
    dismissProgressbar()
    shortToast(getString(R.string.add_participant_group))
    finish()
  }

  private fun onGroupUpdateError(throwable: Throwable) {
    dismissProgressbar()
    setErrorAlert(throwable)
  }

  private fun initUpdateGroup() {
    edt_group_name.visibility = View.VISIBLE
    edt_group_desc.visibility = View.VISIBLE
    groupDetail = intent.getSerializableExtra(EXTRA_GROUP_DETAIL) as GroupRecord
    if (groupDetail != null) {
      edt_group_name.setText(groupDetail!!.name)
      edt_group_desc.setText(groupDetail!!.groupDesc)
      if (groupDetail!!.groupType == GroupRecord.TYPE_PUBLIC) {
        tvGroupType.text = getString(R.string.public_channel)
      } else {
        tvGroupType.text = getString(R.string.private_channel)
      }
      if (groupDetail!!.groupPic != null && groupDetail!!.groupPic.isNotEmpty()) {
        glide.load(groupDetail!!.groupPic).into(ivUserProfile)
      } else {
        ivUserProfile.setImageResource(R.drawable.ic_group)
      }
      participants = (groupDetail!!.groupUsers as ArrayList<UserRecord>?)!!

      disposable.add(
        eRTCSDK.group()
          .subscribeToGroupUpdate()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            if (groupDetail!!.groupId == it.groupId) {
              if (it.groupStatus == GroupRecord.STATUS_FROZEN) {
                finish()
              }
              participants = ((it.groupUsers as ArrayList<UserRecord>?)!!)
              for (participant in participants) {
                if (participant.id == ERTCApplication.getSession(this).getUserId()
                  && participant.role != AppConstants.ADMIN) {
                  shortToast(getString(R.string.removed_from_admin))
                  val intent = Intent()
                  intent.putExtra(AppConstants.REMOVE_FROM_ADMIN, false)
                  setResult(RESULT_OK, intent)
                  finish()
                }
              }
            }
          }, {
            setErrorAlert(it)
          })
      )
    } else {
      finish()
    }

    setToolbar(getString(R.string.update_group), participants.size)
  }

  private fun initCreateGroup() {
    fabDone.show()
    btnUpdate.visibility = View.GONE
    edt_group_name.visibility = View.VISIBLE
    edt_group_desc.visibility = View.VISIBLE
    if (intent.getBooleanExtra(EXTRA_GROUP_TYPE, false)) {
      tvGroupType.text = getString(R.string.private_channel)
    } else {
      tvGroupType.text = getString(R.string.public_channel)
    }
    participants = (intent.getSerializableExtra(EXTRA_PARTICIPANTS) as ArrayList<UserRecord>?)!!
    val intent = UserSelectActivity.getIntent(context = applicationContext, selectedUsers = selectedUser)
    startActivityForResult(intent, UserSelectActivity.REQUEST_CODE)

    setToolbar(getString(R.string.create_channel), participants.size)
  }

  private fun initRecyclerView() {
    if (participants.isEmpty()) {
      tvNoParticipants.visibility = View.VISIBLE
      rvGroupUsers.visibility = View.GONE
    } else {
      tvNoParticipants.visibility = View.GONE
      rvGroupUsers.visibility = View.VISIBLE
      rvGroupUsers.layoutManager = LinearLayoutManager(applicationContext)
      rvGroupUsers.adapter = adapter
      rvGroupUsers.addItemDecoration(StickyHeaderDecoration(adapter, true, true))
      adapter.submitList(participants)
    }
  }

  override fun onItemClick(t: UserRecord) {

  }

  override fun onItemLongClick(t: UserRecord): Boolean {
    return true
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (data == null && resultCode != Activity.RESULT_OK) {
      if (requestCode == UserSelectActivity.REQUEST_CODE
          || requestCode == UserSelectActivity.REQUEST_CODE_ADD_PARTICIPANTS) {
        finish()
      }
      return
    }

    when (requestCode) {
      UserSelectActivity.REQUEST_CODE -> {
        selectedUser = data!!.getSerializableExtra(UserSelectActivity.EXTRA_SELECTED_PARTICIPANTS) as ArrayList<UserRecord>
        tvNoParticipants.visibility = View.GONE
        rvGroupUsers.visibility = View.VISIBLE
        rvGroupUsers.layoutManager = LinearLayoutManager(applicationContext)
        rvGroupUsers.adapter = adapter
        rvGroupUsers.addItemDecoration(StickyHeaderDecoration(adapter, true, true))
        var list = ArrayList(participants)
        list.addAll(selectedUser)
        adapter.submitList(list)
        tvSubTitle.text = getString(R.string.no_of_participants, list.size)
      }
      UserSelectActivity.REQUEST_CODE_ADD_PARTICIPANTS -> {
        selectedUser = data!!.getSerializableExtra(UserSelectActivity.EXTRA_SELECTED_PARTICIPANTS) as ArrayList<UserRecord>
        if (selectedUser.isNotEmpty()) {
          val userList = ArrayList<String>()
          for (user in selectedUser) {
            user.id?.let { userList.add(it) }
          }
          getOnStartDisposable()?.add( eRTCSDK.group().addParticipants(groupDetail?.groupId, userList)
              .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                  this::onAddParticipantsSuccess, this::onGroupUpdateError
              ))
        }
      }
      AttachmentManager.PICK_PHOTO -> {
        setFile(data!!.data)
      }
      AttachmentManager.TAKE_PHOTO -> {
        if ((data == null || data.data == null) && resultCode != Activity.RESULT_OK) {
          return
        } else if (cameraImage != null) {
          lifecycleScope.launch {
            val compressedImageFile = Compressor.compress(this@GroupActivity, cameraImage!!) {
              resolution(1280, 720)
              quality(80) // combine with compressor constraint
              format(Bitmap.CompressFormat.JPEG)
            }
            setFile(Uri.fromFile(compressedImageFile))
          }
        } else {
          showToastShort(getString(R.string.invalid_image))
        }
      }
    }
  }

  private fun setToolbar(title: String, groupSize: Int) {
    val toolbar = setTitleToolBar(title)
    tvSubTitle.visibility = View.VISIBLE
    tvSubTitle.text = getString(R.string.no_of_participants, groupSize)
    toolbar.inflateMenu(R.menu.user_profile_menu)
    toolbar.setNavigationOnClickListener {
        onBackPressed()
    }
    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_edit_pp -> {
          showDialog(AppConstants.arrayProfilePic)
        }
        else -> {
        }
      }
      true
    }
  }

  override fun onBackPressed() {
    if (type == TYPE_CREATE && rvGroupUsers.visibility == View.VISIBLE){
      val intent = UserSelectActivity.getIntent(context = applicationContext, selectedUsers = selectedUser)
      startActivityForResult(intent, UserSelectActivity.REQUEST_CODE)
    }else{
      super.onBackPressed()
    }
  }

  private fun showDialog(arrayProfilePic: Array<String>) {
    val builder = AlertDialog.Builder(this)
    builder.setItems(arrayProfilePic) { _, which ->
      try {
        when (which) {
          0 -> {
            cameraImage = attachmentManager.getPhotoImageFile(this)
            attachmentManager.capturePhoto(this, cameraImage!!)
          }
          1 -> AttachmentManager.selectGallery(this)
          2 -> {
            if (type == TYPE_UPDATE) {
              showProgressbar()
              disposable.add(
                eRTCSDK.group().removeGroupPic(groupDetail?.groupId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                      dismissProgressbar()
                      ivUserProfile.setImageResource(R.drawable.ic_group)
                    }, {
                      dismissProgressbar()
                      setErrorAlert(it)
                    })
              )
            } else {
              filePath = null
              ivUserProfile.setImageResource(R.drawable.ic_group)
            }
          }
        }
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
      }
    }
    val dialog = builder.create()
    dialog.show()
  }

  private fun setFile(uri: Uri?) {
    uri?.let {
      val oldFilePath = FileUtils.getPath(this, it)
      filePath = MediaUtil.moveToProfilePictureFolder(File(oldFilePath))
      glide.load(filePath).into(ivUserProfile)
    }
  }
}
