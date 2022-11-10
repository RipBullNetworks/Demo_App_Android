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
import com.ripbull.ertc.cache.database.entity.ProfanityFilter;
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
public final class ProfanityFilterDao_Impl implements ProfanityFilterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProfanityFilter> __insertionAdapterOfProfanityFilter;

  private final EntityInsertionAdapter<ProfanityFilter> __insertionAdapterOfProfanityFilter_1;

  private final EntityInsertionAdapter<ProfanityFilter> __insertionAdapterOfProfanityFilter_2;

  private final EntityInsertionAdapter<ProfanityFilter> __insertionAdapterOfProfanityFilter_3;

  private final EntityInsertionAdapter<ProfanityFilter> __insertionAdapterOfProfanityFilter_4;

  private final EntityDeletionOrUpdateAdapter<ProfanityFilter> __deletionAdapterOfProfanityFilter;

  private final EntityDeletionOrUpdateAdapter<ProfanityFilter> __updateAdapterOfProfanityFilter;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ProfanityFilterDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProfanityFilter = new EntityInsertionAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `profanity_filter` (`keyword`,`tenant_id`,`regex`,`action_type`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getRegex() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegex());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfProfanityFilter_1 = new EntityInsertionAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `profanity_filter` (`keyword`,`tenant_id`,`regex`,`action_type`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getRegex() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegex());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfProfanityFilter_2 = new EntityInsertionAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `profanity_filter` (`keyword`,`tenant_id`,`regex`,`action_type`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getRegex() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegex());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfProfanityFilter_3 = new EntityInsertionAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `profanity_filter` (`keyword`,`tenant_id`,`regex`,`action_type`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getRegex() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegex());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionType());
        }
      }
    };
    this.__insertionAdapterOfProfanityFilter_4 = new EntityInsertionAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `profanity_filter` (`keyword`,`tenant_id`,`regex`,`action_type`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getRegex() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegex());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionType());
        }
      }
    };
    this.__deletionAdapterOfProfanityFilter = new EntityDeletionOrUpdateAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `profanity_filter` WHERE `keyword` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
      }
    };
    this.__updateAdapterOfProfanityFilter = new EntityDeletionOrUpdateAdapter<ProfanityFilter>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `profanity_filter` SET `keyword` = ?,`tenant_id` = ?,`regex` = ?,`action_type` = ? WHERE `keyword` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProfanityFilter value) {
        if (value.getKeyword() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getKeyword());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getRegex() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRegex());
        }
        if (value.getActionType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActionType());
        }
        if (value.getKeyword() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getKeyword());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM profanity_filter";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<ProfanityFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<ProfanityFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<ProfanityFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<ProfanityFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<ProfanityFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProfanityFilter.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProfanityFilter.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<ProfanityFilter> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProfanityFilter.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ProfanityFilter t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProfanityFilter.handle(t);
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
  public Flowable<List<ProfanityFilter>> getProfanityFilter(final String tenantId) {
    final String _sql = "SELECT * FROM profanity_filter WHERE tenant_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"profanity_filter"}, new Callable<List<ProfanityFilter>>() {
      @Override
      public List<ProfanityFilter> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKeyword = CursorUtil.getColumnIndexOrThrow(_cursor, "keyword");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfRegex = CursorUtil.getColumnIndexOrThrow(_cursor, "regex");
          final int _cursorIndexOfActionType = CursorUtil.getColumnIndexOrThrow(_cursor, "action_type");
          final List<ProfanityFilter> _result = new ArrayList<ProfanityFilter>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ProfanityFilter _item;
            final String _tmpKeyword;
            if (_cursor.isNull(_cursorIndexOfKeyword)) {
              _tmpKeyword = null;
            } else {
              _tmpKeyword = _cursor.getString(_cursorIndexOfKeyword);
            }
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            final String _tmpRegex;
            if (_cursor.isNull(_cursorIndexOfRegex)) {
              _tmpRegex = null;
            } else {
              _tmpRegex = _cursor.getString(_cursorIndexOfRegex);
            }
            final String _tmpActionType;
            if (_cursor.isNull(_cursorIndexOfActionType)) {
              _tmpActionType = null;
            } else {
              _tmpActionType = _cursor.getString(_cursorIndexOfActionType);
            }
            _item = new ProfanityFilter(_tmpKeyword,_tmpTenantId,_tmpRegex,_tmpActionType);
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
