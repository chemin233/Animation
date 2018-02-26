package com.example.a00327927.animationproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;


/**
 * Created by chemin on 2018/2/26 14:30.
 * description：
 */

public class ChoiceView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;

    private float currentPercent;
    private Bitmap mBitmap;
    private RectF dst;
    private int radius=200;

    private boolean isChecked;

    private ValueAnimator animator;

    public ChoiceView(Context context) {
        this(context,null);
    }

    public ChoiceView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ChoiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GREEN);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width=MeasureSpec.getSize(widthMeasureSpec);

        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int height=MeasureSpec.getSize(heightMeasureSpec);
        switch (widthMode){
            case MeasureSpec.AT_MOST:
                width=400;
                break;
        }
        switch (heightMode){
            case MeasureSpec.AT_MOST:
                height=400;
                break;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dst==null){

            canvas.drawCircle(radius,radius,radius,mPaint);

            //开始画勾
            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.choice);
            Rect src=new Rect((int)(currentPercent* mBitmap.getWidth()),0,(int)(currentPercent* mBitmap.getHeight()),0);
            dst = new RectF(0,0,2*radius,2*radius);
            canvas.drawBitmap(mBitmap,src, dst,mPaint);

            animator = ValueAnimator.ofFloat(0,10);
            animator.setDuration(1*1000);
            //设置插值器
            animator.setInterpolator(new AccelerateInterpolator());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float percent= (Float) (animation.getAnimatedValue())/10;
                    if (isChecked){
                        currentPercent= percent;
                    }else {
                        currentPercent=1-percent;
                    }
                    invalidate();
                }
            });

            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation, boolean isReverse) {
                    if (!isChecked){
                        mBitmap.recycle();
                    }
                }
            });
        }else {
            canvas.drawCircle(radius,radius,radius,mPaint);
            Rect   src=new Rect(0,0,(int)(currentPercent* mBitmap.getWidth()),(int)(currentPercent* mBitmap.getHeight()));
            dst = new RectF(0,0,2*radius*currentPercent,2*radius*currentPercent);
            canvas.drawBitmap(mBitmap,src, dst,mPaint);
        }
    }

    public void setChecked(){
            isChecked=true;
            currentPercent=0;
            if (animator!=null){
                animator.start();
            }


    }

    public void unChecked(){
            isChecked=false;
            currentPercent=0;
            if (animator!=null){
                animator.start();
            }

    }

    public boolean isChecked(){
        return isChecked;
    }

    public void setChecked(boolean isChecked){
        if (animator.isRunning()){
            Log.e("cm","animator.isRunning---");
            return;
        }
        this.isChecked=isChecked;
        if (isChecked){
            setChecked();
        }else {
            unChecked();
        }
    }

    public void setBackgound(int color){
        mPaint.setColor(color);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                setChecked(!isChecked());
                break;
        }
        return true;
    }
}
