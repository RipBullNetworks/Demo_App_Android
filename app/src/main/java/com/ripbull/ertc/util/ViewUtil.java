package com.ripbull.ertc.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.ripbull.coresdk.chat.mapper.MessageRecord;
import com.ripbull.coresdk.chat.model.Message;
import com.ripbull.coresdk.core.type.DeleteType;
import com.ripbull.ertc.R;

import java.util.ArrayList;

/**
 * Created by DK on 28/01/19.
 */
public class ViewUtil {
  public static int dpToPx(Context context, int dp) {
    return (int)((dp * context.getResources().getDisplayMetrics().density) + 0.5);
  }

  @SuppressLint("RtlHardcoded")
  public static void setTextViewGravityStart(final @NonNull
      TextView textView, @NonNull Context context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      Configuration configuration = context.getResources().getConfiguration();
      if (configuration.getLayoutDirection()== View.LAYOUT_DIRECTION_RTL) {
        textView.setGravity(Gravity.RIGHT);
      } else {
        textView.setGravity(Gravity.LEFT);
      }
    }
  }

  @SuppressWarnings("unchecked")
  public static <T extends View> T findById(@NonNull View parent, @IdRes int resId) {
    return (T) parent.findViewById(resId);
  }

  public static void setGlobalLayoutListener(@NonNull NestedScrollView scrollView, @NonNull View parentView, @NonNull View scrollToChildView) {

    parentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        try {
          Rect r = new Rect();
          parentView.getWindowVisibleDisplayFrame(r);
          float screenHeight = parentView.getRootView().getHeight();

          // r.bottom is the position above soft keypad or device button.
          // if keypad is shown, the r.bottom is smaller than that before.
          float keypadHeight = screenHeight - r.bottom;

          if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
            // keyboard is opened
            scrollView.post(new Runnable() {
              public void run() {
                scrollView.scrollTo(0, scrollToChildView.getBottom());
              }
            });
          } else {
            // keyboard is closed
          }
        } catch (Exception exp) {

        }
      }
    });
  }

  /**
   * This method is using to show delete Message Dialog
   *
   * @param activity activity reference to show dialog
   * @param clickHandler clickListener class subclass reference
   */
  public static void deleteMessageDialog(int position,Activity activity, DeleteMessageDialogClickListener clickHandler,
                                         ArrayList<Message> messageRecords,String threadId, boolean isIncoming) {
    Dialog builder = new Dialog(activity);
    builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
    builder.setContentView(R.layout.dialog_delete_message);
    AppCompatButton btnDelete = (AppCompatButton) builder.findViewById(R.id.btnDelete);
    AppCompatButton btnCancel = (AppCompatButton) builder.findViewById(R.id.btnCancel);
    AppCompatTextView deleteMsg = (AppCompatTextView) builder.findViewById(R.id.tvAlert);
    AppCompatRadioButton rbEveryone = (AppCompatRadioButton) builder.findViewById(R.id.rbEveryone);
    AppCompatRadioButton rbUser = (AppCompatRadioButton) builder.findViewById(R.id.rbUser);
    LinearLayout llDelete = (LinearLayout) builder.findViewById(R.id.llDelete);
    deleteMsg.setVisibility(isIncoming? View.VISIBLE : View.GONE);
    llDelete.setVisibility(isIncoming? View.GONE : View.VISIBLE);

    rbEveryone.setOnClickListener(v -> {
      rbEveryone.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.selected, 0);
      rbUser.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.unchecked, 0);
      rbEveryone.setChecked(true);
      rbUser.setChecked(false);
    });

    rbUser.setOnClickListener(v -> {
      rbEveryone.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.unchecked, 0);
      rbUser.setCompoundDrawablesWithIntrinsicBounds( 0, 0, R.drawable.selected, 0);
      rbEveryone.setChecked(false);
      rbUser.setChecked(true);
    });

    btnDelete.setOnClickListener(v -> {
      builder.dismiss();
      if (!isIncoming){
        clickHandler.onDelete(messageRecords,threadId, (rbEveryone.isChecked()) ? DeleteType.DELETE_FOR_EVERYONE.getType():
            DeleteType.DELETE_FOR_USER.getType(), position);
      }else {
        clickHandler.onDelete(messageRecords,threadId, DeleteType.DELETE_FOR_USER.getType(), position);
      }
    });

    btnCancel.setOnClickListener(v -> {
      builder.dismiss();
    });
    builder.show();
  }

  public interface DeleteMessageDialogClickListener {
    void onDelete(ArrayList<Message> messageRecords, String threadId, String deleteType,int position);
  }
}
