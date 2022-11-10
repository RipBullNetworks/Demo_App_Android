package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u00c6\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jh\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\fH\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "", "threadId", "", "msgUniqueId", "emojiCode", "chatReactionType", "Lcom/ripbull/coresdk/core/type/ChatReactionType;", "userRecord", "", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "count", "", "parentMsgId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/core/type/ChatReactionType;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getChatReactionType", "()Lcom/ripbull/coresdk/core/type/ChatReactionType;", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEmojiCode", "()Ljava/lang/String;", "getMsgUniqueId", "getParentMsgId", "getThreadId", "getUserRecord", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/core/type/ChatReactionType;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "equals", "", "other", "hashCode", "toString", "ripbull-chat-sdk_qaDebug"})
public final class ChatReactionRecord {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String threadId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String msgUniqueId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String emojiCode = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.core.type.ChatReactionType chatReactionType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer count = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parentMsgId = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.ChatReactionRecord copy(@org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String emojiCode, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatReactionType chatReactionType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Integer count, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ChatReactionRecord() {
        super();
    }
    
    public ChatReactionRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String emojiCode, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatReactionType chatReactionType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Integer count, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgUniqueId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmojiCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.ChatReactionType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.ChatReactionType getChatReactionType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> getUserRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentMsgId() {
        return null;
    }
}