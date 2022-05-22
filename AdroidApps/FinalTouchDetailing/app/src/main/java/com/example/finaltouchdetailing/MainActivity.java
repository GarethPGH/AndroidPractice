package com.example.finaltouchdetailing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.CursorJoiner;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView reservation;
    private TextView cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reservation = (TextView) findViewById(R.id.txtreservation);
        cost = (TextView)findViewById(R.id.txtcost);
        CheckBox basicBtn = (CheckBox) findViewById(R.id.radBasic);
        CheckBox vacBtn = (CheckBox) findViewById(R.id.radVac);
        CheckBox delBtn = (CheckBox) findViewById(R.id.radDeluxe);
        CheckBox restBtn = (CheckBox) findViewById(R.id.radRestore);
        Button btn = (Button) findViewById(R.id.button);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        DateFormat dateFormat =  DateFormat.getDateInstance();

        Calendar cal = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSet = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, monthOfYear);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                reservation.setText("Your appointment: " + dateFormat.format(cal.getTime()));
            }
        };

        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, dateSet, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        dialog.getDatePicker().setMinDate(System.currentTimeMillis());

        btn.setOnClickListener(new View.OnClickListener() {
            double total = 0.0;
            final double BASIC = 10.0;
            final double VACUUM = 20.0;
            final double DELUXE = 45.0;
            final double RESTORE = 160.0;

            @Override
            public void onClick(View view) {

                if(basicBtn.isChecked() || vacBtn.isChecked() || delBtn.isChecked() || restBtn.isChecked()) {
                    if (basicBtn.isChecked()) {
                        total += BASIC;
                    }
                    if (vacBtn.isChecked()) {
                        total += VACUUM;
                    }
                    if (delBtn.isChecked()) {
                        total += DELUXE;
                    }
                    if (restBtn.isChecked()) {
                        total += RESTORE;
                    }

                    dialog.show();
                    dateFormat.format(cal.getTime());

                    cost.setText("Cost: " + currency.format(total));
                }else{
                    total = 0.0;
                    reservation.setText("Please select a service, and try again");
                }
            }
        });
    }
}