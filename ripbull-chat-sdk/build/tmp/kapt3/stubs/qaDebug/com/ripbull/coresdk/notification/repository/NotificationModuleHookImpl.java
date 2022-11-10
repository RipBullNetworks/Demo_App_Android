package com.ripbull.coresdk.notification.repository;

import java.lang.System;

/**
 * @author Sagar
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J6\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0001H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/ripbull/coresdk/notification/repository/NotificationModuleHookImpl;", "Lcom/ripbull/coresdk/notification/repository/NotificationModuleHook;", "notificationModule", "Lcom/ripbull/coresdk/notification/NotificationModule;", "stub", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "tenantDao", "Lcom/ripbull/ertc/cache/database/dao/TenantDao;", "(Lcom/ripbull/coresdk/notification/NotificationModule;Lcom/ripbull/coresdk/notification/NotificationModule;Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/ertc/cache/database/dao/TenantDao;)V", "getSettings", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/notification/mapper/NotificationSettingRecord;", "threadId", "", "isFeatureEnabled", "", "feature", "muteNotifications", "action", "muteNotificationType", "Lcom/ripbull/coresdk/core/type/MuteNotificationType;", "timePeriod", "Lcom/ripbull/coresdk/core/type/SettingAppliedFor;", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "provideModule", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class NotificationModuleHookImpl implements com.ripbull.coresdk.notification.repository.NotificationModuleHook {
    private final com.ripbull.coresdk.notification.NotificationModule notificationModule = null;
    private final com.ripbull.coresdk.notification.NotificationModule stub = null;
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.ertc.cache.database.dao.TenantDao tenantDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.notification.repository.NotificationModuleHookImpl.Companion Companion = null;
    
    private NotificationModuleHookImpl(com.ripbull.coresdk.notification.NotificationModule notificationModule, com.ripbull.coresdk.notification.NotificationModule stub, com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.ertc.cache.database.dao.TenantDao tenantDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.notification.repository.NotificationModuleHook newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ripbull.coresdk.notification.repository.NotificationModuleHook provideModule() {
        return null;
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
    
    private final io.reactivex.Single<java.lang.Boolean> isFeatureEnabled(java.lang.String feature) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/ripbull/coresdk/notification/repository/NotificationModuleHookImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/notification/repository/NotificationModuleHook;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.notification.repository.NotificationModuleHook newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager) {
            return null;
        }
    }
}