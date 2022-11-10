package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by DK on 02/07/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/ThreadChatEmbedded;", "", "()V", "chatThread", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "getChatThread", "()Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "setChatThread", "(Lcom/ripbull/ertc/cache/database/entity/ChatThread;)V", "reactionEntities", "", "Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "getReactionEntities", "()Ljava/util/List;", "setReactionEntities", "(Ljava/util/List;)V", "sdk-cache_debug"})
public final class ThreadChatEmbedded {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Embedded()
    private com.ripbull.ertc.cache.database.entity.ChatThread chatThread;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Relation(parentColumn = "id", entityColumn = "chat_thread_msg_id")
    private java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> reactionEntities;
    
    public ThreadChatEmbedded() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.ertc.cache.database.entity.ChatThread getChatThread() {
        return null;
    }
    
    public final void setChatThread(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.ChatThread p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> getReactionEntities() {
        return null;
    }
    
    public final void setReactionEntities(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> p0) {
    }
}