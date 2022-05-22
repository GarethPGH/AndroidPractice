package com.example.guitarsolo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button playbtn;
    MediaPlayer player;
    int playing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        playbtn = (Button) findViewById(R.id.button);
        playbtn.setOnClickListener(songListener);
        player = MediaPlayer.create(this, R.raw.steviesnoirguitar);
        playing = 0;
    }

    Button.OnClickListener songListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    player.start();
                    playing = 1;
                    playbtn.setText(R.string.pause);
                    break;
                case 1:
                    player.pause();
                    playing = 0;
                    playbtn.setText(R.string.play);
                    break;
            }
        }
    };
}