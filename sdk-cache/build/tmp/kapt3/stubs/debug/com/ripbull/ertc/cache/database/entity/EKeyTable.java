package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by Vik on 21/11/19.
 */
@androidx.room.Entity(tableName = "eKeys", indices = {@androidx.room.Index(unique = true, value = {"keyId", "deviceId", "ertcUserId"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\fH\u00c6\u0003Je\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0003H\u00d6\u0001J\t\u00101\u001a\u00020\u0005H\u00d6\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00062"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/EKeyTable;", "", "id", "", "keyId", "", "deviceId", "publicKey", "privateKey", "ertcUserId", "tenantId", "time", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "getErtcUserId", "setErtcUserId", "getId", "()I", "setId", "(I)V", "getKeyId", "setKeyId", "getPrivateKey", "setPrivateKey", "getPublicKey", "setPublicKey", "getTenantId", "setTenantId", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "sdk-cache_debug"})
public final class EKeyTable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "keyId")
    private java.lang.String keyId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "deviceId")
    private java.lang.String deviceId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "publicKey")
    private java.lang.String publicKey;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "privateKey")
    private java.lang.String privateKey;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "ertcUserId")
    private java.lang.String ertcUserId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "tenant_id")
    private java.lang.String tenantId;
    @androidx.room.ColumnInfo(name = "time")
    private long time;
    
    /**
     * Created by Vik on 21/11/19.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.EKeyTable copy(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String publicKey, @org.jetbrains.annotations.Nullable()
    java.lang.String privateKey, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, long time) {
        return null;
    }
    
    /**
     * Created by Vik on 21/11/19.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by Vik on 21/11/19.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by Vik on 21/11/19.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable() {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String publicKey) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String publicKey, @org.jetbrains.annotations.Nullable()
    java.lang.String privateKey) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String publicKey, @org.jetbrains.annotations.Nullable()
    java.lang.String privateKey, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcUserId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String publicKey, @org.jetbrains.annotations.Nullable()
    java.lang.String privateKey, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public EKeyTable(int id, @org.jetbrains.annotations.Nullable()
    java.lang.String keyId, @org.jetbrains.annotations.Nullable()
    java.lang.String deviceId, @org.jetbrains.annotations.Nullable()
    java.lang.String publicKey, @org.jetbrains.annotations.Nullable()
    java.lang.String privateKey, @org.jetbrains.annotations.Nullable()
    java.lang.String ertcUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, long time) {
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
    public final java.lang.String getKeyId() {
        return null;
    }
    
    public final void setKeyId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeviceId() {
        return null;
    }
    
    public final void setDeviceId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPublicKey() {
        return null;
    }
    
    public final void setPublicKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrivateKey() {
        return null;
    }
    
    public final void setPrivateKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErtcUserId() {
        return null;
    }
    
    public final void setErtcUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTenantId() {
        return null;
    }
    
    public final void setTenantId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long component8() {
        return 0L;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
}