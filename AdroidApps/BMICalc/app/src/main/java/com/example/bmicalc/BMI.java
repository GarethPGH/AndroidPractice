package com.example.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        TextView weight = (TextView) findViewById(R.id.weight);
        TextView height = (TextView) findViewById(R.id.height);
        TextView bmiVal = (TextView) findViewById(R.id.bmival);
        DecimalFormat BMIformat = new DecimalFormat("###.##");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        int heightInches = prefs.getInt("Height",0);
        int weightPounds = prefs.getInt("Weight", 0);
        float bmi = prefs.getFloat("BMI",0);

        weight.setText("Weight: " + weightPounds);
        height.setText("Height: " + heightInches);
        bmiVal.setText("BMI: " + BMIformat.format(bmi));
        Toast.makeText()


    }
}
