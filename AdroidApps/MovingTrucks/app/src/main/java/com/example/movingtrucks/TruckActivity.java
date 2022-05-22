package com.example.movingtrucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TruckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck);

        TextView txtTruck = (TextView) findViewById(R.id.txtTruck);
        TextView txtCost = (TextView) findViewById(R.id.txtCost);
        ImageView truckImg = (ImageView) findViewById(R.id.imageTruck);
        DecimalFormat currency = new DecimalFormat("$###,###.###");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String truck = prefs.getString("TruckSize", "");
        float cost = prefs.getFloat("Cost", 0f);

        if(truck.equals("10 ft Truck")){
            truckImg.setImageResource(R.drawable.smalltruck);
        }else if(truck.equals("17 ft Truck")){
            truckImg.setImageResource(R.drawable.mediumtruck);
        }else if(truck.equals("26 ft Truck")){
            truckImg.setImageResource(R.drawable.largetruck);
        }

        txtTruck.setText(truck);
        txtCost.setText(currency.format(cost));
    }
}