package com.ripbull.ertc.onboard

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MuteNotificationType
import com.ripbull.coresdk.core.type.NotificationSettingsType
import com.ripbull.coresdk.core.type.SettingAppliedFor
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.notification.mapper.NotificationSettingRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.TimestampUtil
import com.ripbull.ertc.util.showToastShort
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.all_toolbar_dark.*
import kotlinx.android.synthetic.main.dialog_alert_info.btnCancel
import kotlinx.android.synthetic.main.dialog_alert_info.btnSubmit
import kotlinx.android.synthetic.main.dialog_alert_info.tvAlertInfo
import kotlinx.android.synthetic.main.dialog_alert_info.tvAlertTitle
import kotlinx.android.synthetic.main.fragment_notification_settings.*

class NotificationsSettingActivity: BaseActivity() {

  private val disposable = CompositeDisposable()
  private var threadId: String? = null
  private var chatType: ChatType = ChatType.SINGLE
  private var notificationSettingRecord: NotificationSettingRecord? = null

  companion object {
    @JvmStatic
    fun getIntent(context: Context, threadId: String, chatType: String): Intent {
      val intent = Intent(context, NotificationsSettingActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.CHAT_TYPE, chatType)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_notification_settings)
    tvTitle.text = getString(R.string.notifications)
    imgToolbarDP.visibility = View.GONE
    rlToolbar.gravity = Gravity.LEFT
    toolbar?.setNavigationIcon(R.drawable.ic_back_toolbar)
    toolbar?.setNavigationOnClickListener {
      finish()
    }

    threadId = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    if (intent.getStringExtra(AppConstants.CHAT_TYPE) == ChatType.GROUP.type) {
      chatType = ChatType.GROUP
    }
    if (threadId == null) {
      finish()
    }
    loadUI()
  }

  override fun onDestroy() {
    super.onDestroy()
    disposable.dispose()
  }

