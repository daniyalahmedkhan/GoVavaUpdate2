package com.example.daniyal.govava;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Home extends AppCompatActivity implements  View.OnClickListener {

    TextView showMore, Handpicked, Categories , UserName;
    ImageView imageView , imageView2;
    String names[];
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ImageView MyimageView;
    ImageView toggle , imageView3;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Handpicked = (TextView) findViewById(R.id.Homehandpicked);
        Categories = (TextView) findViewById(R.id.HomeCategories);
        showMore = (TextView) findViewById(R.id.HomeShowmore);
        imageView = (ImageView) findViewById(R.id.HomeMen);
        imageView2 = (ImageView) findViewById(R.id.HomeDrawer);
        imageView3 = (ImageView) findViewById(R.id.HomeCart);
        e1 = (EditText) findViewById(R.id.HomeSearch);
        progressDialog = new ProgressDialog(this);

        databaseReference = FirebaseDatabase.getInstance().getReference("users");



        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Black.ttf");
        Handpicked.setTypeface(typeface3);
        Categories.setTypeface(typeface3);
        showMore.setTypeface(typeface3);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, cart.class);
                startActivity(intent);
            }
        });


        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this , HomeShowAll.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this , Men.class);
                startActivity(intent);

            }
        });

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Search.class);
                startActivity(intent);



            }
        });


        ///Side Drawer///

        names = new String[]{"Home", "Notification", "What to buy?" , "MY GOVAVA", "Pets", "Favorites" , "My Purchases" , "" , "Categories" , "Settings" , "Help Contact" , "Log out" };
        int img[] = {R.mipmap.sidemenu_home_icon, R.mipmap.sidemenu_notification_icon, R.mipmap.sidemenu_what_to_buy_icon, 0 , R.mipmap.sidemenu_pets_icon , R.mipmap.sidemenu_favourites_icon ,  R.mipmap.sidemenu_mypurchases_notification_icon , 0 , R.mipmap.sidemenu_categories_icon , R.mipmap.sidemenu_setting_icon ,    R.mipmap.sidemenu_help_and_contact_icon , R.mipmap.logout_sidemenu_icon };
        //mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);



        mDrawerList.setFitsSystemWindows(true);

        mDrawerList.setAdapter(new CustomAdapter2(this, img, names));
        ViewGroup header = (ViewGroup) getLayoutInflater().inflate(R.layout.drawer_header, mDrawerList, false);


        TextView t1 = (TextView)header.findViewById(R.id.Emp_Name);
        t1.setTypeface(typeface2);


        mDrawerList.addHeaderView(header, null, false);

        MyimageView = (ImageView) header.findViewById(R.id.proImg);
        UserName = (TextView) findViewById(R.id.Emp_Name);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mDrawerLayout.isDrawerOpen(Gravity.LEFT))
                {
                    mDrawerLayout.closeDrawer(mDrawerList);
                    // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                    // getSupportActionBar().setCustomView(R.layout.menu_title);
                    // getSupportActionBar().show();


                }
                else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                    //getSupportActionBar().hide();
                    // requestWindowFeature(Window.FEATURE_NO_TITLE);
                }

            }
        });

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        progressDialog.setMessage(".. Please Wait");
        progressDialog.show();
        getData();
    }

    @Override
    public void onClick(View v) {

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position)
    {
        Intent i;

        switch (position)
        {
            case 1:
                i = new Intent(Home.this, MenWear.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;

            case 2:
//                i = new Intent(Home.this, Statements.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
                break;

            case 3:
                i = new Intent(Home.this, Question_1.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                   break;

            case 4:
//                i = new Intent(Home.this, Job_Offer.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
                    break;

            case 5:
                i = new Intent(Home.this, Pets.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;

            case 6:
//                firebaseAuth.signOut();
//                finish();
//                i = new Intent(Home.this, Login.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//                Log.i("test","check");
                break;

            case 12:

                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                i = new Intent(Home.this, LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
        }


    }
    public void getData(){


        databaseReference.child(LoginActivity.UID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ModelClass Mod = dataSnapshot.getValue(ModelClass.class);
                String name =   Mod.name;
                String url = Mod.imageUrl;
                String email = Mod.email;
              //Toast.makeText(Home.this, "EMAIL" + email , Toast.LENGTH_LONG).show();
                Glide.with(getApplicationContext()).load(url).into(MyimageView);

                UserName.setText(name.toString());

                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }


}
