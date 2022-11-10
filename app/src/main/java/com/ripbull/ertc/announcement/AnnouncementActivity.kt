package com.ripbull.ertc.announcement

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.AppConstants
import kotlinx.android.synthetic.main.activity_announcement.*
import kotlinx.android.synthetic.main.all_toolbar_dark.*

class AnnouncementActivity : BaseActivity() {

    private var details: String? = null
    private var name: String = "All Users"
    private var groupId: String? = null

    companion object {
        @JvmStatic
        fun getAnnouncementIntent(
            context: Context,
            details: String,
            groupId: String? = null,
            groupName: String? = null
        ): Intent {
            val intent = Intent(context, AnnouncementActivity::class.java)
            intent.putExtra(AppConstants.DETAILS, details)
            intent.putExtra(AppConstants.EXTRA_ID, groupId)
            intent.putExtra(AppConstants.NAME, groupName)
            return intent
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement)

        // Toolbar
        rlToolbar.gravity = Gravity.LEFT
        tvTitle.text = getString(R.string.announcement)
        imgToolbarDP.visibility = View.GONE

        toolbar?.setNavigationIcon(R.drawable.ic_cancel)
        toolbar?.setNavigationOnClickListener {
            this.finish()
        }

        details = intent.getStringExtra(AppConstants.DETAILS)
        if (intent.getStringExtra(AppConstants.NAME) != null) {
            name = intent?.getStringExtra(AppConstants.NAME) ?: ""
        }

        tvAnnouncementTitle.text = name
        tvAnnouncement.text = details
    }
}