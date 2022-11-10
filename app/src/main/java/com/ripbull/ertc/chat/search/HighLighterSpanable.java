package com.ripbull.ertc.chat.search;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.ripbull.ertc.R;

class HighLighterSpanable extends ReplacementSpan {

  private static int CORNER_RADIUS = 4;
  private int backgroundColor = 0;
  private int textColor = 0;

  public HighLighterSpanable(Context context) {
    super();
    backgroundColor = context.getResources().getColor(R.color.thread_stroke_color);
    textColor = context.getResources().getColor(R.color.chat_user_name_color);
  }

  @Override
  public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
    RectF rect = new RectF(x, top, x + measureText(paint, text, start, end), bottom);
    paint.setColor(backgroundColor);
    canvas.drawRoundRect(rect, CORNER_RADIUS, CORNER_RADIUS, paint);
    paint.setColor(textColor);
    canvas.drawText(text, start, end, x, y, paint);
  }

  @Override
  public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
    return Math.round(paint.measureText(text, start, end));
  }

  private float measureText(Paint paint, CharSequence text, int start, int end) {
    return paint.measureText(text, start, end);
  }
}
