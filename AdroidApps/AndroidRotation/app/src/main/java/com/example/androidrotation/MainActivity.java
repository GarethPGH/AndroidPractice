package com.example.androidrotation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageDecoder;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView tween = (ImageView)findViewById(R.id.tweenanim);
        tween.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
    }
}