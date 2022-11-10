package com.ripbull.ertc.group.userselect

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ripbull.coresdk.user.mapper.UserRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.addFragment

class UserSelectActivity : BaseActivity() {

  var fragment: Fragment? = null
  var tag: String? = null

  companion object {
    @JvmStatic
    fun getIntent(
      context: Context,
      groupId: String? = null,
      selectedUsers: ArrayList<UserRecord> = ArrayList()
    ): Intent {
      val intent = Intent(context, UserSelectActivity::class.java)
      intent.putExtra(AppConstants.EXTRA_ID, groupId)
      intent.putExtra(EXTRA_SELECTED_PARTICIPANTS, selectedUsers)
      return intent
    }

    const val EXTRA_EXCEPTION_LIST = "participants"
    const val EXTRA_SELECTED_PARTICIPANTS = "participants"
    const val REQUEST_CODE = 22
    const val REQUEST_CODE_ADD_PARTICIPANTS = 23
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_user_select)

    val groupId = intent.getStringExtra(AppConstants.EXTRA_ID)
    val selectedUsers = (intent.getSerializableExtra(EXTRA_SELECTED_PARTICIPANTS) as ArrayList<UserRecord>?)!!

    fragment = UserSelectFragment.newInstance(groupId, selectedUsers)
    tag = UserSelectFragment.tag()

    if (fragment != null && tag != null) {
      addFragment(R.id.fragment_container, fragment!!, tag)
    }

  }

  override fun onBackPressed() {
    setResult(Activity.RESULT_CANCELED)
    finish()
  }
}
