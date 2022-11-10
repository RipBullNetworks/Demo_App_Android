package com.ripbull.coreattachment.giph;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class GiphyLoader extends AsyncLoader<Observable<List<Gif>>> {

  private static final String TAG = GiphyLoader.class.getSimpleName();
  private final CompositeDisposable compositeDisposable = new CompositeDisposable();
  public static int PAGE_SIZE = 100;

  @Nullable private String searchString;

  private final OkHttpClient client;

  protected GiphyLoader(@NonNull Context context, @Nullable String searchString) {
    super(context);
    this.searchString = searchString;
    this.client = new OkHttpClient.Builder().build();
  }

  @Override
  public Observable<List<Gif>> loadInBackground() {
    return loadGifsInBackground();
  }

  @Nullable
  private static String getStringFromStream(@NonNull final InputStream inputStream)
      throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
    StringBuilder total = new StringBuilder();
    String line;
    while ((line = r.readLine()) != null) total.append(line).append('\n');
    return total.toString();
  }

  public @NonNull Observable<List<Gif>> loadGifsInBackground() {
    return Observable.fromCallable(
        new Callable<List<Gif>>() {
          @Override
          public List<Gif> call() throws Exception {
            try {
              String url;

              if (TextUtils.isEmpty(searchString)) {
                url = String.format(getTrendingUrl(), 0);
              } else {
                url = String.format(getSearchUrl(), 0, Uri.encode(searchString));
              }
              Request request = new Request.Builder().url(url).build();
              Response response = client.newCall(request).execute();

              if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
              }
              String responseStr = getStringFromStream(response.body().byteStream());
              if (responseStr == null) return null;
              JSONArray data = new JSONObject(responseStr).getJSONArray("data");
              ArrayList<Gif> gifs = new ArrayList<>();
              for (int i = 0; i < data.length(); i++) {
                JSONObject images = data.getJSONObject(i).getJSONObject("images");
                Gif gif =
                    new Gif(
                        images.getJSONObject("original").getString("url"),
                        images.has("preview_gif")
                            ? images.getJSONObject("preview_gif").getString("url")
                            : null,
                        images.has("original_mp4")
                            ? images.getJSONObject("original_mp4").getString("mp4")
                            : null);
                gifs.add(gif);
              }
              return gifs;
            } catch (IOException e) {
              e.printStackTrace();
            } catch (JSONException e) {
              e.printStackTrace();
            }
            return null;
          }
        });
  }

  protected abstract String getTrendingUrl();

  protected abstract String getSearchUrl();
}
