package com.ripbull.ertc.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class DecryptableStreamLocalUriFetcher extends StreamLocalUriFetcher {

  private static final String TAG = DecryptableStreamLocalUriFetcher.class.getSimpleName();

  private Context context;

  DecryptableStreamLocalUriFetcher(Context context, Uri uri) {
    super(context.getContentResolver(), uri);
    this.context      = context;
  }

  @Override
  protected InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
    if (hasVideoThumbnail(uri)) {
      Bitmap thumbnail = getVideoThumbnail(context, uri);

      if (thumbnail != null) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return new ByteArrayInputStream(baos.toByteArray());
      }
    }

    try {
      return  context.getContentResolver().openInputStream(uri);
    } catch (IOException ioe) {
      Log.w(TAG, ioe);
      throw new FileNotFoundException("PartAuthority couldn't load Uri resource.");
    }
  }

  public static boolean hasVideoThumbnail(Uri uri) {
    Log.i(TAG, "Checking: " + uri);

    if (uri == null || !ContentResolver.SCHEME_CONTENT.equals(uri.getScheme())) {
      return false;
    }

    if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
      return uri.getLastPathSegment().contains("video");
    }

    return false;
  }

  public static @Nullable
  Bitmap getVideoThumbnail(Context context, Uri uri) {
    if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
      long videoId = Long.parseLong(uri.getLastPathSegment().split(":")[1]);

      return MediaStore.Video.Thumbnails.getThumbnail(context.getContentResolver(),
          videoId,
          MediaStore.Images.Thumbnails.MINI_KIND,
          null);
    }

    return null;
  }
}
