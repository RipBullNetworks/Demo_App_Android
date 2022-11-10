package com.ripbull.ertc.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import com.bumptech.glide.Glide;
import com.ripbull.ertc.R;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleRecipientNotificationBuilder extends AbstractNotificationBuilder {

  private static final String TAG = SingleRecipientNotificationBuilder.class.getSimpleName();

  private final List<CharSequence> messageBodies = new LinkedList<>();

  private CharSequence contentTitle;
  private CharSequence contentText;

  public SingleRecipientNotificationBuilder(@NonNull Context context) {
    super(context);

    setSmallIcon(R.drawable.ic_launcher_foreground);
    setColor(context.getResources().getColor(R.color.colorPrimary));
    setCategory(NotificationCompat.CATEGORY_MESSAGE);

    //if (!NotificationChannels.supported()) {
    //  setPriority(TextSecurePreferences.getNotificationPriority(context));
    //}
  }

  public void setThread() {
    setChannelId("messages_1");

    setContentTitle("Dinesh Air");

    FallbackContactPhoto fallbackContactPhoto =
        new GeneratedContactPhoto("Dinesh Air", R.drawable.ic_person_default_24dp);

    setLargeIcon(fallbackContactPhoto.asDrawable(context,
        ContactColors.generateFor("Dinesh Air").toConversationColor(context)));
  }

  public void setMessageCount(int messageCount) {
    setContentInfo(String.valueOf(messageCount));
    setNumber(messageCount);
  }

  public void setPrimaryMessageBody(@NonNull CharSequence message) {
    SpannableStringBuilder stringBuilder = new SpannableStringBuilder();

    setContentText(stringBuilder.append(message));
  }

  public void addActions(@NonNull PendingIntent markReadIntent,
      @NonNull PendingIntent quickReplyIntent, @NonNull PendingIntent wearableReplyIntent) {
    NotificationCompat.Action markAsReadAction =
        new NotificationCompat.Action(R.drawable.ic_check_white_24dp,
            context.getString(R.string.message_notifier_mark_read), markReadIntent);

    NotificationCompat.Action replyAction =
        new NotificationCompat.Action(R.drawable.ic_reply_white_36dp,
            context.getString(R.string.message_notifier_reply), quickReplyIntent);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      replyAction = new NotificationCompat.Action.Builder(R.drawable.ic_reply_white_36dp,
          context.getString(R.string.message_notifier_reply), wearableReplyIntent).addRemoteInput(
          new RemoteInput.Builder("extra_remote_reply").setLabel(
              context.getString(R.string.message_notifier_reply)).build()).build();
    }

    addAction(markAsReadAction);
    addAction(replyAction);

  }

  public void addMessageBody(@Nullable CharSequence messageBody) {
    SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
    messageBodies.add(stringBuilder.append(messageBody == null ? "" : messageBody));
  }

  @Override
  public Notification build() {
    if (messageBodies.size() == 1 && hasBigPictureSlide()) {
      setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBigPicture())
          .setSummaryText(getBigText(messageBodies)));
    } else {
      setStyle(new NotificationCompat.BigTextStyle().bigText(getBigText(messageBodies)));
    }
    return super.build();
  }

  private void setLargeIcon(@Nullable Drawable drawable) {
    if (drawable != null) {
      int largeIconTargetSize =
          context.getResources().getDimensionPixelSize(R.dimen.contact_photo_target_size);
      Bitmap recipientPhotoBitmap =
          createFromDrawable(drawable, largeIconTargetSize, largeIconTargetSize);

      if (recipientPhotoBitmap != null) {
        setLargeIcon(recipientPhotoBitmap);
      }
    }
  }

  private boolean hasBigPictureSlide() {
    return false;
  }

  private Bitmap getBigPicture() {
    try {
      Uri uri = Uri.parse("content://com.ripbull.ertc/part/1548483252648/3");

      return Glide.with(context.getApplicationContext())
          .asBitmap()
          .load(new DecryptableStreamUriLoader.DecryptableUri(uri))
          .submit(500, 500)
          .get();
    } catch (InterruptedException | ExecutionException e) {
      Log.w(TAG, e);
      return Bitmap.createBitmap(500, 500, Bitmap.Config.RGB_565);
    }
  }

  @Override
  public NotificationCompat.Builder setContentTitle(CharSequence contentTitle) {
    this.contentTitle = contentTitle;
    return super.setContentTitle(contentTitle);
  }

  public NotificationCompat.Builder setContentText(CharSequence contentText) {
    this.contentText = contentText;
    return super.setContentText(contentText);
  }

  private CharSequence getBigText(List<CharSequence> messageBodies) {
    SpannableStringBuilder content = new SpannableStringBuilder();

    for (int i = 0; i < messageBodies.size(); i++) {
      content.append(messageBodies.get(i));
      if (i < messageBodies.size() - 1) {
        content.append('\n');
      }
    }

    return content;
  }

  public static Bitmap createFromDrawable(final Drawable drawable, final int width,
      final int height) {
    final AtomicBoolean created = new AtomicBoolean(false);
    final Bitmap[] result = new Bitmap[1];

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        if (drawable instanceof BitmapDrawable) {
          result[0] = ((BitmapDrawable) drawable).getBitmap();
        } else {
          int canvasWidth = drawable.getIntrinsicWidth();
          if (canvasWidth <= 0) canvasWidth = width;

          int canvasHeight = drawable.getIntrinsicHeight();
          if (canvasHeight <= 0) canvasHeight = height;

          Bitmap bitmap;

          try {
            bitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
          } catch (Exception e) {
            Log.w(TAG, e);
            bitmap = null;
          }
          result[0] = bitmap;
        }

        synchronized (result) {
          created.set(true);
          result.notifyAll();
        }
      }
    };

    runOnMain(runnable);

    synchronized (result) {
      while (!created.get()) wait(result, 0);
      return result[0];
    }
  }

  public static Handler handler = new Handler(Looper.getMainLooper());

  public static void runOnMain(final @NonNull Runnable runnable) {
    if (isMainThread()) {
      runnable.run();
    } else {
      handler.post(runnable);
    }
  }

  public static boolean isMainThread() {
    return Looper.myLooper() == Looper.getMainLooper();
  }

  public static void wait(Object lock, long timeout) {
    try {
      lock.wait(timeout);
    } catch (InterruptedException ie) {
      throw new AssertionError(ie);
    }
  }
}
