package com.ripbull.coreattachment.location;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.WeakHashMap;

public class ErtcLocation {

  private Context context;
  private boolean preInitialize;

  private ErtcLocation(Context context, boolean preInitialize) {
    this.context = context;
    this.preInitialize = preInitialize;
  }

  public static ErtcLocation with(Context context) {
    return new Builder(context).build();
  }

  public LocationControl location() {
    return location(new LocationGooglePlayServicesWithFallbackProvider(context));
  }

  public LocationControl location(LocationProvider provider) {
    return new LocationControl(this, provider);
  }

  public static class Builder {
    private final Context context;
    private boolean preInitialize;

    public Builder(@NonNull Context context) {
      this.context = context;
      this.preInitialize = true;
    }

    public ErtcLocation build() {
      return new ErtcLocation(context, preInitialize);
    }
  }

  public static class LocationControl {

    private static final Map<Context, LocationProvider> MAPPING = new WeakHashMap<>();

    private final ErtcLocation pantepicLocation;
    private LocationParams params;
    private LocationProvider provider;
    private boolean oneFix;

    public LocationControl(@NonNull ErtcLocation pantepicLocation,
        @NonNull LocationProvider locationProvider) {
      this.pantepicLocation = pantepicLocation;
      params = Build.VERSION.SDK_INT < Build.VERSION_CODES.O ? LocationParams.BELOW_OREO : LocationParams.BEST_EFFORT ;
      oneFix = false;

      if (!MAPPING.containsKey(pantepicLocation.context)) {
        MAPPING.put(pantepicLocation.context, locationProvider);
      }
      provider = MAPPING.get(pantepicLocation.context);

      if (pantepicLocation.preInitialize) {
        provider.init(pantepicLocation.context);
      }
    }

    public LocationControl config(@NonNull LocationParams params) {
      this.params = params;
      return this;
    }

    public LocationControl oneFix() {
      this.oneFix = true;
      return this;
    }

    public LocationControl continuous() {
      this.oneFix = false;
      return this;
    }

    public LocationState state() {
      return LocationState.with(pantepicLocation.context);
    }

    @Nullable
    public Location getLastLocation() {
      return provider.getLastLocation();
    }

    public LocationControl get() {
      return this;
    }

    public void start(OnLocationUpdatedListener listener) {
      if (provider == null) {
        throw new RuntimeException("A provider must be initialized");
      }
      provider.start(listener, params, oneFix);
    }

    public void stop() {
      provider.stop();
    }
  }
}
