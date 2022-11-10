package com.ripbull.ertc.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import com.ripbull.ertc.MainActivity;

public class NotificationItem {

  private final long                        id;
  private final long                        threadId;
  private final @Nullable CharSequence      text;
  private final long                        timestamp;

  public NotificationItem(long id,
      long threadId, @Nullable CharSequence text, long timestamp)
  {
    this.id                    = id;
    this.text                  = text;
    this.threadId              = threadId;
    this.timestamp             = timestamp;
  }


  public CharSequence getText() {
    return text;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public long getThreadId() {
    return threadId;
  }


  public PendingIntent getPendingIntent(Context context) {
    Intent     intent           = new Intent(context, MainActivity.class);
    //Recipient  notifyRecipients = threadRecipient != null ? threadRecipient : conversationRecipient;
    //if (notifyRecipients != null) intent.putExtra(ConversationActivity.ADDRESS_EXTRA, notifyRecipients.getAddress());
    intent.putExtra("thread_id", threadId);
    intent.setData((Uri.parse("custom://"+System.currentTimeMillis())));

    return TaskStackBuilder.create(context)
                           .addNextIntentWithParentStack(intent)
                           .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
  }

  public long getId() {
    return id;
  }

  public boolean isMms() {
    return false;
  }
}
