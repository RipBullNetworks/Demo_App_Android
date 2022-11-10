package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by Sagar on 03/03/20.
 */
@androidx.room.Entity(tableName = "download")
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u000eJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010/\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u00100\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014Jx\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u00020\u0003H\u00d6\u0001J\t\u00107\u001a\u00020\u0005H\u00d6\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b\'\u0010\u0012\u00a8\u00068"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/DownloadMedia;", "", "id", "", "url", "", "eTag", "dirPath", "fileName", "msgId", "totalBytes", "", "downloadedBytes", "lastModifiedAt", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getDirPath", "()Ljava/lang/String;", "setDirPath", "(Ljava/lang/String;)V", "getDownloadedBytes", "()Ljava/lang/Long;", "setDownloadedBytes", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getETag", "setETag", "getFileName", "setFileName", "getId", "()I", "setId", "(I)V", "getLastModifiedAt", "setLastModifiedAt", "getMsgId", "setMsgId", "getTotalBytes", "setTotalBytes", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/ripbull/ertc/cache/database/entity/DownloadMedia;", "equals", "", "other", "hashCode", "toString", "sdk-cache_debug"})
public final class DownloadMedia {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey()
    private int id;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "url")
    private java.lang.String url;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "etag")
    private java.lang.String eTag;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "dir_path")
    private java.lang.String dirPath;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "file_name")
    private java.lang.String fileName;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "msg_id")
    private java.lang.String msgId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "total_bytes")
    private java.lang.Long totalBytes;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "downloaded_bytes")
    private java.lang.Long downloadedBytes;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "last_modified_at")
    private java.lang.Long lastModifiedAt;
    
    /**
     * Created by Sagar on 03/03/20.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.DownloadMedia copy(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.Long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.Long downloadedBytes, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastModifiedAt) {
        return null;
    }
    
    /**
     * Created by Sagar on 03/03/20.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by Sagar on 03/03/20.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by Sagar on 03/03/20.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.Long totalBytes) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.Long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.Long downloadedBytes) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public DownloadMedia(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String eTag, @org.jetbrains.annotations.Nullable()
    java.lang.String dirPath, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String msgId, @org.jetbrains.annotations.Nullable()
    java.lang.Long totalBytes, @org.jetbrains.annotations.Nullable()
    java.lang.Long downloadedBytes, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastModifiedAt) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getETag() {
        return null;
    }
    
    public final void setETag(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDirPath() {
        return null;
    }
    
    public final void setDirPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFileName() {
        return null;
    }
    
    public final void setFileName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgId() {
        return null;
    }
    
    public final void setMsgId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getTotalBytes() {
        return null;
    }
    
    public final void setTotalBytes(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDownloadedBytes() {
        return null;
    }
    
    public final void setDownloadedBytes(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getLastModifiedAt() {
        return null;
    }
    
    public final void setLastModifiedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
}