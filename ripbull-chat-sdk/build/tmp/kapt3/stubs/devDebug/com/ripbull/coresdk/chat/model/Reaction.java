package com.ripbull.coresdk.chat.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00c6\u0003JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/ripbull/coresdk/chat/model/Reaction;", "", "msgId", "", "parentMsgId", "sendToChannel", "", "emojiCode", "chatReactionType", "Lcom/ripbull/coresdk/core/type/ChatReactionType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/ripbull/coresdk/core/type/ChatReactionType;)V", "getChatReactionType", "()Lcom/ripbull/coresdk/core/type/ChatReactionType;", "getEmojiCode", "()Ljava/lang/String;", "getMsgId", "getParentMsgId", "getSendToChannel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/ripbull/coresdk/core/type/ChatReactionType;)Lcom/ripbull/coresdk/chat/model/Reaction;", "equals", "", "other", "hashCode", "toString", "ripbull-chat-sdk_devDebug"})
public final class Reaction {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String msgId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parentMsgId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer sendToChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String emojiCode = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ripbull.coresdk.core.type.ChatReactionType chatReactionType = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.model.Reaction copy(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.NotNull()
    java.lang.String emojiCode, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatReactionType chatReactionType) {
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
    
    public Reaction(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.NotNull()
    java.lang.String emojiCode, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatReactionType chatReactionType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMsgId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentMsgId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSendToChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmojiCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.type.ChatReactionType component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.type.ChatReactionType getChatReactionType() {
        return null;
    }
}