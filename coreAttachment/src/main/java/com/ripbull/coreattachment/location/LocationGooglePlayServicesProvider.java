package com.ripbull.coreattachment.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_WIFI_STATE;

public class LocationGooglePlayServicesProvider
    implements LocationProvider, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener, LocationListener, ResultCallback<Status> {

  public static final int REQUEST_START_LOCATION_FIX = 10001;
  public static final int REQUEST_CHECK_SETTINGS = 20001;

  private GoogleApiClient client;
  private OnLocationUpdatedListener listener;
  private boolean shouldStart = false;
  private boolean stopped = false;
  private LocationRequest locationRequest;
  private Context context;
  private GooglePlayServicesListener googlePlayServicesListener;
  private boolean checkLocationSettings;
  private boolean fulfilledCheckLocationSettings;
  private boolean alwaysShow = true;

  public LocationGooglePlayServicesProvider() {
    checkLocationSettings = false;
    fulfilledCheckLocationSettings = false;
  }

  public LocationGooglePlayServicesProvider(GooglePlayServicesListener playServicesListener) {
    this();
    googlePlayServicesListener = playServicesListener;
  }

  @Override
  public void init(Context context) {
    this.context = context;

    if (!shouldStart) {
      this.client = new GoogleApiClient.Builder(context).addApi(LocationServices.API)
          .addConnectionCallbacks(this)
          .addOnConnectionFailedListener(this)
          .build();

      client.connect();
    } else {
      // already started
    }
  }

  private LocationRequest createRequest(LocationParams params, boolean singleUpdate) {
    LocationRequest request = LocationRequest.create()
        .setFastestInterval(params.getInterval())
        .setInterval(params.getInterval())
        .setSmallestDisplacement(params.getDistance());

    switch (params.getAccuracy()) {
      case HIGH:
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        break;
      case MEDIUM:
        request.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        break;
      case LOW:
        request.setPriority(LocationRequest.PRIORITY_LOW_POWER);
        break;
      case LOWEST:
        request.setPriority(LocationRequest.PRIORITY_NO_POWER);
        break;
    }

    if (singleUpdate) {
      request.setNumUpdates(1);
    }

    return request;
  }

  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  @Override
  public void start(OnLocationUpdatedListener listener, LocationParams params,
      boolean singleUpdate) {
    this.listener = listener;
    if (listener == null) {
    }
    locationRequest = createRequest(params, singleUpdate);

    if (client.isConnected()) {
      startUpdating(locationRequest);
    } else if (stopped) {
      shouldStart = true;
      client.connect();
      stopped = false;
    } else {
      shouldStart = true;
    }
  }

  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  private void startUpdating(LocationRequest request) {
    // TODO wait until the connection is done and retry
    if (checkLocationSettings && !fulfilledCheckLocationSettings) {
      checkLocationSettings();
      return;
    }
    if (client.isConnected()) {
      LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this,
          Looper.getMainLooper()).setResultCallback(this);
    } else {

    }
  }

  private void checkLocationSettings() {
    LocationSettingsRequest request =
        new LocationSettingsRequest.Builder().setAlwaysShow(alwaysShow)
            .addLocationRequest(locationRequest)
            .build();
    LocationServices.SettingsApi.checkLocationSettings(client, request)
        .setResultCallback(settingsResultCallback);
  }

  @Override
  public void stop() {
    if (client.isConnected()) {
      LocationServices.FusedLocationApi.removeLocationUpdates(client, this);
      client.disconnect();
    }
    fulfilledCheckLocationSettings = false;
    shouldStart = false;
    stopped = true;
  }

  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  @Override
  public Location getLastLocation() {
    if (client != null && client.isConnected()) {
      Location location = LocationServices.FusedLocationApi.getLastLocation(client);
      if (location != null) {
        return location;
      }
    }
    return null;
  }

  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  @Override
  public void onConnected(Bundle bundle) {
    if (shouldStart) {
      startUpdating(locationRequest);
    }
    if (googlePlayServicesListener != null) {
      googlePlayServicesListener.onConnected(bundle);
    }
  }

  @Override
  public void onConnectionSuspended(int i) {
    if (googlePlayServicesListener != null) {
      googlePlayServicesListener.onConnectionSuspended(i);
    }
  }

  @Override
  public void onConnectionFailed(ConnectionResult connectionResult) {
    if (googlePlayServicesListener != null) {
      googlePlayServicesListener.onConnectionFailed(connectionResult);
    }
  }

  @Override
  public void onLocationChanged(Location location) {
    if (listener != null) {
      listener.onLocationUpdated(location);
    }
  }

  @Override
  public void onResult(Status status) {
    if (status.isSuccess()) {

    } else if (status.hasResolution() && context instanceof Activity) {
      try {
        status.startResolutionForResult((Activity) context, REQUEST_START_LOCATION_FIX);
      } catch (IntentSender.SendIntentException e) {

      }
    } else {
      // No recovery. Weep softly or inform the user.
    }
  }

  /**
   * @return TRUE if active, FALSE if the settings wont be checked before launching the location
   * updates request
   */
  public boolean isCheckingLocationSettings() {
    return checkLocationSettings;
  }

  /**
   * Sets whether or not we should request (before starting updates) the availability of the
   * location settings and act upon it.
   *
   * @param allowingLocationSettings TRUE to show the dialog if needed, FALSE otherwise (default)
   */
  public void setCheckLocationSettings(boolean allowingLocationSettings) {
    this.checkLocationSettings = allowingLocationSettings;
  }

  /**
   * Sets whether or not we should show location settings dialog with NEVER button
   *
   * @param alwaysShow TRUE to show dialog without NEVER button, FALSE - with NEVER button (default)
   */
  public void setLocationSettingsAlwaysShow(boolean alwaysShow) {
    this.alwaysShow = alwaysShow;
  }

  /**
   * This method should be called in the onActivityResult of the calling activity whenever we are
   * trying to implement the Check Location Settings fix dialog.
   */
  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CHECK_SETTINGS) {
      switch (resultCode) {
        case Activity.RESULT_OK:
          fulfilledCheckLocationSettings = true;
          startUpdating(locationRequest);
          break;
        case Activity.RESULT_CANCELED:
          stop();
          break;
      }
    } else if (requestCode == REQUEST_START_LOCATION_FIX) {
      switch (resultCode) {
        case Activity.RESULT_OK:
          startUpdating(locationRequest);
          break;
        case Activity.RESULT_CANCELED:
          stop();
          break;
      }
    }
  }

  private ResultCallback<LocationSettingsResult> settingsResultCallback =
      new ResultCallback<LocationSettingsResult>() {
        @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
        @Override
        public void onResult(LocationSettingsResult locationSettingsResult) {
          final Status status = locationSettingsResult.getStatus();
          switch (status.getStatusCode()) {
            case LocationSettingsStatusCodes.SUCCESS:
              fulfilledCheckLocationSettings = true;
              startUpdating(locationRequest);
              break;
            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
              if (context instanceof Activity) {
                try {
                  // Show the dialog by calling startResolutionForResult(), and check the result
                  // in onActivityResult().
                  status.startResolutionForResult((Activity) context, REQUEST_CHECK_SETTINGS);
                } catch (IntentSender.SendIntentException e) {

                }
              } else {

              }
              break;
            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
              stop();
              break;
          }
        }
      };
}
