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

public class Question_4 extends Activity {


    String ocassion;
    EditText e1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_4);
        e1 = (EditText) findViewById(R.id.Question4Dialogue);
        imageView = (ImageView) findViewById(R.id.continueNext);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Question_4.this , ItemDetails.class);
                startActivity(intent);

            }
        });

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLangDialog();
            }
        });
    }
    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.ocassion_spinner, null);
        dialogBuilder.setView(dialogView);

        RadioGroup radioGroup;

        radioGroup = (RadioGroup) dialogView.findViewById(R.id.radioGroup);


        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();

                e1.setText(ocassion);
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
                Toast.makeText(Question_4.this , "You have selected Birthday " , Toast.LENGTH_SHORT).show();
                ocassion = "Birthday ";
                break;

            case R.id.Radio2:
                Toast.makeText(Question_4.this , " You have selected Bridal " , Toast.LENGTH_SHORT).show();
                ocassion = "Bridal ";
                break;

            case R.id.Radio3:
                Toast.makeText(Question_4.this , " You have selected Thanksgiving " , Toast.LENGTH_SHORT).show();
                ocassion = "Thanksgiving ";
                break;
            case R.id.Radio4:
                Toast.makeText(Question_4.this , " You have selected Christmas " , Toast.LENGTH_SHORT).show();
                ocassion = "Christmas ";
                break;
            case R.id.Radio5:
                Toast.makeText(Question_4.this , " You have selected Easter " , Toast.LENGTH_SHORT).show();
                ocassion = "Easter";
                break;

            case R.id.Radio6:
                Toast.makeText(Question_4.this , " You have selected Hanukah " , Toast.LENGTH_SHORT).show();
                ocassion = "Hanukah ";
                break;

            case R.id.Radio7:
                Toast.makeText(Question_4.this , " You have selected New born " , Toast.LENGTH_SHORT).show();
                ocassion = "New born ";
                break;

            case R.id.Radio8:
                Toast.makeText(Question_4.this , " You have selected Baby Shower " , Toast.LENGTH_SHORT).show();
                ocassion = "Baby Shower ";
                break;

            case R.id.Radio9:
                Toast.makeText(Question_4.this , " You have selected Bachelorette/Bachelor Party " , Toast.LENGTH_SHORT).show();
                ocassion = "Bachelorette/Bachelor Party ";
                break;

            case R.id.Radio10:
                Toast.makeText(Question_4.this , " You have selected Promotion " , Toast.LENGTH_SHORT).show();
                ocassion = "Promotion";
                break;

            case R.id.Radio11:
                Toast.makeText(Question_4.this , " You have selected Sympathy " , Toast.LENGTH_SHORT).show();
                ocassion = "Sympathy ";
                break;

            case R.id.Radio12:
                Toast.makeText(Question_4.this , " You have selected Graduation" , Toast.LENGTH_SHORT).show();
                ocassion = "Graduation";
                break;

            case R.id.Radio13:
                Toast.makeText(Question_4.this , " You have selected Passed a Big Exam" , Toast.LENGTH_SHORT).show();
                ocassion = "Passed a Big Exam";
                break;

            case R.id.Radio14:
                Toast.makeText(Question_4.this , " You have selected Surgery" , Toast.LENGTH_SHORT).show();
                ocassion = "Surgery";
                break;

            case R.id.Radio15:
                Toast.makeText(Question_4.this , " You have selected Get Well Soon/Welcome Home from Hospital" , Toast.LENGTH_SHORT).show();
                ocassion = "Get Well Soon/Welcome Home from Hospital";
                break;

            case R.id.Radio16:
                Toast.makeText(Question_4.this , " You have selected Weight Loss" , Toast.LENGTH_SHORT).show();
                ocassion = "Weight Loss";
                break;
            case R.id.Radio17:
                Toast.makeText(Question_4.this , " You have selected Thank You/Appreciation" , Toast.LENGTH_SHORT).show();
                ocassion = "Thank You/Appreciation";
                break;

            case R.id.Radio18:
                Toast.makeText(Question_4.this , " You have selected Sympathy" , Toast.LENGTH_SHORT).show();
                ocassion = "Sympathy";
                break;

            case R.id.Radio19:
                Toast.makeText(Question_4.this , " You have selected Apology" , Toast.LENGTH_SHORT).show();
                ocassion = "Apology";
                break;

            case R.id.Radio20:
                Toast.makeText(Question_4.this , " You have selected Christening/Confirmation" , Toast.LENGTH_SHORT).show();
                ocassion = "Christening/Confirmation";
                break;

            case R.id.Radio21:
                Toast.makeText(Question_4.this , " You have selected Employee Gifts " , Toast.LENGTH_SHORT).show();
                ocassion = "Employee Gifts";
                break;

            case R.id.Radio22:
                Toast.makeText(Question_4.this , " You have selected Employee Gifts (custom logos)" , Toast.LENGTH_SHORT).show();
                ocassion = "Employee Gifts (custom logos)";
                break;
            case R.id.Radio23:
                Toast.makeText(Question_4.this , " You have selected Bar Mitzvahs" , Toast.LENGTH_SHORT).show();
                ocassion = "Bar Mitzvahs";
                break;
            case R.id.Radio24:
                Toast.makeText(Question_4.this , " You have selected Just Because/Thinking of You" , Toast.LENGTH_SHORT).show();
                ocassion = "Just Because/Thinking of You";
                break;



            default:
                break;


        }



    }
}
