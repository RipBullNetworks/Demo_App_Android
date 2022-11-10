package com.ripbull.ertc.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.webkit.URLUtil
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
import kotlinx.android.synthetic.main.activity_show_image.ivShowImage
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.dialog_media_info.*
import kotlinx.android.synthetic.main.dialog_media_info.tvCreatedAt
import kotlinx.android.synthetic.main.dialog_media_info.tvName
import java.io.File

class ShowImageActivity : BaseActivity() {

  private var userId: String? = null
  private var imagePath: String? = null
  private var chatType: String? = null
  private var threadType: String? = null
  private var msgId: String? = null
  private var createdAt: Long = System.currentTimeMillis()
  private var userRecord: UserRecord? = null
  private var size: String = "800 * 640"

  companion object {
    @JvmStatic
    fun showImageIntent(
      context: Context,
      msgId: String,
      path: String?,
      userId: String?,
      chatType: String,
      threadType: String?,
      createdAt: Long?,
      isMenu: Boolean = false
    ): Intent {
      val intent = Intent(context, ShowImageActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, msgId)
      intent.putExtra(AppConstants.EXTRA_URL, path)
      intent.putExtra(AppConstants.USER_ID, userId)
      intent.putExtra(AppConstants.CHAT_TYPE, chatType)
      intent.putExtra(AppConstants.THREAD_TYPE, threadType)
      intent.putExtra(AppConstants.IS_MENU, isMenu)
      intent.putExtra(AppConstants.CREATED_AT, createdAt)
      return intent
    }
  }

  override fun onCreate(@Nullable savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_show_image)

    if (intent.extras != null) {
      imagePath = intent.getStringExtra(AppConstants.EXTRA_URL)
      userId = intent.getStringExtra(AppConstants.USER_ID)
      chatType = intent.getStringExtra(AppConstants.CHAT_TYPE)
      threadType = intent.getStringExtra(AppConstants.THREAD_TYPE)
      msgId = intent.getStringExtra(AppConstants.EXTRA_ID)
      createdAt = intent.getLongExtra(AppConstants.CREATED_AT, System.currentTimeMillis())

      if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
        setTitleToolBar(getString(R.string.channel_gallery))
      } else {
        setTitleToolBar(getString(R.string.gallery))
      }
      rlToolbar.gravity = Gravity.LEFT

      if (imagePath == null) {
        showToastShort(getString(R.string.media_not_found))
        finish()
      } else {
        if (chatType == "incoming" || URLUtil.isValidUrl(imagePath)) {
          glide.load(imagePath).into(ivShowImage)
        } else if (chatType == "outgoing") {
          glide.load(File(imagePath)).into(ivShowImage)
        } else {
          glide.load(imagePath).into(ivShowImage)
        }
      }

      if (intent.getBooleanExtra(AppConstants.IS_MENU, false)) {
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
                this, msgId, imagePath, MessageType.IMAGE.type, chatType
              ))
            }
            R.id.action_share -> {
              val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, Uri.parse(imagePath))
                type = "image/*"
              }
              startActivity(Intent.createChooser(shareIntent, resources.getText(R.string.send_to)))
            }
            R.id.action_info -> {
              showMediaDetails(userRecord?.name, imagePath, createdAt)
            }
          }
          true
        }
      }

      userId?.let {
        getOnCreateDisposable()?.add(
          eRTCSDK.user().getUserById(it)
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
  }

  private fun showMediaDetails(userName: String?, path: String?, createdAt: Long) {
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