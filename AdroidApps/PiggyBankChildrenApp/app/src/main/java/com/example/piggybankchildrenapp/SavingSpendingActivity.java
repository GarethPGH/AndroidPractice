package com.example.piggybankchildrenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SavingSpendingActivity extends AppCompatActivity {
    EditText dime;
    EditText quarts;
    EditText pens;
    EditText nicks;
    Button butn;
    Spinner spin;
    final double DIME = 0.10;
    final double NICKLE = 0.05;
    final double QUARTER = 0.25;
    final double PENNY = 0.01;

    public SavingSpendingActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_spending);
        dime = (EditText) findViewById(R.id.dimes);
        quarts = (EditText) findViewById(R.id.quarters);
        nicks = (EditText) findViewById(R.id.nickles);
        pens = (EditText) findViewById(R.id.pennies);
        butn = (Button) findViewById(R.id.btnbank);
        spin = (Spinner)findViewById(R.id.spinner);

        butn.setOnClickListener(new View.OnClickListener() {
            int dimes = 0;
            int quarters = 0;
            int pennies = 0;
            int nickles = 0;
            double sum = 0;

            String spendsave = "";
            String returnString = "";
            DecimalFormat currency = new DecimalFormat("$###,###.##");

            TextView banktext = (TextView) findViewById(R.id.bank);

            @Override
            public void onClick(View view) {
                dimes = Integer.parseInt(dime.getText().toString());
                quarters = Integer.parseInt(quarts.getText().toString());
                nickles = Integer.parseInt(nicks.getText().toString());
                pennies = Integer.parseInt(pens.getText().toString());

                sum = (dimes * DIME) + (quarters * QUARTER) + (nickles * NICKLE) + (pennies * PENNY);
                spendsave = spin.getSelectedItem().toString();
                if(spendsave.equals("Saving")){
                    spendsave = "saved";
                }else{
                    spendsave = "spent";
                }

                returnString = "Your Child " + spendsave + " " + currency.format(sum);
                banktext.setText(returnString);
            }
        });
    }
}