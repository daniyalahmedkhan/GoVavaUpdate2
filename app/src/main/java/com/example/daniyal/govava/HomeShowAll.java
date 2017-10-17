package com.example.daniyal.govava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeShowAll extends AppCompatActivity {

    TextView textView, Apparels, Camera;
    ImageView imageView , imageView2;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_show_all);
        Apparels = (TextView) findViewById(R.id.HomeShowApparels);
        Camera = (TextView) findViewById(R.id.HomeShowCamera);
        e1 = (EditText) findViewById(R.id.HomeShowEdit);

        imageView = (ImageView) findViewById(R.id.ShowAllBck);
        textView = (TextView) findViewById(R.id.Showmore);
        imageView2 = (ImageView) findViewById(R.id.ShowAllFilter);

        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");

        Apparels.setTypeface(typeface3);
        Camera.setTypeface(typeface3);
        textView.setTypeface(typeface3);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(HomeShowAll.this , Men.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(HomeShowAll.this , Home.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeShowAll.this , FilterActivity.class);
            }
        });


        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeShowAll.this , Search.class);
                startActivity(intent);
            }
        });

    }
}
