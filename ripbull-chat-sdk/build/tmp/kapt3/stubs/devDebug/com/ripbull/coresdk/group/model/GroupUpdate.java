package com.ripbull.coresdk.group.model;

import java.lang.System;

/**
 * Created by DK on 03/04/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0003J?\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/ripbull/coresdk/group/model/GroupUpdate;", "", "groupId", "", "threadId", "eventTriggeredByUser", "Lcom/ripbull/coresdk/group/model/EventTriggerByUser;", "eventList", "", "Lcom/ripbull/coresdk/group/model/Event;", "(Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/group/model/EventTriggerByUser;Ljava/util/List;)V", "getEventList", "()Ljava/util/List;", "setEventList", "(Ljava/util/List;)V", "getEventTriggeredByUser", "()Lcom/ripbull/coresdk/group/model/EventTriggerByUser;", "setEventTriggeredByUser", "(Lcom/ripbull/coresdk/group/model/EventTriggerByUser;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getThreadId", "setThreadId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ripbull-chat-sdk_devDebug"})
public final class GroupUpdate {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String groupId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String threadId;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.group.model.EventTriggerByUser eventTriggeredByUser;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.ripbull.coresdk.group.model.Event> eventList;
    
    /**
     * Created by DK on 03/04/19.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.group.model.GroupUpdate copy(@org.jetbrains.annotations.Nullable()
    java.lang.String groupId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.model.EventTriggerByUser eventTriggeredByUser, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.group.model.Event> eventList) {
        return null;
    }
    
    /**
     * Created by DK on 03/04/19.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 03/04/19.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 03/04/19.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public GroupUpdate(@org.jetbrains.annotations.Nullable()
    java.lang.String groupId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.model.EventTriggerByUser eventTriggeredByUser, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.group.model.Event> eventList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGroupId() {
        return null;
    }
    
    public final void setGroupId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
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
    public final com.ripbull.coresdk.group.model.EventTriggerByUser component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.model.EventTriggerByUser getEventTriggeredByUser() {
        return null;
    }
    
    public final void setEventTriggeredByUser(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.model.EventTriggerByUser p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.group.model.Event> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.group.model.Event> getEventList() {
        return null;
    }
    
    public final void setEventList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.group.model.Event> p0) {
    }
}