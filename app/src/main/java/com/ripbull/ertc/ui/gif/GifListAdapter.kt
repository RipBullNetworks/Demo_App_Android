package com.ripbull.ertc.ui.gif

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.ripbull.coreattachment.giph.Gif
import com.ripbull.ertc.R
import com.ripbull.ertc.util.MediaUtil

/**
 * @author Sagar
 */
class GifListAdapter(
  private val context: Context,
  private val gifList: List<Gif>,
  private val listener: GifListAdapterListener
) : RecyclerView.Adapter<GifListAdapter.MyViewHolder>() {

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var gifView: AppCompatImageView =
      view.findViewById<View>(R.id.gifView) as AppCompatImageView

    init {
      view.setOnClickListener {
        // send selected contact in callback
        listener.onGifSelected(gifList!![adapterPosition])
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val itemView =
      LayoutInflater.from(parent.context).inflate(R.layout.item_gif_list, parent, false)

    return MyViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val gif = gifList!![position]
    if (gif.gifUrl.isNotEmpty()) {
      MediaUtil.loadIGif(
        context,
        gif.gifUrl,
        holder.gifView
      )
    }
  }

  override fun getItemCount(): Int {
    return gifList!!.size
  }

  interface GifListAdapterListener {
    fun onGifSelected(gif: Gif)
  }
}