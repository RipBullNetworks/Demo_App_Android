package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * Created by Sagar on 01/01/22.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001Bm\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u00a2\u0006\u0002\u0010\u0013J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\fH\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J}\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u00c6\u0001J\u0013\u0010>\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020\u0007H\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001e\u00a8\u0006B"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/FollowThreadRecord;", "", "threadId", "", "name", "type", "replyCount", "", "participants", "", "parentMsgId", "isFollowThread", "", "recipient", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "group", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "replies", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;ZLcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Ljava/util/List;)V", "getGroup", "()Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "setGroup", "(Lcom/ripbull/coresdk/group/mapper/GroupRecord;)V", "()Z", "setFollowThread", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getParentMsgId", "setParentMsgId", "getParticipants", "()Ljava/util/List;", "setParticipants", "(Ljava/util/List;)V", "getRecipient", "()Lcom/ripbull/coresdk/user/mapper/UserRecord;", "setRecipient", "(Lcom/ripbull/coresdk/user/mapper/UserRecord;)V", "getReplies", "setReplies", "getReplyCount", "()I", "setReplyCount", "(I)V", "getThreadId", "setThreadId", "getType", "setType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ripbull-chat-sdk_qaDebug"})
public final class FollowThreadRecord {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String threadId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type;
    private int replyCount;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> participants;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String parentMsgId;
    private boolean isFollowThread;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.user.mapper.UserRecord recipient;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.group.mapper.GroupRecord group;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> replies;
    
    /**
     * Created by Sagar on 01/01/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.FollowThreadRecord copy(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int replyCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> participants, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord recipient, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord group, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> replies) {
        return null;
    }
    
    /**
     * Created by Sagar on 01/01/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by Sagar on 01/01/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by Sagar on 01/01/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public FollowThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int replyCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> participants, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> replies) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public FollowThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int replyCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> participants, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord recipient, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord group, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> replies) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public FollowThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int replyCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> participants, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord recipient, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> replies) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public FollowThreadRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String type, int replyCount, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> participants, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId, boolean isFollowThread, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> replies) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    public final void setThreadId(@org.jetbrains.annotations.NotNull()
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
    
    public final int getReplyCount() {
        return 0;
    }
    
    public final void setReplyCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getParticipants() {
        return null;
    }
    
    public final void setParticipants(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParentMsgId() {
        return null;
    }
    
    public final void setParentMsgId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isFollowThread() {
        return false;
    }
    
    public final void setFollowThread(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord component8() {
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
    public final com.ripbull.coresdk.group.mapper.GroupRecord component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.mapper.GroupRecord getGroup() {
        return null;
    }
    
    public final void setGroup(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> getReplies() {
        return null;
    }
    
    public final void setReplies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> p0) {
    }
}