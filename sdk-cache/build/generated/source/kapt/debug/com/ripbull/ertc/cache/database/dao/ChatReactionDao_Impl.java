package com.ripbull.ertc.cache.database.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ripbull.ertc.cache.database.entity.ChatReactionEntity;
import com.ripbull.ertc.cache.database.entity.ChatReactionWithUsers;
import com.ripbull.ertc.cache.database.entity.User;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatReactionDao_Impl implements ChatReactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ChatReactionEntity> __insertionAdapterOfChatReactionEntity;

  private final EntityInsertionAdapter<ChatReactionEntity> __insertionAdapterOfChatReactionEntity_1;

  private final EntityInsertionAdapter<ChatReactionEntity> __insertionAdapterOfChatReactionEntity_2;

  private final EntityInsertionAdapter<ChatReactionEntity> __insertionAdapterOfChatReactionEntity_3;

  private final EntityInsertionAdapter<ChatReactionEntity> __insertionAdapterOfChatReactionEntity_4;

  private final EntityDeletionOrUpdateAdapter<ChatReactionEntity> __deletionAdapterOfChatReactionEntity;

  private final EntityDeletionOrUpdateAdapter<ChatReactionEntity> __updateAdapterOfChatReactionEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearChatUserReaction;

  private final SharedSQLiteStatement __preparedStmtOfClearChatThreadUserReaction;

  private final SharedSQLiteStatement __preparedStmtOfClearAllThreadUserReaction;

  private final SharedSQLiteStatement __preparedStmtOfClearAllUserReaction;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByThreadId;

  public ChatReactionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChatReactionEntity = new EntityInsertionAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `chat_reaction` (`id`,`unicode`,`thread_id`,`user_chat_id`,`chat_msg_id`,`chat_thread_msg_id`,`total_count`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUnicode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUnicode());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserChatId());
        }
        if (value.getChatMsgId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChatMsgId());
        }
        if (value.getChatThreadMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChatThreadMsgId());
        }
        if (value.getTotalCount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalCount());
        }
      }
    };
    this.__insertionAdapterOfChatReactionEntity_1 = new EntityInsertionAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `chat_reaction` (`id`,`unicode`,`thread_id`,`user_chat_id`,`chat_msg_id`,`chat_thread_msg_id`,`total_count`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUnicode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUnicode());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserChatId());
        }
        if (value.getChatMsgId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChatMsgId());
        }
        if (value.getChatThreadMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChatThreadMsgId());
        }
        if (value.getTotalCount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalCount());
        }
      }
    };
    this.__insertionAdapterOfChatReactionEntity_2 = new EntityInsertionAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `chat_reaction` (`id`,`unicode`,`thread_id`,`user_chat_id`,`chat_msg_id`,`chat_thread_msg_id`,`total_count`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUnicode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUnicode());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserChatId());
        }
        if (value.getChatMsgId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChatMsgId());
        }
        if (value.getChatThreadMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChatThreadMsgId());
        }
        if (value.getTotalCount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalCount());
        }
      }
    };
    this.__insertionAdapterOfChatReactionEntity_3 = new EntityInsertionAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `chat_reaction` (`id`,`unicode`,`thread_id`,`user_chat_id`,`chat_msg_id`,`chat_thread_msg_id`,`total_count`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUnicode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUnicode());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserChatId());
        }
        if (value.getChatMsgId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChatMsgId());
        }
        if (value.getChatThreadMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChatThreadMsgId());
        }
        if (value.getTotalCount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalCount());
        }
      }
    };
    this.__insertionAdapterOfChatReactionEntity_4 = new EntityInsertionAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `chat_reaction` (`id`,`unicode`,`thread_id`,`user_chat_id`,`chat_msg_id`,`chat_thread_msg_id`,`total_count`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUnicode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUnicode());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserChatId());
        }
        if (value.getChatMsgId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChatMsgId());
        }
        if (value.getChatThreadMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChatThreadMsgId());
        }
        if (value.getTotalCount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalCount());
        }
      }
    };
    this.__deletionAdapterOfChatReactionEntity = new EntityDeletionOrUpdateAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `chat_reaction` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfChatReactionEntity = new EntityDeletionOrUpdateAdapter<ChatReactionEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `chat_reaction` SET `id` = ?,`unicode` = ?,`thread_id` = ?,`user_chat_id` = ?,`chat_msg_id` = ?,`chat_thread_msg_id` = ?,`total_count` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ChatReactionEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getUnicode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUnicode());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserChatId());
        }
        if (value.getChatMsgId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getChatMsgId());
        }
        if (value.getChatThreadMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getChatThreadMsgId());
        }
        if (value.getTotalCount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalCount());
        }
        stmt.bindLong(8, value.getId());
      }
    };
    this.__preparedStmtOfClearChatUserReaction = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM chat_reaction WHERE chat_msg_id = ? AND unicode = ? AND user_chat_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearChatThreadUserReaction = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM chat_reaction WHERE chat_thread_msg_id = ? AND unicode = ? AND user_chat_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearAllThreadUserReaction = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM chat_reaction WHERE chat_thread_msg_id = ?  AND user_chat_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearAllUserReaction = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM chat_reaction WHERE chat_msg_id = ?  AND user_chat_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByThreadId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM chat_reaction WHERE thread_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<ChatReactionEntity> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<ChatReactionEntity> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<ChatReactionEntity> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<ChatReactionEntity> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<ChatReactionEntity> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatReactionEntity.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChatReactionEntity.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<ChatReactionEntity> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfChatReactionEntity.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ChatReactionEntity t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChatReactionEntity.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearChatUserReaction(final String chatMsgId, final String unicode,
      final String userChatId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearChatUserReaction.acquire();
    int _argIndex = 1;
    if (chatMsgId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatMsgId);
    }
    _argIndex = 2;
    if (unicode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, unicode);
    }
    _argIndex = 3;
    if (userChatId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userChatId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearChatUserReaction.release(_stmt);
    }
  }

  @Override
  public void clearChatThreadUserReaction(final String chatThreadMsgId, final String unicode,
      final String userChatId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearChatThreadUserReaction.acquire();
    int _argIndex = 1;
    if (chatThreadMsgId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatThreadMsgId);
    }
    _argIndex = 2;
    if (unicode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, unicode);
    }
    _argIndex = 3;
    if (userChatId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userChatId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearChatThreadUserReaction.release(_stmt);
    }
  }

  @Override
  public void clearAllThreadUserReaction(final String chatThreadMsgId, final String userChatId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllThreadUserReaction.acquire();
    int _argIndex = 1;
    if (chatThreadMsgId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatThreadMsgId);
    }
    _argIndex = 2;
    if (userChatId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userChatId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearAllThreadUserReaction.release(_stmt);
    }
  }

  @Override
  public void clearAllUserReaction(final String chatMsgId, final String userChatId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllUserReaction.acquire();
    int _argIndex = 1;
    if (chatMsgId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatMsgId);
    }
    _argIndex = 2;
    if (userChatId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userChatId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearAllUserReaction.release(_stmt);
    }
  }

  @Override
  public void deleteByThreadId(final String threadId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByThreadId.acquire();
    int _argIndex = 1;
    if (threadId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, threadId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByThreadId.release(_stmt);
    }
  }

  @Override
  public Single<List<ChatReactionEntity>> getAllReactions(final String chatMsgId) {
    final String _sql = "SELECT * FROM chat_reaction WHERE chat_msg_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatMsgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatMsgId);
    }
    return RxRoom.createSingle(new Callable<List<ChatReactionEntity>>() {
      @Override
      public List<ChatReactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnicode = CursorUtil.getColumnIndexOrThrow(_cursor, "unicode");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfChatMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_msg_id");
          final int _cursorIndexOfChatThreadMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_thread_msg_id");
          final int _cursorIndexOfTotalCount = CursorUtil.getColumnIndexOrThrow(_cursor, "total_count");
          final List<ChatReactionEntity> _result = new ArrayList<ChatReactionEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChatReactionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUnicode;
            if (_cursor.isNull(_cursorIndexOfUnicode)) {
              _tmpUnicode = null;
            } else {
              _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            final String _tmpChatMsgId;
            if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
              _tmpChatMsgId = null;
            } else {
              _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
            }
            final String _tmpChatThreadMsgId;
            if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
              _tmpChatThreadMsgId = null;
            } else {
              _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
            }
            final Integer _tmpTotalCount;
            if (_cursor.isNull(_cursorIndexOfTotalCount)) {
              _tmpTotalCount = null;
            } else {
              _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
            }
            _item = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<ChatReactionEntity>> getChatReactionsCount(final String chatMsgId,
      final String unicode) {
    final String _sql = "SELECT * FROM chat_reaction WHERE chat_msg_id = ? AND unicode = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (chatMsgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatMsgId);
    }
    _argIndex = 2;
    if (unicode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unicode);
    }
    return RxRoom.createSingle(new Callable<List<ChatReactionEntity>>() {
      @Override
      public List<ChatReactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnicode = CursorUtil.getColumnIndexOrThrow(_cursor, "unicode");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfChatMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_msg_id");
          final int _cursorIndexOfChatThreadMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_thread_msg_id");
          final int _cursorIndexOfTotalCount = CursorUtil.getColumnIndexOrThrow(_cursor, "total_count");
          final List<ChatReactionEntity> _result = new ArrayList<ChatReactionEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChatReactionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUnicode;
            if (_cursor.isNull(_cursorIndexOfUnicode)) {
              _tmpUnicode = null;
            } else {
              _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            final String _tmpChatMsgId;
            if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
              _tmpChatMsgId = null;
            } else {
              _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
            }
            final String _tmpChatThreadMsgId;
            if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
              _tmpChatThreadMsgId = null;
            } else {
              _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
            }
            final Integer _tmpTotalCount;
            if (_cursor.isNull(_cursorIndexOfTotalCount)) {
              _tmpTotalCount = null;
            } else {
              _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
            }
            _item = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<ChatReactionEntity>> getChatThreadReactionsCount(final String chatThreadMsgId,
      final String unicode) {
    final String _sql = "SELECT * FROM chat_reaction WHERE chat_thread_msg_id = ? AND unicode = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (chatThreadMsgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatThreadMsgId);
    }
    _argIndex = 2;
    if (unicode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unicode);
    }
    return RxRoom.createSingle(new Callable<List<ChatReactionEntity>>() {
      @Override
      public List<ChatReactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnicode = CursorUtil.getColumnIndexOrThrow(_cursor, "unicode");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfChatMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_msg_id");
          final int _cursorIndexOfChatThreadMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_thread_msg_id");
          final int _cursorIndexOfTotalCount = CursorUtil.getColumnIndexOrThrow(_cursor, "total_count");
          final List<ChatReactionEntity> _result = new ArrayList<ChatReactionEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChatReactionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUnicode;
            if (_cursor.isNull(_cursorIndexOfUnicode)) {
              _tmpUnicode = null;
            } else {
              _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            final String _tmpChatMsgId;
            if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
              _tmpChatMsgId = null;
            } else {
              _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
            }
            final String _tmpChatThreadMsgId;
            if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
              _tmpChatThreadMsgId = null;
            } else {
              _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
            }
            final Integer _tmpTotalCount;
            if (_cursor.isNull(_cursorIndexOfTotalCount)) {
              _tmpTotalCount = null;
            } else {
              _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
            }
            _item = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<ChatReactionWithUsers>> getReactionedUsersOnThread(final String[] unicodes,
      final String msgId, final String threadId) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM chat_reaction WHERE unicode IN (");
    final int _inputSize = unicodes.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND chat_thread_msg_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" AND thread_id = ");
    _stringBuilder.append("?");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : unicodes) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (msgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msgId);
    }
    _argIndex = 2 + _inputSize;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createSingle(new Callable<List<ChatReactionWithUsers>>() {
      @Override
      public List<ChatReactionWithUsers> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnicode = CursorUtil.getColumnIndexOrThrow(_cursor, "unicode");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfChatMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_msg_id");
          final int _cursorIndexOfChatThreadMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_thread_msg_id");
          final int _cursorIndexOfTotalCount = CursorUtil.getColumnIndexOrThrow(_cursor, "total_count");
          final HashMap<String, ArrayList<User>> _collectionUsers = new HashMap<String, ArrayList<User>>();
          while (_cursor.moveToNext()) {
            if (!_cursor.isNull(_cursorIndexOfUserChatId)) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfUserChatId);
              ArrayList<User> _tmpUsersCollection = _collectionUsers.get(_tmpKey);
              if (_tmpUsersCollection == null) {
                _tmpUsersCollection = new ArrayList<User>();
                _collectionUsers.put(_tmpKey, _tmpUsersCollection);
              }
            }
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipuserAscomRipbullErtcCacheDatabaseEntityUser(_collectionUsers);
          final List<ChatReactionWithUsers> _result = new ArrayList<ChatReactionWithUsers>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChatReactionWithUsers _item_1;
            final ChatReactionEntity _tmpChatReactionEntity;
            if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfUnicode) && _cursor.isNull(_cursorIndexOfThreadId) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfChatMsgId) && _cursor.isNull(_cursorIndexOfChatThreadMsgId) && _cursor.isNull(_cursorIndexOfTotalCount))) {
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpUnicode;
              if (_cursor.isNull(_cursorIndexOfUnicode)) {
                _tmpUnicode = null;
              } else {
                _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
              }
              final String _tmpThreadId;
              if (_cursor.isNull(_cursorIndexOfThreadId)) {
                _tmpThreadId = null;
              } else {
                _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
              }
              final String _tmpUserChatId;
              if (_cursor.isNull(_cursorIndexOfUserChatId)) {
                _tmpUserChatId = null;
              } else {
                _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
              }
              final String _tmpChatMsgId;
              if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
                _tmpChatMsgId = null;
              } else {
                _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
              }
              final String _tmpChatThreadMsgId;
              if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
                _tmpChatThreadMsgId = null;
              } else {
                _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
              }
              final Integer _tmpTotalCount;
              if (_cursor.isNull(_cursorIndexOfTotalCount)) {
                _tmpTotalCount = null;
              } else {
                _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
              }
              _tmpChatReactionEntity = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            }  else  {
              _tmpChatReactionEntity = null;
            }
            ArrayList<User> _tmpUsersCollection_1 = null;
            if (!_cursor.isNull(_cursorIndexOfUserChatId)) {
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfUserChatId);
              _tmpUsersCollection_1 = _collectionUsers.get(_tmpKey_1);
            }
            if (_tmpUsersCollection_1 == null) {
              _tmpUsersCollection_1 = new ArrayList<User>();
            }
            _item_1 = new ChatReactionWithUsers();
            _item_1.setChatReactionEntity(_tmpChatReactionEntity);
            _item_1.setUsers(_tmpUsersCollection_1);
            _result.add(_item_1);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<ChatReactionWithUsers>> getReactionedUsersOnChat(final String[] unicodes,
      final String msgId, final String threadId) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM chat_reaction WHERE unicode IN (");
    final int _inputSize = unicodes.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") AND chat_msg_id = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" AND thread_id = ");
    _stringBuilder.append("?");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 2 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : unicodes) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    _argIndex = 1 + _inputSize;
    if (msgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msgId);
    }
    _argIndex = 2 + _inputSize;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createSingle(new Callable<List<ChatReactionWithUsers>>() {
      @Override
      public List<ChatReactionWithUsers> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnicode = CursorUtil.getColumnIndexOrThrow(_cursor, "unicode");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfChatMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_msg_id");
          final int _cursorIndexOfChatThreadMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_thread_msg_id");
          final int _cursorIndexOfTotalCount = CursorUtil.getColumnIndexOrThrow(_cursor, "total_count");
          final HashMap<String, ArrayList<User>> _collectionUsers = new HashMap<String, ArrayList<User>>();
          while (_cursor.moveToNext()) {
            if (!_cursor.isNull(_cursorIndexOfUserChatId)) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfUserChatId);
              ArrayList<User> _tmpUsersCollection = _collectionUsers.get(_tmpKey);
              if (_tmpUsersCollection == null) {
                _tmpUsersCollection = new ArrayList<User>();
                _collectionUsers.put(_tmpKey, _tmpUsersCollection);
              }
            }
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipuserAscomRipbullErtcCacheDatabaseEntityUser(_collectionUsers);
          final List<ChatReactionWithUsers> _result = new ArrayList<ChatReactionWithUsers>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChatReactionWithUsers _item_1;
            final ChatReactionEntity _tmpChatReactionEntity;
            if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfUnicode) && _cursor.isNull(_cursorIndexOfThreadId) && _cursor.isNull(_cursorIndexOfUserChatId) && _cursor.isNull(_cursorIndexOfChatMsgId) && _cursor.isNull(_cursorIndexOfChatThreadMsgId) && _cursor.isNull(_cursorIndexOfTotalCount))) {
              final long _tmpId;
              _tmpId = _cursor.getLong(_cursorIndexOfId);
              final String _tmpUnicode;
              if (_cursor.isNull(_cursorIndexOfUnicode)) {
                _tmpUnicode = null;
              } else {
                _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
              }
              final String _tmpThreadId;
              if (_cursor.isNull(_cursorIndexOfThreadId)) {
                _tmpThreadId = null;
              } else {
                _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
              }
              final String _tmpUserChatId;
              if (_cursor.isNull(_cursorIndexOfUserChatId)) {
                _tmpUserChatId = null;
              } else {
                _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
              }
              final String _tmpChatMsgId;
              if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
                _tmpChatMsgId = null;
              } else {
                _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
              }
              final String _tmpChatThreadMsgId;
              if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
                _tmpChatThreadMsgId = null;
              } else {
                _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
              }
              final Integer _tmpTotalCount;
              if (_cursor.isNull(_cursorIndexOfTotalCount)) {
                _tmpTotalCount = null;
              } else {
                _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
              }
              _tmpChatReactionEntity = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            }  else  {
              _tmpChatReactionEntity = null;
            }
            ArrayList<User> _tmpUsersCollection_1 = null;
            if (!_cursor.isNull(_cursorIndexOfUserChatId)) {
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfUserChatId);
              _tmpUsersCollection_1 = _collectionUsers.get(_tmpKey_1);
            }
            if (_tmpUsersCollection_1 == null) {
              _tmpUsersCollection_1 = new ArrayList<User>();
            }
            _item_1 = new ChatReactionWithUsers();
            _item_1.setChatReactionEntity(_tmpChatReactionEntity);
            _item_1.setUsers(_tmpUsersCollection_1);
            _result.add(_item_1);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<ChatReactionEntity>> getAllThreadReactions(final String chatThreadMsgId) {
    final String _sql = "SELECT * FROM chat_reaction WHERE chat_thread_msg_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatThreadMsgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatThreadMsgId);
    }
    return RxRoom.createSingle(new Callable<List<ChatReactionEntity>>() {
      @Override
      public List<ChatReactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnicode = CursorUtil.getColumnIndexOrThrow(_cursor, "unicode");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfChatMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_msg_id");
          final int _cursorIndexOfChatThreadMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_thread_msg_id");
          final int _cursorIndexOfTotalCount = CursorUtil.getColumnIndexOrThrow(_cursor, "total_count");
          final List<ChatReactionEntity> _result = new ArrayList<ChatReactionEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ChatReactionEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUnicode;
            if (_cursor.isNull(_cursorIndexOfUnicode)) {
              _tmpUnicode = null;
            } else {
              _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            final String _tmpChatMsgId;
            if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
              _tmpChatMsgId = null;
            } else {
              _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
            }
            final String _tmpChatThreadMsgId;
            if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
              _tmpChatThreadMsgId = null;
            } else {
              _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
            }
            final Integer _tmpTotalCount;
            if (_cursor.isNull(_cursorIndexOfTotalCount)) {
              _tmpTotalCount = null;
            } else {
              _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
            }
            _item = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipuserAscomRipbullErtcCacheDatabaseEntityUser(
      final HashMap<String, ArrayList<User>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<User>> _tmpInnerMap = new HashMap<String, ArrayList<User>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipuserAscomRipbullErtcCacheDatabaseEntityUser(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<User>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipuserAscomRipbullErtcCacheDatabaseEntityUser(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`tenant_id`,`name`,`app_state`,`login_type`,`profile_pic`,`profile_thumb`,`profile_status`,`login_timestamp`,`user_chat_id`,`availability_status`,`blocked_status`,`notification_settings`,`valid_till`,`valid_till_value` FROM `user` WHERE `user_chat_id` IN (");
    final int _inputSize = __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : __mapKeySet) {
      if (_item == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "user_chat_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfTenantId = 1;
      final int _cursorIndexOfName = 2;
      final int _cursorIndexOfAppState = 3;
      final int _cursorIndexOfLoginType = 4;
      final int _cursorIndexOfProfilePic = 5;
      final int _cursorIndexOfProfileThumb = 6;
      final int _cursorIndexOfProfileStatus = 7;
      final int _cursorIndexOfLoginTimestamp = 8;
      final int _cursorIndexOfUserChatId = 9;
      final int _cursorIndexOfAvailabilityStatus = 10;
      final int _cursorIndexOfBlockedStatus = 11;
      final int _cursorIndexOfNotificationSettings = 12;
      final int _cursorIndexOfValidTill = 13;
      final int _cursorIndexOfValidTillValue = 14;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<User> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final User _item_1;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAppState;
            if (_cursor.isNull(_cursorIndexOfAppState)) {
              _tmpAppState = null;
            } else {
              _tmpAppState = _cursor.getString(_cursorIndexOfAppState);
            }
            final String _tmpLoginType;
            if (_cursor.isNull(_cursorIndexOfLoginType)) {
              _tmpLoginType = null;
            } else {
              _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
            }
            final String _tmpProfilePic;
            if (_cursor.isNull(_cursorIndexOfProfilePic)) {
              _tmpProfilePic = null;
            } else {
              _tmpProfilePic = _cursor.getString(_cursorIndexOfProfilePic);
            }
            final String _tmpProfileThumb;
            if (_cursor.isNull(_cursorIndexOfProfileThumb)) {
              _tmpProfileThumb = null;
            } else {
              _tmpProfileThumb = _cursor.getString(_cursorIndexOfProfileThumb);
            }
            final String _tmpProfileStatus;
            if (_cursor.isNull(_cursorIndexOfProfileStatus)) {
              _tmpProfileStatus = null;
            } else {
              _tmpProfileStatus = _cursor.getString(_cursorIndexOfProfileStatus);
            }
            final Long _tmpLoginTimestamp;
            if (_cursor.isNull(_cursorIndexOfLoginTimestamp)) {
              _tmpLoginTimestamp = null;
            } else {
              _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
            }
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            final String _tmpAvailabilityStatus;
            if (_cursor.isNull(_cursorIndexOfAvailabilityStatus)) {
              _tmpAvailabilityStatus = null;
            } else {
              _tmpAvailabilityStatus = _cursor.getString(_cursorIndexOfAvailabilityStatus);
            }
            final String _tmpBlockedStatus;
            if (_cursor.isNull(_cursorIndexOfBlockedStatus)) {
              _tmpBlockedStatus = null;
            } else {
              _tmpBlockedStatus = _cursor.getString(_cursorIndexOfBlockedStatus);
            }
            final String _tmpNotificationSettings;
            if (_cursor.isNull(_cursorIndexOfNotificationSettings)) {
              _tmpNotificationSettings = null;
            } else {
              _tmpNotificationSettings = _cursor.getString(_cursorIndexOfNotificationSettings);
            }
            final Long _tmpValidTill;
            if (_cursor.isNull(_cursorIndexOfValidTill)) {
              _tmpValidTill = null;
            } else {
              _tmpValidTill = _cursor.getLong(_cursorIndexOfValidTill);
            }
            final String _tmpValidTillValue;
            if (_cursor.isNull(_cursorIndexOfValidTillValue)) {
              _tmpValidTillValue = null;
            } else {
              _tmpValidTillValue = _cursor.getString(_cursorIndexOfValidTillValue);
            }
            _item_1 = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
