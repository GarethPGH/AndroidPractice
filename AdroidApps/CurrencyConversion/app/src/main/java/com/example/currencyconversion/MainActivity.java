package com.example.currencyconversion;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_coin);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText convert = (EditText) findViewById(R.id.moneyConvert);
        final TextView txtconvert = (TextView) findViewById(R.id.convertAmt);
        final RadioButton radPeso = (RadioButton)findViewById(R.id.radMex);
        final RadioButton radCanada = (RadioButton)findViewById(R.id.radCan);
        final RadioButton radEur = (RadioButton)findViewById(R.id.radEuro);
        DecimalFormat currency = new DecimalFormat("$###,##0.00");

        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            //Current Conversion Rates
            final double MEXICO = 20.653699;
            final double CANADA = 1.2665239;
            final double EU = 0.89991881;
            double converted = 1.0;
            double conversionRate = 0.0;
            double usd = -1.0;
            String placeholder = "";
            String curr = "";

            @Override
            public void onClick(View view) {
                if(radPeso.isChecked() || radCanada.isChecked() || radEur.isChecked()) {
                    //Get Selection
                    if (radPeso.isChecked()) {
                        conversionRate = MEXICO;
                        curr = "MXN";
                    } else if (radCanada.isChecked()) {
                        conversionRate = CANADA;
                        curr = "CAD";
                    } else if (radEur.isChecked()) {
                        conversionRate = EU;
                        curr = "EUR";
                    }
                    //Get Money
                    placeholder = convert.getText().toString();
                    if (placeholder.matches("[0-9]+\\.?[0-9]*")) {
                        usd = Double.parseDouble(placeholder);
                    }

                    if (usd > 0.0 && usd <= 100000) {
                        converted = usd * conversionRate;
                        txtconvert.setText(currency.format(usd) + " is " + currency.format(converted) + " " + curr);
                    } else if (usd <= 0.0) {
                        Toast.makeText(getBaseContext(), "US Dollars Must be over $0", Toast.LENGTH_LONG).show();
                        txtconvert.setText("invalid");
                    } else if (usd > 100000) {
                        Toast.makeText(getBaseContext(), "US Dollars Must be less than 100000", Toast.LENGTH_LONG).show();
                        txtconvert.setText("invalid");
                    }
                } else if (!radEur.isChecked() && !radPeso.isChecked() && !radCanada.isChecked()) {
                    Toast.makeText(getBaseContext(), "Option not Selected", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}