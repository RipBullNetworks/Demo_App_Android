package com.ripbull.coresdk.user.repository;

import java.lang.System;

/**
 * @author meeth
 */
@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J\u001e\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001d\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0013H\u0016J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0016J\u001a\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u0017H\u0016J:\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0016J\u001c\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001d0\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H\u0016J \u0010.\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u001a\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u0001042\u0006\u0010#\u001a\u00020\u0017H\u0016J\b\u00106\u001a\u000201H\u0002J\"\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H\u0016J\u001d\u00108\u001a\u0004\u0018\u0001012\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016\u00a2\u0006\u0002\u0010:J\"\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010<\u001a\u00020=H\u0016J\u000e\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001004H\u0016J\u0010\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u000104H\u0016J:\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u00172\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006E"}, d2 = {"Lcom/ripbull/coresdk/user/repository/UserRepositoryImpl;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/user/repository/UserRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "preference", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "userDao", "Lcom/ripbull/ertc/cache/database/dao/UserDao;", "gson", "Lcom/google/gson/Gson;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/core/event/EventHandler;Lcom/ripbull/ertc/cache/preference/PreferenceManager;Lcom/ripbull/ertc/cache/database/dao/UserDao;Lcom/google/gson/Gson;)V", "deactivate", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "fetchLatestUserStatus", "getChatUsers", "Lio/reactivex/Flowable;", "", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "tenantId", "", "getChatUsersRemote", "getLastUser", "getLastUserInSync", "Lcom/ripbull/ertc/cache/database/entity/User;", "getLocalUsers", "", "getLoggedInUser", "getMentionedUsers", "getNewUsers", "addUpdateOrDelete", "getProfile", "appUserId", "getReactionedUsers", "reactionUnicodes", "msgId", "threadId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "getRemoteUsers", "getUpdatedUsers", "getUserById", "userId", "getUsersInSync", "lastUserId", "isE2EFeatureEnabled", "", "logout", "metaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/user/mapper/UserMetaDataRecord;", "noInternetConnection", "removeProfilePic", "saveUsersInSync", "userList", "(Ljava/util/List;)Ljava/lang/Boolean;", "setUserAvailability", "availabilityStatus", "Lcom/ripbull/coresdk/core/type/AvailabilityStatus;", "subscribeToLogout", "subscribeToUserMetaData", "updateProfile", "profileStatus", "mediaPath", "mediaType", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class UserRepositoryImpl extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.user.repository.UserRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.coresdk.core.event.EventHandler eventHandler = null;
    private final com.ripbull.ertc.cache.preference.PreferenceManager preference = null;
    private final com.ripbull.ertc.cache.database.dao.UserDao userDao = null;
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.user.repository.UserRepositoryImpl.Companion Companion = null;
    
    private UserRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.core.event.EventHandler eventHandler, com.ripbull.ertc.cache.preference.PreferenceManager preference, com.ripbull.ertc.cache.database.dao.UserDao userDao, com.google.gson.Gson gson) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.user.repository.UserRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        return null;
    }
    
    private final io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getLocalUsers(java.lang.String tenantId) {
        return null;
    }
    
    private final io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getRemoteUsers(java.lang.String tenantId) {
        return null;
    }
    
    private final io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getUpdatedUsers(java.lang.String tenantId, java.lang.String addUpdateOrDelete) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getNewUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String addUpdateOrDelete) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getChatUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getChatUsersRemote(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getMentionedUsers(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.user.mapper.UserRecord>> getReactionedUsers(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> reactionUnicodes, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.ripbull.ertc.cache.database.entity.User> getUsersInSync(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.user.mapper.UserRecord> getLastUser(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.ripbull.ertc.cache.database.entity.User getLastUserInSync(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Boolean saveUsersInSync(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.ertc.cache.database.entity.User> userList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<com.ripbull.coresdk.user.mapper.UserRecord> getUserById(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> logout() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> updateProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String profileStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaPath, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaType) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.user.mapper.UserRecord> getProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String appUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<com.ripbull.coresdk.user.mapper.UserRecord> getLoggedInUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> setUserAvailability(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.AvailabilityStatus availabilityStatus) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserRecord> subscribeToUserMetaData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> removeProfilePic(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> deactivate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.user.mapper.UserMetaDataRecord> metaDataOn(@org.jetbrains.annotations.NotNull()
    java.lang.String appUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> fetchLatestUserStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.data.common.Result> subscribeToLogout() {
        return null;
    }
    
    private final boolean isE2EFeatureEnabled() {
        return false;
    }
    
    private final boolean noInternetConnection() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/user/repository/UserRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/user/repository/UserRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.user.repository.UserRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}