package com.example.a00327927.animationproject;

import android.animation.AnimatorInflater;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TweenAnimation extends AppCompatActivity {

    private TextView tvRotate;
    private final static String TAG="TweenAnimation";
    private long DURATION_TIME=2*1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.rg_container);
        tvRotate = (TextView) findViewById(R.id.tv_rotate);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Log.e(TAG,"checkedId==="+checkedId);
                switch (checkedId){
                    case R.id.rb_alpha:
                        AlphaAnimation alphaAnimation=new AlphaAnimation(1f,0.2f);
                        alphaAnimation.setDuration(DURATION_TIME);
                        tvRotate.startAnimation(alphaAnimation);
                        break;
                    case R.id.rb_rotate:
                        Log.e(TAG,"rotate");
                        RotateAnimation rotateAnimation=new RotateAnimation(0,120, Animation.RELATIVE_TO_SELF,0.8f,Animation.RELATIVE_TO_SELF,0.8f);
                        rotateAnimation.setDuration(2*DURATION_TIME);
//                        rotateAnimation.setRepeatCount(2);
                        tvRotate.startAnimation(rotateAnimation);
                        break;
                    case R.id.rb_scale:
                        ScaleAnimation scaleAnimation=new ScaleAnimation(1f,0.5f,1f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                        scaleAnimation.setDuration(DURATION_TIME);
                        tvRotate.startAnimation(scaleAnimation);
                        break;
                    case R.id.rb_translate:
//                        TranslateAnimation translateAnimation=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.ABSOLUTE,0,Animation.RELATIVE_TO_SELF,20);
//                        translateAnimation.setDuration(DURATION_TIME);
//                        translateAnimation.setRepeatCount(-1);
                        Animation translateAnimation =AnimationUtils.loadAnimation(TweenAnimation.this,R.anim.view_animation);
                        tvRotate.startAnimation(translateAnimation);


                        break;
                    case R.id.rb_set:
                        AnimationSet animationSet=new AnimationSet(true);
                        animationSet.addAnimation(new AlphaAnimation(1f,0.2f));
                        animationSet.addAnimation(new RotateAnimation(0,120, Animation.RELATIVE_TO_SELF,0.8f,Animation.RELATIVE_TO_SELF,0.8f));
                        animationSet.addAnimation(new ScaleAnimation(1f,0.5f,1f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f));
                        animationSet.addAnimation(new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.ABSOLUTE,0,Animation.ABSOLUTE,100));
                        animationSet.setDuration(2*DURATION_TIME);
                        animationSet.setRepeatCount(-1);
                        tvRotate.startAnimation(animationSet);
                        break;
                }
            }
        });





    }
}
