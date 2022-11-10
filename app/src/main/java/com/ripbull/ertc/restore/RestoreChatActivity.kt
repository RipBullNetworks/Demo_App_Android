package com.ripbull.ertc.restore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.ripbull.coresdk.core.type.RestoreType
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.ertc.MainActivity
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.util.MediaUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_restore_chat.btnRestore
import kotlinx.android.synthetic.main.activity_restore_chat.btnSkip
import kotlinx.android.synthetic.main.activity_restore_chat.ivChatBackup
import kotlinx.android.synthetic.main.activity_restore_chat.progress
import kotlinx.android.synthetic.main.activity_restore_chat.tvBackupDescription
import kotlinx.android.synthetic.main.activity_restore_chat.tvBackupTitle
import kotlinx.android.synthetic.main.all_toolbar_dark.imgToolbarDP
import kotlinx.android.synthetic.main.all_toolbar_dark.toolbar

class RestoreChatActivity: BaseActivity() {

  private val disposable = CompositeDisposable()
  private var isRestored = false

  companion object {
    @JvmStatic
    fun newIntent(context: Context): Intent {
      return Intent(context, RestoreChatActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_restore_chat)
    chatToolBar(getString(R.string.restore_messages))
    imgToolbarDP.visibility = View.GONE
    toolbar.navigationIcon = null

    btnSkip.setOnClickListener {
      progress.startAnimation()
      disposable.add(
        eRTCSDK.chat().chatSkipRestore()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            startActivity(MainActivity.newIntent(this, true))
            finish()
          }, {
            setErrorAlert(it)
          })
      )
    }

    btnRestore.setOnClickListener {
      if (isRestored){
        startActivity(MainActivity.newIntent(this, true))
        finish()
      } else if (!MediaUtil.isOnline(this)) {
        shortToast(getString(R.string.no_internet))
      } else {
        progress.startAnimation()
        chatRestoration()
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun chatRestoration() {
    disposable.add(
      eRTCSDK.chat().chatRestore()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          progress.visibility = View.GONE
          progress.removeAnimation()
          ivChatBackup.setImageResource(R.drawable.restored_sucessfully)
          tvBackupTitle.text = resources.getString(R.string.restoreSuccessTitle)
          tvBackupDescription.text = resources.getString(R.string.restoreSuccessMessage)
          btnRestore.text = resources.getString(R.string.continueText)
          btnSkip.visibility = View.INVISIBLE
          isRestored = true
        }, {
          progress.removeAnimation()
          setErrorAlert(it)
        })
    )
  }
}