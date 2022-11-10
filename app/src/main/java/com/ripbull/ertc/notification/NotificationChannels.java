package com.ripbull.ertc.notification;

import android.annotation.TargetApi;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import java.util.Collections;

/**
 * Created by DK on 25/01/19.
 */
public class NotificationChannels {

  private static final String CATEGORY_MESSAGES = "messages";
  private static final String MESSAGES_PREFIX   = "messages_";

  private static final int VERSION = 1;

  public static void create(@NonNull
      Context context) {
    if (!supported()) {
      return;
    }

    NotificationManager notificationManager = getNotificationManager(context);

    onCreate(context, notificationManager);
  }

  @TargetApi(26)
  private static void onCreate(@NonNull Context context, @NonNull NotificationManager notificationManager) {
    NotificationChannelGroup
        messagesGroup = new NotificationChannelGroup(CATEGORY_MESSAGES, "Messages");
    notificationManager.createNotificationChannelGroup(messagesGroup);

    android.app.NotificationChannel
        messages     = new android.app.NotificationChannel(getMessagesChannel(context), "Default", NotificationManager.IMPORTANCE_HIGH);

    messages.setGroup(CATEGORY_MESSAGES);
    messages.enableVibration(false);
    messages.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, getRingtoneAudioAttributes());
    setLedPreference(messages, "blue");


    notificationManager.createNotificationChannels(Collections.singletonList(messages));

  }

  @TargetApi(26)
  private static void setLedPreference(@NonNull
      android.app.NotificationChannel channel, @NonNull String ledColor) {
    if ("none".equals(ledColor)) {
      channel.enableLights(false);
    } else {
      channel.enableLights(true);
      channel.setLightColor(Color.parseColor(ledColor));
    }
  }


  public static @NonNull
  Uri getMessageRingtone(@NonNull Context context) {
    if (!supported()) {
      return Uri.EMPTY;
    }

    Uri sound = getNotificationManager(context).getNotificationChannel(getMessagesChannel(context)).getSound();
    return sound == null ? Uri.EMPTY : sound;
  }


  @TargetApi(26)
  private static @NonNull NotificationManager getNotificationManager(@NonNull Context context) {
    NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
    assert  notificationManager != null;
    return notificationManager;
  }

  public static boolean supported() {
    return Build.VERSION.SDK_INT >= 26;
  }

  public static @NonNull String getMessagesChannel(@NonNull Context context) {
    return getMessagesChannelId(VERSION);
  }
  private static String getMessagesChannelId(int version) {
    return MESSAGES_PREFIX + version;
  }

  @TargetApi(21)
  private static AudioAttributes getRingtoneAudioAttributes() {
    return new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
        .setUsage(AudioAttributes.USAGE_NOTIFICATION_COMMUNICATION_INSTANT)
        .build();
  }
}
