package com.ripbull.coresdk.group.repository;

import java.lang.System;

@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001;B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u001e\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\u000b2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J0\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\u000b2\u0006\u0010#\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020\'H\u0002J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020\'2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0012H\u0016J\u0018\u00104\u001a\u00020.2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u0012H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\f06H\u0016J.\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/ripbull/coresdk/group/repository/GroupRepositoryImpl;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/group/repository/GroupRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/core/event/EventHandler;)V", "groupDao", "Lcom/ripbull/ertc/cache/database/dao/GroupDao;", "addAdmin", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "groupId", "", "user", "addParticipants", "users", "", "createPrivateGroup", "group", "createPublicGroup", "exitGroup", "getActiveGroups", "Lio/reactivex/Flowable;", "tenantId", "getGroupById", "getGroupByThreadId", "threadId", "getGroups", "getLocalGroupById", "getLocalGroups", "getRemoteGroupById", "getRemoteGroups", "getSearchedChannels", "keyword", "channelType", "joined", "isE2EFeatureEnabled", "", "noInternetConnection", "removeAdmin", "removeGroupPic", "Lcom/ripbull/coresdk/data/common/Result;", "removeParticipants", "saveGroupThread", "", "groupResponse", "Lcom/ripbull/ertc/remote/model/response/GroupResponse;", "saveGroupsInSync", "groupList", "Lcom/ripbull/ertc/cache/database/entity/Group;", "saveGroupsThread", "subscribeToGroupUpdate", "Lio/reactivex/Observable;", "updateGroupDetail", "groupName", "groupDesc", "groupImgPath", "Companion", "ripbull-chat-sdk_devDebug"})
public final class GroupRepositoryImpl extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.group.repository.GroupRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.coresdk.core.event.EventHandler eventHandler = null;
    private final com.ripbull.ertc.cache.database.dao.GroupDao groupDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.group.repository.GroupRepositoryImpl.Companion Companion = null;
    
    private GroupRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        super(null);
    }
    
    private final io.reactivex.Single<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getRemoteGroups(java.lang.String tenantId) {
        return null;
    }
    
    private final io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getLocalGroups(java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getGroups(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean saveGroupsInSync(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.ertc.cache.database.entity.Group> groupList) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> createPrivateGroup(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.group.mapper.GroupRecord group) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> updateGroupDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String groupName, @org.jetbrains.annotations.NotNull()
    java.lang.String groupDesc, @org.jetbrains.annotations.NotNull()
    java.lang.String groupImgPath) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> removeParticipants(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> users) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> addParticipants(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> users) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<com.ripbull.coresdk.group.mapper.GroupRecord> getGroupById(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId) {
        return null;
    }
    
    private final io.reactivex.Flowable<com.ripbull.coresdk.group.mapper.GroupRecord> getLocalGroupById(java.lang.String groupId) {
        return null;
    }
    
    private final io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> getRemoteGroupById(java.lang.String groupId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> getGroupByThreadId(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> addAdmin(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> removeAdmin(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId, @org.jetbrains.annotations.NotNull()
    java.lang.String user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> exitGroup(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId) {
        return null;
    }
    
    private final void saveGroupThread(com.ripbull.ertc.remote.model.response.GroupResponse groupResponse) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> removeGroupPic(@org.jetbrains.annotations.NotNull()
    java.lang.String groupId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.group.mapper.GroupRecord> subscribeToGroupUpdate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.group.mapper.GroupRecord> createPublicGroup(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.group.mapper.GroupRecord group) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getSearchedChannels(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    java.lang.String channelType, @org.jetbrains.annotations.Nullable()
    java.lang.String joined) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.group.mapper.GroupRecord>> getActiveGroups(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.group.repository.GroupRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        return null;
    }
    
    private final void saveGroupsThread(java.util.List<? extends com.ripbull.ertc.cache.database.entity.Group> groupList) {
    }
    
    private final boolean isE2EFeatureEnabled() {
        return false;
    }
    
    private final boolean noInternetConnection() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/group/repository/GroupRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/group/repository/GroupRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.group.repository.GroupRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}