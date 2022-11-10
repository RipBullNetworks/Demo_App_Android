package com.ripbull.ertc.util;

import android.text.format.DateUtils;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that provides methods for dealing with timestamp objects
 */
public class TimestampUtil {

  /**
   * Returns the current timestamp
   *
   * @return current timestamp
   */
  public static Timestamp getCurrentTimestamp() {
    Date date = new Date();
    return new Timestamp(date.getTime());
  }

  public static String toDate(Long timestamp) {
    try {
      Date date = new Date(timestamp);
      return new SimpleDateFormat("hh:mm a").format(date).toUpperCase();
    } catch (Exception e) {
      return new SimpleDateFormat("hh:mm a").format(System.currentTimeMillis()).toUpperCase();
    }
  }

  public static String getCurrentTime() {
    try {
      Date date = new Date();
      return new SimpleDateFormat("hh:mm a").format(date);
    } catch (Exception e) {
      return new SimpleDateFormat("hh:mm a").format(System.currentTimeMillis());
    }
  }

  public static String convertTime(long time){
    Date date = new Date(time);
    Format format;
    if (DateUtils.isToday(time)){
      format = new SimpleDateFormat("hh:mm a");
    } else {
      format = new SimpleDateFormat("dd/MM/yyyy");
    }
    return format.format(date);
  }

  public static String getChatDate(long time){
    Date date = new Date(time);
    Format format;
    if (DateUtils.isToday(time)){
      return "Today";
    } else {
      format = new SimpleDateFormat("dd/MM/yyyy");
    }
    return format.format(date);
  }

  public static String getCreatedAt(long time){
    try {
      Date date = new Date(time);
      return new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(date).toUpperCase();
    } catch (Exception e) {
      return new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(System.currentTimeMillis()).toUpperCase();
    }
  }

  public static String getTimeDifference(long startTime, long endTime){
    try {
      long diffInMS = endTime - startTime;

      if (diffInMS <= 0) {
        return "";
      }

      long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMS);
      long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMS);
      long diffInMin = TimeUnit.MILLISECONDS.toMinutes(diffInMS);
      long diffInWeeks = diffInDays/7;

      String diff = "";
      if (diffInWeeks > 0) {
        diff = diffInWeeks + "w " + diffInDays%7 + "d remaining";
      } else if (diffInDays > 0) {
        diff = diffInDays + "d " + diffInHours%24 + "h remaining";
      } else if (diffInHours > 0) {
        diff = diffInHours + "h " + diffInMin%60 + "m remaining";
      } else if (diffInMin > 0) {
        diff = diffInDays + "m remaining";
      }

      return diff;
    } catch (Exception e) {
      return "";
    }
  }
}
