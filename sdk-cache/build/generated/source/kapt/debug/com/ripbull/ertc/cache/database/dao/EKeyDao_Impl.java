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
import com.ripbull.ertc.cache.database.entity.EKeyTable;
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
public final class EKeyDao_Impl implements EKeyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EKeyTable> __insertionAdapterOfEKeyTable;

  private final EntityInsertionAdapter<EKeyTable> __insertionAdapterOfEKeyTable_1;

  private final EntityInsertionAdapter<EKeyTable> __insertionAdapterOfEKeyTable_2;

  private final EntityInsertionAdapter<EKeyTable> __insertionAdapterOfEKeyTable_3;

  private final EntityInsertionAdapter<EKeyTable> __insertionAdapterOfEKeyTable_4;

  private final EntityDeletionOrUpdateAdapter<EKeyTable> __deletionAdapterOfEKeyTable;

  private final EntityDeletionOrUpdateAdapter<EKeyTable> __updateAdapterOfEKeyTable;

  private final SharedSQLiteStatement __preparedStmtOfUpdateKey;

  private final SharedSQLiteStatement __preparedStmtOfSetKeyId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteInActiveDevice;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserDetails;

  public EKeyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEKeyTable = new EntityInsertionAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `eKeys` (`id`,`keyId`,`deviceId`,`publicKey`,`privateKey`,`ertcUserId`,`tenant_id`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
        if (value.getKeyId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyId());
        }
        if (value.getDeviceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceId());
        }
        if (value.getPublicKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicKey());
        }
        if (value.getPrivateKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrivateKey());
        }
        if (value.getErtcUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getErtcUserId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenantId());
        }
        stmt.bindLong(8, value.getTime());
      }
    };
    this.__insertionAdapterOfEKeyTable_1 = new EntityInsertionAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `eKeys` (`id`,`keyId`,`deviceId`,`publicKey`,`privateKey`,`ertcUserId`,`tenant_id`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
        if (value.getKeyId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyId());
        }
        if (value.getDeviceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceId());
        }
        if (value.getPublicKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicKey());
        }
        if (value.getPrivateKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrivateKey());
        }
        if (value.getErtcUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getErtcUserId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenantId());
        }
        stmt.bindLong(8, value.getTime());
      }
    };
    this.__insertionAdapterOfEKeyTable_2 = new EntityInsertionAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `eKeys` (`id`,`keyId`,`deviceId`,`publicKey`,`privateKey`,`ertcUserId`,`tenant_id`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
        if (value.getKeyId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyId());
        }
        if (value.getDeviceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceId());
        }
        if (value.getPublicKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicKey());
        }
        if (value.getPrivateKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrivateKey());
        }
        if (value.getErtcUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getErtcUserId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenantId());
        }
        stmt.bindLong(8, value.getTime());
      }
    };
    this.__insertionAdapterOfEKeyTable_3 = new EntityInsertionAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `eKeys` (`id`,`keyId`,`deviceId`,`publicKey`,`privateKey`,`ertcUserId`,`tenant_id`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
        if (value.getKeyId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyId());
        }
        if (value.getDeviceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceId());
        }
        if (value.getPublicKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicKey());
        }
        if (value.getPrivateKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrivateKey());
        }
        if (value.getErtcUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getErtcUserId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenantId());
        }
        stmt.bindLong(8, value.getTime());
      }
    };
    this.__insertionAdapterOfEKeyTable_4 = new EntityInsertionAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `eKeys` (`id`,`keyId`,`deviceId`,`publicKey`,`privateKey`,`ertcUserId`,`tenant_id`,`time`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
        if (value.getKeyId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyId());
        }
        if (value.getDeviceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceId());
        }
        if (value.getPublicKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicKey());
        }
        if (value.getPrivateKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrivateKey());
        }
        if (value.getErtcUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getErtcUserId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenantId());
        }
        stmt.bindLong(8, value.getTime());
      }
    };
    this.__deletionAdapterOfEKeyTable = new EntityDeletionOrUpdateAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `eKeys` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfEKeyTable = new EntityDeletionOrUpdateAdapter<EKeyTable>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `eKeys` SET `id` = ?,`keyId` = ?,`deviceId` = ?,`publicKey` = ?,`privateKey` = ?,`ertcUserId` = ?,`tenant_id` = ?,`time` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EKeyTable value) {
        stmt.bindLong(1, value.getId());
        if (value.getKeyId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKeyId());
        }
        if (value.getDeviceId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceId());
        }
        if (value.getPublicKey() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublicKey());
        }
        if (value.getPrivateKey() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrivateKey());
        }
        if (value.getErtcUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getErtcUserId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTenantId());
        }
        stmt.bindLong(8, value.getTime());
        stmt.bindLong(9, value.getId());
      }
    };
    this.__preparedStmtOfUpdateKey = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE EKeys SET publicKey =?, keyId =?, time =? WHERE ertcUserId = ? AND deviceId =?";
        return _query;
      }
    };
    this.__preparedStmtOfSetKeyId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE EKeys SET keyId =? WHERE ertcUserId = ? AND publicKey =? AND time=? AND deviceId=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM EKeys";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteInActiveDevice = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM EKeys WHERE ertcUserId = ?  AND deviceId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUserDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM EKeys WHERE ertcUserId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final EKeyTable key) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEKeyTable_3.insert(key);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEKeyTable.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<EKeyTable> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEKeyTable.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EKeyTable t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEKeyTable.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateKey(final String eRTCUserId, final String publicKey, final String keyId,
      final String deviceId, final long time) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateKey.acquire();
    int _argIndex = 1;
    if (publicKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, publicKey);
    }
    _argIndex = 2;
    if (keyId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, keyId);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, time);
    _argIndex = 4;
    if (eRTCUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, eRTCUserId);
    }
    _argIndex = 5;
    if (deviceId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, deviceId);
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateKey.release(_stmt);
    }
  }

  @Override
  public void setKeyId(final String eRTCUserId, final String publicKey, final String keyId,
      final long time, final String deviceId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetKeyId.acquire();
    int _argIndex = 1;
    if (keyId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, keyId);
    }
    _argIndex = 2;
    if (eRTCUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, eRTCUserId);
    }
    _argIndex = 3;
    if (publicKey == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, publicKey);
    }
    _argIndex = 4;
    _stmt.bindLong(_argIndex, time);
    _argIndex = 5;
    if (deviceId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, deviceId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetKeyId.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public void deleteInActiveDevice(final String ertcUserId, final String deviceId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteInActiveDevice.acquire();
    int _argIndex = 1;
    if (ertcUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ertcUserId);
    }
    _argIndex = 2;
    if (deviceId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, deviceId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteInActiveDevice.release(_stmt);
    }
  }

  @Override
  public void deleteUserDetails(final String ertcUserId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserDetails.acquire();
    int _argIndex = 1;
    if (ertcUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ertcUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUserDetails.release(_stmt);
    }
  }

  @Override
  public Single<EKeyTable> getKey(final String keyId) {
    final String _sql = "SELECT * FROM EKeys WHERE keyId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (keyId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyId);
    }
    return RxRoom.createSingle(new Callable<EKeyTable>() {
      @Override
      public EKeyTable call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfKeyId = CursorUtil.getColumnIndexOrThrow(_cursor, "keyId");
            final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
            final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
            final int _cursorIndexOfPrivateKey = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKey");
            final int _cursorIndexOfErtcUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "ertcUserId");
            final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
            final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
            final EKeyTable _result;
            if(_cursor.moveToFirst()) {
              final int _tmpId;
              _tmpId = _cursor.getInt(_cursorIndexOfId);
              final String _tmpKeyId;
              if (_cursor.isNull(_cursorIndexOfKeyId)) {
                _tmpKeyId = null;
              } else {
                _tmpKeyId = _cursor.getString(_cursorIndexOfKeyId);
              }
              final String _tmpDeviceId;
              if (_cursor.isNull(_cursorIndexOfDeviceId)) {
                _tmpDeviceId = null;
              } else {
                _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
              }
              final String _tmpPublicKey;
              if (_cursor.isNull(_cursorIndexOfPublicKey)) {
                _tmpPublicKey = null;
              } else {
                _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
              }
              final String _tmpPrivateKey;
              if (_cursor.isNull(_cursorIndexOfPrivateKey)) {
                _tmpPrivateKey = null;
              } else {
                _tmpPrivateKey = _cursor.getString(_cursorIndexOfPrivateKey);
              }
              final String _tmpErtcUserId;
              if (_cursor.isNull(_cursorIndexOfErtcUserId)) {
                _tmpErtcUserId = null;
              } else {
                _tmpErtcUserId = _cursor.getString(_cursorIndexOfErtcUserId);
              }
              final String _tmpTenantId;
              if (_cursor.isNull(_cursorIndexOfTenantId)) {
                _tmpTenantId = null;
              } else {
                _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
              }
              final long _tmpTime;
              _tmpTime = _cursor.getLong(_cursorIndexOfTime);
              _result = new EKeyTable(_tmpId,_tmpKeyId,_tmpDeviceId,_tmpPublicKey,_tmpPrivateKey,_tmpErtcUserId,_tmpTenantId,_tmpTime);
            } else {
              _result = null;
            }
            if(_result == null) {
              throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public EKeyTable getMyLatestPrivateKey(final String eRTCUserId, final String deviceId,
      final String tenantId) {
    final String _sql = "SELECT * FROM EKeys WHERE ertcUserId = ? AND deviceId =? AND tenant_id =? ORDER BY time DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (eRTCUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eRTCUserId);
    }
    _argIndex = 2;
    if (deviceId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, deviceId);
    }
    _argIndex = 3;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfKeyId = CursorUtil.getColumnIndexOrThrow(_cursor, "keyId");
        final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
        final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
        final int _cursorIndexOfPrivateKey = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKey");
        final int _cursorIndexOfErtcUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "ertcUserId");
        final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
        final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
        final EKeyTable _result;
        if(_cursor.moveToFirst()) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpKeyId;
          if (_cursor.isNull(_cursorIndexOfKeyId)) {
            _tmpKeyId = null;
          } else {
            _tmpKeyId = _cursor.getString(_cursorIndexOfKeyId);
          }
          final String _tmpDeviceId;
          if (_cursor.isNull(_cursorIndexOfDeviceId)) {
            _tmpDeviceId = null;
          } else {
            _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
          }
          final String _tmpPublicKey;
          if (_cursor.isNull(_cursorIndexOfPublicKey)) {
            _tmpPublicKey = null;
          } else {
            _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
          }
          final String _tmpPrivateKey;
          if (_cursor.isNull(_cursorIndexOfPrivateKey)) {
            _tmpPrivateKey = null;
          } else {
            _tmpPrivateKey = _cursor.getString(_cursorIndexOfPrivateKey);
          }
          final String _tmpErtcUserId;
          if (_cursor.isNull(_cursorIndexOfErtcUserId)) {
            _tmpErtcUserId = null;
          } else {
            _tmpErtcUserId = _cursor.getString(_cursorIndexOfErtcUserId);
          }
          final String _tmpTenantId;
          if (_cursor.isNull(_cursorIndexOfTenantId)) {
            _tmpTenantId = null;
          } else {
            _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
          }
          final long _tmpTime;
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
          _result = new EKeyTable(_tmpId,_tmpKeyId,_tmpDeviceId,_tmpPublicKey,_tmpPrivateKey,_tmpErtcUserId,_tmpTenantId,_tmpTime);
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EKeyTable getPrivateKeyByKeyId(final String eRTCUserId, final String deviceId,
      final String tenantId, final String keyId) {
    final String _sql = "SELECT * FROM EKeys WHERE ertcUserId = ? AND deviceId =? AND tenant_id =? AND keyId =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (eRTCUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eRTCUserId);
    }
    _argIndex = 2;
    if (deviceId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, deviceId);
    }
    _argIndex = 3;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 4;
    if (keyId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, keyId);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfKeyId = CursorUtil.getColumnIndexOrThrow(_cursor, "keyId");
        final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
        final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
        final int _cursorIndexOfPrivateKey = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKey");
        final int _cursorIndexOfErtcUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "ertcUserId");
        final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
        final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
        final EKeyTable _result;
        if(_cursor.moveToFirst()) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpKeyId;
          if (_cursor.isNull(_cursorIndexOfKeyId)) {
            _tmpKeyId = null;
          } else {
            _tmpKeyId = _cursor.getString(_cursorIndexOfKeyId);
          }
          final String _tmpDeviceId;
          if (_cursor.isNull(_cursorIndexOfDeviceId)) {
            _tmpDeviceId = null;
          } else {
            _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
          }
          final String _tmpPublicKey;
          if (_cursor.isNull(_cursorIndexOfPublicKey)) {
            _tmpPublicKey = null;
          } else {
            _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
          }
          final String _tmpPrivateKey;
          if (_cursor.isNull(_cursorIndexOfPrivateKey)) {
            _tmpPrivateKey = null;
          } else {
            _tmpPrivateKey = _cursor.getString(_cursorIndexOfPrivateKey);
          }
          final String _tmpErtcUserId;
          if (_cursor.isNull(_cursorIndexOfErtcUserId)) {
            _tmpErtcUserId = null;
          } else {
            _tmpErtcUserId = _cursor.getString(_cursorIndexOfErtcUserId);
          }
          final String _tmpTenantId;
          if (_cursor.isNull(_cursorIndexOfTenantId)) {
            _tmpTenantId = null;
          } else {
            _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
          }
          final long _tmpTime;
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
          _result = new EKeyTable(_tmpId,_tmpKeyId,_tmpDeviceId,_tmpPublicKey,_tmpPrivateKey,_tmpErtcUserId,_tmpTenantId,_tmpTime);
        } else {
          _result = null;
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EKeyTable> getKeyByErtcId(final String eRTCUserId, final String tenantId) {
    final String _sql = "SELECT * FROM EKeys WHERE ertcUserId = ? AND tenant_id =? ORDER BY time DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (eRTCUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eRTCUserId);
    }
    _argIndex = 2;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfKeyId = CursorUtil.getColumnIndexOrThrow(_cursor, "keyId");
        final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "deviceId");
        final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
        final int _cursorIndexOfPrivateKey = CursorUtil.getColumnIndexOrThrow(_cursor, "privateKey");
        final int _cursorIndexOfErtcUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "ertcUserId");
        final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
        final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
        final List<EKeyTable> _result = new ArrayList<EKeyTable>(_cursor.getCount());
        while(_cursor.moveToNext()) {
          final EKeyTable _item;
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpKeyId;
          if (_cursor.isNull(_cursorIndexOfKeyId)) {
            _tmpKeyId = null;
          } else {
            _tmpKeyId = _cursor.getString(_cursorIndexOfKeyId);
          }
          final String _tmpDeviceId;
          if (_cursor.isNull(_cursorIndexOfDeviceId)) {
            _tmpDeviceId = null;
          } else {
            _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
          }
          final String _tmpPublicKey;
          if (_cursor.isNull(_cursorIndexOfPublicKey)) {
            _tmpPublicKey = null;
          } else {
            _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
          }
          final String _tmpPrivateKey;
          if (_cursor.isNull(_cursorIndexOfPrivateKey)) {
            _tmpPrivateKey = null;
          } else {
            _tmpPrivateKey = _cursor.getString(_cursorIndexOfPrivateKey);
          }
          final String _tmpErtcUserId;
          if (_cursor.isNull(_cursorIndexOfErtcUserId)) {
            _tmpErtcUserId = null;
          } else {
            _tmpErtcUserId = _cursor.getString(_cursorIndexOfErtcUserId);
          }
          final String _tmpTenantId;
          if (_cursor.isNull(_cursorIndexOfTenantId)) {
            _tmpTenantId = null;
          } else {
            _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
          }
          final long _tmpTime;
          _tmpTime = _cursor.getLong(_cursorIndexOfTime);
          _item = new EKeyTable(_tmpId,_tmpKeyId,_tmpDeviceId,_tmpPublicKey,_tmpPrivateKey,_tmpErtcUserId,_tmpTenantId,_tmpTime);
          _result.add(_item);
        }
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        _cursor.close();
        _statement.release();
      }
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
