package com.ripbull.coresdk.thread.handler;

import java.lang.System;

/**
 * Created by DK on 24/02/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00032\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0004H&J\u001e\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0011\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0004H&J6\u0010\u0012\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u00130\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J<\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&\u00a8\u0006\u001c"}, d2 = {"Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "", "createThread", "Lio/reactivex/Single;", "", "tenantId", "currentUser", "Lcom/ripbull/ertc/cache/database/entity/User;", "recipientUser", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "threadId", "getThreadByIdAsync", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "getThreadByIdSync", "getThreads", "Lio/reactivex/Flowable;", "", "hasThread", "", "Lcom/ripbull/ertc/cache/database/entity/ThreadUserLink;", "insertThreadData", "", "response", "Lcom/ripbull/ertc/remote/model/response/CreateThreadResponse;", "chatUserId", "lastMessage", "Lcom/ripbull/ertc/remote/model/response/MessageResponse;", "ripbull-chat-sdk_devDebug"})
public abstract interface ThreadRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.ripbull.ertc.cache.database.entity.Thread getThreadByIdSync(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.ertc.cache.database.entity.Thread> getThreadByIdAsync(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.String> createThread(@org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User currentUser, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User recipientUser);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.ertc.cache.database.entity.ThreadUserLink>> hasThread(@org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User currentUser, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.User recipientUser);
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.thread.mapper.ThreadRecord>> getThreads(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId);
    
    public abstract void insertThreadData(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.remote.model.response.CreateThreadResponse response, @org.jetbrains.annotations.NotNull()
    java.lang.String chatUserId, @org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.User currentUser, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.User recipientUser, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.response.MessageResponse lastMessage);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.thread.mapper.ThreadRecord> getThread(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    /**
     * Created by DK on 24/02/19.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}