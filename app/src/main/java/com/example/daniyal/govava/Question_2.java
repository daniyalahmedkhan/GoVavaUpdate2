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

public class Question_2 extends Activity {

    ImageView imageView,imageView2;
    EditText e1;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_2);
        imageView = (ImageView) findViewById(R.id.continueNext);
        imageView2 = (ImageView) findViewById(R.id.QuestionCross);
        e1 = (EditText) findViewById(R.id.Question2Dialouge);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question_2.this , Question_3.class);
                startActivity(intent);
                overridePendingTransition(R.anim.animation_slide,
                        R.anim.animation_slide);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question_2.this.finish();
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
        final View dialogView = inflater.inflate(R.layout.gender_spinner, null);
        dialogBuilder.setView(dialogView);


        RadioGroup radioGroup;

        radioGroup = (RadioGroup) dialogView.findViewById(R.id.radioGroup);


        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                e1.setText(gender);

            }
        });


        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();

                e1.setText(gender);
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
                Toast.makeText(Question_2.this , " You have selected Male" , Toast.LENGTH_SHORT).show();
                gender = "Male";
                break;

            case R.id.Radio2:
                Toast.makeText(Question_2.this , " You have selected Female" , Toast.LENGTH_SHORT).show();
                gender = "Female";
                break;

            case R.id.Radio3:
                Toast.makeText(Question_2.this , " You have selected Relative" , Toast.LENGTH_SHORT).show();
                gender = "Relative";
                break;
            case R.id.Radio4:
                Toast.makeText(Question_2.this , " You have selected Best Friend" , Toast.LENGTH_SHORT).show();
                gender = "Best Friend";
                break;
            case R.id.Radio5:
                Toast.makeText(Question_2.this , " You have selected Casual Friend" , Toast.LENGTH_SHORT).show();
                gender = "Casual Friend";
                break;


            default:
                break;


        }



    }

}
