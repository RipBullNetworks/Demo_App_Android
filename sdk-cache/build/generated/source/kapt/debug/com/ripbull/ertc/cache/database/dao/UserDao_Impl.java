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
import com.ripbull.ertc.cache.database.entity.User;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser_1;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser_2;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser_3;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser_4;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNotificationSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserChatId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAvailabilityStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAvailabilityStatusById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteUserByChatId;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user` (`id`,`tenant_id`,`name`,`app_state`,`login_type`,`profile_pic`,`profile_thumb`,`profile_status`,`login_timestamp`,`user_chat_id`,`availability_status`,`blocked_status`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAppState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAppState());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLoginType());
        }
        if (value.getProfilePic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProfilePic());
        }
        if (value.getProfileThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProfileThumb());
        }
        if (value.getProfileStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProfileStatus());
        }
        if (value.getLoginTimestamp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLoginTimestamp());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getAvailabilityStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getAvailabilityStatus());
        }
        if (value.getBlockedStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlockedStatus());
        }
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNotificationSettings());
        }
        if (value.getValidTill() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getValidTill());
        }
        if (value.getValidTillValue() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfUser_1 = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `user` (`id`,`tenant_id`,`name`,`app_state`,`login_type`,`profile_pic`,`profile_thumb`,`profile_status`,`login_timestamp`,`user_chat_id`,`availability_status`,`blocked_status`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAppState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAppState());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLoginType());
        }
        if (value.getProfilePic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProfilePic());
        }
        if (value.getProfileThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProfileThumb());
        }
        if (value.getProfileStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProfileStatus());
        }
        if (value.getLoginTimestamp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLoginTimestamp());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getAvailabilityStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getAvailabilityStatus());
        }
        if (value.getBlockedStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlockedStatus());
        }
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNotificationSettings());
        }
        if (value.getValidTill() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getValidTill());
        }
        if (value.getValidTillValue() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfUser_2 = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `user` (`id`,`tenant_id`,`name`,`app_state`,`login_type`,`profile_pic`,`profile_thumb`,`profile_status`,`login_timestamp`,`user_chat_id`,`availability_status`,`blocked_status`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAppState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAppState());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLoginType());
        }
        if (value.getProfilePic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProfilePic());
        }
        if (value.getProfileThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProfileThumb());
        }
        if (value.getProfileStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProfileStatus());
        }
        if (value.getLoginTimestamp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLoginTimestamp());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getAvailabilityStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getAvailabilityStatus());
        }
        if (value.getBlockedStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlockedStatus());
        }
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNotificationSettings());
        }
        if (value.getValidTill() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getValidTill());
        }
        if (value.getValidTillValue() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfUser_3 = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `user` (`id`,`tenant_id`,`name`,`app_state`,`login_type`,`profile_pic`,`profile_thumb`,`profile_status`,`login_timestamp`,`user_chat_id`,`availability_status`,`blocked_status`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAppState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAppState());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLoginType());
        }
        if (value.getProfilePic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProfilePic());
        }
        if (value.getProfileThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProfileThumb());
        }
        if (value.getProfileStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProfileStatus());
        }
        if (value.getLoginTimestamp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLoginTimestamp());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getAvailabilityStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getAvailabilityStatus());
        }
        if (value.getBlockedStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlockedStatus());
        }
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNotificationSettings());
        }
        if (value.getValidTill() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getValidTill());
        }
        if (value.getValidTillValue() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfUser_4 = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `user` (`id`,`tenant_id`,`name`,`app_state`,`login_type`,`profile_pic`,`profile_thumb`,`profile_status`,`login_timestamp`,`user_chat_id`,`availability_status`,`blocked_status`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAppState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAppState());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLoginType());
        }
        if (value.getProfilePic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProfilePic());
        }
        if (value.getProfileThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProfileThumb());
        }
        if (value.getProfileStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProfileStatus());
        }
        if (value.getLoginTimestamp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLoginTimestamp());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getAvailabilityStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getAvailabilityStatus());
        }
        if (value.getBlockedStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlockedStatus());
        }
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNotificationSettings());
        }
        if (value.getValidTill() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getValidTill());
        }
        if (value.getValidTillValue() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getValidTillValue());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user` SET `id` = ?,`tenant_id` = ?,`name` = ?,`app_state` = ?,`login_type` = ?,`profile_pic` = ?,`profile_thumb` = ?,`profile_status` = ?,`login_timestamp` = ?,`user_chat_id` = ?,`availability_status` = ?,`blocked_status` = ?,`notification_settings` = ?,`valid_till` = ?,`valid_till_value` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTenantId());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getAppState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAppState());
        }
        if (value.getLoginType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLoginType());
        }
        if (value.getProfilePic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProfilePic());
        }
        if (value.getProfileThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProfileThumb());
        }
        if (value.getProfileStatus() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProfileStatus());
        }
        if (value.getLoginTimestamp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getLoginTimestamp());
        }
        if (value.getUserChatId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserChatId());
        }
        if (value.getAvailabilityStatus() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getAvailabilityStatus());
        }
        if (value.getBlockedStatus() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBlockedStatus());
        }
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNotificationSettings());
        }
        if (value.getValidTill() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getValidTill());
        }
        if (value.getValidTillValue() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getValidTillValue());
        }
        if (value.getId() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUser = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user WHERE id = (?)";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNotificationSettings = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE user SET notification_settings = ? WHERE user_chat_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserChatId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE user SET user_chat_id = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAvailabilityStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE user SET availability_status = ? WHERE user_chat_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAvailabilityStatusById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE user SET availability_status = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteUserByChatId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM user WHERE user_chat_id = (?)";
        return _query;
      }
    };
  }

  @Override
  public void insert(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<User> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(t);
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
  public void deleteUser(final String userId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUser.acquire();
    int _argIndex = 1;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteUser.release(_stmt);
    }
  }

  @Override
  public void updateNotificationSettings(final String chatUserId,
      final String notificationSettings) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNotificationSettings.acquire();
    int _argIndex = 1;
    if (notificationSettings == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, notificationSettings);
    }
    _argIndex = 2;
    if (chatUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNotificationSettings.release(_stmt);
    }
  }

  @Override
  public void updateUserChatId(final String userAppId, final String userChatId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserChatId.acquire();
    int _argIndex = 1;
    if (userChatId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userChatId);
    }
    _argIndex = 2;
    if (userAppId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userAppId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUserChatId.release(_stmt);
    }
  }

  @Override
  public void updateAvailabilityStatus(final String chatUserId, final String availabilityStatus) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAvailabilityStatus.acquire();
    int _argIndex = 1;
    if (availabilityStatus == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, availabilityStatus);
    }
    _argIndex = 2;
    if (chatUserId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, chatUserId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAvailabilityStatus.release(_stmt);
    }
  }

  @Override
  public void updateAvailabilityStatusById(final String userId, final String availabilityStatus) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAvailabilityStatusById.acquire();
    int _argIndex = 1;
    if (availabilityStatus == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, availabilityStatus);
    }
    _argIndex = 2;
    if (userId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, userId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAvailabilityStatusById.release(_stmt);
    }
  }

  @Override
  public void deleteUserByChatId(final String userChatId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteUserByChatId.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfDeleteUserByChatId.release(_stmt);
    }
  }

  @Override
  public Flowable<User> getUser() {
    final String _sql = "SELECT * FROM user ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, false, new String[]{"user"}, new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final User _result;
          if(_cursor.moveToFirst()) {
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
            _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Single<User> getLastUser(final String tenantId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    return RxRoom.createSingle(new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final User _result;
          if(_cursor.moveToFirst()) {
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
            _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public User getLastUserInSync(final String tenantId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) ORDER BY id DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
      final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
      final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
      final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
      final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
      final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
      final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
      final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
      final User _result;
      if(_cursor.moveToFirst()) {
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
        _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Single<User> getUserById(final String tenantId, final String userId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return RxRoom.createSingle(new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final User _result;
          if(_cursor.moveToFirst()) {
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
            _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Maybe<User> getUserById(final String userId) {
    final String _sql = "SELECT * FROM user WHERE id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return Maybe.fromCallable(new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final User _result;
          if(_cursor.moveToFirst()) {
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
            _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Single<List<User>> hasUser(final String tenantId, final String userId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return RxRoom.createSingle(new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
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
            _item = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Flowable<User> getUserByIdFlowable(final String tenantId, final String userId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"user"}, new Callable<User>() {
      @Override
      public User call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final User _result;
          if(_cursor.moveToFirst()) {
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
            _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public User getUserByIdInSync(final String tenantId, final String userId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
      final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
      final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
      final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
      final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
      final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
      final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
      final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
      final User _result;
      if(_cursor.moveToFirst()) {
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
        _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Flowable<List<User>> getUsers(final String tenantId, final String userId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND id != (?) AND app_state = 'active' ORDER BY name COLLATE NOCASE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"user"}, new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
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
            _item = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Single<List<User>> getUsersBySingle(final String tenantId, final String userId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND id != (?) AND app_state = 'active' ORDER BY name COLLATE NOCASE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return RxRoom.createSingle(new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
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
            _item = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public List<String> getUserChatIdByUserAppIds(final String[] ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT user_chat_id FROM user WHERE id IN (");
    final int _inputSize = ids.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : ids) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item_1;
        if (_cursor.isNull(0)) {
          _item_1 = null;
        } else {
          _item_1 = _cursor.getString(0);
        }
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getUserEntityByUserChatIds(final String[] ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM user WHERE user_chat_id IN (");
    final int _inputSize = ids.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : ids) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
      final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
      final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
      final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
      final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
      final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
      final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
      final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
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
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Single<List<User>> getUserEntitiesByUserAppIds(final String[] ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM user WHERE id IN (");
    final int _inputSize = ids.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : ids) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    return RxRoom.createSingle(new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
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
  public Flowable<List<User>> getUsersWithQuery(final String tenantId, final String query) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND name LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"user"}, new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
          final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
          final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
          final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
          final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
          final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
          final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
          final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
          final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
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
            _item = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public String getUserStatus(final String tenantId, final String userId) {
    final String _sql = "SELECT availability_status FROM user WHERE tenant_id = (?) AND id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
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
  public String getUserBlockStatus(final String tenantId, final String userId) {
    final String _sql = "SELECT blocked_status FROM user WHERE tenant_id = (?) AND id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
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
  public User getUserByChatUserId(final String tenantId, final String chatUserId) {
    final String _sql = "SELECT * FROM user WHERE tenant_id = (?) AND user_chat_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    _argIndex = 2;
    if (chatUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatUserId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
      final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
      final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
      final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
      final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
      final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
      final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
      final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
      final User _result;
      if(_cursor.moveToFirst()) {
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
        _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public User getUserByChatUserId(final String chatUserId) {
    final String _sql = "SELECT * FROM user WHERE user_chat_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatUserId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAppState = CursorUtil.getColumnIndexOrThrow(_cursor, "app_state");
      final int _cursorIndexOfLoginType = CursorUtil.getColumnIndexOrThrow(_cursor, "login_type");
      final int _cursorIndexOfProfilePic = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_pic");
      final int _cursorIndexOfProfileThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_thumb");
      final int _cursorIndexOfProfileStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "profile_status");
      final int _cursorIndexOfLoginTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "login_timestamp");
      final int _cursorIndexOfUserChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "user_chat_id");
      final int _cursorIndexOfAvailabilityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "availability_status");
      final int _cursorIndexOfBlockedStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_status");
      final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
      final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
      final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
      final User _result;
      if(_cursor.moveToFirst()) {
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
        _result = new User(_tmpId,_tmpTenantId,_tmpName,_tmpAppState,_tmpLoginType,_tmpProfilePic,_tmpProfileThumb,_tmpProfileStatus,_tmpLoginTimestamp,_tmpUserChatId,_tmpAvailabilityStatus,_tmpBlockedStatus,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public String getName(final String userId) {
    final String _sql = "SELECT name FROM user WHERE id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
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
  public String getAppUserId(final String userChatId) {
    final String _sql = "SELECT id FROM user WHERE user_chat_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userChatId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userChatId);
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
  public Single<List<String>> getUserIds(final String userId) {
    final String _sql = "SELECT id FROM user WHERE id != (?) AND app_state = 'active'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userId);
    }
    return RxRoom.createSingle(new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
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
}
