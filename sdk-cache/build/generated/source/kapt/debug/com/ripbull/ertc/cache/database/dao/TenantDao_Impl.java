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
import com.ripbull.ertc.cache.database.entity.Tenant;
import com.ripbull.ertc.cache.database.entity.TenantAndConfig;
import com.ripbull.ertc.cache.database.entity.TenantConfig;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
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
public final class TenantDao_Impl implements TenantDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Tenant> __insertionAdapterOfTenant;

  private final EntityInsertionAdapter<Tenant> __insertionAdapterOfTenant_1;

  private final EntityInsertionAdapter<Tenant> __insertionAdapterOfTenant_2;

  private final EntityInsertionAdapter<Tenant> __insertionAdapterOfTenant_3;

  private final EntityInsertionAdapter<Tenant> __insertionAdapterOfTenant_4;

  private final EntityInsertionAdapter<TenantConfig> __insertionAdapterOfTenantConfig;

  private final EntityDeletionOrUpdateAdapter<Tenant> __deletionAdapterOfTenant;

  private final EntityDeletionOrUpdateAdapter<Tenant> __updateAdapterOfTenant;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public TenantDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTenant = new EntityInsertionAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tenant` (`id`,`name`,`api_key`,`name_space`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getApiKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApiKey());
        }
        if (value.getNamespace() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNamespace());
        }
      }
    };
    this.__insertionAdapterOfTenant_1 = new EntityInsertionAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `tenant` (`id`,`name`,`api_key`,`name_space`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getApiKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApiKey());
        }
        if (value.getNamespace() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNamespace());
        }
      }
    };
    this.__insertionAdapterOfTenant_2 = new EntityInsertionAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tenant` (`id`,`name`,`api_key`,`name_space`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getApiKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApiKey());
        }
        if (value.getNamespace() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNamespace());
        }
      }
    };
    this.__insertionAdapterOfTenant_3 = new EntityInsertionAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tenant` (`id`,`name`,`api_key`,`name_space`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getApiKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApiKey());
        }
        if (value.getNamespace() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNamespace());
        }
      }
    };
    this.__insertionAdapterOfTenant_4 = new EntityInsertionAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `tenant` (`id`,`name`,`api_key`,`name_space`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getApiKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApiKey());
        }
        if (value.getNamespace() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNamespace());
        }
      }
    };
    this.__insertionAdapterOfTenantConfig = new EntityInsertionAdapter<TenantConfig>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tenant_config` (`tenant_id`,`config_key`,`config_value`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TenantConfig value) {
        if (value.getTenantId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTenantId());
        }
        if (value.getKey() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getKey());
        }
        if (value.getValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getValue());
        }
      }
    };
    this.__deletionAdapterOfTenant = new EntityDeletionOrUpdateAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tenant` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfTenant = new EntityDeletionOrUpdateAdapter<Tenant>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tenant` SET `id` = ?,`name` = ?,`api_key` = ?,`name_space` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tenant value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getApiKey() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getApiKey());
        }
        if (value.getNamespace() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNamespace());
        }
        if (value.getId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tenant";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<Tenant> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<Tenant> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<Tenant> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<Tenant> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<Tenant> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final List<TenantConfig> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenantConfig.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void save(final Tenant tenant) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTenant_3.insert(tenant);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTenant.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<Tenant> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTenant.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Tenant t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTenant.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
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
  public Single<TenantAndConfig> getTenant(final String id) {
    final String _sql = "SELECT * FROM tenant WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return RxRoom.createSingle(new Callable<TenantAndConfig>() {
      @Override
      public TenantAndConfig call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfApiKey = CursorUtil.getColumnIndexOrThrow(_cursor, "api_key");
            final int _cursorIndexOfNamespace = CursorUtil.getColumnIndexOrThrow(_cursor, "name_space");
            final HashMap<String, ArrayList<TenantConfig>> _collectionConfigs = new HashMap<String, ArrayList<TenantConfig>>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey = _cursor.getString(_cursorIndexOfId);
                ArrayList<TenantConfig> _tmpConfigsCollection = _collectionConfigs.get(_tmpKey);
                if (_tmpConfigsCollection == null) {
                  _tmpConfigsCollection = new ArrayList<TenantConfig>();
                  _collectionConfigs.put(_tmpKey, _tmpConfigsCollection);
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiptenantConfigAscomRipbullErtcCacheDatabaseEntityTenantConfig(_collectionConfigs);
            final TenantAndConfig _result;
            if(_cursor.moveToFirst()) {
              final Tenant _tmpTenant;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfApiKey) && _cursor.isNull(_cursorIndexOfNamespace))) {
                final String _tmpId;
                if (_cursor.isNull(_cursorIndexOfId)) {
                  _tmpId = null;
                } else {
                  _tmpId = _cursor.getString(_cursorIndexOfId);
                }
                final String _tmpName;
                if (_cursor.isNull(_cursorIndexOfName)) {
                  _tmpName = null;
                } else {
                  _tmpName = _cursor.getString(_cursorIndexOfName);
                }
                final String _tmpApiKey;
                if (_cursor.isNull(_cursorIndexOfApiKey)) {
                  _tmpApiKey = null;
                } else {
                  _tmpApiKey = _cursor.getString(_cursorIndexOfApiKey);
                }
                final String _tmpNamespace;
                if (_cursor.isNull(_cursorIndexOfNamespace)) {
                  _tmpNamespace = null;
                } else {
                  _tmpNamespace = _cursor.getString(_cursorIndexOfNamespace);
                }
                _tmpTenant = new Tenant(_tmpId,_tmpName,_tmpApiKey,_tmpNamespace);
              }  else  {
                _tmpTenant = null;
              }
              ArrayList<TenantConfig> _tmpConfigsCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                _tmpConfigsCollection_1 = _collectionConfigs.get(_tmpKey_1);
              }
              if (_tmpConfigsCollection_1 == null) {
                _tmpConfigsCollection_1 = new ArrayList<TenantConfig>();
              }
              _result = new TenantAndConfig();
              _result.setTenant(_tmpTenant);
              _result.setConfigs(_tmpConfigsCollection_1);
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
  public Single<String> getTenantConfigValue(final String id, final String key) {
    final String _sql = "SELECT config_value FROM tenant_config WHERE tenant_id = ? AND config_key = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    _argIndex = 2;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    return RxRoom.createSingle(new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            if (_cursor.isNull(0)) {
              _result = null;
            } else {
              _result = _cursor.getString(0);
            }
          } else {
            _result = null;
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
  public String getFeatureEnabled(final String id, final String key) {
    final String _sql = "SELECT config_value FROM tenant_config WHERE tenant_id = ? AND config_key = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    _argIndex = 2;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
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
  public TenantAndConfig getAll() {
    final String _sql = "SELECT * FROM Tenant";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
      try {
        final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
        final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
        final int _cursorIndexOfApiKey = CursorUtil.getColumnIndexOrThrow(_cursor, "api_key");
        final int _cursorIndexOfNamespace = CursorUtil.getColumnIndexOrThrow(_cursor, "name_space");
        final HashMap<String, ArrayList<TenantConfig>> _collectionConfigs = new HashMap<String, ArrayList<TenantConfig>>();
        while (_cursor.moveToNext()) {
          if (!_cursor.isNull(_cursorIndexOfId)) {
            final String _tmpKey = _cursor.getString(_cursorIndexOfId);
            ArrayList<TenantConfig> _tmpConfigsCollection = _collectionConfigs.get(_tmpKey);
            if (_tmpConfigsCollection == null) {
              _tmpConfigsCollection = new ArrayList<TenantConfig>();
              _collectionConfigs.put(_tmpKey, _tmpConfigsCollection);
            }
          }
        }
        _cursor.moveToPosition(-1);
        __fetchRelationshiptenantConfigAscomRipbullErtcCacheDatabaseEntityTenantConfig(_collectionConfigs);
        final TenantAndConfig _result;
        if(_cursor.moveToFirst()) {
          final Tenant _tmpTenant;
          if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfApiKey) && _cursor.isNull(_cursorIndexOfNamespace))) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpApiKey;
            if (_cursor.isNull(_cursorIndexOfApiKey)) {
              _tmpApiKey = null;
            } else {
              _tmpApiKey = _cursor.getString(_cursorIndexOfApiKey);
            }
            final String _tmpNamespace;
            if (_cursor.isNull(_cursorIndexOfNamespace)) {
              _tmpNamespace = null;
            } else {
              _tmpNamespace = _cursor.getString(_cursorIndexOfNamespace);
            }
            _tmpTenant = new Tenant(_tmpId,_tmpName,_tmpApiKey,_tmpNamespace);
          }  else  {
            _tmpTenant = null;
          }
          ArrayList<TenantConfig> _tmpConfigsCollection_1 = null;
          if (!_cursor.isNull(_cursorIndexOfId)) {
            final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
            _tmpConfigsCollection_1 = _collectionConfigs.get(_tmpKey_1);
          }
          if (_tmpConfigsCollection_1 == null) {
            _tmpConfigsCollection_1 = new ArrayList<TenantConfig>();
          }
          _result = new TenantAndConfig();
          _result.setTenant(_tmpTenant);
          _result.setConfigs(_tmpConfigsCollection_1);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshiptenantConfigAscomRipbullErtcCacheDatabaseEntityTenantConfig(
      final HashMap<String, ArrayList<TenantConfig>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<TenantConfig>> _tmpInnerMap = new HashMap<String, ArrayList<TenantConfig>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptenantConfigAscomRipbullErtcCacheDatabaseEntityTenantConfig(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<TenantConfig>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptenantConfigAscomRipbullErtcCacheDatabaseEntityTenantConfig(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `tenant_id`,`config_key`,`config_value` FROM `tenant_config` WHERE `tenant_id` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "tenant_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfTenantId = 0;
      final int _cursorIndexOfKey = 1;
      final int _cursorIndexOfValue = 2;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<TenantConfig> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final TenantConfig _item_1;
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            final String _tmpKey_1;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey_1 = null;
            } else {
              _tmpKey_1 = _cursor.getString(_cursorIndexOfKey);
            }
            final String _tmpValue;
            if (_cursor.isNull(_cursorIndexOfValue)) {
              _tmpValue = null;
            } else {
              _tmpValue = _cursor.getString(_cursorIndexOfValue);
            }
            _item_1 = new TenantConfig(_tmpTenantId,_tmpKey_1,_tmpValue);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
