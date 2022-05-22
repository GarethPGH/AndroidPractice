package com.example.rentacar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CarList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] carplaces = {"Enterprise Rent-A-Car", "Hertz Car Rental", "Avis Cars", "Budget", "Rent A Wreck", "Zipcars"};

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_car_list, R.id.car, carplaces));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enterprise.com/en/home.html")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hertz.com/")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.avis.com/en/home")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.budget.com/en/home")));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rentawreck.com/")));
                break;
            case 5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.zipcar.com/")));
                break;
        }
    }
}