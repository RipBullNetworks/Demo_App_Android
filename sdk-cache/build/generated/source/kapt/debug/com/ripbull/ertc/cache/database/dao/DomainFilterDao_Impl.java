package com.ripbull.ertc.cache.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ripbull.ertc.cache.database.entity.DomainFilter;
import io.reactivex.Flowable;
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
public final class DomainFilterDao_Impl implements DomainFilterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DomainFilter> __insertionAdapterOfDomainFilter;

  private final EntityInsertionAdapter<DomainFilter> __insertionAdapterOfDomainFilter_1;

  private final EntityInsertionAdapter<DomainFilter> __insertionAdapterOfDomainFilter_2;

  private final EntityInsertionAdapter<DomainFilter> __insertionAdapterOfDomainFilter_3;

  private final EntityInsertionAdapter<DomainFilter> __insertionAdapterOfDomainFilter_4;

  private final EntityDeletionOrUpdateAdapter<DomainFilter> __deletionAdapterOfDomainFilter;

  private final EntityDeletionOrUpdateAdapter<DomainFilter> __updateAdapterOfDomainFilter;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DomainFilterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDomainFilter = new EntityInsertionAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `domain_filter` (`domain`,`tenant_id`,`action_type`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfDomainFilter_1 = new EntityInsertionAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `domain_filter` (`domain`,`tenant_id`,`action_type`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfDomainFilter_2 = new EntityInsertionAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `domain_filter` (`domain`,`tenant_id`,`action_type`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfDomainFilter_3 = new EntityInsertionAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `domain_filter` (`domain`,`tenant_id`,`action_type`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfDomainFilter_4 = new EntityInsertionAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `domain_filter` (`domain`,`tenant_id`,`action_type`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionType());
        }
      }
    };
    this.__deletionAdapterOfDomainFilter = new EntityDeletionOrUpdateAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `domain_filter` WHERE `domain` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
      }
    };
    this.__updateAdapterOfDomainFilter = new EntityDeletionOrUpdateAdapter<DomainFilter>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `domain_filter` SET `domain` = ?,`tenant_id` = ?,`action_type` = ? WHERE `domain` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DomainFilter value) {
        if (value.getDomain() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDomain());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getActionType());
        }
        if (value.getDomain() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDomain());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM domain_filter";
        return _query;
      }
    };
  }

  @Override
  public void insert(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<DomainFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<DomainFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<DomainFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<DomainFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<DomainFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDomainFilter.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDomainFilter.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<DomainFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDomainFilter.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final DomainFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDomainFilter.handle(t);
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
  public Flowable<List<DomainFilter>> getDomainFilter(final String tenantId) {
    final String _sql = "SELECT * FROM domain_filter WHERE tenant_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"domain_filter"}, new Callable<List<DomainFilter>>() {
      @Override
      public List<DomainFilter> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDomain = CursorUtil.getColumnIndexOrThrow(_cursor, "domain");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfActionType = CursorUtil.getColumnIndexOrThrow(_cursor, "action_type");
          final List<DomainFilter> _result = new ArrayList<DomainFilter>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DomainFilter _item;
            final String _tmpDomain;
            if (_cursor.isNull(_cursorIndexOfDomain)) {
              _tmpDomain = null;
            } else {
              _tmpDomain = _cursor.getString(_cursorIndexOfDomain);
            }
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            final String _tmpActionType;
            if (_cursor.isNull(_cursorIndexOfActionType)) {
              _tmpActionType = null;
            } else {
              _tmpActionType = _cursor.getString(_cursorIndexOfActionType);
            }
            _item = new DomainFilter(_tmpDomain,_tmpTenantId,_tmpActionType);
            _result.add(_item);
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
}
