package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BillPortion extends AppCompatActivity {
    int people;
    double cost;
    double yourPortion;
    double tip;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_portion);

        final EditText intPeople = (EditText)findViewById(R.id.people);
        final EditText decCost = (EditText) findViewById(R.id.cost);
        btn = (Button) findViewById(R.id.button2);
        final TextView yurCost = (TextView) findViewById(R.id.yourCost);

        final double gratuity = 0.18;

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                people = Integer.parseInt(intPeople.getText().toString());
                cost = Double.parseDouble(decCost.getText().toString());
                System.out.println(people + " " + cost);
                tip = (cost * gratuity)/people;
                yourPortion = cost/people;
                String returnString;
                returnString = "Your Share: " + currency.format(yourPortion) + " Your tip: " + currency.format(tip);
                yurCost.setText(returnString);
            }
        });
    }
}