package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

@androidx.room.Entity(tableName = "profanity_filter", indices = {@androidx.room.Index(value = {"tenant_id"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.ripbull.ertc.cache.database.entity.Tenant.class, childColumns = {"tenant_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u001d"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/ProfanityFilter;", "", "keyword", "", "tenantId", "regex", "actionType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "getKeyword", "setKeyword", "getRegex", "setRegex", "getTenantId", "setTenantId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk-cache_debug"})
public final class ProfanityFilter {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "keyword")
    @androidx.room.PrimaryKey()
    private java.lang.String keyword;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "tenant_id")
    private java.lang.String tenantId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "regex")
    private java.lang.String regex;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "action_type")
    private java.lang.String actionType;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.ProfanityFilter copy(@org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String regex, @org.jetbrains.annotations.Nullable()
    java.lang.String actionType) {
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
    
    public ProfanityFilter(@org.jetbrains.annotations.NotNull()
    @androidx.annotation.NonNull()
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    java.lang.String tenantId, @org.jetbrains.annotations.Nullable()
    java.lang.String regex, @org.jetbrains.annotations.Nullable()
    java.lang.String actionType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeyword() {
        return null;
    }
    
    public final void setKeyword(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getRegex() {
        return null;
    }
    
    public final void setRegex(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActionType() {
        return null;
    }
    
    public final void setActionType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}