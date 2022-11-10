package com.ripbull.coresdk.announcement.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/ripbull/coresdk/announcement/repository/AnnouncementRepositoryImpl;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/announcement/repository/AnnouncementRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "networkManager", "Lcom/ripbull/ertc/remote/NetworkManager;", "preference", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "networkConfig", "Lcom/ripbull/ertc/remote/NetworkConfig;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/core/event/EventHandler;Lcom/ripbull/ertc/remote/NetworkManager;Lcom/ripbull/ertc/cache/preference/PreferenceManager;Lcom/ripbull/ertc/remote/NetworkConfig;)V", "subscribeToAnnouncement", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/announcement/mapper/AnnouncementRecord;", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class AnnouncementRepositoryImpl extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.announcement.repository.AnnouncementRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.coresdk.core.event.EventHandler eventHandler = null;
    private final com.ripbull.ertc.remote.NetworkManager networkManager = null;
    private final com.ripbull.ertc.cache.preference.PreferenceManager preference = null;
    private final com.ripbull.ertc.remote.NetworkConfig networkConfig = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.announcement.repository.AnnouncementRepositoryImpl.Companion Companion = null;
    
    private AnnouncementRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.core.event.EventHandler eventHandler, com.ripbull.ertc.remote.NetworkManager networkManager, com.ripbull.ertc.cache.preference.PreferenceManager preference, com.ripbull.ertc.remote.NetworkConfig networkConfig) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.announcement.repository.AnnouncementRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.announcement.mapper.AnnouncementRecord> subscribeToAnnouncement() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/announcement/repository/AnnouncementRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/announcement/repository/AnnouncementRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.announcement.repository.AnnouncementRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}