package com.example.a00327927.animationproject;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by chemin on 2018/2/24 16:22.
 * description：
 */

public class Circleview extends View {

    private static final long ANIMATOR_DURATION = 3 * 1000;
    private Paint mPaint;
    private Point currentPoint;
    private float radius=50;


    public Circleview(Context context) {
        this(context,null);
    }

    public Circleview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Circleview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (currentPoint==null){//说明是第一次绘制
            currentPoint=new Point(radius+10,radius);

            Point startPoint=new Point(radius+10,radius);
            Point endPoint=new Point(radius+10,800);


            canvas.drawCircle(currentPoint.getCenterX(),currentPoint.getCenterY(),radius,mPaint);

            ValueAnimator valueAnimator=ValueAnimator.ofObject(new PointEvaluator(),startPoint,endPoint);
            valueAnimator.setDuration(ANIMATOR_DURATION);
            valueAnimator.setInterpolator(new BounceInterpolator());

            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    currentPoint= (Point) animation.getAnimatedValue();
                    invalidate();
                }
            });



            valueAnimator.start();

        }else {
            canvas.drawCircle(currentPoint.getCenterX(),currentPoint.getCenterY(),radius,mPaint);
        }


    }
}
