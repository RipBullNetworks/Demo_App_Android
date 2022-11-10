package com.ripbull.coresdk.thread.mapper;

import java.lang.System;

/**
 * Created by DK on 01/03/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0007H\u00c6\u0003J\t\u0010@\u001a\u00020\u0007H\u00c6\u0003J\t\u0010A\u001a\u00020\u0007H\u00c6\u0003J\t\u0010B\u001a\u00020\u000bH\u00c6\u0003J\t\u0010C\u001a\u00020\u0007H\u00c6\u0003J\t\u0010D\u001a\u00020\u000eH\u00c6\u0003J\u0085\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010I\u001a\u00020\u0007H\u00d6\u0001J\t\u0010J\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010$R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 \u00a8\u0006K"}, d2 = {"Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "", "id", "", "name", "type", "messageCount", "", "read", "unReadCount", "creationDate", "", "hasDeleted", "lastMessage", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "recipient", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "groupRecipient", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "notificationSettings", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIJILcom/ripbull/coresdk/chat/mapper/MessageRecord;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Ljava/lang/String;)V", "getCreationDate", "()J", "setCreationDate", "(J)V", "getGroupRecipient", "()Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "setGroupRecipient", "(Lcom/ripbull/coresdk/group/mapper/GroupRecord;)V", "getHasDeleted", "()I", "setHasDeleted", "(I)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getLastMessage", "()Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "setLastMessage", "(Lcom/ripbull/coresdk/chat/mapper/MessageRecord;)V", "getMessageCount", "setMessageCount", "getName", "setName", "getNotificationSettings", "setNotificationSettings", "getRead", "setRead", "getRecipient", "()Lcom/ripbull/coresdk/user/mapper/UserRecord;", "setRecipient", "(Lcom/ripbull/coresdk/user/mapper/UserRecord;)V", "getType", "setType", "getUnReadCount", "setUnReadCount", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "ripbull-chat-sdk_devDebug"})
public final class ThreadRecord {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type;
    private int messageCount;
    private int read;
    private int unReadCount;
    private long creationDate;
    private int hasDeleted;
    @org.jetbrains.annotations.NotNull()
    private com.ripbull.coresdk.chat.mapper.MessageRecord lastMessage;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.user.mapper.UserRecord recipient;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.group.mapper.GroupRecord groupRecipient;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String notificationSettings;
    
    /**
     * Created by DK on 01/03/19.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.thread.mapper.ThreadRecord copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int messageCount, int read, int unReadCount, long creationDate, int hasDeleted, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord lastMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord recipient, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecipient, @org.jetbrains.annotations.NotNull()
    java.lang.String notificationSettings) {
        return null;
    }
    
    /**
     * Created by DK on 01/03/19.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 01/03/19.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 01/03/19.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public ThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int messageCount, int read, int unReadCount, long creationDate, int hasDeleted, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord lastMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord recipient, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecipient, @org.jetbrains.annotations.NotNull()
    java.lang.String notificationSettings) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int messageCount, int read, int unReadCount, long creationDate, int hasDeleted, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord lastMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord recipient, @org.jetbrains.annotations.NotNull()
    java.lang.String notificationSettings) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public ThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int messageCount, int read, int unReadCount, long creationDate, int hasDeleted, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord lastMessage, @org.jetbrains.annotations.NotNull()
    java.lang.String notificationSettings) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getMessageCount() {
        return 0;
    }
    
    public final void setMessageCount(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getRead() {
        return 0;
    }
    
    public final void setRead(int p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getUnReadCount() {
        return 0;
    }
    
    public final void setUnReadCount(int p0) {
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long getCreationDate() {
        return 0L;
    }
    
    public final void setCreationDate(long p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getHasDeleted() {
        return 0;
    }
    
    public final void setHasDeleted(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord getLastMessage() {
        return null;
    }
    
    public final void setLastMessage(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord getRecipient() {
        return null;
    }
    
    public final void setRecipient(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.mapper.GroupRecord component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.mapper.GroupRecord getGroupRecipient() {
        return null;
    }
    
    public final void setGroupRecipient(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNotificationSettings() {
        return null;
    }
    
    public final void setNotificationSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}