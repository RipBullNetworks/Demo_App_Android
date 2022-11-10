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
import com.ripbull.ertc.cache.database.converter.UserListConverter;
import com.ripbull.ertc.cache.database.entity.Group;
import com.ripbull.ertc.cache.database.entity.User;
import io.reactivex.Flowable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GroupDao_Impl implements GroupDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup_1;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup_2;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup_3;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup_4;

  private final EntityDeletionOrUpdateAdapter<Group> __deletionAdapterOfGroup;

  private final EntityDeletionOrUpdateAdapter<Group> __updateAdapterOfGroup;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByGroupId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateGroupStatus;

  public GroupDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGroup = new EntityInsertionAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `group` (`group_id`,`tenant_id`,`thread_id`,`group_type`,`name`,`login_type`,`group_pic`,`group_thumb`,`group_desc`,`login_timestamp`,`group_users`,`joined`,`participants_count`,`group_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getGroupType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGroupType());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLoginType());
        }
        if (value.getGroupPic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGroupPic());
        }
        if (value.getGroupThumb() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGroupThumb());
        }
        if (value.getGroupDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getGroupDesc());
        }
        stmt.bindLong(10, value.getLoginTimestamp());
        final String _tmp = UserListConverter.fromArrayList(value.getGroupUsers());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getJoined() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getJoined());
        }
        if (value.getParticipantsCount() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getParticipantsCount());
        }
        if (value.getGroupStatus() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getGroupStatus());
        }
      }
    };
    this.__insertionAdapterOfGroup_1 = new EntityInsertionAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `group` (`group_id`,`tenant_id`,`thread_id`,`group_type`,`name`,`login_type`,`group_pic`,`group_thumb`,`group_desc`,`login_timestamp`,`group_users`,`joined`,`participants_count`,`group_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getGroupType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGroupType());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLoginType());
        }
        if (value.getGroupPic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGroupPic());
        }
        if (value.getGroupThumb() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGroupThumb());
        }
        if (value.getGroupDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getGroupDesc());
        }
        stmt.bindLong(10, value.getLoginTimestamp());
        final String _tmp = UserListConverter.fromArrayList(value.getGroupUsers());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getJoined() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getJoined());
        }
        if (value.getParticipantsCount() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getParticipantsCount());
        }
        if (value.getGroupStatus() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getGroupStatus());
        }
      }
    };
    this.__insertionAdapterOfGroup_2 = new EntityInsertionAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `group` (`group_id`,`tenant_id`,`thread_id`,`group_type`,`name`,`login_type`,`group_pic`,`group_thumb`,`group_desc`,`login_timestamp`,`group_users`,`joined`,`participants_count`,`group_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getGroupType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGroupType());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLoginType());
        }
        if (value.getGroupPic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGroupPic());
        }
        if (value.getGroupThumb() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGroupThumb());
        }
        if (value.getGroupDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getGroupDesc());
        }
        stmt.bindLong(10, value.getLoginTimestamp());
        final String _tmp = UserListConverter.fromArrayList(value.getGroupUsers());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getJoined() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getJoined());
        }
        if (value.getParticipantsCount() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getParticipantsCount());
        }
        if (value.getGroupStatus() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getGroupStatus());
        }
      }
    };
    this.__insertionAdapterOfGroup_3 = new EntityInsertionAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `group` (`group_id`,`tenant_id`,`thread_id`,`group_type`,`name`,`login_type`,`group_pic`,`group_thumb`,`group_desc`,`login_timestamp`,`group_users`,`joined`,`participants_count`,`group_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getGroupType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGroupType());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLoginType());
        }
        if (value.getGroupPic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGroupPic());
        }
        if (value.getGroupThumb() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGroupThumb());
        }
        if (value.getGroupDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getGroupDesc());
        }
        stmt.bindLong(10, value.getLoginTimestamp());
        final String _tmp = UserListConverter.fromArrayList(value.getGroupUsers());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getJoined() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getJoined());
        }
        if (value.getParticipantsCount() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getParticipantsCount());
        }
        if (value.getGroupStatus() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getGroupStatus());
        }
      }
    };
    this.__insertionAdapterOfGroup_4 = new EntityInsertionAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `group` (`group_id`,`tenant_id`,`thread_id`,`group_type`,`name`,`login_type`,`group_pic`,`group_thumb`,`group_desc`,`login_timestamp`,`group_users`,`joined`,`participants_count`,`group_status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getGroupType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGroupType());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLoginType());
        }
        if (value.getGroupPic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGroupPic());
        }
        if (value.getGroupThumb() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGroupThumb());
        }
        if (value.getGroupDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getGroupDesc());
        }
        stmt.bindLong(10, value.getLoginTimestamp());
        final String _tmp = UserListConverter.fromArrayList(value.getGroupUsers());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getJoined() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getJoined());
        }
        if (value.getParticipantsCount() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getParticipantsCount());
        }
        if (value.getGroupStatus() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getGroupStatus());
        }
      }
    };
    this.__deletionAdapterOfGroup = new EntityDeletionOrUpdateAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `group` WHERE `group_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
      }
    };
    this.__updateAdapterOfGroup = new EntityDeletionOrUpdateAdapter<Group>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `group` SET `group_id` = ?,`tenant_id` = ?,`thread_id` = ?,`group_type` = ?,`name` = ?,`login_type` = ?,`group_pic` = ?,`group_thumb` = ?,`group_desc` = ?,`login_timestamp` = ?,`group_users` = ?,`joined` = ?,`participants_count` = ?,`group_status` = ? WHERE `group_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Group value) {
        if (value.getGroupId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGroupId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getThreadId());
        }
        if (value.getGroupType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGroupType());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLoginType());
        }
        if (value.getGroupPic() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGroupPic());
        }
        if (value.getGroupThumb() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGroupThumb());
        }
        if (value.getGroupDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getGroupDesc());
        }
        stmt.bindLong(10, value.getLoginTimestamp());
        final String _tmp = UserListConverter.fromArrayList(value.getGroupUsers());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getJoined() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getJoined());
        }
        if (value.getParticipantsCount() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getParticipantsCount());
        }
        if (value.getGroupStatus() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getGroupStatus());
        }
        if (value.getGroupId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getGroupId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM `group`";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByGroupId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM `group` WHERE group_id = (?)";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateGroupStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE `group` SET group_status = ? WHERE group_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<Group> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<Group> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<Group> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<Group> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<Group> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGroup.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<Group> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGroup.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Group t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGroup.handle(t);
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
  public void deleteByGroupId(final String groupId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByGroupId.acquire();
    int _argIndex = 1;
    if (groupId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, groupId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByGroupId.release(_stmt);
    }
  }

  @Override
  public void updateGroupStatus(final String groupId, final String groupStatus) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateGroupStatus.acquire();
    int _argIndex = 1;
    if (groupStatus == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, groupStatus);
    }
    _argIndex = 2;
    if (groupId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, groupId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateGroupStatus.release(_stmt);
    }
  }

  @Override
  public Flowable<List<Group>> getAllGroup(final String tenantId) {
    final String _sql = "SELECT * FROM `group` WHERE tenant_id = (?) ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"group"}, new Callable<List<Group>>() {
      @Override
      public List<Group> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfGroupType = CursorUtil.getColumnIndexOrThrow(_cursor, "group_type");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfGroupPic = CursorUtil.getColumnIndexOrThrow(_cursor, "group_pic");
          final int _cursorIndexOfGroupThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "group_thumb");
          final int _cursorIndexOfGroupDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "group_desc");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfGroupUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "group_users");
          final int _cursorIndexOfJoined = CursorUtil.getColumnIndexOrThrow(_cursor, "joined");
          final int _cursorIndexOfParticipantsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "participants_count");
          final int _cursorIndexOfGroupStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "group_status");
          final List<Group> _result = new ArrayList<Group>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Group _item;
            _item = new Group();
            final String _tmpGroupId;
            if (_cursor.isNull(_cursorIndexOfGroupId)) {
              _tmpGroupId = null;
            } else {
              _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
            }
            _item.setGroupId(_tmpGroupId);
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            _item.setTenantId(_tmpTenantId);
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            _item.setThreadId(_tmpThreadId);
            final String _tmpGroupType;
            if (_cursor.isNull(_cursorIndexOfGroupType)) {
              _tmpGroupType = null;
            } else {
              _tmpGroupType = _cursor.getString(_cursorIndexOfGroupType);
            }
            _item.setGroupType(_tmpGroupType);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpLoginType;
            if (_cursor.isNull(_cursorIndexOfLoginType)) {
              _tmpLoginType = null;
            } else {
              _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
            }
            _item.setLoginType(_tmpLoginType);
            final String _tmpGroupPic;
            if (_cursor.isNull(_cursorIndexOfGroupPic)) {
              _tmpGroupPic = null;
            } else {
              _tmpGroupPic = _cursor.getString(_cursorIndexOfGroupPic);
            }
            _item.setGroupPic(_tmpGroupPic);
            final String _tmpGroupThumb;
            if (_cursor.isNull(_cursorIndexOfGroupThumb)) {
              _tmpGroupThumb = null;
            } else {
              _tmpGroupThumb = _cursor.getString(_cursorIndexOfGroupThumb);
            }
            _item.setGroupThumb(_tmpGroupThumb);
            final String _tmpGroupDesc;
            if (_cursor.isNull(_cursorIndexOfGroupDesc)) {
              _tmpGroupDesc = null;
            } else {
              _tmpGroupDesc = _cursor.getString(_cursorIndexOfGroupDesc);
            }
            _item.setGroupDesc(_tmpGroupDesc);
            final long _tmpLoginTimestamp;
            _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
            _item.setLoginTimestamp(_tmpLoginTimestamp);
            final ArrayList<User> _tmpGroupUsers;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupUsers)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupUsers);
            }
            _tmpGroupUsers = UserListConverter.fromString(_tmp);
            _item.setGroupUsers(_tmpGroupUsers);
            final Integer _tmpJoined;
            if (_cursor.isNull(_cursorIndexOfJoined)) {
              _tmpJoined = null;
            } else {
              _tmpJoined = _cursor.getInt(_cursorIndexOfJoined);
            }
            _item.setJoined(_tmpJoined);
            final Integer _tmpParticipantsCount;
            if (_cursor.isNull(_cursorIndexOfParticipantsCount)) {
              _tmpParticipantsCount = null;
            } else {
              _tmpParticipantsCount = _cursor.getInt(_cursorIndexOfParticipantsCount);
            }
            _item.setParticipantsCount(_tmpParticipantsCount);
            final String _tmpGroupStatus;
            if (_cursor.isNull(_cursorIndexOfGroupStatus)) {
              _tmpGroupStatus = null;
            } else {
              _tmpGroupStatus = _cursor.getString(_cursorIndexOfGroupStatus);
            }
            _item.setGroupStatus(_tmpGroupStatus);
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

  @Override
  public Flowable<Group> getGroupById(final String tenantId, final String groupId) {
    final String _sql = "SELECT * FROM `group` WHERE tenant_id = (?) AND group_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (groupId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, groupId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"group"}, new Callable<Group>() {
      @Override
      public Group call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfGroupType = CursorUtil.getColumnIndexOrThrow(_cursor, "group_type");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfGroupPic = CursorUtil.getColumnIndexOrThrow(_cursor, "group_pic");
          final int _cursorIndexOfGroupThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "group_thumb");
          final int _cursorIndexOfGroupDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "group_desc");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfGroupUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "group_users");
          final int _cursorIndexOfJoined = CursorUtil.getColumnIndexOrThrow(_cursor, "joined");
          final int _cursorIndexOfParticipantsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "participants_count");
          final int _cursorIndexOfGroupStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "group_status");
          final Group _result;
          if(_cursor.moveToFirst()) {
            _result = new Group();
            final String _tmpGroupId;
            if (_cursor.isNull(_cursorIndexOfGroupId)) {
              _tmpGroupId = null;
            } else {
              _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
            }
            _result.setGroupId(_tmpGroupId);
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            _result.setTenantId(_tmpTenantId);
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            _result.setThreadId(_tmpThreadId);
            final String _tmpGroupType;
            if (_cursor.isNull(_cursorIndexOfGroupType)) {
              _tmpGroupType = null;
            } else {
              _tmpGroupType = _cursor.getString(_cursorIndexOfGroupType);
            }
            _result.setGroupType(_tmpGroupType);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _result.setName(_tmpName);
            final String _tmpLoginType;
            if (_cursor.isNull(_cursorIndexOfLoginType)) {
              _tmpLoginType = null;
            } else {
              _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
            }
            _result.setLoginType(_tmpLoginType);
            final String _tmpGroupPic;
            if (_cursor.isNull(_cursorIndexOfGroupPic)) {
              _tmpGroupPic = null;
            } else {
              _tmpGroupPic = _cursor.getString(_cursorIndexOfGroupPic);
            }
            _result.setGroupPic(_tmpGroupPic);
            final String _tmpGroupThumb;
            if (_cursor.isNull(_cursorIndexOfGroupThumb)) {
              _tmpGroupThumb = null;
            } else {
              _tmpGroupThumb = _cursor.getString(_cursorIndexOfGroupThumb);
            }
            _result.setGroupThumb(_tmpGroupThumb);
            final String _tmpGroupDesc;
            if (_cursor.isNull(_cursorIndexOfGroupDesc)) {
              _tmpGroupDesc = null;
            } else {
              _tmpGroupDesc = _cursor.getString(_cursorIndexOfGroupDesc);
            }
            _result.setGroupDesc(_tmpGroupDesc);
            final long _tmpLoginTimestamp;
            _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
            _result.setLoginTimestamp(_tmpLoginTimestamp);
            final ArrayList<User> _tmpGroupUsers;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupUsers)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupUsers);
            }
            _tmpGroupUsers = UserListConverter.fromString(_tmp);
            _result.setGroupUsers(_tmpGroupUsers);
            final Integer _tmpJoined;
            if (_cursor.isNull(_cursorIndexOfJoined)) {
              _tmpJoined = null;
            } else {
              _tmpJoined = _cursor.getInt(_cursorIndexOfJoined);
            }
            _result.setJoined(_tmpJoined);
            final Integer _tmpParticipantsCount;
            if (_cursor.isNull(_cursorIndexOfParticipantsCount)) {
              _tmpParticipantsCount = null;
            } else {
              _tmpParticipantsCount = _cursor.getInt(_cursorIndexOfParticipantsCount);
            }
            _result.setParticipantsCount(_tmpParticipantsCount);
            final String _tmpGroupStatus;
            if (_cursor.isNull(_cursorIndexOfGroupStatus)) {
              _tmpGroupStatus = null;
            } else {
              _tmpGroupStatus = _cursor.getString(_cursorIndexOfGroupStatus);
            }
            _result.setGroupStatus(_tmpGroupStatus);
          } else {
            _result = null;
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
  public Group getGroupById(final String groupId) {
    final String _sql = "SELECT * FROM `group` WHERE group_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (groupId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, groupId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfGroupType = CursorUtil.getColumnIndexOrThrow(_cursor, "group_type");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfGroupPic = CursorUtil.getColumnIndexOrThrow(_cursor, "group_pic");
      final int _cursorIndexOfGroupThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "group_thumb");
      final int _cursorIndexOfGroupDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "group_desc");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfGroupUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "group_users");
      final int _cursorIndexOfJoined = CursorUtil.getColumnIndexOrThrow(_cursor, "joined");
      final int _cursorIndexOfParticipantsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "participants_count");
      final int _cursorIndexOfGroupStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "group_status");
      final Group _result;
      if(_cursor.moveToFirst()) {
        _result = new Group();
        final String _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        }
        _result.setGroupId(_tmpGroupId);
        final String _tmpTenantId;
        if (_cursor.isNull(_cursorIndexOfTenantId)) {
          _tmpTenantId = null;
        } else {
          _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
        }
        _result.setTenantId(_tmpTenantId);
        final String _tmpThreadId;
        if (_cursor.isNull(_cursorIndexOfThreadId)) {
          _tmpThreadId = null;
        } else {
          _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
        }
        _result.setThreadId(_tmpThreadId);
        final String _tmpGroupType;
        if (_cursor.isNull(_cursorIndexOfGroupType)) {
          _tmpGroupType = null;
        } else {
          _tmpGroupType = _cursor.getString(_cursorIndexOfGroupType);
        }
        _result.setGroupType(_tmpGroupType);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpLoginType;
        if (_cursor.isNull(_cursorIndexOfLoginType)) {
          _tmpLoginType = null;
        } else {
          _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
        }
        _result.setLoginType(_tmpLoginType);
        final String _tmpGroupPic;
        if (_cursor.isNull(_cursorIndexOfGroupPic)) {
          _tmpGroupPic = null;
        } else {
          _tmpGroupPic = _cursor.getString(_cursorIndexOfGroupPic);
        }
        _result.setGroupPic(_tmpGroupPic);
        final String _tmpGroupThumb;
        if (_cursor.isNull(_cursorIndexOfGroupThumb)) {
          _tmpGroupThumb = null;
        } else {
          _tmpGroupThumb = _cursor.getString(_cursorIndexOfGroupThumb);
        }
        _result.setGroupThumb(_tmpGroupThumb);
        final String _tmpGroupDesc;
        if (_cursor.isNull(_cursorIndexOfGroupDesc)) {
          _tmpGroupDesc = null;
        } else {
          _tmpGroupDesc = _cursor.getString(_cursorIndexOfGroupDesc);
        }
        _result.setGroupDesc(_tmpGroupDesc);
        final long _tmpLoginTimestamp;
        _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
        _result.setLoginTimestamp(_tmpLoginTimestamp);
        final ArrayList<User> _tmpGroupUsers;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfGroupUsers)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfGroupUsers);
        }
        _tmpGroupUsers = UserListConverter.fromString(_tmp);
        _result.setGroupUsers(_tmpGroupUsers);
        final Integer _tmpJoined;
        if (_cursor.isNull(_cursorIndexOfJoined)) {
          _tmpJoined = null;
        } else {
          _tmpJoined = _cursor.getInt(_cursorIndexOfJoined);
        }
        _result.setJoined(_tmpJoined);
        final Integer _tmpParticipantsCount;
        if (_cursor.isNull(_cursorIndexOfParticipantsCount)) {
          _tmpParticipantsCount = null;
        } else {
          _tmpParticipantsCount = _cursor.getInt(_cursorIndexOfParticipantsCount);
        }
        _result.setParticipantsCount(_tmpParticipantsCount);
        final String _tmpGroupStatus;
        if (_cursor.isNull(_cursorIndexOfGroupStatus)) {
          _tmpGroupStatus = null;
        } else {
          _tmpGroupStatus = _cursor.getString(_cursorIndexOfGroupStatus);
        }
        _result.setGroupStatus(_tmpGroupStatus);
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
  public Group getGroupByThreadId(final String tenantId, final String threadId) {
    final String _sql = "SELECT * FROM `group` WHERE tenant_id = (?) AND thread_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfGroupType = CursorUtil.getColumnIndexOrThrow(_cursor, "group_type");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfGroupPic = CursorUtil.getColumnIndexOrThrow(_cursor, "group_pic");
      final int _cursorIndexOfGroupThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "group_thumb");
      final int _cursorIndexOfGroupDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "group_desc");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfGroupUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "group_users");
      final int _cursorIndexOfJoined = CursorUtil.getColumnIndexOrThrow(_cursor, "joined");
      final int _cursorIndexOfParticipantsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "participants_count");
      final int _cursorIndexOfGroupStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "group_status");
      final Group _result;
      if(_cursor.moveToFirst()) {
        _result = new Group();
        final String _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        }
        _result.setGroupId(_tmpGroupId);
        final String _tmpTenantId;
        if (_cursor.isNull(_cursorIndexOfTenantId)) {
          _tmpTenantId = null;
        } else {
          _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
        }
        _result.setTenantId(_tmpTenantId);
        final String _tmpThreadId;
        if (_cursor.isNull(_cursorIndexOfThreadId)) {
          _tmpThreadId = null;
        } else {
          _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
        }
        _result.setThreadId(_tmpThreadId);
        final String _tmpGroupType;
        if (_cursor.isNull(_cursorIndexOfGroupType)) {
          _tmpGroupType = null;
        } else {
          _tmpGroupType = _cursor.getString(_cursorIndexOfGroupType);
        }
        _result.setGroupType(_tmpGroupType);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpLoginType;
        if (_cursor.isNull(_cursorIndexOfLoginType)) {
          _tmpLoginType = null;
        } else {
          _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
        }
        _result.setLoginType(_tmpLoginType);
        final String _tmpGroupPic;
        if (_cursor.isNull(_cursorIndexOfGroupPic)) {
          _tmpGroupPic = null;
        } else {
          _tmpGroupPic = _cursor.getString(_cursorIndexOfGroupPic);
        }
        _result.setGroupPic(_tmpGroupPic);
        final String _tmpGroupThumb;
        if (_cursor.isNull(_cursorIndexOfGroupThumb)) {
          _tmpGroupThumb = null;
        } else {
          _tmpGroupThumb = _cursor.getString(_cursorIndexOfGroupThumb);
        }
        _result.setGroupThumb(_tmpGroupThumb);
        final String _tmpGroupDesc;
        if (_cursor.isNull(_cursorIndexOfGroupDesc)) {
          _tmpGroupDesc = null;
        } else {
          _tmpGroupDesc = _cursor.getString(_cursorIndexOfGroupDesc);
        }
        _result.setGroupDesc(_tmpGroupDesc);
        final long _tmpLoginTimestamp;
        _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
        _result.setLoginTimestamp(_tmpLoginTimestamp);
        final ArrayList<User> _tmpGroupUsers;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfGroupUsers)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfGroupUsers);
        }
        _tmpGroupUsers = UserListConverter.fromString(_tmp);
        _result.setGroupUsers(_tmpGroupUsers);
        final Integer _tmpJoined;
        if (_cursor.isNull(_cursorIndexOfJoined)) {
          _tmpJoined = null;
        } else {
          _tmpJoined = _cursor.getInt(_cursorIndexOfJoined);
        }
        _result.setJoined(_tmpJoined);
        final Integer _tmpParticipantsCount;
        if (_cursor.isNull(_cursorIndexOfParticipantsCount)) {
          _tmpParticipantsCount = null;
        } else {
          _tmpParticipantsCount = _cursor.getInt(_cursorIndexOfParticipantsCount);
        }
        _result.setParticipantsCount(_tmpParticipantsCount);
        final String _tmpGroupStatus;
        if (_cursor.isNull(_cursorIndexOfGroupStatus)) {
          _tmpGroupStatus = null;
        } else {
          _tmpGroupStatus = _cursor.getString(_cursorIndexOfGroupStatus);
        }
        _result.setGroupStatus(_tmpGroupStatus);
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
  public Group getGroupByIdInSync(final String tenantId, final String groupId) {
    final String _sql = "SELECT * FROM `group` WHERE tenant_id = (?) AND group_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (groupId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, groupId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfGroupType = CursorUtil.getColumnIndexOrThrow(_cursor, "group_type");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfGroupPic = CursorUtil.getColumnIndexOrThrow(_cursor, "group_pic");
      final int _cursorIndexOfGroupThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "group_thumb");
      final int _cursorIndexOfGroupDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "group_desc");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfGroupUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "group_users");
      final int _cursorIndexOfJoined = CursorUtil.getColumnIndexOrThrow(_cursor, "joined");
      final int _cursorIndexOfParticipantsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "participants_count");
      final int _cursorIndexOfGroupStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "group_status");
      final Group _result;
      if(_cursor.moveToFirst()) {
        _result = new Group();
        final String _tmpGroupId;
        if (_cursor.isNull(_cursorIndexOfGroupId)) {
          _tmpGroupId = null;
        } else {
          _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
        }
        _result.setGroupId(_tmpGroupId);
        final String _tmpTenantId;
        if (_cursor.isNull(_cursorIndexOfTenantId)) {
          _tmpTenantId = null;
        } else {
          _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
        }
        _result.setTenantId(_tmpTenantId);
        final String _tmpThreadId;
        if (_cursor.isNull(_cursorIndexOfThreadId)) {
          _tmpThreadId = null;
        } else {
          _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
        }
        _result.setThreadId(_tmpThreadId);
        final String _tmpGroupType;
        if (_cursor.isNull(_cursorIndexOfGroupType)) {
          _tmpGroupType = null;
        } else {
          _tmpGroupType = _cursor.getString(_cursorIndexOfGroupType);
        }
        _result.setGroupType(_tmpGroupType);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpLoginType;
        if (_cursor.isNull(_cursorIndexOfLoginType)) {
          _tmpLoginType = null;
        } else {
          _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
        }
        _result.setLoginType(_tmpLoginType);
        final String _tmpGroupPic;
        if (_cursor.isNull(_cursorIndexOfGroupPic)) {
          _tmpGroupPic = null;
        } else {
          _tmpGroupPic = _cursor.getString(_cursorIndexOfGroupPic);
        }
        _result.setGroupPic(_tmpGroupPic);
        final String _tmpGroupThumb;
        if (_cursor.isNull(_cursorIndexOfGroupThumb)) {
          _tmpGroupThumb = null;
        } else {
          _tmpGroupThumb = _cursor.getString(_cursorIndexOfGroupThumb);
        }
        _result.setGroupThumb(_tmpGroupThumb);
        final String _tmpGroupDesc;
        if (_cursor.isNull(_cursorIndexOfGroupDesc)) {
          _tmpGroupDesc = null;
        } else {
          _tmpGroupDesc = _cursor.getString(_cursorIndexOfGroupDesc);
        }
        _result.setGroupDesc(_tmpGroupDesc);
        final long _tmpLoginTimestamp;
        _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
        _result.setLoginTimestamp(_tmpLoginTimestamp);
        final ArrayList<User> _tmpGroupUsers;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfGroupUsers)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfGroupUsers);
        }
        _tmpGroupUsers = UserListConverter.fromString(_tmp);
        _result.setGroupUsers(_tmpGroupUsers);
        final Integer _tmpJoined;
        if (_cursor.isNull(_cursorIndexOfJoined)) {
          _tmpJoined = null;
        } else {
          _tmpJoined = _cursor.getInt(_cursorIndexOfJoined);
        }
        _result.setJoined(_tmpJoined);
        final Integer _tmpParticipantsCount;
        if (_cursor.isNull(_cursorIndexOfParticipantsCount)) {
          _tmpParticipantsCount = null;
        } else {
          _tmpParticipantsCount = _cursor.getInt(_cursorIndexOfParticipantsCount);
        }
        _result.setParticipantsCount(_tmpParticipantsCount);
        final String _tmpGroupStatus;
        if (_cursor.isNull(_cursorIndexOfGroupStatus)) {
          _tmpGroupStatus = null;
        } else {
          _tmpGroupStatus = _cursor.getString(_cursorIndexOfGroupStatus);
        }
        _result.setGroupStatus(_tmpGroupStatus);
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
  public Flowable<List<Group>> getActiveGroup(final String status) {
    final String _sql = "SELECT * FROM `group` WHERE group_status = ? ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"group"}, new Callable<List<Group>>() {
      @Override
      public List<Group> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfGroupType = CursorUtil.getColumnIndexOrThrow(_cursor, "group_type");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfGroupPic = CursorUtil.getColumnIndexOrThrow(_cursor, "group_pic");
          final int _cursorIndexOfGroupThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "group_thumb");
          final int _cursorIndexOfGroupDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "group_desc");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfGroupUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "group_users");
          final int _cursorIndexOfJoined = CursorUtil.getColumnIndexOrThrow(_cursor, "joined");
          final int _cursorIndexOfParticipantsCount = CursorUtil.getColumnIndexOrThrow(_cursor, "participants_count");
          final int _cursorIndexOfGroupStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "group_status");
          final List<Group> _result = new ArrayList<Group>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Group _item;
            _item = new Group();
            final String _tmpGroupId;
            if (_cursor.isNull(_cursorIndexOfGroupId)) {
              _tmpGroupId = null;
            } else {
              _tmpGroupId = _cursor.getString(_cursorIndexOfGroupId);
            }
            _item.setGroupId(_tmpGroupId);
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            _item.setTenantId(_tmpTenantId);
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            _item.setThreadId(_tmpThreadId);
            final String _tmpGroupType;
            if (_cursor.isNull(_cursorIndexOfGroupType)) {
              _tmpGroupType = null;
            } else {
              _tmpGroupType = _cursor.getString(_cursorIndexOfGroupType);
            }
            _item.setGroupType(_tmpGroupType);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _item.setName(_tmpName);
            final String _tmpLoginType;
            if (_cursor.isNull(_cursorIndexOfLoginType)) {
              _tmpLoginType = null;
            } else {
              _tmpLoginType = _cursor.getString(_cursorIndexOfLoginType);
            }
            _item.setLoginType(_tmpLoginType);
            final String _tmpGroupPic;
            if (_cursor.isNull(_cursorIndexOfGroupPic)) {
              _tmpGroupPic = null;
            } else {
              _tmpGroupPic = _cursor.getString(_cursorIndexOfGroupPic);
            }
            _item.setGroupPic(_tmpGroupPic);
            final String _tmpGroupThumb;
            if (_cursor.isNull(_cursorIndexOfGroupThumb)) {
              _tmpGroupThumb = null;
            } else {
              _tmpGroupThumb = _cursor.getString(_cursorIndexOfGroupThumb);
            }
            _item.setGroupThumb(_tmpGroupThumb);
            final String _tmpGroupDesc;
            if (_cursor.isNull(_cursorIndexOfGroupDesc)) {
              _tmpGroupDesc = null;
            } else {
              _tmpGroupDesc = _cursor.getString(_cursorIndexOfGroupDesc);
            }
            _item.setGroupDesc(_tmpGroupDesc);
            final long _tmpLoginTimestamp;
            _tmpLoginTimestamp = _cursor.getLong(_cursorIndexOfLoginTimestamp);
            _item.setLoginTimestamp(_tmpLoginTimestamp);
            final ArrayList<User> _tmpGroupUsers;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupUsers)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupUsers);
            }
            _tmpGroupUsers = UserListConverter.fromString(_tmp);
            _item.setGroupUsers(_tmpGroupUsers);
            final Integer _tmpJoined;
            if (_cursor.isNull(_cursorIndexOfJoined)) {
              _tmpJoined = null;
            } else {
              _tmpJoined = _cursor.getInt(_cursorIndexOfJoined);
            }
            _item.setJoined(_tmpJoined);
            final Integer _tmpParticipantsCount;
            if (_cursor.isNull(_cursorIndexOfParticipantsCount)) {
              _tmpParticipantsCount = null;
            } else {
              _tmpParticipantsCount = _cursor.getInt(_cursorIndexOfParticipantsCount);
            }
            _item.setParticipantsCount(_tmpParticipantsCount);
            final String _tmpGroupStatus;
            if (_cursor.isNull(_cursorIndexOfGroupStatus)) {
              _tmpGroupStatus = null;
            } else {
              _tmpGroupStatus = _cursor.getString(_cursorIndexOfGroupStatus);
            }
            _item.setGroupStatus(_tmpGroupStatus);
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

  @Override
  public String getGroupName(final String threadId) {
    final String _sql = "SELECT name FROM `group` WHERE thread_id = (?)";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
