package com.ripbull.coresdk.chat.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00f4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 }2\u00020\u0001:\u0001}B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0002J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010$\u001a\u00020\u000eH\u0016J<\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0\u000b2\u0006\u0010\'\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00180)j\b\u0012\u0004\u0012\u00020\u0018`*H\u0016J.\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016J(\u00100\u001a\b\u0012\u0004\u0012\u0002010\u001b2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u000204H\u0016J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u00106\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0011H\u0016J&\u00106\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0011H\u0016JJ\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180&2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0&2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0&2\u0006\u00103\u001a\u0002042\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016JD\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00020<0&2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0&2\u0006\u00103\u001a\u0002042\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0\u001bH\u0016J\u001c\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0\u001b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J$\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0A2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u000bH\u0016J\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0016J&\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150F0\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0014\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0&0AH\u0016JI\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0&0\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000e2\u0006\u0010M\u001a\u00020\u00112\b\u0010N\u001a\u0004\u0018\u00010\u000e2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016\u00a2\u0006\u0002\u0010QJ?\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u000e2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016\u00a2\u0006\u0002\u0010SJ\u001e\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0016JI\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010\u000e2\b\u0010N\u001a\u0004\u0018\u00010\u000e2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010V\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010WJ\u0014\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0&0AH\u0016J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u000b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0&0AH\u0016J0\u0010]\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00150)j\b\u0012\u0004\u0012\u00020\u0015`*0\u000b2\u0006\u0010^\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0016J\b\u0010`\u001a\u00020\u0011H\u0016J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010b\u001a\u00020\u000eH\u0002J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010b\u001a\u00020\u000eH\u0002J2\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150&0\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00150&2\u0006\u0010f\u001a\u00020\u0011H\u0016J\u001a\u0010g\u001a\u00020h2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0017J\u0016\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u001b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010k\u001a\b\u0012\u0004\u0012\u0002010\u001bH\u0016J(\u0010k\u001a\b\u0012\u0004\u0012\u0002010\u001b2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u000204H\u0016J(\u0010l\u001a\b\u0012\u0004\u0012\u0002010\u001b2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u000204H\u0016J\b\u0010m\u001a\u00020\u0001H\u0016J.\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u00152\u0006\u0010o\u001a\u00020\u000e2\u0006\u0010p\u001a\u00020\u000eH\u0016J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010r\u001a\u00020sH\u0016J&\u0010t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00150)j\b\u0012\u0004\u0012\u00020\u0015`*0\u000b2\u0006\u0010^\u001a\u00020\u000eH\u0016J(\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016J(\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0016J\u001e\u0010w\u001a\b\u0012\u0004\u0012\u00020x0\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020zH\u0016J\u000e\u0010{\u001a\b\u0012\u0004\u0012\u00020|0\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006~"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/ChatModuleHookImpl;", "Lcom/ripbull/coresdk/chat/repository/ChatModuleHook;", "chatModule", "Lcom/ripbull/coresdk/chat/ChatModule;", "stub", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "tenantDao", "Lcom/ripbull/ertc/cache/database/dao/TenantDao;", "(Lcom/ripbull/coresdk/chat/ChatModule;Lcom/ripbull/coresdk/chat/ChatModule;Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/ertc/cache/database/dao/TenantDao;)V", "blockUnblock", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "action", "", "appUserId", "canBlockUsers", "", "canSendAlerts", "canUseStarredMessaging", "chatMessage", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "threadId", "message", "Lcom/ripbull/coresdk/chat/model/Message;", "customData", "chatMetaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/ChatMetaDataRecord;", "chatRestore", "chatSkipRestore", "clearChat", "copyMessage", "activity", "Landroid/app/Activity;", "createThread", "recipientId", "deleteMessage", "", "deleteType", "messageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "downloadMedia", "msgId", "serverUrl", "dirPath", "mediaType", "downloadOn", "Lcom/ripbull/coresdk/core/type/NetworkEvent;", "parentMsgId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "editMessage", "followThread", "messageRecord", "isFollowed", "messageId", "forwardChat", "userList", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "groupList", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "forwardMediaChat", "getAllFavoriteMessages", "Lio/reactivex/Flowable;", "getChatSettings", "Lcom/ripbull/coresdk/chat/mapper/ChatSettingsRecord;", "getChatThreadMessage", "getChatThreadMessages", "", "getChatUserId", "getDomainFilters", "Lcom/ripbull/coresdk/chat/mapper/DomainDataRecord;", "getFollowThreads", "Lcom/ripbull/coresdk/chat/mapper/FollowThreadRecord;", "currentMsgId", "followedThread", "direction", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMediaGallery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMessage", "getMessages", "isGlobalSearched", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Single;", "getProfanityFilters", "Lcom/ripbull/coresdk/chat/mapper/ProfanityDataRecord;", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "getThreads", "globalSearch", "searchedText", "hasThread", "isChatRestored", "isE2EFeatureEnabled", "feature", "isFeatureEnabled", "markAsFavorite", "list", "isFavorite", "markAsRead", "Lio/reactivex/Completable;", "messageMetaDataOn", "Lcom/ripbull/coresdk/chat/mapper/MessageMetaDataRecord;", "messageOn", "msgReadStatus", "provideModule", "reportMessage", "reportType", "reason", "restore", "restoreType", "Lcom/ripbull/coresdk/core/type/RestoreType;", "searchMessages", "sendMessage", "sendMessageAgain", "sendReaction", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "messageMetaData", "Lcom/ripbull/coresdk/chat/model/MessageMetaData;", "sourceOnMain", "Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class ChatModuleHookImpl implements com.ripbull.coresdk.chat.repository.ChatModuleHook {
    private final com.ripbull.coresdk.chat.ChatModule chatModule = null;
    private final com.ripbull.coresdk.chat.ChatModule stub = null;
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.ertc.cache.database.dao.TenantDao tenantDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.repository.ChatModuleHookImpl.Companion Companion = null;
    
    private ChatModuleHookImpl(com.ripbull.coresdk.chat.ChatModule chatModule, com.ripbull.coresdk.chat.ChatModule stub, com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.ertc.cache.database.dao.TenantDao tenantDao) {
        super();
    }
    
    private final io.reactivex.Single<java.lang.Boolean> isFeatureEnabled(java.lang.String feature) {
        return null;
    }
    
    private final io.reactivex.Single<java.lang.Boolean> isE2EFeatureEnabled(java.lang.String feature) {
        return null;
    }
    
    private final io.reactivex.Single<java.lang.Boolean> canSendAlerts() {
        return null;
    }
    
    private final io.reactivex.Single<java.lang.Boolean> canBlockUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ripbull.coresdk.chat.repository.ChatModuleHook provideModule() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.thread.mapper.ThreadRecord>> getThreads() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> createThread(@org.jetbrains.annotations.NotNull()
    java.lang.String recipientId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> hasThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isGlobalSearched) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getChatThreadMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> getChatUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public io.reactivex.Completable markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> msgReadStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> messageOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> messageOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> blockUnblock(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String appUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> markAsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> list, boolean isFavorite) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> downloadMedia(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String serverUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String dirPath, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> downloadOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatMetaDataRecord> chatMetaDataOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> sendReaction(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.MessageMetaData messageMetaData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageMetaDataRecord> messageMetaDataOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatEvent> sourceOnMain() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> forwardChat(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.model.Message> messageList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.coresdk.group.mapper.GroupRecord> groupList, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> getMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> getChatThreadMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> deleteMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String deleteType, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.ripbull.coresdk.chat.model.Message> messageList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> editMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> chatRestore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> chatSkipRestore() {
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
    public io.reactivex.Single<java.util.ArrayList<com.ripbull.coresdk.chat.mapper.MessageRecord>> searchMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String searchedText) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.ArrayList<com.ripbull.coresdk.chat.mapper.MessageRecord>> globalSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String searchedText, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> followThread(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord, boolean isFollowed) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> followThread(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String messageId, boolean isFollowed) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> reportMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord, @org.jetbrains.annotations.NotNull()
    java.lang.String reportType, @org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> clearChat(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendMessageAgain(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getMediaGallery(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> forwardMediaChat(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.coresdk.group.mapper.GroupRecord> groupList, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> copyMessage(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.FollowThreadRecord>> getFollowThreads(@org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, boolean followedThread, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isChatRestored() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.ChatSettingsRecord> getChatSettings() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityDataRecord>> getProfanityFilters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.DomainDataRecord>> getDomainFilters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.thread.mapper.ThreadRecord> getThread(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId) {
        return null;
    }
    
    private final io.reactivex.Single<java.lang.Boolean> canUseStarredMessaging() {
        return null;
    }
    
    private final io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> chatMessage(java.lang.String threadId, com.ripbull.coresdk.chat.model.Message message, java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.chat.repository.ChatModuleHook newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.event.EventHandler eventHandler) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/ChatModuleHookImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/chat/repository/ChatModuleHook;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.chat.repository.ChatModuleHook newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.Nullable()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}