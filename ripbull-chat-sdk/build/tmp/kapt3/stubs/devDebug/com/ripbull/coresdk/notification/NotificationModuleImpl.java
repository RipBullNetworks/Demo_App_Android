package com.ripbull.coresdk.notification;

import java.lang.System;

/**
 * @author Sagar
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J6\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/ripbull/coresdk/notification/NotificationModuleImpl;", "Lcom/ripbull/coresdk/module/BaseModule;", "Lcom/ripbull/coresdk/notification/NotificationModule;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "notificationRepository", "Lcom/ripbull/coresdk/notification/repository/NotificationRepository;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/notification/repository/NotificationRepository;)V", "getSettings", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/notification/mapper/NotificationSettingRecord;", "threadId", "", "muteNotifications", "action", "muteNotificationType", "Lcom/ripbull/coresdk/core/type/MuteNotificationType;", "timePeriod", "Lcom/ripbull/coresdk/core/type/SettingAppliedFor;", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "Companion", "ripbull-chat-sdk_devDebug"})
public final class NotificationModuleImpl extends com.ripbull.coresdk.module.BaseModule implements com.ripbull.coresdk.notification.NotificationModule {
    private final com.ripbull.coresdk.notification.repository.NotificationRepository notificationRepository = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.notification.NotificationModuleImpl.Companion Companion = null;
    
    private NotificationModuleImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.notification.repository.NotificationRepository notificationRepository) {
        super(null);
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/ripbull/coresdk/notification/NotificationModuleImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/notification/NotificationModule;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ripbull.coresdk.notification.NotificationModule newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager) {
            return null;
        }
    }
}