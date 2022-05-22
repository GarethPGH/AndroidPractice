package com.example.paintestimatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Button;
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Controls
        val lengthField = findViewById<EditText>(R.id.txtLength);
        val widthField = findViewById<EditText>(R.id.txtWidth);
        val paintSelector = findViewById<Spinner>(R.id.spinner);
        val calcButton = findViewById<Button>(R.id.button);
        val gallons = findViewById<TextView>(R.id.txtGallons);

        val sqFtPerGal: Double = 250.0;
        val fraction = DecimalFormat("###,###.##");

        calcButton.setOnClickListener(){
            val len: String = lengthField.text.toString();
            val wid: String = widthField.text.toString();
            //Calculate Area
            if(!len.isNullOrEmpty() && !wid.isNullOrEmpty()) {
                val area: Int = (Integer.parseInt(len)) * (Integer.parseInt(wid));
                val numberGallons: Double = area.toDouble()/ sqFtPerGal;

                //Get Selection
                val paintColor: String = paintSelector.selectedItem.toString();

                //Set gallons control
                gallons.text = "Gallons: " + fraction.format(numberGallons) + " of " + paintColor;
            }
        }

    }
}