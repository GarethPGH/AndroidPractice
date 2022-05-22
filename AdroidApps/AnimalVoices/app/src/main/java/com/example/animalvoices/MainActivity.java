package com.example.animalvoices;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int playing = 0;
    Button btnCows, btnPigs;
    MediaPlayer cowControl, pigControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnCows = (Button)findViewById(R.id.cowbtn);
        btnPigs = (Button)findViewById(R.id.pigbtn);
        btnCows.setOnClickListener(cowListener);
        btnPigs.setOnClickListener(pigListener);

        cowControl = new MediaPlayer();
        pigControl = new MediaPlayer();

        cowControl = MediaPlayer.create(this, R.raw.cows);
        pigControl = MediaPlayer.create(this, R.raw.pigs);
        playing = 0;
    }
    Button.OnClickListener cowListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (playing){
                case 0:
                    playing = 1;
                    cowControl.start();
                    btnCows.setText(R.string.cowspause);
                    btnPigs.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    playing = 0;
                    cowControl.pause();
                    btnCows.setText(R.string.cows);
                    btnPigs.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener pigListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            switch (playing){
                case 0:
                    playing = 1;
                    pigControl.start();
                    btnPigs.setText(R.string.pigspause);
                    btnCows.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    playing = 0;
                    pigControl.pause();
                    btnPigs.setText(R.string.pigs);
                    btnCows.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}