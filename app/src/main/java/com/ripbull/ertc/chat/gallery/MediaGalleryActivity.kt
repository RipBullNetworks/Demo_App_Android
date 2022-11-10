package com.ripbull.ertc.chat.gallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AbsListView
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.ChatType
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.coresdk.core.type.ScrollTo
import com.ripbull.coresdk.eRTCSDK
import com.ripbull.coresdk.group.mapper.GroupRecord
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.AppConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_media_gallery.*
import kotlinx.android.synthetic.main.all_toolbar_dark.rlToolbar

class MediaGalleryActivity: BaseActivity() {

  private val disposable = CompositeDisposable()
  private var threadID: String? = null
  var galleryAdapter: MediaGalleryAdapter? = null
  private var mediaList = ArrayList<MessageRecord>()
  private var lastMsgId: String = ""
  private var isDataLoaded = true

  companion object {
    @JvmStatic
    fun getIntent(
      context: Context,
      name: String,
      threadId: String,
      threadType: String,
      groupId: String? = null
    ): Intent {
      val intent = Intent(context, MediaGalleryActivity::class.java)
      intent.putExtra(AppConstants.NAME, name)
      intent.putExtra(AppConstants.EXTRA_THREAD_ID, threadId)
      intent.putExtra(AppConstants.THREAD_TYPE, threadType)
      intent.putExtra(AppConstants.EXTRA_ID, groupId)
      return intent
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_media_gallery)
    rlToolbar.gravity = Gravity.LEFT

    if (intent.getStringExtra(AppConstants.THREAD_TYPE) == ChatType.GROUP.type) {
      setTitleToolBar(getString(R.string.channel_gallery))
    } else {
      setTitleToolBar(getString(R.string.gallery))
    }

    if (intent.hasExtra(AppConstants.EXTRA_THREAD_ID)) {
      threadID = intent.getStringExtra(AppConstants.EXTRA_THREAD_ID)
    }

    showProgressbar()
    disposable.add(
      eRTCSDK.chat()
        .getMediaGallery(threadID!!, null, ScrollTo.PAST.type, 20)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          dismissProgressbar()
          val msgList = it as ArrayList<MessageRecord>
          mediaList.addAll(msgList.reversed())
          if (mediaList.isNullOrEmpty()) {
            gvGallery.visibility = View.GONE
            tvNoMedia.visibility = View.VISIBLE
            return@subscribe
          }

          galleryAdapter = MediaGalleryAdapter(this, mediaList)
          gvGallery.adapter = galleryAdapter
          gvGallery.setOnItemClickListener { _, _, position, _ ->
            val messageRecord = mediaList[position]
            if (messageRecord.msgType == MessageType.IMAGE.type) {
              openImage(
                messageRecord.id, messageRecord.mediaPath, mediaList[position].senderId, "",
                messageRecord.type, messageRecord.timestamp
              )
            } else if (messageRecord.msgType == MessageType.VIDEO.type) {
              openVideo(
                messageRecord.id, messageRecord.mediaPath, messageRecord.senderId,
                messageRecord.type, messageRecord.timestamp, messageRecord.msgType
              )
            } else {
              openVideo(
                messageRecord.id, messageRecord.mediaPath, messageRecord.senderId,
                messageRecord.type, messageRecord.timestamp, messageRecord.msgType
              )
            }
          }
        }) {
          setErrorAlert(it)
        }
    )

    intent.getStringExtra(AppConstants.EXTRA_ID)?.let { groupId ->
      disposable.add(
        eRTCSDK.group()
          .subscribeToGroupUpdate()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({
            if (groupId == it.groupId) {
              if (it.groupStatus == GroupRecord.STATUS_FROZEN) {
                finish()
              }
            }
          }, {
            setErrorAlert(it)
          })
      )
    }

    gvGallery.setOnScrollListener(object: AbsListView.OnScrollListener {
      override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
        if (totalItemCount - visibleItemCount <= firstVisibleItem && totalItemCount >= 20) {
          //TODO: Add footer or some progress view to show that items are loading

        }
      }
      override fun onScrollStateChanged(view: AbsListView?, state: Int) {
        //TODO: add some logic if needed, but no logic needed for this task
        if (mediaList.size < 20) {
          return
        }
        if (!gvGallery.canScrollVertically(-1) && isDataLoaded) {
          isDataLoaded = false
          val index = mediaList.size-1
          if (lastMsgId == mediaList[index].id) {
            return
          }
          lastMsgId = mediaList[index].id
          showProgressbar()
          disposable.add(
            eRTCSDK.chat().getMediaGallery(
              threadId = threadID!!,
              currentMsgId = lastMsgId,
              direction = ScrollTo.PAST.type,
              pageSize = 20
            )
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe({
                dismissProgressbar()
                val msgList = it as ArrayList<MessageRecord>
                mediaList.addAll(msgList.reversed())
                isDataLoaded = true
                if (galleryAdapter != null) {
                  galleryAdapter?.update(mediaList)
                }
              }) {
                isDataLoaded = true
                setErrorAlert(it)
              }
          )
        }
      }
    })
  }

}