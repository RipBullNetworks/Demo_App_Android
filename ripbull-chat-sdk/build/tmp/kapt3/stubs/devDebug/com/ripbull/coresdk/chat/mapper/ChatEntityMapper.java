package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * It maps request/MQTT response/record to entity.i.e return entity
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u00f7\u0002\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0002\u0010-J\u00bf\u0002\u0010.\u001a\u00020/2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0002\u00100J \u00101\u001a\b\u0012\u0004\u0012\u0002020\u001a2\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001aH\u0002J \u00104\u001a\b\u0012\u0004\u0012\u0002050\u001a2\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0002JN\u00106\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u0002072\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00108\u001a\u0004\u0018\u000109JR\u00106\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ2\u0010@\u001a\u00020/2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u0002072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\bJF\u0010A\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\bJD\u0010J\u001a\u0004\u0018\u00010/2\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bJ7\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\r2\b\u0010)\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010PJK\u0010K\u001a\u00020Q2\u0006\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\b2\b\u0010V\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010!\u00a2\u0006\u0002\u0010X\u00a8\u0006Y"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatEntityMapper;", "", "()V", "chatRowCompose", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "thread", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "message", "", "msgId", "msgType", "msgStatus", "createdAt", "", "isRead", "", "msgUniqueId", "mediaPath", "mediaThumbnail", "mediaName", "address", "latitude", "", "longitude", "contactName", "phoneNumberRecord", "", "Lcom/ripbull/coresdk/chat/mapper/PhoneContactRecord;", "eMailRecords", "Lcom/ripbull/coresdk/chat/mapper/EmailContactRecord;", "gifPath", "senderUserId", "sendToChannel", "", "parentMsgId", "parentMsg", "chatEventType", "forwardMsgUniqueId", "isForwardMessage", "localMediaPath", "clientCreatedAt", "customData", "isFollowThread", "mentions", "mentionedUsers", "(Lcom/ripbull/ertc/cache/database/entity/Thread;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "chatThreadRowCompose", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "(Lcom/ripbull/ertc/cache/database/entity/Thread;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "convertToEntityEmailContactList", "Lcom/ripbull/ertc/cache/database/entity/EmailContact;", "list", "convertToEntityPhoneContactList", "Lcom/ripbull/ertc/cache/database/entity/PhoneContact;", "getChatRow", "Lcom/ripbull/coresdk/chat/model/Message;", "forwardChat", "Lcom/ripbull/ertc/remote/model/request/ForwardChat;", "response", "Lcom/ripbull/ertc/mqtt/model/ChatTopicResponse;", "preferenceManager", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "eKeyDao", "Lcom/ripbull/ertc/cache/database/dao/EKeyDao;", "getChatThreadRow", "getGroupInfoChatRow", "Lcom/ripbull/coresdk/core/type/ChatEventType;", "groupUpdate", "Lcom/ripbull/coresdk/group/model/GroupUpdate;", "event", "Lcom/ripbull/coresdk/group/model/Event;", "userDao", "Lcom/ripbull/ertc/cache/database/dao/UserDao;", "chatUserId", "getThreadChatRow", "transform", "chatThread", "msgResponse", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "senderAppUserId", "(Lcom/ripbull/ertc/cache/database/entity/ChatThread;Lcom/ripbull/ertc/remote/model/response/MessageResponse;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "unicode", "threadId", "chatMsgId", "chatThreadMsgId", "userChatId", "totalCount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "ripbull-chat-sdk_devDebug"})
public final class ChatEntityMapper {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.mapper.ChatEntityMapper INSTANCE = null;
    
    private ChatEntityMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.SingleChat getChatRow(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.request.ForwardChat forwardChat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.ChatThread getChatThreadRow(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    private final com.ripbull.ertc.cache.database.entity.SingleChat chatRowCompose(com.ripbull.ertc.cache.database.entity.Thread thread, java.lang.String message, java.lang.String msgId, java.lang.String msgType, java.lang.String msgStatus, long createdAt, boolean isRead, java.lang.String msgUniqueId, java.lang.String mediaPath, java.lang.String mediaThumbnail, java.lang.String mediaName, java.lang.String address, java.lang.Double latitude, java.lang.Double longitude, java.lang.String contactName, java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneNumberRecord, java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> eMailRecords, java.lang.String gifPath, java.lang.String senderUserId, java.lang.Integer sendToChannel, java.lang.String parentMsgId, java.lang.String parentMsg, java.lang.String chatEventType, java.lang.String forwardMsgUniqueId, java.lang.Boolean isForwardMessage, java.lang.String localMediaPath, java.lang.Long clientCreatedAt, java.lang.String customData, java.lang.Integer isFollowThread, java.lang.String mentions, java.lang.String mentionedUsers) {
        return null;
    }
    
    private final com.ripbull.ertc.cache.database.entity.ChatThread chatThreadRowCompose(com.ripbull.ertc.cache.database.entity.Thread thread, java.lang.String message, java.lang.String msgId, java.lang.String msgType, java.lang.String msgStatus, long createdAt, boolean isRead, java.lang.String msgUniqueId, java.lang.String parentMsgId, java.lang.String mediaPath, java.lang.String mediaThumbnail, java.lang.String mediaName, java.lang.String address, java.lang.Double latitude, java.lang.Double longitude, java.lang.String contactName, java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneNumberRecord, java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> eMailRecords, java.lang.String gifPath, java.lang.Integer sendToChannel, java.lang.String senderUserId, java.lang.String localMediaPath, java.lang.Long clientCreatedAt, java.lang.String customData, java.lang.String mentions, java.lang.String mentionedUsers) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.SingleChat getChatRow(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.model.ChatTopicResponse response, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.preference.PreferenceManager preferenceManager, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.dao.EKeyDao eKeyDao, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.SingleChat getGroupInfoChatRow(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.Nullable()
    java.lang.String senderUserId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.group.model.GroupUpdate groupUpdate, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.group.model.Event event, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.UserDao userDao, @org.jetbrains.annotations.Nullable()
    java.lang.String chatUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.ertc.cache.database.entity.ChatThread getThreadChatRow(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.mqtt.model.ChatTopicResponse response, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.preference.PreferenceManager preferenceManager, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.dao.EKeyDao eKeyDao, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId) {
        return null;
    }
    
    private final java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> convertToEntityPhoneContactList(java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> list) {
        return null;
    }
    
    private final java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> convertToEntityEmailContactList(java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.ChatReactionEntity transform(@org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatThreadMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalCount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.SingleChat transform(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.ChatThread chatThread, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.MessageResponse msgResponse, @org.jetbrains.annotations.NotNull()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
}