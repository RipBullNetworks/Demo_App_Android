package com.ripbull.coresdk.chat.mapper;

import java.lang.System;

/**
 * Created by DK on 09/03/19.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b{\b\u0086\b\u0018\u00002\u00020\u0001B\u00fb\u0003\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0016\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u001b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00104\u001a\u00020\u001b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010:J\t\u0010}\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0012\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u00c6\u0003J\u0012\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016H\u00c6\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003\u00a2\u0006\u0002\u0010OJ\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010DJ\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010!H\u00c6\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010$H\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010(H\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010*H\u00c6\u0003J\u0012\u0010\u0092\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0016H\u00c6\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003\u00a2\u0006\u0002\u0010OJ\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u001bH\u00c6\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u000101H\u00c6\u0003J\u0011\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010DJ\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u001bH\u00c6\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010mJ\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0086\u0004\u0010\u00a6\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u001b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u00104\u001a\u00020\u001b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00a7\u0001J\u0015\u0010\u00a8\u0001\u001a\u00020\u001b2\t\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00aa\u0001\u001a\u00020\bH\u00d6\u0001J\n\u0010\u00ab\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010)\u001a\u0004\u0018\u00010*\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u00105\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001c\u0010\'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0015\u00102\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010DR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010>R\u0013\u00103\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010>R\u0013\u0010&\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010>R\u0013\u0010 \u001a\u0004\u0018\u00010!\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010>R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\n\n\u0002\u0010P\u001a\u0004\b\u001a\u0010OR\u001a\u00104\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010Q\"\u0004\bR\u0010SR\u001a\u0010/\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010Q\"\u0004\bT\u0010SR\u001e\u0010-\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010P\u001a\u0004\b-\u0010O\"\u0004\bU\u0010VR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010>R\u0013\u0010%\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010>R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010>R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010>R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010>R\u0013\u00109\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010>R\u0013\u00108\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010>R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010>R\u001a\u0010.\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010>\"\u0004\bb\u0010cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010>R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010>R\u0013\u0010#\u001a\u0004\u0018\u00010$\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010JR\"\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010J\"\u0004\bj\u0010kR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010n\u001a\u0004\bl\u0010mR\u0013\u00107\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010>R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0013\u00106\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010>R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010>R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010qR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bu\u0010>R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010>R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010E\u001a\u0004\bw\u0010DR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010>R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|\u00a8\u0006\u00ac\u0001"}, d2 = {"Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "", "id", "", "timestamp", "", "message", "read", "", "type", "threadId", "nextMessageId", "lastMessageId", "status", "msgType", "senderId", "mediaPath", "mediaThumbnail", "locationRecord", "Lcom/ripbull/coresdk/chat/mapper/LocationRecord;", "contactName", "phoneContactRecord", "", "Lcom/ripbull/coresdk/chat/mapper/PhoneContactRecord;", "emailContactRecord", "Lcom/ripbull/coresdk/chat/mapper/EmailContactRecord;", "isFavoriteMessage", "", "gifPath", "senderRecord", "Lcom/ripbull/coresdk/user/mapper/UserRecord;", "receiverRecord", "groupRecord", "Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "mediaName", "notificationRecord", "Lcom/ripbull/coresdk/fcm/NotificationRecord;", "localMediaPath", "downloadStatus", "chatThreadMetadata", "Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;", "chatEventType", "Lcom/ripbull/coresdk/core/type/ChatEventType;", "reactions", "Lcom/ripbull/coresdk/chat/mapper/ChatReactionRecord;", "isSilent", "messageDeleteType", "isForwardMessage", "updateType", "Lcom/ripbull/coresdk/core/type/MessageUpdateType;", "clientCreatedAt", "customData", "isFollowThread", "chatReportId", "reportType", "reason", "mentions", "mentionedUsers", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/chat/mapper/LocationRecord;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Ljava/lang/String;Lcom/ripbull/coresdk/fcm/NotificationRecord;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;Lcom/ripbull/coresdk/core/type/ChatEventType;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;ZLcom/ripbull/coresdk/core/type/MessageUpdateType;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatEventType", "()Lcom/ripbull/coresdk/core/type/ChatEventType;", "getChatReportId", "()Ljava/lang/String;", "getChatThreadMetadata", "()Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;", "setChatThreadMetadata", "(Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;)V", "getClientCreatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContactName", "getCustomData", "getDownloadStatus", "getEmailContactRecord", "()Ljava/util/List;", "getGifPath", "getGroupRecord", "()Lcom/ripbull/coresdk/group/mapper/GroupRecord;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "setFollowThread", "(Z)V", "setForwardMessage", "setSilent", "(Ljava/lang/Boolean;)V", "getLastMessageId", "getLocalMediaPath", "getLocationRecord", "()Lcom/ripbull/coresdk/chat/mapper/LocationRecord;", "getMediaName", "getMediaPath", "getMediaThumbnail", "getMentionedUsers", "getMentions", "getMessage", "getMessageDeleteType", "setMessageDeleteType", "(Ljava/lang/String;)V", "getMsgType", "getNextMessageId", "getNotificationRecord", "()Lcom/ripbull/coresdk/fcm/NotificationRecord;", "getPhoneContactRecord", "getReactions", "setReactions", "(Ljava/util/List;)V", "getRead", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReason", "getReceiverRecord", "()Lcom/ripbull/coresdk/user/mapper/UserRecord;", "getReportType", "getSenderId", "getSenderRecord", "getStatus", "getThreadId", "getTimestamp", "getType", "getUpdateType", "()Lcom/ripbull/coresdk/core/type/MessageUpdateType;", "setUpdateType", "(Lcom/ripbull/coresdk/core/type/MessageUpdateType;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/chat/mapper/LocationRecord;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/user/mapper/UserRecord;Lcom/ripbull/coresdk/group/mapper/GroupRecord;Ljava/lang/String;Lcom/ripbull/coresdk/fcm/NotificationRecord;Ljava/lang/String;Ljava/lang/String;Lcom/ripbull/coresdk/chat/mapper/ThreadMessageMetadata;Lcom/ripbull/coresdk/core/type/ChatEventType;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;ZLcom/ripbull/coresdk/core/type/MessageUpdateType;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ripbull/coresdk/chat/mapper/MessageRecord;", "equals", "other", "hashCode", "toString", "ripbull-chat-sdk_qaDebug"})
public final class MessageRecord {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long timestamp = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer read = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String type = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String threadId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nextMessageId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lastMessageId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String status = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String msgType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String senderId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mediaPath = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mediaThumbnail = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String contactName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isFavoriteMessage = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String gifPath = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.user.mapper.UserRecord senderRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.user.mapper.UserRecord receiverRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.group.mapper.GroupRecord groupRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mediaName = null;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.fcm.NotificationRecord notificationRecord = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String localMediaPath = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String downloadStatus = null;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata;
    @org.jetbrains.annotations.Nullable()
    private final com.ripbull.coresdk.core.type.ChatEventType chatEventType = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isSilent;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String messageDeleteType;
    private boolean isForwardMessage;
    @org.jetbrains.annotations.Nullable()
    private com.ripbull.coresdk.core.type.MessageUpdateType updateType;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long clientCreatedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String customData = null;
    private boolean isFollowThread;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String chatReportId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String reportType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String reason = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mentions = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mentionedUsers = null;
    
    /**
     * Created by DK on 09/03/19.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.ripbull.coresdk.chat.mapper.MessageRecord copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String mentions, @org.jetbrains.annotations.Nullable()
    java.lang.String mentionedUsers) {
        return null;
    }
    
    /**
     * Created by DK on 09/03/19.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by DK on 09/03/19.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by DK on 09/03/19.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
    java.lang.String chatReportId, @org.jetbrains.annotations.Nullable()
    java.lang.String reportType, @org.jetbrains.annotations.Nullable()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String mentions) {
        super();
    }
    
    @kotlin.jvm.JvmOverloads()
    public MessageRecord(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Integer read, @org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.String threadId, @org.jetbrains.annotations.Nullable()
    java.lang.String nextMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String lastMessageId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String msgType, @org.jetbrains.annotations.Nullable()
    java.lang.String senderId, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaThumbnail, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.LocationRecord locationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> phoneContactRecord, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> emailContactRecord, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavoriteMessage, @org.jetbrains.annotations.Nullable()
    java.lang.String gifPath, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord senderRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.user.mapper.UserRecord receiverRecord, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.group.mapper.GroupRecord groupRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String mediaName, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.fcm.NotificationRecord notificationRecord, @org.jetbrains.annotations.Nullable()
    java.lang.String localMediaPath, @org.jetbrains.annotations.Nullable()
    java.lang.String downloadStatus, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata chatThreadMetadata, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.ChatEventType chatEventType, @org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> reactions, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isSilent, @org.jetbrains.annotations.NotNull()
    java.lang.String messageDeleteType, boolean isForwardMessage, @org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType updateType, @org.jetbrains.annotations.Nullable()
    java.lang.Long clientCreatedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String customData, boolean isFollowThread, @org.jetbrains.annotations.Nullable()
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
    public final java.lang.Long getTimestamp() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRead() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThreadId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNextMessageId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastMessageId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMsgType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSenderId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaThumbnail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.LocationRecord component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.LocationRecord getLocationRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContactName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.PhoneContactRecord> getPhoneContactRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.EmailContactRecord> getEmailContactRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isFavoriteMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGifPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord getSenderRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.user.mapper.UserRecord getReceiverRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.mapper.GroupRecord component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.group.mapper.GroupRecord getGroupRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMediaName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.fcm.NotificationRecord component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.fcm.NotificationRecord getNotificationRecord() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocalMediaPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDownloadStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata getChatThreadMetadata() {
        return null;
    }
    
    public final void setChatThreadMetadata(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.chat.mapper.ThreadMessageMetadata p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.ChatEventType component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.ChatEventType getChatEventType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> getReactions() {
        return null;
    }
    
    public final void setReactions(@org.jetbrains.annotations.Nullable()
    java.util.List<com.ripbull.coresdk.chat.mapper.ChatReactionRecord> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isSilent() {
        return null;
    }
    
    public final void setSilent(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessageDeleteType() {
        return null;
    }
    
    public final void setMessageDeleteType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component32() {
        return false;
    }
    
    public final boolean isForwardMessage() {
        return false;
    }
    
    public final void setForwardMessage(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.MessageUpdateType component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.ripbull.coresdk.core.type.MessageUpdateType getUpdateType() {
        return null;
    }
    
    public final void setUpdateType(@org.jetbrains.annotations.Nullable()
    com.ripbull.coresdk.core.type.MessageUpdateType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getClientCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomData() {
        return null;
    }
    
    public final boolean component36() {
        return false;
    }
    
    public final boolean isFollowThread() {
        return false;
    }
    
    public final void setFollowThread(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChatReportId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReportType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component40() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMentions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component41() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMentionedUsers() {
        return null;
    }
}