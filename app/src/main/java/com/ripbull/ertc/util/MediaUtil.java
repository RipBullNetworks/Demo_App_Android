package com.ripbull.ertc.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;

import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.FileProvider;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.ripbull.coresdk.chat.mapper.EmailContactRecord;
import com.ripbull.coresdk.chat.mapper.PhoneContactRecord;
import com.ripbull.ertc.R;
import com.ripbull.ertc.attachment.AttachmentManager;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/** Created by DK on 10/02/19. */
public class MediaUtil {
  public static final String IMAGE_PNG = "image/png";
  public static final String IMAGE_JPEG = "image/jpeg";
  public static final String IMAGE_GIF = "image/gif";

  public static @Nullable String getMimeType(Context context, Uri uri) {
    if (uri == null) return null;

    String type = context.getContentResolver().getType(uri);
    if (type == null) {
      final String extension = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
      type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
    }

    return getCorrectedMimeType(type);
  }

  public static @Nullable String getCorrectedMimeType(@Nullable String mimeType) {
    if (mimeType == null) return null;

    switch (mimeType) {
      case "image/jpg":
        return MimeTypeMap.getSingleton().hasMimeType(IMAGE_JPEG) ? IMAGE_JPEG : mimeType;
      default:
        return mimeType;
    }
  }

  public static boolean isGif(String contentType) {
    return !TextUtils.isEmpty(contentType) && contentType.trim().equals("image/gif");
  }

  public static boolean isVideo(String contentType) {
    return !TextUtils.isEmpty(contentType) && contentType.trim().startsWith("video/");
  }

  public static void openVideo(Context context, String path, String userId) {
    /*Intent intent = new Intent(context, VideoPlayerActivity.class);
    intent.putExtra("path", path);
    intent.putExtra("user", userId);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);*/

    final File videoFile = new File(path);
    Uri fileUri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", videoFile);
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(fileUri, "video/*");
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//DO NOT FORGET THIS EVER
    context.startActivity(intent);
  }

