package com.ripbull.ertc.notification;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by DK on 26/01/19.
 */
public class MessageNotifier {

  private static final  int   SUMMARY_NOTIFICATION_ID   = 1111;
  private static final String NOTIFICATION_GROUP        = "messages";

  private static NotificationState constructNotificationState(@NonNull Context context)
  {
    NotificationState     notificationState = new NotificationState();

    notificationState.addNotification(new NotificationItem(1, 1, "Hello", System.currentTimeMillis()));
    notificationState.addNotification(new NotificationItem(2, 1, "I'm here", System.currentTimeMillis()));
    notificationState.addNotification(new NotificationItem(3,  1, "No", System.currentTimeMillis()));
    notificationState.addNotification(new NotificationItem(4,  1, "Let's meet tomorrow", System.currentTimeMillis()));

    return notificationState;
  }

  public static void updateNotification(@NonNull Context context, boolean signal){

    NotificationState notificationState = constructNotificationState(context);
    sendSingleThreadNotification(context, notificationState, signal, false);
  }
  private static void sendSingleThreadNotification(@NonNull  Context context,
      @NonNull  NotificationState notificationState,
      boolean signal, boolean bundled)
  {


    SingleRecipientNotificationBuilder builder        = new SingleRecipientNotificationBuilder(context);
    List<NotificationItem> notifications  = notificationState.getNotifications();
    int                                notificationId = (int) (SUMMARY_NOTIFICATION_ID + (bundled ? notifications.get(0).getThreadId() : 0));


    builder.setThread();
    builder.setMessageCount(notificationState.getMessageCount());
    builder.setPrimaryMessageBody(notifications.get(0).getText());
    builder.setContentIntent(notifications.get(0).getPendingIntent(context));
    builder.setGroup(NOTIFICATION_GROUP);
    builder.setDeleteIntent(notificationState.getDeleteIntent(context));
    builder.setOnlyAlertOnce(!signal);
    builder.setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_SUMMARY);

    long timestamp = notifications.get(0).getTimestamp();
    if (timestamp != 0) builder.setWhen(timestamp);

    //builder.addActions(notificationState.getMarkAsReadIntent(context, notificationId),
    //    notificationState.getQuickReplyIntent(context),
    //    notificationState.getRemoteReplyIntent(context));


    ListIterator<NotificationItem> iterator = notifications.listIterator(notifications.size());

    while(iterator.hasPrevious()) {
      NotificationItem item = iterator.previous();
      builder.addMessageBody(item.getText());
    }

    if (signal) {
      builder.setAlarms(Uri.parse(""));
      builder.setTicker("Dinesh Air",
          notifications.get(0).getText());
    }

    if (!bundled) {
      builder.setGroupSummary(true);
    }

    NotificationManagerCompat.from(context).notify(notificationId, builder.build());
  }


}
