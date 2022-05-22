package com.example.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.button);
        Button bmiBtn = (Button) findViewById(R.id.button2);
        EditText weight = (EditText) findViewById(R.id.txtweight);
        EditText height = (EditText) findViewById(R.id.txtheight);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            int inches = 0;
            int pounds = 0;
            double bmi = 0.0;
            @Override
            public void onClick(View view) {
                pounds = Integer.parseInt(weight.getText().toString());
                inches = Integer.parseInt(height.getText().toString());

                bmi = calculateBMI(pounds, inches);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("Weight", pounds);
                editor.putInt("Height", inches);
                editor.putFloat("BMI", (float)bmi);
                editor.apply();
            }

            public double calculateBMI(int weight, int height){
                double w = (double) weight;
                double h = (double) height;
                return ((w * 703.0)/ (h * h));
            }
        });

        bmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BMI.class));
            }
        });
    }
}