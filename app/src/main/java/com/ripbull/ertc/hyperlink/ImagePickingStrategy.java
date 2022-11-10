package com.ripbull.ertc.hyperlink;

import android.os.AsyncTask;
import java.util.HashMap;
import java.util.List;
import org.jsoup.nodes.Document;

/**
 * A strategy for how to select the images to return.
 */
public interface ImagePickingStrategy {

  void setImageQuantity(int imageQuantity);

  int getImageQuantity();

  List<String> getImages(AsyncTask asyncTask, Document doc, HashMap<String, String> metaTags);
}
