package com.ripbull.coresdk.utils;

import java.lang.System;

/**
 * Created by meeth on 27/10/18.
 * @author meeth
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0002J5\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u0011J5\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u0011J5\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u0011J5\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u0011J5\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u0011J5\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0007\u00a2\u0006\u0002\u0010\u0011J)\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0002\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/ripbull/coresdk/utils/Logger;", "", "()V", "FCM", "", "HTTP", "MQTT", "TAG", "checkAndExecute", "", "action", "Lkotlin/Function0;", "d", "tag", "message", "params", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "wtf", "format", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ripbull-chat-sdk_qaDebug"})
public final class Logger {
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.utils.Logger INSTANCE = null;
    private static final java.lang.String TAG = "chat_sdk_log :";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MQTT = "MQTT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FCM = "FCM";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HTTP = "OK_HTTP";
    
    private Logger() {
        super();
    }
    
    private final java.lang.String format(java.lang.String $this$format, java.lang.Object... params) {
        return null;
    }
    
    private final void checkAndExecute(kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void v(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void w(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
    
    @kotlin.jvm.JvmStatic()
    public static final void wtf(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.Object... params) {
    }
}