package com.ripbull.coresdk.chat.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\nH\u00c6\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/ripbull/coresdk/chat/model/Contact;", "", "contactName", "", "phoneNumberRecord", "", "Lcom/ripbull/coresdk/chat/mapper/PhoneContactRecord;", "eMailRecords", "Lcom/ripbull/coresdk/chat/mapper/EmailContactRecord;", "type", "Lcom/ripbull/coresdk/core/type/MessageType;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/ripbull/coresdk/core/type/MessageType;)V", "getContactName", "()Ljava/lang/String;", "getEMailRecords", "()Ljava/util/List;", "getPhoneNumberRecord", "getType", "()Lcom/ripbull/coresdk/core/type/MessageType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ripbull-chat-sdk_devDebug"})
public final class Contact {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String contactName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneNumberRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> eMailRecords = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ripbull.coresdk.core.type.MessageType type = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.model.Contact copy(@org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneNumberRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> eMailRecords, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.MessageType type) {
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
    
    public Contact(@org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneNumberRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> eMailRecords, @org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.core.type.MessageType type) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContactName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> getPhoneNumberRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> getEMailRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.type.MessageType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.core.type.MessageType getType() {
        return null;
    }
}