package com.ripbull.ertc.group.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ripbull.coresdk.chat.mapper.MessageRecord
import com.ripbull.coresdk.core.type.MessageType
import com.ripbull.ertc.R

class GalleryAdapter(
  private val context: Context,
  private val mediaList: ArrayList<MessageRecord>
) : BaseAdapter() {

  private var layoutInflater: LayoutInflater? = null
  private lateinit var imageView: ImageView
  private lateinit var playVideo: ImageView

  override fun getCount(): Int {
    return mediaList.size
  }

  override fun getItem(position: Int): Any? {
    return null
  }

  override fun getItemId(position: Int): Long {
    return 0
  }

  override fun getView(
    position: Int,
    convertView: View?,
    parent: ViewGroup
  ): View {
    var convertView = convertView
    val messageRecord = mediaList[position]
    if (layoutInflater == null) {
      layoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    if (convertView == null) {
      convertView = layoutInflater!!.inflate(R.layout.item_gallery, null)
    }
    imageView = convertView!!.findViewById(R.id.ivMedia)
    playVideo = convertView!!.findViewById(R.id.ivVideo)

    if (messageRecord.msgType == MessageType.IMAGE.type) {
      playVideo.visibility = View.GONE
      messageRecord.mediaThumbnail?.let {
        val requestOptions = RequestOptions()
        requestOptions.centerCrop().placeholder(R.drawable.image_loader)
        Glide.with(context).load(it).apply(requestOptions).into(imageView)
      }
    } else if (messageRecord.msgType == MessageType.VIDEO.type) {
      playVideo.visibility = View.VISIBLE
      messageRecord.mediaPath?.let {
        val requestOptions = RequestOptions()
        requestOptions.centerCrop().placeholder(R.drawable.image_loader)
        Glide.with(context).load(it).apply(requestOptions).into(imageView)
      }
    } else {
      playVideo.visibility = View.VISIBLE
      val requestOptions = RequestOptions()
      requestOptions.centerCrop()
      Glide.with(context).load(R.drawable.ic_audio_file).apply(requestOptions).into(imageView)
    }

    return convertView
  }
}