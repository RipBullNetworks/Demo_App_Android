package com.ripbull.coreattachment.giph;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GiphyGifLoader extends GiphyLoader {

  public GiphyGifLoader(@NonNull Context context, @Nullable String searchString) {
    super(context, searchString);
  }

  @Override
  protected String getTrendingUrl() {
    return
        "https://api.giphy.com/v1/gifs/trending?api_key=D2KJHQALCwvIGNYbTy002Elz0secgev4&offset=%d&limit="
            + PAGE_SIZE;
  }

  @Override
  protected String getSearchUrl() {
    return
        "https://api.giphy.com/v1/gifs/search?api_key=D2KJHQALCwvIGNYbTy002Elz0secgev4&offset=%d&limit="
            + PAGE_SIZE
            + "&q=%s";
  }
}
