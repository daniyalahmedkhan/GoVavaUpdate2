package com.example.daniyal.govava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Men extends AppCompatActivity {


    ImageView imageView1 , imageView2 , imageView3;
    TextView MenHeading, t1 , t2 , t3 ,t4 ,t5, t6 , t7 , t8 , t9 , t10 , t11 ,t12 ;
    TextView From1 ,From2 , From3 , From4 , From5 , From6;
    TextView Price1 , Price2 , Price3 , Price4 , Price5, Price6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        MenHeading = (TextView) findViewById(R.id.MenHeading);
        t1 = (TextView) findViewById(R.id.MenText1);
        t2 = (TextView) findViewById(R.id.MenText2);
        t3 = (TextView) findViewById(R.id.MenText3);
        t4 = (TextView) findViewById(R.id.MenText4);
        t5 = (TextView) findViewById(R.id.MenText5);
        t6 = (TextView) findViewById(R.id.MenText6);


        /// Price Text Start///

        Price1 = (TextView) findViewById(R.id.Price1);
        Price2 = (TextView) findViewById(R.id.Price2);
        Price3 = (TextView) findViewById(R.id.Price3);
        Price4 = (TextView) findViewById(R.id.Price4);
        Price5 = (TextView) findViewById(R.id.Price5);
        Price6 = (TextView) findViewById(R.id.Price6);

        // End //

        ////From Text Start////

         From1 = (TextView) findViewById(R.id.From1);
        From2 = (TextView) findViewById(R.id.From2);
        From3 = (TextView) findViewById(R.id.From3);
        From4 = (TextView) findViewById(R.id.From4);
        From5 = (TextView) findViewById(R.id.From5);
        From6 = (TextView) findViewById(R.id.From6);


        //End///



        ////Discover our start///
        t7 = (TextView) findViewById(R.id.Discover1);
        t8 = (TextView) findViewById(R.id.Discover2);
        t9 = (TextView) findViewById(R.id.Discover3);
        t10 = (TextView) findViewById(R.id.Discover4);
        t11 = (TextView) findViewById(R.id.Discover5);
        t12 = (TextView) findViewById(R.id.Discover6);

        /// End ///

        imageView1 = (ImageView) findViewById(R.id.MenBack);
        imageView2 = (ImageView) findViewById(R.id.Menimg1);
        imageView3 = (ImageView) findViewById(R.id.MenFilterButton);

        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typeface4 = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Medium.ttf");



        t7.setTypeface(typeface1);
        t8.setTypeface(typeface1);
        t9.setTypeface(typeface1);
        t10.setTypeface(typeface1);
        t11.setTypeface(typeface1);
        t12.setTypeface(typeface1);


        t1.setTypeface(typeface4);
        t2.setTypeface(typeface4);
        t3.setTypeface(typeface4);
        t4.setTypeface(typeface4);
        t5.setTypeface(typeface4);
        t6.setTypeface(typeface4);


        From1.setTypeface(typeface2);
        From2.setTypeface(typeface2);
        From3.setTypeface(typeface2);
        From4.setTypeface(typeface2);
        From5.setTypeface(typeface2);
        From6.setTypeface(typeface2);


        Price1.setTypeface(typeface3);
        Price2.setTypeface(typeface3);
        Price3.setTypeface(typeface3);
        Price4.setTypeface(typeface3);
        Price5.setTypeface(typeface3);
        Price6.setTypeface(typeface3);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Men.this , Home.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Men.this , ItemDetails.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Men.this , FilterActivity.class);
                startActivity(intent);
            }
        });
    }
}
