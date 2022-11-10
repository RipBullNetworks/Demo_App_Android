package com.ripbull.coresdk.chat;

import java.lang.System;

/**
 * @author meeth
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00f8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u0002:\u0002\u0080\u0001B/\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010 \u001a\u00020\u0012H\u0016J<\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u000f2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\'0&j\b\u0012\u0004\u0012\u00020\'`(H\u0016J.\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000f2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0016J(\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00152\u0006\u0010\u0017\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0016J-\u00104\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\'2\b\u00105\u001a\u0004\u0018\u00010*H\u0016\u00a2\u0006\u0002\u00106J-\u00107\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\'2\b\u00105\u001a\u0004\u0018\u00010*H\u0016\u00a2\u0006\u0002\u00106J&\u00108\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020*H\u0016J&\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00122\u0006\u0010:\u001a\u00020*H\u0016JR\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0\"2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\"2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\"2\u0006\u00102\u001a\u0002032\b\u0010A\u001a\u0004\u0018\u00010\u00122\u0006\u0010B\u001a\u00020*H\u0016JD\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001e\u001a\u00020\'2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\"2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\"2\u0006\u00102\u001a\u0002032\b\u0010A\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u0015H\u0016J\u001c\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J$\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0E2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0012H\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u000fH\u0016J\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016J&\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0J0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0014\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0J0EH\u0016JI\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0J0\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010P\u001a\u0004\u0018\u00010\u00122\u0006\u0010Q\u001a\u00020*2\b\u0010R\u001a\u0004\u0018\u00010\u00122\b\u0010S\u001a\u0004\u0018\u00010TH\u0016\u00a2\u0006\u0002\u0010UJ?\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0J0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u00122\b\u0010R\u001a\u0004\u0018\u00010\u00122\b\u0010S\u001a\u0004\u0018\u00010TH\u0016\u00a2\u0006\u0002\u0010WJ\u001e\u0010X\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016JI\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0J0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u00122\b\u0010R\u001a\u0004\u0018\u00010\u00122\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010Z\u001a\u0004\u0018\u00010*H\u0016\u00a2\u0006\u0002\u0010[J\u0014\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0J0EH\u0016J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u000f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0014\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0J0EH\u0016J0\u0010a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020#0&j\b\u0012\u0004\u0012\u00020#`(0\u000f2\u0006\u0010b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020*0\u000fH\u0016J\b\u0010d\u001a\u00020*H\u0016J2\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\f\u0010f\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010g\u001a\u00020*H\u0016J\u001a\u0010h\u001a\u00020i2\u0006\u0010\u0017\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u000e\u0010l\u001a\b\u0012\u0004\u0012\u0002000\u0015H\u0016J(\u0010l\u001a\b\u0012\u0004\u0012\u0002000\u00152\u0006\u0010\u0017\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0016J(\u0010m\u001a\b\u0012\u0004\u0012\u0002000\u00152\u0006\u0010\u0017\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u000203H\u0016J.\u0010n\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u00109\u001a\u00020#2\u0006\u0010o\u001a\u00020\u00122\u0006\u0010p\u001a\u00020\u0012H\u0016J\u0016\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010r\u001a\u00020sH\u0016J&\u0010t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020#0&j\b\u0012\u0004\u0012\u00020#`(0\u000f2\u0006\u0010b\u001a\u00020\u0012H\u0016J(\u0010u\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\'2\b\u0010A\u001a\u0004\u0018\u00010\u0012H\u0016JA\u0010v\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\'2\b\u0010A\u001a\u0004\u0018\u00010\u00122\b\u0010w\u001a\u0004\u0018\u00010*2\b\u00105\u001a\u0004\u0018\u00010*H\u0016\u00a2\u0006\u0002\u0010xJ(\u0010y\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0016J\u001e\u0010z\u001a\b\u0012\u0004\u0012\u00020{0\u000f2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010|\u001a\u00020}H\u0016J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/ripbull/coresdk/chat/ChatModuleImpl;", "Lcom/ripbull/coresdk/module/BaseModule;", "Lcom/ripbull/coresdk/chat/ChatModule;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "chatRepository", "Lcom/ripbull/coresdk/chat/repository/ChatRepository;", "threadRepository", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "favortieMsgRespository", "Lcom/ripbull/coresdk/chat/repository/FavoriteMsgRepository;", "chatRestoreRepository", "Lcom/ripbull/coresdk/chat/repository/ChatRestoreRepository;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/chat/repository/ChatRepository;Lcom/ripbull/coresdk/thread/handler/ThreadRepository;Lcom/ripbull/coresdk/chat/repository/FavoriteMsgRepository;Lcom/ripbull/coresdk/chat/repository/ChatRestoreRepository;)V", "blockUnblock", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "action", "", "appUserId", "chatMetaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/ChatMetaDataRecord;", "threadId", "chatRestore", "chatSkipRestore", "clearChat", "copyMessage", "activity", "Landroid/app/Activity;", "message", "createThread", "recipientId", "deleteMessage", "", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "deleteType", "messageList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/model/Message;", "Lkotlin/collections/ArrayList;", "downloadMedia", "", "msgId", "serverUrl", "dirPath", "mediaType", "downloadOn", "Lcom/ripbull/coresdk/core/type/NetworkEvent;", "parentMsgId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "editE2EMessage", "isUserMentions", "(Ljava/lang/String;Lcom/ripbull/coresdk/chat/model/Message;Ljava/lang/Boolean;)Lio/reactivex/Single;", "editMessage", "followThread", "messageRecord", "isFollowed", "messageId", "forwardChat", "userList", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "groupList", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "customData", "isE2E", "forwardMediaChat", "getAllFavoriteMessages", "Lio/reactivex/Flowable;", "getChatSettings", "Lcom/ripbull/coresdk/chat/mapper/ChatSettingsRecord;", "getChatThreadMessage", "getChatThreadMessages", "", "getChatUserId", "getDomainFilters", "Lcom/ripbull/coresdk/chat/mapper/DomainDataRecord;", "getFollowThreads", "Lcom/ripbull/coresdk/chat/mapper/FollowThreadRecord;", "currentMsgId", "followedThread", "direction", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMediaGallery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMessage", "getMessages", "isGlobalSearched", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Single;", "getProfanityFilters", "Lcom/ripbull/coresdk/chat/mapper/ProfanityDataRecord;", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "getThreads", "globalSearch", "searchedText", "hasThread", "isChatRestored", "markAsFavorite", "list", "isFavorite", "markAsRead", "Lio/reactivex/Completable;", "messageMetaDataOn", "Lcom/ripbull/coresdk/chat/mapper/MessageMetaDataRecord;", "messageOn", "msgReadStatus", "reportMessage", "reportType", "reason", "restore", "restoreType", "Lcom/ripbull/coresdk/core/type/RestoreType;", "searchMessages", "sendE2EMessage", "sendMessage", "isReplyThreadDisabled", "(Ljava/lang/String;Lcom/ripbull/coresdk/chat/model/Message;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/Single;", "sendMessageAgain", "sendReaction", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "messageMetaData", "Lcom/ripbull/coresdk/chat/model/MessageMetaData;", "sourceOnMain", "Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "Companion", "ripbull-chat-sdk_devDebug"})
public final class ChatModuleImpl extends com.ripbull.coresdk.module.BaseModule implements com.ripbull.coresdk.chat.ChatModule {
    private final com.ripbull.coresdk.chat.repository.ChatRepository chatRepository = null;
    private final com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository = null;
    private final com.ripbull.coresdk.chat.repository.FavoriteMsgRepository favortieMsgRespository = null;
    private final com.ripbull.coresdk.chat.repository.ChatRestoreRepository chatRestoreRepository = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.ChatModuleImpl.Companion Companion = null;
    
    private ChatModuleImpl(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.chat.repository.ChatRepository chatRepository, com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, com.ripbull.coresdk.chat.repository.FavoriteMsgRepository favortieMsgRespository, com.ripbull.coresdk.chat.repository.ChatRestoreRepository chatRestoreRepository) {
        super(null);
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
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isReplyThreadDisabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isUserMentions) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendE2EMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> hasThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> getChatUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
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
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> msgReadStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
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
    public io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageMetaDataRecord> messageMetaDataOn(@org.jetbrains.annotations.NotNull()
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
    java.lang.String customData, boolean isE2E) {
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
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isUserMentions) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> editE2EMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isUserMentions) {
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
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> restore(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.RestoreType restoreType) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/ripbull/coresdk/chat/ChatModuleImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/chat/ChatModule;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ripbull.coresdk.chat.ChatModule newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.Nullable()
        com.ripbull.coresdk.core.event.EventHandler eventHandler) {
            return null;
        }
    }
}