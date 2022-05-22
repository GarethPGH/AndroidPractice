package com.example.carwashpackages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final double EXT_NO_PACK = 10.99;
        final double INT_NO_PACK = 15.99;
        final double EXT = 8.99;
        final double INT = 12.99;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_carwash);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Button btn = (Button) findViewById(R.id.button);
        final TextView txtview = (TextView) findViewById(R.id.txtCost);
        final RadioButton radExt = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton radInt = (RadioButton) findViewById(R.id.radioButton2);
        final EditText numPack = (EditText) findViewById(R.id.editTextNumber);
        DecimalFormat currency = new DecimalFormat("$###,##0.00");

        btn.setOnClickListener(new View.OnClickListener() {
            double cost = 1.0;
            @Override
            public void onClick(View view) {
                //If selected get number
                if (radExt.isChecked() || radInt.isChecked()) {
                    String placeholder = numPack.getText().toString();

                    if (placeholder.matches("[0-9]+")) {
                        int numberWashes = Integer.parseInt(placeholder);

                        if (numberWashes > 0) {
                            //Show discount message if washes < 12
                            if (numberWashes < 12) {
                                Toast.makeText(MainActivity.this, "For a Discount, buy 12 or more washes", Toast.LENGTH_SHORT).show();
                            }
                            //Do math
                            if (radExt.isChecked() && numberWashes >= 12) {
                                cost = EXT * numberWashes;
                            } else if (radExt.isChecked() && numberWashes < 12) {
                                cost = EXT_NO_PACK * numberWashes;
                            } else if (radInt.isChecked() && numberWashes >= 12) {
                                cost = INT * numberWashes;
                            } else if (radInt.isChecked() && numberWashes < 12) {
                                cost = INT_NO_PACK * numberWashes;
                            }
                            //Set text
                            txtview.setText("Cost For " + numberWashes + " washes is " + currency.format(cost));
                        } else {
                            Toast.makeText(MainActivity.this, "Washes Must be Greater than 0", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Washes must be a number", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "You must select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}