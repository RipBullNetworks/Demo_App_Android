package com.ripbull.ertc.user.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.AvailabilityStatus
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.ScrollTo
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.ERTCApplication
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.gallery.MediaGalleryActivity
import com.ripbull.ertc.chat.starred.StarredMessagesActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.setDrawableLeft
import com.ripbull.ertc.group.detail.GalleryAdapter
import com.ripbull.ertc.onboard.NotificationsSettingActivity
import com.ripbull.ertc.user.update.UpdateUserProfileActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity : BaseActivity() {

  private var user: UserRecord? = null
  private var menu: Menu? = null
  private var userId: String? = null
  private val disposable = CompositeDisposable()
  private var threadID: String? = null

  companion object {
    @JvmStatic
    fun getUserDetailIntent(context: Context, id: String, threadId: String? = null): Intent {
      var intent = Intent(context, UserDetailsActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, id)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      return intent
    }
  }

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_user_details)

    if (eRTCSDK.tenant().projectType() == AppConstants.FREE_SAMPLE_APP) {
      rlGallery.visibility = View.GONE
      tvStarredMessages.visibility = View.GONE
    }

    if (intent.hasExtra(AppConstants.EXTRA_ID)) {
      userId = intent.getStringExtra(AppConstants.EXTRA_ID)
    }

    if (userId == null) {
      showToastShort(getString(R.string.user_failure_message))
      finish()
    }

    if (intent.hasExtra(AppConstants.EXTRA_THREAD_ID)) {
      threadID = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    }

    if (threadID != null) {
      initThreadDetails(threadID!!)
    } else if (threadID == null && ERTCApplication.getSession(this).getUserId() != userId) {
      rlGallery.visibility = View.GONE
      showProgressbar()
      disposable.add(eRTCSDK.chat().createThread(userId!!)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          threadID = it
          initThreadDetails(it)
          dismissProgressbar()
        }, {
          setErrorAlert(it)
          dismissProgressbar()
        })
      )
    } else {
      rlGallery.visibility = View.GONE
    }

    tvAvailabilityStatus.setOnClickListener {
      showStatusDialog()
    }

    tvBlockUser.setOnClickListener {
      showProgressbar()
      val action: String = if (user?.blockedStatus.equals(AppConstants.USER_BLOCKED)) {
        this.getString(R.string.unblock_user_action)
      } else {
        this.getString(R.string.block_user_action)
      }
      disposable.add(
        eRTCSDK.chat().blockUnblock(action, user?.id!!).subscribeOn(
          Schedulers.io()
        ).observeOn(
          AndroidSchedulers.mainThread()
        ).subscribe({
          if (action.equals(this.getString(R.string.block_user_action), true)) {
            this.showToastShort(this.getString(R.string.block_user_message))
            tvBlockedUser.visibility = View.VISIBLE
            user?.name?.let {
              tvBlockUser.text =
                """${resources.getString(R.string.menu_title_unblock_user)} $it"""
              tvBlockUser.setDrawableLeft(R.drawable.ic_unblock)
              tvBlockUser.setTextColor(ContextCompat.getColor(this, R.color.card_view_title))
            }
          } else {
            user?.name?.let {
              tvBlockUser.text =
                """${resources.getString(R.string.menu_title_block_user)} $it"""
              tvBlockUser.setDrawableLeft(R.drawable.ic_block)
              tvBlockUser.setTextColor(ContextCompat.getColor(this, R.color.audio_cancel_button_color))
            }
            this.showToastShort(this.getString(R.string.unblock_user_message))
            tvBlockedUser.visibility = View.GONE
          }
          dismissProgressbar()
        }, {
          dismissProgressbar()
          setErrorAlert(it)
        })
      )
    }

    disposable.add(
      eRTCSDK.user().subscribeToUserMetaData().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          if (it.id.equals(userId)) {
            it.availabilityStatus?.let { it1 -> setStatus(it1) }
          }
        }, {

        })
    )

    rlNotification.setOnClickListener {
      threadID?.let { threadID ->
        startActivity(NotificationsSettingActivity.getIntent(this, threadID, ChatType.SINGLE.type))
      }
    }

    tvStarredMessages.setOnClickListener {
      startActivity(StarredMessagesActivity.newIntent(this, threadID))
    }

    tvViewGallery.setOnClickListener {
      startActivity(
        user?.name?.let {
          MediaGalleryActivity.getIntent(this, it, threadID!!, ChatType.SINGLE.type)
        }
      )
    }
  }

  override fun onStart() {
    super.onStart()
    getOnStartDisposable()?.add(
      eRTCSDK.user().getUserById(this.userId!!)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::onUserSuccess,
          this::onUserError
        )
    )
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun onUserSuccess(user: UserRecord?) {
    this.user = user

    setSupportActionBar(toolbar)
    // Now get the support action bar
    val actionBar = supportActionBar
    // Set toolbar title/app title
    actionBar!!.title = user!!.name

    actionBar.setDisplayHomeAsUpEnabled(true)
    actionBar.setDisplayShowTitleEnabled(false)

    // Set action bar elevation
    actionBar.elevation = 4.0F

    val mAppBarLayout = findViewById<View>(R.id.ablContainer) as AppBarLayout
    mAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
      var isShow = false
      var scrollRange = -1

      override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
        if (scrollRange == -1) {
          scrollRange = appBarLayout.totalScrollRange
        }
        if (scrollRange + verticalOffset == 0) {
          isShow = true
          actionBar.setDisplayShowTitleEnabled(true)
        } else if (isShow) {
          isShow = false
          actionBar.setDisplayShowTitleEnabled(false)
        }
      }
    })

    if (user.profilePic != null) {
      glide.load(user.profilePic).into(ivUserProfile)
    } else {
      ivUserProfile.setImageResource(R.drawable.user_profile)
    }

    if (ERTCApplication.getSession(this).getUserId() != user.id) {
      tvAvailabilityStatus.isClickable = false
      if (threadID == null) {
        rlNotification.visibility = View.GONE
      }
    } else {
      rlNotification.visibility = View.GONE
      tvBlockUser.visibility = View.GONE
      tvStarredMessages.visibility = View.GONE
      rlGallery.visibility = View.GONE
    }

    tvEmailDetail.text = user.id
    if (user.blockedStatus.equals(AppConstants.USER_BLOCKED)) {
      user.name?.let {
        tvBlockUser.text =
          """${resources.getString(R.string.menu_title_unblock_user)} $it"""
        tvBlockUser.setDrawableLeft(R.drawable.ic_unblock)
        tvBlockUser.setTextColor(ContextCompat.getColor(this, R.color.card_view_title))
        tvBlockedUser.visibility = View.VISIBLE
      }
    } else {
      user.name?.let {
        tvBlockUser.text =
          """${resources.getString(R.string.menu_title_block_user)} $it"""
        tvBlockUser.setDrawableLeft(R.drawable.ic_block)
        tvBlockUser.setTextColor(ContextCompat.getColor(this, R.color.audio_cancel_button_color))
        tvBlockedUser.visibility = View.GONE
      }
    }

    user.name?.let { profileName.text = it }
    user.profileStatus?.let { tvStatus.text = it }

    user.availabilityStatus?.let {
      setStatus(it)
    }
  }

  private fun setStatus(it: String) {
    when (it) {
      AvailabilityStatus.AUTO.status      -> {
        tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_active)
        tvAvailabilityStatus.text = AppConstants.arrayStatus[0]
      }
      AvailabilityStatus.ONLINE.status    -> {
        tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_active)
        tvAvailabilityStatus.text = AppConstants.arrayStatus[0]
      }
      AvailabilityStatus.AWAY.status      -> {
        tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_away)
        tvAvailabilityStatus.text = AppConstants.arrayStatus[1]
      }
      AvailabilityStatus.DND.status       -> {
        tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_dnd)
        tvAvailabilityStatus.text = AppConstants.arrayStatus[3]
      }
      AvailabilityStatus.INVISIBLE.status -> {
        tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_invisible)
        tvAvailabilityStatus.text = AppConstants.arrayStatus[2]
      }
    }
  }

  private fun onUserError(throwable: Throwable) {
    setErrorAlert(throwable)
    finish()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    this.menu = menu
    menuInflater.inflate(R.menu.user_menu, menu)
    menu.findItem(R.id.action_edit_pp).isVisible =
      ERTCApplication.getSession(this).getUserId() == user!!.id
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    val id = item.itemId

    if (id == android.R.id.home) {
      finish()
      return true
    } else if (id == R.id.action_edit_pp) {
      // start your next activity
      startActivity(user!!.id?.let { UpdateUserProfileActivity.getIntent(this, it) })
      return true
    }

    return super.onOptionsItemSelected(item)
  }

  private fun showStatusDialog() {
    val builder = AlertDialog.Builder(this)
    builder.setItems(AppConstants.arrayStatus) { _, which ->
      try {
        showProgressbar()

        val status = when (which) {
          0    -> AvailabilityStatus.AUTO
          1    -> AvailabilityStatus.AWAY
          2    -> AvailabilityStatus.INVISIBLE
          3    -> AvailabilityStatus.DND
          else -> AvailabilityStatus.AUTO
        }
        disposable.add(
          eRTCSDK.user().setUserAvailability(status)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              tvAvailabilityStatus.text = AppConstants.arrayStatus[which]
              when (which) {
                0 -> {
                  tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_active)
                }
                1 -> {
                  tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_away)
                }
                2 -> {
                  tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_invisible)
                }
                3 -> {
                  tvAvailabilityStatus.setDrawableLeft(R.drawable.ic_status_dnd)
                }
              }
              dismissProgressbar()
            }, {
              setErrorAlert(it as Throwable)
              dismissProgressbar()
            })
        )
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
        dismissProgressbar()
      }
    }
    val dialog = builder.create()
    dialog.show()
  }

  private fun initThreadDetails(threadId: String) {
    if (eRTCSDK.tenant().projectType() != AppConstants.FREE_SAMPLE_APP) {
      rlGallery.visibility = View.VISIBLE
      disposable.add(eRTCSDK.chat()
        .getMediaGallery(threadId, null, ScrollTo.PAST.type, 10)
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
        })
    }
  }
}