package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by DK on 13/06/20.
 */
@androidx.room.Entity(tableName = "chat_reaction", indices = {@androidx.room.Index(unique = true, value = {"id", "chat_msg_id", "chat_thread_msg_id"}), @androidx.room.Index(unique = true, value = {"chat_msg_id", "unicode", "user_chat_id"}), @androidx.room.Index(unique = true, value = {"chat_thread_msg_id", "unicode", "user_chat_id"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.ripbull.ertc.cache.database.entity.SingleChat.class, childColumns = {"chat_msg_id"}, onDelete = 5, parentColumns = {"id"}), @androidx.room.ForeignKey(entity = com.ripbull.ertc.cache.database.entity.ChatThread.class, childColumns = {"chat_thread_msg_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J^\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u000bH\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "", "id", "", "unicode", "", "threadId", "userChatId", "chatMsgId", "chatThreadMsgId", "totalCount", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getChatMsgId", "()Ljava/lang/String;", "setChatMsgId", "(Ljava/lang/String;)V", "getChatThreadMsgId", "setChatThreadMsgId", "getId", "()J", "getThreadId", "setThreadId", "getTotalCount", "()Ljava/lang/Integer;", "setTotalCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUnicode", "setUnicode", "getUserChatId", "setUserChatId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "equals", "", "other", "hashCode", "toString", "sdk-cache_debug"})
public final class ChatReactionEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "unicode")
    private java.lang.String unicode;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "thread_id")
    private java.lang.String threadId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "user_chat_id")
    private java.lang.String userChatId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "chat_msg_id")
    private java.lang.String chatMsgId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "chat_thread_msg_id")
    private java.lang.String chatThreadMsgId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "total_count")
    private java.lang.Integer totalCount;
    
    /**
     * Created by DK on 13/06/20.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.ChatReactionEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatThreadMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalCount) {
        return null;
    }
    
    /**
     * Created by DK on 13/06/20.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 13/06/20.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 13/06/20.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatReactionEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatReactionEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMsgId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatReactionEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatThreadMsgId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatReactionEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String chatThreadMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalCount) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatReactionEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String unicode, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUnicode() {
        return null;
    }
    
    public final void setUnicode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    public final void setThreadId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserChatId() {
        return null;
    }
    
    public final void setUserChatId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChatMsgId() {
        return null;
    }
    
    public final void setChatMsgId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChatThreadMsgId() {
        return null;
    }
    
    public final void setChatThreadMsgId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTotalCount() {
        return null;
    }
    
    public final void setTotalCount(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
}