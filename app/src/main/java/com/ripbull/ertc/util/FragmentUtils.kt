package com.ripbull.ertc.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

/**
 * @author meeth
 */
fun Fragment.replaceFragment(
  @IdRes layout: Int, fragment: Fragment, tag: String? = null, addToBackStack: Boolean = false
) {
  val replace = fragmentManager!!.beginTransaction().replace(layout, fragment, tag)
  if (addToBackStack) {
    replace.addToBackStack(tag)
  }
  try {
    replace.commit()
  } catch (e: Exception) {
    replace.commitAllowingStateLoss()
  }
}

fun Fragment.toggleKeyboard(isVisible: Boolean) {
  val imm = activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  //Find the currently focused view, so we can grab the correct window token from it.
  var view = activity!!.currentFocus
  //If no view currently has focus, create a new one, just so we can grab a window token from it
  if (view == null) {
    view = View(activity)
  }

  if (isVisible) {
    imm.showSoftInputFromInputMethod(view.windowToken, 0)
  } else {
    imm.hideSoftInputFromWindow(view.windowToken, 0)
  }

}

fun Fragment.hideKeyBoard(@Nullable view: View?) {
  try {
    if (view != null) {
      val inputManager =
        activity!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
      inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
  } catch (e: Exception) {
    e.printStackTrace()
  }
}