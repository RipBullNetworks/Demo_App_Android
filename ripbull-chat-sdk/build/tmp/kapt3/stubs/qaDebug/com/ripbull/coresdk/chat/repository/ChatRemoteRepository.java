package com.ripbull.coresdk.chat.repository;

import java.lang.System;

/**
 * Created by DK on 08/12/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a8\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0089\u00012\u00020\u00012\u00020\u0002:\u0002\u0089\u0001B\u0081\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&2\u0006\u0010(\u001a\u00020\"H\u0016J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010(\u001a\u00020\"H\u0016J(\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/H\u0002J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\"0\u001f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\"H\u0016J<\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060/0\u001f2\u0006\u00107\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u0002090+j\b\u0012\u0004\u0012\u000209`-H\u0016J.\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u001f2\u0006\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"H\u0016J0\u0010@\u001a\b\u0012\u0004\u0012\u00020A0&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010\"2\u0006\u0010C\u001a\u00020DH\u0016JB\u0010E\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u00104\u001a\u0002092\u0006\u0010F\u001a\u00020\"2\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020H\u0018\u00010+j\n\u0012\u0004\u0012\u00020H\u0018\u0001`-H\u0016J\u001e\u0010I\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u00104\u001a\u000209H\u0016J&\u0010J\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010K\u001a\u0002062\u0006\u0010L\u001a\u00020;H\u0016J&\u0010J\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010M\u001a\u00020\"2\u0006\u0010L\u001a\u00020;H\u0016Jb\u0010N\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090/2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0/2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0/2\u0006\u0010F\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\"2\u0006\u0010T\u001a\u00020;H\u0016JT\u0010U\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010V\u001a\u0002092\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0/2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0/2\u0006\u0010F\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\b\u0010S\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u001fH\u0016J\u001e\u0010Y\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"H\u0016J,\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060[0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"H\u0016J4\u0010\\\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010]\u001a\u0004\u0018\u00010\"2\b\u0010^\u001a\u0004\u0018\u00010\"2\b\u0010F\u001a\u0004\u0018\u00010\"H\u0016J\u0014\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0[0`H\u0016JI\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0[0\u001f2\b\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010d\u001a\u0004\u0018\u00010\"2\u0006\u0010e\u001a\u00020;2\b\u0010f\u001a\u0004\u0018\u00010\"2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016\u00a2\u0006\u0002\u0010iJO\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060[0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010k\u001a\u00020\"2\b\u0010d\u001a\u0004\u0018\u00010\"2\b\u0010f\u001a\u0004\u0018\u00010\"2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016\u00a2\u0006\u0002\u0010lJ\u001e\u0010m\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"H\u0016JQ\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060[0\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\b\u0010d\u001a\u0004\u0018\u00010\"2\b\u0010f\u001a\u0004\u0018\u00010\"2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010o\u001a\u0004\u0018\u00010;H\u0016\u00a2\u0006\u0002\u0010pJ\u0014\u0010q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0[0`H\u0016J0\u0010s\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060+j\b\u0012\u0004\u0012\u000206`-0\u001f2\u0006\u0010t\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010u\u001a\u00020;H\u0016J$\u0010v\u001a\u00020w2\u0006\u0010!\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010B\u001a\u0004\u0018\u00010\"H\u0016J\u0016\u0010x\u001a\b\u0012\u0004\u0012\u00020y0&2\u0006\u0010(\u001a\u00020\"H\u0016J\u0016\u0010z\u001a\b\u0012\u0004\u0012\u00020A0&2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010z\u001a\b\u0012\u0004\u0012\u00020A0&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010\"2\u0006\u0010C\u001a\u00020DH\u0016J0\u0010{\u001a\b\u0012\u0004\u0012\u00020A0&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010\"2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010|\u001a\u00020;H\u0002J.\u0010}\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010K\u001a\u0002062\u0006\u0010~\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020\"H\u0016J\'\u0010\u0080\u0001\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002060+j\b\u0012\u0004\u0012\u000206`-0\u001f2\u0006\u0010t\u001a\u00020\"H\u0016JU\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u00104\u001a\u0002092\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"2\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020H\u0018\u00010+j\n\u0012\u0004\u0012\u00020H\u0018\u0001`-2\b\u0010S\u001a\u0004\u0018\u00010\"H\u0016J9\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u00104\u001a\u0002092\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"2\b\u0010S\u001a\u0004\u0018\u00010\"H\u0016J)\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u0002060\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010<\u001a\u00020\"2\b\u0010B\u001a\u0004\u0018\u00010\"H\u0016J!\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020,0\u001f2\u0006\u0010(\u001a\u00020\"2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u0018\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010&2\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/ChatRemoteRepository;", "Lcom/ripbull/coresdk/core/base/BaseRepository;", "Lcom/ripbull/coresdk/chat/repository/ChatRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "threadRepository", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "downloadRepository", "Lcom/ripbull/sdk/downloader/handler/DownloadRepository;", "singleChatDao", "Lcom/ripbull/ertc/cache/database/dao/SingleChatDao;", "chatThreadDao", "Lcom/ripbull/ertc/cache/database/dao/ChatThreadDao;", "chatReactionDao", "Lcom/ripbull/ertc/cache/database/dao/ChatReactionDao;", "userDao", "Lcom/ripbull/ertc/cache/database/dao/UserDao;", "ekeyDao", "Lcom/ripbull/ertc/cache/database/dao/EKeyDao;", "networkManager", "Lcom/ripbull/ertc/remote/NetworkManager;", "preference", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "mqtt", "Lcom/ripbull/ertc/mqtt/MqttManager;", "networkConfig", "Lcom/ripbull/ertc/remote/NetworkConfig;", "(Lcom/ripbull/coresdk/data/DataManager;Lcom/ripbull/coresdk/thread/handler/ThreadRepository;Lcom/ripbull/coresdk/core/event/EventHandler;Lcom/ripbull/sdk/downloader/handler/DownloadRepository;Lcom/ripbull/ertc/cache/database/dao/SingleChatDao;Lcom/ripbull/ertc/cache/database/dao/ChatThreadDao;Lcom/ripbull/ertc/cache/database/dao/ChatReactionDao;Lcom/ripbull/ertc/cache/database/dao/UserDao;Lcom/ripbull/ertc/cache/database/dao/EKeyDao;Lcom/ripbull/ertc/remote/NetworkManager;Lcom/ripbull/ertc/cache/preference/PreferenceManager;Lcom/ripbull/ertc/mqtt/MqttManager;Lcom/ripbull/ertc/remote/NetworkConfig;)V", "blockUnblockUser", "Lio/reactivex/Single;", "Lcom/ripbull/coresdk/data/common/Result;", "tenantId", "", "action", "appUserId", "chatMetaDataOn", "Lio/reactivex/Observable;", "Lcom/ripbull/coresdk/chat/mapper/ChatMetaDataRecord;", "threadId", "clearChat", "composeReactionList", "Ljava/util/ArrayList;", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "Lkotlin/collections/ArrayList;", "reactions", "", "Lcom/ripbull/ertc/remote/model/response/Reactions;", "copyMessage", "activity", "Landroid/app/Activity;", "message", "deleteMessage", "Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "deleteType", "messageList", "Lcom/ripbull/coresdk/chat/model/Message;", "downloadMedia", "", "msgId", "serverUrl", "dirPath", "mediaType", "downloadOn", "Lcom/ripbull/coresdk/core/type/NetworkEvent;", "parentMsgId", "chatType", "Lcom/ripbull/coresdk/core/type/ChatType;", "editE2EMessage", "deviceId", "parallelDeviceList", "Lcom/ripbull/ertc/cache/database/entity/EKeyTable;", "editMessage", "followThread", "messageRecord", "isFollowed", "messageId", "forwardChat", "userList", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "groupList", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "customData", "isE2E", "forwardMediaChat", "Message", "getChatSettings", "Lcom/ripbull/coresdk/chat/mapper/ChatSettingsRecord;", "getChatThreadMessage", "getChatThreadMessages", "", "getChatUserId", "userId", "fcmToken", "getDomainFilters", "Lio/reactivex/Flowable;", "Lcom/ripbull/coresdk/chat/mapper/DomainDataRecord;", "getFollowThreads", "Lcom/ripbull/coresdk/chat/mapper/FollowThreadRecord;", "currentMsgId", "followedThread", "direction", "pageSize", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMediaGallery", "msgType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Single;", "getMessage", "getMessages", "isGlobalSearched", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Single;", "getProfanityFilters", "Lcom/ripbull/coresdk/chat/mapper/ProfanityDataRecord;", "globalSearch", "searchedText", "isChatRestored", "markAsRead", "Lio/reactivex/Completable;", "messageMetaDataOn", "Lcom/ripbull/coresdk/chat/mapper/MessageMetaDataRecord;", "messageOn", "msgReadStatus", "noInternetConnection", "reportMessage", "reportType", "reason", "searchMessages", "sendE2EMessage", "sendMessage", "sendMessageAgain", "sendReaction", "messageMetaData", "Lcom/ripbull/coresdk/chat/model/MessageMetaData;", "sourceOnMain", "Lcom/ripbull/coresdk/chat/mapper/ChatEvent;", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class ChatRemoteRepository extends com.ripbull.coresdk.core.base.BaseRepository implements com.ripbull.coresdk.chat.repository.ChatRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    private final com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository = null;
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
    public static final com.ripbull.coresdk.chat.repository.ChatRemoteRepository.Companion Companion = null;
    
    private ChatRemoteRepository(com.ripbull.coresdk.data.DataManager dataManager, com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, com.ripbull.coresdk.core.event.EventHandler eventHandler, com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository, com.ripbull.ertc.cache.database.dao.SingleChatDao singleChatDao, com.ripbull.ertc.cache.database.dao.ChatThreadDao chatThreadDao, com.ripbull.ertc.cache.database.dao.ChatReactionDao chatReactionDao, com.ripbull.ertc.cache.database.dao.UserDao userDao, com.ripbull.ertc.cache.database.dao.EKeyDao ekeyDao, com.ripbull.ertc.remote.NetworkManager networkManager, com.ripbull.ertc.cache.preference.PreferenceManager preference, com.ripbull.ertc.mqtt.MqttManager mqtt, com.ripbull.ertc.remote.NetworkConfig networkConfig) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.coresdk.chat.repository.ChatRemoteRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.event.EventHandler eventHandler, @org.jetbrains.annotations.NotNull()
    com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isGlobalSearched) {
        return null;
    }
    
    private final java.util.ArrayList<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> composeReactionList(java.util.List<com.ripbull.ertc.remote.model.response.Reactions> reactions) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.ripbull.coresdk.chat.mapper.MessageRecord>> getChatThreadMessages(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendMessage(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> sendE2EMessage(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.ripbull.ertc.cache.database.entity.EKeyTable> parallelDeviceList, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> getChatUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String userId, @org.jetbrains.annotations.Nullable()
    java.lang.String fcmToken, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable markAsRead(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> blockUnblockUser(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String action, @org.jetbrains.annotations.Nullable()
    java.lang.String appUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> messageOn(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> messageOn(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> msgReadStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<com.ripbull.coresdk.core.type.NetworkEvent> downloadOn(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.ChatType chatType) {
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
    public io.reactivex.Observable<com.ripbull.coresdk.chat.mapper.ChatEvent> sourceOnMain(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> forwardChat(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.chat.model.Message> messageList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.coresdk.group.mapper.GroupRecord> groupList, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull()
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
    com.ripbull.coresdk.chat.model.Message message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.chat.mapper.MessageRecord> editE2EMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message message, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.ripbull.ertc.cache.database.entity.EKeyTable> parallelDeviceList) {
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
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    java.lang.String threadId, @org.jetbrains.annotations.NotNull()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String currentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String direction, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pageSize) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<com.ripbull.coresdk.data.common.Result> forwardMediaChat(@org.jetbrains.annotations.NotNull()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.chat.model.Message Message, @org.jetbrains.annotations.NotNull()
    java.util.List<com.ripbull.coresdk.user.mapper.UserRecord> userList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ripbull.coresdk.group.mapper.GroupRecord> groupList, @org.jetbrains.annotations.NotNull()
    java.lang.String deviceId, @org.jetbrains.annotations.NotNull()
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
    
    private final boolean noInternetConnection() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/ripbull/coresdk/chat/repository/ChatRemoteRepository$Companion;", "", "()V", "newInstance", "Lcom/ripbull/coresdk/chat/repository/ChatRemoteRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "threadRepository", "Lcom/ripbull/coresdk/thread/handler/ThreadRepository;", "eventHandler", "Lcom/ripbull/coresdk/core/event/EventHandler;", "downloadRepository", "Lcom/ripbull/sdk/downloader/handler/DownloadRepository;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.coresdk.chat.repository.ChatRemoteRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.thread.handler.ThreadRepository threadRepository, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.core.event.EventHandler eventHandler, @org.jetbrains.annotations.NotNull()
        com.ripbull.sdk.downloader.handler.DownloadRepository downloadRepository) {
            return null;
        }
    }
}