package com.example.garrusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable charAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView animView = (ImageView)findViewById(R.id.slideshow);
        animView.setBackgroundResource(R.drawable.gar_frame);
        charAnimation = (AnimationDrawable)animView.getBackground();

        Button slideshowbtn = (Button) findViewById(R.id.slideshowbtn);
        Button tweenbtn = (Button) findViewById(R.id.tweenbtn);

        slideshowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                charAnimation.start();
            }
        });

        tweenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                charAnimation.stop();
                startActivity(new Intent(getApplicationContext(), TweenActivity.class));
            }
        });
    }
}