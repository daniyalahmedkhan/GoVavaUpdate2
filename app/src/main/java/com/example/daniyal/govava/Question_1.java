package com.example.daniyal.govava;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class Question_1 extends Activity {


    EditText e1;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    String age;
    ImageView imageView , imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_1);
        //spinner = (Spinner) findViewById(R.id.spinner1);
        imageView2 = (ImageView) findViewById(R.id.QuestionCross);
        e1 = (EditText) findViewById(R.id.Question1Edit);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question_1.this.finish();
            }
        });

        imageView = (ImageView) findViewById(R.id.continueNext);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question_1.this , Question_2.class);
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
        final View dialogView = inflater.inflate(R.layout.spinner, null);
        dialogBuilder.setView(dialogView);


        RadioGroup radioGroup;

        radioGroup = (RadioGroup) dialogView.findViewById(R.id.radioGroup);




        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                e1.setText(age);

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
            Toast.makeText(Question_1.this , " You have selected Age 2-9" , Toast.LENGTH_SHORT).show();
                age = "2-9";
                break;

            case R.id.Radio2:
                Toast.makeText(Question_1.this , " You have selected Age 10-12" , Toast.LENGTH_SHORT).show();
                age = "10-12";
                break;

            case R.id.Radio3:
                Toast.makeText(Question_1.this , " You have selected Age 13-15" , Toast.LENGTH_SHORT).show();
                age = "13-15";
                break;
            case R.id.Radio4:
                Toast.makeText(Question_1.this , " You have selected Age 16-24" , Toast.LENGTH_SHORT).show();
                age = "16-24";
                break;
            case R.id.Radio5:
                Toast.makeText(Question_1.this , " You have selected Age 25-32" , Toast.LENGTH_SHORT).show();
                age = "25-32";
                break;
            case R.id.Radio6:
                Toast.makeText(Question_1.this , " You have selected Age 33-45" , Toast.LENGTH_SHORT).show();
                age = "33-45";

                break;
            case R.id.Radio7:
                Toast.makeText(Question_1.this , " You have selected Age 46-55" , Toast.LENGTH_SHORT).show();
                age = "46-55";

                break;
            case R.id.Radio8:
                Toast.makeText(Question_1.this , " You have selected Age 56-65" , Toast.LENGTH_SHORT).show();
                age = "56-65";

                break;
            case R.id.Radio9:
                Toast.makeText(Question_1.this , " You have selected Age 65-older" , Toast.LENGTH_SHORT).show();
                age = "65-older";

                break;

            default:
                break;


        }



    }

}
