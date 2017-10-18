package com.example.daniyal.govava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CartTab2 extends AppCompatActivity {

    String[] titles = {"Brand New Apple iPhone 6s Plus" , "Lomography Lomo'Instant Cam" , "Nike Internationalist Star Shoes"};
    int[] images = {R.mipmap.saved_tab_img_one , R.mipmap.saved_tab_img_two , R.mipmap.saved_tab_img_three };

    ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_tab2);
        l1 = (ListView) findViewById(R.id.cartTabList);
        CartAdapter cartAdapter = new CartAdapter(CartTab2.this, images ,titles );
        l1.setAdapter(cartAdapter);
    }
}
