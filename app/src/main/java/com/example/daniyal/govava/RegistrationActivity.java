package com.example.daniyal.govava;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegistrationActivity extends Activity {

    TextView t1 , t2 , t3 , t4;
    EditText e1 , e2 ,e3 ,e4 ,e5 ,e6;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        window.setBackgroundDrawableResource(R.drawable.login_cover);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);



        setContentView(R.layout.activity_registration);





        t1 = (TextView) findViewById(R.id.RegName);
        t2 = (TextView) findViewById(R.id.RegEmail);
        t3 = (TextView) findViewById(R.id.RegSign);
        t4 = (TextView) findViewById(R.id.RegHaveAccount);
        imageView = (ImageView) findViewById(R.id.RegImgSign);
        e1 = (EditText) findViewById(R.id.FullName);
        e2 = (EditText) findViewById(R.id.EmailAddress);
        e3 = (EditText) findViewById(R.id.Password);
        e4 = (EditText) findViewById(R.id.ConfirmPassword);
        e5 = (EditText) findViewById(R.id.Adress);
        e6 = (EditText) findViewById(R.id.PhoneNumber);


        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");

        t1.setTypeface(typeface3);
        t2.setTypeface(typeface3);
        t3.setTypeface(typeface3);
        t4.setTypeface(typeface3);
        e1.setTypeface(typeface3);
        e2.setTypeface(typeface3);
        e3.setTypeface(typeface3);
        e4.setTypeface(typeface3);
        e5.setTypeface(typeface3);
        e6.setTypeface(typeface3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this , Home.class);
                startActivity(intent);
            }
        });

    }
}
