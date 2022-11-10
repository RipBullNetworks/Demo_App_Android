package com.ripbull.coresdk.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J6\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/ripbull/coresdk/notification/NotificationModuleStub;", "Lcom/ripbull/coresdk/notification/NotificationModule;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSettings", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/notification/mapper/NotificationSettingRecord;", "threadId", "", "muteNotifications", "action", "muteNotificationType", "Lcom/ripbull/coresdk/core/type/MuteNotificationType;", "timePeriod", "Lcom/ripbull/coresdk/core/type/SettingAppliedFor;", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "Companion", "ripbull-chat-sdk_devDebug"})
public final class NotificationModuleStub implements com.ripbull.coresdk.notification.NotificationModule {
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.notification.NotificationModuleStub.Companion Companion = null;
    
    private NotificationModuleStub(android.content.Context appContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> muteNotifications(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.MuteNotificationType muteNotificationType, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.SettingAppliedFor timePeriod, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> getSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/notification/NotificationModuleStub$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/notification/NotificationModule;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ripbull.coresdk.notification.NotificationModule newInstance() {
            return null;
        }
    }
}