package com.ripbull.coresdk.filter;

import java.lang.System;

/**
 * Created by DK on 26/03/20.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0000H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0000H&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0000H&\u00a8\u0006\f"}, d2 = {"Lcom/ripbull/coresdk/filter/Filter;", "", "execute", "", "command", "Lcom/ripbull/coresdk/filter/Command;", "(Lcom/ripbull/coresdk/filter/Command;)Ljava/lang/Boolean;", "getLast", "getNext", "setNext", "", "filter", "ripbull-chat-sdk_devDebug"})
public abstract interface Filter {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Boolean execute(@org.jetbrains.annotations.NotNull()
    com.ripbull.coresdk.filter.Command command);
    
    public abstract void setNext(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.filter.Filter filter);
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.ripbull.coresdk.filter.Filter getNext();
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.ripbull.coresdk.filter.Filter getLast();
}