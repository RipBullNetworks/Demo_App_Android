package com.ripbull.ertc.ui.location

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.model.PlaceLikelihood
import com.ripbull.coreattachment.LocationSelector
import com.ripbull.coreattachment.location.ErtcLocation
import com.ripbull.coreattachment.location.LocationGooglePlayServicesProvider
import com.ripbull.ertc.R
import com.ripbull.ertc.core.BaseActivity
import com.ripbull.ertc.util.AppConstants
import com.ripbull.permissions.Permissions
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_share_location.ivCurrentLocation
import kotlinx.android.synthetic.main.activity_share_location.rlCurrentLocation
import kotlinx.android.synthetic.main.activity_share_location.rvPlaces
import kotlinx.android.synthetic.main.activity_share_location.tvCurrentLocationAddress

class ShareLocationActivity : BaseActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
  PlaceAdapter.PlaceAdapterListener {

  private lateinit var map: GoogleMap
  private lateinit var lastLocation: Location
  private var selectedLatLng: LatLng? = null

  private var statusOfGPS: Boolean = false
  private val markerOptions = MarkerOptions()
  private var list: List<PlaceLikelihood>? = null
  private var manager: LocationManager? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_share_location)

    loadUI()
  }

  override fun onResume() {
    super.onResume()
    Permissions.with(this).request(
      Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.ACCESS_COARSE_LOCATION,
      Manifest.permission.ACCESS_WIFI_STATE
    ).ifNecessary().withPermanentDenialDialog(this.getString(R.string.attachment_location_denied))
      .onAllGranted {
        statusOfGPS = manager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (!statusOfGPS) {
          val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
          startActivity(intent)
        }
      }.execute()
  }

  private fun loadUI() {
    showProgressbar()
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    mapFragment.getMapAsync(this)

    manager = getSystemService(LOCATION_SERVICE) as LocationManager

    val toolbar = setTitleToolBar(getString(R.string.title_send_location))
    /*toolbar.inflateMenu(R.menu.location_menu)
    toolbar.setOnMenuItemClickListener {
      when (it.itemId) {
        R.id.action_search -> {
          loadPlacePicker()
        }
        else -> {
        }
      }
      true
    }*/

    ivCurrentLocation.setOnClickListener {
      statusOfGPS = manager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)

      if (!statusOfGPS) {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivity(intent)
      } else {
        //map.isMyLocationEnabled = true
        startLocation(this)
      }
    }

    rlCurrentLocation.setOnClickListener {
      if (selectedLatLng != null){
        val locationIntent = Intent()
        locationIntent.putExtra(AppConstants.EXTRA_LAT_LNG, selectedLatLng)
        locationIntent.putExtra(AppConstants.EXTRA_ADDRESS, tvCurrentLocationAddress.text)
        setResult(Activity.RESULT_OK, locationIntent)
        finish()
      }else{
        Toast.makeText(this, getString(R.string.no_address_selected), Toast.LENGTH_SHORT).show()
      }
    }
  }

  /**
   * Manipulates the map once available.
   * This callback is triggered when the map is ready to be used.
   * This is where we can add markers or lines, add listeners or move the camera. In this case,
   * we just add a marker near Sydney, Australia.
   * If Google Play services is not installed on the device, the user will be prompted to install
   * it inside the SupportMapFragment. This method will only be triggered once the user has
   * installed Google Play services and returned to the app.
   */
  @SuppressLint("MissingPermission")
  override fun onMapReady(googleMap: GoogleMap) {
    map = googleMap

    map.uiSettings.isZoomControlsEnabled = true
    map.setOnMarkerClickListener(this)
    map.isMyLocationEnabled = false
    map.mapType = GoogleMap.MAP_TYPE_NORMAL
    map.uiSettings.isZoomControlsEnabled = false
    startLocation(this)
  }

  override fun onMarkerClick(p0: Marker?) = false

  private fun startLocation(activity: Activity) {
    val provider = LocationGooglePlayServicesProvider()
    provider.setCheckLocationSettings(false)
    val ertcLocation = ErtcLocation.Builder(activity).build()
    ertcLocation.location(provider).start {
      lastLocation = it //return current location
      val latLng = LatLng(lastLocation.latitude, lastLocation.longitude)
      placeMarkerOnMap(latLng, getAddress(latLng))
      selectLocation(this)
    }
    dismissProgressbar()
  }

  private fun selectLocation(activity: Activity) {
    Permissions.with(activity).request(
      Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.ACCESS_COARSE_LOCATION,
      Manifest.permission.ACCESS_WIFI_STATE
    ).ifNecessary()
      .withPermanentDenialDialog(activity.getString(R.string.attachment_location_denied))
      .onAllGranted {
        val apiKey = activity.getString(R.string.google_api_key)
        val locationSelector = LocationSelector()
        try {
          locationSelector.selectPlaces(activity, apiKey).observeOn(
            AndroidSchedulers.mainThread()
          ).subscribe(
            ::onLocationSyncSuccess, ::onLocationSyncFailure
          )
        } catch (ex: SecurityException) {
          ex.printStackTrace()
        }
      }.execute()
  }

  private fun onLocationSyncSuccess(list: List<PlaceLikelihood>) {
    System.out.println(list)
    this.list = list;
    if (list != null) {
      //adding a layoutmanager
      rvPlaces.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
      //creating our adapter
      val adapter = PlaceAdapter(list, this, this)
      //now adding the adapter to recyclerview
      rvPlaces.adapter = adapter
    }
  }

  private fun onLocationSyncFailure(throwable: Throwable) {

  }

  private fun getAddress(latLng: LatLng): String {
    val geocoder = Geocoder(this)
    val addresses: List<Address>?
    val address: Address?
    var addressText = ""

    try {
      addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
      if (null != addresses && !addresses.isEmpty()) {
        address = addresses[0]
        if (address != null) {
          addressText = address.getAddressLine(0)
        }
        /*for (i in 0 until address.maxAddressLineIndex) {
          addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
        }*/
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }

    return addressText
  }

  private fun placeMarkerOnMap(location: LatLng, address: String) {
    map.clear()
    selectedLatLng = location
    markerOptions.position(location)

    markerOptions.title(address)
    tvCurrentLocationAddress.text = address

    map.addMarker(markerOptions)
    map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 17f))
  }

  /*private fun loadPlacePicker() {
    val builder = PlacePicker.IntentBuilder()

    try {
      startActivityForResult(builder.build(this@ShareLocationActivity), PLACE_PICKER_REQUEST)
    } catch (e: GooglePlayServicesRepairableException) {
      e.printStackTrace()
    } catch (e: GooglePlayServicesNotAvailableException) {
      e.printStackTrace()
    }
  }*/

  override fun onPlaceSelected(place: PlaceLikelihood) {
    val locationIntent = Intent()
    locationIntent.putExtra(AppConstants.EXTRA_LAT_LNG, place.place.latLng)
    locationIntent.putExtra(AppConstants.EXTRA_ADDRESS, place.place.address)
    setResult(Activity.RESULT_OK, locationIntent)
    finish()
  }
}