package com.ripbull.coreattachment.location;

import android.content.Context;
import android.location.Location;

public interface LocationProvider {
  void init(Context context);

  void start(OnLocationUpdatedListener listener, LocationParams params, boolean singleUpdate);

  void stop();

  Location getLastLocation();
}
