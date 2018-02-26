package com.example.a00327927.animationproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChoiceViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_view);

        ChoiceView choiceView= (ChoiceView) findViewById(R.id.choiceView);

    }
}
