package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by DK on 02/01/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/UserEmbedded;", "", "()V", "configs", "", "Lcom/ripbull/ertc/cache/database/entity/UserMetadata;", "tenant", "Lcom/ripbull/ertc/cache/database/entity/User;", "getTenant", "()Lcom/ripbull/ertc/cache/database/entity/User;", "sdk-cache_debug"})
public final class UserEmbedded {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Embedded()
    private final com.ripbull.ertc.cache.database.entity.User tenant = null;
    @androidx.room.Relation(parentColumn = "id", entityColumn = "use_id")
    private final java.util.List<com.ripbull.ertc.cache.database.entity.UserMetadata> configs = null;
    
    public UserEmbedded() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.ertc.cache.database.entity.User getTenant() {
        return null;
    }
}