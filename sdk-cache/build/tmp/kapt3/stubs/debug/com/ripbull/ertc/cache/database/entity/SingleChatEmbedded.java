package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by DK on 10/03/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/SingleChatEmbedded;", "", "()V", "listChatThread", "", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "getListChatThread", "()Ljava/util/List;", "setListChatThread", "(Ljava/util/List;)V", "reactionEntities", "Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "getReactionEntities", "setReactionEntities", "singleChat", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "getSingleChat", "()Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "setSingleChat", "(Lcom/ripbull/ertc/cache/database/entity/SingleChat;)V", "sdk-cache_debug"})
public final class SingleChatEmbedded {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Embedded()
    private com.ripbull.ertc.cache.database.entity.SingleChat singleChat;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Relation(parentColumn = "id", entityColumn = "parent_msg_id")
    private java.util.List<com.ripbull.ertc.cache.database.entity.ChatThread> listChatThread;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Relation(parentColumn = "id", entityColumn = "chat_msg_id")
    private java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> reactionEntities;
    
    public SingleChatEmbedded() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.ertc.cache.database.entity.SingleChat getSingleChat() {
        return null;
    }
    
    public final void setSingleChat(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.SingleChat p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.ChatThread> getListChatThread() {
        return null;
    }
    
    public final void setListChatThread(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.ChatThread> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> getReactionEntities() {
        return null;
    }
    
    public final void setReactionEntities(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> p0) {
    }
}