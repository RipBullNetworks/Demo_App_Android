package com.ripbull.ertc.util

import com.ripbull.coresdk.core.type.SettingAppliedFor
import com.ripbull.coresdk.group.mapper.GroupRecord

object AppConstants {
  // folder paths
  const val DIR_ROOT = "eRTC"
  const val DIR_SEPARATOR = "/"
  const val DIR_PROFILE_PIC = "Profile Pictures"
  const val DIR_CACHE_PIC = "/eRTC/eRTC Pictures"
  const val DIR_CACHE_VID = "/eRTC/eRTC Movies"
  const val DIR_DB = "Databases"
  const val DIR_BACKUP = "Backups"
  const val DIR_MEDIA = "Media"
  const val DIR_MEDIA_IMAGES = "eRTC Images"
  const val DIR_MEDIA_VIDEOS = "eRTC Videos"
  const val DIR_MEDIA_AUDIOS = "eRTC Audios"
  const val DIR_MEDIA_DOCUMENTS = "eRTC Documents"
  const val DIR_MEDIA_GIF = "eRTC Gif"
  const val DIR_MEDIA_PATH = "/eRTC/Media/"
  const val DIR_SENT = "sent"
  const val TYPING_STATUS = "Typing..."
  const val GROUP_TYPING_STATUS = "typing..."
  const val DIR_PROFILE_PIC_PATH = "/eRTC/Profile Pictures"

  //ChatActivity Constants
  val array = arrayOf("Take Photo", "Choose from Files")
  val arrayVideo = arrayOf("Record Video", "Choose from Files")

  const val EXTRA_THREAD_ID = "thread_id"
  const val EXTRA_ID = "id"
  const val EXTRA_CHAT_TYPE = "type"
  const val EXTRA_GROUP_RECORD = "group"
  const val EXTRA_MESSAGE = "message"

  const val TYPE_SINGLE = 1
  const val TYPE_GROUP = 2
  const val GROUP_REQUEST_CODE = 500
  const val TYPE_EXIT = 1
  const val EXTRA_EXIT_TYPE = "type"

  //ChatAdapter Constants
  const val CHAT_TEXT = "text"
  const val CHAT_IMAGE = "image"
  const val CHAT_VIDEO = "video"
  const val CHAT_AUDIO = "audio"
  const val CHAT_CONTACT = "contact"
  const val CHAT_LOCATION = "location"
  const val CHAT_FILE = "file"
  const val CHAT_GIPHY = "gify"
  const val CHAT_GIF = "gif"

  const val INCOMING_TEXT = 1
  const val INCOMING_IMAGE = 2
  const val INCOMING_VIDEO = 3
  const val INCOMING_AUDIO = 4
  const val INCOMING_LOCATION = 5
  const val INCOMING_CONTACT = 6
  const val INCOMING_FILE = 7
  const val INCOMING_GIF = 8

  const val OUTGOING_TEXT = 11
  const val OUTGOING_IMAGE = 12
  const val OUTGOING_VIDEO = 13
  const val OUTGOING_AUDIO = 14
  const val OUTGOING_LOCATION = 15
  const val OUTGOING_CONTACT = 16
  const val OUTGOING_FILE = 17
  const val OUTGOING_GIF = 18

  const val FAV_TEXT = 21
  const val FAV_IMAGE = 22
  const val FAV_VIDEO = 23
  const val FAV_AUDIO = 24
  const val FAV_LOCATION = 25
  const val FAV_CONTACT = 26
  const val FAV_FILE = 27
  const val FAV_GIF = 28

  const val CHAT_META_DATA = 31

  const val DELAY = 500L

  const val EXTRA_URL = "url"
  const val EXTRA_LAT_LNG = "latLng"
  const val EXTRA_ADDRESS = "address"
  const val EXTRA_MSG_ID = "msg_1"

  //Chat View Type
  const val TYPE_FAV_MESSAGES = 100
  const val TYPE_CHAT = 101
  const val TYPE_FOLLOW_THREAD = 102

  //User Availability Status
  val arrayStatus = arrayOf("Online", "Away", "Invisible", "DND")
  val arrayProfilePic = arrayOf("Take Photo", "Choose from Files", "Remove Photo")
  //val arrayAddGroupPic = arrayOf("Take Photo", "Choose from Files", "Cancel")

  //User Blocked Status
  const val USER_BLOCKED = "blocked"
  const val USER_INACTIVE = "inactive"

  //Group Member Action
  val arrayGroupAddAdminAction = arrayOf("Send Message", "View Profile", "Make Channel Admin", "Remove From Channel")
  val arrayGroupDismissAdminAction = arrayOf("Send Message", "View Profile", "Dismiss as Admin", "Remove From Channel")
  val arrayGroupUserAction = arrayOf("Send Message", "View Profile")
  val arrayMentionUserAction = arrayOf("Send Message", "View Profile")

  const val ADMIN = "admin"
  const val USER = "user"

  const val PARENT_MESSAGE_ID = "parent_msg_id"
  const val STAR_MESSAGE_ID = "msg_id"
  const val BLOCKED_USER = "blocked_user"
  const val IS_GLOBAL_SEARCH = "is_global_search"

  const val EVENT_TYPE = "type"
  const val SPLASH = "splash"
  const val CHANGE_PASSWORD = "change_pwd"
  const val NOTIFICATION_SETTINGS = "notification_settings"
  const val LOGIN = "login"

  const val READ = "Read"
  const val DELIVERED = "Delivered"

  const val RECIPIENT_ID = "recipient_id"

  val pattern = Regex("<@+[a-zA-Z0-9._ @-]+>|<@channel>|<@here>")
  val channelPattern = Regex("<@channel>|<@here>")

  const val IN_GRAM = false
  const val BLESS = false
  const val WE_WORK = false
  val copyPattern = Regex("<@+[a-zA-Z0-9._ ]+>|<@channel>|<@here>")

  const val REMOVE_FROM_ADMIN = "removed"
  const val DETAILS = "details"
  const val NAME = "name"
  const val USER_ID = "user_id"
  const val CHAT_TYPE = "chat_type"
  const val IS_MENU = "menu"
  const val THREAD_TYPE = "thread_type"
  const val CREATED_AT = "created_at"
  const val FREE_SAMPLE_APP = "freesampleapp"
  const val CHANNEL_DELETE = "channelDeleted"
  const val SENDER_ID = "sender_id"
  val groupStatus = arrayOf(GroupRecord.STATUS_FROZEN, GroupRecord.STATUS_DELETED, GroupRecord.STATUS_DEACTIVATED)

  const val BLOCK = "block"
  const val REPLACE = "replace"
  const val NOTIFICATION = "notification"
  val validTill = arrayOf(
    SettingAppliedFor.HOURS_24.duration,
    SettingAppliedFor.HOURS_72.duration,
    SettingAppliedFor.WEEK_1.duration,
    SettingAppliedFor.WEEKS_2.duration,
    SettingAppliedFor.MONTH_1.duration
  )
}