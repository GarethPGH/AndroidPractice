package com.example.garrusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenActivity extends AppCompatActivity {
    AnimationSet anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);

        ImageView tween = (ImageView)findViewById(R.id.tweenanim);

        tween.startAnimation(AnimationUtils.loadAnimation(this, R.anim.gar_tween));
    }
}