  // url = file path or whatever suitable URL you want.
  public static String getMimeType(String url) {
    String type = null;
    String extension = MimeTypeMap.getFileExtensionFromUrl(url);
    if (extension != null) {
      type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase());
    }
    return type;
  }

  public static boolean isValidImageExt(String url) {
    if (url != null) {
      String mimeType = getMimeType(url);
      if (!TextUtils.isEmpty(mimeType)) {
        return (mimeType.contains("jpeg") || mimeType.contains("png") || mimeType.contains("jpg"));
      } else if (url.lastIndexOf('.') != -1) {
        mimeType = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
        return (mimeType.equals("jpeg")
            || mimeType.equals("png")
            || mimeType.equals("jpg"));
      }
    }
    return false;
  }

  public static boolean isValidGifExt(String url) {
    if (url != null) {
      String mimeType = getMimeType(url);
      if (!TextUtils.isEmpty(mimeType)) {
        return (mimeType.contains("gif"));
      } else if (url.lastIndexOf('.') != -1) {
        mimeType = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
        return (mimeType.equals("gif"));
      }
    }
    return false;
  }

  public static boolean isValidVideoExt(String url) {
    if (url != null) {
      String mimeType = getMimeType(url);
      if (!TextUtils.isEmpty(mimeType)) {
        return (mimeType.contains("mp4") || mimeType.contains("3gp"));
      } else if (url.lastIndexOf('.') != -1) {
        mimeType = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
        return (mimeType.equals("mp4") || mimeType.equals("3gp"));
      }
    }
    return false;
  }

  public static boolean isValidAudioExt(String url) {
    if (url != null) {
      String mimeType = getMimeType(url);
      if (!TextUtils.isEmpty(mimeType)){
        return (mimeType.contains("mp3")
            || mimeType.contains("wav")
            || mimeType.contains("m4a")
            || mimeType.contains("aac")
            || mimeType.contains("mpeg")
            || mimeType.contains("ogg"));
      } else if (url.lastIndexOf('.') != -1) {
        mimeType = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
        return (mimeType.equals("mp3")
            || mimeType.equals("wav")
            || mimeType.equals("m4a")
            || mimeType.equals("aac")
            || mimeType.contains("mpeg")
            || mimeType.equals("ogg"));
      }
    }
    return false;
  }

  public static boolean isValidDocExt(String url) {
    if (url != null) {
      String mimeType = getMimeType(url);
      if (!TextUtils.isEmpty(mimeType)) {
        return (mimeType.contains("pdf")
            || mimeType.contains("doc")
            || mimeType.contains("docx")
            || mimeType.contains("txt")
            || mimeType.contains("xlsx"));
      } else if (url.lastIndexOf('.') != -1) {
        mimeType = url.substring(url.lastIndexOf('.') + 1).toLowerCase();
        return (mimeType.equals("pdf")
            || mimeType.equals("doc")
            || mimeType.equals("docx")
            || mimeType.equals("txt")
            || mimeType.equals("xlsx"));
      }
    }
    return false;
  }

  // Get Media duration in case of Audio and Video
  public static String getMediaDuration(Context context, String filePath) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    // use one of overloaded setDataSource() functions to set your data source
    retriever.setDataSource(context, Uri.fromFile(new File(filePath)));
    String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

    retriever.release();
    return formatMilliSecond(Long.parseLong(time));
  }

  /** Function to convert milliseconds time to Timer Format Hours:Minutes:Seconds */
  public static String formatMilliSecond(long milliseconds) {
    String finalTimerString = "";
    String secondsString = "";

    // Convert total duration into time
    int hours = (int) (milliseconds / (1000 * 60 * 60));
    int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
    int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

    // Add hours if there
    if (hours > 0) {
      finalTimerString = hours + ":";
    }

    // Prepending 0 to seconds if it is one digit
    if (seconds < 10) {
      secondsString = "0" + seconds;
    } else {
      secondsString = "" + seconds;
    }

    finalTimerString = finalTimerString + minutes + ":" + secondsString;

    return finalTimerString;
  }

  // Load image in Chat screen using local filepath(Image)
  public static void loadChatImage(Context context, String path, AppCompatImageView imageView) {

    RequestOptions requestOptions = new RequestOptions();
    // requestOptions.placeholder(R.drawable.ic_splash_app_blue);
    // requestOptions.error(R.drawable.ic_splash_app_blue);
    requestOptions.centerCrop();

    if (TextUtils.isEmpty(path)) {
      /*Glide.with(eRTCApplication.Companion.applicationContext())
      .load(R.drawable.ic_splash_app_blue)
      .apply(requestOptions)
      .into(imageView);*/
    } else {
      if(URLUtil.isValidUrl(path)) {
          Glide.with(context).load(path).apply(requestOptions).into(imageView);
      } else {
        File file = new File(path);
        Glide.with(context).load(file).apply(requestOptions).into(imageView);
      }
    }
  }

  // Load thumbnail image in Chat screen using local filepath(Video)
  public static RequestBuilder<Drawable> loadVideoThumbnail(Context context, String path) {
    RequestOptions requestOptions = new RequestOptions();
    // requestOptions.placeholder(R.drawable.ic_video_file);
    // requestOptions.error(R.drawable.ic_video_file);
    requestOptions.centerCrop();

    return Glide.with(context).load(Uri.fromFile(new File(path))).apply(requestOptions);
  }

  public static boolean fileExits(String path) {
    if (!TextUtils.isEmpty(path)) {
      File mFile = new File(path);
      if (mFile.exists()) {
        return true;
      } else {
        return mFile.isFile();
      }
    }
    return false;
  }

  public static String getImageName(String path) {
    if (path != null) {
      return path.substring(path.lastIndexOf("/") + 1);
    } else {
      return "";
    }
  }

  // inits all teh directories
  public static void createDirectories() {

    List<String> mDirList = new ArrayList<>();

    mDirList.add(AppConstants.DIR_PROFILE_PIC);
    mDirList.add(AppConstants.DIR_DB);
    mDirList.add(AppConstants.DIR_BACKUP);
    mDirList.add(AppConstants.DIR_MEDIA);

    List<String> mChildDir = new ArrayList<>();

    mChildDir.add(AppConstants.DIR_MEDIA_IMAGES);
    mChildDir.add(AppConstants.DIR_MEDIA_VIDEOS);
    mChildDir.add(AppConstants.DIR_MEDIA_AUDIOS);
    mChildDir.add(AppConstants.DIR_MEDIA_DOCUMENTS);
    mChildDir.add(AppConstants.DIR_MEDIA_GIF);

    File mDirectory =
        new File(android.os.Environment.getExternalStorageDirectory(), AppConstants.DIR_ROOT);
    if (!mDirectory.exists()) {
      mDirectory.mkdirs();
    }

    for (String mSubDirName : mDirList) {
      File mSubDirectory =
          new File(
              android.os.Environment.getExternalStorageDirectory()
                  + AppConstants.DIR_SEPARATOR
                  + AppConstants.DIR_ROOT
                  + AppConstants.DIR_SEPARATOR
                  + mSubDirName);
      if (!mSubDirectory.exists()) {
        mSubDirectory.mkdirs();
      }
    }

    for (String mSubDirName : mChildDir) {

      File mSubChild =
          new File(
              android.os.Environment.getExternalStorageDirectory()
                  + AppConstants.DIR_MEDIA_PATH
                  + mSubDirName);
      if (!mSubChild.exists()) {
        mSubChild.mkdir();
      }
    }

    for (String mSubDirName : mChildDir) {

      File mSubChild =
          new File(
              android.os.Environment.getExternalStorageDirectory()
                  + AppConstants.DIR_MEDIA_PATH
                  + mSubDirName
                  + AppConstants.DIR_SEPARATOR
                  + AppConstants.DIR_SENT);
      if (!mSubChild.exists()) {
        mSubChild.mkdir();
      }
    }
  }

  public static void deleteAppImagesCachePath() {

    deleteDirectory(
        new File(Environment.getExternalStorageDirectory() + AppConstants.DIR_CACHE_PIC));
    deleteDirectory(
        new File(Environment.getExternalStorageDirectory() + AppConstants.DIR_CACHE_VID));
  }

  public static boolean deleteDirectory(File path) {
    if (path.exists()) {
      File[] files = path.listFiles();
      if (files == null) {
        return true;
      }
      for (File file : files) {
        if (file.isDirectory()) {
          deleteDirectory(file);
        } else {
          file.delete();
        }
      }
    }
    return (path.delete());
  }

  // gives media paths
  public static String getImagesPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_IMAGES;
  }

  public static String getImagesSentPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_IMAGES
        + AppConstants.DIR_SEPARATOR
        + AppConstants.DIR_SENT;
  }

  public static String getVideosPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_VIDEOS;
  }

  public static String getVideosSentPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_VIDEOS
        + AppConstants.DIR_SEPARATOR
        + AppConstants.DIR_SENT;
  }

  public static String getAudiosPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_AUDIOS;
  }

  public static String getAudiosSentPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_AUDIOS
        + AppConstants.DIR_SEPARATOR
        + AppConstants.DIR_SENT;
  }

  public static String getDocumentSentPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_DOCUMENTS
        + AppConstants.DIR_SEPARATOR
        + AppConstants.DIR_SENT;
  }

  public static String getGifSentPath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_MEDIA_PATH
        + AppConstants.DIR_MEDIA_GIF
        + AppConstants.DIR_SEPARATOR
        + AppConstants.DIR_SENT;
  }

  public static String moveToSentFolder(File file, AttachmentManager.MediaType mediaType) {
    String sentPath = "";
    if (mediaType == AttachmentManager.MediaType.IMAGE) {
      sentPath = getImagesSentPath();
    } else if (mediaType == AttachmentManager.MediaType.VIDEO) {
      sentPath = getVideosSentPath();
    } else if (mediaType == AttachmentManager.MediaType.AUDIO) {
      sentPath = getAudiosSentPath();
    } else if (mediaType == AttachmentManager.MediaType.FILE) {
      sentPath = getDocumentSentPath();
    } else if (mediaType == AttachmentManager.MediaType.GIF) {
      sentPath = getGifSentPath();
    }

    File dir = new File(sentPath);
    if (!dir.exists()) {
      createDirectories();
    }

    String fileName = file.getName();
    String timeStamp = new Date().getTime() + "_";
    boolean isCopied = copyFile(file, new File(sentPath + "/" + timeStamp + fileName));

    if (isCopied) {
      return sentPath + "/" + timeStamp + fileName;
    } else {
      return "";
    }
  }

  public static String moveVideoToSentFolder(File file) {
    String sentPath = getVideosSentPath();

    File dir = new File(sentPath);
    if (!dir.exists()) {
      createDirectories();
    }

    String fileName = file.getName();
    String timeStamp = new Date().getTime() + "_";
    boolean isCopied = copyFile(file, new File(sentPath + "/" + timeStamp + fileName));

    if (isCopied) {
      file.delete();
      return sentPath + "/" + timeStamp + fileName;
    } else {
      return "";
    }
  }

  private static boolean copyFile(File srcFile, File destFile) {

    try {

      FileInputStream in = new FileInputStream(srcFile);
      FileOutputStream out = new FileOutputStream(destFile);

      byte[] buffer = new byte[1024];
      int read;
      while ((read = in.read(buffer)) != -1) {
        out.write(buffer, 0, read);
      }
      in.close();
      in = null;

      // write the output file (You have now copied the file)
      out.flush();
      out.close();
      out = null;
      return true;
    } catch (FileNotFoundException fileNotFound) {
    } catch (Exception e) {
    }
    return false;
  }

  // Load thumbnail image in Chat screen using thumbnail url
  public static RequestBuilder<Drawable> loadIncomingVideoThumbnail(Context context, String url) {
    RequestOptions requestOptions = new RequestOptions();
    requestOptions.centerCrop();

    if (!TextUtils.isEmpty(url)) {
      return Glide.with(context).load(url).apply(requestOptions);
    }
    return null;
  }

  // Load Incoming image in Chat screen using url
  public static void loadIncomingChatImage(
      Context context, String url, AppCompatImageView imageView) {

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.centerCrop();

    if (!TextUtils.isEmpty(url)) {
      Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }
  }

  // Load outgoing gif in Chat screen using url
  public static void loadGIF(
      Context context, String url, AppCompatImageView imageView, ProgressBar progressBar, AppCompatImageView ivPlayGif) {

    progressBar.setVisibility(View.VISIBLE);

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.centerCrop();

    if (!TextUtils.isEmpty(url)) {
      Glide.with(context).load(url).apply(requestOptions).listener(new RequestListener<Drawable>() {
        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model,
            Target<Drawable> target, boolean isFirstResource) {
          progressBar.setVisibility(View.GONE);
          ivPlayGif.setVisibility(View.VISIBLE);
          return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target,
            DataSource dataSource, boolean isFirstResource) {
          progressBar.setVisibility(View.GONE);
          ivPlayGif.setVisibility(View.VISIBLE);
          return false;
        }
      }).into(imageView);
    }
  }

  // Get Incoming Media duration in case of Audio and Video
  public static String getIncomingMediaDuration(Context context, String mediaPath) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    // use one of overloaded setDataSource() functions to set your data source
    retriever.setDataSource(mediaPath, new HashMap<String, String>());
    String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

    retriever.release();
    return formatMilliSecond(Long.parseLong(time));
  }

  // Get Incoming Media duration in seconds  in case of Audio and Video
  public static int getIncomingMediaDurationSeconds(Context context, String mediaPath) {
    MediaMetadataRetriever retriever = new MediaMetadataRetriever();
    // use one of overloaded setDataSource() functions to set your data source
    retriever.setDataSource(mediaPath, new HashMap<String, String>());
    String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);

    retriever.release();
    return Integer.parseInt(time);
  }

  public static String getMapUrl(Context context, String latitude, String longitude) {
    String mMap = "";
    String apiKey = context.getString(R.string.google_api_key);
    mMap =
        "https://maps.googleapis.com/maps/api/staticmap?zoom=17&size=420x350&maptype=roadmap&markers=color:blue%7C"
            + latitude
            + ","
            + longitude
            + "%20&key="
            + apiKey;
    return mMap;
  }

  // Load Incoming image in Chat screen using url
  public static void loadGoogleMapImage(Context context, String url, AppCompatImageView imageView) {

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.centerCrop();

    if (!TextUtils.isEmpty(url)) {
      Glide.with(context).load(Uri.parse(Uri.decode(url))).apply(requestOptions).into(imageView);
    }
  }

  public static ArrayList<PhoneContactRecord> getPhoneNumbers(
      Cursor cursor, ContentResolver contentResolver, String id) {
    ArrayList<PhoneContactRecord> phoneRecords = new ArrayList<>();

    String phoneNumber =
        (cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
    if (phoneNumber.equalsIgnoreCase("1")) {
      Cursor cursorPhone =
          contentResolver.query(
              ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
              null,
              ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
              new String[] {id},
              null);
      while (cursorPhone.moveToNext()) {
        String phoneNumValue =
            cursorPhone.getString(
                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        Integer phoneType =
            cursorPhone.getInt(
                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
        String strType = "";

        switch (phoneType) {
          case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
            strType = "Home";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
            strType = "Mobile";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
            strType = "Work";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_HOME:
            strType = "Home Fax";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK:
            strType = "Work Fax";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_MAIN:
            strType = "Main";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER:
            strType = "Other";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_CUSTOM:
            strType = "Custom";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_PAGER:
            strType = "Pager";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_ASSISTANT:
            strType = "Assistant";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_CALLBACK:
            strType = "Callback";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_CAR:
            strType = "Car";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_COMPANY_MAIN:
            strType = "Company Main";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_ISDN:
            strType = "ISDN";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_MMS:
            strType = "MMS";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER_FAX:
            strType = "Other Fax";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_RADIO:
            strType = "Radio";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_TELEX:
            strType = "Telex";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_TTY_TDD:
            strType = "TTY TDD";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE:
            strType = "Work Mobile";
            break;
          case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_PAGER:
            strType = "Work Pager";
            break;
        }
        phoneRecords.add(new PhoneContactRecord(strType, phoneNumValue));
      }
      cursorPhone.close();
    }

    return phoneRecords;
  }

  public static ArrayList<EmailContactRecord> getEmails(
      ContentResolver contentResolver, String id) {
    ArrayList<EmailContactRecord> emailRecords = new ArrayList<>();

    Cursor cursorEmail =
        contentResolver.query(
            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
            null,
            ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=?",
            new String[] {id},
            null);

    while (cursorEmail.moveToNext()) {
      String emailValue =
          cursorEmail.getString(
              cursorEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
      Integer emailType =
          cursorEmail.getInt(
              cursorEmail.getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE));
      String strType = "";

      switch (emailType) {
        case ContactsContract.CommonDataKinds.Email.TYPE_HOME:
          strType = "Home";
          break;
        case ContactsContract.CommonDataKinds.Email.TYPE_MOBILE:
          strType = "Mobile";
          break;
        case ContactsContract.CommonDataKinds.Email.TYPE_WORK:
          strType = "Work";
          break;
        case ContactsContract.CommonDataKinds.Email.TYPE_OTHER:
          strType = "Other";
          break;
        case ContactsContract.CommonDataKinds.Email.TYPE_CUSTOM:
          strType = "Custom";
          break;
      }
      emailRecords.add(new EmailContactRecord(strType, emailValue));
    }
    cursorEmail.close();

    return emailRecords;
  }

  public static void openContact(
      Context context,
      String name,
      List<PhoneContactRecord> phoneRecord,
      List<EmailContactRecord> emailRecord) {
    Intent intent = new Intent(Intent.ACTION_INSERT);
    intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
    intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
    ArrayList<ContentValues> data = new ArrayList<>();

    if (phoneRecord != null) {
      for (int i = 0; i < phoneRecord.size(); i++) {
        PhoneContactRecord phoneContactRecord = phoneRecord.get(i);
        ContentValues row = new ContentValues();
        row.put(
            ContactsContract.Data.MIMETYPE,
            ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);

        Integer type = 0;
        switch (phoneContactRecord.getType()) {
          case "Home":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_HOME;
            break;
          case "Mobile":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE;
            break;
          case "Work":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_WORK;
            break;
          case "Home Fax":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_FAX_HOME;
            break;
          case "Work Fax":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK;
            break;
          case "Main":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_MAIN;
            break;
          case "Other":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_OTHER;
            break;
          case "Custom":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_CUSTOM;
            break;
          case "Pager":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_PAGER;
            break;
          case "Assistant":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_ASSISTANT;
            break;
          case "Callback":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_CALLBACK;
            break;
          case "Car":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_CAR;
            break;
          case "Company Main":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_COMPANY_MAIN;
            break;
          case "ISDN":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_ISDN;
            break;
          case "MMS":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_MMS;
            break;
          case "Other Fax":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_OTHER_FAX;
            break;
          case "Radio":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_RADIO;
            break;
          case "Telex":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_TELEX;
            break;
          case "TTY TDD":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_TTY_TDD;
            break;
          case "Work Mobile":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE;
            break;
          case "Work Pager":
            type = ContactsContract.CommonDataKinds.Phone.TYPE_WORK_PAGER;
            break;
        }

        row.put(ContactsContract.CommonDataKinds.Phone.TYPE, type);
        row.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phoneContactRecord.getNumber());
        data.add(row);
      }
    }

    if (emailRecord != null) {
      for (int i = 0; i < emailRecord.size(); i++) {
        EmailContactRecord emailContactRecord = emailRecord.get(i);
        ContentValues row = new ContentValues();
        row.put(
            ContactsContract.Data.MIMETYPE,
            ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE);

        Integer type = 0;
        switch (emailContactRecord.getType()) {
          case "Home":
            type = ContactsContract.CommonDataKinds.Email.TYPE_HOME;
            break;
          case "Mobile":
            type = ContactsContract.CommonDataKinds.Email.TYPE_MOBILE;
            break;
          case "Work":
            type = ContactsContract.CommonDataKinds.Email.TYPE_WORK;
            break;
          case "Other":
            type = ContactsContract.CommonDataKinds.Email.TYPE_OTHER;
            break;
          case "Custom":
            type = ContactsContract.CommonDataKinds.Email.TYPE_CUSTOM;
            break;
        }
        row.put(ContactsContract.CommonDataKinds.Email.TYPE, type);
        row.put(ContactsContract.CommonDataKinds.Email.ADDRESS, emailContactRecord.getEmail());
        data.add(row);
      }
    }

    intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, data);
    context.startActivity(intent);
  }

  public static void openLocation(Context context, String latitude, String longitude) {
    String geoUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude;
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
    context.startActivity(intent);
  }

  public static String getProfilePicturePath() {
    return Environment.getExternalStorageDirectory()
        + AppConstants.DIR_PROFILE_PIC_PATH;
  }

  public static String moveToProfilePictureFolder(File file) {
    String profilePicturePath = getProfilePicturePath();

    File dir = new File(profilePicturePath);
    if (!dir.exists()) {
      createDirectories();
    }

    String fileName = file.getName();
    String timeStamp = new Date().getTime() + "_";
    boolean isCopied = copyFile(file, new File(profilePicturePath + "/" + timeStamp + fileName));

    if (isCopied) {
      return profilePicturePath + "/" + timeStamp + fileName;
    } else {
      return "";
    }
  }

  public static String getFileName(String filePath) {
    String fileName = filePath.substring(filePath.lastIndexOf('/') + 1);
    if (fileName.length() > 30){
      fileName = fileName.substring(fileName.length()-30, fileName.length());
    }
    return fileName;
  }

  public static void openSendDocument(Context context, String filePath) {
    if(URLUtil.isValidUrl(filePath)) {
      openReceivedDocument(context, filePath);
    } else {
      Uri docURI =
        FileProvider.getUriForFile(
          context, context.getPackageName() + ".provider", new File(filePath));
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, docURI);
      browserIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      context.startActivity(browserIntent);
    }
  }

  public static void openReceivedDocument(Context context, String url) {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    context.startActivity(browserIntent);
  }

  public static String uriDecoder(CharSequence serverResponse) {
    String data = StringEscapeUtils.unescapeHtml(serverResponse.toString());
    return StringEscapeUtils.unescapeXml(data);
  }

  public static CharSequence uriEncode(CharSequence toServer) {
    return StringEscapeUtils.escapeXml(toServer.toString());
  }

  // Load gif for giphy
  public static void loadIGif(Context context, String url, AppCompatImageView imageView) {

    RequestOptions requestOptions = new RequestOptions();
    requestOptions.centerCrop();

    if (!TextUtils.isEmpty(url)) {
      Glide.with(context)
          .asGif()
          .load(url).apply(requestOptions).into(imageView);
    }
  }

  public static void playVideo(Context context, String path) {
    final File videoFile = new File(path);
    Uri fileUri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", videoFile);
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(fileUri, "video/*");
    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//DO NOT FORGET THIS EVER
    context.startActivity(intent);
  }

  /**
   * compress Image for captured image
   * @param context
   * @param imageUri
   * @return
   */
  public static String compressImage(Context context, Uri imageUri) {

    String filePath = getRealPathFromURI(context, imageUri);
    Bitmap scaledBitmap = null;

    BitmapFactory.Options options = new BitmapFactory.Options();

    // by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If you try the use the bitmap here, you will get null.
    options.inJustDecodeBounds = true;
    Bitmap bmp = BitmapFactory.decodeFile(filePath, options);

    int actualHeight = options.outHeight;
    int actualWidth = options.outWidth;

    // max Height and width values of the compressed image is taken as 816x612

    float maxHeight = 816.0f;
    float maxWidth = 612.0f;
    float imgRatio = actualWidth / actualHeight;
    float maxRatio = maxWidth / maxHeight;

    // width and height values are set maintaining the aspect ratio of the image

    if (actualHeight > maxHeight || actualWidth > maxWidth) {
      if (imgRatio < maxRatio) {
        imgRatio = maxHeight / actualHeight;
        actualWidth = (int) (imgRatio * actualWidth);
        actualHeight = (int) maxHeight;
      } else if (imgRatio > maxRatio) {
        imgRatio = maxWidth / actualWidth;
        actualHeight = (int) (imgRatio * actualHeight);
        actualWidth = (int) maxWidth;
      } else {
        actualHeight = (int) maxHeight;
        actualWidth = (int) maxWidth;

      }
    }

    // setting inSampleSize value allows to load a scaled down version of the original image

    options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

    // inJustDecodeBounds set to false to load the actual bitmap
    options.inJustDecodeBounds = false;

    // this options allow android to claim the bitmap memory if it runs low on memory
    options.inPurgeable = true;
    options.inInputShareable = true;
    options.inTempStorage = new byte[16 * 1024];

    try {
      // load the bitmap from its path
      bmp = BitmapFactory.decodeFile(filePath, options);
    } catch (OutOfMemoryError exception) {
      exception.printStackTrace();
    }
    try {
      scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
    } catch (OutOfMemoryError exception) {
      exception.printStackTrace();
    }

    float ratioX = actualWidth / (float) options.outWidth;
    float ratioY = actualHeight / (float) options.outHeight;
    float middleX = actualWidth / 2.0f;
    float middleY = actualHeight / 2.0f;

    Matrix scaleMatrix = new Matrix();
    scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

    Canvas canvas = new Canvas(scaledBitmap);
    canvas.setMatrix(scaleMatrix);
    canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

    // check the rotation of the image and display it properly
    ExifInterface exif;
    try {
      exif = new ExifInterface(filePath);

      int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
      Matrix matrix = new Matrix();
      if (orientation == 6) {
        matrix.postRotate(90);
      } else if (orientation == 3) {
        matrix.postRotate(180);
      } else if (orientation == 8) {
        matrix.postRotate(270);
      }
      scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
          true);
    } catch (IOException e) {
      e.printStackTrace();
    }

    FileOutputStream out = null;
    String filename = getFilename();
    try {
      out = new FileOutputStream(filename);

      // write the compressed bitmap at the destination specified by filename.
      scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return filename;
  }

  private static String getFilename() {
    String profilePicturePath = getProfilePicturePath();
    File file = new File(profilePicturePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
    return uriSting;
  }

  private static String getRealPathFromURI(Context context, Uri contentUri) {
    Cursor cursor = context.getContentResolver().query(contentUri, null, null, null, null);
    if (cursor == null) {
      return contentUri.getPath();
    } else {
      cursor.moveToFirst();
      int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
      return cursor.getString(index);
    }
  }

  private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
    final int height = options.outHeight;
    final int width = options.outWidth;
    int inSampleSize = 1;

    if (height > reqHeight || width > reqWidth) {
      final int heightRatio = Math.round((float) height / (float) reqHeight);
      final int widthRatio = Math.round((float) width / (float) reqWidth);
      inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
    }
    final float totalPixels = width * height;
    final float totalReqPixelsCap = reqWidth * reqHeight * 2;
    while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
      inSampleSize++;
    }

    return inSampleSize;
  }

  // Load outgoing gif in media preview dialog using url
  public static void previewGIF(Context context, String url, AppCompatImageView imageView, ProgressBar progressBar) {

    progressBar.setVisibility(View.VISIBLE);

    RequestOptions requestOptions = new RequestOptions();

    if (!TextUtils.isEmpty(url)) {
      Glide.with(context).load(url).apply(requestOptions).listener(new RequestListener<Drawable>() {
        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model,
            Target<Drawable> target, boolean isFirstResource) {
          progressBar.setVisibility(View.GONE);
          return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target,
            DataSource dataSource, boolean isFirstResource) {
          progressBar.setVisibility(View.GONE);
          return false;
        }
      }).into(imageView);
    }
  }

  public static String getIMGSize(Uri uri){
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(new File(uri.getPath()).getAbsolutePath(), options);
    int imageHeight = options.outHeight;
    int imageWidth = options.outWidth;

    return ("" + imageWidth + " * " + imageHeight);
  }

  public static boolean isOnline(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    return netInfo != null && netInfo.isConnectedOrConnecting();
  }
}