package com.ripbull.coresdk.thread.handler;

import java.lang.System;

/**
 * Created by DK on 24/02/19.
 */
@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00062\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u001e\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u0007H\u0016J6\u0010\u0015\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00160\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J:\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/ripbull/coresdk/thread/handler/ThreadRepositoryImpl;", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "local", "remote", "(Lcom/ripbull/coresdk/thread/handler/ThreadRepository;Lcom/ripbull/coresdk/thread/handler/ThreadRepository;)V", "createThread", "Lio/reactivex/Single;", "", "tenantId", "currentUser", "Lcom/ripbull/ertc/cache/database/entity/User;", "recipientUser", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "threadId", "getThreadByIdAsync", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "getThreadByIdSync", "getThreads", "Lio/reactivex/Flowable;", "", "hasThread", "", "Lcom/ripbull/ertc/cache/database/entity/ThreadUserLink;", "insertThreadData", "", "response", "Lcom/ripbull/ertc/remote/model/response/CreateThreadResponse;", "chatUserId", "lastMessage", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class ThreadRepositoryImpl implements com.ripbull.coresdk.thread.handler.ThreadRepository {
    private final com.ripbull.coresdk.thread.handler.ThreadRepository local = null;
    private final com.ripbull.coresdk.thread.handler.ThreadRepository remote = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.thread.handler.ThreadRepositoryImpl.Companion Companion = null;
    
    private ThreadRepositoryImpl(com.ripbull.coresdk.thread.handler.ThreadRepository local, com.ripbull.coresdk.thread.handler.ThreadRepository remote) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.thread.handler.ThreadRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
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
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.thread.mapper.ThreadRecord>> getThreads(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/ripbull/coresdk/thread/handler/ThreadRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.thread.handler.ThreadRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager) {
            return null;
        }
    }
}