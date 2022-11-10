package com.ripbull.ertc.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.MediaController
import androidx.annotation.Nullable
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.chat.gallery.forward.ForwardMediaGalleryActivity
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.recepients.Recipient
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.MediaUtil
import com.ripbull.ertc.util.TimestampUtil
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_video_player.ivAudio
import kotlinx.android.synthetic.main.activity_video_player.mVideoView
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.dialog_media_info.*

class VideoPlayerActivity : BaseActivity() {

  private var userId: String? = null
  private var videoPath: String? = null
  private var mediaController: MediaController? = null
  private var msgId: String? = null
  private var threadType: String? = null
  private var createdAt: Long = System.currentTimeMillis()
  private var userRecord: UserRecord? = null
  private var size: String = "600 * 540"

  companion object {
    @JvmStatic
    fun videoPlayerIntent(
      context: Context,
      msgId: String,
      path: String?,
      userId: String?,
      threadType: String?,
      createdAt: Long?,
      msgType: String?
    ): Intent {
      val intent = Intent(context, VideoPlayerActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, msgId)
      intent.putExtra(AppConstants.EXTRA_URL, path)
      intent.putExtra(AppConstants.USER_ID, userId)
      intent.putExtra(AppConstants.THREAD_TYPE, threadType)
      intent.putExtra(AppConstants.CREATED_AT, createdAt)
      intent.putExtra(AppConstants.CHAT_TYPE, msgType)
      intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      return intent
    }
  }

  override fun onCreate(@Nullable savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_video_player)

    if (intent.extras != null) {
      videoPath = intent.getStringExtra(AppConstants.EXTRA_URL)
      userId = intent.getStringExtra(AppConstants.USER_ID)
      msgId = intent.getStringExtra(AppConstants.EXTRA_ID)
      threadType = intent.getStringExtra(AppConstants.THREAD_TYPE)
      createdAt = intent.getLongExtra(AppConstants.CREATED_AT, System.currentTimeMillis())
      val msgType = intent.getStringExtra(AppConstants.CHAT_TYPE)

      if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
        setTitleToolBar(getString(R.string.channel_gallery))
      } else {
        setTitleToolBar(getString(R.string.gallery))
      }
      rlToolbar.gravity = Gravity.LEFT

      if (videoPath == null) {
        showToastShort(getString(R.string.video_not_found))
        finish()
      }

      var mediaType = "video/*"
      if (msgType == MessageType.AUDIO.type) {
        mediaType = "audio/*"
        size = "Not Applicable"
        ivAudio.visibility = View.VISIBLE
      } else {
        //size = MediaUtil.getIMGSize(Uri.parse(videoPath))
      }

      toolbar.inflateMenu(R.menu.media_gallery_menu)
      toolbar.setOnMenuItemClickListener {
        when (it.itemId) {
          android.R.id.home -> {
            finish()
          }
          R.id.action_forward -> {
            var chatType = ChatType.SINGLE
            if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
              chatType = ChatType.GROUP
            }
            startActivity(
              ForwardMediaGalleryActivity.getForwardMediaIntent(
                this, msgId, videoPath, MessageType.VIDEO.type, chatType
              )
            )
          }
          R.id.action_share -> {
            val shareIntent: Intent = Intent().apply {
              action = Intent.ACTION_SEND
              putExtra(Intent.EXTRA_STREAM, Uri.parse(videoPath))
              type = mediaType
            }
            startActivity(Intent.createChooser(shareIntent, resources.getText(R.string.send_to)))
          }
          R.id.action_info -> {
            showMediaDetails(userRecord?.name, videoPath, createdAt)
          }
        }
        true
      }

      userId?.let {
        getOnCreateDisposable()?.add(
            eRTCSDK.user()
                .getUserById(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                  userRecord = it
                }, {
                  setErrorAlert(it)
                })
        )
      }
    } else {
      showToastShort(getString(R.string.failure_message))
      finish()
    }

    if (userId == null) {
      showToastShort(getString(R.string.failure_message))
      finish()
    }

    mVideoView.setVideoPath(videoPath)

    mediaController = MediaController(this)
    mediaController!!.setAnchorView(mVideoView)
    mediaController!!.setMediaPlayer(mVideoView)
    mVideoView.setMediaController(mediaController)

    mVideoView.setOnPreparedListener { mp ->
      mp.isLooping = false
    }
    mVideoView.start()
  }

  private fun showMediaDetails(
    userName: String?,
    path: String?,
    createdAt: Long
  ) {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(true)
    dialog.setContentView(R.layout.dialog_media_info)

    val recipient = Recipient(userRecord?.name, null, null)
    if (userRecord?.profileThumb.isNullOrEmpty()) {
      dialog.contactDP.setAvatar(glide as GlideRequests, recipient)
    } else {
      glide.load(userRecord?.profileThumb).circleCrop().into(dialog.contactDP)
    }

    dialog.tvName.text = userName
    dialog.tvCreatedAt.text = TimestampUtil.getCreatedAt(createdAt)
    dialog.tvFileName.text = MediaUtil.getFileName(path)
    dialog.tvSize.text = size

    dialog.btnClose?.setOnClickListener {
      dialog.dismiss()
    }

    dialog.show()
  }
}