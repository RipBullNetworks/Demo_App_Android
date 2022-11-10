package com.ripbull.ertc.group.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_select_admin.*
import kotlinx.android.synthetic.main.all_toolbar_dark.*

class SelectAdminActivity : BaseActivity(), SelectAdminAdapter.SelectAdminAdapterListener {

  var selectAdminAdapter: SelectAdminAdapter? = null
  private val disposable = CompositeDisposable()
  private var groupId: String? = null
  private lateinit var group: GroupRecord
  private var exceptList = ArrayList<String>()
  private var selectedUsers = ArrayList<UserRecord>()

  companion object {
    @JvmStatic
    fun getSelectAdminIntent(context: Context, id: String): Intent {
      val intent = Intent(context, SelectAdminActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      return intent
    }

    const val REQUEST_CODE_MAKE_ADMIN = 63
    const val EXTRA_MAKE_ADMIN = "admin"
  }

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_admin)
    val toolbar = setTitleToolBar(getString(R.string.select_admin))
    rlToolbar.gravity = Gravity.LEFT

    toolbar.setNavigationOnClickListener {
      onBackPressed()
    }

    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        android.R.id.home -> {
          finish()
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

    disposable.add(
      eRTCSDK.group().subscribeToGroupUpdate().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (group.groupId == it.groupId) {
            group = it
            loadUI(group)
          }
        }, {
          setErrorAlert(it)
        })
    )

    fabNext.setOnClickListener {
      if (selectAdminAdapter == null || selectAdminAdapter?.selectedUsers?.isEmpty() == null) {
        fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_disable_bg)))
        shortToast(getString(R.string.select_admin_alert))
      } else {
        val data = Intent()
        data.putExtra(
          EXTRA_MAKE_ADMIN,
          ArrayList(selectAdminAdapter?.selectedUsers!!)
        )
        setResult(RESULT_OK, data)
        finish()
      }
    }

    groupId?.let {
      showProgressbar()
      disposable.add(
        eRTCSDK.group().getGroupById(it).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread()).subscribe(
            this::onGroupSuccess, this::onGroupError
          )
      )
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun loadUI(groupRecord: GroupRecord) {
    this.group = groupRecord
    val participants = ArrayList<UserRecord>()
    val contacts = group.groupUsers as ArrayList<UserRecord>?
    contacts?.let {
      for (contact in it) {
        if (contact.id != ERTCApplication.getSession(this).getUserId())
        participants.add(contact)
      }
    }

    initList(participants)
  }

  private fun onGroupSuccess(groupRecord: GroupRecord) {
    loadUI(groupRecord)
    dismissProgressbar()
  }

  private fun initList(participants : ArrayList<UserRecord>) {
    if (participants.isEmpty()) {
      rvChannelUsers.visibility = View.GONE
    } else {
      rvChannelUsers.visibility = View.VISIBLE
      rvChannelUsers.layoutManager = LinearLayoutManager(this)
      rvChannelUsers.itemAnimator = DefaultItemAnimator()
      selectAdminAdapter = SelectAdminAdapter(participants, glide as GlideRequests, this)
      rvChannelUsers.adapter = selectAdminAdapter
      onUserSelected()
    }
  }

  private fun onGroupError(throwable: Throwable) {
    setErrorAlert(throwable)
    dismissProgressbar()
  }

  override fun onUserSelected() {
    if (selectAdminAdapter?.selectedUsers?.isEmpty() == true) {
      fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_disable_bg)))
    } else {
      fabNext.backgroundTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.fab_enable_bg)))
    }
  }
}