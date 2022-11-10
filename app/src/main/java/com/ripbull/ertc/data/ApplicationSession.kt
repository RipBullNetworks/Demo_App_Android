package com.ripbull.ertc.data

import android.content.Context

class ApplicationSession(context: Context) {

  private val prefName = "eRTC"
  private val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

  // All Shared Preferences Keys
  private val isLogin = "IsLoggedIn"
  private val userId = "userId"
  private val accessCode = "accessCode"
  private val isGlobalSearch = "isGlobalSearch"
  private val globalSearch = "globalSearch"

  /**
   * Create login session
   */
  fun createLoginSession(userId: String) {
    val editor = sharedPref.edit()
    // Storing login value as TRUE
    editor.putBoolean(isLogin, true)
    editor.putString(this.userId, userId)
    // commit changes
    editor.apply()
  }

  /**
   * Create login session
   */
  @Deprecated("Old stuff",ReplaceWith("ChatEventType"))
  fun setUserId(userId: String) {
    val editor = sharedPref.edit()
    // Storing login value as TRUE
    editor.putString(this.userId, userId)
    // commit changes
    editor.apply()
  }

  /**
   * Clear session details
   */
  fun logoutUser() {
    val editor = sharedPref.edit()
    // Clearing all data from Shared Preferences
    editor.putBoolean(isLogin, false)
    editor.putBoolean(isGlobalSearch, false)
    editor.putString(userId, "")
    editor.putString(accessCode, "")
    editor.putString(globalSearch, "")
    editor.apply()
  }

  /**
   * Quick check for login
   */
  // Get Login State
  fun isLoggedIn(): Boolean {
    return sharedPref.getBoolean(isLogin, false)
  }

  //@Deprecated("Old stuff",ReplaceWith("ChatEventType"))
  fun getUserId(): String {
    val d = sharedPref.getString(userId, "")
    return d!!
  }

  /**
   * set Access Code for Sample Only.
   */
  fun setAccessCode(accessCode: String) {
    val editor = sharedPref.edit()
    // Storing Access Code(Api Key)
    editor.putString(this.accessCode, accessCode)
    // commit changes
    editor.apply()
  }

  fun getAccessCode(): String {
    return sharedPref.getString(accessCode, "")!!
  }

  // Set global search State
  fun setGlobalSearch(isEnabled: Boolean) {
    val editor = sharedPref.edit()
    // Storing login value as TRUE
    editor.putBoolean(isGlobalSearch, isEnabled)
    // commit changes
    editor.apply()
  }

  /**
   * Quick check for Global Search
   */
  // Get global search State
  fun isGlobalSearch(): Boolean {
    return sharedPref.getBoolean(isGlobalSearch, false)
  }

  /**
   * set Global Search History.
   */
  fun setGlobalSearch(searchHistory: String) {
    val editor = sharedPref.edit()
    // Storing Global Search History
    editor.putString(this.globalSearch, searchHistory)
    // commit changes
    editor.apply()
  }

  /**
   * get Global Search History.
   */
  fun getGlobalSearch(): String {
    return sharedPref.getString(globalSearch, "")!!
  }
}