package com.example.humanesocietyapp;
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
    Integer[] dogArray = {R.drawable.beatrice, R.drawable.beefydave, R.drawable.bowie, R.drawable.clarice, R.drawable.murphy, R.drawable.teeter};
    String[] dogName = {"Beatrice", "BeefyDave", "Bowie", "Clarice", "Murphy", "Teeter"};
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
                Toast.makeText(getBaseContext(), dogName[position].toString(), Toast.LENGTH_SHORT).show();
                pic.setImageResource(dogArray[position]);
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
            return dogArray.length;
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
            pic.setImageResource(dogArray[index]);
            pic.setScaleType(ImageView.ScaleType.FIT_CENTER);
            pic.setLayoutParams(new ViewGroup.LayoutParams(300,250));
            return pic;
        }
    }
}