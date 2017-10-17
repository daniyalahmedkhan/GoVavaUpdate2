package com.example.daniyal.govava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ItemDetails extends AppCompatActivity {

    ImageView imageView , imageView2 , imageView3 , imageView4;
    String UriString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        imageView = (ImageView) findViewById(R.id.ItemDetailBtn);
        imageView2 = (ImageView) findViewById(R.id.Head4Image);
        imageView3 = (ImageView) findViewById(R.id.Head4Image2);
        imageView4 = (ImageView) findViewById(R.id.ItemDetailBack);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetails.this, Gift_for_Pets.class);
                startActivity(intent);
            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetails.this, Details.class);
                startActivity(intent);
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetails.this , Men.class);
                startActivity(intent);
            }
        });
    }
}
