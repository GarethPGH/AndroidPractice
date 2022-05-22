package com.example.wildgingerdinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {
    private TextView reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reservation = (TextView) findViewById(R.id.txtreservation);
        Button btn = (Button) findViewById(R.id.button);

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
                if (hour <= 23 && hour >= 17) {
                    hour = hour - 12;
                    if(minutes == 0){
                        reservation.setText("Your food will be delivered at " + hour + ":" + "00 PM");
                    }else if(minutes >= 1 && minutes < 10){
                        reservation.setText("Your food will be delivered at " + hour + ":0" + minutes + " PM");
                    }else{
                        reservation.setText("Your food will be delivered at " + hour + ":" + minutes + " PM");
                    }
                } else {
                    reservation.setText("Restaurant not open, please choose a different time");
                }
            }
        };


        btn.setOnClickListener(new View.OnClickListener() {
            int hour = 5;
            int minute = 0;

            @Override
            public void onClick(View view) {
                new TimePickerDialog(MainActivity.this, timeSetListener, hour, minute, false).show();
            }
        });
    }
}