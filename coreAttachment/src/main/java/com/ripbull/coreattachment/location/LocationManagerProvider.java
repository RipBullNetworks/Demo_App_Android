package com.ripbull.coreattachment.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.RequiresPermission;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_WIFI_STATE;

public class LocationManagerProvider implements LocationProvider, LocationListener {

  private LocationManager locationManager;
  private OnLocationUpdatedListener listener;

  @Override
  public void init(Context context) {
    this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
  }

  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  @Override
  public void start(OnLocationUpdatedListener listener, LocationParams params,
      boolean singleUpdate) {
    this.listener = listener;

    Criteria criteria = getProvider(params);

    if (singleUpdate) {
      locationManager.requestSingleUpdate(criteria, this, Looper.getMainLooper());
    } else {
      locationManager.requestLocationUpdates(params.getInterval(), params.getDistance(), criteria,
          this, Looper.getMainLooper());
    }
  }

  @SuppressLint("MissingPermission")
  @Override
  public void stop() {
    if (locationManager != null) {
      locationManager.removeUpdates(this);
    }
  }

  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  @Override
  public Location getLastLocation() {
    if (locationManager != null) {
      Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
      if (location != null) {
        return location;
      }
    }

    return null;
  }

  private Criteria getProvider(LocationParams params) {
    final LocationAccuracy accuracy = params.getAccuracy();
    final Criteria criteria = new Criteria();
    switch (accuracy) {
      case HIGH:
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setBearingAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setSpeedAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);
        break;
      case MEDIUM:
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setVerticalAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setBearingAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setSpeedAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        break;
      case LOW:
      case LOWEST:
      default:
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_LOW);
        criteria.setVerticalAccuracy(Criteria.ACCURACY_LOW);
        criteria.setBearingAccuracy(Criteria.ACCURACY_LOW);
        criteria.setSpeedAccuracy(Criteria.ACCURACY_LOW);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
    }
    return criteria;
  }

  @Override
  public void onLocationChanged(Location location) {
    if (listener != null) {
      listener.onLocationUpdated(location);
    }
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {
  }

  @Override
  public void onProviderEnabled(String provider) {
  }

  @Override
  public void onProviderDisabled(String provider) {
  }
}
