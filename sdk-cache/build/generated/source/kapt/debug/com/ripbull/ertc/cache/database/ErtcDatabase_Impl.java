package com.ripbull.ertc.cache.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.ripbull.ertc.cache.database.dao.ChatReactionDao;
import com.ripbull.ertc.cache.database.dao.ChatReactionDao_Impl;
import com.ripbull.ertc.cache.database.dao.ChatThreadDao;
import com.ripbull.ertc.cache.database.dao.ChatThreadDao_Impl;
import com.ripbull.ertc.cache.database.dao.DomainFilterDao;
import com.ripbull.ertc.cache.database.dao.DomainFilterDao_Impl;
import com.ripbull.ertc.cache.database.dao.DownloadMediaDao;
import com.ripbull.ertc.cache.database.dao.DownloadMediaDao_Impl;
import com.ripbull.ertc.cache.database.dao.EKeyDao;
import com.ripbull.ertc.cache.database.dao.EKeyDao_Impl;
import com.ripbull.ertc.cache.database.dao.GroupDao;
import com.ripbull.ertc.cache.database.dao.GroupDao_Impl;
import com.ripbull.ertc.cache.database.dao.ProfanityFilterDao;
import com.ripbull.ertc.cache.database.dao.ProfanityFilterDao_Impl;
import com.ripbull.ertc.cache.database.dao.SingleChatDao;
import com.ripbull.ertc.cache.database.dao.SingleChatDao_Impl;
import com.ripbull.ertc.cache.database.dao.TenantDao;
import com.ripbull.ertc.cache.database.dao.TenantDao_Impl;
import com.ripbull.ertc.cache.database.dao.ThreadDao;
import com.ripbull.ertc.cache.database.dao.ThreadDao_Impl;
import com.ripbull.ertc.cache.database.dao.ThreadUserLinkDao;
import com.ripbull.ertc.cache.database.dao.ThreadUserLinkDao_Impl;
import com.ripbull.ertc.cache.database.dao.UserDao;
import com.ripbull.ertc.cache.database.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ErtcDatabase_Impl extends ErtcDatabase {
  private volatile SingleChatDao _singleChatDao;

  private volatile ChatThreadDao _chatThreadDao;

  private volatile TenantDao _tenantDao;

  private volatile ThreadDao _threadDao;

  private volatile UserDao _userDao;

  private volatile ThreadUserLinkDao _threadUserLinkDao;

  private volatile GroupDao _groupDao;

  private volatile EKeyDao _eKeyDao;

  private volatile DownloadMediaDao _downloadMediaDao;

  private volatile ChatReactionDao _chatReactionDao;

  private volatile DomainFilterDao _domainFilterDao;

  private volatile ProfanityFilterDao _profanityFilterDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(10) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `single_chat` (`id` TEXT NOT NULL, `createdAt` INTEGER, `message` TEXT, `read` INTEGER, `type` TEXT, `sender_id` TEXT, `thread_id` TEXT, `next_msg_id` TEXT, `last_msg_id` TEXT, `status` TEXT, `msg_type` TEXT, `msg_unique_id` TEXT, `media_path` TEXT, `media_thumbnail` TEXT, `contact_name` TEXT, `phone_contact_list` TEXT, `email_contact_list` TEXT, `isStarredChat` TEXT, `gif_path` TEXT, `media_name` TEXT, `local_media_path` TEXT, `download_status` TEXT, `send_to_channel` INTEGER, `parent_msg_id` TEXT, `parent_msg` TEXT, `event_type` TEXT, `delete_type` TEXT, `forward_msg_unique_id` TEXT, `is_forward_message` INTEGER, `update_type` TEXT, `client_created_at` INTEGER, `custom_data` TEXT, `is_followed` INTEGER, `chat_report_id` TEXT, `report_type` TEXT, `reason` TEXT, `mentions` TEXT, `mentioned_users` TEXT, `address` TEXT, `latitude` REAL, `longitude` REAL, PRIMARY KEY(`id`), FOREIGN KEY(`thread_id`) REFERENCES `thread`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_single_chat_id_thread_id` ON `single_chat` (`id`, `thread_id`)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_single_chat_msg_unique_id_thread_id` ON `single_chat` (`msg_unique_id`, `thread_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `single_chat_meta_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `message_id` TEXT, `key` TEXT, `value` TEXT, FOREIGN KEY(`message_id`) REFERENCES `thread`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_single_chat_meta_data_message_id` ON `single_chat_meta_data` (`message_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tenant` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `api_key` TEXT NOT NULL, `name_space` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tenant_config` (`tenant_id` TEXT NOT NULL, `config_key` TEXT NOT NULL, `config_value` TEXT NOT NULL, PRIMARY KEY(`tenant_id`, `config_key`), FOREIGN KEY(`tenant_id`) REFERENCES `tenant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` TEXT NOT NULL, `tenant_id` TEXT, `name` TEXT, `app_state` TEXT, `login_type` TEXT, `profile_pic` TEXT, `profile_thumb` TEXT, `profile_status` TEXT, `login_timestamp` INTEGER, `user_chat_id` TEXT, `availability_status` TEXT, `blocked_status` TEXT, `notification_settings` TEXT, `valid_till` INTEGER, `valid_till_value` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`tenant_id`) REFERENCES `tenant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_user_id_tenant_id` ON `user` (`id`, `tenant_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `group` (`group_id` TEXT NOT NULL, `tenant_id` TEXT NOT NULL, `thread_id` TEXT NOT NULL, `group_type` TEXT, `name` TEXT, `login_type` TEXT, `group_pic` TEXT, `group_thumb` TEXT, `group_desc` TEXT, `login_timestamp` INTEGER NOT NULL, `group_users` TEXT, `joined` INTEGER, `participants_count` INTEGER, `group_status` TEXT, PRIMARY KEY(`group_id`), FOREIGN KEY(`tenant_id`) REFERENCES `tenant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_group_group_id` ON `group` (`group_id`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_group_tenant_id` ON `group` (`tenant_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `group_metadata` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `group_id` TEXT NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL, FOREIGN KEY(`group_id`) REFERENCES `group`(`group_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_group_metadata_group_id` ON `group_metadata` (`group_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user_metadata` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `key` TEXT, `value` TEXT, FOREIGN KEY(`user_id`) REFERENCES `user`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_user_metadata_user_id` ON `user_metadata` (`user_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `thread` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, `tenant_id` TEXT NOT NULL, `sender_chat_id` TEXT NOT NULL, `recipient_chat_id` TEXT NOT NULL, `message_count` INTEGER NOT NULL, `read` INTEGER NOT NULL, `unread_count` INTEGER NOT NULL, `creation_date` INTEGER NOT NULL, `has_deleted` INTEGER NOT NULL, `creator_tenant_id` TEXT NOT NULL, `creator_user_id` TEXT NOT NULL, `sender_user_id` TEXT NOT NULL, `recipient_user_id` TEXT NOT NULL, `updated_at` INTEGER NOT NULL, `notification_settings` TEXT, `valid_till` INTEGER NOT NULL, `valid_till_value` TEXT, PRIMARY KEY(`id`), FOREIGN KEY(`tenant_id`) REFERENCES `tenant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_thread_tenant_id` ON `thread` (`tenant_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `thread_user_link` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `sender_id` TEXT NOT NULL, `recipient_id` TEXT NOT NULL, `thread_id` TEXT NOT NULL, FOREIGN KEY(`thread_id`) REFERENCES `thread`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_thread_user_link_thread_id` ON `thread_user_link` (`thread_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `thread_meta_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `thread_id` TEXT NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL, FOREIGN KEY(`thread_id`) REFERENCES `thread`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_thread_meta_data_thread_id` ON `thread_meta_data` (`thread_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `eKeys` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `keyId` TEXT, `deviceId` TEXT, `publicKey` TEXT, `privateKey` TEXT, `ertcUserId` TEXT, `tenant_id` TEXT, `time` INTEGER NOT NULL)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_eKeys_keyId_deviceId_ertcUserId` ON `eKeys` (`keyId`, `deviceId`, `ertcUserId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `chat_thread` (`id` TEXT NOT NULL, `createdAt` INTEGER, `message` TEXT, `read` INTEGER, `type` TEXT, `sender_id` TEXT, `thread_id` TEXT, `next_msg_id` TEXT, `last_msg_id` TEXT, `status` TEXT, `msg_type` TEXT, `msg_unique_id` TEXT, `media_path` TEXT, `media_thumbnail` TEXT, `media_name` TEXT, `local_media_path` TEXT, `download_status` TEXT, `contact_name` TEXT, `phone_contact_list` TEXT, `email_contact_list` TEXT, `isStarredChat` TEXT, `gif_path` TEXT, `send_to_channel` INTEGER, `delete_type` TEXT, `parent_msg_id` TEXT, `update_type` TEXT, `client_created_at` INTEGER, `custom_data` TEXT, `chat_report_id` TEXT, `report_type` TEXT, `reason` TEXT, `mentions` TEXT, `mentioned_users` TEXT, `address` TEXT, `latitude` REAL, `longitude` REAL, PRIMARY KEY(`id`), FOREIGN KEY(`parent_msg_id`) REFERENCES `single_chat`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_thread_id_parent_msg_id` ON `chat_thread` (`id`, `parent_msg_id`)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_thread_msg_unique_id_thread_id` ON `chat_thread` (`msg_unique_id`, `thread_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `download` (`id` INTEGER NOT NULL, `url` TEXT, `etag` TEXT, `dir_path` TEXT, `file_name` TEXT, `msg_id` TEXT, `total_bytes` INTEGER, `downloaded_bytes` INTEGER, `last_modified_at` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `chat_reaction` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `unicode` TEXT NOT NULL, `thread_id` TEXT, `user_chat_id` TEXT, `chat_msg_id` TEXT, `chat_thread_msg_id` TEXT, `total_count` INTEGER, FOREIGN KEY(`chat_msg_id`) REFERENCES `single_chat`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`chat_thread_msg_id`) REFERENCES `chat_thread`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_reaction_id_chat_msg_id_chat_thread_msg_id` ON `chat_reaction` (`id`, `chat_msg_id`, `chat_thread_msg_id`)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_reaction_chat_msg_id_unicode_user_chat_id` ON `chat_reaction` (`chat_msg_id`, `unicode`, `user_chat_id`)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_chat_reaction_chat_thread_msg_id_unicode_user_chat_id` ON `chat_reaction` (`chat_thread_msg_id`, `unicode`, `user_chat_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `domain_filter` (`domain` TEXT NOT NULL, `tenant_id` TEXT, `action_type` TEXT, PRIMARY KEY(`domain`), FOREIGN KEY(`tenant_id`) REFERENCES `tenant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_domain_filter_tenant_id` ON `domain_filter` (`tenant_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `profanity_filter` (`keyword` TEXT NOT NULL, `tenant_id` TEXT, `regex` TEXT, `action_type` TEXT, PRIMARY KEY(`keyword`), FOREIGN KEY(`tenant_id`) REFERENCES `tenant`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_profanity_filter_tenant_id` ON `profanity_filter` (`tenant_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0e929f9d6c4d583d1cac2d241b898dc6')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `single_chat`");
        _db.execSQL("DROP TABLE IF EXISTS `single_chat_meta_data`");
        _db.execSQL("DROP TABLE IF EXISTS `tenant`");
        _db.execSQL("DROP TABLE IF EXISTS `tenant_config`");
        _db.execSQL("DROP TABLE IF EXISTS `user`");
        _db.execSQL("DROP TABLE IF EXISTS `group`");
        _db.execSQL("DROP TABLE IF EXISTS `group_metadata`");
        _db.execSQL("DROP TABLE IF EXISTS `user_metadata`");
        _db.execSQL("DROP TABLE IF EXISTS `thread`");
        _db.execSQL("DROP TABLE IF EXISTS `thread_user_link`");
        _db.execSQL("DROP TABLE IF EXISTS `thread_meta_data`");
        _db.execSQL("DROP TABLE IF EXISTS `eKeys`");
        _db.execSQL("DROP TABLE IF EXISTS `chat_thread`");
        _db.execSQL("DROP TABLE IF EXISTS `download`");
        _db.execSQL("DROP TABLE IF EXISTS `chat_reaction`");
        _db.execSQL("DROP TABLE IF EXISTS `domain_filter`");
        _db.execSQL("DROP TABLE IF EXISTS `profanity_filter`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSingleChat = new HashMap<String, TableInfo.Column>(41);
        _columnsSingleChat.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("read", new TableInfo.Column("read", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("sender_id", new TableInfo.Column("sender_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("thread_id", new TableInfo.Column("thread_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("next_msg_id", new TableInfo.Column("next_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("last_msg_id", new TableInfo.Column("last_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("msg_type", new TableInfo.Column("msg_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("msg_unique_id", new TableInfo.Column("msg_unique_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("media_path", new TableInfo.Column("media_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("media_thumbnail", new TableInfo.Column("media_thumbnail", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("contact_name", new TableInfo.Column("contact_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("phone_contact_list", new TableInfo.Column("phone_contact_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("email_contact_list", new TableInfo.Column("email_contact_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("isStarredChat", new TableInfo.Column("isStarredChat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("gif_path", new TableInfo.Column("gif_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("media_name", new TableInfo.Column("media_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("local_media_path", new TableInfo.Column("local_media_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("download_status", new TableInfo.Column("download_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("send_to_channel", new TableInfo.Column("send_to_channel", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("parent_msg_id", new TableInfo.Column("parent_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("parent_msg", new TableInfo.Column("parent_msg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("event_type", new TableInfo.Column("event_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("delete_type", new TableInfo.Column("delete_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("forward_msg_unique_id", new TableInfo.Column("forward_msg_unique_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("is_forward_message", new TableInfo.Column("is_forward_message", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("update_type", new TableInfo.Column("update_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("client_created_at", new TableInfo.Column("client_created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("custom_data", new TableInfo.Column("custom_data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("is_followed", new TableInfo.Column("is_followed", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("chat_report_id", new TableInfo.Column("chat_report_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("report_type", new TableInfo.Column("report_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("mentions", new TableInfo.Column("mentions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("mentioned_users", new TableInfo.Column("mentioned_users", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChat.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSingleChat = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSingleChat.add(new TableInfo.ForeignKey("thread", "CASCADE", "NO ACTION",Arrays.asList("thread_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSingleChat = new HashSet<TableInfo.Index>(2);
        _indicesSingleChat.add(new TableInfo.Index("index_single_chat_id_thread_id", true, Arrays.asList("id","thread_id"), Arrays.asList("ASC","ASC")));
        _indicesSingleChat.add(new TableInfo.Index("index_single_chat_msg_unique_id_thread_id", true, Arrays.asList("msg_unique_id","thread_id"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoSingleChat = new TableInfo("single_chat", _columnsSingleChat, _foreignKeysSingleChat, _indicesSingleChat);
        final TableInfo _existingSingleChat = TableInfo.read(_db, "single_chat");
        if (! _infoSingleChat.equals(_existingSingleChat)) {
          return new RoomOpenHelper.ValidationResult(false, "single_chat(com.ripbull.ertc.cache.database.entity.SingleChat).\n"
                  + " Expected:\n" + _infoSingleChat + "\n"
                  + " Found:\n" + _existingSingleChat);
        }
        final HashMap<String, TableInfo.Column> _columnsSingleChatMetaData = new HashMap<String, TableInfo.Column>(4);
        _columnsSingleChatMetaData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChatMetaData.put("message_id", new TableInfo.Column("message_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChatMetaData.put("key", new TableInfo.Column("key", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSingleChatMetaData.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSingleChatMetaData = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSingleChatMetaData.add(new TableInfo.ForeignKey("thread", "CASCADE", "CASCADE",Arrays.asList("message_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesSingleChatMetaData = new HashSet<TableInfo.Index>(1);
        _indicesSingleChatMetaData.add(new TableInfo.Index("index_single_chat_meta_data_message_id", false, Arrays.asList("message_id"), Arrays.asList("ASC")));
        final TableInfo _infoSingleChatMetaData = new TableInfo("single_chat_meta_data", _columnsSingleChatMetaData, _foreignKeysSingleChatMetaData, _indicesSingleChatMetaData);
        final TableInfo _existingSingleChatMetaData = TableInfo.read(_db, "single_chat_meta_data");
        if (! _infoSingleChatMetaData.equals(_existingSingleChatMetaData)) {
          return new RoomOpenHelper.ValidationResult(false, "single_chat_meta_data(com.ripbull.ertc.cache.database.entity.SingleChatMetadata).\n"
                  + " Expected:\n" + _infoSingleChatMetaData + "\n"
                  + " Found:\n" + _existingSingleChatMetaData);
        }
        final HashMap<String, TableInfo.Column> _columnsTenant = new HashMap<String, TableInfo.Column>(4);
        _columnsTenant.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTenant.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTenant.put("api_key", new TableInfo.Column("api_key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTenant.put("name_space", new TableInfo.Column("name_space", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTenant = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTenant = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTenant = new TableInfo("tenant", _columnsTenant, _foreignKeysTenant, _indicesTenant);
        final TableInfo _existingTenant = TableInfo.read(_db, "tenant");
        if (! _infoTenant.equals(_existingTenant)) {
          return new RoomOpenHelper.ValidationResult(false, "tenant(com.ripbull.ertc.cache.database.entity.Tenant).\n"
                  + " Expected:\n" + _infoTenant + "\n"
                  + " Found:\n" + _existingTenant);
        }
        final HashMap<String, TableInfo.Column> _columnsTenantConfig = new HashMap<String, TableInfo.Column>(3);
        _columnsTenantConfig.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTenantConfig.put("config_key", new TableInfo.Column("config_key", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTenantConfig.put("config_value", new TableInfo.Column("config_value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTenantConfig = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTenantConfig.add(new TableInfo.ForeignKey("tenant", "CASCADE", "NO ACTION",Arrays.asList("tenant_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTenantConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTenantConfig = new TableInfo("tenant_config", _columnsTenantConfig, _foreignKeysTenantConfig, _indicesTenantConfig);
        final TableInfo _existingTenantConfig = TableInfo.read(_db, "tenant_config");
        if (! _infoTenantConfig.equals(_existingTenantConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "tenant_config(com.ripbull.ertc.cache.database.entity.TenantConfig).\n"
                  + " Expected:\n" + _infoTenantConfig + "\n"
                  + " Found:\n" + _existingTenantConfig);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(15);
        _columnsUser.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("app_state", new TableInfo.Column("app_state", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("login_type", new TableInfo.Column("login_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("profile_pic", new TableInfo.Column("profile_pic", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("profile_thumb", new TableInfo.Column("profile_thumb", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("profile_status", new TableInfo.Column("profile_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("login_timestamp", new TableInfo.Column("login_timestamp", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("user_chat_id", new TableInfo.Column("user_chat_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("availability_status", new TableInfo.Column("availability_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("blocked_status", new TableInfo.Column("blocked_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("notification_settings", new TableInfo.Column("notification_settings", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("valid_till", new TableInfo.Column("valid_till", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("valid_till_value", new TableInfo.Column("valid_till_value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysUser.add(new TableInfo.ForeignKey("tenant", "CASCADE", "NO ACTION",Arrays.asList("tenant_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(1);
        _indicesUser.add(new TableInfo.Index("index_user_id_tenant_id", false, Arrays.asList("id","tenant_id"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.ripbull.ertc.cache.database.entity.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsGroup = new HashMap<String, TableInfo.Column>(14);
        _columnsGroup.put("group_id", new TableInfo.Column("group_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("thread_id", new TableInfo.Column("thread_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_type", new TableInfo.Column("group_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("login_type", new TableInfo.Column("login_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_pic", new TableInfo.Column("group_pic", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_thumb", new TableInfo.Column("group_thumb", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_desc", new TableInfo.Column("group_desc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("login_timestamp", new TableInfo.Column("login_timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_users", new TableInfo.Column("group_users", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("joined", new TableInfo.Column("joined", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("participants_count", new TableInfo.Column("participants_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_status", new TableInfo.Column("group_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGroup = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysGroup.add(new TableInfo.ForeignKey("tenant", "CASCADE", "NO ACTION",Arrays.asList("tenant_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesGroup = new HashSet<TableInfo.Index>(2);
        _indicesGroup.add(new TableInfo.Index("index_group_group_id", false, Arrays.asList("group_id"), Arrays.asList("ASC")));
        _indicesGroup.add(new TableInfo.Index("index_group_tenant_id", false, Arrays.asList("tenant_id"), Arrays.asList("ASC")));
        final TableInfo _infoGroup = new TableInfo("group", _columnsGroup, _foreignKeysGroup, _indicesGroup);
        final TableInfo _existingGroup = TableInfo.read(_db, "group");
        if (! _infoGroup.equals(_existingGroup)) {
          return new RoomOpenHelper.ValidationResult(false, "group(com.ripbull.ertc.cache.database.entity.Group).\n"
                  + " Expected:\n" + _infoGroup + "\n"
                  + " Found:\n" + _existingGroup);
        }
        final HashMap<String, TableInfo.Column> _columnsGroupMetadata = new HashMap<String, TableInfo.Column>(4);
        _columnsGroupMetadata.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroupMetadata.put("group_id", new TableInfo.Column("group_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroupMetadata.put("key", new TableInfo.Column("key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroupMetadata.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGroupMetadata = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysGroupMetadata.add(new TableInfo.ForeignKey("group", "CASCADE", "NO ACTION",Arrays.asList("group_id"), Arrays.asList("group_id")));
        final HashSet<TableInfo.Index> _indicesGroupMetadata = new HashSet<TableInfo.Index>(1);
        _indicesGroupMetadata.add(new TableInfo.Index("index_group_metadata_group_id", false, Arrays.asList("group_id"), Arrays.asList("ASC")));
        final TableInfo _infoGroupMetadata = new TableInfo("group_metadata", _columnsGroupMetadata, _foreignKeysGroupMetadata, _indicesGroupMetadata);
        final TableInfo _existingGroupMetadata = TableInfo.read(_db, "group_metadata");
        if (! _infoGroupMetadata.equals(_existingGroupMetadata)) {
          return new RoomOpenHelper.ValidationResult(false, "group_metadata(com.ripbull.ertc.cache.database.entity.GroupMetadata).\n"
                  + " Expected:\n" + _infoGroupMetadata + "\n"
                  + " Found:\n" + _existingGroupMetadata);
        }
        final HashMap<String, TableInfo.Column> _columnsUserMetadata = new HashMap<String, TableInfo.Column>(4);
        _columnsUserMetadata.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMetadata.put("user_id", new TableInfo.Column("user_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMetadata.put("key", new TableInfo.Column("key", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserMetadata.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserMetadata = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysUserMetadata.add(new TableInfo.ForeignKey("user", "CASCADE", "NO ACTION",Arrays.asList("user_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesUserMetadata = new HashSet<TableInfo.Index>(1);
        _indicesUserMetadata.add(new TableInfo.Index("index_user_metadata_user_id", false, Arrays.asList("user_id"), Arrays.asList("ASC")));
        final TableInfo _infoUserMetadata = new TableInfo("user_metadata", _columnsUserMetadata, _foreignKeysUserMetadata, _indicesUserMetadata);
        final TableInfo _existingUserMetadata = TableInfo.read(_db, "user_metadata");
        if (! _infoUserMetadata.equals(_existingUserMetadata)) {
          return new RoomOpenHelper.ValidationResult(false, "user_metadata(com.ripbull.ertc.cache.database.entity.UserMetadata).\n"
                  + " Expected:\n" + _infoUserMetadata + "\n"
                  + " Found:\n" + _existingUserMetadata);
        }
        final HashMap<String, TableInfo.Column> _columnsThread = new HashMap<String, TableInfo.Column>(19);
        _columnsThread.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("sender_chat_id", new TableInfo.Column("sender_chat_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("recipient_chat_id", new TableInfo.Column("recipient_chat_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("message_count", new TableInfo.Column("message_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("read", new TableInfo.Column("read", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("unread_count", new TableInfo.Column("unread_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("creation_date", new TableInfo.Column("creation_date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("has_deleted", new TableInfo.Column("has_deleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("creator_tenant_id", new TableInfo.Column("creator_tenant_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("creator_user_id", new TableInfo.Column("creator_user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("sender_user_id", new TableInfo.Column("sender_user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("recipient_user_id", new TableInfo.Column("recipient_user_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("updated_at", new TableInfo.Column("updated_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("notification_settings", new TableInfo.Column("notification_settings", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("valid_till", new TableInfo.Column("valid_till", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThread.put("valid_till_value", new TableInfo.Column("valid_till_value", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysThread = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysThread.add(new TableInfo.ForeignKey("tenant", "CASCADE", "NO ACTION",Arrays.asList("tenant_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesThread = new HashSet<TableInfo.Index>(1);
        _indicesThread.add(new TableInfo.Index("index_thread_tenant_id", false, Arrays.asList("tenant_id"), Arrays.asList("ASC")));
        final TableInfo _infoThread = new TableInfo("thread", _columnsThread, _foreignKeysThread, _indicesThread);
        final TableInfo _existingThread = TableInfo.read(_db, "thread");
        if (! _infoThread.equals(_existingThread)) {
          return new RoomOpenHelper.ValidationResult(false, "thread(com.ripbull.ertc.cache.database.entity.Thread).\n"
                  + " Expected:\n" + _infoThread + "\n"
                  + " Found:\n" + _existingThread);
        }
        final HashMap<String, TableInfo.Column> _columnsThreadUserLink = new HashMap<String, TableInfo.Column>(4);
        _columnsThreadUserLink.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThreadUserLink.put("sender_id", new TableInfo.Column("sender_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThreadUserLink.put("recipient_id", new TableInfo.Column("recipient_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThreadUserLink.put("thread_id", new TableInfo.Column("thread_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysThreadUserLink = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysThreadUserLink.add(new TableInfo.ForeignKey("thread", "CASCADE", "NO ACTION",Arrays.asList("thread_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesThreadUserLink = new HashSet<TableInfo.Index>(1);
        _indicesThreadUserLink.add(new TableInfo.Index("index_thread_user_link_thread_id", false, Arrays.asList("thread_id"), Arrays.asList("ASC")));
        final TableInfo _infoThreadUserLink = new TableInfo("thread_user_link", _columnsThreadUserLink, _foreignKeysThreadUserLink, _indicesThreadUserLink);
        final TableInfo _existingThreadUserLink = TableInfo.read(_db, "thread_user_link");
        if (! _infoThreadUserLink.equals(_existingThreadUserLink)) {
          return new RoomOpenHelper.ValidationResult(false, "thread_user_link(com.ripbull.ertc.cache.database.entity.ThreadUserLink).\n"
                  + " Expected:\n" + _infoThreadUserLink + "\n"
                  + " Found:\n" + _existingThreadUserLink);
        }
        final HashMap<String, TableInfo.Column> _columnsThreadMetaData = new HashMap<String, TableInfo.Column>(4);
        _columnsThreadMetaData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThreadMetaData.put("thread_id", new TableInfo.Column("thread_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThreadMetaData.put("key", new TableInfo.Column("key", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsThreadMetaData.put("value", new TableInfo.Column("value", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysThreadMetaData = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysThreadMetaData.add(new TableInfo.ForeignKey("thread", "CASCADE", "NO ACTION",Arrays.asList("thread_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesThreadMetaData = new HashSet<TableInfo.Index>(1);
        _indicesThreadMetaData.add(new TableInfo.Index("index_thread_meta_data_thread_id", false, Arrays.asList("thread_id"), Arrays.asList("ASC")));
        final TableInfo _infoThreadMetaData = new TableInfo("thread_meta_data", _columnsThreadMetaData, _foreignKeysThreadMetaData, _indicesThreadMetaData);
        final TableInfo _existingThreadMetaData = TableInfo.read(_db, "thread_meta_data");
        if (! _infoThreadMetaData.equals(_existingThreadMetaData)) {
          return new RoomOpenHelper.ValidationResult(false, "thread_meta_data(com.ripbull.ertc.cache.database.entity.ThreadMetadata).\n"
                  + " Expected:\n" + _infoThreadMetaData + "\n"
                  + " Found:\n" + _existingThreadMetaData);
        }
        final HashMap<String, TableInfo.Column> _columnsEKeys = new HashMap<String, TableInfo.Column>(8);
        _columnsEKeys.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("keyId", new TableInfo.Column("keyId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("deviceId", new TableInfo.Column("deviceId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("publicKey", new TableInfo.Column("publicKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("privateKey", new TableInfo.Column("privateKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("ertcUserId", new TableInfo.Column("ertcUserId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEKeys.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEKeys = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEKeys = new HashSet<TableInfo.Index>(1);
        _indicesEKeys.add(new TableInfo.Index("index_eKeys_keyId_deviceId_ertcUserId", true, Arrays.asList("keyId","deviceId","ertcUserId"), Arrays.asList("ASC","ASC","ASC")));
        final TableInfo _infoEKeys = new TableInfo("eKeys", _columnsEKeys, _foreignKeysEKeys, _indicesEKeys);
        final TableInfo _existingEKeys = TableInfo.read(_db, "eKeys");
        if (! _infoEKeys.equals(_existingEKeys)) {
          return new RoomOpenHelper.ValidationResult(false, "eKeys(com.ripbull.ertc.cache.database.entity.EKeyTable).\n"
                  + " Expected:\n" + _infoEKeys + "\n"
                  + " Found:\n" + _existingEKeys);
        }
        final HashMap<String, TableInfo.Column> _columnsChatThread = new HashMap<String, TableInfo.Column>(36);
        _columnsChatThread.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("read", new TableInfo.Column("read", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("sender_id", new TableInfo.Column("sender_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("thread_id", new TableInfo.Column("thread_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("next_msg_id", new TableInfo.Column("next_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("last_msg_id", new TableInfo.Column("last_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("msg_type", new TableInfo.Column("msg_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("msg_unique_id", new TableInfo.Column("msg_unique_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("media_path", new TableInfo.Column("media_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("media_thumbnail", new TableInfo.Column("media_thumbnail", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("media_name", new TableInfo.Column("media_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("local_media_path", new TableInfo.Column("local_media_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("download_status", new TableInfo.Column("download_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("contact_name", new TableInfo.Column("contact_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("phone_contact_list", new TableInfo.Column("phone_contact_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("email_contact_list", new TableInfo.Column("email_contact_list", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("isStarredChat", new TableInfo.Column("isStarredChat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("gif_path", new TableInfo.Column("gif_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("send_to_channel", new TableInfo.Column("send_to_channel", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("delete_type", new TableInfo.Column("delete_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("parent_msg_id", new TableInfo.Column("parent_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("update_type", new TableInfo.Column("update_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("client_created_at", new TableInfo.Column("client_created_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("custom_data", new TableInfo.Column("custom_data", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("chat_report_id", new TableInfo.Column("chat_report_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("report_type", new TableInfo.Column("report_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("reason", new TableInfo.Column("reason", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("mentions", new TableInfo.Column("mentions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("mentioned_users", new TableInfo.Column("mentioned_users", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatThread.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatThread = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysChatThread.add(new TableInfo.ForeignKey("single_chat", "CASCADE", "NO ACTION",Arrays.asList("parent_msg_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChatThread = new HashSet<TableInfo.Index>(2);
        _indicesChatThread.add(new TableInfo.Index("index_chat_thread_id_parent_msg_id", true, Arrays.asList("id","parent_msg_id"), Arrays.asList("ASC","ASC")));
        _indicesChatThread.add(new TableInfo.Index("index_chat_thread_msg_unique_id_thread_id", true, Arrays.asList("msg_unique_id","thread_id"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoChatThread = new TableInfo("chat_thread", _columnsChatThread, _foreignKeysChatThread, _indicesChatThread);
        final TableInfo _existingChatThread = TableInfo.read(_db, "chat_thread");
        if (! _infoChatThread.equals(_existingChatThread)) {
          return new RoomOpenHelper.ValidationResult(false, "chat_thread(com.ripbull.ertc.cache.database.entity.ChatThread).\n"
                  + " Expected:\n" + _infoChatThread + "\n"
                  + " Found:\n" + _existingChatThread);
        }
        final HashMap<String, TableInfo.Column> _columnsDownload = new HashMap<String, TableInfo.Column>(9);
        _columnsDownload.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("url", new TableInfo.Column("url", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("etag", new TableInfo.Column("etag", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("dir_path", new TableInfo.Column("dir_path", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("file_name", new TableInfo.Column("file_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("msg_id", new TableInfo.Column("msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("total_bytes", new TableInfo.Column("total_bytes", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("downloaded_bytes", new TableInfo.Column("downloaded_bytes", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDownload.put("last_modified_at", new TableInfo.Column("last_modified_at", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDownload = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDownload = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDownload = new TableInfo("download", _columnsDownload, _foreignKeysDownload, _indicesDownload);
        final TableInfo _existingDownload = TableInfo.read(_db, "download");
        if (! _infoDownload.equals(_existingDownload)) {
          return new RoomOpenHelper.ValidationResult(false, "download(com.ripbull.ertc.cache.database.entity.DownloadMedia).\n"
                  + " Expected:\n" + _infoDownload + "\n"
                  + " Found:\n" + _existingDownload);
        }
        final HashMap<String, TableInfo.Column> _columnsChatReaction = new HashMap<String, TableInfo.Column>(7);
        _columnsChatReaction.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatReaction.put("unicode", new TableInfo.Column("unicode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatReaction.put("thread_id", new TableInfo.Column("thread_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatReaction.put("user_chat_id", new TableInfo.Column("user_chat_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatReaction.put("chat_msg_id", new TableInfo.Column("chat_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatReaction.put("chat_thread_msg_id", new TableInfo.Column("chat_thread_msg_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChatReaction.put("total_count", new TableInfo.Column("total_count", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChatReaction = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysChatReaction.add(new TableInfo.ForeignKey("single_chat", "CASCADE", "NO ACTION",Arrays.asList("chat_msg_id"), Arrays.asList("id")));
        _foreignKeysChatReaction.add(new TableInfo.ForeignKey("chat_thread", "CASCADE", "NO ACTION",Arrays.asList("chat_thread_msg_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesChatReaction = new HashSet<TableInfo.Index>(3);
        _indicesChatReaction.add(new TableInfo.Index("index_chat_reaction_id_chat_msg_id_chat_thread_msg_id", true, Arrays.asList("id","chat_msg_id","chat_thread_msg_id"), Arrays.asList("ASC","ASC","ASC")));
        _indicesChatReaction.add(new TableInfo.Index("index_chat_reaction_chat_msg_id_unicode_user_chat_id", true, Arrays.asList("chat_msg_id","unicode","user_chat_id"), Arrays.asList("ASC","ASC","ASC")));
        _indicesChatReaction.add(new TableInfo.Index("index_chat_reaction_chat_thread_msg_id_unicode_user_chat_id", true, Arrays.asList("chat_thread_msg_id","unicode","user_chat_id"), Arrays.asList("ASC","ASC","ASC")));
        final TableInfo _infoChatReaction = new TableInfo("chat_reaction", _columnsChatReaction, _foreignKeysChatReaction, _indicesChatReaction);
        final TableInfo _existingChatReaction = TableInfo.read(_db, "chat_reaction");
        if (! _infoChatReaction.equals(_existingChatReaction)) {
          return new RoomOpenHelper.ValidationResult(false, "chat_reaction(com.ripbull.ertc.cache.database.entity.ChatReactionEntity).\n"
                  + " Expected:\n" + _infoChatReaction + "\n"
                  + " Found:\n" + _existingChatReaction);
        }
        final HashMap<String, TableInfo.Column> _columnsDomainFilter = new HashMap<String, TableInfo.Column>(3);
        _columnsDomainFilter.put("domain", new TableInfo.Column("domain", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDomainFilter.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDomainFilter.put("action_type", new TableInfo.Column("action_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDomainFilter = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysDomainFilter.add(new TableInfo.ForeignKey("tenant", "CASCADE", "NO ACTION",Arrays.asList("tenant_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesDomainFilter = new HashSet<TableInfo.Index>(1);
        _indicesDomainFilter.add(new TableInfo.Index("index_domain_filter_tenant_id", false, Arrays.asList("tenant_id"), Arrays.asList("ASC")));
        final TableInfo _infoDomainFilter = new TableInfo("domain_filter", _columnsDomainFilter, _foreignKeysDomainFilter, _indicesDomainFilter);
        final TableInfo _existingDomainFilter = TableInfo.read(_db, "domain_filter");
        if (! _infoDomainFilter.equals(_existingDomainFilter)) {
          return new RoomOpenHelper.ValidationResult(false, "domain_filter(com.ripbull.ertc.cache.database.entity.DomainFilter).\n"
                  + " Expected:\n" + _infoDomainFilter + "\n"
                  + " Found:\n" + _existingDomainFilter);
        }
        final HashMap<String, TableInfo.Column> _columnsProfanityFilter = new HashMap<String, TableInfo.Column>(4);
        _columnsProfanityFilter.put("keyword", new TableInfo.Column("keyword", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfanityFilter.put("tenant_id", new TableInfo.Column("tenant_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfanityFilter.put("regex", new TableInfo.Column("regex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProfanityFilter.put("action_type", new TableInfo.Column("action_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProfanityFilter = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysProfanityFilter.add(new TableInfo.ForeignKey("tenant", "CASCADE", "NO ACTION",Arrays.asList("tenant_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesProfanityFilter = new HashSet<TableInfo.Index>(1);
        _indicesProfanityFilter.add(new TableInfo.Index("index_profanity_filter_tenant_id", false, Arrays.asList("tenant_id"), Arrays.asList("ASC")));
        final TableInfo _infoProfanityFilter = new TableInfo("profanity_filter", _columnsProfanityFilter, _foreignKeysProfanityFilter, _indicesProfanityFilter);
        final TableInfo _existingProfanityFilter = TableInfo.read(_db, "profanity_filter");
        if (! _infoProfanityFilter.equals(_existingProfanityFilter)) {
          return new RoomOpenHelper.ValidationResult(false, "profanity_filter(com.ripbull.ertc.cache.database.entity.ProfanityFilter).\n"
                  + " Expected:\n" + _infoProfanityFilter + "\n"
                  + " Found:\n" + _existingProfanityFilter);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "0e929f9d6c4d583d1cac2d241b898dc6", "2a2afe2df563e2c88a2173f6e5b12cbb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "single_chat","single_chat_meta_data","tenant","tenant_config","user","group","group_metadata","user_metadata","thread","thread_user_link","thread_meta_data","eKeys","chat_thread","download","chat_reaction","domain_filter","profanity_filter");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `single_chat`");
      _db.execSQL("DELETE FROM `single_chat_meta_data`");
      _db.execSQL("DELETE FROM `tenant`");
      _db.execSQL("DELETE FROM `tenant_config`");
      _db.execSQL("DELETE FROM `user`");
      _db.execSQL("DELETE FROM `group`");
      _db.execSQL("DELETE FROM `group_metadata`");
      _db.execSQL("DELETE FROM `user_metadata`");
      _db.execSQL("DELETE FROM `thread`");
      _db.execSQL("DELETE FROM `thread_user_link`");
      _db.execSQL("DELETE FROM `thread_meta_data`");
      _db.execSQL("DELETE FROM `eKeys`");
      _db.execSQL("DELETE FROM `chat_thread`");
      _db.execSQL("DELETE FROM `download`");
      _db.execSQL("DELETE FROM `chat_reaction`");
      _db.execSQL("DELETE FROM `domain_filter`");
      _db.execSQL("DELETE FROM `profanity_filter`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SingleChatDao.class, SingleChatDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChatThreadDao.class, ChatThreadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TenantDao.class, TenantDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ThreadDao.class, ThreadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ThreadUserLinkDao.class, ThreadUserLinkDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GroupDao.class, GroupDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EKeyDao.class, EKeyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DownloadMediaDao.class, DownloadMediaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChatReactionDao.class, ChatReactionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DomainFilterDao.class, DomainFilterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProfanityFilterDao.class, ProfanityFilterDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public SingleChatDao messageDao() {
    if (_singleChatDao != null) {
      return _singleChatDao;
    } else {
      synchronized(this) {
        if(_singleChatDao == null) {
          _singleChatDao = new SingleChatDao_Impl(this);
        }
        return _singleChatDao;
      }
    }
  }

  @Override
  public ChatThreadDao chatThreadDao() {
    if (_chatThreadDao != null) {
      return _chatThreadDao;
    } else {
      synchronized(this) {
        if(_chatThreadDao == null) {
          _chatThreadDao = new ChatThreadDao_Impl(this);
        }
        return _chatThreadDao;
      }
    }
  }

  @Override
  public TenantDao tenantDao() {
    if (_tenantDao != null) {
      return _tenantDao;
    } else {
      synchronized(this) {
        if(_tenantDao == null) {
          _tenantDao = new TenantDao_Impl(this);
        }
        return _tenantDao;
      }
    }
  }

  @Override
  public ThreadDao threadDao() {
    if (_threadDao != null) {
      return _threadDao;
    } else {
      synchronized(this) {
        if(_threadDao == null) {
          _threadDao = new ThreadDao_Impl(this);
        }
        return _threadDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ThreadUserLinkDao userLinkDao() {
    if (_threadUserLinkDao != null) {
      return _threadUserLinkDao;
    } else {
      synchronized(this) {
        if(_threadUserLinkDao == null) {
          _threadUserLinkDao = new ThreadUserLinkDao_Impl(this);
        }
        return _threadUserLinkDao;
      }
    }
  }

  @Override
  public GroupDao groupDao() {
    if (_groupDao != null) {
      return _groupDao;
    } else {
      synchronized(this) {
        if(_groupDao == null) {
          _groupDao = new GroupDao_Impl(this);
        }
        return _groupDao;
      }
    }
  }

  @Override
  public EKeyDao eKeyDao() {
    if (_eKeyDao != null) {
      return _eKeyDao;
    } else {
      synchronized(this) {
        if(_eKeyDao == null) {
          _eKeyDao = new EKeyDao_Impl(this);
        }
        return _eKeyDao;
      }
    }
  }

  @Override
  public DownloadMediaDao downloadMediaDao() {
    if (_downloadMediaDao != null) {
      return _downloadMediaDao;
    } else {
      synchronized(this) {
        if(_downloadMediaDao == null) {
          _downloadMediaDao = new DownloadMediaDao_Impl(this);
        }
        return _downloadMediaDao;
      }
    }
  }

  @Override
  public ChatReactionDao chatReactionDao() {
    if (_chatReactionDao != null) {
      return _chatReactionDao;
    } else {
      synchronized(this) {
        if(_chatReactionDao == null) {
          _chatReactionDao = new ChatReactionDao_Impl(this);
        }
        return _chatReactionDao;
      }
    }
  }

  @Override
  public DomainFilterDao domainFilterDao() {
    if (_domainFilterDao != null) {
      return _domainFilterDao;
    } else {
      synchronized(this) {
        if(_domainFilterDao == null) {
          _domainFilterDao = new DomainFilterDao_Impl(this);
        }
        return _domainFilterDao;
      }
    }
  }

  @Override
  public ProfanityFilterDao profanityFilterDao() {
    if (_profanityFilterDao != null) {
      return _profanityFilterDao;
    } else {
      synchronized(this) {
        if(_profanityFilterDao == null) {
          _profanityFilterDao = new ProfanityFilterDao_Impl(this);
        }
        return _profanityFilterDao;
      }
    }
  }
}
