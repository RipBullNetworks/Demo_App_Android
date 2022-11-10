package com.ripbull.ertc.cache.preference;

import java.lang.System;

/**
 * @author meeth
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bD\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 o2\u00020\u0001:\u0001oB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010m\u001a\u00020nH\u0016R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR/\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR/\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR/\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR/\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR/\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR/\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b)\u0010\r\u001a\u0004\b\'\u0010\t\"\u0004\b(\u0010\u000bR/\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\r\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR/\u0010.\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010\u000bR/\u00102\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\r\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR/\u00106\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\r\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR/\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b=\u0010\r\u001a\u0004\b;\u0010\t\"\u0004\b<\u0010\u000bR/\u0010>\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bA\u0010\r\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR/\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bE\u0010\r\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR/\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bI\u0010\r\u001a\u0004\bG\u0010\t\"\u0004\bH\u0010\u000bR\u0016\u0010J\u001a\n L*\u0004\u0018\u00010K0KX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010N\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020M8V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR/\u0010U\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bX\u0010\r\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR/\u0010Y\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\\\u0010\r\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000bR/\u0010]\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\b`\u0010\r\u001a\u0004\b^\u0010\t\"\u0004\b_\u0010\u000bR/\u0010a\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bd\u0010\r\u001a\u0004\bb\u0010\t\"\u0004\bc\u0010\u000bR/\u0010e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bh\u0010\r\u001a\u0004\bf\u0010\t\"\u0004\bg\u0010\u000bR/\u0010i\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u008e\u0002\u00a2\u0006\u0012\n\u0004\bl\u0010\r\u001a\u0004\bj\u0010\t\"\u0004\bk\u0010\u000b\u00a8\u0006p"}, d2 = {"Lcom/ripbull/ertc/cache/preference/PreferenceManagerImpl;", "Lcom/ripbull/ertc/cache/preference/PreferenceManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "apiKey", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "apiKey$delegate", "Lcom/ripbull/ertc/cache/preference/StringPreference;", "appUserId", "getAppUserId", "setAppUserId", "appUserId$delegate", "chatApiKey", "getChatApiKey", "setChatApiKey", "chatApiKey$delegate", "chatRefreshToken", "getChatRefreshToken", "setChatRefreshToken", "chatRefreshToken$delegate", "chatServer", "getChatServer", "setChatServer", "chatServer$delegate", "chatToken", "getChatToken", "setChatToken", "chatToken$delegate", "chatUserId", "getChatUserId", "setChatUserId", "chatUserId$delegate", "deviceId", "getDeviceId", "setDeviceId", "deviceId$delegate", "fcmToken", "getFcmToken", "setFcmToken", "fcmToken$delegate", "lastCallTimeUser", "getLastCallTimeUser", "setLastCallTimeUser", "lastCallTimeUser$delegate", "loginType", "getLoginType", "setLoginType", "loginType$delegate", "mqttApiKey", "getMqttApiKey", "setMqttApiKey", "mqttApiKey$delegate", "mqttServer", "getMqttServer", "setMqttServer", "mqttServer$delegate", "name", "getName", "setName", "name$delegate", "packageName", "getPackageName", "setPackageName", "packageName$delegate", "projectType", "getProjectType", "setProjectType", "projectType$delegate", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "", "skipRestoreFlag", "getSkipRestoreFlag", "()Z", "setSkipRestoreFlag", "(Z)V", "skipRestoreFlag$delegate", "Lcom/ripbull/ertc/cache/preference/BooleanPreference;", "tenantId", "getTenantId", "setTenantId", "tenantId$delegate", "userApiKey", "getUserApiKey", "setUserApiKey", "userApiKey$delegate", "userId", "getUserId", "setUserId", "userId$delegate", "userRefreshToken", "getUserRefreshToken", "setUserRefreshToken", "userRefreshToken$delegate", "userServer", "getUserServer", "setUserServer", "userServer$delegate", "userToken", "getUserToken", "setUserToken", "userToken$delegate", "clearData", "", "Companion", "sdk-cache_debug"})
public final class PreferenceManagerImpl implements com.ripbull.ertc.cache.preference.PreferenceManager {
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference tenantId$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference userId$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference name$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference loginType$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference userServer$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference chatServer$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference mqttServer$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference chatUserId$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference apiKey$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference chatApiKey$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference userApiKey$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference mqttApiKey$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference appUserId$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference fcmToken$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference deviceId$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference packageName$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference chatToken$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference chatRefreshToken$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference userToken$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference userRefreshToken$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference lastCallTimeUser$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ripbull.ertc.cache.preference.BooleanPreference skipRestoreFlag$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.ertc.cache.preference.StringPreference projectType$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.ertc.cache.preference.PreferenceManagerImpl.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_TENANT_KEY = "PREF_TENANT_KEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_USER_ID = "PREF_USER_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_NAME = "PREF_NAME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_LOGIN_TYPE = "PREF_LOGIN_TYPE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_USER_SERVER = "PREF_USER_SERVER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CHAT_SERVER = "PREF_CHAT_SERVER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_MQTT_SERVER = "PREF_MQTT_SERVER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CHAT_USER_ID = "PREF_CHAT_USER_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_API_KEY = "PREF_API_KEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CHAT_API_KEY = "PREF_CHAT_API_KEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_USER_API_KEY = "PREF_USER_API_KEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_MQTT_API_KEY = "PREF_MQTT_API_KEY";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_APP_USER_ID = "PREF_APP_USER_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_FCM_TOKEN = "PREF_FCM_TOKEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEVICE_ID = "PREF_DEVICE_ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_PACKAGE_NAME = "PREF_PACKAGE_NAME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CHAT_TOKEN = "PREF_CHAT_TOKEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_CHAT_REFRESH_TOKEN = "PREF_CHAT_REFRESH_TOKEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_USER_TOKEN = "PREF_USER_TOKEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_USER_REFRESH_TOKEN = "PREF_USER_REFRESH_TOKEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_LAST_CALL_TIME_USER = "PREF_LAST_CALL_TIME_USER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_SKIP_RESTORE_FLAG = "PREF_SKIP_RESTORE_FLAG";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_PROJECT_TYPE = "PREF_PROJECT_TYPE";
    
    public PreferenceManagerImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getTenantId() {
        return null;
    }
    
    @java.lang.Override()
    public void setTenantId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getUserId() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override()
    public void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getLoginType() {
        return null;
    }
    
    @java.lang.Override()
    public void setLoginType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getUserServer() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserServer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getChatServer() {
        return null;
    }
    
    @java.lang.Override()
    public void setChatServer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getMqttServer() {
        return null;
    }
    
    @java.lang.Override()
    public void setMqttServer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getChatUserId() {
        return null;
    }
    
    @java.lang.Override()
    public void setChatUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getApiKey() {
        return null;
    }
    
    @java.lang.Override()
    public void setApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getChatApiKey() {
        return null;
    }
    
    @java.lang.Override()
    public void setChatApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getUserApiKey() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getMqttApiKey() {
        return null;
    }
    
    @java.lang.Override()
    public void setMqttApiKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getAppUserId() {
        return null;
    }
    
    @java.lang.Override()
    public void setAppUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getFcmToken() {
        return null;
    }
    
    @java.lang.Override()
    public void setFcmToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getDeviceId() {
        return null;
    }
    
    @java.lang.Override()
    public void setDeviceId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getPackageName() {
        return null;
    }
    
    @java.lang.Override()
    public void setPackageName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getChatToken() {
        return null;
    }
    
    @java.lang.Override()
    public void setChatToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getChatRefreshToken() {
        return null;
    }
    
    @java.lang.Override()
    public void setChatRefreshToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getUserToken() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getUserRefreshToken() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserRefreshToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getLastCallTimeUser() {
        return null;
    }
    
    @java.lang.Override()
    public void setLastCallTimeUser(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public boolean getSkipRestoreFlag() {
        return false;
    }
    
    @java.lang.Override()
    public void setSkipRestoreFlag(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getProjectType() {
        return null;
    }
    
    @java.lang.Override()
    public void setProjectType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void clearData() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/ripbull/ertc/cache/preference/PreferenceManagerImpl$Companion;", "", "()V", "PREF_API_KEY", "", "PREF_APP_USER_ID", "PREF_CHAT_API_KEY", "PREF_CHAT_REFRESH_TOKEN", "PREF_CHAT_SERVER", "PREF_CHAT_TOKEN", "PREF_CHAT_USER_ID", "PREF_DEVICE_ID", "PREF_FCM_TOKEN", "PREF_LAST_CALL_TIME_USER", "PREF_LOGIN_TYPE", "PREF_MQTT_API_KEY", "PREF_MQTT_SERVER", "PREF_NAME", "PREF_PACKAGE_NAME", "PREF_PROJECT_TYPE", "PREF_SKIP_RESTORE_FLAG", "PREF_TENANT_KEY", "PREF_USER_API_KEY", "PREF_USER_ID", "PREF_USER_REFRESH_TOKEN", "PREF_USER_SERVER", "PREF_USER_TOKEN", "sdk-cache_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}