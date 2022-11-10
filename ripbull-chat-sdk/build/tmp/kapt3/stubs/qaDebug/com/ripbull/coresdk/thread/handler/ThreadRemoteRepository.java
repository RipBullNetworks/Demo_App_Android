package com.ripbull.coresdk.thread.handler;

import java.lang.System;

/**
 * Created by DK on 24/02/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0002J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u001e\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\u0007H\u0016J6\u0010\u0016\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00170\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J:\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/ripbull/coresdk/thread/handler/ThreadRemoteRepository;", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "(Lcom/ripbull/coresdk/data/DataManager;)V", "createThread", "Lio/reactivex/Single;", "", "tenantId", "currentUser", "Lcom/ripbull/ertc/cache/database/entity/User;", "recipientUser", "data", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "threadId", "getThreadByIdAsync", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "getThreadByIdSync", "getThreads", "Lio/reactivex/Flowable;", "", "hasThread", "", "Lcom/ripbull/ertc/cache/database/entity/ThreadUserLink;", "insertThreadData", "", "response", "Lcom/ripbull/ertc/remote/model/response/CreateThreadResponse;", "chatUserId", "lastMessage", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "noInternetConnection", "", "ripbull-chat-sdk_qaDebug"})
public final class ThreadRemoteRepository implements com.ripbull.coresdk.thread.handler.ThreadRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    
    public ThreadRemoteRepository(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        super();
    }
    
    private final com.ripbull.coresdk.data.DataManager data() {
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.thread.mapper.ThreadRecord>> getThreads(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    private final boolean noInternetConnection() {
        return false;
    }
}