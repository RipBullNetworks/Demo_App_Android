package com.ripbull.coresdk.chat;

import java.lang.System;

/**
 * @author meeth
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0014\u001a\u00020\u0006H&J<\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00032\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cH&J.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H&J(\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\'H&J/\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001eH&\u00a2\u0006\u0002\u0010*J/\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001eH&\u00a2\u0006\u0002\u0010*J&\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001eH&J&\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u001eH&JV\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00162\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00162\u0006\u0010&\u001a\u00020\'2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u00106\u001a\u00020\u001eH&JF\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u001b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00162\f\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00162\u0006\u0010&\u001a\u00020\'2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006H&J\u0014\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\tH&J\u001c\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\t2\u0006\u0010\u000b\u001a\u00020\u0006H&J$\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016092\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H&J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0003H&J\u001e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H&J&\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170>0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006H&J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0>09H&JI\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0>0\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010D\u001a\u0004\u0018\u00010\u00062\u0006\u0010E\u001a\u00020\u001e2\b\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010G\u001a\u0004\u0018\u00010HH&\u00a2\u0006\u0002\u0010IJE\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170>0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH&\u00a2\u0006\u0002\u0010KJ\u001e\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H&JI\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170>0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u00062\b\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010N\u001a\u0004\u0018\u00010\u001eH&\u00a2\u0006\u0002\u0010OJ\u0014\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0>09H&J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0016\u0010T\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0>\u0018\u000109H&J2\u0010U\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u001aj\b\u0012\u0004\u0012\u00020\u0017`\u001c0\u00032\u0006\u0010V\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003H&J\b\u0010X\u001a\u00020\u001eH&J2\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00032\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010[\u001a\u00020\u001eH&J\u001a\u0010\\\u001a\u00020]2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\t2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u000e\u0010`\u001a\b\u0012\u0004\u0012\u00020$0\tH&J(\u0010`\u001a\b\u0012\u0004\u0012\u00020$0\t2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\'H&J(\u0010a\u001a\b\u0012\u0004\u0012\u00020$0\t2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\'H&J.\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u0006H&J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010f\u001a\u00020gH&J&\u0010h\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170\u001aj\b\u0012\u0004\u0012\u00020\u0017`\u001c0\u00032\u0006\u0010V\u001a\u00020\u0006H&J*\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0006H&JG\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u001b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001eH&\u00a2\u0006\u0002\u0010lJ*\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006H&J\u001e\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010p\u001a\u00020qH&J\u000e\u0010r\u001a\b\u0012\u0004\u0012\u00020s0\tH&\u00a8\u0006t"}, d2 = {"Lcom/ripbull/coresdk/chat/ChatModule;", "", "blockUnblock", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "action", "", "appUserId", "chatMetaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/ChatMetaDataRecord;", "threadId", "chatRestore", "chatSkipRestore", "clearChat", "copyMessage", "activity", "Landroid/app/Activity;", "message", "createThread", "recipientId", "deleteMessage", "", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "deleteType", "messageList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/model/Message;", "Lkotlin/collections/ArrayList;", "downloadMedia", "", "msgId", "serverUrl", "dirPath", "mediaType", "downloadOn", "Lcom/ripbull/coresdk/core/type/NetworkEvent;", "parentMsgId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "editE2EMessage", "isUserMentions", "(Ljava/lang/String;Lcom/ripbull/coresdk/chat/model/Message;Ljava/lang/Boolean;)Lio/reactivex/Single;", "editMessage", "followThread", "messageRecord", "isFollowed", "messageId", "forwardChat", "userList", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "groupList", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "customData", "isE2E", "forwardMediaChat", "getAllFavoriteMessages", "Lio/reactivex/Flowable;", "getChatSettings", "Lcom/ripbull/coresdk/chat/mapper/ChatSettingsRecord;", "getChatThreadMessage", "getChatThreadMessages", "", "getChatUserId", "getDomainFilters", "Lcom/ripbull/coresdk/chat/mapper/DomainDataRecord;", "getFollowThreads", "Lcom/ripbull/coresdk/chat/mapper/FollowThreadRecord;", "currentMsgId", "followedThread", "direction", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMediaGallery", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMessage", "getMessages", "isGlobalSearched", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Single;", "getProfanityFilters", "Lcom/ripbull/coresdk/chat/mapper/ProfanityDataRecord;", "getThread", "Lcom/ripbull/coresdk/thread/mapper/ThreadRecord;", "getThreads", "globalSearch", "searchedText", "hasThread", "isChatRestored", "markAsFavorite", "list", "isFavorite", "markAsRead", "Lio/reactivex/Completable;", "messageMetaDataOn", "Lcom/ripbull/coresdk/chat/mapper/MessageMetaDataRecord;", "messageOn", "msgReadStatus", "reportMessage", "reportType", "reason", "restore", "restoreType", "Lcom/ripbull/coresdk/core/type/RestoreType;", "searchMessages", "sendE2EMessage", "sendMessage", "isReplyThreadDisabled", "(Ljava/lang/String;Lcom/ripbull/coresdk/chat/model/Message;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/Single;", "sendMessageAgain", "sendReaction", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "messageMetaData", "Lcom/ripbull/coresdk/chat/model/MessageMetaData;", "sourceOnMain", "Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "ripbull-chat-sdk_devDebug"})
public abstract interface ChatModule {
    
    @org.jetbrains.annotations.Nullable()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.thread.mapper.ThreadRecord>> getThreads();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.String> createThread(@org.jetbrains.annotations.NotNull()
    java.lang.String recipientId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> hasThread();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isGlobalSearched);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getChatThreadMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isReplyThreadDisabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isUserMentions);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendE2EMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.String customData);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> getChatUserId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> msgReadStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> messageOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> messageOn();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> blockUnblock(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    java.lang.String appUserId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> markAsFavorite(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord> list, boolean isFavorite);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getAllFavoriteMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> downloadMedia(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String serverUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String dirPath, @org.jetbrains.annotations.NotNull()
    java.lang.String mediaType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> downloadOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatMetaDataRecord> chatMetaDataOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> sendReaction(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.MessageMetaData messageMetaData);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.MessageMetaDataRecord> messageMetaDataOn(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatEvent> sourceOnMain();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> forwardChat(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.model.Message> messageList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.coresdk.group.mapper.GroupRecord> groupList, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isE2E);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> getMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> getChatThreadMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> deleteMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String deleteType, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.ripbull.coresdk.chat.model.Message> messageList);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> editMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isUserMentions);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> editE2EMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isUserMentions);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> chatRestore();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> chatSkipRestore();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.ArrayList<com.ripbull.coresdk.chat.mapper.MessageRecord>> searchMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String searchedText);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.ArrayList<com.ripbull.coresdk.chat.mapper.MessageRecord>> globalSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String searchedText, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> restore(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.RestoreType restoreType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> followThread(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord, boolean isFollowed);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> reportMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.mapper.MessageRecord messageRecord, @org.jetbrains.annotations.NotNull()
    java.lang.String reportType, @org.jetbrains.annotations.NotNull()
    java.lang.String reason);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> clearChat(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendMessageAgain(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getMediaGallery(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> forwardMediaChat(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.coresdk.group.mapper.GroupRecord> groupList, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType, @org.jetbrains.annotations.Nullable()
    java.lang.String customData);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.String> copyMessage(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.FollowThreadRecord>> getFollowThreads(@org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, boolean followedThread, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.data.common.Result> followThread(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String messageId, boolean isFollowed);
    
    public abstract boolean isChatRestored();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.chat.mapper.ChatSettingsRecord> getChatSettings();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityDataRecord>> getProfanityFilters();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Flowable<java.util.List<com.ripbull.coresdk.chat.mapper.DomainDataRecord>> getDomainFilters();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<com.ripbull.coresdk.thread.mapper.ThreadRecord> getThread(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId);
    
    /**
     * @author meeth
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}