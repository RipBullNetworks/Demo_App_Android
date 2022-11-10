package com.ripbull.ertc.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by DK on 14/02/19.
 */
@GlideModule
public class eRTCGlideModule extends AppGlideModule {
  @Override
  public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    super.applyOptions(context, builder);
  }

  @Override
  public boolean isManifestParsingEnabled() {
    return super.isManifestParsingEnabled();
  }
}
