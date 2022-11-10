package com.ripbull.coresdk.chat;

import java.lang.System;

/**
 * @author meeth
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 w2\u00020\u0001:\u0001wB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0017\u001a\u00020\tH\u0016J<\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00062\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fH\u0016J.\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016J(\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010)\u001a\u00020*H\u0016J-\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0002\u0010-J-\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0002\u0010-J&\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020!H\u0016J&\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020!H\u0016JR\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00192\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00192\u0006\u0010)\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020!H\u0016JD\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0015\u001a\u00020\u001e2\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00192\u0006\u0010)\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010\tH\u0016J\u0014\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\fH\u0016J\u001c\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016J$\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190<2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0006H\u0016J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0016J&\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0A0\u00062\u0006\u0010\u000e\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0014\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0A0<H\u0016JI\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0A0\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010\t2\u0006\u0010H\u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010\t2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016\u00a2\u0006\u0002\u0010LJ?\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0A0\u00062\u0006\u0010\u000e\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\t2\b\u0010I\u001a\u0004\u0018\u00010\t2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016\u00a2\u0006\u0002\u0010NJ\u001e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0016JI\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0A0\u00062\u0006\u0010\u000e\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\t2\b\u0010I\u001a\u0004\u0018\u00010\t2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010Q\u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0002\u0010RJ\u0014\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0A0<H\u0016J\u0016\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0014\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0A0<H\u0016J0\u0010X\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u001dj\b\u0012\u0004\u0012\u00020\u001a`\u001f0\u00062\u0006\u0010Y\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020!0\u0006H\u0016J\b\u0010[\u001a\u00020!H\u0016J2\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00062\u0006\u0010\u000e\u001a\u00020\t2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010^\u001a\u00020!H\u0016J\u001a\u0010_\u001a\u00020`2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020b0\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020\'0\fH\u0016J(\u0010c\u001a\b\u0012\u0004\u0012\u00020\'0\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010)\u001a\u00020*H\u0016J(\u0010d\u001a\b\u0012\u0004\u0012\u00020\'0\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010)\u001a\u00020*H\u0016J.\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u00100\u001a\u00020\u001a2\u0006\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\tH\u0016J\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010i\u001a\u00020jH\u0016J&\u0010k\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u001dj\b\u0012\u0004\u0012\u00020\u001a`\u001f0\u00062\u0006\u0010Y\u001a\u00020\tH\u0016J(\u0010l\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001e2\b\u00108\u001a\u0004\u0018\u00010\tH\u0016JA\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u001e2\b\u00108\u001a\u0004\u0018\u00010\t2\b\u0010n\u001a\u0004\u0018\u00010!2\b\u0010,\u001a\u0004\u0018\u00010!H\u0016\u00a2\u0006\u0002\u0010oJ(\u0010p\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\tH\u0016J\u001e\u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010s\u001a\u00020tH\u0016J\u000e\u0010u\u001a\b\u0012\u0004\u0012\u00020v0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006x"}, d2 = {"Lcom/ripbull/coresdk/chat/ChatModuleStub;", "Lcom/ripbull/coresdk/chat/ChatModule;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "blockUnblock", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "action", "", "appUserId", "chatMetaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/ChatMetaDataRecord;", "threadId", "chatRestore", "chatSkipRestore", "clearChat", "copyMessage", "activity", "Landroid/app/Activity;", "message", "createThread", "recipientId", "deleteMessage", "", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "deleteType", "messageList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/model/Message;", "Lkotlin/collections/ArrayList;", "downloadMedia", "", "msgId", "serverUrl", "dirPath", "mediaType", "downloadOn", "Lcom/ripbull/coresdk/core/type/NetworkEvent;", "parentMsgId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "editE2EMessage", "isUserMentions", "(Ljava/lang/String;Lcom/ripbull/coresdk/chat/model/Message;Ljava/lang/Boolean;)Lio/reactivex/Single;", "editMessage", "followThread", "messageRecord", "isFollowed", "messageId", "forwardChat", "userList", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "groupList", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "customData", "isE2E", "forwardMediaChat", "getAllFavoriteMessages", "Lio/reactivex/Flowable;", "getChatSettings", "Lcom/ripbull/coresdk/chat/mapper/ChatSettingsRecord;", "getChatThreadMessage", "getChatThreadMessages", "", "getChatUserId", "getDomainFilters", "Lcom/ripbull/coresdk/chat/mapper/DomainDataRecord;", "getFollowThreads", "Lcom/ripbull/coresdk/chat/mapper/FollowThreadRecord;", "currentMsgId", "followedThread", "direction", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMediaGallery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMessage", "getMessages", "isGlobalSearched", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Single;", "getProfanityFilters", "Lcom/ripbull/coresdk/chat/mapper/ProfanityDataRecord;", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "getThreads", "globalSearch", "searchedText", "hasThread", "isChatRestored", "markAsFavorite", "list", "isFavorite", "markAsRead", "Lio/reactivex/Completable;", "messageMetaDataOn", "Lcom/ripbull/coresdk/chat/mapper/MessageMetaDataRecord;", "messageOn", "msgReadStatus", "reportMessage", "reportType", "reason", "restore", "restoreType", "Lcom/ripbull/coresdk/core/type/RestoreType;", "searchMessages", "sendE2EMessage", "sendMessage", "isReplyThreadDisabled", "(Ljava/lang/String;Lcom/ripbull/coresdk/chat/model/Message;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/Single;", "sendMessageAgain", "sendReaction", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "messageMetaData", "Lcom/ripbull/coresdk/chat/model/MessageMetaData;", "sourceOnMain", "Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "Companion", "ripbull-chat-sdk_devDebug"})
public final class ChatModuleStub implements com.ripbull.coresdk.chat.ChatModule {
    private final android.content.Context appContext = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.chat.ChatModuleStub.Companion Companion = null;
    
    private ChatModuleStub(android.content.Context appContext) {
        super();
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
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendE2EMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
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
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> deleteMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String deleteType, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.ripbull.coresdk.chat.model.Message> messageList) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/chat/ChatModuleStub$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/chat/ChatModule;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ripbull.coresdk.chat.ChatModule newInstance() {
            return null;
        }
    }
}