package com.example.maqso.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

import static android.R.attr.bitmap;

public class SecondActivity extends AppCompatActivity {

    private ListView listView;

     int[] image= {R.drawable.imag,
            R.drawable.imn,
            R.drawable.jknd,
            R.drawable.kdg,
            R.drawable.kjn,
            R.drawable.imagg

    };
      String[] names = {"hassan","akhter","salman","hamza","gohar","nashit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

      class  CustomAdapter extends BaseAdapter{


          @Override
          public int getCount() {
              return image.length;
          }

          @Override
          public Object getItem(int position) {
              return null;
          }

          @Override
          public long getItemId(int position) {
              return 0;
          }

          @Override
          public View getView(int position, View convertView, ViewGroup parent) {

              convertView = getLayoutInflater().inflate(R.layout.item,null);
              ImageView imageView  = (ImageView) convertView.findViewById(R.id.imageView);
              TextView textView = (TextView) convertView.findViewById(R.id.textView);
              imageView.setImageResource(image[position]);
              textView.setText(names[position]);

              return convertView;
          }
      }

}
