package com.ripbull.coresdk.filter;

import java.lang.System;

/**
 * Created by DK on 26/03/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a2\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/ripbull/coresdk/filter/AbstractFilter;", "Lcom/ripbull/coresdk/filter/Filter;", "()V", "next", "execute", "", "command", "Lcom/ripbull/coresdk/filter/Command;", "(Lcom/ripbull/coresdk/filter/Command;)Ljava/lang/Boolean;", "getLast", "getNext", "setNext", "", "filter", "ripbull-chat-sdk_qaDebug"})
public abstract class AbstractFilter implements com.ripbull.coresdk.filter.Filter {
    private com.ripbull.coresdk.filter.Filter next;
    
    public AbstractFilter() {
        super();
    }
    
    @java.lang.Override()
    public void setNext(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.filter.Filter filter) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.ripbull.coresdk.filter.Filter getNext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.ripbull.coresdk.filter.Filter getLast() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Boolean execute(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.filter.Command command) {
        return null;
    }
}