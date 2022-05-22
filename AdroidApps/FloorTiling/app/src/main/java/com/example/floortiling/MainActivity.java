package com.example.floortiling;

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
        final EditText len = (EditText) findViewById(R.id.length);
        final EditText wid = (EditText) findViewById(R.id.width);
        final TextView txtTiles = (TextView)findViewById(R.id.tiles);
        final RadioButton radtwelve = (RadioButton)findViewById(R.id.rad12);
        final RadioButton radeighteen = (RadioButton)findViewById(R.id.rad18);
        DecimalFormat tileFormat = new DecimalFormat("###,##0.00#");

        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            int length = 0;
            int width = 0;
            double area = 0;
            double numTiles = 0;
            int tileArea = 0;
            @Override
            public void onClick(View view) {
                length = Integer.parseInt(len.getText().toString());
                width = Integer.parseInt(wid.getText().toString());
                area = (length * width) * 12.0; //Convert to inches
                if(radtwelve.isChecked()){
                    tileArea = 144;
                }else if(radeighteen.isChecked()){
                    tileArea = 324;
                }else{
                    Toast.makeText(MainActivity.this, "Make a selection", Toast.LENGTH_SHORT).show();
                    return;
                }
                numTiles = area/tileArea;
                area = area/12.0;
                txtTiles.setText(tileFormat.format(numTiles) + " tiles needed for " + tileFormat.format(area) + " square ft");
            }
        });
    }
}