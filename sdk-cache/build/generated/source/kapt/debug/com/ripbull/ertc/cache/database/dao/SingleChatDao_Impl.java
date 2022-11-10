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
import com.ripbull.ertc.cache.database.entity.ChatReactionEntity;
import com.ripbull.ertc.cache.database.entity.ChatThread;
import com.ripbull.ertc.cache.database.entity.EmailContact;
import com.ripbull.ertc.cache.database.entity.Location;
import com.ripbull.ertc.cache.database.entity.PhoneContact;
import com.ripbull.ertc.cache.database.entity.SingleChat;
import com.ripbull.ertc.cache.database.entity.SingleChatEmbedded;
import io.reactivex.Observable;
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
public final class SingleChatDao_Impl implements SingleChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SingleChat> __insertionAdapterOfSingleChat;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<SingleChat> __insertionAdapterOfSingleChat_1;

  private final EntityInsertionAdapter<SingleChat> __insertionAdapterOfSingleChat_2;

  private final EntityInsertionAdapter<SingleChat> __insertionAdapterOfSingleChat_3;

  private final EntityInsertionAdapter<SingleChat> __insertionAdapterOfSingleChat_4;

  private final EntityDeletionOrUpdateAdapter<SingleChat> __deletionAdapterOfSingleChat;

  private final EntityDeletionOrUpdateAdapter<SingleChat> __updateAdapterOfSingleChat;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByThreadId;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByMsgId;

  private final SharedSQLiteStatement __preparedStmtOfSetStatus;

  private final SharedSQLiteStatement __preparedStmtOfSetFollowThread;

  public SingleChatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSingleChat = new EntityInsertionAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `single_chat` (`id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`media_name`,`local_media_path`,`download_status`,`send_to_channel`,`parent_msg_id`,`parent_msg`,`event_type`,`delete_type`,`forward_msg_unique_id`,`is_forward_message`,`update_type`,`client_created_at`,`custom_data`,`is_followed`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCreatedAt());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getRead() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRead());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getSenderAppUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderAppUserId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThreadId());
        }
        if (value.getNextMessageId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNextMessageId());
        }
        if (value.getLastMessageId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLastMessageId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMsgType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMsgType());
        }
        if (value.getMsgUniqueId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgUniqueId());
        }
        if (value.getMediaPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMediaPath());
        }
        if (value.getMediaThumbnail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMediaThumbnail());
        }
        if (value.getContactName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getContactName());
        }
        final String _tmp = __converters.phoneContactListToJson(value.getPhoneContactList());
        if (_tmp == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp);
        }
        final String _tmp_1 = __converters.emailContactListToJson(value.getEmailContactList());
        if (_tmp_1 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_1);
        }
        if (value.isStarredChat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.isStarredChat());
        }
        if (value.getGifPath() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getGifPath());
        }
        if (value.getMediaName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMediaName());
        }
        if (value.getLocalMediaPath() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLocalMediaPath());
        }
        if (value.getDownloadStatus() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDownloadStatus());
        }
        if (value.getSendToChannel() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getSendToChannel());
        }
        if (value.getParentMsgId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getParentMsgId());
        }
        if (value.getParentMsg() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getParentMsg());
        }
        if (value.getChatEventType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getChatEventType());
        }
        if (value.getDeleteType() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDeleteType());
        }
        if (value.getForwardMsgUniqueId() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getForwardMsgUniqueId());
        }
        if (value.isForwardMessage() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindLong(29, value.isForwardMessage());
        }
        if (value.getUpdateType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getUpdateType());
        }
        if (value.getClientCreatedAt() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClientCreatedAt());
        }
        if (value.getCustomData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCustomData());
        }
        if (value.isFollowed() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindLong(33, value.isFollowed());
        }
        if (value.getChatReportId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getChatReportId());
        }
        if (value.getReportType() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getReportType());
        }
        if (value.getReason() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getReason());
        }
        if (value.getMentions() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getMentions());
        }
        if (value.getMentionedUsers() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getMentionedUsers());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          if (_tmpLocation.getAddress() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLocation.getAddress());
          }
          if (_tmpLocation.getLatitude() == null) {
            stmt.bindNull(40);
          } else {
            stmt.bindDouble(40, _tmpLocation.getLatitude());
          }
          if (_tmpLocation.getLongitude() == null) {
            stmt.bindNull(41);
          } else {
            stmt.bindDouble(41, _tmpLocation.getLongitude());
          }
        } else {
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
        }
      }
    };
    this.__insertionAdapterOfSingleChat_1 = new EntityInsertionAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `single_chat` (`id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`media_name`,`local_media_path`,`download_status`,`send_to_channel`,`parent_msg_id`,`parent_msg`,`event_type`,`delete_type`,`forward_msg_unique_id`,`is_forward_message`,`update_type`,`client_created_at`,`custom_data`,`is_followed`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCreatedAt());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getRead() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRead());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getSenderAppUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderAppUserId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThreadId());
        }
        if (value.getNextMessageId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNextMessageId());
        }
        if (value.getLastMessageId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLastMessageId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMsgType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMsgType());
        }
        if (value.getMsgUniqueId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgUniqueId());
        }
        if (value.getMediaPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMediaPath());
        }
        if (value.getMediaThumbnail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMediaThumbnail());
        }
        if (value.getContactName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getContactName());
        }
        final String _tmp = __converters.phoneContactListToJson(value.getPhoneContactList());
        if (_tmp == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp);
        }
        final String _tmp_1 = __converters.emailContactListToJson(value.getEmailContactList());
        if (_tmp_1 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_1);
        }
        if (value.isStarredChat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.isStarredChat());
        }
        if (value.getGifPath() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getGifPath());
        }
        if (value.getMediaName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMediaName());
        }
        if (value.getLocalMediaPath() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLocalMediaPath());
        }
        if (value.getDownloadStatus() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDownloadStatus());
        }
        if (value.getSendToChannel() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getSendToChannel());
        }
        if (value.getParentMsgId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getParentMsgId());
        }
        if (value.getParentMsg() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getParentMsg());
        }
        if (value.getChatEventType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getChatEventType());
        }
        if (value.getDeleteType() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDeleteType());
        }
        if (value.getForwardMsgUniqueId() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getForwardMsgUniqueId());
        }
        if (value.isForwardMessage() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindLong(29, value.isForwardMessage());
        }
        if (value.getUpdateType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getUpdateType());
        }
        if (value.getClientCreatedAt() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClientCreatedAt());
        }
        if (value.getCustomData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCustomData());
        }
        if (value.isFollowed() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindLong(33, value.isFollowed());
        }
        if (value.getChatReportId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getChatReportId());
        }
        if (value.getReportType() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getReportType());
        }
        if (value.getReason() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getReason());
        }
        if (value.getMentions() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getMentions());
        }
        if (value.getMentionedUsers() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getMentionedUsers());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          if (_tmpLocation.getAddress() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLocation.getAddress());
          }
          if (_tmpLocation.getLatitude() == null) {
            stmt.bindNull(40);
          } else {
            stmt.bindDouble(40, _tmpLocation.getLatitude());
          }
          if (_tmpLocation.getLongitude() == null) {
            stmt.bindNull(41);
          } else {
            stmt.bindDouble(41, _tmpLocation.getLongitude());
          }
        } else {
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
        }
      }
    };
    this.__insertionAdapterOfSingleChat_2 = new EntityInsertionAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `single_chat` (`id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`media_name`,`local_media_path`,`download_status`,`send_to_channel`,`parent_msg_id`,`parent_msg`,`event_type`,`delete_type`,`forward_msg_unique_id`,`is_forward_message`,`update_type`,`client_created_at`,`custom_data`,`is_followed`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCreatedAt());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getRead() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRead());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getSenderAppUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderAppUserId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThreadId());
        }
        if (value.getNextMessageId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNextMessageId());
        }
        if (value.getLastMessageId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLastMessageId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMsgType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMsgType());
        }
        if (value.getMsgUniqueId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgUniqueId());
        }
        if (value.getMediaPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMediaPath());
        }
        if (value.getMediaThumbnail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMediaThumbnail());
        }
        if (value.getContactName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getContactName());
        }
        final String _tmp = __converters.phoneContactListToJson(value.getPhoneContactList());
        if (_tmp == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp);
        }
        final String _tmp_1 = __converters.emailContactListToJson(value.getEmailContactList());
        if (_tmp_1 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_1);
        }
        if (value.isStarredChat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.isStarredChat());
        }
        if (value.getGifPath() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getGifPath());
        }
        if (value.getMediaName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMediaName());
        }
        if (value.getLocalMediaPath() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLocalMediaPath());
        }
        if (value.getDownloadStatus() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDownloadStatus());
        }
        if (value.getSendToChannel() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getSendToChannel());
        }
        if (value.getParentMsgId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getParentMsgId());
        }
        if (value.getParentMsg() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getParentMsg());
        }
        if (value.getChatEventType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getChatEventType());
        }
        if (value.getDeleteType() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDeleteType());
        }
        if (value.getForwardMsgUniqueId() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getForwardMsgUniqueId());
        }
        if (value.isForwardMessage() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindLong(29, value.isForwardMessage());
        }
        if (value.getUpdateType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getUpdateType());
        }
        if (value.getClientCreatedAt() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClientCreatedAt());
        }
        if (value.getCustomData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCustomData());
        }
        if (value.isFollowed() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindLong(33, value.isFollowed());
        }
        if (value.getChatReportId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getChatReportId());
        }
        if (value.getReportType() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getReportType());
        }
        if (value.getReason() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getReason());
        }
        if (value.getMentions() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getMentions());
        }
        if (value.getMentionedUsers() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getMentionedUsers());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          if (_tmpLocation.getAddress() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLocation.getAddress());
          }
          if (_tmpLocation.getLatitude() == null) {
            stmt.bindNull(40);
          } else {
            stmt.bindDouble(40, _tmpLocation.getLatitude());
          }
          if (_tmpLocation.getLongitude() == null) {
            stmt.bindNull(41);
          } else {
            stmt.bindDouble(41, _tmpLocation.getLongitude());
          }
        } else {
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
        }
      }
    };
    this.__insertionAdapterOfSingleChat_3 = new EntityInsertionAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `single_chat` (`id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`media_name`,`local_media_path`,`download_status`,`send_to_channel`,`parent_msg_id`,`parent_msg`,`event_type`,`delete_type`,`forward_msg_unique_id`,`is_forward_message`,`update_type`,`client_created_at`,`custom_data`,`is_followed`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCreatedAt());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getRead() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRead());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getSenderAppUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderAppUserId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThreadId());
        }
        if (value.getNextMessageId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNextMessageId());
        }
        if (value.getLastMessageId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLastMessageId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMsgType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMsgType());
        }
        if (value.getMsgUniqueId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgUniqueId());
        }
        if (value.getMediaPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMediaPath());
        }
        if (value.getMediaThumbnail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMediaThumbnail());
        }
        if (value.getContactName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getContactName());
        }
        final String _tmp = __converters.phoneContactListToJson(value.getPhoneContactList());
        if (_tmp == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp);
        }
        final String _tmp_1 = __converters.emailContactListToJson(value.getEmailContactList());
        if (_tmp_1 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_1);
        }
        if (value.isStarredChat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.isStarredChat());
        }
        if (value.getGifPath() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getGifPath());
        }
        if (value.getMediaName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMediaName());
        }
        if (value.getLocalMediaPath() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLocalMediaPath());
        }
        if (value.getDownloadStatus() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDownloadStatus());
        }
        if (value.getSendToChannel() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getSendToChannel());
        }
        if (value.getParentMsgId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getParentMsgId());
        }
        if (value.getParentMsg() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getParentMsg());
        }
        if (value.getChatEventType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getChatEventType());
        }
        if (value.getDeleteType() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDeleteType());
        }
        if (value.getForwardMsgUniqueId() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getForwardMsgUniqueId());
        }
        if (value.isForwardMessage() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindLong(29, value.isForwardMessage());
        }
        if (value.getUpdateType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getUpdateType());
        }
        if (value.getClientCreatedAt() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClientCreatedAt());
        }
        if (value.getCustomData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCustomData());
        }
        if (value.isFollowed() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindLong(33, value.isFollowed());
        }
        if (value.getChatReportId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getChatReportId());
        }
        if (value.getReportType() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getReportType());
        }
        if (value.getReason() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getReason());
        }
        if (value.getMentions() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getMentions());
        }
        if (value.getMentionedUsers() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getMentionedUsers());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          if (_tmpLocation.getAddress() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLocation.getAddress());
          }
          if (_tmpLocation.getLatitude() == null) {
            stmt.bindNull(40);
          } else {
            stmt.bindDouble(40, _tmpLocation.getLatitude());
          }
          if (_tmpLocation.getLongitude() == null) {
            stmt.bindNull(41);
          } else {
            stmt.bindDouble(41, _tmpLocation.getLongitude());
          }
        } else {
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
        }
      }
    };
    this.__insertionAdapterOfSingleChat_4 = new EntityInsertionAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `single_chat` (`id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`media_name`,`local_media_path`,`download_status`,`send_to_channel`,`parent_msg_id`,`parent_msg`,`event_type`,`delete_type`,`forward_msg_unique_id`,`is_forward_message`,`update_type`,`client_created_at`,`custom_data`,`is_followed`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCreatedAt());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getRead() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRead());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getSenderAppUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderAppUserId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThreadId());
        }
        if (value.getNextMessageId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNextMessageId());
        }
        if (value.getLastMessageId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLastMessageId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMsgType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMsgType());
        }
        if (value.getMsgUniqueId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgUniqueId());
        }
        if (value.getMediaPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMediaPath());
        }
        if (value.getMediaThumbnail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMediaThumbnail());
        }
        if (value.getContactName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getContactName());
        }
        final String _tmp = __converters.phoneContactListToJson(value.getPhoneContactList());
        if (_tmp == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp);
        }
        final String _tmp_1 = __converters.emailContactListToJson(value.getEmailContactList());
        if (_tmp_1 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_1);
        }
        if (value.isStarredChat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.isStarredChat());
        }
        if (value.getGifPath() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getGifPath());
        }
        if (value.getMediaName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMediaName());
        }
        if (value.getLocalMediaPath() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLocalMediaPath());
        }
        if (value.getDownloadStatus() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDownloadStatus());
        }
        if (value.getSendToChannel() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getSendToChannel());
        }
        if (value.getParentMsgId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getParentMsgId());
        }
        if (value.getParentMsg() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getParentMsg());
        }
        if (value.getChatEventType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getChatEventType());
        }
        if (value.getDeleteType() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDeleteType());
        }
        if (value.getForwardMsgUniqueId() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getForwardMsgUniqueId());
        }
        if (value.isForwardMessage() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindLong(29, value.isForwardMessage());
        }
        if (value.getUpdateType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getUpdateType());
        }
        if (value.getClientCreatedAt() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClientCreatedAt());
        }
        if (value.getCustomData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCustomData());
        }
        if (value.isFollowed() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindLong(33, value.isFollowed());
        }
        if (value.getChatReportId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getChatReportId());
        }
        if (value.getReportType() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getReportType());
        }
        if (value.getReason() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getReason());
        }
        if (value.getMentions() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getMentions());
        }
        if (value.getMentionedUsers() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getMentionedUsers());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          if (_tmpLocation.getAddress() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLocation.getAddress());
          }
          if (_tmpLocation.getLatitude() == null) {
            stmt.bindNull(40);
          } else {
            stmt.bindDouble(40, _tmpLocation.getLatitude());
          }
          if (_tmpLocation.getLongitude() == null) {
            stmt.bindNull(41);
          } else {
            stmt.bindDouble(41, _tmpLocation.getLongitude());
          }
        } else {
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
        }
      }
    };
    this.__deletionAdapterOfSingleChat = new EntityDeletionOrUpdateAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `single_chat` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfSingleChat = new EntityDeletionOrUpdateAdapter<SingleChat>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `single_chat` SET `id` = ?,`createdAt` = ?,`message` = ?,`read` = ?,`type` = ?,`sender_id` = ?,`thread_id` = ?,`next_msg_id` = ?,`last_msg_id` = ?,`status` = ?,`msg_type` = ?,`msg_unique_id` = ?,`media_path` = ?,`media_thumbnail` = ?,`contact_name` = ?,`phone_contact_list` = ?,`email_contact_list` = ?,`isStarredChat` = ?,`gif_path` = ?,`media_name` = ?,`local_media_path` = ?,`download_status` = ?,`send_to_channel` = ?,`parent_msg_id` = ?,`parent_msg` = ?,`event_type` = ?,`delete_type` = ?,`forward_msg_unique_id` = ?,`is_forward_message` = ?,`update_type` = ?,`client_created_at` = ?,`custom_data` = ?,`is_followed` = ?,`chat_report_id` = ?,`report_type` = ?,`reason` = ?,`mentions` = ?,`mentioned_users` = ?,`address` = ?,`latitude` = ?,`longitude` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SingleChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCreatedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getCreatedAt());
        }
        if (value.getMessage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessage());
        }
        if (value.getRead() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getRead());
        }
        if (value.getType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getType());
        }
        if (value.getSenderAppUserId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderAppUserId());
        }
        if (value.getThreadId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getThreadId());
        }
        if (value.getNextMessageId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getNextMessageId());
        }
        if (value.getLastMessageId() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLastMessageId());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStatus());
        }
        if (value.getMsgType() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getMsgType());
        }
        if (value.getMsgUniqueId() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgUniqueId());
        }
        if (value.getMediaPath() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMediaPath());
        }
        if (value.getMediaThumbnail() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMediaThumbnail());
        }
        if (value.getContactName() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getContactName());
        }
        final String _tmp = __converters.phoneContactListToJson(value.getPhoneContactList());
        if (_tmp == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp);
        }
        final String _tmp_1 = __converters.emailContactListToJson(value.getEmailContactList());
        if (_tmp_1 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, _tmp_1);
        }
        if (value.isStarredChat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.isStarredChat());
        }
        if (value.getGifPath() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getGifPath());
        }
        if (value.getMediaName() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getMediaName());
        }
        if (value.getLocalMediaPath() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getLocalMediaPath());
        }
        if (value.getDownloadStatus() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDownloadStatus());
        }
        if (value.getSendToChannel() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindLong(23, value.getSendToChannel());
        }
        if (value.getParentMsgId() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getParentMsgId());
        }
        if (value.getParentMsg() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getParentMsg());
        }
        if (value.getChatEventType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getChatEventType());
        }
        if (value.getDeleteType() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDeleteType());
        }
        if (value.getForwardMsgUniqueId() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getForwardMsgUniqueId());
        }
        if (value.isForwardMessage() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindLong(29, value.isForwardMessage());
        }
        if (value.getUpdateType() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getUpdateType());
        }
        if (value.getClientCreatedAt() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindLong(31, value.getClientCreatedAt());
        }
        if (value.getCustomData() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCustomData());
        }
        if (value.isFollowed() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindLong(33, value.isFollowed());
        }
        if (value.getChatReportId() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getChatReportId());
        }
        if (value.getReportType() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getReportType());
        }
        if (value.getReason() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getReason());
        }
        if (value.getMentions() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getMentions());
        }
        if (value.getMentionedUsers() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getMentionedUsers());
        }
        final Location _tmpLocation = value.getLocation();
        if(_tmpLocation != null) {
          if (_tmpLocation.getAddress() == null) {
            stmt.bindNull(39);
          } else {
            stmt.bindString(39, _tmpLocation.getAddress());
          }
          if (_tmpLocation.getLatitude() == null) {
            stmt.bindNull(40);
          } else {
            stmt.bindDouble(40, _tmpLocation.getLatitude());
          }
          if (_tmpLocation.getLongitude() == null) {
            stmt.bindNull(41);
          } else {
            stmt.bindDouble(41, _tmpLocation.getLongitude());
          }
        } else {
          stmt.bindNull(39);
          stmt.bindNull(40);
          stmt.bindNull(41);
        }
        if (value.getId() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM single_chat";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByThreadId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM single_chat WHERE thread_id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteByMsgId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM single_chat WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSetStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE single_chat SET status = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSetFollowThread = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE single_chat SET is_followed = ? WHERE msg_unique_id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<SingleChat> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithFail(final List<SingleChat> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_1.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_2.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithIgnore(final List<SingleChat> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_2.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_3.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final List<SingleChat> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_3.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_4.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithRollback(final List<SingleChat> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat_4.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithAbort(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSingleChat.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSingleChat.handle(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<SingleChat> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSingleChat.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final SingleChat t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSingleChat.handle(t);
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
  public void deleteByThreadId(final String threadId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByThreadId.acquire();
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
      __preparedStmtOfDeleteByThreadId.release(_stmt);
    }
  }

  @Override
  public void deleteByMsgId(final String msgId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByMsgId.acquire();
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
      __preparedStmtOfDeleteByMsgId.release(_stmt);
    }
  }

  @Override
  public void setStatus(final String status, final String id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetStatus.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    if (id == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, id);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetStatus.release(_stmt);
    }
  }

  @Override
  public void setFollowThread(final Integer followThread, final String msgUniqueId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetFollowThread.acquire();
    int _argIndex = 1;
    if (followThread == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, followThread);
    }
    _argIndex = 2;
    if (msgUniqueId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, msgUniqueId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetFollowThread.release(_stmt);
    }
  }

  @Override
  public SingleChat getChatByLocalMsgId(final String messageId, final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE id = ? AND thread_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (messageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageId);
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final SingleChat _result;
      if(_cursor.moveToFirst()) {
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
        _result = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public Single<SingleChat> getChatByClientIdByRxSingle(final String messageId,
      final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE id = ? AND thread_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (messageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageId);
    }
    _argIndex = 2;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createSingle(new Callable<SingleChat>() {
      @Override
      public SingleChat call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final SingleChat _result;
          if(_cursor.moveToFirst()) {
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
            _result = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public SingleChat getChatByServerMsgId(final String msgId, final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE msg_unique_id = ? AND thread_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (msgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msgId);
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
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final SingleChat _result;
      if(_cursor.moveToFirst()) {
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
        _result = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public Single<List<SingleChatEmbedded>> getAll(final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE thread_id = ? ORDER BY createdAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createSingle(new Callable<List<SingleChatEmbedded>>() {
      @Override
      public List<SingleChatEmbedded> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final HashMap<String, ArrayList<ChatThread>> _collectionListChatThread = new HashMap<String, ArrayList<ChatThread>>();
          final HashMap<String, ArrayList<ChatReactionEntity>> _collectionReactionEntities = new HashMap<String, ArrayList<ChatReactionEntity>>();
          while (_cursor.moveToNext()) {
            if (!_cursor.isNull(_cursorIndexOfId)) {
              final String _tmpKey = _cursor.getString(_cursorIndexOfId);
              ArrayList<ChatThread> _tmpListChatThreadCollection = _collectionListChatThread.get(_tmpKey);
              if (_tmpListChatThreadCollection == null) {
                _tmpListChatThreadCollection = new ArrayList<ChatThread>();
                _collectionListChatThread.put(_tmpKey, _tmpListChatThreadCollection);
              }
            }
            if (!_cursor.isNull(_cursorIndexOfId)) {
              final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              ArrayList<ChatReactionEntity> _tmpReactionEntitiesCollection = _collectionReactionEntities.get(_tmpKey_1);
              if (_tmpReactionEntitiesCollection == null) {
                _tmpReactionEntitiesCollection = new ArrayList<ChatReactionEntity>();
                _collectionReactionEntities.put(_tmpKey_1, _tmpReactionEntitiesCollection);
              }
            }
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshipchatThreadAscomRipbullErtcCacheDatabaseEntityChatThread(_collectionListChatThread);
          __fetchRelationshipchatReactionAscomRipbullErtcCacheDatabaseEntityChatReactionEntity(_collectionReactionEntities);
          final List<SingleChatEmbedded> _result = new ArrayList<SingleChatEmbedded>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleChatEmbedded _item;
            final SingleChat _tmpSingleChat;
            if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfMessage) && _cursor.isNull(_cursorIndexOfRead) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSenderAppUserId) && _cursor.isNull(_cursorIndexOfThreadId) && _cursor.isNull(_cursorIndexOfNextMessageId) && _cursor.isNull(_cursorIndexOfLastMessageId) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfMsgType) && _cursor.isNull(_cursorIndexOfMsgUniqueId) && _cursor.isNull(_cursorIndexOfMediaPath) && _cursor.isNull(_cursorIndexOfMediaThumbnail) && _cursor.isNull(_cursorIndexOfContactName) && _cursor.isNull(_cursorIndexOfPhoneContactList) && _cursor.isNull(_cursorIndexOfEmailContactList) && _cursor.isNull(_cursorIndexOfIsStarredChat) && _cursor.isNull(_cursorIndexOfGifPath) && _cursor.isNull(_cursorIndexOfMediaName) && _cursor.isNull(_cursorIndexOfLocalMediaPath) && _cursor.isNull(_cursorIndexOfDownloadStatus) && _cursor.isNull(_cursorIndexOfSendToChannel) && _cursor.isNull(_cursorIndexOfParentMsgId) && _cursor.isNull(_cursorIndexOfParentMsg) && _cursor.isNull(_cursorIndexOfChatEventType) && _cursor.isNull(_cursorIndexOfDeleteType) && _cursor.isNull(_cursorIndexOfForwardMsgUniqueId) && _cursor.isNull(_cursorIndexOfIsForwardMessage) && _cursor.isNull(_cursorIndexOfUpdateType) && _cursor.isNull(_cursorIndexOfClientCreatedAt) && _cursor.isNull(_cursorIndexOfCustomData) && _cursor.isNull(_cursorIndexOfIsFollowed) && _cursor.isNull(_cursorIndexOfChatReportId) && _cursor.isNull(_cursorIndexOfReportType) && _cursor.isNull(_cursorIndexOfReason) && _cursor.isNull(_cursorIndexOfMentions) && _cursor.isNull(_cursorIndexOfMentionedUsers) && _cursor.isNull(_cursorIndexOfAddress) && _cursor.isNull(_cursorIndexOfLatitude) && _cursor.isNull(_cursorIndexOfLongitude))) {
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
              _tmpSingleChat = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
            }  else  {
              _tmpSingleChat = null;
            }
            ArrayList<ChatThread> _tmpListChatThreadCollection_1 = null;
            if (!_cursor.isNull(_cursorIndexOfId)) {
              final String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
              _tmpListChatThreadCollection_1 = _collectionListChatThread.get(_tmpKey_2);
            }
            if (_tmpListChatThreadCollection_1 == null) {
              _tmpListChatThreadCollection_1 = new ArrayList<ChatThread>();
            }
            ArrayList<ChatReactionEntity> _tmpReactionEntitiesCollection_1 = null;
            if (!_cursor.isNull(_cursorIndexOfId)) {
              final String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
              _tmpReactionEntitiesCollection_1 = _collectionReactionEntities.get(_tmpKey_3);
            }
            if (_tmpReactionEntitiesCollection_1 == null) {
              _tmpReactionEntitiesCollection_1 = new ArrayList<ChatReactionEntity>();
            }
            _item = new SingleChatEmbedded();
            _item.setSingleChat(_tmpSingleChat);
            _item.setListChatThread(_tmpListChatThreadCollection_1);
            _item.setReactionEntities(_tmpReactionEntitiesCollection_1);
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
  public List<SingleChat> getDeliveredMessages(final String threadId, final String status,
      final String appUserId) {
    final String _sql = "SELECT * FROM single_chat WHERE thread_id = ? AND status = ? AND sender_id != ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 3;
    if (appUserId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, appUserId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SingleChat _item;
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
        _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SingleChat> hasMessage(final String threadId, final String messageId,
      final String status) {
    final String _sql = "SELECT * FROM single_chat WHERE thread_id = (?) AND  msg_unique_id = ? AND status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    _argIndex = 2;
    if (messageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageId);
    }
    _argIndex = 3;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SingleChat _item;
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
        _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SingleChat> hasMessage(final String msgId) {
    final String _sql = "SELECT * FROM single_chat WHERE id = ?";
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
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SingleChat _item;
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
        _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Single<List<SingleChat>> hasThreadMessage(final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE thread_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createSingle(new Callable<List<SingleChat>>() {
      @Override
      public List<SingleChat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleChat _item;
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
            _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public List<SingleChat> getSendingMessages(final String status, final List<String> msgType) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM single_chat WHERE status = ");
    _stringBuilder.append("?");
    _stringBuilder.append(" AND msg_type IN (");
    final int _inputSize = msgType.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 1 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    _argIndex = 2;
    for (String _item : msgType) {
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
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
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
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Observable<List<SingleChat>> getFavoriteMessages(final String isStarred,
      final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE isStarredChat = ? AND thread_id = ? ORDER BY createdAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (isStarred == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, isStarred);
    }
    _argIndex = 2;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    return RxRoom.createObservable(__db, false, new String[]{"single_chat"}, new Callable<List<SingleChat>>() {
      @Override
      public List<SingleChat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleChat _item;
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
            _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public Observable<List<SingleChat>> getAllFavoriteMessages(final String isStarred) {
    final String _sql = "SELECT * FROM single_chat WHERE isStarredChat = ? ORDER BY createdAt ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (isStarred == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, isStarred);
    }
    return RxRoom.createObservable(__db, false, new String[]{"single_chat"}, new Callable<List<SingleChat>>() {
      @Override
      public List<SingleChat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleChat _item;
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
            _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public Single<SingleChat> getChatByMsgId(final String messageId) {
    final String _sql = "SELECT * FROM single_chat WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (messageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageId);
    }
    return RxRoom.createSingle(new Callable<SingleChat>() {
      @Override
      public SingleChat call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final SingleChat _result;
          if(_cursor.moveToFirst()) {
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
            _result = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public SingleChatEmbedded getSingleChatByServerMsgId(final String msgId, final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE msg_unique_id = ? AND thread_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (msgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msgId);
    }
    _argIndex = 2;
    if (threadId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, threadId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final HashMap<String, ArrayList<ChatThread>> _collectionListChatThread = new HashMap<String, ArrayList<ChatThread>>();
      final HashMap<String, ArrayList<ChatReactionEntity>> _collectionReactionEntities = new HashMap<String, ArrayList<ChatReactionEntity>>();
      while (_cursor.moveToNext()) {
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey = _cursor.getString(_cursorIndexOfId);
          ArrayList<ChatThread> _tmpListChatThreadCollection = _collectionListChatThread.get(_tmpKey);
          if (_tmpListChatThreadCollection == null) {
            _tmpListChatThreadCollection = new ArrayList<ChatThread>();
            _collectionListChatThread.put(_tmpKey, _tmpListChatThreadCollection);
          }
        }
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
          ArrayList<ChatReactionEntity> _tmpReactionEntitiesCollection = _collectionReactionEntities.get(_tmpKey_1);
          if (_tmpReactionEntitiesCollection == null) {
            _tmpReactionEntitiesCollection = new ArrayList<ChatReactionEntity>();
            _collectionReactionEntities.put(_tmpKey_1, _tmpReactionEntitiesCollection);
          }
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipchatThreadAscomRipbullErtcCacheDatabaseEntityChatThread(_collectionListChatThread);
      __fetchRelationshipchatReactionAscomRipbullErtcCacheDatabaseEntityChatReactionEntity(_collectionReactionEntities);
      final SingleChatEmbedded _result;
      if(_cursor.moveToFirst()) {
        final SingleChat _tmpSingleChat;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfMessage) && _cursor.isNull(_cursorIndexOfRead) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSenderAppUserId) && _cursor.isNull(_cursorIndexOfThreadId) && _cursor.isNull(_cursorIndexOfNextMessageId) && _cursor.isNull(_cursorIndexOfLastMessageId) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfMsgType) && _cursor.isNull(_cursorIndexOfMsgUniqueId) && _cursor.isNull(_cursorIndexOfMediaPath) && _cursor.isNull(_cursorIndexOfMediaThumbnail) && _cursor.isNull(_cursorIndexOfContactName) && _cursor.isNull(_cursorIndexOfPhoneContactList) && _cursor.isNull(_cursorIndexOfEmailContactList) && _cursor.isNull(_cursorIndexOfIsStarredChat) && _cursor.isNull(_cursorIndexOfGifPath) && _cursor.isNull(_cursorIndexOfMediaName) && _cursor.isNull(_cursorIndexOfLocalMediaPath) && _cursor.isNull(_cursorIndexOfDownloadStatus) && _cursor.isNull(_cursorIndexOfSendToChannel) && _cursor.isNull(_cursorIndexOfParentMsgId) && _cursor.isNull(_cursorIndexOfParentMsg) && _cursor.isNull(_cursorIndexOfChatEventType) && _cursor.isNull(_cursorIndexOfDeleteType) && _cursor.isNull(_cursorIndexOfForwardMsgUniqueId) && _cursor.isNull(_cursorIndexOfIsForwardMessage) && _cursor.isNull(_cursorIndexOfUpdateType) && _cursor.isNull(_cursorIndexOfClientCreatedAt) && _cursor.isNull(_cursorIndexOfCustomData) && _cursor.isNull(_cursorIndexOfIsFollowed) && _cursor.isNull(_cursorIndexOfChatReportId) && _cursor.isNull(_cursorIndexOfReportType) && _cursor.isNull(_cursorIndexOfReason) && _cursor.isNull(_cursorIndexOfMentions) && _cursor.isNull(_cursorIndexOfMentionedUsers) && _cursor.isNull(_cursorIndexOfAddress) && _cursor.isNull(_cursorIndexOfLatitude) && _cursor.isNull(_cursorIndexOfLongitude))) {
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
          _tmpSingleChat = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
        }  else  {
          _tmpSingleChat = null;
        }
        ArrayList<ChatThread> _tmpListChatThreadCollection_1 = null;
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
          _tmpListChatThreadCollection_1 = _collectionListChatThread.get(_tmpKey_2);
        }
        if (_tmpListChatThreadCollection_1 == null) {
          _tmpListChatThreadCollection_1 = new ArrayList<ChatThread>();
        }
        ArrayList<ChatReactionEntity> _tmpReactionEntitiesCollection_1 = null;
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
          _tmpReactionEntitiesCollection_1 = _collectionReactionEntities.get(_tmpKey_3);
        }
        if (_tmpReactionEntitiesCollection_1 == null) {
          _tmpReactionEntitiesCollection_1 = new ArrayList<ChatReactionEntity>();
        }
        _result = new SingleChatEmbedded();
        _result.setSingleChat(_tmpSingleChat);
        _result.setListChatThread(_tmpListChatThreadCollection_1);
        _result.setReactionEntities(_tmpReactionEntitiesCollection_1);
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
  public SingleChatEmbedded getSingleChatByMsgId(final String msgId) {
    final String _sql = "SELECT * FROM single_chat WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (msgId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, msgId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final HashMap<String, ArrayList<ChatThread>> _collectionListChatThread = new HashMap<String, ArrayList<ChatThread>>();
      final HashMap<String, ArrayList<ChatReactionEntity>> _collectionReactionEntities = new HashMap<String, ArrayList<ChatReactionEntity>>();
      while (_cursor.moveToNext()) {
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey = _cursor.getString(_cursorIndexOfId);
          ArrayList<ChatThread> _tmpListChatThreadCollection = _collectionListChatThread.get(_tmpKey);
          if (_tmpListChatThreadCollection == null) {
            _tmpListChatThreadCollection = new ArrayList<ChatThread>();
            _collectionListChatThread.put(_tmpKey, _tmpListChatThreadCollection);
          }
        }
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
          ArrayList<ChatReactionEntity> _tmpReactionEntitiesCollection = _collectionReactionEntities.get(_tmpKey_1);
          if (_tmpReactionEntitiesCollection == null) {
            _tmpReactionEntitiesCollection = new ArrayList<ChatReactionEntity>();
            _collectionReactionEntities.put(_tmpKey_1, _tmpReactionEntitiesCollection);
          }
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshipchatThreadAscomRipbullErtcCacheDatabaseEntityChatThread(_collectionListChatThread);
      __fetchRelationshipchatReactionAscomRipbullErtcCacheDatabaseEntityChatReactionEntity(_collectionReactionEntities);
      final SingleChatEmbedded _result;
      if(_cursor.moveToFirst()) {
        final SingleChat _tmpSingleChat;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfCreatedAt) && _cursor.isNull(_cursorIndexOfMessage) && _cursor.isNull(_cursorIndexOfRead) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfSenderAppUserId) && _cursor.isNull(_cursorIndexOfThreadId) && _cursor.isNull(_cursorIndexOfNextMessageId) && _cursor.isNull(_cursorIndexOfLastMessageId) && _cursor.isNull(_cursorIndexOfStatus) && _cursor.isNull(_cursorIndexOfMsgType) && _cursor.isNull(_cursorIndexOfMsgUniqueId) && _cursor.isNull(_cursorIndexOfMediaPath) && _cursor.isNull(_cursorIndexOfMediaThumbnail) && _cursor.isNull(_cursorIndexOfContactName) && _cursor.isNull(_cursorIndexOfPhoneContactList) && _cursor.isNull(_cursorIndexOfEmailContactList) && _cursor.isNull(_cursorIndexOfIsStarredChat) && _cursor.isNull(_cursorIndexOfGifPath) && _cursor.isNull(_cursorIndexOfMediaName) && _cursor.isNull(_cursorIndexOfLocalMediaPath) && _cursor.isNull(_cursorIndexOfDownloadStatus) && _cursor.isNull(_cursorIndexOfSendToChannel) && _cursor.isNull(_cursorIndexOfParentMsgId) && _cursor.isNull(_cursorIndexOfParentMsg) && _cursor.isNull(_cursorIndexOfChatEventType) && _cursor.isNull(_cursorIndexOfDeleteType) && _cursor.isNull(_cursorIndexOfForwardMsgUniqueId) && _cursor.isNull(_cursorIndexOfIsForwardMessage) && _cursor.isNull(_cursorIndexOfUpdateType) && _cursor.isNull(_cursorIndexOfClientCreatedAt) && _cursor.isNull(_cursorIndexOfCustomData) && _cursor.isNull(_cursorIndexOfIsFollowed) && _cursor.isNull(_cursorIndexOfChatReportId) && _cursor.isNull(_cursorIndexOfReportType) && _cursor.isNull(_cursorIndexOfReason) && _cursor.isNull(_cursorIndexOfMentions) && _cursor.isNull(_cursorIndexOfMentionedUsers) && _cursor.isNull(_cursorIndexOfAddress) && _cursor.isNull(_cursorIndexOfLatitude) && _cursor.isNull(_cursorIndexOfLongitude))) {
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
          _tmpSingleChat = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
        }  else  {
          _tmpSingleChat = null;
        }
        ArrayList<ChatThread> _tmpListChatThreadCollection_1 = null;
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
          _tmpListChatThreadCollection_1 = _collectionListChatThread.get(_tmpKey_2);
        }
        if (_tmpListChatThreadCollection_1 == null) {
          _tmpListChatThreadCollection_1 = new ArrayList<ChatThread>();
        }
        ArrayList<ChatReactionEntity> _tmpReactionEntitiesCollection_1 = null;
        if (!_cursor.isNull(_cursorIndexOfId)) {
          final String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
          _tmpReactionEntitiesCollection_1 = _collectionReactionEntities.get(_tmpKey_3);
        }
        if (_tmpReactionEntitiesCollection_1 == null) {
          _tmpReactionEntitiesCollection_1 = new ArrayList<ChatReactionEntity>();
        }
        _result = new SingleChatEmbedded();
        _result.setSingleChat(_tmpSingleChat);
        _result.setListChatThread(_tmpListChatThreadCollection_1);
        _result.setReactionEntities(_tmpReactionEntitiesCollection_1);
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
  public String getLastGroupEventMessage(final String chatEventType, final String threadId) {
    final String _sql = "SELECT message FROM single_chat WHERE event_type = ? AND thread_id = ? ORDER BY createdAt DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (chatEventType == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatEventType);
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
  public Single<List<SingleChat>> getChatByMsgIdCount(final String messageId) {
    final String _sql = "SELECT * FROM single_chat WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (messageId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageId);
    }
    return RxRoom.createSingle(new Callable<List<SingleChat>>() {
      @Override
      public List<SingleChat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleChat _item;
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
            _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public Single<List<SingleChat>> searchedMessageList(final String searchedText) {
    final String _sql = "SELECT * FROM single_chat WHERE message LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (searchedText == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchedText);
    }
    return RxRoom.createSingle(new Callable<List<SingleChat>>() {
      @Override
      public List<SingleChat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
          final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
          final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
          final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
          final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
          final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
          final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
          final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
          final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
          final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
          final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
          final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
          final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
          final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
          final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
          final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
          final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
          final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
          final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
          final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
          final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
          final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
          final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
          final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
          final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
          final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
          final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
          final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
          final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<SingleChat> _result = new ArrayList<SingleChat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final SingleChat _item;
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
            _item = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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
  public SingleChat getLastMessage(final String threadId) {
    final String _sql = "SELECT * FROM single_chat WHERE thread_id = ? ORDER BY createdAt DESC LIMIT 1";
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
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
      final int _cursorIndexOfRead = CursorUtil.getColumnIndexOrThrow(_cursor, "read");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfSenderAppUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "sender_id");
      final int _cursorIndexOfThreadId = CursorUtil.getColumnIndexOrThrow(_cursor, "thread_id");
      final int _cursorIndexOfNextMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "next_msg_id");
      final int _cursorIndexOfLastMessageId = CursorUtil.getColumnIndexOrThrow(_cursor, "last_msg_id");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfMsgType = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_type");
      final int _cursorIndexOfMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "msg_unique_id");
      final int _cursorIndexOfMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "media_path");
      final int _cursorIndexOfMediaThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "media_thumbnail");
      final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
      final int _cursorIndexOfPhoneContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "phone_contact_list");
      final int _cursorIndexOfEmailContactList = CursorUtil.getColumnIndexOrThrow(_cursor, "email_contact_list");
      final int _cursorIndexOfIsStarredChat = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarredChat");
      final int _cursorIndexOfGifPath = CursorUtil.getColumnIndexOrThrow(_cursor, "gif_path");
      final int _cursorIndexOfMediaName = CursorUtil.getColumnIndexOrThrow(_cursor, "media_name");
      final int _cursorIndexOfLocalMediaPath = CursorUtil.getColumnIndexOrThrow(_cursor, "local_media_path");
      final int _cursorIndexOfDownloadStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "download_status");
      final int _cursorIndexOfSendToChannel = CursorUtil.getColumnIndexOrThrow(_cursor, "send_to_channel");
      final int _cursorIndexOfParentMsgId = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg_id");
      final int _cursorIndexOfParentMsg = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_msg");
      final int _cursorIndexOfChatEventType = CursorUtil.getColumnIndexOrThrow(_cursor, "event_type");
      final int _cursorIndexOfDeleteType = CursorUtil.getColumnIndexOrThrow(_cursor, "delete_type");
      final int _cursorIndexOfForwardMsgUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "forward_msg_unique_id");
      final int _cursorIndexOfIsForwardMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "is_forward_message");
      final int _cursorIndexOfUpdateType = CursorUtil.getColumnIndexOrThrow(_cursor, "update_type");
      final int _cursorIndexOfClientCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "client_created_at");
      final int _cursorIndexOfCustomData = CursorUtil.getColumnIndexOrThrow(_cursor, "custom_data");
      final int _cursorIndexOfIsFollowed = CursorUtil.getColumnIndexOrThrow(_cursor, "is_followed");
      final int _cursorIndexOfChatReportId = CursorUtil.getColumnIndexOrThrow(_cursor, "chat_report_id");
      final int _cursorIndexOfReportType = CursorUtil.getColumnIndexOrThrow(_cursor, "report_type");
      final int _cursorIndexOfReason = CursorUtil.getColumnIndexOrThrow(_cursor, "reason");
      final int _cursorIndexOfMentions = CursorUtil.getColumnIndexOrThrow(_cursor, "mentions");
      final int _cursorIndexOfMentionedUsers = CursorUtil.getColumnIndexOrThrow(_cursor, "mentioned_users");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final SingleChat _result;
      if(_cursor.moveToFirst()) {
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
        _result = new SingleChat(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpSendToChannel,_tmpParentMsgId,_tmpParentMsg,_tmpChatEventType,_tmpDeleteType,_tmpForwardMsgUniqueId,_tmpIsForwardMessage,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpIsFollowed,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
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

  private void __fetchRelationshipchatThreadAscomRipbullErtcCacheDatabaseEntityChatThread(
      final HashMap<String, ArrayList<ChatThread>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<ChatThread>> _tmpInnerMap = new HashMap<String, ArrayList<ChatThread>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipchatThreadAscomRipbullErtcCacheDatabaseEntityChatThread(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<ChatThread>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipchatThreadAscomRipbullErtcCacheDatabaseEntityChatThread(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`createdAt`,`message`,`read`,`type`,`sender_id`,`thread_id`,`next_msg_id`,`last_msg_id`,`status`,`msg_type`,`msg_unique_id`,`media_path`,`media_thumbnail`,`media_name`,`local_media_path`,`download_status`,`contact_name`,`phone_contact_list`,`email_contact_list`,`isStarredChat`,`gif_path`,`send_to_channel`,`delete_type`,`parent_msg_id`,`update_type`,`client_created_at`,`custom_data`,`chat_report_id`,`report_type`,`reason`,`mentions`,`mentioned_users`,`address`,`latitude`,`longitude` FROM `chat_thread` WHERE `parent_msg_id` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "parent_msg_id");
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
      final int _cursorIndexOfMediaName = 14;
      final int _cursorIndexOfLocalMediaPath = 15;
      final int _cursorIndexOfDownloadStatus = 16;
      final int _cursorIndexOfContactName = 17;
      final int _cursorIndexOfPhoneContactList = 18;
      final int _cursorIndexOfEmailContactList = 19;
      final int _cursorIndexOfIsStarredChat = 20;
      final int _cursorIndexOfGifPath = 21;
      final int _cursorIndexOfSendToChannel = 22;
      final int _cursorIndexOfDeleteType = 23;
      final int _cursorIndexOfParentMsgId = 24;
      final int _cursorIndexOfUpdateType = 25;
      final int _cursorIndexOfClientCreatedAt = 26;
      final int _cursorIndexOfCustomData = 27;
      final int _cursorIndexOfChatReportId = 28;
      final int _cursorIndexOfReportType = 29;
      final int _cursorIndexOfReason = 30;
      final int _cursorIndexOfMentions = 31;
      final int _cursorIndexOfMentionedUsers = 32;
      final int _cursorIndexOfAddress = 33;
      final int _cursorIndexOfLatitude = 34;
      final int _cursorIndexOfLongitude = 35;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<ChatThread> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final ChatThread _item_1;
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
            final Integer _tmpSendToChannel;
            if (_cursor.isNull(_cursorIndexOfSendToChannel)) {
              _tmpSendToChannel = null;
            } else {
              _tmpSendToChannel = _cursor.getInt(_cursorIndexOfSendToChannel);
            }
            final String _tmpDeleteType;
            if (_cursor.isNull(_cursorIndexOfDeleteType)) {
              _tmpDeleteType = null;
            } else {
              _tmpDeleteType = _cursor.getString(_cursorIndexOfDeleteType);
            }
            final String _tmpParentMsgId;
            if (_cursor.isNull(_cursorIndexOfParentMsgId)) {
              _tmpParentMsgId = null;
            } else {
              _tmpParentMsgId = _cursor.getString(_cursorIndexOfParentMsgId);
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
            _item_1 = new ChatThread(_tmpId,_tmpCreatedAt,_tmpMessage,_tmpRead,_tmpType,_tmpSenderAppUserId,_tmpThreadId,_tmpNextMessageId,_tmpLastMessageId,_tmpStatus,_tmpMsgType,_tmpMsgUniqueId,_tmpMediaPath,_tmpMediaThumbnail,_tmpMediaName,_tmpLocalMediaPath,_tmpDownloadStatus,_tmpContactName,_tmpPhoneContactList,_tmpEmailContactList,_tmpIsStarredChat,_tmpGifPath,_tmpLocation,_tmpSendToChannel,_tmpDeleteType,_tmpParentMsgId,_tmpUpdateType,_tmpClientCreatedAt,_tmpCustomData,_tmpChatReportId,_tmpReportType,_tmpReason,_tmpMentions,_tmpMentionedUsers);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshipchatReactionAscomRipbullErtcCacheDatabaseEntityChatReactionEntity(
      final HashMap<String, ArrayList<ChatReactionEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      HashMap<String, ArrayList<ChatReactionEntity>> _tmpInnerMap = new HashMap<String, ArrayList<ChatReactionEntity>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      for(String _mapKey : __mapKeySet) {
        _tmpInnerMap.put(_mapKey, _map.get(_mapKey));
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshipchatReactionAscomRipbullErtcCacheDatabaseEntityChatReactionEntity(_tmpInnerMap);
          _tmpInnerMap = new HashMap<String, ArrayList<ChatReactionEntity>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshipchatReactionAscomRipbullErtcCacheDatabaseEntityChatReactionEntity(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`unicode`,`thread_id`,`user_chat_id`,`chat_msg_id`,`chat_thread_msg_id`,`total_count` FROM `chat_reaction` WHERE `chat_msg_id` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "chat_msg_id");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfUnicode = 1;
      final int _cursorIndexOfThreadId = 2;
      final int _cursorIndexOfUserChatId = 3;
      final int _cursorIndexOfChatMsgId = 4;
      final int _cursorIndexOfChatThreadMsgId = 5;
      final int _cursorIndexOfTotalCount = 6;
      while(_cursor.moveToNext()) {
        if (!_cursor.isNull(_itemKeyIndex)) {
          final String _tmpKey = _cursor.getString(_itemKeyIndex);
          ArrayList<ChatReactionEntity> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final ChatReactionEntity _item_1;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpUnicode;
            if (_cursor.isNull(_cursorIndexOfUnicode)) {
              _tmpUnicode = null;
            } else {
              _tmpUnicode = _cursor.getString(_cursorIndexOfUnicode);
            }
            final String _tmpThreadId;
            if (_cursor.isNull(_cursorIndexOfThreadId)) {
              _tmpThreadId = null;
            } else {
              _tmpThreadId = _cursor.getString(_cursorIndexOfThreadId);
            }
            final String _tmpUserChatId;
            if (_cursor.isNull(_cursorIndexOfUserChatId)) {
              _tmpUserChatId = null;
            } else {
              _tmpUserChatId = _cursor.getString(_cursorIndexOfUserChatId);
            }
            final String _tmpChatMsgId;
            if (_cursor.isNull(_cursorIndexOfChatMsgId)) {
              _tmpChatMsgId = null;
            } else {
              _tmpChatMsgId = _cursor.getString(_cursorIndexOfChatMsgId);
            }
            final String _tmpChatThreadMsgId;
            if (_cursor.isNull(_cursorIndexOfChatThreadMsgId)) {
              _tmpChatThreadMsgId = null;
            } else {
              _tmpChatThreadMsgId = _cursor.getString(_cursorIndexOfChatThreadMsgId);
            }
            final Integer _tmpTotalCount;
            if (_cursor.isNull(_cursorIndexOfTotalCount)) {
              _tmpTotalCount = null;
            } else {
              _tmpTotalCount = _cursor.getInt(_cursorIndexOfTotalCount);
            }
            _item_1 = new ChatReactionEntity(_tmpId,_tmpUnicode,_tmpThreadId,_tmpUserChatId,_tmpChatMsgId,_tmpChatThreadMsgId,_tmpTotalCount);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
