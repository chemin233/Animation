package com.example.a00327927.animationproject;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnTween= (Button) findViewById(R.id.btn_tween);
        btnTween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TweenAnimation.class));
            }
        });

        Button btnAnimation= (Button) findViewById(R.id.btn_animator);
        btnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AnimatorActivity.class));
            }
        });

        Button btnChoice= (Button) findViewById(R.id.btn_choiceview);
        btnChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ChoiceViewActivity.class));
            }
        });
    }
}
