package com.ripbull.ertc.notification;

import android.app.Notification;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.Settings;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

/**
 * Created by DK on 25/01/19.
 */
public abstract class AbstractNotificationBuilder extends NotificationCompat.Builder {
  public AbstractNotificationBuilder(
      @NonNull
          Context context,
      @NonNull
          String channelId) {
    super(context, channelId);
  }

  private static final String TAG = AbstractNotificationBuilder.class.getSimpleName();

  protected Context                       context;

  public AbstractNotificationBuilder(Context context) {
    super(context);

    this.context = context;
    setChannelId(NotificationChannels.getMessagesChannel(context));
    setLed();
  }

  protected CharSequence getStyledMessage(@NonNull String name, @Nullable
      CharSequence message) {
    SpannableStringBuilder builder = new SpannableStringBuilder();
    builder.append(getBoldedString(name));
    builder.append(": ");
    builder.append(message == null ? "" : message);

    return builder;
  }

  public void setAlarms(
      @Nullable
          Uri ringtone) {
    Uri     defaultRingtone = NotificationChannels.supported() ? NotificationChannels.getMessageRingtone(context) :  Settings.System.DEFAULT_NOTIFICATION_URI;
    if      (ringtone == null && !TextUtils.isEmpty(defaultRingtone.toString())) setSound(defaultRingtone);
    else if (ringtone != null && !ringtone.toString().isEmpty())                 setSound(ringtone);

    setDefaults(Notification.DEFAULT_VIBRATE);
  }

  private void setLed() {
    String ledColor              = "blue";
    String ledBlinkPattern       = "500,2000";
    String ledBlinkPatternCustom = "500,2000";

    if (!ledColor.equals("none")) {
      String[] blinkPatternArray = parseBlinkPattern(ledBlinkPattern, ledBlinkPatternCustom);

      setLights(Color.parseColor(ledColor),
          Integer.parseInt(blinkPatternArray[0]),
          Integer.parseInt(blinkPatternArray[1]));
    }
  }

  public void setTicker(@NonNull String name, @Nullable CharSequence message) {
    setTicker(getStyledMessage(name, message));
  }

  private String[] parseBlinkPattern(String blinkPattern, String blinkPatternCustom) {
    if (blinkPattern.equals("custom"))
      blinkPattern = blinkPatternCustom;

    return blinkPattern.split(",");
  }

  public static CharSequence getBoldedString(String value) {
    SpannableString spanned = new SpannableString(value);
    spanned.setSpan(new StyleSpan(Typeface.BOLD), 0,
        spanned.length(),
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    return spanned;
  }

}
