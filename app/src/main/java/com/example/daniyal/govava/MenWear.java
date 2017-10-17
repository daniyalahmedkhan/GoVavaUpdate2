package com.example.daniyal.govava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenWear extends AppCompatActivity {


    ImageView imageView1 , imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_wear);
        imageView1 = (ImageView) findViewById(R.id.MenBack);
        imageView2 = (ImageView) findViewById(R.id.Image1);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenWear.this.finish();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenWear.this , Men.class);
                startActivity(intent);
            }
        });

    }
}
