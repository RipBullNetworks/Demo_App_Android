package com.ripbull.coresdk.announcement;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/announcement/AnnouncementModule;", "", "subscribeToAnnouncement", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/announcement/mapper/AnnouncementRecord;", "ripbull-chat-sdk_qaDebug"})
public abstract interface AnnouncementModule {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.announcement.mapper.AnnouncementRecord> subscribeToAnnouncement();
}