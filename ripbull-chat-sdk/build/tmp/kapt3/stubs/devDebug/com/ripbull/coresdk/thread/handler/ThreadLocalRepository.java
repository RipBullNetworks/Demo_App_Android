package com.ripbull.coresdk.thread.handler;

import java.lang.System;

/**
 * Created by DK on 24/02/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ.\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\f2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001a0\u00192\u0006\u0010\u000e\u001a\u00020\rH\u0016J6\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001c0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J:\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/ripbull/coresdk/thread/handler/ThreadLocalRepository;", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "threadDao", "Lcom/ripbull/ertc/cache/database/dao/ThreadDao;", "userDao", "Lcom/ripbull/ertc/cache/database/dao/UserDao;", "groupDao", "Lcom/ripbull/ertc/cache/database/dao/GroupDao;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/ertc/cache/database/dao/ThreadDao;Lcom/ripbull/ertc/cache/database/dao/UserDao;Lcom/ripbull/ertc/cache/database/dao/GroupDao;)V", "createThread", "Lio/reactivex/Single;", "", "tenantId", "currentUser", "Lcom/ripbull/ertc/cache/database/entity/User;", "recipientUser", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "threadId", "getThreadByIdAsync", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "getThreadByIdSync", "getThreads", "Lio/reactivex/Flowable;", "", "hasThread", "", "Lcom/ripbull/ertc/cache/database/entity/ThreadUserLink;", "insertThreadData", "", "response", "Lcom/ripbull/ertc/remote/model/response/CreateThreadResponse;", "chatUserId", "lastMessage", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "ripbull-chat-sdk_devDebug"})
public final class ThreadLocalRepository implements com.ripbull.coresdk.thread.handler.ThreadRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.ertc.cache.database.dao.ThreadDao threadDao = null;
    private final com.ripbull.ertc.cache.database.dao.UserDao userDao = null;
    private final com.ripbull.ertc.cache.database.dao.GroupDao groupDao = null;
    
    public ThreadLocalRepository(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.ThreadDao threadDao, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.UserDao userDao, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.dao.GroupDao groupDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.ripbull.ertc.cache.database.entity.Thread getThreadByIdSync(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.ertc.cache.database.entity.Thread> getThreadByIdAsync(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> createThread(@org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User currentUser, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User recipientUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.ertc.cache.database.entity.ThreadUserLink>> hasThread(@org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User currentUser, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User recipientUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.thread.mapper.ThreadRecord>> getThreads(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @java.lang.Override()
    public void insertThreadData(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.CreateThreadResponse response, @org.jetbrains.annotations.NotNull()
    java.lang.String chatUserId, @org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.User currentUser, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.User recipientUser, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.response.MessageResponse lastMessage) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.thread.mapper.ThreadRecord> getThread(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
}