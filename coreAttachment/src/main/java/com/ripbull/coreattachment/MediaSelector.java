package com.ripbull.coreattachment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaSelector {

  private static final int TAKE_PHOTO = 100;
  private static final int CHOOSE_PHOTO = 101;
  private static final int TAKE_VIDEO = 102;
  private static final int CHOOSE_VIDEO = 103;
  private static final int CHOOSE_FILE = 104;
  protected String pictureFilePath;

  public void startTakePhotoActivity(Activity activity, File pictureFile) {
    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (cameraIntent.resolveActivity(activity.getPackageManager()) != null && pictureFile != null) {

      try {
        Uri photoURI =
            FileProvider.getUriForFile(
                activity, activity.getPackageName() + ".provider", pictureFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        activity.startActivityForResult(cameraIntent, TAKE_PHOTO);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void startTakeVideoActivity(Activity activity) {
    Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
    if (takeVideoIntent.resolveActivity(activity.getPackageManager()) != null) {
      activity.startActivityForResult(takeVideoIntent, TAKE_VIDEO);
    }
  }

  public void startChooseVideoActivity(Activity activity) {
    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    activity.startActivityForResult(intent, CHOOSE_VIDEO);
  }

  public void startChooseImageActivity(Activity activity) {
    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    activity.startActivityForResult(intent, CHOOSE_PHOTO);
  }

  public File getPictureFile(Activity activity) {
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String pictureFile = "IMG_" + timeStamp;
    File storageDir = activity.getCacheDir();
        //new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "Camera");
    File image = null;
    try {
      image = File.createTempFile(pictureFile, ".jpg", storageDir);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    pictureFilePath = image.getAbsolutePath();
    return image;
  }

  public void startChooseFileActivity(Activity activity) {
    final Intent intent = new Intent();
    intent.setType("application/*");
    intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
    try {
      activity.startActivityForResult(intent, CHOOSE_FILE);
      return;
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    intent.setAction(Intent.ACTION_GET_CONTENT);

    try {
      activity.startActivityForResult(intent, CHOOSE_FILE);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
