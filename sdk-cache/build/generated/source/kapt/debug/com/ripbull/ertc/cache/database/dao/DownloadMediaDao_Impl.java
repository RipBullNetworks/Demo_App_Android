package com.ripbull.ertc.cache.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ripbull.ertc.cache.database.entity.DownloadMedia;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DownloadMediaDao_Impl implements DownloadMediaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DownloadMedia> __insertionAdapterOfDownloadMedia;

  private final EntityInsertionAdapter<DownloadMedia> __insertionAdapterOfDownloadMedia_1;

  private final EntityInsertionAdapter<DownloadMedia> __insertionAdapterOfDownloadMedia_2;

  private final EntityInsertionAdapter<DownloadMedia> __insertionAdapterOfDownloadMedia_3;

  private final EntityInsertionAdapter<DownloadMedia> __insertionAdapterOfDownloadMedia_4;

  private final EntityDeletionOrUpdateAdapter<DownloadMedia> __deletionAdapterOfDownloadMedia;

  private final EntityDeletionOrUpdateAdapter<DownloadMedia> __updateAdapterOfDownloadMedia;

  private final SharedSQLiteStatement __preparedStmtOfRemoveById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveByMsgId;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public DownloadMediaDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDownloadMedia = new EntityInsertionAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `download` (`id`,`url`,`etag`,`dir_path`,`file_name`,`msg_id`,`total_bytes`,`downloaded_bytes`,`last_modified_at`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getETag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getETag());
        }
        if (value.getDirPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirPath());
        }
        if (value.getFileName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileName());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgId());
        }
        if (value.getTotalBytes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalBytes());
        }
        if (value.getDownloadedBytes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDownloadedBytes());
        }
        if (value.getLastModifiedAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastModifiedAt());
        }
      }
    };
    this.__insertionAdapterOfDownloadMedia_1 = new EntityInsertionAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `download` (`id`,`url`,`etag`,`dir_path`,`file_name`,`msg_id`,`total_bytes`,`downloaded_bytes`,`last_modified_at`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getETag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getETag());
        }
        if (value.getDirPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirPath());
        }
        if (value.getFileName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileName());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgId());
        }
        if (value.getTotalBytes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalBytes());
        }
        if (value.getDownloadedBytes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDownloadedBytes());
        }
        if (value.getLastModifiedAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastModifiedAt());
        }
      }
    };
    this.__insertionAdapterOfDownloadMedia_2 = new EntityInsertionAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `download` (`id`,`url`,`etag`,`dir_path`,`file_name`,`msg_id`,`total_bytes`,`downloaded_bytes`,`last_modified_at`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getETag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getETag());
        }
        if (value.getDirPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirPath());
        }
        if (value.getFileName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileName());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgId());
        }
        if (value.getTotalBytes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalBytes());
        }
        if (value.getDownloadedBytes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDownloadedBytes());
        }
        if (value.getLastModifiedAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastModifiedAt());
        }
      }
    };
    this.__insertionAdapterOfDownloadMedia_3 = new EntityInsertionAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `download` (`id`,`url`,`etag`,`dir_path`,`file_name`,`msg_id`,`total_bytes`,`downloaded_bytes`,`last_modified_at`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getETag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getETag());
        }
        if (value.getDirPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirPath());
        }
        if (value.getFileName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileName());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgId());
        }
        if (value.getTotalBytes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalBytes());
        }
        if (value.getDownloadedBytes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDownloadedBytes());
        }
        if (value.getLastModifiedAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastModifiedAt());
        }
      }
    };
    this.__insertionAdapterOfDownloadMedia_4 = new EntityInsertionAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `download` (`id`,`url`,`etag`,`dir_path`,`file_name`,`msg_id`,`total_bytes`,`downloaded_bytes`,`last_modified_at`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getETag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getETag());
        }
        if (value.getDirPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirPath());
        }
        if (value.getFileName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileName());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgId());
        }
        if (value.getTotalBytes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalBytes());
        }
        if (value.getDownloadedBytes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDownloadedBytes());
        }
        if (value.getLastModifiedAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastModifiedAt());
        }
      }
    };
    this.__deletionAdapterOfDownloadMedia = new EntityDeletionOrUpdateAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `download` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfDownloadMedia = new EntityDeletionOrUpdateAdapter<DownloadMedia>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `download` SET `id` = ?,`url` = ?,`etag` = ?,`dir_path` = ?,`file_name` = ?,`msg_id` = ?,`total_bytes` = ?,`downloaded_bytes` = ?,`last_modified_at` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DownloadMedia value) {
        stmt.bindLong(1, value.getId());
        if (value.getUrl() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUrl());
        }
        if (value.getETag() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getETag());
        }
        if (value.getDirPath() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDirPath());
        }
        if (value.getFileName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileName());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgId());
        }
        if (value.getTotalBytes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getTotalBytes());
        }
        if (value.getDownloadedBytes() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getDownloadedBytes());
        }
        if (value.getLastModifiedAt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLastModifiedAt());
        }
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfRemoveById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM download WHERE id = (?)";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveByMsgId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM download WHERE msg_id = (?)";
        return _query;
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM download";
        return _query;
      }
    };
  }

  @Override
  public void insert(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<DownloadMedia> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<DownloadMedia> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<DownloadMedia> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<DownloadMedia> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<DownloadMedia> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDownloadMedia.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDownloadMedia.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<DownloadMedia> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDownloadMedia.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final DownloadMedia t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDownloadMedia.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveById.release(_stmt);
    }
  }

  @Override
  public void removeByMsgId(final String msgId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveByMsgId.acquire();
    int _argIndex = 1;
    if (msgId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, msgId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveByMsgId.release(_stmt);
    }
  }

  @Override
  public void clear() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClear.release(_stmt);
    }
  }

  @Override
  public DownloadMedia getDownloadById(final int id) {
    final String _sql = "SELECT * FROM download WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfETag = CursorUtil.getColumnIndexOrThrow(_cursor, "etag");
      final int _cursorIndexOfDirPath = CursorUtil.getColumnIndexOrThrow(_cursor, "dir_path");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_id");
      final int _cursorIndexOfTotalBytes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_bytes");
      final int _cursorIndexOfDownloadedBytes = CursorUtil.getColumnIndexOrThrow(_cursor, "downloaded_bytes");
      final int _cursorIndexOfLastModifiedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified_at");
      final DownloadMedia _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpUrl;
        if (_cursor.isNull(_cursorIndexOfUrl)) {
          _tmpUrl = null;
        } else {
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        }
        final String _tmpETag;
        if (_cursor.isNull(_cursorIndexOfETag)) {
          _tmpETag = null;
        } else {
          _tmpETag = _cursor.getString(_cursorIndexOfETag);
        }
        final String _tmpDirPath;
        if (_cursor.isNull(_cursorIndexOfDirPath)) {
          _tmpDirPath = null;
        } else {
          _tmpDirPath = _cursor.getString(_cursorIndexOfDirPath);
        }
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsgId;
        if (_cursor.isNull(_cursorIndexOfMsgId)) {
          _tmpMsgId = null;
        } else {
          _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
        }
        final Long _tmpTotalBytes;
        if (_cursor.isNull(_cursorIndexOfTotalBytes)) {
          _tmpTotalBytes = null;
        } else {
          _tmpTotalBytes = _cursor.getLong(_cursorIndexOfTotalBytes);
        }
        final Long _tmpDownloadedBytes;
        if (_cursor.isNull(_cursorIndexOfDownloadedBytes)) {
          _tmpDownloadedBytes = null;
        } else {
          _tmpDownloadedBytes = _cursor.getLong(_cursorIndexOfDownloadedBytes);
        }
        final Long _tmpLastModifiedAt;
        if (_cursor.isNull(_cursorIndexOfLastModifiedAt)) {
          _tmpLastModifiedAt = null;
        } else {
          _tmpLastModifiedAt = _cursor.getLong(_cursorIndexOfLastModifiedAt);
        }
        _result = new DownloadMedia(_tmpId,_tmpUrl,_tmpETag,_tmpDirPath,_tmpFileName,_tmpMsgId,_tmpTotalBytes,_tmpDownloadedBytes,_tmpLastModifiedAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DownloadMedia getDownloadByMsgId(final String msgId) {
    final String _sql = "SELECT * FROM download WHERE msg_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (msgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msgId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfETag = CursorUtil.getColumnIndexOrThrow(_cursor, "etag");
      final int _cursorIndexOfDirPath = CursorUtil.getColumnIndexOrThrow(_cursor, "dir_path");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_id");
      final int _cursorIndexOfTotalBytes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_bytes");
      final int _cursorIndexOfDownloadedBytes = CursorUtil.getColumnIndexOrThrow(_cursor, "downloaded_bytes");
      final int _cursorIndexOfLastModifiedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified_at");
      final DownloadMedia _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpUrl;
        if (_cursor.isNull(_cursorIndexOfUrl)) {
          _tmpUrl = null;
        } else {
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        }
        final String _tmpETag;
        if (_cursor.isNull(_cursorIndexOfETag)) {
          _tmpETag = null;
        } else {
          _tmpETag = _cursor.getString(_cursorIndexOfETag);
        }
        final String _tmpDirPath;
        if (_cursor.isNull(_cursorIndexOfDirPath)) {
          _tmpDirPath = null;
        } else {
          _tmpDirPath = _cursor.getString(_cursorIndexOfDirPath);
        }
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsgId;
        if (_cursor.isNull(_cursorIndexOfMsgId)) {
          _tmpMsgId = null;
        } else {
          _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
        }
        final Long _tmpTotalBytes;
        if (_cursor.isNull(_cursorIndexOfTotalBytes)) {
          _tmpTotalBytes = null;
        } else {
          _tmpTotalBytes = _cursor.getLong(_cursorIndexOfTotalBytes);
        }
        final Long _tmpDownloadedBytes;
        if (_cursor.isNull(_cursorIndexOfDownloadedBytes)) {
          _tmpDownloadedBytes = null;
        } else {
          _tmpDownloadedBytes = _cursor.getLong(_cursorIndexOfDownloadedBytes);
        }
        final Long _tmpLastModifiedAt;
        if (_cursor.isNull(_cursorIndexOfLastModifiedAt)) {
          _tmpLastModifiedAt = null;
        } else {
          _tmpLastModifiedAt = _cursor.getLong(_cursorIndexOfLastModifiedAt);
        }
        _result = new DownloadMedia(_tmpId,_tmpUrl,_tmpETag,_tmpDirPath,_tmpFileName,_tmpMsgId,_tmpTotalBytes,_tmpDownloadedBytes,_tmpLastModifiedAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<DownloadMedia> getUnwantedModels(final long days) {
    final String _sql = "SELECT * FROM download WHERE last_modified_at <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, days);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfETag = CursorUtil.getColumnIndexOrThrow(_cursor, "etag");
      final int _cursorIndexOfDirPath = CursorUtil.getColumnIndexOrThrow(_cursor, "dir_path");
      final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "file_name");
      final int _cursorIndexOfMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_id");
      final int _cursorIndexOfTotalBytes = CursorUtil.getColumnIndexOrThrow(_cursor, "total_bytes");
      final int _cursorIndexOfDownloadedBytes = CursorUtil.getColumnIndexOrThrow(_cursor, "downloaded_bytes");
      final int _cursorIndexOfLastModifiedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "last_modified_at");
      final List<DownloadMedia> _result = new ArrayList<DownloadMedia>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DownloadMedia _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpUrl;
        if (_cursor.isNull(_cursorIndexOfUrl)) {
          _tmpUrl = null;
        } else {
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        }
        final String _tmpETag;
        if (_cursor.isNull(_cursorIndexOfETag)) {
          _tmpETag = null;
        } else {
          _tmpETag = _cursor.getString(_cursorIndexOfETag);
        }
        final String _tmpDirPath;
        if (_cursor.isNull(_cursorIndexOfDirPath)) {
          _tmpDirPath = null;
        } else {
          _tmpDirPath = _cursor.getString(_cursorIndexOfDirPath);
        }
        final String _tmpFileName;
        if (_cursor.isNull(_cursorIndexOfFileName)) {
          _tmpFileName = null;
        } else {
          _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
        }
        final String _tmpMsgId;
        if (_cursor.isNull(_cursorIndexOfMsgId)) {
          _tmpMsgId = null;
        } else {
          _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
        }
        final Long _tmpTotalBytes;
        if (_cursor.isNull(_cursorIndexOfTotalBytes)) {
          _tmpTotalBytes = null;
        } else {
          _tmpTotalBytes = _cursor.getLong(_cursorIndexOfTotalBytes);
        }
        final Long _tmpDownloadedBytes;
        if (_cursor.isNull(_cursorIndexOfDownloadedBytes)) {
          _tmpDownloadedBytes = null;
        } else {
          _tmpDownloadedBytes = _cursor.getLong(_cursorIndexOfDownloadedBytes);
        }
        final Long _tmpLastModifiedAt;
        if (_cursor.isNull(_cursorIndexOfLastModifiedAt)) {
          _tmpLastModifiedAt = null;
        } else {
          _tmpLastModifiedAt = _cursor.getLong(_cursorIndexOfLastModifiedAt);
        }
        _item = new DownloadMedia(_tmpId,_tmpUrl,_tmpETag,_tmpDirPath,_tmpFileName,_tmpMsgId,_tmpTotalBytes,_tmpDownloadedBytes,_tmpLastModifiedAt);
        _result.add(_item);
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
