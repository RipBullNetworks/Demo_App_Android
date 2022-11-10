package com.ripbull.coresdk.chat.model;

import java.lang.System;

/**
 * Created by DK on 2020-02-23.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B\u00b9\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0002\u0010\u001dJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u001aH\u00c6\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010:J\u000b\u0010F\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u00c4\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00c6\u0001\u00a2\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u001a2\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010O\u001a\u00020\u0007H\u00d6\u0001J\t\u0010P\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010-R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010*R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:\u00a8\u0006Q"}, d2 = {"Lcom/ripbull/coresdk/chat/model/Message;", "", "message", "", "parentMsgId", "msgId", "sendToChannel", "", "media", "Lcom/ripbull/coresdk/chat/model/Media;", "file", "Lcom/ripbull/coresdk/chat/model/File;", "giphy", "Lcom/ripbull/coresdk/chat/model/Giphy;", "contact", "Lcom/ripbull/coresdk/chat/model/Contact;", "location", "Lcom/ripbull/coresdk/chat/model/Location;", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "mentions", "Lcom/ripbull/coresdk/core/type/MentionType;", "mentioned_users", "", "forwardMsgId", "isForwardMessage", "", "clientCreatedAt", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/ripbull/coresdk/chat/model/Media;Lcom/ripbull/coresdk/chat/model/File;Lcom/ripbull/coresdk/chat/model/Giphy;Lcom/ripbull/coresdk/chat/model/Contact;Lcom/ripbull/coresdk/chat/model/Location;Lcom/ripbull/coresdk/core/type/ChatType;Lcom/ripbull/coresdk/core/type/MentionType;Ljava/util/List;Ljava/lang/String;ZLjava/lang/Long;)V", "getChatType", "()Lcom/ripbull/coresdk/core/type/ChatType;", "getClientCreatedAt", "()Ljava/lang/Long;", "setClientCreatedAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getContact", "()Lcom/ripbull/coresdk/chat/model/Contact;", "getFile", "()Lcom/ripbull/coresdk/chat/model/File;", "getForwardMsgId", "()Ljava/lang/String;", "getGiphy", "()Lcom/ripbull/coresdk/chat/model/Giphy;", "()Z", "getLocation", "()Lcom/ripbull/coresdk/chat/model/Location;", "getMedia", "()Lcom/ripbull/coresdk/chat/model/Media;", "getMentioned_users", "()Ljava/util/List;", "getMentions", "()Lcom/ripbull/coresdk/core/type/MentionType;", "getMessage", "getMsgId", "getParentMsgId", "getSendToChannel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/ripbull/coresdk/chat/model/Media;Lcom/ripbull/coresdk/chat/model/File;Lcom/ripbull/coresdk/chat/model/Giphy;Lcom/ripbull/coresdk/chat/model/Contact;Lcom/ripbull/coresdk/chat/model/Location;Lcom/ripbull/coresdk/core/type/ChatType;Lcom/ripbull/coresdk/core/type/MentionType;Ljava/util/List;Ljava/lang/String;ZLjava/lang/Long;)Lcom/ripbull/coresdk/chat/model/Message;", "equals", "other", "hashCode", "toString", "ripbull-chat-sdk_qaDebug"})
public final class Message {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parentMsgId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String msgId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer sendToChannel = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.model.Media media = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.model.File file = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.model.Giphy giphy = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.model.Contact contact = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.model.Location location = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ripbull.coresdk.core.type.ChatType chatType = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.core.type.MentionType mentions = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> mentioned_users = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String forwardMsgId = null;
    private final boolean isForwardMessage = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long clientCreatedAt;
    
    /**
     * Created by DK on 2020-02-23.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.model.Message copy(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Media media, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.File file, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Giphy giphy, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Contact contact, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Location location, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MentionType mentions, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mentioned_users, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgId, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt) {
        return null;
    }
    
    /**
     * Created by DK on 2020-02-23.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 2020-02-23.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 2020-02-23.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Message(@org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Media media, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.File file, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Giphy giphy, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Contact contact, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.model.Location location, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MentionType mentions, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> mentioned_users, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgId, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
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
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSendToChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Media component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Media getMedia() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.File component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.File getFile() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Giphy component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Giphy getGiphy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Contact component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Contact getContact() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Location component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.model.Location getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.type.ChatType component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.type.ChatType getChatType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.MentionType component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.MentionType getMentions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getMentioned_users() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getForwardMsgId() {
        return null;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean isForwardMessage() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getClientCreatedAt() {
        return null;
    }
    
    public final void setClientCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
}