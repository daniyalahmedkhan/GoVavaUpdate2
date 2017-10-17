package com.example.daniyal.govava;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.media.RatingCompat;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.left;
import static android.R.attr.right;
import static android.R.attr.typeface;
import static com.example.daniyal.govava.R.id.bottom;
import static com.example.daniyal.govava.R.id.top;

/**
 * Created by Daniyal on 10/12/2017.
 */

public class CustomAdapter2  extends BaseAdapter{


    Typeface typeface1;
    Typeface typeface2;

    private LayoutInflater lInflater;
    //private List<ItemObject> listStorage;
    private String name[];
    private int img[];




    public CustomAdapter2(Context context, int img[], String name[]) {
        lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //listStorage = customizedListView;
        this.img = img;
        this.name = name;

        typeface1 = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
        typeface2 = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
    }

    @Override
    public int getCount() {
        //return listStorage.size();
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = lInflater.inflate(R.layout.drawer_items, parent, false);

            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView62);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.home_sidemenu_icon);



//            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView63);
//            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.home_sidemenu_notification);
//
//            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView64);
//            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.home_sidemenu_whattobuy);
//

            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText(name[position]);


        if (img[position] == 0 ){

            listViewHolder.textInListView.setTypeface(Typeface.DEFAULT_BOLD );
            listViewHolder.imageInListView.setVisibility(View.GONE);
//            String Head = listViewHolder.textInListView.getText().toString();
//            Head.toLowerCase();
//            StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);


            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.rightMargin = 180;
                 listViewHolder.textInListView.setLayoutParams(layoutParams);





        }
        else {
            listViewHolder.imageInListView.setImageResource(img[position]);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            layoutParams.leftMargin = 50;

                      listViewHolder.imageInListView.setLayoutParams(layoutParams);
            listViewHolder.textInListView.setLayoutParams(layoutParams);

        }


        listViewHolder.textInListView.setTypeface(typeface1);



        return convertView;
    }

    static class ViewHolder{

        TextView textInListView;
        ImageView imageInListView;
    }

}