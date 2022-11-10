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
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ripbull.ertc.cache.database.entity.ThreadUserLink;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ThreadUserLinkDao_Impl implements ThreadUserLinkDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ThreadUserLink> __insertionAdapterOfThreadUserLink;

  private final EntityInsertionAdapter<ThreadUserLink> __insertionAdapterOfThreadUserLink_1;

  private final EntityInsertionAdapter<ThreadUserLink> __insertionAdapterOfThreadUserLink_2;

  private final EntityInsertionAdapter<ThreadUserLink> __insertionAdapterOfThreadUserLink_3;

  private final EntityInsertionAdapter<ThreadUserLink> __insertionAdapterOfThreadUserLink_4;

  private final EntityDeletionOrUpdateAdapter<ThreadUserLink> __deletionAdapterOfThreadUserLink;

  private final EntityDeletionOrUpdateAdapter<ThreadUserLink> __updateAdapterOfThreadUserLink;

  private final SharedSQLiteStatement __preparedStmtOfDeleteThreadByUserId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteThreadById;

  public ThreadUserLinkDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfThreadUserLink = new EntityInsertionAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `thread_user_link` (`id`,`sender_id`,`recipient_id`,`thread_id`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
        if (value.getSenderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSenderId());
        }
        if (value.getRecipientId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecipientId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThreadId());
        }
      }
    };
    this.__insertionAdapterOfThreadUserLink_1 = new EntityInsertionAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `thread_user_link` (`id`,`sender_id`,`recipient_id`,`thread_id`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
        if (value.getSenderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSenderId());
        }
        if (value.getRecipientId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecipientId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThreadId());
        }
      }
    };
    this.__insertionAdapterOfThreadUserLink_2 = new EntityInsertionAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `thread_user_link` (`id`,`sender_id`,`recipient_id`,`thread_id`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
        if (value.getSenderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSenderId());
        }
        if (value.getRecipientId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecipientId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThreadId());
        }
      }
    };
    this.__insertionAdapterOfThreadUserLink_3 = new EntityInsertionAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `thread_user_link` (`id`,`sender_id`,`recipient_id`,`thread_id`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
        if (value.getSenderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSenderId());
        }
        if (value.getRecipientId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecipientId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThreadId());
        }
      }
    };
    this.__insertionAdapterOfThreadUserLink_4 = new EntityInsertionAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `thread_user_link` (`id`,`sender_id`,`recipient_id`,`thread_id`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
        if (value.getSenderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSenderId());
        }
        if (value.getRecipientId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecipientId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThreadId());
        }
      }
    };
    this.__deletionAdapterOfThreadUserLink = new EntityDeletionOrUpdateAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `thread_user_link` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfThreadUserLink = new EntityDeletionOrUpdateAdapter<ThreadUserLink>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `thread_user_link` SET `id` = ?,`sender_id` = ?,`recipient_id` = ?,`thread_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ThreadUserLink value) {
        stmt.bindLong(1, value.getId());
        if (value.getSenderId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSenderId());
        }
        if (value.getRecipientId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecipientId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getThreadId());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteThreadByUserId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM thread_user_link WHERE recipient_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteThreadById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM thread_user_link WHERE thread_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<ThreadUserLink> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<ThreadUserLink> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<ThreadUserLink> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<ThreadUserLink> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<ThreadUserLink> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThreadUserLink.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfThreadUserLink.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<ThreadUserLink> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfThreadUserLink.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ThreadUserLink t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfThreadUserLink.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteThreadByUserId(final String recipientUserId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteThreadByUserId.acquire();
    int _argIndex = 1;
    if (recipientUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, recipientUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteThreadByUserId.release(_stmt);
    }
  }

  @Override
  public void deleteThreadById(final String threadId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteThreadById.acquire();
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
      __preparedStmtOfDeleteThreadById.release(_stmt);
    }
  }

  @Override
  public Single<List<ThreadUserLink>> hasThread(final String senderId, final String recipientId) {
    final String _sql = "SELECT * FROM thread_user_link WHERE sender_id = (?) AND recipient_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (senderId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, senderId);
    }
    _argIndex = 2;
    if (recipientId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipientId);
    }
    return RxRoom.createSingle(new Callable<List<ThreadUserLink>>() {
      @Override
      public List<ThreadUserLink> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfRecipientId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final List<ThreadUserLink> _result = new ArrayList<ThreadUserLink>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ThreadUserLink _item;
            final String _tmpSenderId;
            if (_cursor.isNull(_cursorIndexOfSenderId)) {
              _tmpSenderId = null;
            } else {
              _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
            }
            final String _tmpRecipientId;
            if (_cursor.isNull(_cursorIndexOfRecipientId)) {
              _tmpRecipientId = null;
            } else {
              _tmpRecipientId = _cursor.getString(_cursorIndexOfRecipientId);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            _item = new ThreadUserLink(_tmpSenderId,_tmpRecipientId,_tmpThreadId);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
  public List<ThreadUserLink> hasThread(final String threadId) {
    final String _sql = "SELECT * FROM thread_user_link WHERE thread_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfRecipientId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final List<ThreadUserLink> _result = new ArrayList<ThreadUserLink>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ThreadUserLink _item;
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        final String _tmpRecipientId;
        if (_cursor.isNull(_cursorIndexOfRecipientId)) {
          _tmpRecipientId = null;
        } else {
          _tmpRecipientId = _cursor.getString(_cursorIndexOfRecipientId);
        }
        final String _tmpThreadId;
        if (_cursor.isNull(_cursorIndexOfThreadId)) {
          _tmpThreadId = null;
        } else {
          _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
        }
        _item = new ThreadUserLink(_tmpSenderId,_tmpRecipientId,_tmpThreadId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ThreadUserLink threadUserInfoSync(final String threadId) {
    final String _sql = "SELECT * FROM thread_user_link WHERE thread_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfSenderId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfRecipientId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final ThreadUserLink _result;
      if(_cursor.moveToFirst()) {
        final String _tmpSenderId;
        if (_cursor.isNull(_cursorIndexOfSenderId)) {
          _tmpSenderId = null;
        } else {
          _tmpSenderId = _cursor.getString(_cursorIndexOfSenderId);
        }
        final String _tmpRecipientId;
        if (_cursor.isNull(_cursorIndexOfRecipientId)) {
          _tmpRecipientId = null;
        } else {
          _tmpRecipientId = _cursor.getString(_cursorIndexOfRecipientId);
        }
        final String _tmpThreadId;
        if (_cursor.isNull(_cursorIndexOfThreadId)) {
          _tmpThreadId = null;
        } else {
          _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
        }
        _result = new ThreadUserLink(_tmpSenderId,_tmpRecipientId,_tmpThreadId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
