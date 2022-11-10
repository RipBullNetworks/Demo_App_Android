package com.ripbull.coresdk.user.repository;

import java.lang.System;

/**
 * @author meeth
 */
@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u001e\u0010\u0006\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007H&J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH&J\u001a\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u000bH&J:\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH&J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH&J$\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\u001a\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0006\u0010\u0015\u001a\u00020\u000bH&J\"\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH&J\u001d\u0010%\u001a\u0004\u0018\u00010&2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000f0(H&\u00a2\u0006\u0002\u0010)J\"\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\"H&J\u0010\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\"H&J:\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH&\u00a8\u00063"}, d2 = {"Lcom/ripbull/coresdk/user/repository/UserRepository;", "", "deactivate", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "fetchLatestUserStatus", "getChatUsers", "Lio/reactivex/Flowable;", "", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "tenantId", "", "getChatUsersRemote", "getLastUser", "getLastUserInSync", "Lcom/ripbull/ertc/cache/database/entity/User;", "getLoggedInUser", "getMentionedUsers", "getNewUsers", "addUpdateOrDelete", "getProfile", "appUserId", "getReactionedUsers", "reactionUnicodes", "msgId", "threadId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "getUserById", "userId", "getUsersInSync", "lastUserId", "logout", "metaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/user/mapper/UserMetaDataRecord;", "removeProfilePic", "saveUsersInSync", "", "userList", "", "(Ljava/util/List;)Ljava/lang/Boolean;", "setUserAvailability", "availabilityStatus", "Lcom/ripbull/coresdk/core/type/AvailabilityStatus;", "subscribeToLogout", "subscribeToUserMetaData", "updateProfile", "profileStatus", "mediaPath", "mediaType", "ripbull-chat-sdk_qaDebug"})
public abstract interface UserRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getNewUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String addUpdateOrDelete);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getChatUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getChatUsersRemote(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getMentionedUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getReactionedUsers(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> reactionUnicodes, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.List<com.ripbull.ertc.cache.database.entity.User> getUsersInSync(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastUserId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.user.mapper.UserRecord> getLastUser(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.ripbull.ertc.cache.database.entity.User getLastUserInSync(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Boolean saveUsersInSync(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.ertc.cache.database.entity.User> userList);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<com.ripbull.coresdk.user.mapper.UserRecord> getUserById(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> logout();
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> updateProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String profileStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaPath, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaType);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.user.mapper.UserRecord> getProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String appUserId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<com.ripbull.coresdk.user.mapper.UserRecord> getLoggedInUser();
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> setUserAvailability(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.AvailabilityStatus availabilityStatus);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> subscribeToUserMetaData();
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> removeProfilePic(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> deactivate();
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserMetaDataRecord> metaDataOn(@org.jetbrains.annotations.NotNull()
    java.lang.String appUserId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> fetchLatestUserStatus();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.data.common.Result> subscribeToLogout();
}