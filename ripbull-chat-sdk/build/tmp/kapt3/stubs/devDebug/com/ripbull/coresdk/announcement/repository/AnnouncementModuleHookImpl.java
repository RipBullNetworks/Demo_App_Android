package com.ripbull.coresdk.announcement.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/ripbull/coresdk/announcement/repository/AnnouncementModuleHookImpl;", "Lcom/ripbull/coresdk/announcement/repository/AnnouncementModuleHook;", "announcementModule", "Lcom/ripbull/coresdk/announcement/AnnouncementModule;", "stub", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "tenantDao", "Lcom/ripbull/ertc/cache/database/dao/TenantDao;", "(Lcom/ripbull/coresdk/announcement/AnnouncementModule;Lcom/ripbull/coresdk/announcement/AnnouncementModule;Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/ertc/cache/database/dao/TenantDao;)V", "isFeatureEnabled", "Lio/reactivex/Single;", "", "feature", "", "subscribeToAnnouncement", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/announcement/mapper/AnnouncementRecord;", "Companion", "ripbull-chat-sdk_devDebug"})
public final class AnnouncementModuleHookImpl implements com.ripbull.coresdk.announcement.repository.AnnouncementModuleHook {
    private final com.ripbull.coresdk.announcement.AnnouncementModule announcementModule = null;
    private final com.ripbull.coresdk.announcement.AnnouncementModule stub = null;
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.ertc.cache.database.dao.TenantDao tenantDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.announcement.repository.AnnouncementModuleHookImpl.Companion Companion = null;
    
    private AnnouncementModuleHookImpl(com.ripbull.coresdk.announcement.AnnouncementModule announcementModule, com.ripbull.coresdk.announcement.AnnouncementModule stub, com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.ertc.cache.database.dao.TenantDao tenantDao) {
        super();
    }
    
    private final io.reactivex.Single<java.lang.Boolean> isFeatureEnabled(java.lang.String feature) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.announcement.mapper.AnnouncementRecord> subscribeToAnnouncement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.announcement.repository.AnnouncementModuleHook newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/announcement/repository/AnnouncementModuleHookImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/announcement/repository/AnnouncementModuleHook;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.announcement.repository.AnnouncementModuleHook newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}