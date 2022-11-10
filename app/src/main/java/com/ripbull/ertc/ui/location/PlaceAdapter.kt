package com.ripbull.ertc.ui.location

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.libraries.places.api.model.PlaceLikelihood
import com.ripbull.ertc.R

class PlaceAdapter(
  var items: List<PlaceLikelihood>,
  val context: Context,
  val listener: PlaceAdapterListener
) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater: LayoutInflater = LayoutInflater.from(parent.context)
    var view: View
    view = inflater.inflate(R.layout.item_google_map_place, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  //this method is binding the data on the list
  override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
    holder.bindItems(items[position])
  }

  //the class is hodling the list view
  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
      itemView.setOnClickListener {
        // send selected contact in callback
        listener.onPlaceSelected(items[position])
      }
    }

    fun bindItems(placeLikelihood: PlaceLikelihood) {
      val tvLocation = itemView.findViewById(R.id.tvLocation) as AppCompatTextView
      val tvLocationAddress = itemView.findViewById(R.id.tvLocationAddress) as AppCompatTextView
      tvLocation.text = placeLikelihood.place.name
      tvLocationAddress.text = placeLikelihood.place.address

    }
  }

  interface PlaceAdapterListener {
    fun onPlaceSelected(place: PlaceLikelihood)
  }
}