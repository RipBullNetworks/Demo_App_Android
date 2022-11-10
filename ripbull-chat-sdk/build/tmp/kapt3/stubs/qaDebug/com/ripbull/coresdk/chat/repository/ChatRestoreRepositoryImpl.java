package com.ripbull.coresdk.chat.repository;

import java.lang.System;

/**
 * Created by DK on 08/12/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010%\u001a\u00020&H\u0016J\u000e\u0010\'\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/ChatRestoreRepositoryImpl;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/chat/repository/ChatRestoreRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "threadRepository", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "userRepository", "Lcom/ripbull/coresdk/user/repository/UserRepository;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "downloadRepository", "Lcom/ripbull/sdk/downloader/handler/DownloadRepository;", "singleChatDao", "Lcom/ripbull/ertc/cache/database/dao/SingleChatDao;", "chatThreadDao", "Lcom/ripbull/ertc/cache/database/dao/ChatThreadDao;", "chatReactionDao", "Lcom/ripbull/ertc/cache/database/dao/ChatReactionDao;", "userDao", "Lcom/ripbull/ertc/cache/database/dao/UserDao;", "ekeyDao", "Lcom/ripbull/ertc/cache/database/dao/EKeyDao;", "networkManager", "Lcom/ripbull/ertc/remote/NetworkManager;", "preference", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "mqtt", "Lcom/ripbull/ertc/mqtt/MqttManager;", "networkConfig", "Lcom/ripbull/ertc/remote/NetworkConfig;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/thread/handler/ThreadRepository;Lcom/ripbull/coresdk/user/repository/UserRepository;Lcom/ripbull/coresdk/core/event/EventHandler;Lcom/ripbull/sdk/downloader/handler/DownloadRepository;Lcom/ripbull/ertc/cache/database/dao/SingleChatDao;Lcom/ripbull/ertc/cache/database/dao/ChatThreadDao;Lcom/ripbull/ertc/cache/database/dao/ChatReactionDao;Lcom/ripbull/ertc/cache/database/dao/UserDao;Lcom/ripbull/ertc/cache/database/dao/EKeyDao;Lcom/ripbull/ertc/remote/NetworkManager;Lcom/ripbull/ertc/cache/preference/PreferenceManager;Lcom/ripbull/ertc/mqtt/MqttManager;Lcom/ripbull/ertc/remote/NetworkConfig;)V", "chatRestore", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "chatSkipRestore", "restore", "restoreType", "Lcom/ripbull/coresdk/core/type/RestoreType;", "threadRestore", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class ChatRestoreRepositoryImpl extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.chat.repository.ChatRestoreRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository = null;
    private final com.ripbull.coresdk.user.repository.UserRepository userRepository = null;
    private final com.ripbull.coresdk.core.event.EventHandler eventHandler = null;
    private final com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository = null;
    private final com.ripbull.ertc.cache.database.dao.SingleChatDao singleChatDao = null;
    private final com.ripbull.ertc.cache.database.dao.ChatThreadDao chatThreadDao = null;
    private final com.ripbull.ertc.cache.database.dao.ChatReactionDao chatReactionDao = null;
    private final com.ripbull.ertc.cache.database.dao.UserDao userDao = null;
    private final com.ripbull.ertc.cache.database.dao.EKeyDao ekeyDao = null;
    private final com.ripbull.ertc.remote.NetworkManager networkManager = null;
    private final com.ripbull.ertc.cache.preference.PreferenceManager preference = null;
    private final com.ripbull.ertc.mqtt.MqttManager mqtt = null;
    private final com.ripbull.ertc.remote.NetworkConfig networkConfig = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.repository.ChatRestoreRepositoryImpl.Companion Companion = null;
    
    private ChatRestoreRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, com.ripbull.coresdk.user.repository.UserRepository userRepository, com.ripbull.coresdk.core.event.EventHandler eventHandler, com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository, com.ripbull.ertc.cache.database.dao.SingleChatDao singleChatDao, com.ripbull.ertc.cache.database.dao.ChatThreadDao chatThreadDao, com.ripbull.ertc.cache.database.dao.ChatReactionDao chatReactionDao, com.ripbull.ertc.cache.database.dao.UserDao userDao, com.ripbull.ertc.cache.database.dao.EKeyDao ekeyDao, com.ripbull.ertc.remote.NetworkManager networkManager, com.ripbull.ertc.cache.preference.PreferenceManager preference, com.ripbull.ertc.mqtt.MqttManager mqtt, com.ripbull.ertc.remote.NetworkConfig networkConfig) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.chat.repository.ChatRestoreRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.user.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler, @org.jetbrains.annotations.NotNull()
    com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> restore(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.RestoreType restoreType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> chatRestore() {
        return null;
    }
    
    private final io.reactivex.Single<com.ripbull.coresdk.data.common.Result> threadRestore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> chatSkipRestore() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/ChatRestoreRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/chat/repository/ChatRestoreRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "threadRepository", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "userRepository", "Lcom/ripbull/coresdk/user/repository/UserRepository;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "downloadRepository", "Lcom/ripbull/sdk/downloader/handler/DownloadRepository;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.chat.repository.ChatRestoreRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.user.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler, @org.jetbrains.annotations.NotNull()
        com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository) {
            return null;
        }
    }
}