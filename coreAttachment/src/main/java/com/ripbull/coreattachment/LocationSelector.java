package com.ripbull.coreattachment;

import android.app.Activity;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCESS_WIFI_STATE;

public class LocationSelector {
  @RequiresPermission(allOf = { ACCESS_FINE_LOCATION, ACCESS_WIFI_STATE })
  public Single<List<PlaceLikelihood>> selectPlaces(Activity activity, String placesApiKey) {
    return Single.create(emitter -> {
      Places.initialize(activity, placesApiKey);
      PlacesClient placesClient = Places.createClient(activity);
      List<Place.Field> list = new ArrayList();
      list.add(Place.Field.NAME);
      list.add(Place.Field.LAT_LNG);
      list.add(Place.Field.ADDRESS);
      FindCurrentPlaceRequest currentPlaceRequest = FindCurrentPlaceRequest.newInstance(list);
      Task<FindCurrentPlaceResponse> currentPlaceTask =
          placesClient.findCurrentPlace(currentPlaceRequest);
      currentPlaceTask.addOnSuccessListener((response) -> {
        emitter.onSuccess(response.getPlaceLikelihoods());
      });
      currentPlaceTask.addOnFailureListener((response) -> {
        emitter.onError(response.fillInStackTrace());
      });
    });
  }
}
