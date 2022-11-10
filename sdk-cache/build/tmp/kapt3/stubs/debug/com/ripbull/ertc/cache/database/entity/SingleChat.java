package com.ripbull.ertc.cache.database.entity;

import java.lang.System;

/**
 * Created by DK on 2019-08-14.
 */
@androidx.room.Entity(tableName = "single_chat", indices = {@androidx.room.Index(unique = true, value = {"id", "thread_id"}), @androidx.room.Index(unique = true, value = {"msg_unique_id", "thread_id"})}, foreignKeys = {@androidx.room.ForeignKey(entity = com.ripbull.ertc.cache.database.entity.Thread.class, childColumns = {"thread_id"}, onDelete = 5, parentColumns = {"id"})})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u0091\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00e3\u0003\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u00100J\n\u0010\u0084\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0012\u0010\u008b\u0001\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u00c6\u0003J\u0012\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015H\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u00108J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u00108J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\f\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a7\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00aa\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00ee\u0003\u0010\u00ab\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00ac\u0001J\u0016\u0010\u00ad\u0001\u001a\u00030\u00ae\u00012\t\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00b0\u0001\u001a\u00020\bH\u00d6\u0001J\n\u0010\u00b1\u0001\u001a\u00020\u0003H\u00d6\u0001R \u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\"\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010;\u001a\u0004\b>\u00108\"\u0004\b?\u0010:R \u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00102\"\u0004\bA\u00104R \u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u00102\"\u0004\bC\u00104R \u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010GR \u0010%\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u00102\"\u0004\bI\u00104R \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u00102\"\u0004\bK\u00104R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00102R\"\u0010*\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010P\u001a\u0004\b*\u0010M\"\u0004\bN\u0010OR\"\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010P\u001a\u0004\b&\u0010M\"\u0004\bQ\u0010OR \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u00102\"\u0004\bR\u00104R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u00102\"\u0004\bT\u00104R \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u00102\"\u0004\bV\u00104R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u00102\"\u0004\b\\\u00104R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u00102\"\u0004\b^\u00104R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u00102\"\u0004\b`\u00104R \u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u00102\"\u0004\bb\u00104R \u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00102\"\u0004\bd\u00104R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u00102\"\u0004\bf\u00104R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u00102\"\u0004\bh\u00104R \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u00102\"\u0004\bj\u00104R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u00102\"\u0004\bl\u00104R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u00102\"\u0004\bn\u00104R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u00102\"\u0004\bp\u00104R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010GR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010P\u001a\u0004\br\u0010M\"\u0004\bs\u0010OR \u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u00102\"\u0004\bu\u00104R \u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u00102\"\u0004\bw\u00104R\"\u0010 \u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010P\u001a\u0004\bx\u0010M\"\u0004\by\u0010OR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u00102\"\u0004\b{\u00104R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u00102\"\u0004\b}\u00104R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u00102\"\u0004\b\u007f\u00104R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u00102\"\u0005\b\u0081\u0001\u00104R\"\u0010\'\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u00102\"\u0005\b\u0083\u0001\u00104\u00a8\u0006\u00b2\u0001"}, d2 = {"Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "", "id", "", "createdAt", "", "message", "read", "", "type", "senderAppUserId", "threadId", "nextMessageId", "lastMessageId", "status", "msgType", "msgUniqueId", "mediaPath", "mediaThumbnail", "contactName", "phoneContactList", "", "Lcom/ripbull/ertc/cache/database/entity/PhoneContact;", "emailContactList", "Lcom/ripbull/ertc/cache/database/entity/EmailContact;", "isStarredChat", "gifPath", "location", "Lcom/ripbull/ertc/cache/database/entity/Location;", "mediaName", "localMediaPath", "downloadStatus", "sendToChannel", "parentMsgId", "parentMsg", "chatEventType", "deleteType", "forwardMsgUniqueId", "isForwardMessage", "updateType", "clientCreatedAt", "customData", "isFollowed", "chatReportId", "reportType", "reason", "mentions", "mentionedUsers", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/ertc/cache/database/entity/Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatEventType", "()Ljava/lang/String;", "setChatEventType", "(Ljava/lang/String;)V", "getChatReportId", "setChatReportId", "getClientCreatedAt", "()Ljava/lang/Long;", "setClientCreatedAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getContactName", "setContactName", "getCreatedAt", "setCreatedAt", "getCustomData", "setCustomData", "getDeleteType", "setDeleteType", "getDownloadStatus", "setDownloadStatus", "getEmailContactList", "()Ljava/util/List;", "getForwardMsgUniqueId", "setForwardMsgUniqueId", "getGifPath", "setGifPath", "getId", "()Ljava/lang/Integer;", "setFollowed", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setForwardMessage", "setStarredChat", "getLastMessageId", "setLastMessageId", "getLocalMediaPath", "setLocalMediaPath", "getLocation", "()Lcom/ripbull/ertc/cache/database/entity/Location;", "setLocation", "(Lcom/ripbull/ertc/cache/database/entity/Location;)V", "getMediaName", "setMediaName", "getMediaPath", "setMediaPath", "getMediaThumbnail", "setMediaThumbnail", "getMentionedUsers", "setMentionedUsers", "getMentions", "setMentions", "getMessage", "setMessage", "getMsgType", "setMsgType", "getMsgUniqueId", "setMsgUniqueId", "getNextMessageId", "setNextMessageId", "getParentMsg", "setParentMsg", "getParentMsgId", "setParentMsgId", "getPhoneContactList", "getRead", "setRead", "getReason", "setReason", "getReportType", "setReportType", "getSendToChannel", "setSendToChannel", "getSenderAppUserId", "setSenderAppUserId", "getStatus", "setStatus", "getThreadId", "setThreadId", "getType", "setType", "getUpdateType", "setUpdateType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/ertc/cache/database/entity/Location;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ripbull/ertc/cache/database/entity/SingleChat;", "equals", "", "other", "hashCode", "toString", "sdk-cache_debug"})
public final class SingleChat {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "createdAt")
    private java.lang.Long createdAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "message")
    private java.lang.String message;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "read")
    private java.lang.Integer read;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "type")
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "sender_id")
    private java.lang.String senderAppUserId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "thread_id")
    private java.lang.String threadId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "next_msg_id")
    private java.lang.String nextMessageId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "last_msg_id")
    private java.lang.String lastMessageId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "status")
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "msg_type")
    private java.lang.String msgType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "msg_unique_id")
    private java.lang.String msgUniqueId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "media_path")
    private java.lang.String mediaPath;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "media_thumbnail")
    private java.lang.String mediaThumbnail;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "contact_name")
    private java.lang.String contactName;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "phone_contact_list")
    private final java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "email_contact_list")
    private final java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo()
    private java.lang.String isStarredChat;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "gif_path")
    private java.lang.String gifPath;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Embedded()
    private com.ripbull.ertc.cache.database.entity.Location location;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "media_name")
    private java.lang.String mediaName;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "local_media_path")
    private java.lang.String localMediaPath;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "download_status")
    private java.lang.String downloadStatus;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "send_to_channel")
    private java.lang.Integer sendToChannel;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "parent_msg_id")
    private java.lang.String parentMsgId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "parent_msg")
    private java.lang.String parentMsg;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "event_type")
    private java.lang.String chatEventType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "delete_type")
    private java.lang.String deleteType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "forward_msg_unique_id")
    private java.lang.String forwardMsgUniqueId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "is_forward_message")
    private java.lang.Integer isForwardMessage;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "update_type")
    private java.lang.String updateType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "client_created_at")
    private java.lang.Long clientCreatedAt;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "custom_data")
    private java.lang.String customData;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "is_followed")
    private java.lang.Integer isFollowed;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "chat_report_id")
    private java.lang.String chatReportId;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "report_type")
    private java.lang.String reportType;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "reason")
    private java.lang.String reason;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "mentions")
    private java.lang.String mentions;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "mentioned_users")
    private java.lang.String mentionedUsers;
    
    /**
     * Created by DK on 2019-08-14.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.ertc.cache.database.entity.SingleChat copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String mentions, @org.jetbrains.annotations.Nullable()
    java.lang.String mentionedUsers) {
        return null;
    }
    
    /**
     * Created by DK on 2019-08-14.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 2019-08-14.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 2019-08-14.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String mentions) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public SingleChat(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String senderAppUserId, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String msgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> phoneContactList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> emailContactList, @org.jetbrains.annotations.Nullable()
    java.lang.String isStarredChat, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location location, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sendToChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsgId, @org.jetbrains.annotations.Nullable()
    java.lang.String parentMsg, @org.jetbrains.annotations.Nullable()
    java.lang.String chatEventType, @org.jetbrains.annotations.Nullable()
    java.lang.String deleteType, @org.jetbrains.annotations.Nullable()
    java.lang.String forwardMsgUniqueId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isForwardMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, @org.jetbrains.annotations.Nullable()
    java.lang.Integer isFollowed, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String mentions, @org.jetbrains.annotations.Nullable()
    java.lang.String mentionedUsers) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRead() {
        return null;
    }
    
    public final void setRead(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSenderAppUserId() {
        return null;
    }
    
    public final void setSenderAppUserId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    public final void setThreadId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNextMessageId() {
        return null;
    }
    
    public final void setNextMessageId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastMessageId() {
        return null;
    }
    
    public final void setLastMessageId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgType() {
        return null;
    }
    
    public final void setMsgType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgUniqueId() {
        return null;
    }
    
    public final void setMsgUniqueId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaPath() {
        return null;
    }
    
    public final void setMediaPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaThumbnail() {
        return null;
    }
    
    public final void setMediaThumbnail(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContactName() {
        return null;
    }
    
    public final void setContactName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.PhoneContact> getPhoneContactList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.ertc.cache.database.entity.EmailContact> getEmailContactList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String isStarredChat() {
        return null;
    }
    
    public final void setStarredChat(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGifPath() {
        return null;
    }
    
    public final void setGifPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.ertc.cache.database.entity.Location component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.ertc.cache.database.entity.Location getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    com.ripbull.ertc.cache.database.entity.Location p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaName() {
        return null;
    }
    
    public final void setMediaName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocalMediaPath() {
        return null;
    }
    
    public final void setLocalMediaPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDownloadStatus() {
        return null;
    }
    
    public final void setDownloadStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSendToChannel() {
        return null;
    }
    
    public final void setSendToChannel(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentMsgId() {
        return null;
    }
    
    public final void setParentMsgId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentMsg() {
        return null;
    }
    
    public final void setParentMsg(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChatEventType() {
        return null;
    }
    
    public final void setChatEventType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeleteType() {
        return null;
    }
    
    public final void setDeleteType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getForwardMsgUniqueId() {
        return null;
    }
    
    public final void setForwardMsgUniqueId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer isForwardMessage() {
        return null;
    }
    
    public final void setForwardMessage(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdateType() {
        return null;
    }
    
    public final void setUpdateType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getClientCreatedAt() {
        return null;
    }
    
    public final void setClientCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomData() {
        return null;
    }
    
    public final void setCustomData(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer isFollowed() {
        return null;
    }
    
    public final void setFollowed(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChatReportId() {
        return null;
    }
    
    public final void setChatReportId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReportType() {
        return null;
    }
    
    public final void setReportType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReason() {
        return null;
    }
    
    public final void setReason(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMentions() {
        return null;
    }
    
    public final void setMentions(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMentionedUsers() {
        return null;
    }
    
    public final void setMentionedUsers(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}