  private fun loadUI() {

    disposable.add(
      eRTCSDK.notification()
        .getSettings(threadId!!)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          notificationSettingRecord = it
          setMuteSettings(it)
        }, {
          setErrorAlert(it)
        })
    )

    /*disposable.add(
      eRTCSDK.chat().chatMetaDataOn(threadId!!).subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()
      ).subscribe({
        it.notificationSettings?.let { it1 -> setMuteSettings(it1) }
      }, {
        setErrorAlert(it)
      }
      )
    )*/

    rgMuteSettings.setOnCheckedChangeListener { group, checkedId ->
      when (checkedId) {
        R.id.rbAll     -> {
          tvApplyFor.visibility = View.GONE
          rgSettingsFor.visibility = View.GONE
          tvSettingInfo.visibility = View.GONE
          rbAlways.isChecked = true
        }
        R.id.rbMention -> {
          tvApplyFor.visibility = View.VISIBLE
          rgSettingsFor.visibility = View.VISIBLE
        }
        R.id.rbNone    -> {
          tvApplyFor.visibility = View.VISIBLE
          rgSettingsFor.visibility = View.VISIBLE
        }
      }
    }

    rgSettingsFor.setOnCheckedChangeListener { group, checkedId ->
      when (checkedId) {
        R.id.rbAlways     -> {
          tvSettingInfo.visibility = View.GONE
        }
        R.id.rb24Hours -> {
          tvSettingInfo.visibility = View.VISIBLE
          tvSettingInfo.text = "Note that after 24 hours the notification settings will be reset to allow all."
        }
        R.id.rb72Hours    -> {
          tvSettingInfo.visibility = View.VISIBLE
          tvSettingInfo.text = "Note that after 72 hours the notification settings will be reset to allow all."
        }
        R.id.rb1Week     -> {
          tvSettingInfo.visibility = View.VISIBLE
          tvSettingInfo.text = "Note that after 1 week the notification settings will be reset to allow all."
        }
        R.id.rb2Weeks -> {
          tvSettingInfo.visibility = View.VISIBLE
          tvSettingInfo.text = "Note that after 2 weeks the notification settings will be reset to allow all."
        }
        R.id.rb1Month    -> {
          tvSettingInfo.visibility = View.VISIBLE
          tvSettingInfo.text = "Note that after 1 month the notification settings will be reset to allow all."
        }
      }
    }

    btnUpdateSettings.setOnClickListener {
      val timePeriod = when (rgSettingsFor.checkedRadioButtonId) {
        R.id.rbAlways -> SettingAppliedFor.ALWAYS
        R.id.rb24Hours -> SettingAppliedFor.HOURS_24
        R.id.rb72Hours -> SettingAppliedFor.HOURS_72
        R.id.rb1Week -> SettingAppliedFor.WEEK_1
        R.id.rb2Weeks -> SettingAppliedFor.WEEKS_2
        R.id.rb1Month -> SettingAppliedFor.MONTH_1
        else           -> SettingAppliedFor.ALWAYS
      }

      threadId?.let { id ->
        when (rgMuteSettings.checkedRadioButtonId) {
          R.id.rbAll -> {
            muteNotifications(id, NotificationSettingsType.ALL.mute, chatType, timePeriod)
          }
          R.id.rbMention -> {
            muteNotifications(id, NotificationSettingsType.MENTIONS.mute, chatType, timePeriod)
          }
          R.id.rbNone -> {
            muteNotifications(id, NotificationSettingsType.NONE.mute, chatType, timePeriod)
          }
        }
      }
    }
  }

  private fun setMuteSettings(notificationSettingRecord: NotificationSettingRecord) {
    tv24Hours.visibility = View.GONE
    tv72Hours.visibility = View.GONE
    tv1Week.visibility = View.GONE
    tv2Weeks.visibility = View.GONE
    tv1Month.visibility = View.GONE

    when (notificationSettingRecord.allowFrom) {
      NotificationSettingsType.ALL.mute -> {
        rbAll.isChecked = true
        tvApplyFor.visibility = View.GONE
        rgSettingsFor.visibility = View.GONE
        tvSettingInfo.visibility = View.GONE
      }
      NotificationSettingsType.MENTIONS.mute -> {
        rbMention.isChecked = true
      }
      NotificationSettingsType.NONE.mute -> {
        rbNone.isChecked = true
      }
      else -> {
        rbAll.isChecked = true
      }
    }

    val startTime = System.currentTimeMillis()
    when (notificationSettingRecord.validTillValue) {
      SettingAppliedFor.ALWAYS.duration -> {
        rbAlways.isChecked = true
        tvSettingInfo.visibility = View.GONE
      }
      SettingAppliedFor.HOURS_24.duration -> {
        notificationSettingRecord.validTill?.let {
          val diff = TimestampUtil.getTimeDifference(startTime, it)
          if (diff.isNotEmpty()) {
            tv24Hours.visibility = View.VISIBLE
            tv24Hours.text = diff
          }
        }
        rb24Hours.isChecked = true
        tvSettingInfo.text = "Note that after 24 hours the notification settings will be reset to allow all."
      }
      SettingAppliedFor.HOURS_72.duration -> {
        notificationSettingRecord.validTill?.let {
          val diff = TimestampUtil.getTimeDifference(startTime, it)
          if (diff.isNotEmpty()) {
            tv72Hours.visibility = View.VISIBLE
            tv72Hours.text = diff
          }
        }
        rb72Hours.isChecked = true
        tvSettingInfo.text = "Note that after 72 hours the notification settings will be reset to allow all."
      }
      SettingAppliedFor.WEEK_1.duration -> {
        notificationSettingRecord.validTill?.let {
          val diff = TimestampUtil.getTimeDifference(startTime, it)
          if (diff.isNotEmpty()) {
            tv1Week.visibility = View.VISIBLE
            tv1Week.text = diff
          }
        }
        rb1Week.isChecked = true
        tvSettingInfo.text = "Note that after 1 week the notification settings will be reset to allow all."
      }
      SettingAppliedFor.WEEKS_2.duration -> {
        notificationSettingRecord.validTill?.let {
          val diff = TimestampUtil.getTimeDifference(startTime, it)
          if (diff.isNotEmpty()) {
            tv2Weeks.visibility = View.VISIBLE
            tv2Weeks.text = diff
          }
        }
        rb2Weeks.isChecked = true
        tvSettingInfo.text = "Note that after 2 weeks the notification settings will be reset to allow all."
      }
      SettingAppliedFor.MONTH_1.duration -> {
        notificationSettingRecord.validTill?.let {
          val diff = TimestampUtil.getTimeDifference(startTime, it)
          if (diff.isNotEmpty()) {
            tv1Month.visibility = View.VISIBLE
            tv1Month.text = diff
          }
        }
        rb1Month.isChecked = true
        tvSettingInfo.text = "Note that after 1 month the notification settings will be reset to allow all."
      }
      else -> {
        rbAlways.isChecked = true
        tvSettingInfo.visibility = View.GONE
      }
    }
  }

  private fun muteNotifications(
    threadId: String,
    action: String,
    chatType: ChatType,
    timePeriod: SettingAppliedFor = SettingAppliedFor.ALWAYS,
    isDelete: Boolean = false
  ) {
    if (!isDelete) {
      notificationSettingRecord?.let {
        if (AppConstants.validTill.contains(it.validTillValue) && timePeriod == SettingAppliedFor.ALWAYS) {
          notificationPopUp(action)
          return
        }
      }
    }

    showProgressbar()
    disposable.add(
      eRTCSDK.notification()
        .muteNotifications(action, MuteNotificationType.THREAD_LEVEL, timePeriod, threadId, chatType)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          notificationSettingRecord = it
          dismissProgressbar()
          shortToast(getString(R.string.notification_updated))
          setMuteSettings(it)
        }, { throwable ->
          dismissProgressbar()
          throwable.printStackTrace()

          if (throwable.cause != null) {
            if (throwable.cause?.message.isNullOrEmpty()) {
              setErrorMessage(throwable.message)
            } else {
              setErrorMessage(throwable.cause?.message)
            }

            if (throwable.cause?.message?.contains(getString(R.string.user_deactivated)) == true) {
              logoutApp()
            }
          } else if (throwable.message != null) {
            setErrorMessage(throwable.message)

            if (throwable.message?.contains(getString(R.string.user_deactivated)) == true) {
              logoutApp()
            }
          }
        })
    )
  }

  private fun setErrorMessage(errorMessage: String?) {
    errorMessage?.let {
      if (it.contains("Thread not found")) {
        showToastShort(getString(R.string.blocked_group_toast))
        setResult(RESULT_CANCELED)
        finish()
      } else {
        showToastShort(it)
      }
    }
  }

  private fun notificationPopUp(action: String) {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.dialog_alert_info)
    dialog.tvAlertTitle.text = getString(R.string.custom_notification_set)
    dialog.tvAlertInfo.text = getString(R.string.custom_notification_info)
    dialog.btnSubmit.text = getString(R.string.delete)
    dialog.btnCancel.text = getString(R.string.view)
    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      dialog.btnSubmit.setTextColor(getColor(R.color.group_exit_color))
    } else {
      dialog.btnSubmit.setTextColor(resources.getColor(R.color.group_exit_color))
    }

    dialog.btnSubmit?.setOnClickListener {
      threadId?.let { id ->
        muteNotifications(
          id,
          action,
          chatType,
          SettingAppliedFor.ALWAYS,
          true
        )
      }
      dialog.dismiss()
    }

    dialog.btnCancel?.setOnClickListener {
      when (notificationSettingRecord?.validTillValue) {
        SettingAppliedFor.HOURS_24.duration -> {
          rb24Hours.isChecked = true
        }
        SettingAppliedFor.HOURS_72.duration -> {
          rb72Hours.isChecked = true
        }
        SettingAppliedFor.WEEK_1.duration   -> {
          rb1Week.isChecked = true
        }
        SettingAppliedFor.WEEKS_2.duration  -> {
          rb2Weeks.isChecked = true
        }
        SettingAppliedFor.MONTH_1.duration  -> {
          rb1Month.isChecked = true
        }
      }
      dialog.dismiss()
    }

    dialog.show()
  }
}