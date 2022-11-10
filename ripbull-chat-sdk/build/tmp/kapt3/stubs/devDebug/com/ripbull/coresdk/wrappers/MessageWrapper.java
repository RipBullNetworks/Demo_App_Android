package com.ripbull.coresdk.wrappers;

import java.lang.System;

/**
 * Created by DK on 12/06/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/ripbull/coresdk/wrappers/MessageWrapper;", "", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "(Lcom/ripbull/coresdk/data/DataManager;)V", "chatUserId", "", "deviceId", "gson", "Lcom/google/gson/Gson;", "composeReactionList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "Lkotlin/collections/ArrayList;", "listOfReactionEntities", "", "Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "messageMetaData", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/MessageMetaDataRecord;", "receivedMessage", "Lcom/ripbull/ertc/mqtt/listener/ReceivedMessage;", "topic", "setChatId", "", "setDeviceId", "ripbull-chat-sdk_devDebug"})
public final class MessageWrapper {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.google.gson.Gson gson = null;
    private java.lang.String chatUserId;
    private java.lang.String deviceId;
    
    public MessageWrapper(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        super();
    }
    
    private final void setChatId(java.lang.String chatUserId) {
    }
    
    private final void setDeviceId(java.lang.String chatUserId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageMetaDataRecord> messageMetaData(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String topic) {
        return null;
    }
    
    private final java.util.ArrayList<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> composeReactionList(java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> listOfReactionEntities) {
        return null;
    }
}