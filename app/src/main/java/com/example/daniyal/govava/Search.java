package com.example.daniyal.govava;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import static android.R.attr.color;
import static android.R.attr.colorPrimary;
import static android.R.attr.colorPrimaryDark;
import static android.R.attr.drawable;
import static android.R.attr.host;

@SuppressWarnings("deprecation")
public class Search extends TabActivity {

    //TabHost TabHostWindow;
    // TabHost tabHost;
    TabHost tabHost;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        imageView = (ImageView) findViewById(R.id.SearchAllBck);
        final TabHost tabHost = getTabHost();
        tabHost.setup();

        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Photos");
        // setting Title and Icon for the Tab
        photospec.setIndicator("", getResources().getDrawable(R.mipmap.recentlysearch_search_icon));
        Intent photosIntent = new Intent(this, TabActivity_1.class);
        photospec.setContent(photosIntent);

        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("Songs");
        songspec.setIndicator("", getResources().getDrawable(R.mipmap.cart_save_icon));
        Intent songsIntent = new Intent(this, TabActivity_2.class);
        songspec.setContent(songsIntent);

//            // Tab for Videos
//            TabSpec videospec = tabHost.newTabSpec("Videos");
//            videospec.setIndicator("Videos", getResources().getDrawable(R.drawable.icon_videos_tab));
//            Intent videosIntent = new Intent(this, VideosActivity.class);
//            videospec.setContent(videosIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        //tabHost.addTab(videospec); // Adding videos tab


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search.this.finish();
            }
        });


        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(0, PorterDuff.Mode.MULTIPLY);


        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
           @Override
           public void onTabChanged(String s) {


        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(0, PorterDuff.Mode.MULTIPLY);
           }
       });



    }
}