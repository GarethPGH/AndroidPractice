package com.example.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button butn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butn = (Button)findViewById(R.id.button);
        butn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, BillPortion.class));
            }
        });
    }
}