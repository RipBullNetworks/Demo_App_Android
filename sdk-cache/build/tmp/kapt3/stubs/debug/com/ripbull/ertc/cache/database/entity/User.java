package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

@androidx.room.Entity(tableName = "user", indices = {@androidx.room.Index(value = {"id", "tenant_id"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.ripbull.ertc.cache.database.entity.Tenant.class, childColumns = {"tenant_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00b7\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u00c0\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Q\u001a\u00020RH\u00d6\u0001J\t\u0010S\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b\'\u0010\u0017R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R \u00102\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0015\"\u0004\b8\u0010\u0017R\"\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u0017\u00a8\u0006T"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/User;", "", "id", "", "tenantId", "name", "appState", "loginType", "profilePic", "profileThumb", "profileStatus", "loginTimestamp", "", "userChatId", "availabilityStatus", "blockedStatus", "notificationSettings", "validTill", "validTillValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getAppState", "()Ljava/lang/String;", "setAppState", "(Ljava/lang/String;)V", "getAvailabilityStatus", "setAvailabilityStatus", "getBlockedStatus", "setBlockedStatus", "ertcId", "getErtcId", "setErtcId", "getId", "setId", "getLoginTimestamp", "()Ljava/lang/Long;", "setLoginTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLoginType", "setLoginType", "getName", "setName", "getNotificationSettings", "setNotificationSettings", "getProfilePic", "setProfilePic", "getProfileStatus", "setProfileStatus", "getProfileThumb", "setProfileThumb", "role", "getRole", "setRole", "getTenantId", "setTenantId", "getUserChatId", "setUserChatId", "getValidTill", "setValidTill", "getValidTillValue", "setValidTillValue", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/ripbull/ertc/cache/database/entity/User;", "equals", "", "other", "hashCode", "", "toString", "sdk-cache_debug"})
public final class User {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey()
    private java.lang.String id;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "tenant_id")
    private java.lang.String tenantId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "app_state")
    private java.lang.String appState;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "login_type")
    private java.lang.String loginType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "profile_pic")
    private java.lang.String profilePic;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "profile_thumb")
    private java.lang.String profileThumb;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "profile_status")
    private java.lang.String profileStatus;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "login_timestamp")
    private java.lang.Long loginTimestamp;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "user_chat_id")
    private java.lang.String userChatId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "availability_status")
    private java.lang.String availabilityStatus;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "blocked_status")
    private java.lang.String blockedStatus;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "notification_settings")
    private java.lang.String notificationSettings;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "valid_till")
    private java.lang.Long validTill;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "valid_till_value")
    private java.lang.String validTillValue;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    private java.lang.String ertcId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    private java.lang.String role;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.User copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationSettings, @org.jetbrains.annotations.Nullable()
    java.lang.Long validTill, @org.jetbrains.annotations.Nullable()
    java.lang.String validTillValue) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationSettings) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationSettings, @org.jetbrains.annotations.Nullable()
    java.lang.Long validTill) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic, @org.jetbrains.annotations.Nullable()
    java.lang.String profileThumb, @org.jetbrains.annotations.Nullable()
    java.lang.String profileStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Long loginTimestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String userChatId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationSettings, @org.jetbrains.annotations.Nullable()
    java.lang.Long validTill, @org.jetbrains.annotations.Nullable()
    java.lang.String validTillValue) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTenantId() {
        return null;
    }
    
    public final void setTenantId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAppState() {
        return null;
    }
    
    public final void setAppState(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLoginType() {
        return null;
    }
    
    public final void setLoginType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfilePic() {
        return null;
    }
    
    public final void setProfilePic(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfileThumb() {
        return null;
    }
    
    public final void setProfileThumb(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfileStatus() {
        return null;
    }
    
    public final void setProfileStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getLoginTimestamp() {
        return null;
    }
    
    public final void setLoginTimestamp(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserChatId() {
        return null;
    }
    
    public final void setUserChatId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvailabilityStatus() {
        return null;
    }
    
    public final void setAvailabilityStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBlockedStatus() {
        return null;
    }
    
    public final void setBlockedStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNotificationSettings() {
        return null;
    }
    
    public final void setNotificationSettings(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getValidTill() {
        return null;
    }
    
    public final void setValidTill(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getValidTillValue() {
        return null;
    }
    
    public final void setValidTillValue(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErtcId() {
        return null;
    }
    
    public final void setErtcId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}