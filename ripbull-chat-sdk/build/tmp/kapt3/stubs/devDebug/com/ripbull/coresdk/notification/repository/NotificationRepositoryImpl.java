package com.ripbull.coresdk.notification.repository;

import java.lang.System;

/**
 * @author Sagar
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/ripbull/coresdk/notification/repository/NotificationRepositoryImpl;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/notification/repository/NotificationRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "networkManager", "Lcom/ripbull/ertc/remote/NetworkManager;", "preference", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/ertc/remote/NetworkManager;Lcom/ripbull/ertc/cache/preference/PreferenceManager;)V", "getSettings", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/notification/mapper/NotificationSettingRecord;", "threadId", "", "muteAppNotifications", "action", "timePeriod", "Lcom/ripbull/coresdk/core/type/SettingAppliedFor;", "muteNotifications", "noInternetConnection", "", "Companion", "ripbull-chat-sdk_devDebug"})
public final class NotificationRepositoryImpl extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.notification.repository.NotificationRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.ertc.remote.NetworkManager networkManager = null;
    private final com.ripbull.ertc.cache.preference.PreferenceManager preference = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.notification.repository.NotificationRepositoryImpl.Companion Companion = null;
    
    private NotificationRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.ertc.remote.NetworkManager networkManager, com.ripbull.ertc.cache.preference.PreferenceManager preference) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.notification.repository.NotificationRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> muteAppNotifications(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.SettingAppliedFor timePeriod) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> muteNotifications(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.SettingAppliedFor timePeriod) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> getSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    private final boolean noInternetConnection() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/ripbull/coresdk/notification/repository/NotificationRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/notification/repository/NotificationRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.notification.repository.NotificationRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager) {
            return null;
        }
    }
}