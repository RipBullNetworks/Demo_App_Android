package com.ripbull.ertc.user.update

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import com.google.android.material.appbar.AppBarLayout
import com.ripbull.coreattachment.compressor.image.Compressor
import com.ripbull.coreattachment.compressor.image.constraint.format
import com.ripbull.coreattachment.compressor.image.constraint.quality
import com.ripbull.coreattachment.compressor.image.constraint.resolution
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.attachment.AttachmentManager
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.MediaUtil
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_update_user_profile.btnUpdate
import kotlinx.android.synthetic.main.activity_update_user_profile.etStatus
import kotlinx.android.synthetic.main.activity_update_user_profile.ivUserProfile
import kotlinx.android.synthetic.main.activity_update_user_profile.profileName
import kotlinx.android.synthetic.main.activity_update_user_profile.toolbar
import kotlinx.coroutines.launch
import java.io.File

class UpdateUserProfileActivity : BaseActivity() {

  private var user: UserRecord? = null
  private var menu: Menu? = null
  private var userId: String? = null
  private lateinit var attachmentManager: AttachmentManager
  private var cameraImage: File? = null
  private var filePath: String? = null
  private val disposable = CompositeDisposable()

  companion object {
    fun getIntent(context: Context, userId: String): Intent {
      val intent = Intent(context, UpdateUserProfileActivity::class.java)
      // To pass any data to next activity
      intent.putExtra("id", userId)
      return intent
    }
  }

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_update_user_profile)

    if (intent.hasExtra("id")) {
      userId = intent.getStringExtra("id")
    }

    if (userId == null) {
      showToastShort(getString(R.string.user_failure_message))
      finish()
    }

    btnUpdate.setOnClickListener {
      if (etStatus.text.toString().trim().isEmpty()){
        showToastShort(getString(R.string.profile_status_empty))
        return@setOnClickListener
      }
      showProgressbar()
      disposable.add(
        eRTCSDK.user().updateProfile(
          etStatus.text.toString().trim(), this.filePath.let { if(it.isNullOrEmpty()) "" else it },
          AttachmentManager.MediaType.IMAGE.toString()
        )
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            dismissProgressbar()
            finish()
          }, {
            dismissProgressbar()
            setErrorAlert(it)
          })
      )
    }

    etStatus.setOnTouchListener { v, event ->
      if (v.id == R.id.etStatus) {
        v.parent.requestDisallowInterceptTouchEvent(true)
        when (event.action and MotionEvent.ACTION_MASK) {
          MotionEvent.ACTION_UP -> v.parent.requestDisallowInterceptTouchEvent(false)
        }
      }
      false
    }

    etStatus.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(p0: Editable?) {
        if (etStatus.length() == 140) {
          etStatus.error = getString(R.string.max_limit)
        }
      }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
    })

    attachmentManager = AttachmentManager(this)
    setUserDetail()
  }

  private fun setUserDetail(){
    disposable.add(
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

  private fun onUserSuccess(user: UserRecord) {
    this.user = user
    setSupportActionBar(toolbar)
    // Now get the support action bar
    val actionBar = supportActionBar
    // Set toolbar title/app title
    actionBar!!.title = user.name

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

    user.profilePic?.let {
      glide.load(it).into(ivUserProfile)
    }

    user.name?.let { profileName.text = it }
    user.profileStatus?.let { etStatus.setText(it) }
  }

  private fun onUserError(throwable: Throwable) {
    setErrorAlert(throwable)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    this.menu = menu
    menuInflater.inflate(R.menu.user_profile_menu, menu)
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
      showDialog()
      return true
    }

    return super.onOptionsItemSelected(item)
  }

  private fun showDialog() {
    val builder = AlertDialog.Builder(this)
    builder.setItems(AppConstants.arrayProfilePic) { _, which ->
      try {
        when (which) {
          0 -> {
            cameraImage = attachmentManager.getPhotoImageFile(this)
            attachmentManager.capturePhoto(
                this, cameraImage!!
            )
          }
          1 -> AttachmentManager.selectGallery(this)
          2 -> {
            showProgressbar()
            disposable.add(
              eRTCSDK.user().removeProfilePic()
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe({
                    dismissProgressbar()
                    finish()
                  }, {
                    dismissProgressbar()
                    setErrorAlert(it)
                  })
            )
          }
        }
      } catch (e: IllegalArgumentException) {
        e.printStackTrace()
      }
    }
    val dialog = builder.create()
    dialog.show()
  }

  override fun onActivityResult(
    reqCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    super.onActivityResult(reqCode, resultCode, data)
    if (data == null && resultCode != Activity.RESULT_OK) {
      return
    }
    when (reqCode) {
      AttachmentManager.PICK_PHOTO -> {
        setFile(data!!.data)
      }
      AttachmentManager.TAKE_PHOTO -> {
        if ((data == null || data.data == null) && resultCode != Activity.RESULT_OK) {
          return
        } else if (cameraImage != null) {
          lifecycleScope.launch {
            val compressedImageFile = Compressor.compress(this@UpdateUserProfileActivity, cameraImage!!) {
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

  private fun setFile(uri: Uri?) {
    uri?.let {
      filePath = MediaUtil.compressImage(this, uri)
      glide.load(filePath).into(ivUserProfile)
    }
  }

}