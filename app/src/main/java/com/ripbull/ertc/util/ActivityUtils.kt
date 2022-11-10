package com.ripbull.ertc.util

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/**
 * @author meeth
 */
inline fun <reified T : Fragment> FragmentActivity.findFragmentById(@IdRes layout: Int): T? {
  val fragment: Fragment? = supportFragmentManager.findFragmentById(layout)
  if (fragment != null && fragment is T) {
    return fragment
  }
  return null
}

inline fun <reified T : Fragment> FragmentActivity.findFragmentByTag(tag: String): T? {
  val fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
  if (fragment != null && fragment is T) {
    return fragment
  }
  return null
}

fun FragmentActivity.onBackPressed(fm: FragmentManager?): Boolean {
  if (fm != null) {
    val fragmentList = fm.fragments
    if (fragmentList.size > 0) {
      for (fragment in fragmentList) {
        if (fragment.isVisible && fragment.childFragmentManager.backStackEntryCount > 0) {
          fragment.childFragmentManager.popBackStack()
          return true
        }
      }
    }

    if (fm.backStackEntryCount > 0) {
      fm.popBackStack()
      return true
    }
  }
  return false
}

fun FragmentActivity.replaceFragment(@IdRes layout: Int, fragment: Fragment, tag: String? = null) {
  val replace = supportFragmentManager.beginTransaction()
      .replace(layout, fragment, tag)
  try {
    replace.commit()
  } catch (e: Exception) {
    replace.commitAllowingStateLoss()
  }
}

fun FragmentActivity.toggleKeyboard(isVisible: Boolean) {
  val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  //Find the currently focused view, so we can grab the correct window token from it.
  var view = currentFocus
  //If no view currently has focus, create a new one, just so we can grab a window token from it
  if (view == null) {
    view = View(this)
  }

  if (isVisible) {
    imm.showSoftInputFromInputMethod(view.windowToken, 0)
  } else {
    imm.hideSoftInputFromWindow(view.windowToken, 0)
  }

}

fun FragmentActivity.showToastLong(message: String?) {
  if (message != null) {
    Toast.makeText(this, message, Toast.LENGTH_LONG)
        .show()
  }
}

fun FragmentActivity.showToastShort(message: String?) {
  if (message != null) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT)
        .show()
  }
}

fun FragmentActivity.addFragment(@IdRes layout: Int, fragment: Fragment, tag: String? = null) {
  val add = supportFragmentManager.beginTransaction()
          .add(layout, fragment, tag)
  try {
    add.commit()
  } catch (e: Exception) {
    add.commitAllowingStateLoss()
  }
}

fun FragmentActivity.hideKeyBoard(@Nullable view: View?) {
  try {
    if (view != null) {
        val inputManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
  } catch (e: Exception) {
    e.printStackTrace()
  }
}