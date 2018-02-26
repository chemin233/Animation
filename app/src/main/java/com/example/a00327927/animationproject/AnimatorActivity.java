package com.example.a00327927.animationproject;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AnimatorActivity extends AppCompatActivity {

    private ViewGroup.LayoutParams layoutParams;
    private ValueAnimator animator;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        button = (Button) findViewById(R.id.animator_btn);

        layoutParams = button.getLayoutParams();
        animator = ValueAnimator.ofInt(layoutParams.width,500);

        animator.setDuration(3*1000);
        animator.setRepeatCount(2);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int widthValue= (Integer) animation.getAnimatedValue();
                Log.e("cm","widthValue---"+widthValue);
                layoutParams.width=widthValue;
                button.requestLayout();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animator.start();

            }
        });
        




//        ValueAnimator.ofInt()
    }
}
