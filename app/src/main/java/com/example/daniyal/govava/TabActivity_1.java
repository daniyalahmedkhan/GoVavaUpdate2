package com.example.daniyal.govava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.List;

public class TabActivity_1 extends AppCompatActivity {

   EditText e1;
    TextView t1, t2 ,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_1);
        e1 = (EditText) findViewById(R.id.EditTextSearch);
        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView3);
        t3 = (TextView) findViewById(R.id.textView4);



        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name  = t1.getText().toString();
                e1.setText(name);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name  = t2.getText().toString();
                e1.setText(name);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name  = t3.getText().toString();
                e1.setText(name);
            }
        });


    }

}