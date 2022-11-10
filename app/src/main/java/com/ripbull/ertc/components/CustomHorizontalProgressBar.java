package com.ripbull.ertc.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.ripbull.coresdk.R;

public class CustomHorizontalProgressBar  extends View {
  // distance between neighbour dot centres
  private int mDotStep = 40;

  // actual dot radius
  private int mDotRadius = 5;

  // Bounced Dot Radius
  private int mBigDotRadius = 5;

  // to get identified in which position dot has to bounce
  private int mDotPosition;

  // specify how many dots you need in a progressbar
  private static final int MIN_COUNT = 1;
  private static final int DEF_COUNT = 10;
  private static final int MAX_COUNT = 100;
  private int mDotCount = DEF_COUNT;

  private static final int MIN_TIMEOUT = 100;
  private static final int DEF_TIMEOUT = 500;
  private static final int MAX_TIMEOUT = 3000;
  private int mTimeout = DEF_TIMEOUT;

  private boolean isAnimateStarted = false;
  private Canvas canvas;
  private int mDotColor = Color.parseColor("#2B3D4F");
  private int mDotColorInActive = Color.parseColor("#CECECE");

  public CustomHorizontalProgressBar(Context context) {
    super(context);
    initDotSize();
  }

  public CustomHorizontalProgressBar(Context context, AttributeSet attrs) {
    super(context, attrs);
    initDotSize();
    applyAttrs(context, attrs);
  }

  public CustomHorizontalProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initDotSize();
    applyAttrs(context, attrs);
  }

  private void initDotSize() {
    final float scale = getResources().getDisplayMetrics().density;
    mDotStep = (int)(mDotStep * scale);
    mDotRadius = (int)(mDotRadius * scale);
    mBigDotRadius = (int)(mBigDotRadius * scale);
  }

  private void applyAttrs(Context context, AttributeSet attrs) {
    TypedArray a = context.getTheme().obtainStyledAttributes(
        attrs, com.ripbull.ertc.R.styleable.ToolDotProgress, 0, 0);

    try {
      mDotCount = a.getInteger(com.ripbull.ertc.R.styleable.ToolDotProgress_count, mDotCount);
      mDotCount = Math.min(Math.max(mDotCount, MIN_COUNT), MAX_COUNT);
      mTimeout = a.getInteger(com.ripbull.ertc.R.styleable.ToolDotProgress_timeout, mTimeout);
      mTimeout = Math.min(Math.max(mTimeout, MIN_TIMEOUT), MAX_TIMEOUT);
    } finally {
      a.recycle();
    }
  }

  //Method to draw your customized dot on the canvas
  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    this.canvas = canvas;
    if (isShown()) {
      Paint paintactive = new Paint();
      Paint paintInactive = new Paint();
      paintactive.setColor(mDotColor);
      paintInactive.setColor(mDotColorInActive);
      createDots(canvas, paintactive,paintInactive);
    }
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();

  }

  private void createDots(Canvas canvas, Paint paint,Paint inActivePaint) {
    for (int i = 0; i < mDotCount; i++ ) {
      int radius = (i == mDotPosition) ? mBigDotRadius : mDotRadius;
      Paint paintDot = (isAnimateStarted && ( i == mDotPosition || i == mDotPosition+1)) ? paint : inActivePaint;
      canvas.drawCircle(mDotStep / 2 + (i * mDotStep), mBigDotRadius, radius, paintDot);
    }
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    // MUST CALL THIS
    setMeasuredDimension(mDotStep * mDotCount, mBigDotRadius * 2);
  }

  public void startAnimation() {
    isAnimateStarted = true;
    BounceAnimation bounceAnimation = new BounceAnimation();
    bounceAnimation.setDuration(mTimeout);
    bounceAnimation.setRepeatCount(Animation.INFINITE);
    bounceAnimation.setInterpolator(new LinearInterpolator());
    bounceAnimation.setAnimationListener(new Animation.AnimationListener() {
      @Override
      public void onAnimationStart(Animation animation) {
      }

      @Override
      public void onAnimationEnd(Animation animation) {
      }

      @Override
      public void onAnimationRepeat(Animation animation) {
        if (++mDotPosition >= mDotCount) {
          mDotPosition = 0;
        }
      }
    });
    startAnimation(bounceAnimation);
  }


  private class BounceAnimation extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
      super.applyTransformation(interpolatedTime, t);
      // call invalidate to redraw your view again
      invalidate();
    }
  }

  public void removeAnimation(){
    isAnimateStarted = false;
    if (isShown() && canvas!=null) {
      Paint paintactive = new Paint();
      Paint paintInactive = new Paint();
      paintactive.setColor(mDotColor);
      paintInactive.setColor(mDotColorInActive);
      createDots(canvas, paintactive,paintInactive);
    }
    clearAnimation();
    invalidate();
  }
}