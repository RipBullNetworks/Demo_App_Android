package com.ripbull.ertc.testing

object AppConstants {
  const val ONBOARD = "Onboard"
  const val USER = "User"
  const val THREAD = "Thread"
  const val CHAT = "Chat"
  const val GROUP = "Group"
  const val MQTT_PUBLISH = "Mqtt Publish"
  const val MQTT_SUBSCRIBE = "Mqtt Subscribe"

  // User Auth APIs
  const val NAMESPACE = "Namespace"
  const val LOGIN = "Login"
  const val CONNECT = "Connect"
  const val CHANGE_PASSWORD = "Change password"
  const val FORGOT_PASSWORD = "Forgot password"
  const val LOGOUT = "Logout"

  // User APIs
  const val GET_CHAT_USERS = "Get Chat Users"
  const val MENTIONED_USERS = "Mentioned Users"
  const val REACTIONED_USERS = ""
  const val REMOVE_PROFILE_PIC = "Remove profile pic"


  // Thread APIs
  const val THREAD_HISTORY = "Thread history"
  const val CHAT_HISTORY = "Chat history"
  const val CREATE_THREAD = "Create Thread"
  const val GET_THREADS = "Get Threads"


  // Chat APIs
  const val SEND_MESSAGE = "Send TextMessage"
  const val SEND_IMAGE_MESSAGE = "Send Image Message"
  const val SEND_VIDEO_MESSAGE = "Send Video Message"
  const val SEND_AUDIO_MESSAGE = "Send Audio Message"
  const val GET_MESSAGES = "Get Messages"
  const val EDIT_MESSAGE = "Edit Message"
  const val DELETE_MESSAGES = "Delete Messages"
  const val FORWARD_MESSAGES = "Forward Messages"
  const val ADD_REACTION = "Add Reaction"
  const val BLOCK_USER = "Block User"
  const val UN_BLOCK_USER = "Unblock User"
  const val MARK_FAVOURITE = "Mark as favorite"
  const val GET_ALL_FAV_MESSAGES = "Get all Favorite Messages"
  const val GET_ALL_FAV_THREAD_MSG = "Get all Favorite Thread specific messages"
  const val SEND_CHAT_THREAD_MESSAGE = "Send Chat Thread Message"
  const val GET_CHAT_THREAD_MESSAGES = "Get Chat Thread Messages"
  const val GLOBAL_SEARCH = "Global search"
  const val LOCAL_SEARCH = "Local search"


  // MQTT Events
  const val MQTT_CONNECT = "MQTT connect"
  const val MARK_AS_READ = "Mark as Read"
  const val MESSAGE_READ_STATUS = "Message Read Status"
  const val MESSAGE_ON = "Message On"
  const val TYPING_PUBLISH = "Typing Indicator Publish"
  const val TYPING_SUBSCRIBE = "Typing Indicator Subscribe"
  const val REACTION_SUBSCRIBE = "Reaction"
  const val GROUP_UPDATE = "Group Update"
  const val AVAILABILITY_STATUS = "Availability Status"
  const val NOTIFICATION_SETTINGS_GLOBAL = "Notification Settings Global"
  const val NOTIFICATION_SETTINGS_THREAD = "Notification Settings Thread "
  const val THREAD_METADATA_ON = "Thread Metadata On"
  const val MESSAGE_METADATA_ON = "Message Metadata On"


  // Group APIs
  const val ALL_GROUPS = "Get all groups"
  const val CREATE_GROUP = "Create Group"
  const val GROUP_BY_ID = "Get group by groupId"
  const val UPDATE_GROUP_DETAILS = "Update Group Details"
  const val ADD_PARTICIPANTS = "Add Participants"
  const val REMOVE_PARTICIPANTS = "Remove Participants"
  const val ADD_ADMIN = "Add Admin"
  const val REMOVE_ADMIN = "Remove Admin"
  const val EXIT_GROUP = "Exit Group"
  const val REMOVE_GROUP_PIC = "Remove Group Pic"


  const val USER_DATA_ON = "User Metadata On"


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

  //User Availability Status
  val arrayStatus = arrayOf("Online", "Away", "Invisible", "DND")
  val arrayProfilePic = arrayOf("Take Photo", "Choose from Files", "Remove Photo")
  //val arrayAddGroupPic = arrayOf("Take Photo", "Choose from Files", "Cancel")

  //User Blocked Status
  const val USER_BLOCKED = "blocked"
  const val USER_INACTIVE = "inactive"

  //Group Member Action
  val arrayGroupAddAdminAction = arrayOf("Send Message", "View Profile", "Make Group Admin", "Remove From Group")
  val arrayGroupDismissAdminAction = arrayOf("Send Message", "View Profile", "Dismiss as Admin", "Remove From Group")
  val arrayGroupUserAction = arrayOf("Send Message", "View Profile")
  val arrayMentionUserAction = arrayOf("Send Message", "View Profile")

  const val ADMIN = "admin"

  const val PARENT_MESSAGE_ID = "parent_msg_id"
  const val STAR_MESSAGE_ID = "msg_id"
  const val BLOCKED_USER = "blocked_user"

  const val EVENT_TYPE = "type"
  const val SPLASH = "splash"
  const val NOTIFICATION_SETTINGS = "notification_settings"

  const val READ = "Read"
  const val DELIVERED = "Delivered"

  const val RECIPIENT_ID = "recipient_id"

  val pattern = Regex("<@+[a-zA-Z0-9._ @-]+>|<@channel>|<@here>")

  const val IN_GRAM = false
  const val BLESS = false
  const val WE_WORK = false
  val copyPattern = Regex("<@+[a-zA-Z0-9. _]+>|<@channel>|<@here>")


}