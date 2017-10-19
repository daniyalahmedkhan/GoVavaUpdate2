package com.example.daniyal.govava;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.net.URI;

public class RegistrationActivity extends Activity {

    private static final int PICK_IMAGE_REQUEST = 234 ;
    TextView t1 , t2 , t3 , t4;
    EditText e1 , e2 ,e3 ,e4 ,e5 ,e6;
    ImageView imageView , ProfileImage , ProfileUpload;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String Uname, Uemail , Upass , Uconpass , Uadress , Uphone;
    String UID;
    private StorageReference storageReference;
    private Uri filepath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.setBackgroundDrawableResource(R.drawable.login_cover);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_registration);


        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        firebaseAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(this);
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
        ProfileImage = (ImageView) findViewById(R.id.profile_image);
        ProfileUpload = (ImageView) findViewById(R.id.reg_uploadImage);


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
               ValidationMethod();

            }
        });


        ProfileUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenGallery();
            }
        });

    }


    /// Input field Validation Method //

    public void ValidationMethod(){

        progressDialog.setCancelable(true);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();
       String  name = e1.getText().toString().trim();
       String  email = e2.getText().toString().trim();
       String  pass = e3.getText().toString().trim();
       String  conPass = e4.getText().toString().trim();
       String  adress = e5.getText().toString().trim();
       String  phone = e6.getText().toString().trim();




        if((TextUtils.isEmpty(name)) || (TextUtils.isEmpty(email)) ||
                (TextUtils.isEmpty(pass)) || (TextUtils.isEmpty(conPass)) ||
                (TextUtils.isEmpty(adress)) || TextUtils.isEmpty(phone)){

            Toast.makeText(RegistrationActivity.this , " Validation Required " , Toast.LENGTH_SHORT).show();
            progressDialog.cancel();
        }else if(!(email.contains("@gmail.com")) || (email.contains("@yahoo.com")) ||

                (email.contains("@hotmail.com")) || (email.contains("@live.com"))){


            e2.setError("Please enter valid email");
            progressDialog.cancel();

        }else if(e3.length() < 6){


            e3.setError("Password must contains 6 digits");
            progressDialog.cancel();
        }else{

            //Toast.makeText(RegistrationActivity.this , " Good to Go " , Toast.LENGTH_SHORT).show();

            Uname = e1.getText().toString().trim();
            Uemail = e2.getText().toString().trim();
            Upass = e3.getText().toString().trim();
            Uconpass = e4.getText().toString().trim();
            Uadress = e5.getText().toString().trim();
            Uphone = e6.getText().toString().trim();
            RegUser();

        }


    }


    public void RegUser() {


        firebaseAuth.createUserWithEmailAndPassword(Uemail , Upass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                UID = firebaseAuth.getCurrentUser().getUid();
                Log.d("userid" ,  UID.toString());
                //FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser() ;
                //Toast.makeText(RegistrationActivity.this , " Success" , Toast.LENGTH_SHORT).show();
                //Toast.makeText(RegistrationActivity.this , " " + currentFirebaseUser , Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {


                SaveData();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistrationActivity.this , "Failed to Add" , Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void SaveData(){


        ModelClass Mod = new ModelClass(Uname , Uemail , Upass , Uconpass , Uadress , Uphone , UID);
        databaseReference.child(UID).setValue(Mod, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseReference.equals(databaseError)){
                    progressDialog.dismiss();
                    Toast.makeText(RegistrationActivity.this , "Error in Saving" , Toast.LENGTH_SHORT).show();
                }else {

                    uploadfile();
                    progressDialog.dismiss();
                    Intent i = new Intent(RegistrationActivity.this , LoginActivity.class);
                    startActivity(i);
                }

            }
        });

    }


    public void OpenGallery(){


        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select any image") , PICK_IMAGE_REQUEST);


    }


    private void uploadfile(){


        if (filepath != null){
        StorageReference riversRef = storageReference.child(UID+"/"+UID);
        /// MAIN FOLDER MAIN JA K UID KA FOLDER HOGA THEN IMAGE HOGI:
        riversRef.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Uri downUrl = taskSnapshot.getDownloadUrl();
                            Log.d("downUrl" , downUrl.toString());
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        }else {

            Toast.makeText(RegistrationActivity.this , " This error from upload file" , Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK  &&  data != null && data.getData() != null){

                filepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                ProfileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}




