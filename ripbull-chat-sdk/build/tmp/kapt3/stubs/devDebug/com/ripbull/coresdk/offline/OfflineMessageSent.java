package com.ripbull.coresdk.offline;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/ripbull/coresdk/offline/OfflineMessageSent;", "", "()V", "Companion", "ripbull-chat-sdk_devDebug"})
public final class OfflineMessageSent {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.offline.OfflineMessageSent.Companion Companion = null;
    
    public OfflineMessageSent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/ripbull/coresdk/offline/OfflineMessageSent$Companion;", "", "()V", "sendE2EMessage", "", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "tenantId", "", "singleChat", "Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "chatUserId", "data", "Lcom/ripbull/coresdk/data/DataManager;", "parallelDeviceList", "Ljava/util/ArrayList;", "Lcom/ripbull/ertc/cache/database/entity/EKeyTable;", "Lkotlin/collections/ArrayList;", "ripbull-chat-sdk_devDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void sendE2EMessage(@org.jetbrains.annotations.NotNull()
        io.reactivex.disposables.CompositeDisposable disposable, @org.jetbrains.annotations.NotNull()
        java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
        com.ripbull.ertc.cache.database.entity.SingleChat singleChat, @org.jetbrains.annotations.NotNull()
        java.lang.String chatUserId, @org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager data, @org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.ripbull.ertc.cache.database.entity.EKeyTable> parallelDeviceList) {
        }
    }
}