package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * Created by DK on 05/08/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \'2\u00020\u0001:\u0001\'BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JE\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006("}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "", "eventType", "Lcom/ripbull/coresdk/core/type/EventType;", "threadId", "", "messageRecord", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "chatReactionRecord", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "threadMetadata", "Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;", "(Lcom/ripbull/coresdk/core/type/EventType;Ljava/lang/String;Lcom/ripbull/coresdk/chat/mapper/MessageRecord;Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;)V", "getChatReactionRecord", "()Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "getEventType", "()Lcom/ripbull/coresdk/core/type/EventType;", "setEventType", "(Lcom/ripbull/coresdk/core/type/EventType;)V", "getMessageRecord", "()Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "setMessageRecord", "(Lcom/ripbull/coresdk/chat/mapper/MessageRecord;)V", "getThreadId", "()Ljava/lang/String;", "getThreadMetadata", "()Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class ChatEvent {
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.core.type.EventType eventType;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String threadId = null;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.mapper.ChatReactionRecord chatReactionRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata threadMetadata = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.mapper.ChatEvent.Companion Companion = null;
    
    /**
     * Created by DK on 05/08/20.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.ChatEvent copy(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.EventType eventType, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ChatReactionRecord chatReactionRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata threadMetadata) {
        return null;
    }
    
    /**
     * Created by DK on 05/08/20.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 05/08/20.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 05/08/20.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ChatEvent() {
        super();
    }
    
    public ChatEvent(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.EventType eventType, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ChatReactionRecord chatReactionRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata threadMetadata) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.EventType component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.EventType getEventType() {
        return null;
    }
    
    public final void setEventType(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.EventType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord getMessageRecord() {
        return null;
    }
    
    public final void setMessageRecord(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.MessageRecord p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.ChatReactionRecord component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.ChatReactionRecord getChatReactionRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata getThreadMetadata() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.jvm.JvmStatic()
    public static final io.reactivex.functions.Predicate<com.ripbull.coresdk.chat.mapper.ChatEvent> filterType(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.EventType type) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatEvent$Companion;", "", "()V", "filterType", "Lio/reactivex/functions/Predicate;", "Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "type", "Lcom/ripbull/coresdk/core/type/EventType;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.JvmStatic()
        public final io.reactivex.functions.Predicate<com.ripbull.coresdk.chat.mapper.ChatEvent> filterType(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.type.EventType type) {
            return null;
        }
    }
}