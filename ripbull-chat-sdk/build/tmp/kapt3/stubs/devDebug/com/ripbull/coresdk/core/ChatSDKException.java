package com.ripbull.coresdk.core;

import java.lang.System;

/**
 * Created by DK on 2019-09-24.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException;", "", "error", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "message", "", "exception", "(Lcom/ripbull/coresdk/core/ChatSDKException$Error;Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "getException", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Error", "ripbull-chat-sdk_devDebug"})
public final class ChatSDKException extends java.lang.Throwable {
    @org.jetbrains.annotations.NotNull()
    private final com.ripbull.coresdk.core.ChatSDKException.Error error = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Throwable exception = null;
    
    /**
     * Created by DK on 2019-09-24.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.ChatSDKException copy(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.ChatSDKException.Error error, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable exception) {
        return null;
    }
    
    /**
     * Created by DK on 2019-09-24.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 2019-09-24.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 2019-09-24.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatSDKException(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.ChatSDKException.Error error) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatSDKException(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.ChatSDKException.Error error, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public ChatSDKException(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.ChatSDKException.Error error, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable exception) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.ChatSDKException.Error component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.ChatSDKException.Error getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Throwable component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Throwable getException() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "", "code", "", "(I)V", "getCode", "()I", "AuthError", "Failure", "IOError", "InvalidModule", "NoNetwork", "SocketTimeout", "UnknownError", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$InvalidModule;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$Failure;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$NoNetwork;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$AuthError;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$UnknownError;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$SocketTimeout;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error$IOError;", "ripbull-chat-sdk_devDebug"})
    public static abstract class Error {
        private final int code = 0;
        
        private Error(int code) {
            super();
        }
        
        public final int getCode() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$InvalidModule;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "()V", "ripbull-chat-sdk_devDebug"})
        public static final class InvalidModule extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public InvalidModule() {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$Failure;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "code", "", "(I)V", "ripbull-chat-sdk_devDebug"})
        public static final class Failure extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public Failure(int code) {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$NoNetwork;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "code", "", "(I)V", "ripbull-chat-sdk_devDebug"})
        public static final class NoNetwork extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public NoNetwork(int code) {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$AuthError;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "code", "", "(I)V", "ripbull-chat-sdk_devDebug"})
        public static final class AuthError extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public AuthError(int code) {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$UnknownError;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "code", "", "(I)V", "ripbull-chat-sdk_devDebug"})
        public static final class UnknownError extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public UnknownError(int code) {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$SocketTimeout;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "code", "", "(I)V", "ripbull-chat-sdk_devDebug"})
        public static final class SocketTimeout extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public SocketTimeout(int code) {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ripbull/coresdk/core/ChatSDKException$Error$IOError;", "Lcom/ripbull/coresdk/core/ChatSDKException$Error;", "code", "", "(I)V", "ripbull-chat-sdk_devDebug"})
        public static final class IOError extends com.ripbull.coresdk.core.ChatSDKException.Error {
            
            public IOError(int code) {
                super(0);
            }
        }
    }
}