package com.ripbull.coresdk.notification.repository;

import java.lang.System;

/**
 * @author Sagar
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&J<\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0000H&\u00a8\u0006\u0010"}, d2 = {"Lcom/ripbull/coresdk/notification/repository/NotificationModuleHook;", "", "getSettings", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/notification/mapper/NotificationSettingRecord;", "threadId", "", "muteNotifications", "action", "muteNotificationType", "Lcom/ripbull/coresdk/core/type/MuteNotificationType;", "timePeriod", "Lcom/ripbull/coresdk/core/type/SettingAppliedFor;", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "provideModule", "ripbull-chat-sdk_qaDebug"})
public abstract interface NotificationModuleHook {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.ripbull.coresdk.notification.repository.NotificationModuleHook provideModule();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> muteNotifications(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.MuteNotificationType muteNotificationType, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.SettingAppliedFor timePeriod, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.notification.mapper.NotificationSettingRecord> getSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    /**
     * @author Sagar
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}