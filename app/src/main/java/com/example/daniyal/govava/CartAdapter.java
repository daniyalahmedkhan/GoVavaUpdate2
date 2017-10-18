package com.example.daniyal.govava;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kashif on 10/17/2017.
 */

public class CartAdapter extends ArrayAdapter {
    int[] imagesArray;
    String[] titleArray;


    public CartAdapter( Context context, int[] imagesArray , String[] titleArray) {
        super(context, R.layout.cart_tab2, R.id.cartTab2_Heading , titleArray);
        this.imagesArray = imagesArray;
       this.titleArray = titleArray;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.cart_tab2 , parent , false);


        ImageView imageView = (ImageView) row.findViewById(R.id.cartTab2_Image);
       TextView textView = (TextView) row.findViewById(R.id.cartTab2_Heading);

        imageView.setImageResource(imagesArray[position]);
        textView.setText(titleArray[position]);


        return row;
    }
}
