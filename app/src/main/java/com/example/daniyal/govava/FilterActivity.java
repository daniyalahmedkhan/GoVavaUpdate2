package com.example.daniyal.govava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class FilterActivity extends AppCompatActivity {

    ImageView imageView;

   // RangeSeekBar rangeSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        imageView = (ImageView) findViewById(R.id.FilterCross);
       // rangeSeekBar = (RangeSeekBar) findViewById(R.id.rangeSeekbar);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilterActivity.this.finish();
            }
        });

        RangeSeekBar<Integer> rangeSeekBar = new RangeSeekBar<Integer>(FilterActivity.this);
        rangeSeekBar.setRangeValues(0, 100);


        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                //Now you have the minValue and maxValue of your RangeSeekbar
                Toast.makeText(getApplicationContext(), minValue + "-" + maxValue, Toast.LENGTH_LONG).show();
            }
        });

        // Get noticed while dragging
        rangeSeekBar.setNotifyWhileDragging(true);
    }
}
