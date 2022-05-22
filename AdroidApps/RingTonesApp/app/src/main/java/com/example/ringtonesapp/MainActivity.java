package com.example.ringtonesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
MediaPlayer player1, player2, player3;
RadioButton ring1btn, ring2btn, ring3btn;
TextView text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ring1btn = (RadioButton) findViewById(R.id.radioButton);
        ring2btn = (RadioButton) findViewById(R.id.radioButton2);
        ring3btn = (RadioButton) findViewById(R.id.radioButton3);

        ring1btn.setOnClickListener(doPlay);
        ring2btn.setOnClickListener(doPlay);
        ring3btn.setOnClickListener(doPlay);

        text1 = (TextView) findViewById(R.id.cantinatxt);
        text2 = (TextView) findViewById(R.id.alarmtxt);
        text3 = (TextView) findViewById(R.id.trolltxt);

        player1 = new MediaPlayer();
        player2 = new MediaPlayer();
        player3 = new MediaPlayer();

        player1 = MediaPlayer.create(this, R.raw.cantinaband);
        player2 = MediaPlayer.create(this, R.raw.extremealarmclock);
        player3 = MediaPlayer.create(this, R.raw.loltrollsong);

    }

    public void PlaySong(MediaPlayer player){
        if(player.isPlaying()){
            player.pause();
        }else if(!player.isPlaying()){
            player.start();
        }
    }

    RadioButton.OnClickListener doPlay = new RadioButton.OnClickListener(){
        @Override
        public void onClick(View view){
            if(ring1btn.isChecked()){
                if(player2.isPlaying()){
                    player2.pause();
                }else if(player3.isPlaying()){
                    player3.pause();
                }

                PlaySong(player1);

                ring1btn.setAlpha(1f);
                text1.setAlpha(1f);
                ring2btn.setAlpha(0.5f);
                text2.setAlpha(0.5f);
                ring3btn.setAlpha(0.5f);
                text3.setAlpha(0.5f);
            }else if(ring2btn.isChecked()){
                if(player1.isPlaying()){
                    player1.pause();
                }else if(player3.isPlaying()) {
                    player3.pause();
                }

                PlaySong(player2);

                ring1btn.setAlpha(0.5f);
                text1.setAlpha(0.5f);
                ring2btn.setAlpha(1f);
                text2.setAlpha(1f);
                ring3btn.setAlpha(0.5f);
                text3.setAlpha(0.5f);
            }else if(ring3btn.isChecked()){
                if(player1.isPlaying()){
                    player1.pause();
                }else if(player2.isPlaying()) {
                    player2.pause();
                }
                PlaySong(player3);

                ring1btn.setAlpha(0.5f);
                text1.setAlpha(0.5f);
                ring2btn.setAlpha(0.5f);
                text2.setAlpha(0.5f);
                ring3btn.setAlpha(1f);
                text3.setAlpha(1f);
            }
        }
    };
}