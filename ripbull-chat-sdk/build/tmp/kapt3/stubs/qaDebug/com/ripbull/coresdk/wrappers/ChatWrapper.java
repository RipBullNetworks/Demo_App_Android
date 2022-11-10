package com.ripbull.coresdk.wrappers;

import java.lang.System;

/**
 * Created by DK on 16/03/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0002J(\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00152\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020&J\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\n\u0010(\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010)\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001c2\u0006\u0010,\u001a\u00020-2\n\u0010.\u001a\u00060/R\u00020-H\u0002J\n\u00100\u001a\u0004\u0018\u00010\bH\u0002J2\u00101\u001a\u0004\u0018\u00010\"2\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010>\u001a\u00020?H\u0002J$\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010C\u001a\u0004\u0018\u00010\bJ\u0018\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00152\u0006\u0010E\u001a\u00020\u0018H\u0007J\u0016\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0002Jb\u0010H\u001a\u00020I2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010L\u001a\u0004\u0018\u00010\b2\u0006\u0010M\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020\b2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bH\u0002J\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015J\u0014\u0010S\u001a\u0004\u0018\u00010\b2\b\u0010S\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lcom/ripbull/coresdk/wrappers/ChatWrapper;", "", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/core/event/EventHandler;)V", "appUserId", "", "chatUserId", "db", "Lcom/ripbull/ertc/cache/database/DataSource;", "deviceId", "gson", "Lcom/google/gson/Gson;", "mqttManager", "Lcom/ripbull/ertc/mqtt/MqttManager;", "preferenceManager", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "tenantId", "announcementTrigger", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/announcement/mapper/AnnouncementRecord;", "receivedMessage", "Lcom/ripbull/ertc/mqtt/listener/ReceivedMessage;", "autoLogout", "Lcom/ripbull/coresdk/data/common/Result;", "composeReactionList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "listOfReactionEntities", "", "Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "download", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "msgId", "localPath", "status", "Lcom/ripbull/sdk/downloader/utils/Status;", "fetchChatSettings", "getAppUserId", "getChatUserId", "getConfigList", "Lcom/ripbull/ertc/cache/database/entity/TenantConfig;", "tenant", "Lcom/ripbull/ertc/remote/model/response/TenantDetailResponse;", "config", "Lcom/ripbull/ertc/remote/model/response/TenantDetailResponse$Config;", "getDeviceId", "getDownloadMessageRecord", "singleChatEmbedded", "Lcom/ripbull/ertc/cache/database/entity/SingleChatEmbedded;", "chatThread", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "downloadStatus", "getParentMessage", "singleChat", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "getTenantId", "groupUpdated", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "groupUpdatedMessage", "isE2EFeatureEnabled", "", "markAsRead", "Lio/reactivex/Completable;", "threadId", "parentMsgId", "messagesOn", "message", "msgReadStatus", "onChatUpdate", "publishStatus", "", "response", "Lcom/ripbull/ertc/mqtt/model/ChatTopicResponse;", "msgUniqueId", "recipientERTCUserId", "replyThread", "Lcom/ripbull/ertc/mqtt/model/ReplyThread;", "forwardChat", "Lcom/ripbull/ertc/mqtt/model/ForwardChat;", "updateFeatures", "updateType", "ripbull-chat-sdk_qaDebug"})
public final class ChatWrapper {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.coresdk.core.event.EventHandler eventHandler = null;
    private final com.ripbull.ertc.cache.database.DataSource db = null;
    private final com.google.gson.Gson gson = null;
    private final com.ripbull.ertc.mqtt.MqttManager mqttManager = null;
    private java.lang.String chatUserId;
    private java.lang.String appUserId;
    private java.lang.String deviceId;
    private java.lang.String tenantId;
    private final com.ripbull.ertc.cache.preference.PreferenceManager preferenceManager = null;
    
    public ChatWrapper(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        super();
    }
    
    private final java.lang.String getChatUserId() {
        return null;
    }
    
    private final java.lang.String getAppUserId() {
        return null;
    }
    
    private final java.lang.String getDeviceId() {
        return null;
    }
    
    private final java.lang.String getTenantId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageRecord> messagesOn(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage message) {
        return null;
    }
    
    private final void publishStatus(com.ripbull.ertc.mqtt.model.ChatTopicResponse response) {
    }
    
    private final void publishStatus(java.lang.String tenantId, java.lang.String msgUniqueId, java.lang.String recipientERTCUserId, java.lang.String threadId, java.lang.String chatUserId, java.lang.String status, com.ripbull.ertc.mqtt.model.ReplyThread replyThread, com.ripbull.ertc.mqtt.model.ForwardChat forwardChat, java.lang.String deviceId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageRecord> msgReadStatus(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageRecord> onChatUpdate(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    private final java.lang.String updateType(java.lang.String updateType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Completable markAsRead(@org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String appUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.group.mapper.GroupRecord> groupUpdated(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageRecord> groupUpdatedMessage(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    private final java.lang.String getParentMessage(com.ripbull.ertc.cache.database.entity.SingleChat singleChat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageRecord> download(@org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.String localPath, @org.jetbrains.annotations.NotNull()
    com.ripbull.sdk.downloader.utils.Status status) {
        return null;
    }
    
    private final com.ripbull.coresdk.chat.mapper.MessageRecord getDownloadMessageRecord(com.ripbull.ertc.cache.database.entity.SingleChatEmbedded singleChatEmbedded, com.ripbull.ertc.cache.database.entity.ChatThread chatThread, java.lang.String downloadStatus, java.lang.String localPath) {
        return null;
    }
    
    private final boolean isE2EFeatureEnabled() {
        return false;
    }
    
    private final java.util.ArrayList<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> composeReactionList(java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> listOfReactionEntities) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.announcement.mapper.AnnouncementRecord> announcementTrigger(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.data.common.Result> autoLogout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.data.common.Result> updateFeatures() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<com.ripbull.coresdk.data.common.Result> fetchChatSettings(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.listener.ReceivedMessage receivedMessage) {
        return null;
    }
    
    private final java.util.ArrayList<com.ripbull.ertc.cache.database.entity.TenantConfig> getConfigList(com.ripbull.ertc.remote.model.response.TenantDetailResponse tenant, com.ripbull.ertc.remote.model.response.TenantDetailResponse.Config config) {
        return null;
    }
}