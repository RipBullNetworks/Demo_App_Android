package com.ripbull.coresdk.fcm;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/ripbull/coresdk/fcm/NotificationUtils;", "", "()V", "Companion", "ripbull-chat-sdk_devDebug"})
public final class NotificationUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.fcm.NotificationUtils.Companion Companion = null;
    private static final java.lang.String TAG = null;
    private static final java.lang.String CHANNEL_ID = "ertc_channel";
    
    public NotificationUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0004J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0004J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ@\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020!H\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/ripbull/coresdk/fcm/NotificationUtils$Companion;", "", "()V", "CHANNEL_ID", "", "TAG", "kotlin.jvm.PlatformType", "clearNotifications", "", "context", "Landroid/content/Context;", "createId", "", "getAppIcon", "getTimeMilliSec", "", "isAppIsInBackground", "", "parseRegex", "chatMessage", "showNotificationMessage", "title", "message", "threadId", "showSmallNotification", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "resultPendingIntent", "Landroid/app/PendingIntent;", "preferenceManager", "Lcom/ripbull/coresdk/fcm/NotificationPreferenceManager;", "uriDecoder", "serverResponse", "", "uriEncode", "toServer", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void showNotificationMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        java.lang.String threadId, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private final void showSmallNotification(androidx.core.app.NotificationCompat.Builder mBuilder, java.lang.String title, java.lang.String message, java.lang.String threadId, android.app.PendingIntent resultPendingIntent, com.ripbull.coresdk.fcm.NotificationPreferenceManager preferenceManager, android.content.Context context) {
        }
        
        /**
         * Method checks if the app is in background or not
         */
        protected final boolean isAppIsInBackground(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        private final void clearNotifications(android.content.Context context) {
        }
        
        private final long getTimeMilliSec() {
            return 0L;
        }
        
        private final int createId() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        protected final java.lang.String uriDecoder(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence serverResponse) {
            return null;
        }
        
        private final java.lang.CharSequence uriEncode(java.lang.CharSequence toServer) {
            return null;
        }
        
        private final int getAppIcon(android.content.Context context) {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        protected final java.lang.String parseRegex(@org.jetbrains.annotations.NotNull()
        java.lang.String chatMessage) {
            return null;
        }
    }
}