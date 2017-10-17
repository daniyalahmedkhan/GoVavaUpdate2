package com.example.daniyal.govava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Gift_for_Pets extends AppCompatActivity {


    ImageView imageView;
    TextView  Price1 , Price2 , Price3 , Price4 , Price5, Price6;
    TextView Name1 , Name2 , Name3 , Name4 , Name5 , Name6;
    TextView From1 , From2 , From3 , From4, From5 , From6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_for__pets);
        imageView = (ImageView) findViewById(R.id.GiftForPetimg1);
        Name1 = (TextView) findViewById(R.id.Name1);
        Name2 = (TextView) findViewById(R.id.Name2);
        Name3 = (TextView) findViewById(R.id.Name3);
        Name4 = (TextView) findViewById(R.id.Name4);
        Name5 = (TextView) findViewById(R.id.Name5);
        Name6 = (TextView) findViewById(R.id.Name6);

        Price1 = (TextView)  findViewById(R.id.Price1);
        Price2 = (TextView)  findViewById(R.id.Price2);
        Price3 = (TextView)  findViewById(R.id.Price3);
        Price4 = (TextView)  findViewById(R.id.Price4);
        Price5 = (TextView)  findViewById(R.id.Price5);
        Price6 = (TextView)  findViewById(R.id.Price6);

        From1 = (TextView) findViewById(R.id.From1);
        From2 = (TextView) findViewById(R.id.From1);
        From3 = (TextView) findViewById(R.id.From1);
        From4 = (TextView) findViewById(R.id.From1);
        From5 = (TextView) findViewById(R.id.From1);
        From6 = (TextView) findViewById(R.id.From1);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gift_for_Pets.this , Pets.class);
                startActivity(intent);
            }
        });


        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        Typeface typeface4 = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Medium.ttf");
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");

        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");



        Name1.setTypeface(typeface4);
        Name2.setTypeface(typeface4);
        Name3.setTypeface(typeface4);
        Name4.setTypeface(typeface4);
        Name5.setTypeface(typeface4);
        Name6.setTypeface(typeface4);


        Price1.setTypeface(typeface3);
        Price2.setTypeface(typeface3);
        Price3.setTypeface(typeface3);
        Price4.setTypeface(typeface3);
        Price5.setTypeface(typeface3);
        Price6.setTypeface(typeface3);


        From1.setTypeface(typeface2);
        From2.setTypeface(typeface2);
        From3.setTypeface(typeface2);
        From4.setTypeface(typeface2);
        From5.setTypeface(typeface2);
        From6.setTypeface(typeface2);


        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.custom_searchbar);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCustom);
//        setSupportActionBar(toolbar);

    }
}
