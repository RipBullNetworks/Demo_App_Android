package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * Created by DK on 13/06/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004H\u0002J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004H\u0002J&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0088\u0001\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011J\u0084\u0001\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010)j\n\u0012\u0004\u0012\u00020#\u0018\u0001`*2\b\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJb\u0010+\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010)j\n\u0012\u0004\u0012\u00020#\u0018\u0001`*J\u0010\u0010-\u001a\u00020.2\u0006\u0010\"\u001a\u00020#H\u0002JL\u0010/\u001a\u0012\u0012\u0004\u0012\u0002000)j\b\u0012\u0004\u0012\u000200`*2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020#0)j\b\u0012\u0004\u0012\u00020#`*2\b\u00102\u001a\u0004\u0018\u00010\u00112\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0011H\u0002J:\u00106\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u00107\u001a\u0002082\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0007\u00a8\u00069"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatRequestMapper;", "", "()V", "convertToReqEmailList", "", "Lcom/ripbull/ertc/remote/model/request/Email;", "list", "Lcom/ripbull/coresdk/chat/mapper/EmailContactRecord;", "convertToReqPhoneNumList", "Lcom/ripbull/ertc/remote/model/request/PhoneNumber;", "Lcom/ripbull/coresdk/chat/mapper/PhoneContactRecord;", "mentions", "Lcom/ripbull/ertc/remote/model/request/Mentions;", "message", "Lcom/ripbull/coresdk/chat/model/Message;", "mentionedChatUserIds", "", "", "request", "Lcom/ripbull/ertc/remote/model/request/MessageRequest;", "thread", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "msgId", "replyThread", "Lcom/ripbull/ertc/remote/model/request/ReplyThread;", "senderId", "threadId", "forwardChat", "Lcom/ripbull/ertc/remote/model/request/ForwardChat;", "recipientAppUserId", "mediaReq", "Lcom/ripbull/ertc/remote/model/request/MediaReq;", "customData", "requestE2E", "eKeyTable", "Lcom/ripbull/ertc/cache/database/entity/EKeyTable;", "ekeyDao", "Lcom/ripbull/ertc/cache/database/dao/EKeyDao;", "groupDao", "Lcom/ripbull/ertc/cache/database/dao/GroupDao;", "parallelDeviceList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "requestEditE2E", "msgUniqueId", "senderKeyDetails", "Lcom/ripbull/ertc/remote/model/request/SenderKeyDetails;", "singleTypeEncryptedChatList", "Lcom/ripbull/ertc/remote/model/request/EncryptedChat;", "tableList", "msg", "msgType", "Lcom/ripbull/coresdk/core/type/MessageType;", "privateKey", "textRequest", "clientCreatedAt", "", "ripbull-chat-sdk_qaDebug"})
public final class ChatRequestMapper {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.mapper.ChatRequestMapper INSTANCE = null;
    
    private ChatRequestMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.remote.model.request.MessageRequest request(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.request.ReplyThread replyThread, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mentionedChatUserIds, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.request.ForwardChat forwardChat, @org.jetbrains.annotations.Nullable()
    java.lang.String recipientAppUserId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.request.MediaReq mediaReq, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.remote.model.request.Mentions> mentions(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mentionedChatUserIds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.remote.model.request.MessageRequest requestE2E(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.request.ReplyThread replyThread, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.EKeyTable eKeyTable, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.EKeyDao ekeyDao, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.GroupDao groupDao, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mentionedChatUserIds, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.ripbull.ertc.cache.database.entity.EKeyTable> parallelDeviceList, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.request.ForwardChat forwardChat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.remote.model.request.MessageRequest requestEditE2E(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.Thread thread, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.EKeyTable eKeyTable, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.EKeyDao ekeyDao, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.GroupDao groupDao, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mentionedChatUserIds, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.ripbull.ertc.cache.database.entity.EKeyTable> parallelDeviceList) {
        return null;
    }
    
    private final com.ripbull.ertc.remote.model.request.SenderKeyDetails senderKeyDetails(com.ripbull.ertc.cache.database.entity.EKeyTable eKeyTable) {
        return null;
    }
    
    private final java.util.ArrayList<com.ripbull.ertc.remote.model.request.EncryptedChat> singleTypeEncryptedChatList(java.util.ArrayList<com.ripbull.ertc.cache.database.entity.EKeyTable> tableList, java.lang.String msg, com.ripbull.coresdk.core.type.MessageType msgType, java.lang.String privateKey) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public final com.ripbull.ertc.remote.model.request.MessageRequest textRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String senderId, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    private final java.util.List<com.ripbull.ertc.remote.model.request.PhoneNumber> convertToReqPhoneNumList(java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> list) {
        return null;
    }
    
    private final java.util.List<com.ripbull.ertc.remote.model.request.Email> convertToReqEmailList(java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> list) {
        return null;
    }
}