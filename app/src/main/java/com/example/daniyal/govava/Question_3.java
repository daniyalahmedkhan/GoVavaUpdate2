package com.example.daniyal.govava;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question_3 extends Activity {

    String price;
    ImageView imageView;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_3);
        e1 = (EditText) findViewById(R.id.Question3Dialouge);
        imageView = (ImageView) findViewById(R.id.continueNext);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question_3.this , Question_4.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_slide,
                        R.anim.animation_slide);
            }
        });

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangeLangDialog();
            }
        });
    }

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.price_spinner, null);
        dialogBuilder.setView(dialogView);

        RadioGroup radioGroup;

        radioGroup = (RadioGroup) dialogView.findViewById(R.id.radioGroup);


        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();

                e1.setText(price);
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void onRadioButtonClicked(View v){

        switch (v.getId()){


            case R.id.Radio1:
                Toast.makeText(Question_3.this , "You have selected $2-25" , Toast.LENGTH_SHORT).show();
                price = "$2-25";
                break;

            case R.id.Radio2:
                Toast.makeText(Question_3.this , " You have selected $30-40" , Toast.LENGTH_SHORT).show();
                price = "$30-40";
                break;

            case R.id.Radio3:
                Toast.makeText(Question_3.this , " You have selected $45-50" , Toast.LENGTH_SHORT).show();
                price = "$45-50";
                break;
            case R.id.Radio4:
                Toast.makeText(Question_3.this , " You have selected $75-100" , Toast.LENGTH_SHORT).show();
                price = "$75-100";
                break;
            case R.id.Radio5:
                Toast.makeText(Question_3.this , " You have selected More+" , Toast.LENGTH_SHORT).show();
               price = "More+";
                break;


            default:
                break;


        }



    }

}
