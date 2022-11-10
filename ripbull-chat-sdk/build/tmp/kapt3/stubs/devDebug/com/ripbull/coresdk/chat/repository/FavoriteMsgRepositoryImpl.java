package com.ripbull.coresdk.chat.repository;

import java.lang.System;

/**
 * @author meeth
 */
@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011BK\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002J2\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0017H\u0002J,\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00172\u0006\u0010$\u001a\u00020%H\u0002J\u001e\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0017\u0018\u00010\'2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0017\u0018\u00010\'2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cH\u0016J.\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0017\u0018\u00010)2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001cH\u0016J>\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00170,2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00172\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/FavoriteMsgRepositoryImpl;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/chat/repository/FavoriteMsgRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "chatDao", "Lcom/ripbull/ertc/cache/database/dao/SingleChatDao;", "chatThreadDao", "Lcom/ripbull/ertc/cache/database/dao/ChatThreadDao;", "threadDao", "Lcom/ripbull/ertc/cache/database/dao/ThreadDao;", "userDao", "Lcom/ripbull/ertc/cache/database/dao/UserDao;", "groupDao", "Lcom/ripbull/ertc/cache/database/dao/GroupDao;", "chatReactionDao", "Lcom/ripbull/ertc/cache/database/dao/ChatReactionDao;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/ertc/cache/database/dao/SingleChatDao;Lcom/ripbull/ertc/cache/database/dao/ChatThreadDao;Lcom/ripbull/ertc/cache/database/dao/ThreadDao;Lcom/ripbull/ertc/cache/database/dao/UserDao;Lcom/ripbull/ertc/cache/database/dao/GroupDao;Lcom/ripbull/ertc/cache/database/dao/ChatReactionDao;)V", "composeReactionList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "Lkotlin/collections/ArrayList;", "listOfReactionEntities", "", "Lcom/ripbull/ertc/cache/database/entity/ChatReactionEntity;", "compostFavMessageRecord", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "tenantId", "", "singleChatList", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "threadEmbeddeds", "Lcom/ripbull/ertc/cache/database/entity/ThreadEmbedded;", "compostFavMessageRecordForThread", "chatThreadList", "Lcom/ripbull/ertc/cache/database/entity/ChatThread;", "thread", "Lcom/ripbull/ertc/cache/database/entity/Thread;", "getAllFavoriteMessages", "Lio/reactivex/Observable;", "threadId", "Lio/reactivex/Flowable;", "parentMsgId", "markAsFavorite", "Lio/reactivex/Single;", "messages", "isFavorite", "", "noInternetConnection", "Companion", "ripbull-chat-sdk_devDebug"})
public final class FavoriteMsgRepositoryImpl extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.chat.repository.FavoriteMsgRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.ertc.cache.database.dao.SingleChatDao chatDao = null;
    private final com.ripbull.ertc.cache.database.dao.ChatThreadDao chatThreadDao = null;
    private final com.ripbull.ertc.cache.database.dao.ThreadDao threadDao = null;
    private final com.ripbull.ertc.cache.database.dao.UserDao userDao = null;
    private final com.ripbull.ertc.cache.database.dao.GroupDao groupDao = null;
    private final com.ripbull.ertc.cache.database.dao.ChatReactionDao chatReactionDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.repository.FavoriteMsgRepositoryImpl.Companion Companion = null;
    
    private FavoriteMsgRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.ertc.cache.database.dao.SingleChatDao chatDao, com.ripbull.ertc.cache.database.dao.ChatThreadDao chatThreadDao, com.ripbull.ertc.cache.database.dao.ThreadDao threadDao, com.ripbull.ertc.cache.database.dao.UserDao userDao, com.ripbull.ertc.cache.database.dao.GroupDao groupDao, com.ripbull.ertc.cache.database.dao.ChatReactionDao chatReactionDao) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.chat.repository.FavoriteMsgRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> markAsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> messages, boolean isFavorite) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Observable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    private final java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> compostFavMessageRecord(java.lang.String tenantId, java.util.List<com.ripbull.ertc.cache.database.entity.SingleChat> singleChatList, java.util.List<? extends com.ripbull.ertc.cache.database.entity.ThreadEmbedded> threadEmbeddeds) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Observable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId) {
        return null;
    }
    
    private final java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> compostFavMessageRecordForThread(java.lang.String tenantId, java.util.List<com.ripbull.ertc.cache.database.entity.ChatThread> chatThreadList, com.ripbull.ertc.cache.database.entity.Thread thread) {
        return null;
    }
    
    private final boolean noInternetConnection() {
        return false;
    }
    
    private final java.util.ArrayList<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> composeReactionList(java.util.List<com.ripbull.ertc.cache.database.entity.ChatReactionEntity> listOfReactionEntities) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/FavoriteMsgRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/chat/repository/FavoriteMsgRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.chat.repository.FavoriteMsgRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager) {
            return null;
        }
    }
}