package com.ripbull.coresdk.notification.repository;

import java.lang.System;

/**
 * @author Sagar
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/ripbull/coresdk/notification/repository/NotificationRepository;", "", "getSettings", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/notification/mapper/NotificationSettingRecord;", "threadId", "", "muteAppNotifications", "action", "timePeriod", "Lcom/ripbull/coresdk/core/type/SettingAppliedFor;", "muteNotifications", "ripbull-chat-sdk_devDebug"})
public abstract interface NotificationRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> muteAppNotifications(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.SettingAppliedFor timePeriod);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> muteNotifications(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.SettingAppliedFor timePeriod);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> getSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
}