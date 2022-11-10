package com.ripbull.coresdk.group.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ>\u0010\u0003\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/ripbull/coresdk/group/mapper/GroupMapper;", "", "()V", "transform", "Lcom/ripbull/ertc/cache/database/entity/Group;", "groupRecord", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "group", "tenantId", "", "myAppUserId", "Lcom/ripbull/ertc/remote/model/response/GroupResponse;", "db", "Lcom/ripbull/ertc/cache/database/DataSource;", "userMedia", "myChatUserId", "ripbull-chat-sdk_devDebug"})
public final class GroupMapper {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.group.mapper.GroupMapper INSTANCE = null;
    
    private GroupMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.group.mapper.GroupRecord transform(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.remote.model.response.GroupResponse group, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.DataSource db, @org.jetbrains.annotations.NotNull()
    java.lang.String userMedia, @org.jetbrains.annotations.Nullable()
    java.lang.String myAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String myChatUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.group.mapper.GroupRecord transform(@org.jetbrains.annotations.NotNull()
    com.ripbull.ertc.cache.database.entity.Group group, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String myAppUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.ertc.cache.database.entity.Group transform(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord) {
        return null;
    }
}