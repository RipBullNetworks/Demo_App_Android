package com.ripbull.ertc.chat.chat

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.RelativeSizeSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Filter
import android.widget.Filterable
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coreattachment.audio.AudioPlayer
import com.ripbull.coresdk.chat.mapper.ChatReactionRecord
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata
import com.ripbull.coresdk.core.type.ChatEventType
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.DownloadStatus
import com.ripbull.coresdk.core.type.MessageStatus
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.MessageUpdateType
import com.ripbull.ertc.R
import com.ripbull.ertc.components.RoundedImageView
import com.ripbull.ertc.extension.loadImage
import com.ripbull.ertc.extension.shortToast
import com.ripbull.ertc.glide.GlideRequests
import com.ripbull.ertc.ui.ShowImageActivity
import com.ripbull.ertc.ui.VideoPlayerActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.ertc.util.ForwardTagUtil.Companion.setForwardTagMedia
import com.ripbull.ertc.util.MediaUtil
import com.ripbull.ertc.util.TimestampUtil
import com.ripbull.ertc.util.WebViewUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.io.File

class ChatCommonAdapter(
  private var chatList: ArrayList<MessageRecord>,
  private val glide: GlideRequests?,
  val context: Context,
  private val actViewType: Int,
  private val threadType: String,
  private val listener: ChatCommonAdapterListener,
  private val isChatThread: Boolean = false,
  private var selectedItems: List<MessageRecord> = emptyList(),
  private val replyCount: Int = 1
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable, ReactionsAdapter.ReactionsAdapterListener {

  val mSeekbarUpdateHandler = Handler()
  var filteredChatList: List<MessageRecord> = mutableListOf()
  private val audioPlayer = AudioPlayer()
  private var ivPlayAudioBtn: AppCompatImageView? = null
  private var ivStopAudioBtn: AppCompatImageView? = null
  private var tvChatThreadTitle: AppCompatTextView? = null
  var run: Runnable? = null
  private var previousSeekBar: AppCompatSeekBar? = null
  private var mediaId: String? = null
  private var highlightedPosition = -1

  init {
    this.filteredChatList = chatList
  }

  // CALLBACKS
  /**
   * This method is used to specify which view inflate in onCreateViewHolder() method
   * @param position
   * @return
   */
  override fun getItemViewType(position: Int): Int {
    val messageRecord: MessageRecord = filteredChatList[position]
    when {
      actViewType == AppConstants.TYPE_FAV_MESSAGES         -> when (filteredChatList[position].msgType) {
        AppConstants.CHAT_TEXT     -> return AppConstants.FAV_TEXT
        AppConstants.CHAT_IMAGE    -> return AppConstants.FAV_IMAGE
        AppConstants.CHAT_VIDEO    -> return AppConstants.FAV_VIDEO
        AppConstants.CHAT_AUDIO    -> return AppConstants.FAV_AUDIO
        AppConstants.CHAT_LOCATION -> return AppConstants.FAV_LOCATION
        AppConstants.CHAT_CONTACT  -> return AppConstants.FAV_CONTACT
        AppConstants.CHAT_FILE     -> return AppConstants.FAV_FILE
        AppConstants.CHAT_GIPHY    -> return AppConstants.FAV_GIF
        AppConstants.CHAT_GIF      -> return AppConstants.FAV_GIF
      }
      messageRecord.chatEventType == ChatEventType.CHAT_META_DATA -> {
        return AppConstants.CHAT_META_DATA
      }
      messageRecord.chatEventType == ChatEventType.OUTGOING -> when (filteredChatList[position].msgType) {
        AppConstants.CHAT_TEXT     -> return AppConstants.OUTGOING_TEXT
        AppConstants.CHAT_IMAGE    -> return AppConstants.OUTGOING_IMAGE
        AppConstants.CHAT_VIDEO    -> return AppConstants.OUTGOING_VIDEO
        AppConstants.CHAT_AUDIO    -> return AppConstants.OUTGOING_AUDIO
        AppConstants.CHAT_LOCATION -> return AppConstants.OUTGOING_LOCATION
        AppConstants.CHAT_CONTACT  -> return AppConstants.OUTGOING_CONTACT
        AppConstants.CHAT_FILE     -> return AppConstants.OUTGOING_FILE
        AppConstants.CHAT_GIPHY    -> return AppConstants.OUTGOING_GIF
        AppConstants.CHAT_GIF      -> return AppConstants.OUTGOING_GIF
      }
      else                                                  -> when (filteredChatList[position].msgType) {
        AppConstants.CHAT_TEXT     -> return AppConstants.INCOMING_TEXT
        AppConstants.CHAT_IMAGE    -> return AppConstants.INCOMING_IMAGE
        AppConstants.CHAT_VIDEO    -> return AppConstants.INCOMING_VIDEO
        AppConstants.CHAT_AUDIO    -> return AppConstants.INCOMING_AUDIO
        AppConstants.CHAT_LOCATION -> return AppConstants.INCOMING_LOCATION
        AppConstants.CHAT_CONTACT  -> return AppConstants.INCOMING_CONTACT
        AppConstants.CHAT_FILE     -> return AppConstants.INCOMING_FILE
        AppConstants.CHAT_GIPHY    -> return AppConstants.INCOMING_GIF
        AppConstants.CHAT_GIF      -> return AppConstants.INCOMING_GIF
      }
    }

    return -1
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater: LayoutInflater = LayoutInflater.from(parent.context)
    var view: View?
    view = inflater.inflate(R.layout.item_incoming_chat_text, parent, false)

    var viewHolder: RecyclerView.ViewHolder = ReceiveTextHolder(view!!)
    when (viewType) {
      AppConstants.INCOMING_TEXT, AppConstants.FAV_TEXT         -> {
        view = inflater.inflate(R.layout.item_incoming_chat_text, parent, false)
        viewHolder = ReceiveTextHolder(view!!)
      }
      AppConstants.INCOMING_IMAGE, AppConstants.FAV_IMAGE       -> {
        view = inflater.inflate(R.layout.item_incoming_chat_image_video, parent, false)
        viewHolder = ReceiveImageVideoHolder(view!!)
      }
      AppConstants.INCOMING_VIDEO, AppConstants.FAV_VIDEO       -> {
        view = inflater.inflate(R.layout.item_incoming_chat_image_video, parent, false)
        viewHolder = ReceiveImageVideoHolder(view!!)
      }
      AppConstants.INCOMING_AUDIO, AppConstants.FAV_AUDIO       -> {
        view = inflater.inflate(R.layout.item_incoming_chat_audio, parent, false)
        viewHolder = ReceiveAudioHolder(view!!)
      }
      AppConstants.INCOMING_LOCATION, AppConstants.FAV_LOCATION -> {
        view = inflater.inflate(R.layout.item_incoming_chat_location, parent, false)
        viewHolder = ReceiveLocationHolder(view!!)
      }
      AppConstants.INCOMING_CONTACT, AppConstants.FAV_CONTACT   -> {
        view = inflater.inflate(R.layout.item_incoming_chat_contact, parent, false)
        viewHolder = ReceiveContactHolder(view!!)
      }
      AppConstants.INCOMING_FILE, AppConstants.FAV_FILE         -> {
        view = inflater.inflate(R.layout.item_incoming_chat_document, parent, false)
        viewHolder = ReceiveDocumentHolder(view!!)
      }
      AppConstants.INCOMING_GIF, AppConstants.FAV_GIF           -> {
        view = inflater.inflate(R.layout.item_incoming_chat_image_video, parent, false)
        viewHolder = ReceiveImageVideoHolder(view!!)
      }

      AppConstants.OUTGOING_TEXT                                -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_text, parent, false)
        viewHolder = SendTextHolder(view!!)
      }
      AppConstants.OUTGOING_IMAGE                               -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_image_video, parent, false)
        viewHolder = SendImageVideoHolder(view!!)
      }
      AppConstants.OUTGOING_VIDEO                               -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_image_video, parent, false)
        viewHolder = SendImageVideoHolder(view!!)
      }
      AppConstants.OUTGOING_AUDIO                               -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_audio, parent, false)
        viewHolder = SendAudioHolder(view!!)
      }
      AppConstants.OUTGOING_LOCATION                            -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_location, parent, false)
        viewHolder = SendLocationHolder(view!!)
      }
      AppConstants.OUTGOING_CONTACT                             -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_contact, parent, false)
        viewHolder = SendContactHolder(view!!)
      }
      AppConstants.OUTGOING_FILE                                -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_document, parent, false)
        viewHolder = SendDocumentHolder(view!!)
      }
      AppConstants.OUTGOING_GIF                                 -> {
        view = inflater.inflate(R.layout.item_outgoing_chat_image_video, parent, false)
        viewHolder = SendImageVideoHolder(view!!)
      }
      AppConstants.CHAT_META_DATA                               -> {
        view = inflater.inflate(R.layout.item_chat_meta_data, parent, false)
        viewHolder = ChatMetaDataHolder(view!!)
      }
    }
    return viewHolder
  }

  @RequiresApi(Build.VERSION_CODES.M)
  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    val messageRecord = filteredChatList[position]
    if (selectedItems.contains(messageRecord)) {
      holder.itemView.setBackgroundResource(0)
    }

    if (highlightedPosition == position) {
      highlightedPosition = -1
      holder.itemView.setBackgroundResource(R.color.chat_star_msg_bg)

      Handler().postDelayed({
        holder.itemView.setBackgroundResource(0)
      }, 1500)
    }

    when (holder.itemViewType) {
      //set Incoming UI
      AppConstants.INCOMING_TEXT     -> {
        val viewHolder = holder as ReceiveTextHolder

        viewHolder.rlChat.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.tvMessage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.clPreview.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.tvOriginalMsg.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }


        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        if(messageRecord.updateType != MessageUpdateType.DELETE){
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            if (WebViewUtil.checkHyperLink(messageRecord.message!!)){
              val isMessageEdit = messageRecord.updateType == MessageUpdateType.EDIT
              WebViewUtil.showPreview(context, viewHolder.tvOriginalMsg, viewHolder.ivPreview,
                  viewHolder.clPreview, viewHolder.tvPreview, messageRecord.message!!, viewHolder.tvMessage, isMessageEdit)
            } else {
              viewHolder.clPreview.visibility = View.GONE
              viewHolder.tvMessage.visibility = View.VISIBLE
              viewHolder.tvMessage.setTextColor(context.getColor(R.color.incoming_text_msg_color))
            }
            viewHolder.ivStar.visibility = View.GONE
          }
        } else {
          viewHolder.clPreview.visibility = View.GONE
          viewHolder.tvMessage.visibility = View.VISIBLE
          viewHolder.tvMessage.setTextColor(context.getColor(R.color.incoming_delete_message_color))
          viewHolder.ivStar.visibility = View.GONE
        }
        setMentionText(viewHolder.tvMessage, messageRecord)
        viewHolder.tvTimestamp.text =
          TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_IMAGE    -> {
        val viewHolder = holder as ReceiveImageVideoHolder
        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.ivReceiveDownloadImage.visibility = View.GONE
        viewHolder.tvChatTime.text =
          TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )
        viewHolder.rlReceiveImage.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        } else {
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }

          MediaUtil.loadIncomingChatImage(
            context, messageRecord.mediaPath, viewHolder.ivReceiveImage
          )
        }

        viewHolder.ivReceiveImage.setOnClickListener {
          openImage(
            messageRecord.id,
            messageRecord.mediaPath,
            messageRecord.senderId,
            "incoming",
            threadType,
            messageRecord.timestamp
          )
        }

        viewHolder.ivReceiveImage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }
        removeSenderReadReceipt(position)
        setForwardTagMedia(context, true, viewHolder.ivReceiveImage, viewHolder.rlReceiveImage,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_VIDEO    -> {
        val viewHolder = holder as ReceiveImageVideoHolder
        viewHolder.tvChatTime.text =
          TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )

        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.pbReceiveImage.visibility = View.GONE
        viewHolder.rlReceiveImage.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }

          if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
            setUserName(viewHolder.tvName, messageRecord, position)
          } else {
            viewHolder.tvName.visibility = View.GONE
          }
          if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
            viewHolder.ivReceiveDownloadImage.visibility = View.GONE
            viewHolder.ivPlayVideoImage.visibility = View.VISIBLE
            viewHolder.pbReceiveImage.visibility = View.GONE
            MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
              .into(viewHolder.ivReceiveImage)
          } else if (messageRecord.localMediaPath.isNullOrEmpty()) {
            if (messageRecord.downloadStatus != null
              && messageRecord.downloadStatus == DownloadStatus.PROGRESS.status) {
              viewHolder.pbReceiveImage.visibility = View.VISIBLE
              viewHolder.ivReceiveDownloadImage.visibility = View.GONE
            } else {
              viewHolder.ivReceiveDownloadImage.visibility = View.VISIBLE
              viewHolder.pbReceiveImage.visibility = View.GONE
            }
            viewHolder.ivPlayVideoImage.visibility = View.GONE
            MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
              .into(viewHolder.ivReceiveImage)
          } else {
            viewHolder.ivReceiveDownloadImage.visibility = View.GONE
            viewHolder.ivPlayVideoImage.visibility = View.VISIBLE
            viewHolder.pbReceiveImage.visibility = View.GONE
            if (File(messageRecord.localMediaPath).canRead()) {
              MediaUtil.loadVideoThumbnail(context, messageRecord.localMediaPath)
                .into(viewHolder.ivReceiveImage)
            } else {
              MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
                .into(viewHolder.ivReceiveImage)
            }
          }

        }
        //viewHolder.tvDuration.text = MediaUtil.getIncomingMediaDuration(context, messageRecord.mediaPath)

        viewHolder.ivPlayVideoImage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivReceiveDownloadImage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivReceiveDownloadImage.setOnClickListener {
          viewHolder.ivReceiveDownloadImage.visibility = View.GONE
          viewHolder.pbReceiveImage.visibility = View.VISIBLE
          messageRecord.mediaPath?.let { it1 ->
            listener.downloadMedia(
                messageRecord.id, it1, MediaUtil.getVideosPath(), MessageType.VIDEO.type)
          }
        }

        viewHolder.ivPlayVideoImage.setOnClickListener {
          if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
            openServerVideo(
              messageRecord.id, messageRecord.mediaPath, messageRecord.senderId,
              messageRecord.type, messageRecord.timestamp, messageRecord.msgType
            )
          } else if (messageRecord.localMediaPath.isNullOrEmpty()) {
            viewHolder.ivReceiveDownloadImage.visibility = View.VISIBLE
            viewHolder.ivPlayVideoImage.visibility = View.GONE
          } else {
            val file = File(messageRecord.localMediaPath)
            if (!file.canRead()) {
              viewHolder.ivReceiveDownloadImage.visibility = View.VISIBLE
              viewHolder.ivPlayVideoImage.visibility = View.GONE
            } else {
              pauseOrStopAudio()
              openVideo(messageRecord.localMediaPath, messageRecord.senderId)
            }
          }
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTagMedia(context, true, viewHolder.ivReceiveImage, viewHolder.rlReceiveImage,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_AUDIO    -> {
        val viewHolder = holder as ReceiveAudioHolder
        viewHolder.tvChatTime.text =
          TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )
        viewHolder.rlReceiveAudio.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        viewHolder.rlReceiveAudio.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.pbAudio.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        viewHolder.ivReceiveDownloadAudio.visibility = View.GONE
        viewHolder.pbReceiveAudio.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        //viewHolder.tvDuration.text = MediaUtil.getIncomingMediaDuration(context, messageRecord.mediaPath)

        viewHolder.ivReceivePlayAudio.setOnClickListener {
          run = Runnable {
            var progress = 0
            if (audioPlayer.durationMillis() > 0)
              progress = audioPlayer.currentPosition() / (audioPlayer.durationMillis() / 100)
            viewHolder.pbAudio.progress = progress
            run?.let { it1 -> mSeekbarUpdateHandler.postDelayed(it1, 500) }
          }
          (run as Runnable).run()

          startAudio(
            viewHolder.pbAudio,
            messageRecord,
            viewHolder.ivReceivePlayAudio,
            viewHolder.ivReceiveStopAudio,
            AppConstants.INCOMING_AUDIO
          )
        }

        viewHolder.pbAudio.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
          override fun onProgressChanged(
            seekBar: SeekBar?,
            progress: Int,
            fromUser: Boolean
          ) {
            if (fromUser)
              audioPlayer.setPosition(progress)
          }

          override fun onStartTrackingTouch(seekBar: SeekBar?) {
          }

          override fun onStopTrackingTouch(seekBar: SeekBar?) {
          }
        })

        viewHolder.pbAudio.setOnTouchListener { v, m -> // Perform tasks here
          true
        }

        viewHolder.ivReceiveStopAudio.setOnClickListener {
          stopAudio(
            messageRecord,
            viewHolder.ivReceivePlayAudio,
            viewHolder.ivReceiveStopAudio,
            AppConstants.INCOMING_AUDIO
          )
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_LOCATION -> {
        val viewHolder = holder as ReceiveLocationHolder

        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        viewHolder.tvChatTime.text =
          TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )
        viewHolder.rlReceiveLocation.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        val mapPath = MediaUtil.getMapUrl(
          context,
          messageRecord.locationRecord?.latitude.toString(),
          messageRecord.locationRecord?.longitude.toString()
        )
        MediaUtil.loadGoogleMapImage(context, mapPath, viewHolder.ivReceiveLocation)
        viewHolder.ivReceiveLocation.setOnClickListener {
          MediaUtil.openLocation(
            context,
            messageRecord.locationRecord?.latitude.toString(),
            messageRecord.locationRecord?.longitude.toString()
          )
        }

        viewHolder.ivReceiveLocation.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTagMedia(context, true, viewHolder.ivReceiveLocation, viewHolder.rlReceiveLocation,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_CONTACT  -> {
        val viewHolder = holder as ReceiveContactHolder

        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        viewHolder.tvContactName.text = messageRecord.contactName
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )
        viewHolder.rlReceiveContact.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE) {
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        } else {
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        viewHolder.rlReceiveContact.setOnClickListener {
          MediaUtil.openContact(
            context,
            messageRecord.contactName,
            messageRecord.phoneContactRecord,
            messageRecord.emailContactRecord
          )
        }

        viewHolder.rlReceiveContact.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_FILE     -> {
        val viewHolder = holder as ReceiveDocumentHolder

        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        if (messageRecord.mediaName != null) {
          viewHolder.tvDocumentName.text = MediaUtil.getFileName(messageRecord.mediaName)
        } else {
          viewHolder.tvDocumentName.text = MediaUtil.getFileName(messageRecord.mediaPath)
        }

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )
        viewHolder.rlReceiveDocument.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE) {
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        } else {
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        viewHolder.rlReceiveDocument.setOnClickListener {
          MediaUtil.openReceivedDocument(context, messageRecord.mediaPath)
        }

        viewHolder.rlReceiveDocument.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.INCOMING_GIF      -> {
        val viewHolder = holder as ReceiveImageVideoHolder
        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          setUserName(viewHolder.tvName, messageRecord, position)
        } else {
          viewHolder.tvName.visibility = View.GONE
        }
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.ivReceiveDownloadImage.visibility = View.GONE
        viewHolder.ivPlayGIF.visibility = View.VISIBLE
        viewHolder.tvChatTime.text =
          TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(
          position,
          viewHolder.tvHeader,
          messageRecord.timestamp
        )
        viewHolder.rlReceiveImage.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        val gifFilePath = if (messageRecord.msgType == MessageType.GIF.type) {
          messageRecord.mediaPath
        } else {
          messageRecord.gifPath
        }

        MediaUtil.loadIncomingChatImage(
          context,
          gifFilePath,
          viewHolder.ivReceiveImage
        )
        viewHolder.ivReceiveImage.setOnClickListener {
          openImage(
            messageRecord.id,
            gifFilePath,
            messageRecord.senderId,
            "incoming",
            threadType,
            messageRecord.timestamp
          )
        }

        viewHolder.ivReceiveImage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivPlayGIF.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivPlayGIF.setOnClickListener {
          viewHolder.ivPlayGIF.visibility = View.GONE
          viewHolder.ivReceiveImage.loadImage(
            url = gifFilePath,
            asGif = true
          )
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        removeSenderReadReceipt(position)
        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }

      //set Outgoing UI
      AppConstants.OUTGOING_TEXT     -> {
        val viewHolder = holder as SendTextHolder

        viewHolder.rlChat.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.tvMessage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.clPreview.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        setMentionText(viewHolder.tvMessage, messageRecord)
        viewHolder.tvTimestamp.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position, false)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.clPreview.visibility = View.GONE
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.tvMessage.visibility = View.VISIBLE
          viewHolder.ivStar.visibility = View.GONE
          viewHolder.tvMessage.setTextColor(context.getColor(R.color.outgoing_delete_message_color))
        } else {
          if (WebViewUtil.checkHyperLink(messageRecord.message!!)){
            val isMessageEdit = messageRecord.updateType == MessageUpdateType.EDIT
            WebViewUtil.showPreview(context, viewHolder.tvOriginalMsg, viewHolder.ivPreview,
            viewHolder.clPreview, viewHolder.tvPreview, messageRecord.message!!, viewHolder.tvMessage, isMessageEdit)
          } else {
            viewHolder.clPreview.visibility = View.GONE
            viewHolder.tvMessage.visibility = View.VISIBLE
          }
          viewHolder.tvMessage.setTextColor(context.getColor(R.color.outgoing_text_msg_color))
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.OUTGOING_IMAGE    -> {
        val viewHolder = holder as SendImageVideoHolder
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.ivSendUploadImage.visibility = View.GONE
        viewHolder.pbSendImage.visibility = View.GONE

        if (!messageRecord.localMediaPath.isNullOrEmpty() && !URLUtil.isValidUrl(messageRecord.localMediaPath)) {
          if (File(messageRecord.localMediaPath).canRead()) {
            MediaUtil.loadChatImage(context, messageRecord.localMediaPath, viewHolder.ivSendImage)
          } else {
            MediaUtil.loadChatImage(context, messageRecord.mediaPath, viewHolder.ivSendImage)
          }
        } else {
          MediaUtil.loadChatImage(context, messageRecord.mediaPath, viewHolder.ivSendImage)
        }

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position, pbSendAgain = viewHolder.pbSendImage)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        viewHolder.rlSendImage.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        viewHolder.ivSendImage.setOnClickListener {
          openImage(
            messageRecord.id,
            messageRecord.mediaPath,
            messageRecord.senderId,
            "outgoing",
            threadType,
            messageRecord.timestamp
          )
        }

        viewHolder.ivSendImage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }
        setForwardTagMedia(context, false, viewHolder.ivSendImage, viewHolder.rlSendImage,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.OUTGOING_VIDEO    -> {
        val viewHolder = holder as SendImageVideoHolder
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivSendUploadImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.pbSendImage.visibility = View.GONE
        viewHolder.rlSendImage.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if (messageRecord.updateType == MessageUpdateType.DELETE) {
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        } else {
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }

          setReadReceipt(viewHolder.tvStatus, messageRecord.status, position, pbSendAgain = viewHolder.pbSendImage)
          setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
          viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)

          viewHolder.ivPlayVideoImage.setOnClickListener {
            if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
              openServerVideo(
                messageRecord.id, messageRecord.mediaPath, messageRecord.senderId,
                messageRecord.type, messageRecord.timestamp, messageRecord.msgType
              )
            } else if (!messageRecord.localMediaPath.isNullOrEmpty()) {
              val file = File(messageRecord.localMediaPath)
              if (file.canRead()) {
                pauseOrStopAudio()
                openVideo(messageRecord.localMediaPath, messageRecord.senderId)
              } else {
                viewHolder.ivSendUploadImage.visibility = View.VISIBLE
                viewHolder.ivPlayVideoImage.visibility = View.GONE
              }
            } else {
              viewHolder.ivSendUploadImage.visibility = View.VISIBLE
              viewHolder.ivPlayVideoImage.visibility = View.GONE
            }
          }

          viewHolder.ivSendUploadImage.setOnClickListener {
            viewHolder.ivSendUploadImage.visibility = View.GONE
            viewHolder.pbSendImage.visibility = View.VISIBLE
            messageRecord.mediaPath?.let { it1 ->
              listener.downloadMedia(
                messageRecord.id, it1, MediaUtil.getVideosPath(), MessageType.VIDEO.type
              )
            }
          }

          if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
            viewHolder.ivPlayVideoImage.visibility = View.VISIBLE
            viewHolder.ivSendUploadImage.visibility = View.GONE
            viewHolder.ivChatTypeImg.visibility = View.GONE
            viewHolder.tvDuration.visibility = View.GONE
            MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
              .into(viewHolder.ivSendImage)
          } else if (!messageRecord.localMediaPath.isNullOrEmpty() && !URLUtil.isValidUrl(messageRecord.localMediaPath)) {
            viewHolder.ivPlayVideoImage.visibility = View.VISIBLE
            viewHolder.ivSendUploadImage.visibility = View.GONE
            viewHolder.ivChatTypeImg.visibility = View.GONE
            viewHolder.tvDuration.visibility = View.GONE

            if (File(messageRecord.localMediaPath).canRead()) {
              MediaUtil.loadVideoThumbnail(context, messageRecord.localMediaPath)
                .into(viewHolder.ivSendImage)
            } else if (!messageRecord.mediaPath.isNullOrEmpty()) {
              viewHolder.ivSendUploadImage.visibility = View.VISIBLE
              viewHolder.ivPlayVideoImage.visibility = View.GONE
              MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
                .into(viewHolder.ivSendImage)
            }
          } else {
            if (messageRecord.localMediaPath.isNullOrEmpty()) {
              if (messageRecord.downloadStatus != null && messageRecord.downloadStatus == DownloadStatus.PROGRESS.status) {
                viewHolder.pbSendImage.visibility = View.VISIBLE
                viewHolder.ivSendUploadImage.visibility = View.GONE
              } else {
                viewHolder.ivSendUploadImage.visibility = View.VISIBLE
                viewHolder.ivSendUploadImage.setImageResource(R.drawable.ic_download)
                viewHolder.pbSendImage.visibility = View.GONE
              }
              viewHolder.ivPlayVideoImage.visibility = View.GONE
              MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
                .into(viewHolder.ivSendImage)
            }
          }

          if (messageRecord.status == MessageStatus.SENDING.status) {
            viewHolder.ivSendUploadImage.visibility = View.GONE
            viewHolder.ivPlayVideoImage.visibility = View.VISIBLE
          }

          viewHolder.ivPlayVideoImage.setOnLongClickListener {
            listener.onMessageLongPress(messageRecord, position)
            return@setOnLongClickListener true
          }

          if (isChatThread && position == 0) {
            viewHolder.rlThreadBox.visibility = View.VISIBLE
            handleThreadBox(
                messageRecord, viewHolder.tvThreadTitle, viewHolder.ivAddFav, viewHolder.ivCopy
            )
          } else {
            viewHolder.rlThreadBox.visibility = View.GONE
          }

          if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
            if (position == 0) {
              setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
            }
          } else if (!isChatThread) {
            viewHolder.tvThreadMessage.visibility = View.GONE
            viewHolder.tvThreadCount.visibility = View.GONE

            messageRecord.chatThreadMetadata?.let { ctData ->
              if (!ctData.parentMsgId.isNullOrEmpty()) {
                viewHolder.tvThreadMessage.visibility = View.VISIBLE
                ctData.parentMsg?.let {
                  viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
                }
              }

              ctData.chatThreadCount?.let {
                if (it > 0) {
                  viewHolder.tvThreadCount.visibility = View.VISIBLE
                  //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
                } else {
                  viewHolder.tvThreadCount.visibility = View.GONE
                }
              }
            }

            viewHolder.tvThreadMessage.setOnClickListener {
              listener.goToThread(messageRecord)
            }

            viewHolder.tvThreadCount.setOnClickListener {
              listener.goToThread(messageRecord)
            }
          } else {
            setSentToChannelTag(
                viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel
            )
          }

          if (messageRecord.reactions.isNullOrEmpty()) {
            viewHolder.rvReactions.visibility = View.GONE
          } else {
            setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
          }
        }

        setForwardTagMedia(context, false, viewHolder.ivSendImage, viewHolder.rlSendImage,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.OUTGOING_AUDIO    -> {
        val viewHolder = holder as SendAudioHolder
        viewHolder.ivSendUploadAudio.visibility = View.GONE
        viewHolder.pbSendAudio.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position, pbSendAgain = viewHolder.pbSendAudio)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        viewHolder.rlSendAudio.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }
        viewHolder.ivSendPlayAudio.setOnClickListener {
          run = Runnable {
            var progress = 0
            if (audioPlayer.durationMillis() > 0)
              progress = audioPlayer.currentPosition() / (audioPlayer.durationMillis() / 100)
            viewHolder.viewAudioBar.progress = progress
            run?.let { it1 -> mSeekbarUpdateHandler.postDelayed(it1, 500) }
          }
          (run as Runnable).run()

          startAudio(
            viewHolder.viewAudioBar,
            messageRecord,
            viewHolder.ivSendPlayAudio,
            viewHolder.ivSendStopAudio,
            AppConstants.OUTGOING_AUDIO
          )
        }

        viewHolder.viewAudioBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
          override fun onProgressChanged(
            seekBar: SeekBar?,
            progress: Int,
            fromUser: Boolean
          ) {
            if (fromUser)
              audioPlayer.setPosition(progress)
          }

          override fun onStartTrackingTouch(seekBar: SeekBar?) {
          }

          override fun onStopTrackingTouch(seekBar: SeekBar?) {
          }

        })

        viewHolder.viewAudioBar.setOnTouchListener { v, m -> // Perform tasks here
          true
        }

        viewHolder.rlSendAudio.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.viewAudioBar.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivSendStopAudio.setOnClickListener {
          stopAudio(
            messageRecord,
            viewHolder.ivSendPlayAudio,
            viewHolder.ivSendStopAudio,
            AppConstants.OUTGOING_AUDIO
          )
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.OUTGOING_LOCATION -> {
        val viewHolder = holder as SendLocationHolder

        val mapPath = MediaUtil.getMapUrl(
          context,
          messageRecord.locationRecord?.latitude.toString(),
          messageRecord.locationRecord?.longitude.toString()
        )
        setForwardTagMedia(context, false, viewHolder.ivSendLocation, viewHolder.rlSendLocation,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
        MediaUtil.loadGoogleMapImage(context, mapPath, viewHolder.ivSendLocation)
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        viewHolder.rlSendLocation.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }
        viewHolder.ivSendLocation.setOnClickListener {
          MediaUtil.openLocation(
            context,
            messageRecord.locationRecord?.latitude.toString(),
            messageRecord.locationRecord?.longitude.toString()
          )
        }

        viewHolder.ivSendLocation.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

      }
      AppConstants.OUTGOING_CONTACT  -> {
        val viewHolder = holder as SendContactHolder

        viewHolder.tvContactName.text = messageRecord.contactName
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        viewHolder.rlSendContact.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE) {
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        } else {
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }
        viewHolder.rlSendContact.setOnClickListener {
          MediaUtil.openContact(
            context,
            messageRecord.contactName,
            messageRecord.phoneContactRecord,
            messageRecord.emailContactRecord
          )
        }

        viewHolder.rlSendContact.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.OUTGOING_FILE     -> {
        val viewHolder = holder as SendDocumentHolder
        viewHolder.pbSendDoc.visibility = View.GONE

        viewHolder.tvDocumentName.text =
          MediaUtil.getFileName(messageRecord.mediaPath)
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position, pbSendAgain = viewHolder.pbSendDoc)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        viewHolder.rlSendDocument.setOnClickListener {
          MediaUtil.openSendDocument(context, messageRecord.mediaPath)
        }
        viewHolder.rlSendDocument.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE) {
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        } else {
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        viewHolder.rlSendDocument.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        setForwardTag(viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }
      AppConstants.OUTGOING_GIF      -> {
        val viewHolder = holder as SendImageVideoHolder
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.ivSendUploadImage.visibility = View.GONE
        viewHolder.pbSendImage.visibility = View.GONE

        val gifFilePath = if (messageRecord.msgType == MessageType.GIF.type) {
          messageRecord.mediaPath
        } else {
          messageRecord.gifPath
        }

        MediaUtil.loadGIF(
          context,
          gifFilePath,
          viewHolder.ivSendImage,
          viewHolder.progressBarGif,
          viewHolder.ivPlayGIF
        )

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setReadReceipt(viewHolder.tvStatus, messageRecord.status, position, pbSendAgain = viewHolder.pbSendImage)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        viewHolder.rlSendImage.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
        viewHolder.clDeleteMsg.visibility = if(messageRecord.updateType == MessageUpdateType.DELETE) View.VISIBLE else View.GONE
        if(messageRecord.updateType == MessageUpdateType.DELETE){
          viewHolder.tvMessage.text = messageRecord.message
          viewHolder.tvStatus.visibility = View.GONE
          viewHolder.ivStar.visibility = View.GONE
        }else{
          if (messageRecord.isFavoriteMessage!!) {
            viewHolder.ivStar.visibility = View.VISIBLE
          } else {
            viewHolder.ivStar.visibility = View.GONE
          }
        }
        viewHolder.ivSendImage.setOnClickListener {
          openImage(
            messageRecord.id,
            gifFilePath,
            messageRecord.senderId,
            "outgoing",
            threadType,
            messageRecord.timestamp
          )
        }

        viewHolder.ivSendImage.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivPlayGIF.setOnLongClickListener {
          listener.onMessageLongPress(messageRecord, position)
          return@setOnLongClickListener true
        }

        viewHolder.ivPlayGIF.setOnClickListener {
          viewHolder.ivPlayGIF.visibility = View.GONE
          viewHolder.ivSendImage.loadImage(url = gifFilePath, asGif = true)
        }

        if (isChatThread && position == 0) {
          viewHolder.rlThreadBox.visibility = View.VISIBLE
          handleThreadBox(
            messageRecord, viewHolder.tvThreadTitle,
            viewHolder.ivAddFav, viewHolder.ivCopy
          )
        } else {
          viewHolder.rlThreadBox.visibility = View.GONE
        }

        if (actViewType == AppConstants.TYPE_FOLLOW_THREAD) {
          if (position == 0) {
            setFollowThreadReplyCount(viewHolder.tvThreadCount, replyCount)
          }
        } else if (!isChatThread) {
          viewHolder.tvThreadMessage.visibility = View.GONE
          viewHolder.tvThreadCount.visibility = View.GONE

          messageRecord.chatThreadMetadata?.let { ctData ->
            if (!ctData.parentMsgId.isNullOrEmpty()) {
              viewHolder.tvThreadMessage.visibility = View.VISIBLE
              ctData.parentMsg?.let {
                viewHolder.tvThreadMessage.text = context.getString(R.string.reply_to_thread, parseRegex(ctData.parentMsg))
              }
            }

            ctData.chatThreadCount?.let {
              if (it > 0) {
                viewHolder.tvThreadCount.visibility = View.VISIBLE
                //viewHolder.tvThreadCount.text = context.getString(R.string.reply, it)
              } else {
                viewHolder.tvThreadCount.visibility = View.GONE
              }
            }
          }

          viewHolder.tvThreadMessage.setOnClickListener {
            listener.goToThread(messageRecord)
          }

          viewHolder.tvThreadCount.setOnClickListener {
            listener.goToThread(messageRecord)
          }
        } else {
          setSentToChannelTag(viewHolder.tvSendToChannel, messageRecord.chatThreadMetadata?.sendToChannel)
        }

        if (messageRecord.reactions.isNullOrEmpty()) {
          viewHolder.rvReactions.visibility = View.GONE
        } else {
          setReactionData(viewHolder.rvReactions, messageRecord.reactions!!, messageRecord)
        }

        setForwardTagMedia(context, false, viewHolder.ivSendImage, viewHolder.rlSendImage,
          viewHolder.ivForwardTag, viewHolder.tvForwardTag, messageRecord.isForwardMessage)
      }

      //set FAV Message UI
      AppConstants.FAV_TEXT          -> {
        val viewHolder = holder as ReceiveTextHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        setMentionText(viewHolder.tvMessage, messageRecord)
        viewHolder.tvTimestamp.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
      }
      AppConstants.FAV_IMAGE         -> {
        val viewHolder = holder as ReceiveImageVideoHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.ivReceiveDownloadImage.visibility = View.GONE
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        MediaUtil.loadIncomingChatImage(
          context, messageRecord.mediaPath, viewHolder.ivReceiveImage
        )

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
      }
      AppConstants.FAV_VIDEO         -> {
        val viewHolder = holder as ReceiveImageVideoHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        viewHolder.ivReceiveDownloadImage.visibility = View.GONE
        viewHolder.ivPlayVideoImage.visibility = View.VISIBLE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE

        try {
          MediaUtil.loadIncomingVideoThumbnail(context, messageRecord.mediaPath)
            .into(viewHolder.ivReceiveImage)

          viewHolder.ivOpen.setOnClickListener {
            // send selected contact in callback
            listener.onMessageSelected(messageRecord)
          }
          setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
        } catch (ex: Exception) {
          Log.e("StarMsg", "video exception: => " + ex.message)
        }
      }
      AppConstants.FAV_AUDIO         -> {
        val viewHolder = holder as ReceiveAudioHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        viewHolder.ivReceiveDownloadAudio.visibility = View.GONE
        viewHolder.pbReceiveAudio.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE

        viewHolder.ivReceivePlayAudio.setOnClickListener {
          run = Runnable {
            var progress = 0
            if (audioPlayer.durationMillis() > 0)
              progress = audioPlayer.currentPosition() / (audioPlayer.durationMillis() / 100)
            viewHolder.pbAudio.progress = progress
            run?.let { it1 -> mSeekbarUpdateHandler.postDelayed(it1, 500) }
          }
          (run as Runnable).run()

          startAudio(
            viewHolder.pbAudio,
            messageRecord,
            viewHolder.ivReceivePlayAudio,
            viewHolder.ivReceiveStopAudio,
            AppConstants.FAV_AUDIO
          )
        }
        viewHolder.pbAudio.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
          override fun onProgressChanged(
            seekBar: SeekBar?,
            progress: Int,
            fromUser: Boolean
          ) {
            if (fromUser)
              audioPlayer.setPosition(progress)
          }

          override fun onStartTrackingTouch(seekBar: SeekBar?) {
          }

          override fun onStopTrackingTouch(seekBar: SeekBar?) {
          }

        })

        viewHolder.pbAudio.setOnTouchListener { v, m -> // Perform tasks here
          true
        }

        viewHolder.ivReceiveStopAudio.setOnClickListener {
          stopAudio(
            messageRecord,
            viewHolder.ivReceivePlayAudio,
            viewHolder.ivReceiveStopAudio,
            AppConstants.FAV_AUDIO
          )
        }

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
      }
      AppConstants.FAV_LOCATION      -> {
        val viewHolder = holder as ReceiveLocationHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        val mapPath = MediaUtil.getMapUrl(
          context,
          messageRecord.locationRecord?.latitude.toString(),
          messageRecord.locationRecord?.longitude.toString()
        )
        MediaUtil.loadGoogleMapImage(context, mapPath, viewHolder.ivReceiveLocation)

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
      }
      AppConstants.FAV_CONTACT       -> {
        val viewHolder = holder as ReceiveContactHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        viewHolder.tvContactName.text = messageRecord.contactName

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
      }
      AppConstants.FAV_FILE          -> {
        val viewHolder = holder as ReceiveDocumentHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        if (messageRecord.chatEventType == ChatEventType.OUTGOING) {
          viewHolder.tvDocumentName.text = MediaUtil.getFileName(messageRecord.mediaPath)
        } else {
          viewHolder.tvDocumentName.text = MediaUtil.getFileName(messageRecord.mediaName)
        }
        viewHolder.rlReceiveDocument.setOnClickListener {
          MediaUtil.openReceivedDocument(context, messageRecord.mediaPath)
        }

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)
      }
      AppConstants.FAV_GIF           -> {
        val viewHolder = holder as ReceiveImageVideoHolder
        viewHolder.itemView.setBackgroundResource(0)
        viewHolder.tvName.visibility = View.VISIBLE
        viewHolder.ivOpen.visibility = View.VISIBLE
        viewHolder.ivUserProfile.visibility = View.VISIBLE
        viewHolder.ivStar.visibility = View.VISIBLE
        viewHolder.ivPlayVideoImage.visibility = View.GONE
        viewHolder.ivChatTypeImg.visibility = View.GONE
        viewHolder.tvDuration.visibility = View.GONE
        viewHolder.ivReceiveDownloadImage.visibility = View.GONE
        viewHolder.ivPlayGIF.visibility = View.VISIBLE

        viewHolder.tvChatTime.text = TimestampUtil.toDate(messageRecord.timestamp)
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)

        val gifFilePath = if (messageRecord.msgType == MessageType.GIF.type) {
          messageRecord.mediaPath
        } else {
          messageRecord.gifPath
        }

        MediaUtil.loadIncomingChatImage(
          context,
          gifFilePath,
          viewHolder.ivReceiveImage
        )

        viewHolder.ivOpen.setOnClickListener {
          // send selected contact in callback
          listener.onMessageSelected(messageRecord)
        }
        setUserDetails(messageRecord, viewHolder.ivUserProfile, viewHolder.tvName)

        viewHolder.ivPlayGIF.setOnClickListener {
          viewHolder.ivPlayGIF.visibility = View.GONE
          viewHolder.ivReceiveImage.loadImage(
            url = gifFilePath,
            asGif = true
          )
        }
      }

      // Chat Meta Data info
      AppConstants.CHAT_META_DATA     -> {
        val viewHolder = holder as ChatMetaDataHolder

        viewHolder.tvChatMetaData.text = messageRecord.message
        setDateInfo(position, viewHolder.tvHeader, messageRecord.timestamp)
        removeSenderReadReceipt(position)
      }
    }
  }

  override fun getItemCount(): Int {
    return filteredChatList.size
  }

  /**
   * Class responsible for binding the elements of Receive text layout file
   */
  private open inner class ReceiveTextHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvName: AppCompatTextView = v.findViewById<View>(R.id.tvName) as AppCompatTextView
    val tvOriginalMsg: AppCompatTextView = v.findViewById<View>(R.id.tvOriginalMsg) as AppCompatTextView
    val clPreview: ConstraintLayout = v.findViewById<View>(R.id.clPreview) as ConstraintLayout
    val tvPreview: AppCompatTextView = v.findViewById<View>(R.id.tvPreview) as AppCompatTextView
    val ivPreview: AppCompatImageView = v.findViewById<View>(R.id.ivPreview) as AppCompatImageView
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val tvTimestamp: AppCompatTextView = v.findViewById<View>(R.id.tvTimestamp) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val ivOpen: AppCompatImageView = v.findViewById<View>(R.id.ivOpen) as AppCompatImageView
    val ivUserProfile: AppCompatImageView =
      v.findViewById<View>(R.id.ivUserProfile) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val rlChat: RelativeLayout = v.findViewById<RelativeLayout>(R.id.rlChat)
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Receive image/video layout file
   */
  private open inner class ReceiveImageVideoHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvName: AppCompatTextView = v.findViewById<View>(R.id.tvName) as AppCompatTextView
    val rlReceiveImage: RelativeLayout = v.findViewById<View>(R.id.rlReceiveImage) as RelativeLayout
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val ivReceiveImage: RoundedImageView =
      v.findViewById<View>(R.id.ivReceiveImage) as RoundedImageView
    val ivReceiveDownloadImage: AppCompatImageView =
      v.findViewById<View>(R.id.ivReceiveDownloadImage) as AppCompatImageView
    val ivPlayVideoImage: AppCompatImageView =
      v.findViewById<View>(R.id.ivPlayVideoImage) as AppCompatImageView
    val ivChatTypeImg: AppCompatImageView =
      v.findViewById<View>(R.id.ivChatTypeImg) as AppCompatImageView
    val tvDuration: AppCompatTextView = v.findViewById<View>(R.id.tvDuration) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivPlayGIF: AppCompatImageView = v.findViewById<View>(R.id.ivPlayGIF) as AppCompatImageView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val ivOpen: AppCompatImageView = v.findViewById<View>(R.id.ivOpen) as AppCompatImageView
    val ivUserProfile: AppCompatImageView =
      v.findViewById<View>(R.id.ivUserProfile) as AppCompatImageView
    val pbReceiveImage: ProgressBar = v.findViewById<View>(R.id.pbReceiveImage) as ProgressBar
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Receive audio layout file
   */
  private open inner class ReceiveAudioHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvName: AppCompatTextView = v.findViewById<View>(R.id.tvName) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val ivReceivePlayAudio: AppCompatImageView =
      v.findViewById<View>(R.id.ivReceivePlayAudio) as AppCompatImageView
    val ivReceiveStopAudio: AppCompatImageView =
      v.findViewById<View>(R.id.ivReceiveStopAudio) as AppCompatImageView
    val ivReceiveDownloadAudio: AppCompatImageView =
      v.findViewById<View>(R.id.ivReceiveDownloadAudio) as AppCompatImageView
    val pbReceiveAudio: ProgressBar = v.findViewById<View>(R.id.pbReceiveAudio) as ProgressBar
    val tvDuration: AppCompatTextView = v.findViewById<View>(R.id.tvDuration) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val ivOpen: AppCompatImageView = v.findViewById<View>(R.id.ivOpen) as AppCompatImageView
    val ivUserProfile: AppCompatImageView =
      v.findViewById<View>(R.id.ivUserProfile) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rlReceiveAudio: LinearLayout = v.findViewById<View>(R.id.rlReceiveAudio) as LinearLayout
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val pbAudio: AppCompatSeekBar = v.findViewById<AppCompatSeekBar>(R.id.viewAudioBar)!!
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Receive location layout file
   */
  private open inner class ReceiveLocationHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvName: AppCompatTextView = v.findViewById<View>(R.id.tvName) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val rlReceiveLocation: RelativeLayout = v.findViewById<View>(R.id.rlReceiveLocation) as RelativeLayout
    val ivReceiveLocation: RoundedImageView =
      v.findViewById<View>(R.id.ivReceiveLocation) as RoundedImageView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val ivOpen: AppCompatImageView = v.findViewById<View>(R.id.ivOpen) as AppCompatImageView
    val ivUserProfile: AppCompatImageView =
      v.findViewById<View>(R.id.ivUserProfile) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Receive contact layout file
   */
  private open inner class ReceiveContactHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvName: AppCompatTextView = v.findViewById<View>(R.id.tvName) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val rlReceiveContact: LinearLayout =
      v.findViewById<View>(R.id.rlReceiveContact) as LinearLayout
    val tvContactName: AppCompatTextView =
      v.findViewById<View>(R.id.tvContactName) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val ivOpen: AppCompatImageView = v.findViewById<View>(R.id.ivOpen) as AppCompatImageView
    val ivUserProfile: AppCompatImageView =
      v.findViewById<View>(R.id.ivUserProfile) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Receive document layout file
   */
  private open inner class ReceiveDocumentHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvName: AppCompatTextView = v.findViewById<View>(R.id.tvName) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val rlReceiveDocument: LinearLayout =
      v.findViewById<View>(R.id.rlReceiveDocument) as LinearLayout
    val tvDocumentName: AppCompatTextView =
      v.findViewById<View>(R.id.tvDocumentName) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val ivOpen: AppCompatImageView = v.findViewById<View>(R.id.ivOpen) as AppCompatImageView
    val ivUserProfile: AppCompatImageView =
      v.findViewById<View>(R.id.ivUserProfile) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Send text layout file
   */
  private open inner class SendTextHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val tvOriginalMsg: AppCompatTextView = v.findViewById<View>(R.id.tvOriginalMsg) as AppCompatTextView
    val clPreview: ConstraintLayout = v.findViewById<View>(R.id.clPreview) as ConstraintLayout
    val tvPreview: AppCompatTextView = v.findViewById<View>(R.id.tvPreview) as AppCompatTextView
    val ivPreview: AppCompatImageView = v.findViewById<View>(R.id.ivPreview) as AppCompatImageView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val llChat: ConstraintLayout = v.findViewById<View>(R.id.llChat) as ConstraintLayout
    val tvTimestamp: AppCompatTextView = v.findViewById<View>(R.id.tvTimestamp) as AppCompatTextView
    val tvStatus: AppCompatTextView = v.findViewById<View>(R.id.tvStatus) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val rlChat: RelativeLayout = v.findViewById<RelativeLayout>(R.id.rlChat)
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Send image/video layout file
   */
  private open inner class SendImageVideoHolder(v: View) : RecyclerView.ViewHolder(v) {
    val ivSendImage: RoundedImageView =
      v.findViewById<View>(R.id.ivSendImage) as RoundedImageView
    val ivSendUploadImage: AppCompatImageView =
      v.findViewById<View>(R.id.ivSendUploadImage) as AppCompatImageView
    val ivPlayVideoImage: AppCompatImageView =
      v.findViewById<View>(R.id.ivPlayVideoImage) as AppCompatImageView
    val ivChatTypeImg: AppCompatImageView =
      v.findViewById<View>(R.id.ivChatTypeImg) as AppCompatImageView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val rlSendImage: RelativeLayout = v.findViewById<View>(R.id.rlSendImage) as RelativeLayout
    val tvDuration: AppCompatTextView = v.findViewById<View>(R.id.tvDuration) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvStatus: AppCompatTextView = v.findViewById<View>(R.id.tvStatus) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivPlayGIF: AppCompatImageView = v.findViewById<View>(R.id.ivPlayGIF) as AppCompatImageView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val pbSendImage: ProgressBar = v.findViewById<View>(R.id.pbSendImage) as ProgressBar
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val progressBarGif: ProgressBar = v.findViewById<View>(R.id.progressBarGif) as ProgressBar
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Send audio layout file
   */
  private open inner class SendAudioHolder(v: View) : RecyclerView.ViewHolder(v) {
    val viewAudioBar: AppCompatSeekBar =
      v.findViewById<View>(R.id.viewAudioBarSend) as AppCompatSeekBar
    val ivSendPlayAudio: AppCompatImageView =
      v.findViewById<View>(R.id.ivSendPlayAudio) as AppCompatImageView
    val ivSendStopAudio: AppCompatImageView =
      v.findViewById<View>(R.id.ivSendStopAudio) as AppCompatImageView
    val ivSendUploadAudio: AppCompatImageView =
      v.findViewById<View>(R.id.ivSendUploadAudio) as AppCompatImageView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val pbSendAudio: ProgressBar = v.findViewById<View>(R.id.pbSendAudio) as ProgressBar
    val tvDuration: AppCompatTextView = v.findViewById<View>(R.id.tvDuration) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvStatus: AppCompatTextView = v.findViewById<View>(R.id.tvStatus) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rlSendAudio: LinearLayout = v.findViewById<View>(R.id.rlSendAudio) as LinearLayout
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Send location layout file
   */
  private open inner class SendLocationHolder(v: View) : RecyclerView.ViewHolder(v) {
    val ivSendLocation: RoundedImageView =
      v.findViewById<View>(R.id.ivSendLocation) as RoundedImageView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val rlSendLocation: RelativeLayout = v.findViewById<View>(R.id.rlSendLocation) as RelativeLayout
    val tvStatus: AppCompatTextView = v.findViewById<View>(R.id.tvStatus) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Send contact layout file
   */
  private open inner class SendContactHolder(v: View) : RecyclerView.ViewHolder(v) {
    val rlSendContact: LinearLayout =
      v.findViewById<View>(R.id.rlSendContact) as LinearLayout
    val tvContactName: AppCompatTextView =
      v.findViewById<View>(R.id.tvContactName) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val rlSendLocation: LinearLayout = v.findViewById<View>(R.id.rlSendContact) as LinearLayout
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val tvStatus: AppCompatTextView = v.findViewById<View>(R.id.tvStatus) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
  }

  /**
   * Class responsible for binding the elements of Send document layout file
   */
  private open inner class SendDocumentHolder(v: View) : RecyclerView.ViewHolder(v) {
    val rlSendDocument: LinearLayout =
      v.findViewById<View>(R.id.rlSendDocument) as LinearLayout
    val tvDocumentName: AppCompatTextView =
      v.findViewById<View>(R.id.tvDocumentName) as AppCompatTextView
    val ivForwardTag: View = v.findViewById<View>(R.id.ivForwardTag) as View
    val clDeleteMsg: ConstraintLayout = v.findViewById<View>(R.id.clDeleteMsg) as ConstraintLayout
    val tvMessage: AppCompatTextView = v.findViewById<View>(R.id.tvMessage) as AppCompatTextView
    val tvChatTime: AppCompatTextView = v.findViewById<View>(R.id.tvChatTime) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
    val tvStatus: AppCompatTextView = v.findViewById<View>(R.id.tvStatus) as AppCompatTextView
    val ivStar: AppCompatImageView = v.findViewById<View>(R.id.ivStar) as AppCompatImageView
    val rlThreadBox: RelativeLayout = v.findViewById<View>(R.id.rlThreadBox) as RelativeLayout
    val tvThreadTitle: AppCompatTextView = v.findViewById<View>(R.id.tvThreadTitle) as AppCompatTextView
    val ivAddFav: AppCompatImageView = v.findViewById<View>(R.id.ivAddFav) as AppCompatImageView
    val ivCopy: AppCompatImageView = v.findViewById<View>(R.id.ivCopy) as AppCompatImageView
    val threadCountLayout: ConstraintLayout = v.findViewById<View>(R.id.threadCountLayout) as ConstraintLayout
    val tvThreadCount: AppCompatTextView = v.findViewById<View>(R.id.tvThreadCount) as AppCompatTextView
    val tvThreadMessage: AppCompatTextView = v.findViewById<View>(R.id.tvThreadMessage) as AppCompatTextView
    val rvReactions: RecyclerView = v.findViewById<RecyclerView>(R.id.rvReactions)
    val tvSendToChannel: AppCompatTextView = v.findViewById<View>(R.id.tvSendToChannel) as AppCompatTextView
    val tvForwardTag: AppCompatTextView = v.findViewById<AppCompatTextView>(R.id.tvForwardTag)
    val pbSendDoc: ProgressBar = v.findViewById<View>(R.id.pbSendDoc) as ProgressBar
  }

  /**
   * Class responsible for binding the elements of Chat mata data layout file
   */
  private open inner class ChatMetaDataHolder(v: View) : RecyclerView.ViewHolder(v) {
    val tvChatMetaData: AppCompatTextView = v.findViewById<View>(R.id.tvChatMetaData) as AppCompatTextView
    val tvHeader: AppCompatTextView = v.findViewById<View>(R.id.tvHeader) as AppCompatTextView
  }

  //-------------------------------------------------------------------
  // ----------------- action clicks
  //-------------------------------------------------------------------

  private fun openImage(msgId: String, path: String?, userId: String?, chatType: String, threadType: String, createdAt: Long?) {
    // todo downloaded image not getting open
    context.startActivity(ShowImageActivity.showImageIntent(context, msgId, path, userId, chatType, threadType, createdAt))
  }

  private fun openVideo(path: String?, userId: String?) {
    MediaUtil.openVideo(context, path, userId)
  }

  fun openServerVideo(
    msgId: String, path: String?, userId: String?, threadType: String?,
    createdAt: Long?, msgType: String?
  ) {
    context.startActivity(
      VideoPlayerActivity.videoPlayerIntent(
        context, msgId, path, userId, threadType, createdAt, msgType
      )
    )
  }

  private fun startAudio(
    seekBar: AppCompatSeekBar,
    messageRecord: MessageRecord,
    ivPlayButton: AppCompatImageView,
    ivStopAudio: AppCompatImageView,
    chatType: Int
  ) {
    ivPlayAudioBtn?.let { it1 ->
      ivStopAudioBtn?.let {
        it1.visibility = View.VISIBLE
        it.visibility = View.GONE
        pauseOrStopAudio(messageRecord.id)
      }
    }

    audioPlayer.setCompletionListener {
      ivPlayAudioBtn?.let { it1 ->
        ivStopAudioBtn?.let {
          it1.visibility = View.VISIBLE
          it.visibility = View.GONE
          mediaId = ""
          audioPlayer.stop()
          previousSeekBar?.progress = 0
        }
      }
    }

    ivPlayAudioBtn = ivPlayButton
    ivStopAudioBtn = ivStopAudio
    previousSeekBar = seekBar

    if (chatType == AppConstants.INCOMING_AUDIO && !messageRecord.mediaPath.isNullOrEmpty()
      || URLUtil.isValidUrl(messageRecord.mediaPath)) {
      ivPlayButton.visibility = View.GONE
      ivStopAudio.visibility = View.VISIBLE
    } else if (chatType == AppConstants.OUTGOING_AUDIO && MediaUtil.fileExits(messageRecord.mediaPath)) {
      ivPlayButton.visibility = View.GONE
      ivStopAudio.visibility = View.VISIBLE
    } else if (chatType == AppConstants.FAV_AUDIO && !messageRecord.mediaPath.isNullOrEmpty()
      || URLUtil.isValidUrl(messageRecord.mediaPath)) {
      ivPlayButton.visibility = View.GONE
      ivStopAudio.visibility = View.VISIBLE
    } else {
      Toast.makeText(context, context.getString(R.string.audio_path_empty), Toast.LENGTH_SHORT).show()
      return
    }

    try {
      if (mediaId.isNullOrEmpty() || mediaId != messageRecord.id) {
        audioPlayer.play(messageRecord.mediaPath)
      } else {
        audioPlayer.resume()
      }
    } catch (e: Exception) {
      ivPlayButton.visibility = View.VISIBLE
      ivStopAudio.visibility = View.GONE
      Toast.makeText(context, context.getString(R.string.audio_file_not_found), Toast.LENGTH_SHORT).show()
    }
    mediaId = messageRecord.id
  }

  private fun stopAudio(
    messageRecord: MessageRecord,
    ivPlayButton: AppCompatImageView,
    ivStopAudio: AppCompatImageView,
    chatType: Int
  ) {
    if (chatType == AppConstants.INCOMING_AUDIO && !messageRecord.mediaPath.isNullOrEmpty()) {
      ivPlayButton.visibility = View.VISIBLE
      ivStopAudio.visibility = View.GONE

      pauseOrStopAudio(messageRecord.id)
    } else if (chatType == AppConstants.OUTGOING_AUDIO && !messageRecord.mediaPath.isNullOrEmpty()) {
      ivPlayButton.visibility = View.VISIBLE
      ivStopAudio.visibility = View.GONE

      pauseOrStopAudio(messageRecord.id)
    } else if (chatType == AppConstants.FAV_AUDIO && !messageRecord.mediaPath.isNullOrEmpty()) {
      ivPlayButton.visibility = View.VISIBLE
      ivStopAudio.visibility = View.GONE

      pauseOrStopAudio(messageRecord.id)
    }
    mediaId = messageRecord.id
  }

  private fun setDateInfo(position: Int, tvHeader: AppCompatTextView, timesInMillSeconds: Long?) {
    if (position == 0) {
      tvHeader.visibility = View.VISIBLE
      tvHeader.text = timesInMillSeconds?.let { TimestampUtil.getChatDate(it) }
    } else if (position > 0) {
      val lastMessageTime: Long? = filteredChatList[position - 1].timestamp

      if (timesInMillSeconds?.let { TimestampUtil.getChatDate(it) } != lastMessageTime?.let {
            TimestampUtil.getChatDate(it)
        }) {
        tvHeader.visibility = View.VISIBLE
        tvHeader.text = timesInMillSeconds?.let { TimestampUtil.getChatDate(it) }
      } else {
        tvHeader.visibility = View.GONE
      }
    } else {
      tvHeader.visibility = View.GONE
    }
  }

  private fun setUserDetails(
    messageRecord: MessageRecord,
    ivUserProfile: AppCompatImageView,
    tvName: AppCompatTextView
  ) {
    if (messageRecord.senderId != null && (messageRecord.type == ChatType.SINGLE.type ||
          messageRecord.type == ChatType.SINGLE_CHAT_THREAD.type)
    ) {
      messageRecord.senderRecord?.let {
        tvName.text = it.name
        if (it.profileThumb != null) {
          glide!!.load(it.profileThumb).into(ivUserProfile)
        }
      }
    } else if (messageRecord.senderId != null && (messageRecord.type == ChatType.GROUP.type ||
          messageRecord.type == ChatType.GROUP_CHAT_THREAD.type)
    ) {
      messageRecord.groupRecord?.let {
        tvName.text = it.name
        if (it.groupThumb != null) {
          glide!!.load(it.groupThumb).into(ivUserProfile)
        }
      }
    }
  }

  override fun getFilter(): Filter {
    return object : Filter() {
      @SuppressLint("DefaultLocale")
      override fun performFiltering(charSequence: CharSequence): FilterResults {
        val charString = charSequence.toString()
        filteredChatList = if (charString.isEmpty()) {
          chatList
        } else {
          val filteredList = ArrayList<MessageRecord>()
          for (row in chatList) {
            // name match condition. this might differ depending on your requirement
            // here we are looking for name or phone number match
            if (row.message != null && row.message!!.toLowerCase().contains(charString.toLowerCase())) {
              filteredList.add(row)
            }
          }
          filteredList
        }

        val filterResults = FilterResults()
        filterResults.values = filteredChatList
        return filterResults
      }

      override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
        filteredChatList = filterResults.values as ArrayList<MessageRecord>
        notifyDataSetChanged()
        if (filteredChatList.isNullOrEmpty()) {
          listener.onStarredListChanged(true)
        } else {
          listener.onStarredListChanged(false)
        }
      }
    }
  }

  interface ChatCommonAdapterListener {
    fun onMessageSelected(messageRecord: MessageRecord)

    fun downloadMedia(
      msgId: String ,
      serverUrl: String ,
      dirPath: String ,
      mediaType: String
    )

    fun onAddToFav(messageRecord: MessageRecord)

    fun goToThread(messageRecord: MessageRecord)

    fun onMessageLongPress(messageRecord: MessageRecord, position: Int)

    fun onMentionUserClicked(appUserId: String)

    fun onSelectReaction(chatReactionRecord: ChatReactionRecord, messageRecord: MessageRecord)

    fun onReactionLongClickListener(reactionUnicodes: List<String>,msgId:String,threadId:String,chatType:String)

    fun onStarredListChanged(isDataEmpty: Boolean)

    fun onChatTryAgain(messageRecord: MessageRecord, position: Int)
  }

  fun notifyMessageAdded(messageRecord: MessageRecord): Int {
    chatList.add(messageRecord)
    notifyItemInserted(chatList.size-1)
    updateReplyThreadCount()
    return (chatList.size - 1)
  }

  fun notifyMessageUpdated(index: Int, messageRecord: MessageRecord) {
    if (index >= chatList.size) {
      chatList.add(messageRecord)
      notifyItemInserted(index)
      updateReplyThreadCount()
    } else {
      chatList[index] = messageRecord
      notifyItemChanged(index)
    }
  }

  fun notifyMessageStatusChanged(messageRecord: MessageRecord) {
    for((index, messageItem) in chatList.withIndex()) {
      if(messageItem.id == messageRecord.id) {
        chatList[index] = messageRecord
        notifyItemChanged(index)
        return
      }
    }

    chatList.add(messageRecord)
    notifyItemInserted(chatList.size-1)
    updateReplyThreadCount()
  }

  fun notifyMessageAsFavorite(position: Int, isFavorite: Boolean) {
    chatList[position] = chatList[position].copy(isFavoriteMessage = isFavorite)
    notifyItemChanged(position)
  }

  fun notifyFollowThread(position: Int, isFollowed: Boolean) {
    chatList[position] = chatList[position].copy(isFollowThread = isFollowed)
    notifyItemChanged(position)
  }

  fun notifyReportMessage(position: Int, messageRecord: MessageRecord) {
    chatList[position] = messageRecord
    notifyItemChanged(position)
  }

  fun notifyMessageDeleted(position: Int, messageRecord: List<MessageRecord>) {
    chatList[position] = chatList[position].copy(message = messageRecord[0].message, updateType = messageRecord[0].updateType)
    notifyItemChanged(position)
  }

  fun notifyMessageUpdated(messageRecord: MessageRecord) {
    for((index, messageItem) in chatList.withIndex()) {
      if(messageItem.id == messageRecord.id) {
        if (messageRecord.updateType == MessageUpdateType.EDIT) {
          chatList[index] = chatList[index].copy(
            message = messageRecord.message,
            updateType = messageRecord.updateType,
            isFavoriteMessage = messageRecord.isFavoriteMessage
          )
        } else {
          chatList[index] = messageRecord
        }
        notifyItemChanged(index)
        return
      }
    }

    chatList.add(messageRecord)
    notifyItemInserted(chatList.size-1)
    updateReplyThreadCount()
  }

  private fun handleThreadBox(
    messageRecord: MessageRecord,
    tvThreadTitle: AppCompatTextView,
    ivAddFav: AppCompatImageView,
    ivCopy: AppCompatImageView) {

    tvChatThreadTitle = tvThreadTitle
    if (filteredChatList.size > 1) {
      tvThreadTitle.text = "${(filteredChatList.size -1)} Reply"
    } else {
      tvThreadTitle.text = context.getString(R.string.start_thread)
    }

    if (messageRecord.isFavoriteMessage!!) {
      ivAddFav.setImageResource(R.drawable.ic_add_fav_selected)
    } else {
      ivAddFav.setImageResource(R.drawable.ic_add_fav)
    }

    ivCopy.setOnClickListener {
      val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
      val clip: ClipData = ClipData.newPlainText(context.getString(R.string.text_copied), messageRecord.message)
      clipboard.setPrimaryClip(clip)
      context.shortToast(context.getString(R.string.text_copied))
    }

    ivAddFav.setOnClickListener {
      listener.onAddToFav(messageRecord)
    }
  }

  private fun updateReplyThreadCount() {
    if (threadType == ChatType.SINGLE_CHAT_THREAD.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
      tvChatThreadTitle?.let { tvThreadTitle ->
        if (filteredChatList.size > 1) {
          tvThreadTitle.text = "${(filteredChatList.size - 1)} Reply"
        } else {
          tvThreadTitle.text = context.getString(R.string.start_thread)
        }
      }
    }
  }

  fun stopMedia() {
    audioPlayer.stop()

    ivPlayAudioBtn?.let { it1 ->
      ivStopAudioBtn?.let {
        it1.visibility = View.VISIBLE
        it.visibility = View.GONE
      }
    }
    mediaId = ""
    previousSeekBar?.progress = 0
    ivPlayAudioBtn = null
    ivStopAudioBtn = null
  }

  private fun setMentionText(tvMessage: AppCompatTextView, messageRecord: MessageRecord) {
    messageRecord.message?.let { message ->
      val userPattern = Regex("@+[a-zA-Z0-9_ @-]+.")
      val genericPattern = Regex("@channel|@here")

      if (AppConstants.pattern.containsMatchIn(message)) {
        val channelParsedMessage = AppConstants.channelPattern.replace(message) { matchResult ->
          matchResult.value.substring(1, matchResult.value.length-1)
        }

        val parsedMessage = AppConstants.pattern.replace(channelParsedMessage) { matchResult ->
          matchResult.value.substring(1, matchResult.value.length-1).replace("_", " ") + "."
        }

        val spannable = SpannableStringBuilder(parsedMessage)
        val userMatcher = userPattern.findAll(parsedMessage, 0)

        userMatcher.forEach { userMatch ->
          if (userMatch.toString().toLowerCase() != "@channel" && userMatch.toString().toLowerCase() != "@here") {
            val userClickableSpan = object : ClickableSpan() {
              override fun onClick(widget: View) {
                // TODO add check if widget instanceof TextView
                val tv = widget as AppCompatTextView
                // TODO add check if tv.getText() instanceof Spanned
                val spanned = tv.text as Spanned
                val start = spanned.getSpanStart(this)
                val end = spanned.getSpanEnd(this)
                //listener.onMentionUserClicked(spanned.subSequence(start+1, end).toString())
              }

              override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor(context.getString(R.string.user_mention_color))
                ds.isUnderlineText = false
                ds.isFakeBoldText = true
              }

            }

            spannable.setSpan(
              userClickableSpan,
              userMatch.range.first,
              userMatch.range.last+1,
              Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
          }
        }

        if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
          val genericMatcher = genericPattern.findAll(parsedMessage, 0)
          genericMatcher.forEach { genericMatch ->

            val genericClickableSpan = object : ClickableSpan() {
              override fun onClick(widget: View) {
                // TODO with onclick event
              }

              override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.parseColor(context.getString(R.string.generic_mention_color))
                ds.isUnderlineText = false
                ds.isFakeBoldText = true
              }

            }

            spannable.setSpan(
              genericClickableSpan,
              genericMatch.range.first,
              genericMatch.range.last+1,
              Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
          }
        }

        if (messageRecord.updateType == MessageUpdateType.EDIT){
          spannable.spansAppend(
            " (edited)",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE,
            RelativeSizeSpan(0.8f),
            Color.parseColor(context.getString(R.string.fab_disable_bg))
          )
        }
        tvMessage.text = spannable
        tvMessage.movementMethod = LinkMovementMethod.getInstance()
      } else {
        if (messageRecord.updateType == MessageUpdateType.EDIT){
          val spannable = SpannableStringBuilder(message)
          spannable.spansAppend(
            " (edited)",
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE,
            RelativeSizeSpan(0.8f),
            Color.parseColor(context.getString(R.string.fab_disable_bg))
          )
          tvMessage.text = spannable
        }else{
          tvMessage.text = message
        }
      }
    }
  }

  fun SpannableStringBuilder.spansAppend(
    text: CharSequence,
    flags: Int,
    vararg spans: Any
  ): SpannableStringBuilder {
    val start = length
    append(text)

    spans.forEach { span ->
      setSpan(span, start, length, flags)
    }

    return this
  }

  private fun setReactionData(rvReactions: RecyclerView, reactionList: List<ChatReactionRecord>, messageRecord: MessageRecord) {
   rvReactions.visibility = if (messageRecord.updateType == MessageUpdateType.DELETE) View.GONE else View.VISIBLE
    var spanCount = 5
    if (reactionList.size < 5) {
      spanCount = reactionList.size
    }

    val gridLayoutManager =
      GridLayoutManager(context, spanCount, LinearLayoutManager.VERTICAL, false)
    rvReactions.layoutManager = gridLayoutManager
    rvReactions.setHasFixedSize(true)
    val reactionsAdapter = ReactionsAdapter(reactionList as ArrayList<ChatReactionRecord>, messageRecord, this)
    rvReactions.adapter = reactionsAdapter
  }

  private fun parseRegex(chatMessage: String?): String {
    chatMessage?.let {chatMessage ->
      if (AppConstants.pattern.containsMatchIn(chatMessage)) {
        return AppConstants.pattern.replace(chatMessage) { matchResult ->
          matchResult.value.substring(1, matchResult.value.length - 1).replace("_", " ")
        }
      }
      return chatMessage
    }
    return ""
  }

  fun notifyMessageMetaDataUpdated(chatReaction: ChatReactionRecord) {
    for((index, messageItem) in chatList.withIndex()) {
      if(messageItem.id == chatReaction.msgUniqueId) {
        var reactionList = ArrayList<ChatReactionRecord>()
        if (chatList[index].reactions.isNullOrEmpty()) {
          chatReaction.count?.let {
            if (it > 0) {
              reactionList.add(chatReaction)
            }
          }
        } else {
          reactionList = chatList[index].reactions as ArrayList<ChatReactionRecord>
          var isChatReactionDataAdded = false

          for ((position, reactionData) in chatList[index].reactions?.withIndex()!!) {
            if (chatReaction.emojiCode == reactionData.emojiCode) {
              if (chatReaction.count == 0) {
                reactionList.removeAt(position)
              } else {
                reactionList[position] = chatReaction
              }
              isChatReactionDataAdded = true
              break
            }
          }

          if (!isChatReactionDataAdded) {
            reactionList.add(chatReaction)
          }
        }

        chatList[index].reactions = reactionList
        notifyItemChanged(index)
        return
      }
    }
  }

  fun notifyThreadMetadataChanged(threadMessageMetadata: ThreadMessageMetadata) {
    for((index, messageItem) in chatList.withIndex()) {
      if(messageItem.id == threadMessageMetadata.parentMsgId) {
        chatList[index].chatThreadMetadata = threadMessageMetadata.copy(parentMsgId = "")
        notifyItemChanged(index)
        return
      }
    }
  }

  private fun setSentToChannelTag(tvSendToChannel: AppCompatTextView, sentToChannel: Int?) {
    if (sentToChannel == 1) {
      tvSendToChannel.visibility = View.VISIBLE
    } else {
      tvSendToChannel.visibility = View.GONE
    }
  }

  private fun setReadReceipt(
    tvStatus: AppCompatTextView,
    status: String?,
    position: Int,
    isMedia: Boolean = true,
    pbSendAgain: ProgressBar? = null
  ) {
    if ((position + 1) == chatList.size) {
      tvStatus.visibility = View.VISIBLE
      if (threadType == ChatType.GROUP.type || threadType == ChatType.GROUP_CHAT_THREAD.type) {
        if (status == MessageStatus.DELIVERED.status || status == MessageStatus.SEEN.status) {
          tvStatus.text = MessageStatus.SENT.status
        } else {
          tvStatus.text = status
        }
      } else {
        var readStatus = status?.replace(MessageStatus.SEEN.status, AppConstants.READ)
        readStatus = readStatus?.replace(MessageStatus.DELIVERED.status, AppConstants.DELIVERED)
        if (isMedia) {
          if (readStatus == AppConstants.READ) {
            tvStatus.text = AppConstants.DELIVERED
          } else {
            tvStatus.text = readStatus
          }
        } else {
          tvStatus.text = readStatus
        }
      }

      if (status == MessageStatus.FAILED.status) {
        val spannable = SpannableString("$status. Try again")
        val chatClickableSpan = object : ClickableSpan() {
          override fun onClick(widget: View) {
            pbSendAgain?.visibility = View.VISIBLE
            listener.onChatTryAgain(filteredChatList[position], position)
          }

          override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = Color.parseColor(context.getString(R.string.try_again_color))
            ds.isUnderlineText = false
            ds.isFakeBoldText = false
          }
        }

        spannable.setSpan(
          chatClickableSpan,
          8, // start
          spannable.length, // end
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvStatus.text = spannable
        tvStatus.movementMethod = LinkMovementMethod.getInstance()
      }

      if (position > 0) {
        Observable.just(true)
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe{
            notifyItemChanged(position-1)
          }
      }
    } else {
      if (status == MessageStatus.FAILED.status) {
        val spannable = SpannableString("$status. Try again")
        val chatClickableSpan = object : ClickableSpan() {
          override fun onClick(widget: View) {
            pbSendAgain?.visibility = View.VISIBLE
            listener.onChatTryAgain(filteredChatList[position], position)
          }

          override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = Color.parseColor(context.getString(R.string.try_again_color))
            ds.isUnderlineText = false
            ds.isFakeBoldText = false
          }
        }

        spannable.setSpan(
          chatClickableSpan,
          8, // start
          spannable.length, // end
          Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvStatus.text = spannable
        tvStatus.movementMethod = LinkMovementMethod.getInstance()
      } else {
        tvStatus.visibility = View.GONE
      }
    }
  }

  private fun removeSenderReadReceipt(position: Int) {
    if ((position + 1) == chatList.size && position > 0) {
      Observable.just(true)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe{
          notifyItemChanged(position-1)
        }
    }
  }

  override fun onReactionClick(chatReactionRecord: ChatReactionRecord, messageRecord: MessageRecord) {
    listener.onSelectReaction(chatReactionRecord, messageRecord)
  }

  override fun onReactionLongClick(
    reactionUnicodes: List<String>,
    msgId: String,
    threadId: String,
    chatType: String
  ) {
    listener.onReactionLongClickListener(reactionUnicodes, msgId, threadId, chatType)
  }

  fun update(messageList:ArrayList<MessageRecord>){
    filteredChatList = messageList
    chatList = messageList
    notifyDataSetChanged()
  }

  private fun setUserName(tvName: AppCompatTextView, messageRecord: MessageRecord, position: Int) {
    if (position > 0) {
      val preMessageRecord = filteredChatList[position-1]
      if (preMessageRecord.chatEventType == ChatEventType.INCOMING &&
        messageRecord.senderId == preMessageRecord.senderId) {
        tvName.visibility = View.GONE
      } else {
        tvName.visibility = View.VISIBLE
        tvName.text = messageRecord.senderRecord?.name ?: ""
      }
    } else {
      tvName.visibility = View.VISIBLE
      tvName.text = messageRecord.senderRecord?.name ?: ""
    }
  }

  private fun setForwardTag(ivForwardTag: View, tvForwardTag: AppCompatTextView, isForwardMessage: Boolean) {
    if (isForwardMessage) {
      tvForwardTag.visibility = View.VISIBLE
      ivForwardTag.visibility = View.VISIBLE
    } else {
      tvForwardTag.visibility = View.GONE
      ivForwardTag.visibility = View.GONE
    }
  }

  private fun pauseOrStopAudio(messageId: String = "") {
    if (messageId.isEmpty()) {
      audioPlayer.pause()
      ivPlayAudioBtn?.let { it1 ->
        ivStopAudioBtn?.let {
          it1.visibility = View.VISIBLE
          it.visibility = View.GONE
        }
      }
    } else if (mediaId == messageId) {
      audioPlayer.pause()
    } else {
      audioPlayer.stop()
      previousSeekBar?.progress = 0
    }
  }

  fun highlightPosition(position: Int) {
    highlightedPosition = position
  }

  private fun setFollowThreadReplyCount(tvThreadCount: AppCompatTextView, count: Int) {
    // Once we implement chat thread restoration than we will remove below line and uncomment this code.
    tvThreadCount.visibility = View.GONE
    /*if (count < 3) {
      tvThreadCount.visibility = View.GONE
    } else {
      tvThreadCount.visibility = View.VISIBLE
      tvThreadCount.text = context.getString(R.string.view_replies, (count-2))
    }*/
  }
}