package com.example.a00327927.animationproject;

import android.animation.TypeEvaluator;

/**
 * Created by chemin on 2018/2/24 16:34.
 * description：
 */

public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint= (Point) startValue;
        Point endPoint= (Point) endValue;
        float x=startPoint.getCenterX()+fraction*(endPoint.getCenterX()-startPoint.getCenterX());
        float y=startPoint.getCenterY()+fraction*(endPoint.getCenterY()-startPoint.getCenterY());
        return new Point(x,y);
    }
}
