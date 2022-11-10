package com.ripbull.coreattachment.ui;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.N_MR1;

import android.content.ClipDescription;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import com.ripbull.coreattachment.R;

public class RichContentEditText extends AppCompatMultiAutoCompleteTextView {

  public RichContentEditText(Context context) {
    super(context);
  }

  public RichContentEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    setAttributes(context, attrs);
  }

  public RichContentEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    setAttributes(context, attrs);
  }

  private void setAttributes(Context context, AttributeSet attrs) {
    TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
        R.styleable.RichContentEditText, 0, 0);
    try {
      switch (a.getInteger(R.styleable.RichContentEditText_allowedMimeTypes, 0)) {
        case 1:
          allowImageInsertion();
          break;
        default:
          disallowRichContent();
          break;
      }
    } finally {
      a.recycle();
    }
  }

  /**
   * An interface that contains the onRichContent callback
   */
  public interface OnRichContentListener {
    /**
     * Called whenever rich content is received
     * NOTE: the listener is run on a background thread by default; see runListenerInBackground
     *
     * @param contentUri  the uri from the content provider
     * @param description the clip description associated with the uri
     */
    void onRichContent(Uri contentUri, ClipDescription description);
  }

  private OnRichContentListener onRichContentListener = null;
  private String[] mimeTypes = {};
  private static final String TAG = "GifEditText";
  /**
   * Determines whether the listener is run on a background thread or on the main thread
   * True (recommended): runs the listener on a background thread to improve performance
   * False (not advised): runs the listener on the main thread
   * NOTE: if this is true, ensure you update any necessary views on the main thread
   */
  public boolean runListenerInBackground = true;

  /**
   * Sets the listener that is called whenever rich content is received
   * NOTE: the listener is run on a background thread by default; see runListenerInBackground
   *
   * @param onRichContentListener the listener
   */
  public void setOnRichContentListener(OnRichContentListener onRichContentListener) {
    this.onRichContentListener = onRichContentListener;
  }

  /**
   * Sets the mime types to accept from a keyboard
   *
   * @param mimeTypes a string array of mime types
   */
  public void setContentMimeTypes(String[] mimeTypes) {
    if (mimeTypes != null) this.mimeTypes = mimeTypes;
  }

  /**
   * A convenience method for allowing image insertion from a keyboard
   * Sets the appropriate mime types to accept images
   */
  public void allowImageInsertion() {
    setContentMimeTypes(new String[]{"image/png", "image/gif", "image/jpeg"});
  }

  /**
   * A convenience method for disallowing rich content from a keyboard
   */
  public void disallowRichContent() {
    setContentMimeTypes(new String[]{"image/png", "image/gif", "image/jpeg"});
  }

  /**
   * @return the currently allowed mime types
   */
  public String[] getContentMimeTypes() {
    return mimeTypes;
  }

  @Override
  public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
    final InputConnection ic = super.onCreateInputConnection(editorInfo);
    EditorInfoCompat.setContentMimeTypes(editorInfo, getContentMimeTypes());
    return InputConnectionCompat.createWrapper(ic, editorInfo,
            (inputContentInfo, flags, opts) -> {
              if (SDK_INT >= N_MR1 && (flags & InputConnectionCompat
                  .INPUT_CONTENT_GRANT_READ_URI_PERMISSION) != 0) {
                try {
                  if (onRichContentListener != null) {
                    Runnable runnable = () -> {
                      inputContentInfo.requestPermission();
                      onRichContentListener.onRichContent(
                          inputContentInfo.getContentUri(),
                          inputContentInfo.getDescription());
                      inputContentInfo.releasePermission();
                    };
                    if (runListenerInBackground) new Thread(runnable).start();
                    else runnable.run();
                  }
                } catch (Exception e) {
                  e.printStackTrace();
                  return false;
                }
              }
              return true;
            });
  }
}