package com.ripbull.coresdk.user.mapper;

import java.lang.System;

/**
 * Created by DK on 09/03/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b<\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00bb\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0013J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u00c2\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u00d6\u0003J\t\u0010L\u001a\u00020MH\u00d6\u0001J\b\u0010N\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0015\"\u0004\b4\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017\u00a8\u0006O"}, d2 = {"Lcom/ripbull/coresdk/user/mapper/UserRecord;", "Ljava/io/Serializable;", "id", "", "tenantId", "name", "appState", "loginType", "profilePic", "profileThumb", "profileStatus", "loginTimestamp", "", "userChatId", "role", "ertcId", "availabilityStatus", "blockedStatus", "notificationSettings", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppState", "()Ljava/lang/String;", "setAppState", "(Ljava/lang/String;)V", "getAvailabilityStatus", "setAvailabilityStatus", "getBlockedStatus", "setBlockedStatus", "getErtcId", "setErtcId", "getId", "setId", "getLoginTimestamp", "()Ljava/lang/Long;", "setLoginTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLoginType", "setLoginType", "getName", "setName", "getNotificationSettings", "setNotificationSettings", "getProfilePic", "setProfilePic", "getProfileStatus", "setProfileStatus", "getProfileThumb", "setProfileThumb", "getRole", "setRole", "getTenantId", "setTenantId", "getUserChatId", "setUserChatId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ripbull/coresdk/user/mapper/UserRecord;", "equals", "", "other", "", "hashCode", "", "toString", "ripbull-chat-sdk_devDebug"})
public final class UserRecord implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String tenantId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String appState;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String loginType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String profilePic;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String profileThumb;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String profileStatus;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long loginTimestamp;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userChatId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String role;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String ertcId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String availabilityStatus;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String blockedStatus;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String notificationSettings;
    
    /**
     * Created by DK on 09/03/19.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.user.mapper.UserRecord copy(@org.jetbrains.annotations.Nullable()
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
    java.lang.String role, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationSettings) {
        return null;
    }
    
    /**
     * Created by DK on 09/03/19.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 09/03/19.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord() {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String appState, @org.jetbrains.annotations.Nullable()
    java.lang.String loginType, @org.jetbrains.annotations.Nullable()
    java.lang.String profilePic) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    java.lang.String role) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    java.lang.String role, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    java.lang.String role, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    java.lang.String role, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public UserRecord(@org.jetbrains.annotations.Nullable()
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
    java.lang.String role, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcId, @org.jetbrains.annotations.Nullable()
    java.lang.String availabilityStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String blockedStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String notificationSettings) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
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
    public final java.lang.String getRole() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErtcId() {
        return null;
    }
    
    public final void setErtcId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
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
    public final java.lang.String component14() {
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
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNotificationSettings() {
        return null;
    }
    
    public final void setNotificationSettings(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
}