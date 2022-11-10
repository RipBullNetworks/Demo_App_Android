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
import com.ripbull.ertc.cache.database.Converters;
import com.ripbull.ertc.cache.database.entity.EmailContact;
import com.ripbull.ertc.cache.database.entity.Location;
import com.ripbull.ertc.cache.database.entity.PhoneContact;
import com.ripbull.ertc.cache.database.entity.SingleChat;
import com.ripbull.ertc.cache.database.entity.Thread;
import com.ripbull.ertc.cache.database.entity.ThreadEmbedded;
import com.ripbull.ertc.cache.database.entity.ThreadMetadata;
import com.ripbull.ertc.cache.database.entity.ThreadUserLink;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Double;
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
public final class ThreadDao_Impl implements ThreadDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Thread> __insertionAdapterOfThread;

  private final EntityInsertionAdapter<Thread> __insertionAdapterOfThread_1;

  private final EntityInsertionAdapter<Thread> __insertionAdapterOfThread_2;

  private final EntityInsertionAdapter<Thread> __insertionAdapterOfThread_3;

  private final EntityInsertionAdapter<Thread> __insertionAdapterOfThread_4;

  private final EntityDeletionOrUpdateAdapter<Thread> __deletionAdapterOfThread;

  private final EntityDeletionOrUpdateAdapter<Thread> __updateAdapterOfThread;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteThreadById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteThreadByUserId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUserUpdatedAt;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNotificationSettings;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUnreadCount;

  private final Converters __converters = new Converters();

  public ThreadDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfThread = new EntityInsertionAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `thread` (`id`,`name`,`type`,`tenant_id`,`sender_chat_id`,`recipient_chat_id`,`message_count`,`read`,`unread_count`,`creation_date`,`has_deleted`,`creator_tenant_id`,`creator_user_id`,`sender_user_id`,`recipient_user_id`,`updated_at`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTenantId());
        }
        if (value.getSenderChatId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderChatId());
        }
        if (value.getRecipientChatId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecipientChatId());
        }
        stmt.bindLong(7, value.getMessageCount());
        stmt.bindLong(8, value.getRead());
        stmt.bindLong(9, value.getUnReadCount());
        stmt.bindLong(10, value.getCreationDate());
        stmt.bindLong(11, value.getHasDeleted());
        if (value.getCreatorTenantId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatorTenantId());
        }
        if (value.getCreatorUserId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatorUserId());
        }
        if (value.getSenderUserId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSenderUserId());
        }
        if (value.getRecipientUserId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecipientUserId());
        }
        stmt.bindLong(16, value.getUpdatedAt());
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNotificationSettings());
        }
        stmt.bindLong(18, value.getValidTill());
        if (value.getValidTillValue() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfThread_1 = new EntityInsertionAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `thread` (`id`,`name`,`type`,`tenant_id`,`sender_chat_id`,`recipient_chat_id`,`message_count`,`read`,`unread_count`,`creation_date`,`has_deleted`,`creator_tenant_id`,`creator_user_id`,`sender_user_id`,`recipient_user_id`,`updated_at`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTenantId());
        }
        if (value.getSenderChatId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderChatId());
        }
        if (value.getRecipientChatId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecipientChatId());
        }
        stmt.bindLong(7, value.getMessageCount());
        stmt.bindLong(8, value.getRead());
        stmt.bindLong(9, value.getUnReadCount());
        stmt.bindLong(10, value.getCreationDate());
        stmt.bindLong(11, value.getHasDeleted());
        if (value.getCreatorTenantId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatorTenantId());
        }
        if (value.getCreatorUserId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatorUserId());
        }
        if (value.getSenderUserId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSenderUserId());
        }
        if (value.getRecipientUserId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecipientUserId());
        }
        stmt.bindLong(16, value.getUpdatedAt());
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNotificationSettings());
        }
        stmt.bindLong(18, value.getValidTill());
        if (value.getValidTillValue() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfThread_2 = new EntityInsertionAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `thread` (`id`,`name`,`type`,`tenant_id`,`sender_chat_id`,`recipient_chat_id`,`message_count`,`read`,`unread_count`,`creation_date`,`has_deleted`,`creator_tenant_id`,`creator_user_id`,`sender_user_id`,`recipient_user_id`,`updated_at`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTenantId());
        }
        if (value.getSenderChatId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderChatId());
        }
        if (value.getRecipientChatId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecipientChatId());
        }
        stmt.bindLong(7, value.getMessageCount());
        stmt.bindLong(8, value.getRead());
        stmt.bindLong(9, value.getUnReadCount());
        stmt.bindLong(10, value.getCreationDate());
        stmt.bindLong(11, value.getHasDeleted());
        if (value.getCreatorTenantId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatorTenantId());
        }
        if (value.getCreatorUserId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatorUserId());
        }
        if (value.getSenderUserId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSenderUserId());
        }
        if (value.getRecipientUserId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecipientUserId());
        }
        stmt.bindLong(16, value.getUpdatedAt());
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNotificationSettings());
        }
        stmt.bindLong(18, value.getValidTill());
        if (value.getValidTillValue() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfThread_3 = new EntityInsertionAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `thread` (`id`,`name`,`type`,`tenant_id`,`sender_chat_id`,`recipient_chat_id`,`message_count`,`read`,`unread_count`,`creation_date`,`has_deleted`,`creator_tenant_id`,`creator_user_id`,`sender_user_id`,`recipient_user_id`,`updated_at`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTenantId());
        }
        if (value.getSenderChatId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderChatId());
        }
        if (value.getRecipientChatId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecipientChatId());
        }
        stmt.bindLong(7, value.getMessageCount());
        stmt.bindLong(8, value.getRead());
        stmt.bindLong(9, value.getUnReadCount());
        stmt.bindLong(10, value.getCreationDate());
        stmt.bindLong(11, value.getHasDeleted());
        if (value.getCreatorTenantId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatorTenantId());
        }
        if (value.getCreatorUserId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatorUserId());
        }
        if (value.getSenderUserId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSenderUserId());
        }
        if (value.getRecipientUserId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecipientUserId());
        }
        stmt.bindLong(16, value.getUpdatedAt());
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNotificationSettings());
        }
        stmt.bindLong(18, value.getValidTill());
        if (value.getValidTillValue() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getValidTillValue());
        }
      }
    };
    this.__insertionAdapterOfThread_4 = new EntityInsertionAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `thread` (`id`,`name`,`type`,`tenant_id`,`sender_chat_id`,`recipient_chat_id`,`message_count`,`read`,`unread_count`,`creation_date`,`has_deleted`,`creator_tenant_id`,`creator_user_id`,`sender_user_id`,`recipient_user_id`,`updated_at`,`notification_settings`,`valid_till`,`valid_till_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTenantId());
        }
        if (value.getSenderChatId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderChatId());
        }
        if (value.getRecipientChatId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecipientChatId());
        }
        stmt.bindLong(7, value.getMessageCount());
        stmt.bindLong(8, value.getRead());
        stmt.bindLong(9, value.getUnReadCount());
        stmt.bindLong(10, value.getCreationDate());
        stmt.bindLong(11, value.getHasDeleted());
        if (value.getCreatorTenantId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatorTenantId());
        }
        if (value.getCreatorUserId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatorUserId());
        }
        if (value.getSenderUserId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSenderUserId());
        }
        if (value.getRecipientUserId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecipientUserId());
        }
        stmt.bindLong(16, value.getUpdatedAt());
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNotificationSettings());
        }
        stmt.bindLong(18, value.getValidTill());
        if (value.getValidTillValue() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getValidTillValue());
        }
      }
    };
    this.__deletionAdapterOfThread = new EntityDeletionOrUpdateAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `thread` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfThread = new EntityDeletionOrUpdateAdapter<Thread>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `thread` SET `id` = ?,`name` = ?,`type` = ?,`tenant_id` = ?,`sender_chat_id` = ?,`recipient_chat_id` = ?,`message_count` = ?,`read` = ?,`unread_count` = ?,`creation_date` = ?,`has_deleted` = ?,`creator_tenant_id` = ?,`creator_user_id` = ?,`sender_user_id` = ?,`recipient_user_id` = ?,`updated_at` = ?,`notification_settings` = ?,`valid_till` = ?,`valid_till_value` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Thread value) {
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
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getTenantId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTenantId());
        }
        if (value.getSenderChatId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSenderChatId());
        }
        if (value.getRecipientChatId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecipientChatId());
        }
        stmt.bindLong(7, value.getMessageCount());
        stmt.bindLong(8, value.getRead());
        stmt.bindLong(9, value.getUnReadCount());
        stmt.bindLong(10, value.getCreationDate());
        stmt.bindLong(11, value.getHasDeleted());
        if (value.getCreatorTenantId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCreatorTenantId());
        }
        if (value.getCreatorUserId() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatorUserId());
        }
        if (value.getSenderUserId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSenderUserId());
        }
        if (value.getRecipientUserId() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRecipientUserId());
        }
        stmt.bindLong(16, value.getUpdatedAt());
        if (value.getNotificationSettings() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNotificationSettings());
        }
        stmt.bindLong(18, value.getValidTill());
        if (value.getValidTillValue() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getValidTillValue());
        }
        if (value.getId() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM thread";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteThreadById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM thread WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteThreadByUserId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM thread WHERE recipient_user_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUserUpdatedAt = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE thread SET updated_at = ? WHERE recipient_user_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNotificationSettings = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE thread SET notification_settings = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUnreadCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE thread SET unread_count = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<Thread> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<Thread> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<Thread> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<Thread> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<Thread> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfThread.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfThread.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<Thread> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfThread.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Thread t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfThread.handle(t);
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
  public void updateUserUpdatedAt(final String recipientUserId, final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUserUpdatedAt.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, updatedAt);
    _argIndex = 2;
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
      __preparedStmtOfUpdateUserUpdatedAt.release(_stmt);
    }
  }

  @Override
  public void updateNotificationSettings(final String threadId, final String notificationSettings) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNotificationSettings.acquire();
    int _argIndex = 1;
    if (notificationSettings == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, notificationSettings);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateNotificationSettings.release(_stmt);
    }
  }

  @Override
  public void updateUnreadCount(final String threadId, final int unreadCount) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUnreadCount.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, unreadCount);
    _argIndex = 2;
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
      __preparedStmtOfUpdateUnreadCount.release(_stmt);
    }
  }

  @Override
  public Flowable<List<ThreadEmbedded>> getThreads(final String tenantId) {
    final String _sql = "SELECT * FROM thread WHERE tenant_id = (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tenantId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tenantId);
    }
    return RxRoom.createFlowable(__db, true, new String[]{"thread_user_link","single_chat","thread_meta_data","thread"}, new Callable<List<ThreadEmbedded>>() {
      @Override
      public List<ThreadEmbedded> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
            final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
            final int _cursorIndexOfSenderChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_chat_id");
            final int _cursorIndexOfRecipientChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_chat_id");
            final int _cursorIndexOfMessageCount = CursorUtil.getColumnIndexOrThrow(_cursor, "message_count");
            final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
            final int _cursorIndexOfUnReadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unread_count");
            final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
            final int _cursorIndexOfHasDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "has_deleted");
            final int _cursorIndexOfCreatorTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_tenant_id");
            final int _cursorIndexOfCreatorUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_user_id");
            final int _cursorIndexOfSenderUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_user_id");
            final int _cursorIndexOfRecipientUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_user_id");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
            final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
            final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
            final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
            final HashMap<String, ArrayList<ThreadUserLink>> _collectionThreadUserLinks = new HashMap<String, ArrayList<ThreadUserLink>>();
            final HashMap<String, ArrayList<SingleChat>> _collectionSingleChatList = new HashMap<String, ArrayList<SingleChat>>();
            final HashMap<String, ArrayList<ThreadMetadata>> _collectionThreadMetadataList = new HashMap<String, ArrayList<ThreadMetadata>>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey = _cursor.getString(_cursorIndexOfId);
                ArrayList<ThreadUserLink> _tmpThreadUserLinksCollection = _collectionThreadUserLinks.get(_tmpKey);
                if (_tmpThreadUserLinksCollection == null) {
                  _tmpThreadUserLinksCollection = new ArrayList<ThreadUserLink>();
                  _collectionThreadUserLinks.put(_tmpKey, _tmpThreadUserLinksCollection);
                }
              }
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                ArrayList<SingleChat> _tmpSingleChatListCollection = _collectionSingleChatList.get(_tmpKey_1);
                if (_tmpSingleChatListCollection == null) {
                  _tmpSingleChatListCollection = new ArrayList<SingleChat>();
                  _collectionSingleChatList.put(_tmpKey_1, _tmpSingleChatListCollection);
                }
              }
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
                ArrayList<ThreadMetadata> _tmpThreadMetadataListCollection = _collectionThreadMetadataList.get(_tmpKey_2);
                if (_tmpThreadMetadataListCollection == null) {
                  _tmpThreadMetadataListCollection = new ArrayList<ThreadMetadata>();
                  _collectionThreadMetadataList.put(_tmpKey_2, _tmpThreadMetadataListCollection);
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipthreadUserLinkAscomRipbullErtcCacheDatabaseEntityThreadUserLink(_collectionThreadUserLinks);
            __fetchRelationshipsingleChatAscomRipbullErtcCacheDatabaseEntitySingleChat(_collectionSingleChatList);
            __fetchRelationshipthreadMetaDataAscomRipbullErtcCacheDatabaseEntityThreadMetadata(_collectionThreadMetadataList);
            final List<ThreadEmbedded> _result = new ArrayList<ThreadEmbedded>(_cursor.getCount());
            while(_cursor.moveToNext()) {
              final ThreadEmbedded _item;
              final Thread _tmpThread;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfTenantId) && _cursor.isNull(_cursorIndexOfSenderChatId) && _cursor.isNull(_cursorIndexOfRecipientChatId) && _cursor.isNull(_cursorIndexOfMessageCount) && _cursor.isNull(_cursorIndexOfRead) && _cursor.isNull(_cursorIndexOfUnReadCount) && _cursor.isNull(_cursorIndexOfCreationDate) && _cursor.isNull(_cursorIndexOfHasDeleted) && _cursor.isNull(_cursorIndexOfCreatorTenantId) && _cursor.isNull(_cursorIndexOfCreatorUserId) && _cursor.isNull(_cursorIndexOfSenderUserId) && _cursor.isNull(_cursorIndexOfRecipientUserId) && _cursor.isNull(_cursorIndexOfUpdatedAt) && _cursor.isNull(_cursorIndexOfNotificationSettings) && _cursor.isNull(_cursorIndexOfValidTill) && _cursor.isNull(_cursorIndexOfValidTillValue))) {
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
                final String _tmpType;
                if (_cursor.isNull(_cursorIndexOfType)) {
                  _tmpType = null;
                } else {
                  _tmpType = _cursor.getString(_cursorIndexOfType);
                }
                final String _tmpTenantId;
                if (_cursor.isNull(_cursorIndexOfTenantId)) {
                  _tmpTenantId = null;
                } else {
                  _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
                }
                final String _tmpSenderChatId;
                if (_cursor.isNull(_cursorIndexOfSenderChatId)) {
                  _tmpSenderChatId = null;
                } else {
                  _tmpSenderChatId = _cursor.getString(_cursorIndexOfSenderChatId);
                }
                final String _tmpRecipientChatId;
                if (_cursor.isNull(_cursorIndexOfRecipientChatId)) {
                  _tmpRecipientChatId = null;
                } else {
                  _tmpRecipientChatId = _cursor.getString(_cursorIndexOfRecipientChatId);
                }
                final int _tmpMessageCount;
                _tmpMessageCount = _cursor.getInt(_cursorIndexOfMessageCount);
                final int _tmpRead;
                _tmpRead = _cursor.getInt(_cursorIndexOfRead);
                final int _tmpUnReadCount;
                _tmpUnReadCount = _cursor.getInt(_cursorIndexOfUnReadCount);
                final long _tmpCreationDate;
                _tmpCreationDate = _cursor.getLong(_cursorIndexOfCreationDate);
                final int _tmpHasDeleted;
                _tmpHasDeleted = _cursor.getInt(_cursorIndexOfHasDeleted);
                final String _tmpCreatorTenantId;
                if (_cursor.isNull(_cursorIndexOfCreatorTenantId)) {
                  _tmpCreatorTenantId = null;
                } else {
                  _tmpCreatorTenantId = _cursor.getString(_cursorIndexOfCreatorTenantId);
                }
                final String _tmpCreatorUserId;
                if (_cursor.isNull(_cursorIndexOfCreatorUserId)) {
                  _tmpCreatorUserId = null;
                } else {
                  _tmpCreatorUserId = _cursor.getString(_cursorIndexOfCreatorUserId);
                }
                final String _tmpSenderUserId;
                if (_cursor.isNull(_cursorIndexOfSenderUserId)) {
                  _tmpSenderUserId = null;
                } else {
                  _tmpSenderUserId = _cursor.getString(_cursorIndexOfSenderUserId);
                }
                final String _tmpRecipientUserId;
                if (_cursor.isNull(_cursorIndexOfRecipientUserId)) {
                  _tmpRecipientUserId = null;
                } else {
                  _tmpRecipientUserId = _cursor.getString(_cursorIndexOfRecipientUserId);
                }
                final long _tmpUpdatedAt;
                _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
                final String _tmpNotificationSettings;
                if (_cursor.isNull(_cursorIndexOfNotificationSettings)) {
                  _tmpNotificationSettings = null;
                } else {
                  _tmpNotificationSettings = _cursor.getString(_cursorIndexOfNotificationSettings);
                }
                final long _tmpValidTill;
                _tmpValidTill = _cursor.getLong(_cursorIndexOfValidTill);
                final String _tmpValidTillValue;
                if (_cursor.isNull(_cursorIndexOfValidTillValue)) {
                  _tmpValidTillValue = null;
                } else {
                  _tmpValidTillValue = _cursor.getString(_cursorIndexOfValidTillValue);
                }
                _tmpThread = new Thread(_tmpId,_tmpName,_tmpType,_tmpTenantId,_tmpSenderChatId,_tmpRecipientChatId,_tmpMessageCount,_tmpRead,_tmpUnReadCount,_tmpCreationDate,_tmpHasDeleted,_tmpCreatorTenantId,_tmpCreatorUserId,_tmpSenderUserId,_tmpRecipientUserId,_tmpUpdatedAt,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
              }  else  {
                _tmpThread = null;
              }
              ArrayList<ThreadUserLink> _tmpThreadUserLinksCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
                _tmpThreadUserLinksCollection_1 = _collectionThreadUserLinks.get(_tmpKey_3);
              }
              if (_tmpThreadUserLinksCollection_1 == null) {
                _tmpThreadUserLinksCollection_1 = new ArrayList<ThreadUserLink>();
              }
              ArrayList<SingleChat> _tmpSingleChatListCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_4 = _cursor.getString(_cursorIndexOfId);
                _tmpSingleChatListCollection_1 = _collectionSingleChatList.get(_tmpKey_4);
              }
              if (_tmpSingleChatListCollection_1 == null) {
                _tmpSingleChatListCollection_1 = new ArrayList<SingleChat>();
              }
              ArrayList<ThreadMetadata> _tmpThreadMetadataListCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_5 = _cursor.getString(_cursorIndexOfId);
                _tmpThreadMetadataListCollection_1 = _collectionThreadMetadataList.get(_tmpKey_5);
              }
              if (_tmpThreadMetadataListCollection_1 == null) {
                _tmpThreadMetadataListCollection_1 = new ArrayList<ThreadMetadata>();
              }
              _item = new ThreadEmbedded();
              _item.setThread(_tmpThread);
              _item.setThreadUserLinks(_tmpThreadUserLinksCollection_1);
              _item.setSingleChatList(_tmpSingleChatListCollection_1);
              _item.setThreadMetadataList(_tmpThreadMetadataListCollection_1);
              _result.add(_item);
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
  public Thread getThreadByIdInSync(final String threadId) {
    final String _sql = "SELECT * FROM thread WHERE id = ?";
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
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
      final int _cursorIndexOfSenderChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_chat_id");
      final int _cursorIndexOfRecipientChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_chat_id");
      final int _cursorIndexOfMessageCount = CursorUtil.getColumnIndexOrThrow(_cursor, "message_count");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfUnReadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unread_count");
      final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
      final int _cursorIndexOfHasDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "has_deleted");
      final int _cursorIndexOfCreatorTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_tenant_id");
      final int _cursorIndexOfCreatorUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_user_id");
      final int _cursorIndexOfSenderUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_user_id");
      final int _cursorIndexOfRecipientUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_user_id");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
      final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
      final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
      final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
      final Thread _result;
      if(_cursor.moveToFirst()) {
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
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        final String _tmpTenantId;
        if (_cursor.isNull(_cursorIndexOfTenantId)) {
          _tmpTenantId = null;
        } else {
          _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
        }
        final String _tmpSenderChatId;
        if (_cursor.isNull(_cursorIndexOfSenderChatId)) {
          _tmpSenderChatId = null;
        } else {
          _tmpSenderChatId = _cursor.getString(_cursorIndexOfSenderChatId);
        }
        final String _tmpRecipientChatId;
        if (_cursor.isNull(_cursorIndexOfRecipientChatId)) {
          _tmpRecipientChatId = null;
        } else {
          _tmpRecipientChatId = _cursor.getString(_cursorIndexOfRecipientChatId);
        }
        final int _tmpMessageCount;
        _tmpMessageCount = _cursor.getInt(_cursorIndexOfMessageCount);
        final int _tmpRead;
        _tmpRead = _cursor.getInt(_cursorIndexOfRead);
        final int _tmpUnReadCount;
        _tmpUnReadCount = _cursor.getInt(_cursorIndexOfUnReadCount);
        final long _tmpCreationDate;
        _tmpCreationDate = _cursor.getLong(_cursorIndexOfCreationDate);
        final int _tmpHasDeleted;
        _tmpHasDeleted = _cursor.getInt(_cursorIndexOfHasDeleted);
        final String _tmpCreatorTenantId;
        if (_cursor.isNull(_cursorIndexOfCreatorTenantId)) {
          _tmpCreatorTenantId = null;
        } else {
          _tmpCreatorTenantId = _cursor.getString(_cursorIndexOfCreatorTenantId);
        }
        final String _tmpCreatorUserId;
        if (_cursor.isNull(_cursorIndexOfCreatorUserId)) {
          _tmpCreatorUserId = null;
        } else {
          _tmpCreatorUserId = _cursor.getString(_cursorIndexOfCreatorUserId);
        }
        final String _tmpSenderUserId;
        if (_cursor.isNull(_cursorIndexOfSenderUserId)) {
          _tmpSenderUserId = null;
        } else {
          _tmpSenderUserId = _cursor.getString(_cursorIndexOfSenderUserId);
        }
        final String _tmpRecipientUserId;
        if (_cursor.isNull(_cursorIndexOfRecipientUserId)) {
          _tmpRecipientUserId = null;
        } else {
          _tmpRecipientUserId = _cursor.getString(_cursorIndexOfRecipientUserId);
        }
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final String _tmpNotificationSettings;
        if (_cursor.isNull(_cursorIndexOfNotificationSettings)) {
          _tmpNotificationSettings = null;
        } else {
          _tmpNotificationSettings = _cursor.getString(_cursorIndexOfNotificationSettings);
        }
        final long _tmpValidTill;
        _tmpValidTill = _cursor.getLong(_cursorIndexOfValidTill);
        final String _tmpValidTillValue;
        if (_cursor.isNull(_cursorIndexOfValidTillValue)) {
          _tmpValidTillValue = null;
        } else {
          _tmpValidTillValue = _cursor.getString(_cursorIndexOfValidTillValue);
        }
        _result = new Thread(_tmpId,_tmpName,_tmpType,_tmpTenantId,_tmpSenderChatId,_tmpRecipientChatId,_tmpMessageCount,_tmpRead,_tmpUnReadCount,_tmpCreationDate,_tmpHasDeleted,_tmpCreatorTenantId,_tmpCreatorUserId,_tmpSenderUserId,_tmpRecipientUserId,_tmpUpdatedAt,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public Single<Thread> getThreadByIdInAsync(final String threadId) {
    final String _sql = "SELECT * FROM thread WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createSingle(new Callable<Thread>() {
      @Override
      public Thread call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfSenderChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_chat_id");
          final int _cursorIndexOfRecipientChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_chat_id");
          final int _cursorIndexOfMessageCount = CursorUtil.getColumnIndexOrThrow(_cursor, "message_count");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfUnReadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unread_count");
          final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
          final int _cursorIndexOfHasDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "has_deleted");
          final int _cursorIndexOfCreatorTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_tenant_id");
          final int _cursorIndexOfCreatorUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_user_id");
          final int _cursorIndexOfSenderUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_user_id");
          final int _cursorIndexOfRecipientUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_user_id");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final Thread _result;
          if(_cursor.moveToFirst()) {
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
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            final String _tmpSenderChatId;
            if (_cursor.isNull(_cursorIndexOfSenderChatId)) {
              _tmpSenderChatId = null;
            } else {
              _tmpSenderChatId = _cursor.getString(_cursorIndexOfSenderChatId);
            }
            final String _tmpRecipientChatId;
            if (_cursor.isNull(_cursorIndexOfRecipientChatId)) {
              _tmpRecipientChatId = null;
            } else {
              _tmpRecipientChatId = _cursor.getString(_cursorIndexOfRecipientChatId);
            }
            final int _tmpMessageCount;
            _tmpMessageCount = _cursor.getInt(_cursorIndexOfMessageCount);
            final int _tmpRead;
            _tmpRead = _cursor.getInt(_cursorIndexOfRead);
            final int _tmpUnReadCount;
            _tmpUnReadCount = _cursor.getInt(_cursorIndexOfUnReadCount);
            final long _tmpCreationDate;
            _tmpCreationDate = _cursor.getLong(_cursorIndexOfCreationDate);
            final int _tmpHasDeleted;
            _tmpHasDeleted = _cursor.getInt(_cursorIndexOfHasDeleted);
            final String _tmpCreatorTenantId;
            if (_cursor.isNull(_cursorIndexOfCreatorTenantId)) {
              _tmpCreatorTenantId = null;
            } else {
              _tmpCreatorTenantId = _cursor.getString(_cursorIndexOfCreatorTenantId);
            }
            final String _tmpCreatorUserId;
            if (_cursor.isNull(_cursorIndexOfCreatorUserId)) {
              _tmpCreatorUserId = null;
            } else {
              _tmpCreatorUserId = _cursor.getString(_cursorIndexOfCreatorUserId);
            }
            final String _tmpSenderUserId;
            if (_cursor.isNull(_cursorIndexOfSenderUserId)) {
              _tmpSenderUserId = null;
            } else {
              _tmpSenderUserId = _cursor.getString(_cursorIndexOfSenderUserId);
            }
            final String _tmpRecipientUserId;
            if (_cursor.isNull(_cursorIndexOfRecipientUserId)) {
              _tmpRecipientUserId = null;
            } else {
              _tmpRecipientUserId = _cursor.getString(_cursorIndexOfRecipientUserId);
            }
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final String _tmpNotificationSettings;
            if (_cursor.isNull(_cursorIndexOfNotificationSettings)) {
              _tmpNotificationSettings = null;
            } else {
              _tmpNotificationSettings = _cursor.getString(_cursorIndexOfNotificationSettings);
            }
            final long _tmpValidTill;
            _tmpValidTill = _cursor.getLong(_cursorIndexOfValidTill);
            final String _tmpValidTillValue;
            if (_cursor.isNull(_cursorIndexOfValidTillValue)) {
              _tmpValidTillValue = null;
            } else {
              _tmpValidTillValue = _cursor.getString(_cursorIndexOfValidTillValue);
            }
            _result = new Thread(_tmpId,_tmpName,_tmpType,_tmpTenantId,_tmpSenderChatId,_tmpRecipientChatId,_tmpMessageCount,_tmpRead,_tmpUnReadCount,_tmpCreationDate,_tmpHasDeleted,_tmpCreatorTenantId,_tmpCreatorUserId,_tmpSenderUserId,_tmpRecipientUserId,_tmpUpdatedAt,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public String getThreadIdByUserId(final String recipientUserId) {
    final String _sql = "SELECT id FROM thread WHERE recipient_user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipientUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipientUserId);
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
  public String getUserIdByThreadId(final String threadId) {
    final String _sql = "SELECT recipient_user_id FROM thread WHERE id = ?";
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

  @Override
  public Flowable<Thread> getThreadByIdInFlowable(final String threadId) {
    final String _sql = "SELECT * FROM thread WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createFlowable(__db, false, new String[]{"thread"}, new Callable<Thread>() {
      @Override
      public Thread call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
          final int _cursorIndexOfSenderChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_chat_id");
          final int _cursorIndexOfRecipientChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_chat_id");
          final int _cursorIndexOfMessageCount = CursorUtil.getColumnIndexOrThrow(_cursor, "message_count");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfUnReadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unread_count");
          final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
          final int _cursorIndexOfHasDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "has_deleted");
          final int _cursorIndexOfCreatorTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_tenant_id");
          final int _cursorIndexOfCreatorUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_user_id");
          final int _cursorIndexOfSenderUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_user_id");
          final int _cursorIndexOfRecipientUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_user_id");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
          final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
          final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
          final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
          final Thread _result;
          if(_cursor.moveToFirst()) {
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
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpTenantId;
            if (_cursor.isNull(_cursorIndexOfTenantId)) {
              _tmpTenantId = null;
            } else {
              _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
            }
            final String _tmpSenderChatId;
            if (_cursor.isNull(_cursorIndexOfSenderChatId)) {
              _tmpSenderChatId = null;
            } else {
              _tmpSenderChatId = _cursor.getString(_cursorIndexOfSenderChatId);
            }
            final String _tmpRecipientChatId;
            if (_cursor.isNull(_cursorIndexOfRecipientChatId)) {
              _tmpRecipientChatId = null;
            } else {
              _tmpRecipientChatId = _cursor.getString(_cursorIndexOfRecipientChatId);
            }
            final int _tmpMessageCount;
            _tmpMessageCount = _cursor.getInt(_cursorIndexOfMessageCount);
            final int _tmpRead;
            _tmpRead = _cursor.getInt(_cursorIndexOfRead);
            final int _tmpUnReadCount;
            _tmpUnReadCount = _cursor.getInt(_cursorIndexOfUnReadCount);
            final long _tmpCreationDate;
            _tmpCreationDate = _cursor.getLong(_cursorIndexOfCreationDate);
            final int _tmpHasDeleted;
            _tmpHasDeleted = _cursor.getInt(_cursorIndexOfHasDeleted);
            final String _tmpCreatorTenantId;
            if (_cursor.isNull(_cursorIndexOfCreatorTenantId)) {
              _tmpCreatorTenantId = null;
            } else {
              _tmpCreatorTenantId = _cursor.getString(_cursorIndexOfCreatorTenantId);
            }
            final String _tmpCreatorUserId;
            if (_cursor.isNull(_cursorIndexOfCreatorUserId)) {
              _tmpCreatorUserId = null;
            } else {
              _tmpCreatorUserId = _cursor.getString(_cursorIndexOfCreatorUserId);
            }
            final String _tmpSenderUserId;
            if (_cursor.isNull(_cursorIndexOfSenderUserId)) {
              _tmpSenderUserId = null;
            } else {
              _tmpSenderUserId = _cursor.getString(_cursorIndexOfSenderUserId);
            }
            final String _tmpRecipientUserId;
            if (_cursor.isNull(_cursorIndexOfRecipientUserId)) {
              _tmpRecipientUserId = null;
            } else {
              _tmpRecipientUserId = _cursor.getString(_cursorIndexOfRecipientUserId);
            }
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            final String _tmpNotificationSettings;
            if (_cursor.isNull(_cursorIndexOfNotificationSettings)) {
              _tmpNotificationSettings = null;
            } else {
              _tmpNotificationSettings = _cursor.getString(_cursorIndexOfNotificationSettings);
            }
            final long _tmpValidTill;
            _tmpValidTill = _cursor.getLong(_cursorIndexOfValidTill);
            final String _tmpValidTillValue;
            if (_cursor.isNull(_cursorIndexOfValidTillValue)) {
              _tmpValidTillValue = null;
            } else {
              _tmpValidTillValue = _cursor.getString(_cursorIndexOfValidTillValue);
            }
            _result = new Thread(_tmpId,_tmpName,_tmpType,_tmpTenantId,_tmpSenderChatId,_tmpRecipientChatId,_tmpMessageCount,_tmpRead,_tmpUnReadCount,_tmpCreationDate,_tmpHasDeleted,_tmpCreatorTenantId,_tmpCreatorUserId,_tmpSenderUserId,_tmpRecipientUserId,_tmpUpdatedAt,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
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
  public List<String> getThreadIdByRecipientUserId(final String recipientUserId) {
    final String _sql = "SELECT id FROM thread WHERE recipient_user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipientUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipientUserId);
    }
    __db.assertNotSuspendingTransaction();
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
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Maybe<String> getThreadIdByRecipientId(final String recipientUserId) {
    final String _sql = "SELECT id FROM thread WHERE recipient_user_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (recipientUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, recipientUserId);
    }
    return Maybe.fromCallable(new Callable<String>() {
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
  public Single<ThreadEmbedded> getThread(final String tenantId, final String threadId) {
    final String _sql = "SELECT * FROM thread WHERE tenant_id = ? AND id = ?";
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
    return RxRoom.createSingle(new Callable<ThreadEmbedded>() {
      @Override
      public ThreadEmbedded call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
            final int _cursorIndexOfTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "tenant_id");
            final int _cursorIndexOfSenderChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_chat_id");
            final int _cursorIndexOfRecipientChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_chat_id");
            final int _cursorIndexOfMessageCount = CursorUtil.getColumnIndexOrThrow(_cursor, "message_count");
            final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
            final int _cursorIndexOfUnReadCount = CursorUtil.getColumnIndexOrThrow(_cursor, "unread_count");
            final int _cursorIndexOfCreationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "creation_date");
            final int _cursorIndexOfHasDeleted = CursorUtil.getColumnIndexOrThrow(_cursor, "has_deleted");
            final int _cursorIndexOfCreatorTenantId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_tenant_id");
            final int _cursorIndexOfCreatorUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "creator_user_id");
            final int _cursorIndexOfSenderUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_user_id");
            final int _cursorIndexOfRecipientUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipient_user_id");
            final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_at");
            final int _cursorIndexOfNotificationSettings = CursorUtil.getColumnIndexOrThrow(_cursor, "notification_settings");
            final int _cursorIndexOfValidTill = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till");
            final int _cursorIndexOfValidTillValue = CursorUtil.getColumnIndexOrThrow(_cursor, "valid_till_value");
            final HashMap<String, ArrayList<ThreadUserLink>> _collectionThreadUserLinks = new HashMap<String, ArrayList<ThreadUserLink>>();
            final HashMap<String, ArrayList<SingleChat>> _collectionSingleChatList = new HashMap<String, ArrayList<SingleChat>>();
            final HashMap<String, ArrayList<ThreadMetadata>> _collectionThreadMetadataList = new HashMap<String, ArrayList<ThreadMetadata>>();
            while (_cursor.moveToNext()) {
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey = _cursor.getString(_cursorIndexOfId);
                ArrayList<ThreadUserLink> _tmpThreadUserLinksCollection = _collectionThreadUserLinks.get(_tmpKey);
                if (_tmpThreadUserLinksCollection == null) {
                  _tmpThreadUserLinksCollection = new ArrayList<ThreadUserLink>();
                  _collectionThreadUserLinks.put(_tmpKey, _tmpThreadUserLinksCollection);
                }
              }
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                ArrayList<SingleChat> _tmpSingleChatListCollection = _collectionSingleChatList.get(_tmpKey_1);
                if (_tmpSingleChatListCollection == null) {
                  _tmpSingleChatListCollection = new ArrayList<SingleChat>();
                  _collectionSingleChatList.put(_tmpKey_1, _tmpSingleChatListCollection);
                }
              }
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
                ArrayList<ThreadMetadata> _tmpThreadMetadataListCollection = _collectionThreadMetadataList.get(_tmpKey_2);
                if (_tmpThreadMetadataListCollection == null) {
                  _tmpThreadMetadataListCollection = new ArrayList<ThreadMetadata>();
                  _collectionThreadMetadataList.put(_tmpKey_2, _tmpThreadMetadataListCollection);
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshipthreadUserLinkAscomRipbullErtcCacheDatabaseEntityThreadUserLink(_collectionThreadUserLinks);
            __fetchRelationshipsingleChatAscomRipbullErtcCacheDatabaseEntitySingleChat(_collectionSingleChatList);
            __fetchRelationshipthreadMetaDataAscomRipbullErtcCacheDatabaseEntityThreadMetadata(_collectionThreadMetadataList);
            final ThreadEmbedded _result;
            if(_cursor.moveToFirst()) {
              final Thread _tmpThread;
              if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfTenantId) && _cursor.isNull(_cursorIndexOfSenderChatId) && _cursor.isNull(_cursorIndexOfRecipientChatId) && _cursor.isNull(_cursorIndexOfMessageCount) && _cursor.isNull(_cursorIndexOfRead) && _cursor.isNull(_cursorIndexOfUnReadCount) && _cursor.isNull(_cursorIndexOfCreationDate) && _cursor.isNull(_cursorIndexOfHasDeleted) && _cursor.isNull(_cursorIndexOfCreatorTenantId) && _cursor.isNull(_cursorIndexOfCreatorUserId) && _cursor.isNull(_cursorIndexOfSenderUserId) && _cursor.isNull(_cursorIndexOfRecipientUserId) && _cursor.isNull(_cursorIndexOfUpdatedAt) && _cursor.isNull(_cursorIndexOfNotificationSettings) && _cursor.isNull(_cursorIndexOfValidTill) && _cursor.isNull(_cursorIndexOfValidTillValue))) {
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
                final String _tmpType;
                if (_cursor.isNull(_cursorIndexOfType)) {
                  _tmpType = null;
                } else {
                  _tmpType = _cursor.getString(_cursorIndexOfType);
                }
                final String _tmpTenantId;
                if (_cursor.isNull(_cursorIndexOfTenantId)) {
                  _tmpTenantId = null;
                } else {
                  _tmpTenantId = _cursor.getString(_cursorIndexOfTenantId);
                }
                final String _tmpSenderChatId;
                if (_cursor.isNull(_cursorIndexOfSenderChatId)) {
                  _tmpSenderChatId = null;
                } else {
                  _tmpSenderChatId = _cursor.getString(_cursorIndexOfSenderChatId);
                }
                final String _tmpRecipientChatId;
                if (_cursor.isNull(_cursorIndexOfRecipientChatId)) {
                  _tmpRecipientChatId = null;
                } else {
                  _tmpRecipientChatId = _cursor.getString(_cursorIndexOfRecipientChatId);
                }
                final int _tmpMessageCount;
                _tmpMessageCount = _cursor.getInt(_cursorIndexOfMessageCount);
                final int _tmpRead;
                _tmpRead = _cursor.getInt(_cursorIndexOfRead);
                final int _tmpUnReadCount;
                _tmpUnReadCount = _cursor.getInt(_cursorIndexOfUnReadCount);
                final long _tmpCreationDate;
                _tmpCreationDate = _cursor.getLong(_cursorIndexOfCreationDate);
                final int _tmpHasDeleted;
                _tmpHasDeleted = _cursor.getInt(_cursorIndexOfHasDeleted);
                final String _tmpCreatorTenantId;
                if (_cursor.isNull(_cursorIndexOfCreatorTenantId)) {
                  _tmpCreatorTenantId = null;
                } else {
                  _tmpCreatorTenantId = _cursor.getString(_cursorIndexOfCreatorTenantId);
                }
                final String _tmpCreatorUserId;
                if (_cursor.isNull(_cursorIndexOfCreatorUserId)) {
                  _tmpCreatorUserId = null;
                } else {
                  _tmpCreatorUserId = _cursor.getString(_cursorIndexOfCreatorUserId);
                }
                final String _tmpSenderUserId;
                if (_cursor.isNull(_cursorIndexOfSenderUserId)) {
                  _tmpSenderUserId = null;
                } else {
                  _tmpSenderUserId = _cursor.getString(_cursorIndexOfSenderUserId);
                }
                final String _tmpRecipientUserId;
                if (_cursor.isNull(_cursorIndexOfRecipientUserId)) {
                  _tmpRecipientUserId = null;
                } else {
                  _tmpRecipientUserId = _cursor.getString(_cursorIndexOfRecipientUserId);
                }
                final long _tmpUpdatedAt;
                _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
                final String _tmpNotificationSettings;
                if (_cursor.isNull(_cursorIndexOfNotificationSettings)) {
                  _tmpNotificationSettings = null;
                } else {
                  _tmpNotificationSettings = _cursor.getString(_cursorIndexOfNotificationSettings);
                }
                final long _tmpValidTill;
                _tmpValidTill = _cursor.getLong(_cursorIndexOfValidTill);
                final String _tmpValidTillValue;
                if (_cursor.isNull(_cursorIndexOfValidTillValue)) {
                  _tmpValidTillValue = null;
                } else {
                  _tmpValidTillValue = _cursor.getString(_cursorIndexOfValidTillValue);
                }
                _tmpThread = new Thread(_tmpId,_tmpName,_tmpType,_tmpTenantId,_tmpSenderChatId,_tmpRecipientChatId,_tmpMessageCount,_tmpRead,_tmpUnReadCount,_tmpCreationDate,_tmpHasDeleted,_tmpCreatorTenantId,_tmpCreatorUserId,_tmpSenderUserId,_tmpRecipientUserId,_tmpUpdatedAt,_tmpNotificationSettings,_tmpValidTill,_tmpValidTillValue);
              }  else  {
                _tmpThread = null;
              }
              ArrayList<ThreadUserLink> _tmpThreadUserLinksCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
                _tmpThreadUserLinksCollection_1 = _collectionThreadUserLinks.get(_tmpKey_3);
              }
              if (_tmpThreadUserLinksCollection_1 == null) {
                _tmpThreadUserLinksCollection_1 = new ArrayList<ThreadUserLink>();
              }
              ArrayList<SingleChat> _tmpSingleChatListCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_4 = _cursor.getString(_cursorIndexOfId);
                _tmpSingleChatListCollection_1 = _collectionSingleChatList.get(_tmpKey_4);
              }
              if (_tmpSingleChatListCollection_1 == null) {
                _tmpSingleChatListCollection_1 = new ArrayList<SingleChat>();
              }
              ArrayList<ThreadMetadata> _tmpThreadMetadataListCollection_1 = null;
              if (!_cursor.isNull(_cursorIndexOfId)) {
                final String _tmpKey_5 = _cursor.getString(_cursorIndexOfId);
                _tmpThreadMetadataListCollection_1 = _collectionThreadMetadataList.get(_tmpKey_5);
              }
              if (_tmpThreadMetadataListCollection_1 == null) {
                _tmpThreadMetadataListCollection_1 = new ArrayList<ThreadMetadata>();
              }
              _result = new ThreadEmbedded();
              _result.setThread(_tmpThread);
              _result.setThreadUserLinks(_tmpThreadUserLinksCollection_1);
              _result.setSingleChatList(_tmpSingleChatListCollection_1);
              _result.setThreadMetadataList(_tmpThreadMetadataListCollection_1);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshipthreadUserLinkAscomRipbullErtcCacheDatabaseEntityThreadUserLink(
      final HashMap<String, ArrayList<ThreadUserLink>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<ThreadUserLink>> _tmpInnerMap = new HashMap<String, ArrayList<ThreadUserLink>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipthreadUserLinkAscomRipbullErtcCacheDatabaseEntityThreadUserLink(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<ThreadUserLink>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipthreadUserLinkAscomRipbullErtcCacheDatabaseEntityThreadUserLink(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`sender_id`,`recipient_id`,`thread_id` FROM `thread_user_link` WHERE `thread_id` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "thread_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfSenderId = 1;
      final int _cursorIndexOfRecipientId = 2;
      final int _cursorIndexOfThreadId = 3;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<ThreadUserLink> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final ThreadUserLink _item_1;
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
            _item_1 = new ThreadUserLink(_tmpSenderId,_tmpRecipientId,_tmpThreadId);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item_1.setId(_tmpId);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipsingleChatAscomRipbullErtcCacheDatabaseEntitySingleChat(
      final HashMap<String, ArrayList<SingleChat>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<SingleChat>> _tmpInnerMap = new HashMap<String, ArrayList<SingleChat>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipsingleChatAscomRipbullErtcCacheDatabaseEntitySingleChat(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<SingleChat>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipsingleChatAscomRipbullErtcCacheDatabaseEntitySingleChat(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`media_name`,`local_media_path`,`download_status`,`send_to_channel`,`parent_msg_id`,`parent_msg`,`event_type`,`delete_type`,`forward_msg_unique_id`,`is_forward_message`,`update_type`,`client_created_at`,`custom_data`,`is_followed`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude` FROM `single_chat` WHERE `thread_id` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "thread_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfCreatedAt = 1;
      final int _cursorIndexOfMessage = 2;
      final int _cursorIndexOfRead = 3;
      final int _cursorIndexOfType = 4;
      final int _cursorIndexOfSenderAppUserId = 5;
      final int _cursorIndexOfThreadId = 6;
      final int _cursorIndexOfNextMessageId = 7;
      final int _cursorIndexOfLastMessageId = 8;
      final int _cursorIndexOfStatus = 9;
      final int _cursorIndexOfMsgType = 10;
      final int _cursorIndexOfMsgUniqueId = 11;
      final int _cursorIndexOfMediaPath = 12;
      final int _cursorIndexOfMediaThumbnail = 13;
      final int _cursorIndexOfContactName = 14;
      final int _cursorIndexOfPhoneContactList = 15;
      final int _cursorIndexOfEmailContactList = 16;
      final int _cursorIndexOfIsStarredChat = 17;
      final int _cursorIndexOfGifPath = 18;
      final int _cursorIndexOfMediaName = 19;
      final int _cursorIndexOfLocalMediaPath = 20;
      final int _cursorIndexOfDownloadStatus = 21;
      final int _cursorIndexOfSendToChannel = 22;
      final int _cursorIndexOfParentMsgId = 23;
      final int _cursorIndexOfParentMsg = 24;
      final int _cursorIndexOfChatEventType = 25;
      final int _cursorIndexOfDeleteType = 26;
      final int _cursorIndexOfForwardMsgUniqueId = 27;
      final int _cursorIndexOfIsForwardMessage = 28;
      final int _cursorIndexOfUpdateType = 29;
      final int _cursorIndexOfClientCreatedAt = 30;
      final int _cursorIndexOfCustomData = 31;
      final int _cursorIndexOfIsFollowed = 32;
      final int _cursorIndexOfChatReportId = 33;
      final int _cursorIndexOfReportType = 34;
      final int _cursorIndexOfReason = 35;
      final int _cursorIndexOfMentions = 36;
      final int _cursorIndexOfMentionedUsers = 37;
      final int _cursorIndexOfAddress = 38;
      final int _cursorIndexOfLatitude = 39;
      final int _cursorIndexOfLongitude = 40;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<SingleChat> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final SingleChat _item_1;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final Long _tmpCreatedAt;
            if (_cursor.isNull(_cursorIndexOfCreatedAt)) {
              _tmpCreatedAt = null;
            } else {
              _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            }
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final Integer _tmpRead;
            if (_cursor.isNull(_cursorIndexOfRead)) {
              _tmpRead = null;
            } else {
              _tmpRead = _cursor.getInt(_cursorIndexOfRead);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final String _tmpSenderAppUserId;
            if (_cursor.isNull(_cursorIndexOfSenderAppUserId)) {
              _tmpSenderAppUserId = null;
            } else {
              _tmpSenderAppUserId = _cursor.getString(_cursorIndexOfSenderAppUserId);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            final String _tmpNextMessageId;
            if (_cursor.isNull(_cursorIndexOfNextMessageId)) {
              _tmpNextMessageId = null;
            } else {
              _tmpNextMessageId = _cursor.getString(_cursorIndexOfNextMessageId);
            }
            final String _tmpLastMessageId;
            if (_cursor.isNull(_cursorIndexOfLastMessageId)) {
              _tmpLastMessageId = null;
            } else {
              _tmpLastMessageId = _cursor.getString(_cursorIndexOfLastMessageId);
            }
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpMsgType;
            if (_cursor.isNull(_cursorIndexOfMsgType)) {
              _tmpMsgType = null;
            } else {
              _tmpMsgType = _cursor.getString(_cursorIndexOfMsgType);
            }
            final String _tmpMsgUniqueId;
            if (_cursor.isNull(_cursorIndexOfMsgUniqueId)) {
              _tmpMsgUniqueId = null;
            } else {
              _tmpMsgUniqueId = _cursor.getString(_cursorIndexOfMsgUniqueId);
            }
            final String _tmpMediaPath;
            if (_cursor.isNull(_cursorIndexOfMediaPath)) {
              _tmpMediaPath = null;
            } else {
              _tmpMediaPath = _cursor.getString(_cursorIndexOfMediaPath);
            }
            final String _tmpMediaThumbnail;
            if (_cursor.isNull(_cursorIndexOfMediaThumbnail)) {
              _tmpMediaThumbnail = null;
            } else {
              _tmpMediaThumbnail = _cursor.getString(_cursorIndexOfMediaThumbnail);
            }
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final List<PhoneContact> _tmpPhoneContactList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfPhoneContactList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfPhoneContactList);
            }
            _tmpPhoneContactList = __converters.jsonToPhoneContactList(_tmp);
            final List<EmailContact> _tmpEmailContactList;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEmailContactList)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfEmailContactList);
            }
            _tmpEmailContactList = __converters.jsonToEmailContactList(_tmp_1);
            final String _tmpIsStarredChat;
            if (_cursor.isNull(_cursorIndexOfIsStarredChat)) {
              _tmpIsStarredChat = null;
            } else {
              _tmpIsStarredChat = _cursor.getString(_cursorIndexOfIsStarredChat);
            }
            final String _tmpGifPath;
            if (_cursor.isNull(_cursorIndexOfGifPath)) {
              _tmpGifPath = null;
            } else {
              _tmpGifPath = _cursor.getString(_cursorIndexOfGifPath);
            }
            final String _tmpMediaName;
            if (_cursor.isNull(_cursorIndexOfMediaName)) {
              _tmpMediaName = null;
            } else {
              _tmpMediaName = _cursor.getString(_cursorIndexOfMediaName);
            }
            final String _tmpLocalMediaPath;
            if (_cursor.isNull(_cursorIndexOfLocalMediaPath)) {
              _tmpLocalMediaPath = null;
            } else {
              _tmpLocalMediaPath = _cursor.getString(_cursorIndexOfLocalMediaPath);
            }
            final String _tmpDownloadStatus;
            if (_cursor.isNull(_cursorIndexOfDownloadStatus)) {
              _tmpDownloadStatus = null;
            } else {
              _tmpDownloadStatus = _cursor.getString(_cursorIndexOfDownloadStatus);
            }
            final Integer _tmpSendToChannel;
            if (_cursor.isNull(_cursorIndexOfSendToChannel)) {
              _tmpSendToChannel = null;
            } else {
              _tmpSendToChannel = _cursor.getInt(_cursorIndexOfSendToChannel);
            }
            final String _tmpParentMsgId;
            if (_cursor.isNull(_cursorIndexOfParentMsgId)) {
              _tmpParentMsgId = null;
            } else {
              _tmpParentMsgId = _cursor.getString(_cursorIndexOfParentMsgId);
            }
            final String _tmpParentMsg;
            if (_cursor.isNull(_cursorIndexOfParentMsg)) {
              _tmpParentMsg = null;
            } else {
              _tmpParentMsg = _cursor.getString(_cursorIndexOfParentMsg);
            }
            final String _tmpChatEventType;
            if (_cursor.isNull(_cursorIndexOfChatEventType)) {
              _tmpChatEventType = null;
            } else {
              _tmpChatEventType = _cursor.getString(_cursorIndexOfChatEventType);
            }
            final String _tmpDeleteType;
            if (_cursor.isNull(_cursorIndexOfDeleteType)) {
              _tmpDeleteType = null;
            } else {
              _tmpDeleteType = _cursor.getString(_cursorIndexOfDeleteType);
            }
            final String _tmpForwardMsgUniqueId;
            if (_cursor.isNull(_cursorIndexOfForwardMsgUniqueId)) {
              _tmpForwardMsgUniqueId = null;
            } else {
              _tmpForwardMsgUniqueId = _cursor.getString(_cursorIndexOfForwardMsgUniqueId);
            }
            final Integer _tmpIsForwardMessage;
            if (_cursor.isNull(_cursorIndexOfIsForwardMessage)) {
              _tmpIsForwardMessage = null;
            } else {
              _tmpIsForwardMessage = _cursor.getInt(_cursorIndexOfIsForwardMessage);
            }
            final String _tmpUpdateType;
            if (_cursor.isNull(_cursorIndexOfUpdateType)) {
              _tmpUpdateType = null;
            } else {
              _tmpUpdateType = _cursor.getString(_cursorIndexOfUpdateType);
            }
            final Long _tmpClientCreatedAt;
            if (_cursor.isNull(_cursorIndexOfClientCreatedAt)) {
              _tmpClientCreatedAt = null;
            } else {
              _tmpClientCreatedAt = _cursor.getLong(_cursorIndexOfClientCreatedAt);
            }
            final String _tmpCustomData;
            if (_cursor.isNull(_cursorIndexOfCustomData)) {
              _tmpCustomData = null;
            } else {
              _tmpCustomData = _cursor.getString(_cursorIndexOfCustomData);
            }
            final Integer _tmpIsFollowed;
            if (_cursor.isNull(_cursorIndexOfIsFollowed)) {
              _tmpIsFollowed = null;
            } else {
              _tmpIsFollowed = _cursor.getInt(_cursorIndexOfIsFollowed);
            }
            final String _tmpChatReportId;
            if (_cursor.isNull(_cursorIndexOfChatReportId)) {
              _tmpChatReportId = null;
            } else {
              _tmpChatReportId = _cursor.getString(_cursorIndexOfChatReportId);
            }
            final String _tmpReportType;
            if (_cursor.isNull(_cursorIndexOfReportType)) {
              _tmpReportType = null;
            } else {
              _tmpReportType = _cursor.getString(_cursorIndexOfReportType);
            }
            final String _tmpReason;
            if (_cursor.isNull(_cursorIndexOfReason)) {
              _tmpReason = null;
            } else {
              _tmpReason = _cursor.getString(_cursorIndexOfReason);
            }
            final String _tmpMentions;
            if (_cursor.isNull(_cursorIndexOfMentions)) {
              _tmpMentions = null;
            } else {
              _tmpMentions = _cursor.getString(_cursorIndexOfMentions);
            }
            final String _tmpMentionedUsers;
            if (_cursor.isNull(_cursorIndexOfMentionedUsers)) {
              _tmpMentionedUsers = null;
            } else {
              _tmpMentionedUsers = _cursor.getString(_cursorIndexOfMentionedUsers);
            }
            final Location _tmpLocation;
            if (! (_cursor.isNull(_cursorIndexOfAddress) && _cursor.isNull(_cursorIndexOfLatitude) && _cursor.isNull(_cursorIndexOfLongitude))) {
              final String _tmpAddress;
              if (_cursor.isNull(_cursorIndexOfAddress)) {
                _tmpAddress = null;
              } else {
                _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
              }
              final Double _tmpLatitude;
              if (_cursor.isNull(_cursorIndexOfLatitude)) {
                _tmpLatitude = null;
              } else {
                _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
              }
              final Double _tmpLongitude;
              if (_cursor.isNull(_cursorIndexOfLongitude)) {
                _tmpLongitude = null;
              } else {
                _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
              }
              _tmpLocation = new Location(_tmpAddress,_tmpLatitude,_tmpLongitude);
            }  else  {
              _tmpLocation = null;
            }
            _item_1 = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipthreadMetaDataAscomRipbullErtcCacheDatabaseEntityThreadMetadata(
      final HashMap<String, ArrayList<ThreadMetadata>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<ThreadMetadata>> _tmpInnerMap = new HashMap<String, ArrayList<ThreadMetadata>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipthreadMetaDataAscomRipbullErtcCacheDatabaseEntityThreadMetadata(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<ThreadMetadata>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipthreadMetaDataAscomRipbullErtcCacheDatabaseEntityThreadMetadata(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`thread_id`,`key`,`value` FROM `thread_meta_data` WHERE `thread_id` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "thread_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfThreadId = 1;
      final int _cursorIndexOfKey = 2;
      final int _cursorIndexOfValue = 3;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<ThreadMetadata> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final ThreadMetadata _item_1;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
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
            _item_1 = new ThreadMetadata(_tmpId,_tmpThreadId,_tmpKey_1,_tmpValue);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
