package com.ripbull.ertc.testing

import android.content.Context

import android.content.Intent
import android.content.SharedPreferences

class ApplicationSession(context: Context) {

  private val prefName = "eRTC"
  private val sharedPref: SharedPreferences =
    context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

  // All Shared Preferences Keys
  private val isLogin = "IsLoggedIn"
  private val userId = "userId"
  private val accessCode = "accessCode"

  /**
   * Create login session
   */
  fun createLoginSession() {
    val editor: SharedPreferences.Editor = sharedPref.edit()
    // Storing login value as TRUE
    editor.putBoolean(isLogin, true)
    // commit changes
    editor.apply()
  }

  /**
   * Create login session
   */
  @Deprecated("Old stuff", ReplaceWith("ChatEventType"))
  fun setUserId(userId: String) {
    val editor: SharedPreferences.Editor = sharedPref.edit()
    // Storing login value as TRUE
    editor.putString(this.userId, userId)
    // commit changes
    editor.apply()
  }

  /**
   * Clear session details
   */
  fun logoutUser(context: Context) {
    val editor: SharedPreferences.Editor = sharedPref.edit()
    // Clearing all data from Shared Preferences
    editor.putBoolean(isLogin, false)
    editor.apply()
  }

  /**
   * Quick check for login
   */
  // Get Login State
  fun isLoggedIn(): Boolean {
    return sharedPref.getBoolean(isLogin, false)
  }

  @Deprecated("Old stuff", ReplaceWith("ChatEventType"))
  fun getUserId(): String {
    val d = sharedPref.getString(userId, "")
    return d!!
  }

  /**
   * set Access Code for Sample Only.
   */
  fun setAccessCode(accessCode: String) {
    val editor: SharedPreferences.Editor = sharedPref.edit()
    // Storing Access Code(Api Key)
    editor.putString(this.accessCode, accessCode)
    // commit changes
    editor.apply()
  }

  fun getAccessCode(): String {
    return sharedPref.getString(accessCode, "")!!
  }
}