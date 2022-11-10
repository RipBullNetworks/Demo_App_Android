package com.ripbull.coresdk.download;

import java.lang.System;

/**
 * Created by Sagar on 03/03/20.
 */
@androidx.annotation.RestrictTo(value = {androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ripbull/coresdk/download/DownloadRepositoryImpl;", "Lcom/ripbull/sdk/downloader/handler/DownloadRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "(Lcom/ripbull/coresdk/data/DataManager;)V", "getDownloadById", "Lcom/ripbull/sdk/downloader/request/DownloadMediaRecord;", "id", "", "getUnwantedModels", "", "days", "", "insertDownloadData", "", "downloadMediaRecord", "removeById", "updateDownloadProgress", "downloadedBytes", "lastModifiedAt", "Companion", "ripbull-chat-sdk_qaDebug"})
public final class DownloadRepositoryImpl implements com.ripbull.sdk.downloader.handler.DownloadRepository {
    private final com.ripbull.coresdk.data.DataManager dataManager = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ripbull.coresdk.download.DownloadRepositoryImpl.Companion Companion = null;
    
    private DownloadRepositoryImpl(com.ripbull.coresdk.data.DataManager dataManager) {
        super();
    }
    
    @java.lang.Override()
    public void insertDownloadData(@org.jetbrains.annotations.Nullable()
    com.ripbull.sdk.downloader.request.DownloadMediaRecord downloadMediaRecord) {
    }
    
    @java.lang.Override()
    public void updateDownloadProgress(int id, long downloadedBytes, long lastModifiedAt) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.ripbull.sdk.downloader.request.DownloadMediaRecord getDownloadById(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.List<com.ripbull.sdk.downloader.request.DownloadMediaRecord> getUnwantedModels(long days) {
        return null;
    }
    
    @java.lang.Override()
    public void removeById(int id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.ripbull.sdk.downloader.handler.DownloadRepository newInstance(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.data.DataManager dataManager) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/ripbull/coresdk/download/DownloadRepositoryImpl$Companion;", "", "()V", "newInstance", "Lcom/ripbull/sdk/downloader/handler/DownloadRepository;", "dataManager", "Lcom/ripbull/coresdk/data/DataManager;", "ripbull-chat-sdk_qaDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.ripbull.sdk.downloader.handler.DownloadRepository newInstance(@org.jetbrains.annotations.NotNull()
        com.ripbull.coresdk.data.DataManager dataManager) {
            return null;
        }
    }
}