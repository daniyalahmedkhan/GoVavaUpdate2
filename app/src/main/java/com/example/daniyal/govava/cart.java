package com.example.daniyal.govava;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;


@SuppressWarnings("deprecation")
public class cart extends TabActivity {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final TabHost tabHost = getTabHost();
        tabHost.setup();


        TabHost.TabSpec photospec = tabHost.newTabSpec("Photos");
        // setting Title and Icon for the Tab
        photospec.setIndicator("", getResources().getDrawable(R.mipmap.cart_cart_icon));
        Intent photosIntent = new Intent(this, CartTab1.class);
        photospec.setContent(photosIntent);

        // Tab for Songs
        TabHost.TabSpec songspec = tabHost.newTabSpec("Songs");
        songspec.setIndicator("", getResources().getDrawable(R.mipmap.cart_save_icon));
        Intent songsIntent = new Intent(this, CartTab2.class);
        songspec.setContent(songsIntent);



        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab


        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(0, PorterDuff.Mode.MULTIPLY);


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {


                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(0, PorterDuff.Mode.MULTIPLY);
            }
        });

    }
}
