package com.example.daniyal.govava;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView t1 , t2 , t3 , t4 ,t5;
    EditText e1 , e2;
    TextView GoToRegistration;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);


        Window window = this.getWindow();
        window.setBackgroundDrawableResource(R.drawable.login_cover);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);


        setContentView(R.layout.activity_login);


//        editText = (EditText) findViewById(R.id.FullName);
//
//        editText.setPadding(35,0,0,0);

        t1 = (TextView) findViewById(R.id.HeadingSgn);
        t2 = (TextView) findViewById(R.id.Signup);
        t4 = (TextView) findViewById(R.id.orSigninWith);
        t5 = (TextView) findViewById(R.id.ForgotPassword);
        e1 = (EditText) findViewById(R.id.FullName);
        e2 = (EditText) findViewById(R.id.EmailAddress);
        GoToRegistration = (TextView) findViewById(R.id.GoToRegistation);

        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");

        t1.setTypeface(typeface3);
        t2.setTypeface(typeface3);
//        t3.setTypeface(typeface3);
        t4.setTypeface(typeface3);
        t5.setTypeface(typeface3);
        e1.setTypeface(typeface3);
        e2.setTypeface(typeface3);

        GoToRegistration.setTypeface(typeface3);



        GoToRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this , RegistrationActivity.class);
                startActivity(intent);


            }
        });



    }
}
