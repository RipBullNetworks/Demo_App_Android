package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * It maps response/entity to entity.i.e return record
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0002J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002Jm\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0002\u0010 J\u007f\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0002\u0010$J\u008b\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0002\u0010(Jm\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0002\u0010 \u00a8\u0006*"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatRecordMapper;", "", "()V", "convertToRecordEmailContactList", "", "Lcom/ripbull/coresdk/chat/mapper/EmailContactRecord;", "list", "Lcom/ripbull/ertc/cache/database/entity/EmailContact;", "convertToRecordPhoneContactList", "Lcom/ripbull/coresdk/chat/mapper/PhoneContactRecord;", "Lcom/ripbull/ertc/cache/database/entity/PhoneContact;", "getMsgUpdateType", "Lcom/ripbull/coresdk/core/type/MessageUpdateType;", "updateType", "", "transform", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "chatThread", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "senderRecord", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "receiverRecord", "groupRecord", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "notificationRecord", "Lcom/ripbull/coresdk/fcm/NotificationRecord;", "chatEventType", "Lcom/ripbull/coresdk/core/type/ChatEventType;", "chatReactions", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "isSilent", "", "(Lcom/ripbull/ertc/cache/database/entity/ChatThread;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Lcom/ripbull/coresdk/fcm/NotificationRecord;Lcom/ripbull/coresdk/core/type/ChatEventType;Ljava/util/List;Ljava/lang/Boolean;)Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "singleChat", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "chatThreadList", "(Lcom/ripbull/ertc/cache/database/entity/SingleChat;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Lcom/ripbull/coresdk/fcm/NotificationRecord;Ljava/util/List;Lcom/ripbull/coresdk/core/type/ChatEventType;Ljava/util/List;Ljava/lang/Boolean;)Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "messageResponse", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "threadType", "(Lcom/ripbull/ertc/remote/model/response/MessageResponse;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Ljava/lang/String;Lcom/ripbull/coresdk/fcm/NotificationRecord;Ljava/util/List;Lcom/ripbull/coresdk/core/type/ChatEventType;Ljava/util/List;Ljava/lang/Boolean;)Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "transformDelete", "ripbull-chat-sdk_devDebug"})
public final class ChatRecordMapper {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.mapper.ChatRecordMapper INSTANCE = null;
    
    private ChatRecordMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord transformDelete(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.ChatThread chatThread, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> chatReactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord transform(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.SingleChat singleChat, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.ChatThread> chatThreadList, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> chatReactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent) {
        return null;
    }
    
    private final com.ripbull.coresdk.core.type.MessageUpdateType getMsgUpdateType(java.lang.String updateType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord transform(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.ChatThread chatThread, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> chatReactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord transform(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.MessageResponse messageResponse, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String threadType, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.ChatThread> chatThreadList, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> chatReactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent) {
        return null;
    }
    
    private final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> convertToRecordPhoneContactList(java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> list) {
        return null;
    }
    
    private final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> convertToRecordEmailContactList(java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> list) {
        return null;
    }
}