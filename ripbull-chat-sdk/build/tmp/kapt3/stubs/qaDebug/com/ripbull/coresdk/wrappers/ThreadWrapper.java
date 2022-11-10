package com.ripbull.coresdk.wrappers;

import java.lang.System;

/**
 * Created by DK on 12/06/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\u0010\r\u001a\u00060\u000eR\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/ripbull/coresdk/wrappers/ThreadWrapper;", "", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "(Lcom/ripbull/coresdk/data/DataManager;)V", "gson", "Lcom/google/gson/Gson;", "chatCleared", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/ChatMetaDataRecord;", "receivedMessage", "Lcom/ripbull/ertc/mqtt/listener/ReceivedMessage;", "threadMetaDataUpdated", "eventItem", "Lcom/ripbull/ertc/remote/model/response/UserSelfUpdateResponse$EventItem;", "Lcom/ripbull/ertc/remote/model/response/UserSelfUpdateResponse;", "ripbull-chat-sdk_qaDebug"})
public final class ThreadWrapper {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.google.gson.Gson gson = null;
    
    public ThreadWrapper(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatMetaDataRecord> threadMetaDataUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.UserSelfUpdateResponse.EventItem eventItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatMetaDataRecord> chatCleared(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
}