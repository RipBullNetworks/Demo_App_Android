package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * Created by Sagar on 11/02/2022.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/ChatSettingsRecord;", "", "profanityFilters", "", "Lcom/ripbull/coresdk/chat/mapper/ProfanityFilterRecord;", "domainFilters", "Lcom/ripbull/coresdk/chat/mapper/DomainFilterRecord;", "(Ljava/util/List;Ljava/util/List;)V", "getDomainFilters", "()Ljava/util/List;", "getProfanityFilters", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ripbull-chat-sdk_qaDebug"})
public final class ChatSettingsRecord {
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityFilterRecord> profanityFilters = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.chat.mapper.DomainFilterRecord> domainFilters = null;
    
    /**
     * Created by Sagar on 11/02/2022.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.ChatSettingsRecord copy(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityFilterRecord> profanityFilters, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.DomainFilterRecord> domainFilters) {
        return null;
    }
    
    /**
     * Created by Sagar on 11/02/2022.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by Sagar on 11/02/2022.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by Sagar on 11/02/2022.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ChatSettingsRecord(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityFilterRecord> profanityFilters, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.DomainFilterRecord> domainFilters) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityFilterRecord> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.ProfanityFilterRecord> getProfanityFilters() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.DomainFilterRecord> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.DomainFilterRecord> getDomainFilters() {
        return null;
    }
}