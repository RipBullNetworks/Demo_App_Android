package com.ripbull.coresdk.group.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/ripbull/coresdk/group/model/EventData;", "", "changeData", "Lcom/ripbull/coresdk/group/model/ChangeData;", "eventTriggeredOnUserList", "", "Lcom/ripbull/coresdk/group/model/EventTriggeredOnUsers;", "(Lcom/ripbull/coresdk/group/model/ChangeData;Ljava/util/List;)V", "getChangeData", "()Lcom/ripbull/coresdk/group/model/ChangeData;", "setChangeData", "(Lcom/ripbull/coresdk/group/model/ChangeData;)V", "getEventTriggeredOnUserList", "()Ljava/util/List;", "setEventTriggeredOnUserList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ripbull-chat-sdk_qaDebug"})
public final class EventData {
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.group.model.ChangeData changeData;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.ripbull.coresdk.group.model.EventTriggeredOnUsers> eventTriggeredOnUserList;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.group.model.EventData copy(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.model.ChangeData changeData, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.group.model.EventTriggeredOnUsers> eventTriggeredOnUserList) {
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
    
    public EventData(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.model.ChangeData changeData, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.group.model.EventTriggeredOnUsers> eventTriggeredOnUserList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.model.ChangeData component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.model.ChangeData getChangeData() {
        return null;
    }
    
    public final void setChangeData(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.model.ChangeData p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.group.model.EventTriggeredOnUsers> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.group.model.EventTriggeredOnUsers> getEventTriggeredOnUserList() {
        return null;
    }
    
    public final void setEventTriggeredOnUserList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.group.model.EventTriggeredOnUsers> p0) {
    }
}