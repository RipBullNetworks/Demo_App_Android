package com.ripbull.coresdk.announcement;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/ripbull/coresdk/announcement/AnnouncementModuleImpl;", "Lcom/ripbull/coresdk/module/BaseModule;", "Lcom/ripbull/coresdk/announcement/AnnouncementModule;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "announcementRepository", "Lcom/ripbull/coresdk/announcement/repository/AnnouncementRepository;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/announcement/repository/AnnouncementRepository;)V", "subscribeToAnnouncement", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/announcement/mapper/AnnouncementRecord;", "Companion", "ripbull-chat-sdk_devDebug"})
public final class AnnouncementModuleImpl extends com.ripbull.coresdk.module.BaseModule implements com.ripbull.coresdk.announcement.AnnouncementModule {
    private final com.ripbull.coresdk.announcement.repository.AnnouncementRepository announcementRepository = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.announcement.AnnouncementModuleImpl.Companion Companion = null;
    
    private AnnouncementModuleImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.announcement.repository.AnnouncementRepository announcementRepository) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.announcement.mapper.AnnouncementRecord> subscribeToAnnouncement() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/announcement/AnnouncementModuleImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/announcement/AnnouncementModule;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ripbull.coresdk.announcement.AnnouncementModule newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}