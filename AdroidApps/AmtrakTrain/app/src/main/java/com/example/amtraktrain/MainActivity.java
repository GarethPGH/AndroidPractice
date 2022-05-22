package com.example.amtraktrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        EditText txtMin = (EditText) findViewById(R.id.txtMinutes);
        EditText txtHour = (EditText) findViewById(R.id.txtHour);
        EditText txtTrip = (EditText) findViewById(R.id.txtTripLen);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        btn.setOnClickListener(new View.OnClickListener() {
            int tripLen = -1;
            int min = -1;
            int hour = -1;
            @Override
            public void onClick(View view) {

                String trip = txtTrip.getText().toString();
                String minutes = txtMin.getText().toString();
                String hr = txtHour.getText().toString();

                if(!trip.isEmpty() && !minutes.isEmpty() && !hr.isEmpty()) {
                    tripLen = Integer.parseInt(trip);
                    min = Integer.parseInt(minutes);
                    hour = Integer.parseInt(hr);
                }

                if(tripLen <= 0 || tripLen > 1500){
                    Toast.makeText(getApplicationContext(), "Trip Can't Exceed 1500 Minutes", Toast.LENGTH_SHORT).show();
                }else{
                    if(min < 0 || min > 59 || hour < 0 || hour > 23){
                        Toast.makeText(getApplicationContext(), "Hour or Minutes not Valid", Toast.LENGTH_SHORT).show();
                    }else{
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("TripLength", tripLen);
                        editor.putInt("Hour", hour);
                        editor.putInt("Minutes", min);
                        editor.commit();

                        startActivity(new Intent(getBaseContext(), TrainActivity.class));
                    }
                }
            }
        });
    }
}