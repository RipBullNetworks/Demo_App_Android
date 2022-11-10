package com.ripbull.ertc.testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class ApiCallAdapter(
  private val list: ArrayList<RequestValues>,
  private val listener: ApiCallAdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private val TYPE_HEADER = 0
  private val TYPE_LIST = 1

  inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvHeader = itemView.findViewById(R.id.tvHeader) as AppCompatTextView
  }

  inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var btnRequest: AppCompatTextView =
      view.findViewById<View>(R.id.btnSingleRequest) as AppCompatTextView

    init {
      btnRequest.setOnClickListener {
        // send selected contact in callback
        listener.onApiButtonClicked(adapterPosition, list!![adapterPosition])

      }
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    if (viewType == TYPE_HEADER) {
      val inflatedView: View = inflater.inflate(R.layout.header_layout, parent, false)
      return HeaderViewHolder(inflatedView)
    } else if (viewType == TYPE_LIST) {
      val inflatedView: View = inflater.inflate(R.layout.single_item, parent, false)
      return MyViewHolder(inflatedView)
    }
    throw  RuntimeException(
        "there is no type that matches the type $viewType + make sure your using types correctly"
    )

  }

  override fun getItemViewType(position: Int): Int {
    if (list[position].isHeader) {
      return TYPE_HEADER
    } else {
      return TYPE_LIST
    }

  }

  override fun getItemCount(): Int {
    return list!!.size

  }

  interface ApiCallAdapterListener {
    fun onApiButtonClicked(position: Int, list: RequestValues)
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val requestValues = list!![position]
    if (requestValues.isHeader) {
      if (holder is HeaderViewHolder) {
        holder.tvHeader.text = requestValues.title
      }
    }

    if (holder is MyViewHolder) {
      holder.btnRequest.text = requestValues.requestName
    }

  }
}






