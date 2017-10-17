package com.example.daniyal.govava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Pets extends AppCompatActivity {

    ImageView imageView, imageView2;
    TextView t1,t2,t3,t4,t5,t6;
    TextView Imagestxt1 ,Imagestxt2,Imagestxt3,Imagestxt4,Imagestxt5,Imagestxt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        /// Pets Name Text Start ///

        t1 = (TextView) findViewById(R.id.Text1);
        t2 = (TextView) findViewById(R.id.Text2);
        t3 = (TextView) findViewById(R.id.Text3);
        t4 = (TextView) findViewById(R.id.Text4);
        t5 = (TextView) findViewById(R.id.Text5);
        t6 = (TextView) findViewById(R.id.Text6);

        // End //


        /// Images Text Start ///

        Imagestxt1 = (TextView) findViewById(R.id.ImagesTxt1);
        Imagestxt2 = (TextView) findViewById(R.id.ImagesTxt2);
        Imagestxt3 = (TextView) findViewById(R.id.ImagesTxt3);
        Imagestxt4 = (TextView) findViewById(R.id.ImagesTxt4);
        Imagestxt5 = (TextView) findViewById(R.id.ImagesTxt5);
        Imagestxt6 = (TextView) findViewById(R.id.ImagesTxt6);


        // End ///


        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        Typeface typeface4 = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Medium.ttf");


        imageView = (ImageView) findViewById(R.id.Petsimg1);
        imageView2 = (ImageView) findViewById(R.id.PetsBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pets.this , Dogs.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pets.this.finish();
            }
        });


        t1.setTypeface(typeface1);
        t2.setTypeface(typeface1);
        t3.setTypeface(typeface1);
        t4.setTypeface(typeface1);
        t5.setTypeface(typeface1);
        t6.setTypeface(typeface1);


        Imagestxt1.setTypeface(typeface4);
        Imagestxt2.setTypeface(typeface4);
        Imagestxt3.setTypeface(typeface4);
        Imagestxt4.setTypeface(typeface4);
        Imagestxt5.setTypeface(typeface4);
        Imagestxt6.setTypeface(typeface4);

    }


}
