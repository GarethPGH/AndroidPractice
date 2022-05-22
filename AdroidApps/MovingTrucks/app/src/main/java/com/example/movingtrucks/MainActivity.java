package com.example.movingtrucks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText txtMiles = (EditText) findViewById(R.id.txtMiles);
        RadioButton btnSmall = (RadioButton) findViewById(R.id.smallbtn);
        RadioButton btnMed = (RadioButton) findViewById(R.id.medbutton);
        RadioButton btnLarge = (RadioButton) findViewById(R.id.largebutton);
        Button btn = (Button) findViewById(R.id.calcbtn);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        btn.setOnClickListener(new View.OnClickListener() {
            String truck = "";
            int miles = 0;
            double cost = 0.0;
            final double SMALL = 19.95;
            final double MED = 29.95;
            final double LARGE = 39.95;
            final double COST_PER_MILE = 0.99;
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                miles = Integer.parseInt(txtMiles.getText().toString());

                if(btnSmall.isChecked()){
                    truck = "10 ft Truck";
                    cost = SMALL + (COST_PER_MILE * miles);
                }else if(btnMed.isChecked()){
                    truck = "17 ft Truck";
                    cost = MED + (COST_PER_MILE * miles);
                }else if(btnLarge.isChecked()){
                    truck = "26 ft Truck";
                    cost = LARGE + (COST_PER_MILE * miles);
                }

                editor.putString("TruckSize", truck);
                editor.putFloat("Cost", (float)cost);
                editor.apply();

                startActivity(new Intent(getApplicationContext(), TruckActivity.class));
            }
        });
    }
}