package com.example.personalphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] photos = {R.drawable.derp, R.drawable.derpina, R.drawable.goat, R.drawable.limzard, R.drawable.queen, R.drawable.thead, R.drawable.mifamilia, R.drawable.grandma};
    String[] names = {"Derp", "Little Derp", "Cute Goat", "Old Man", "Pretty Girl", "Akirashima", "Mom, Dad, Bro", "Grandma"};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridview);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getBaseContext(),names[position], Toast.LENGTH_SHORT).show();
                pic.setImageResource(photos[position]);
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return photos.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int index, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(photos[index]);
            pic.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            pic.setLayoutParams(new ViewGroup.LayoutParams(150,150));
            return pic;
        }
    }
}