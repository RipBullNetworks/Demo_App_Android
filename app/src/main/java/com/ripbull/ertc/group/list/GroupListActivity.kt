package com.ripbull.ertc.group.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.addFragment

class GroupListActivity : BaseActivity() {

  var fragment: Fragment? = null
  var tag: String? = null

  companion object {
    @JvmStatic
    fun getIntent(
      context: Context
    ): Intent {
      return Intent(context, GroupListActivity::class.java)
    }

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_group_list)

    fragment = GroupListFragment.newInstance()
    tag = GroupListFragment.tag()

    if (fragment != null && tag != null) {
      addFragment(R.id.fragment_container, fragment!!, tag)
    }
  }
}
