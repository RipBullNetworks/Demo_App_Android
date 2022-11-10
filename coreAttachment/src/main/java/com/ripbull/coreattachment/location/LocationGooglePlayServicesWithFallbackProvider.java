package com.ripbull.coreattachment.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class LocationGooglePlayServicesWithFallbackProvider
    implements LocationProvider, GooglePlayServicesListener {

  private OnLocationUpdatedListener listener;
  private boolean shouldStart = false;
  private Context context;
  private LocationParams params;
  private boolean singleUpdate = false;

  private LocationProvider provider;

  public LocationGooglePlayServicesWithFallbackProvider(Context context) {
    if (context == null) {
      // context = PantepicApp.getAppContext();
    }
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS) {
      provider = new LocationGooglePlayServicesProvider(this);
    } else {
      provider = new LocationManagerProvider();
    }
  }

  @Override
  public void init(Context context) {
    this.context = context;
    provider.init(context);
  }

  @Override
  public void start(OnLocationUpdatedListener listener, LocationParams params,
      boolean singleUpdate) {
    shouldStart = true;
    this.listener = listener;
    this.params = params;
    this.singleUpdate = singleUpdate;
    provider.start(listener, params, singleUpdate);
  }

  @Override
  public void stop() {
    provider.stop();
    shouldStart = false;
  }

  @Override
  public Location getLastLocation() {
    return provider.getLastLocation();
  }

  @Override
  public void onConnected(Bundle bundle) {
    // Nothing to do here
  }

  @Override
  public void onConnectionSuspended(int i) {
    fallbackToLocationManager();
  }

  @Override
  public void onConnectionFailed(ConnectionResult connectionResult) {
    fallbackToLocationManager();
  }

  private void fallbackToLocationManager() {
    provider = new LocationManagerProvider();
    provider.init(context);
    if (shouldStart) {
      provider.start(listener, params, singleUpdate);
    }
  }
}
