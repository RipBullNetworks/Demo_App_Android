package com.ripbull.ertc.cache.preference;

import java.lang.System;

/**
 * @author meeth
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010M\u001a\u00020NH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0005\"\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u001a\u0010 \u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u001a\u0010#\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u001a\u0010&\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010\u0005\"\u0004\b(\u0010\u0007R\u001a\u0010)\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u001a\u0010,\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u0005\"\u0004\b.\u0010\u0007R\u001a\u0010/\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010\u0005\"\u0004\b1\u0010\u0007R\u001a\u00102\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u0005\"\u0004\b4\u0010\u0007R\u0018\u00105\u001a\u000206X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b<\u0010\u0005\"\u0004\b=\u0010\u0007R\u001a\u0010>\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b?\u0010\u0005\"\u0004\b@\u0010\u0007R\u001a\u0010A\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010\u0005\"\u0004\bC\u0010\u0007R\u001a\u0010D\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bE\u0010\u0005\"\u0004\bF\u0010\u0007R\u001a\u0010G\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bH\u0010\u0005\"\u0004\bI\u0010\u0007R\u001a\u0010J\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010\u0005\"\u0004\bL\u0010\u0007\u00a8\u0006O"}, d2 = {"Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "", "apiKey", "", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "appUserId", "getAppUserId", "setAppUserId", "chatApiKey", "getChatApiKey", "setChatApiKey", "chatRefreshToken", "getChatRefreshToken", "setChatRefreshToken", "chatServer", "getChatServer", "setChatServer", "chatToken", "getChatToken", "setChatToken", "chatUserId", "getChatUserId", "setChatUserId", "deviceId", "getDeviceId", "setDeviceId", "fcmToken", "getFcmToken", "setFcmToken", "lastCallTimeUser", "getLastCallTimeUser", "setLastCallTimeUser", "loginType", "getLoginType", "setLoginType", "mqttApiKey", "getMqttApiKey", "setMqttApiKey", "mqttServer", "getMqttServer", "setMqttServer", "name", "getName", "setName", "packageName", "getPackageName", "setPackageName", "projectType", "getProjectType", "setProjectType", "skipRestoreFlag", "", "getSkipRestoreFlag", "()Z", "setSkipRestoreFlag", "(Z)V", "tenantId", "getTenantId", "setTenantId", "userApiKey", "getUserApiKey", "setUserApiKey", "userId", "getUserId", "setUserId", "userRefreshToken", "getUserRefreshToken", "setUserRefreshToken", "userServer", "getUserServer", "setUserServer", "userToken", "getUserToken", "setUserToken", "clearData", "", "sdk-cache_debug"})
public abstract interface PreferenceManager {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getTenantId();
    
    public abstract void setTenantId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getUserId();
    
    public abstract void setUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getName();
    
    public abstract void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getLoginType();
    
    public abstract void setLoginType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getUserServer();
    
    public abstract void setUserServer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getChatServer();
    
    public abstract void setChatServer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getMqttServer();
    
    public abstract void setMqttServer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getChatUserId();
    
    public abstract void setChatUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getApiKey();
    
    public abstract void setApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getChatApiKey();
    
    public abstract void setChatApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getUserApiKey();
    
    public abstract void setUserApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getMqttApiKey();
    
    public abstract void setMqttApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getAppUserId();
    
    public abstract void setAppUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getFcmToken();
    
    public abstract void setFcmToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getDeviceId();
    
    public abstract void setDeviceId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getPackageName();
    
    public abstract void setPackageName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getUserToken();
    
    public abstract void setUserToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getUserRefreshToken();
    
    public abstract void setUserRefreshToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getChatToken();
    
    public abstract void setChatToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getChatRefreshToken();
    
    public abstract void setChatRefreshToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getLastCallTimeUser();
    
    public abstract void setLastCallTimeUser(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    public abstract boolean getSkipRestoreFlag();
    
    public abstract void setSkipRestoreFlag(boolean p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getProjectType();
    
    public abstract void setProjectType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    public abstract void clearData();
}