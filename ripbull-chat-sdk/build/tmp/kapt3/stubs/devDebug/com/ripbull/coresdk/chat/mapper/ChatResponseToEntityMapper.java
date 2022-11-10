package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * It maps server response to entity.i.e return entity
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u00d3\u0002\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0002\u0010*J\u00a7\u0002\u0010+\u001a\u00020,2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0002\u0010-J \u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001a2\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001aH\u0002J \u00101\u001a\b\u0012\u0004\u0012\u0002020\u001a2\u0010\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0002JX\u00103\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u0002042\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\bJ@\u00106\u001a\u00020,2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u0002042\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\b\u00a8\u00067"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatResponseToEntityMapper;", "", "()V", "chatRowCompose", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "thread", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "message", "", "msgId", "msgType", "msgStatus", "createdAt", "", "isRead", "", "msgUniqueId", "mediaPath", "mediaThumbnail", "mediaName", "address", "latitude", "", "longitude", "contactName", "phoneNumberRecord", "", "Lcom/ripbull/ertc/remote/model/response/PhoneNumber;", "eMailRecords", "Lcom/ripbull/ertc/remote/model/response/Email;", "gifPath", "senderUserId", "sendToChannel", "", "parentMsgId", "parentMsg", "chatEventType", "forwardMsgUniqueId", "isForwardMessage", "clientCreatedAt", "customData", "isFavoriteMessage", "(Lcom/ripbull/ertc/cache/database/entity/Thread;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "chatThreadRowCompose", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "(Lcom/ripbull/ertc/cache/database/entity/Thread;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "convertToEntityEmailContactList", "Lcom/ripbull/ertc/cache/database/entity/EmailContact;", "list", "convertToEntityPhoneContactList", "Lcom/ripbull/ertc/cache/database/entity/PhoneContact;", "getChatRow", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "baseUrl", "getChatThreadRow", "ripbull-chat-sdk_devDebug"})
public final class ChatResponseToEntityMapper {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.mapper.ChatResponseToEntityMapper INSTANCE = null;
    
    private ChatResponseToEntityMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.SingleChat getChatRow(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.MessageResponse message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String baseUrl) {
        return null;
    }
    
    private final com.ripbull.ertc.cache.database.entity.SingleChat chatRowCompose(com.ripbull.ertc.cache.database.entity.Thread thread, java.lang.String message, java.lang.String msgId, java.lang.String msgType, java.lang.String msgStatus, long createdAt, boolean isRead, java.lang.String msgUniqueId, java.lang.String mediaPath, java.lang.String mediaThumbnail, java.lang.String mediaName, java.lang.String address, java.lang.Double latitude, java.lang.Double longitude, java.lang.String contactName, java.util.List<com.ripbull.ertc.remote.model.response.PhoneNumber> phoneNumberRecord, java.util.List<com.ripbull.ertc.remote.model.response.Email> eMailRecords, java.lang.String gifPath, java.lang.String senderUserId, java.lang.Integer sendToChannel, java.lang.String parentMsgId, java.lang.String parentMsg, java.lang.String chatEventType, java.lang.String forwardMsgUniqueId, java.lang.Boolean isForwardMessage, java.lang.Long clientCreatedAt, java.lang.String customData, java.lang.Boolean isFavoriteMessage) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.ChatThread getChatThreadRow(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.MessageResponse message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String senderUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String baseUrl) {
        return null;
    }
    
    private final com.ripbull.ertc.cache.database.entity.ChatThread chatThreadRowCompose(com.ripbull.ertc.cache.database.entity.Thread thread, java.lang.String message, java.lang.String msgId, java.lang.String msgType, java.lang.String msgStatus, long createdAt, boolean isRead, java.lang.String msgUniqueId, java.lang.String parentMsgId, java.lang.String mediaPath, java.lang.String mediaThumbnail, java.lang.String mediaName, java.lang.String address, java.lang.Double latitude, java.lang.Double longitude, java.lang.String contactName, java.util.List<com.ripbull.ertc.remote.model.response.PhoneNumber> phoneNumberRecord, java.util.List<com.ripbull.ertc.remote.model.response.Email> eMailRecords, java.lang.String gifPath, java.lang.Integer sendToChannel, java.lang.String senderUserId, java.lang.Long clientCreatedAt, java.lang.String customData, java.lang.Boolean isFavoriteMessage) {
        return null;
    }
    
    private final java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> convertToEntityPhoneContactList(java.util.List<com.ripbull.ertc.remote.model.response.PhoneNumber> list) {
        return null;
    }
    
    private final java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> convertToEntityEmailContactList(java.util.List<com.ripbull.ertc.remote.model.response.Email> list) {
        return null;
    }
}