package com.example.techgadgets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] gadgets = {"Stand Mixer", "Rice Cooker", "XBox 360", "DDR Dancepad", "Valve Index Headset"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.tech, gadgets));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position){
            case 0:
                startActivity(new Intent(MainActivity.this, StandMixer.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, RiceCooker.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, XBoxConsole.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, DanceDanceRevolution.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, ValveIndex.class));
                break;
        }
    }
}