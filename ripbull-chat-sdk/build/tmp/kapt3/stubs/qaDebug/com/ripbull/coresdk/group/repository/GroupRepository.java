package com.ripbull.coresdk.group.repository;

import java.lang.System;

@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0004H&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0004H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\u0006H&J\u001e\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0006H&J0\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\nH&J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#H&J.\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020\u0006H&\u00a8\u0006("}, d2 = {"Lcom/ripbull/coresdk/group/repository/GroupRepository;", "", "addAdmin", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "groupId", "", "user", "addParticipants", "users", "", "createPrivateGroup", "group", "createPublicGroup", "exitGroup", "getActiveGroups", "Lio/reactivex/Flowable;", "tenantId", "getGroupById", "getGroupByThreadId", "threadId", "getGroups", "getSearchedChannels", "keyword", "channelType", "joined", "removeAdmin", "removeGroupPic", "Lcom/ripbull/coresdk/data/common/Result;", "removeParticipants", "saveGroupsInSync", "", "groupList", "Lcom/ripbull/ertc/cache/database/entity/Group;", "subscribeToGroupUpdate", "Lio/reactivex/Observable;", "updateGroupDetail", "groupName", "groupDesc", "groupImgPath", "ripbull-chat-sdk_qaDebug"})
public abstract interface GroupRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getGroups(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    public abstract boolean saveGroupsInSync(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.ertc.cache.database.entity.Group> groupList);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> createPrivateGroup(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.group.mapper.GroupRecord group);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> updateGroupDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String groupName, @org.jetbrains.annotations.NotNull()
    java.lang.String groupDesc, @org.jetbrains.annotations.NotNull()
    java.lang.String groupImgPath);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> removeParticipants(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> users);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> addParticipants(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> users);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<com.ripbull.coresdk.group.mapper.GroupRecord> getGroupById(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> getGroupByThreadId(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> addAdmin(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String user);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> removeAdmin(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String user);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> exitGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> removeGroupPic(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.group.mapper.GroupRecord> subscribeToGroupUpdate();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> createPublicGroup(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.group.mapper.GroupRecord group);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getSearchedChannels(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    java.lang.String channelType, @org.jetbrains.annotations.Nullable()
    java.lang.String joined);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getActiveGroups(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
}