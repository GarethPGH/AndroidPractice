package com.example.amtraktrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        ImageView trainImg = (ImageView) findViewById(R.id.trainImg);
        TextView hour = (TextView) findViewById(R.id.txthr);
        TextView minutes = (TextView) findViewById(R.id.txtmin);
        TextView red = (TextView) findViewById(R.id.txtred);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int departureHour = prefs.getInt("Hour", 0);
        int departureMinutes = prefs.getInt("Minutes", 0);
        int tripLength = prefs.getInt("TripLength",0);

        int tripHours = tripLength / 60;
        int tripMin = tripLength % 60;

        int arrivalHour = departureHour + tripHours;
        int arrivalMinutes = departureMinutes + tripMin;

        if(arrivalMinutes >= 60){
            arrivalHour += 1;
            arrivalMinutes = arrivalMinutes - 60;
        }
        if(arrivalHour > 23){
            arrivalHour %= 23;
        }
        if(arrivalHour > 0 || (arrivalHour == 0 && arrivalMinutes > 0)){
            if(arrivalHour <= 5){
                red.setText(R.string.red);
                trainImg.setImageResource(R.drawable.nighttime);
            }
        }

        hour.setText(String.format(String.valueOf(arrivalHour)));
        minutes.setText(String.format(String.valueOf(arrivalMinutes)));
    }
}