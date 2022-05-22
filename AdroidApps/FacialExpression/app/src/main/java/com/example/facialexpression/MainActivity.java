package com.example.facialexpression;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable faceAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView anim = (ImageView) findViewById(R.id.animation);
        anim.setBackgroundResource(R.drawable.animation);
        faceAnimation = (AnimationDrawable)anim.getBackground();

        Button btn = (Button)findViewById(R.id.buttn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                faceAnimation.start();
            }
        });
    }
}