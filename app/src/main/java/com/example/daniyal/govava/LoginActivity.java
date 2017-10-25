package com.example.daniyal.govava;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessTokenTracker;
import com.facebook.ProfileTracker;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.TwitterAuthProvider;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import com.linkedin.platform.APIHelper;
import com.linkedin.platform.LISessionManager;
import com.linkedin.platform.errors.LIApiError;
import com.linkedin.platform.errors.LIAuthError;
import com.linkedin.platform.listeners.ApiListener;
import com.linkedin.platform.listeners.ApiResponse;
import com.linkedin.platform.listeners.AuthListener;
import com.linkedin.platform.utils.Scope;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.data;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1 , t2 , t3 , t4 ,t5;
    EditText e1 , e2;
    ImageView signin , FacebookLogin , fb , twitter , google , Linkedin;
    TextView GoToRegistration;
    EditText editText;
   public static String UID;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    DatabaseReference firebaseDatabase;
    LoginButton loginButton;
    TwitterLoginButton loginButton2;
    CallbackManager callbackManager;
    private String TAG = "data";
    public  String name;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private GoogleApiClient mGoogleApiClient;
    private int RC_SIGN_IN = 100;
    SignInButton signInButton;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        Window window = this.getWindow();
        window.setBackgroundDrawableResource(R.drawable.login_cover);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_login);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton2 = (TwitterLoginButton) findViewById(R.id.login_button2);
        fb = (ImageView) findViewById(R.id.fb);
        twitter = (ImageView) findViewById(R.id.twitter);
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        google = (ImageView) findViewById(R.id.google);
        Linkedin = (ImageView) findViewById(R.id.Linkedin);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("users");
        progressDialog = new ProgressDialog(this);

        t1 = (TextView) findViewById(R.id.HeadingSgn);
        t2 = (TextView) findViewById(R.id.Signup);
        t4 = (TextView) findViewById(R.id.orSigninWith);
        t5 = (TextView) findViewById(R.id.ForgotPassword);
        e1 = (EditText) findViewById(R.id.FullName);
        e2 = (EditText) findViewById(R.id.EmailAddress);
        GoToRegistration = (TextView) findViewById(R.id.GoToRegistation);
        signin = (ImageView) findViewById(R.id.ImgSign);



        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");

        t1.setTypeface(typeface3);
        t2.setTypeface(typeface3);
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

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginUser();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        //////******** FACEBOOK LOGIN *******////////////

        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email", "public_profile");


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Log.i(TAG,"Hello"+loginResult.getAccessToken().getToken());

                handleFacebookAccessToken(loginResult.getAccessToken());
                String userID = loginResult.getAccessToken().getUserId();
                progressDialog.setMessage("Please Wait....");
                progressDialog.show();

            }



            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });




        mAuthListener  = new FirebaseAuth.AuthStateListener(){


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user!=null){
                    name = user.getDisplayName();
                    Log.d("name" , name.toString());
                    Toast.makeText(LoginActivity.this,""+user.getDisplayName(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(LoginActivity.this,"something went wrong",Toast.LENGTH_LONG).show();
                }


            }
        };

        /// TWITTER LOGIN///


        loginButton2.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Log.d(TAG, "twitterLogin:success" + result);
                handleTwitterSession(result.data);

            }

            @Override
            public void failure(TwitterException exception) {
                Log.w(TAG, "twitterLogin:failure", exception);
                //updateUI(null);
            }
        });


        /// LOGIN WITH GOOGLE ////

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this , new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

                    }
                } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();



    }




    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton2.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);

            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }
        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);

    }



    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            UID = currentUser.getUid();
            Intent i = new Intent(LoginActivity.this, Home.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        } else {
            // User is signed out
            Log.d(TAG, "onAuthStateChanged:signed_out");
        }


        //updateUI(currentUser);
    }

    


    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            String name = "";
                            String email = "";
                            UID = "";
                            String photo = "";
                            String phone = "";
                            if (user != null) {
                                name = user.getDisplayName();
                                email = user.getEmail();
                                UID = user.getUid();
                                photo = String.valueOf(user.getPhotoUrl());
                                phone = user.getPhoneNumber();

                            }





                            ModelClass  Mod = new ModelClass(name , email , UID , photo , phone);

                            firebaseDatabase.child(UID).setValue(Mod, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    if (databaseReference.equals(databaseError)){
                                        progressDialog.dismiss();
                                        //Toast.makeText(RegistrationActivity.this , "Error in Saving" , Toast.LENGTH_SHORT).show();
                                    }else {


                                        progressDialog.dismiss();
                                        Intent i = new Intent(LoginActivity.this , Home.class);
                                        startActivity(i);
                                    }

                                }
                            });



                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }

        ////////****** LOGIN WITH TWITTER **********///////////////

    private void handleTwitterSession(TwitterSession session) {
        Log.d(TAG, "handleTwitterSession:" + session);

        AuthCredential credential = TwitterAuthProvider.getCredential(
                session.getAuthToken().token,
                session.getAuthToken().secret);

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            String name = "";
                            String email = "";
                            UID = "";
                            String photo = "";
                            String phone = "";
                            if (user != null) {
                                name = user.getDisplayName();
                                email = user.getEmail();
                                UID = user.getUid();

                                photo = String.valueOf(user.getPhotoUrl());
                                phone = user.getPhoneNumber();

                            }

                            ModelClass  Mod = new ModelClass(name , email , UID , photo , phone);
                            firebaseDatabase.child(UID).setValue(Mod, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    if (databaseReference.equals(databaseError)){
                                        progressDialog.dismiss();
                                        //Toast.makeText(RegistrationActivity.this , "Error in Saving" , Toast.LENGTH_SHORT).show();
                                    }else {


                                        progressDialog.dismiss();
                                        Intent i = new Intent(LoginActivity.this , Home.class);
                                        startActivity(i);
                                    }

                                }
                            });


//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }


    ///////// ******** LOGIN WITH GOOGLE *************/////////


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            String name = "";
                            String email = "";
                            UID = "";
                            String photo = "";
                            String phone = "";
                            if (user != null) {
                                name = user.getDisplayName();
                                email = user.getEmail();
                                UID = user.getUid();
                                photo = String.valueOf(user.getPhotoUrl());
                                phone = user.getPhoneNumber();

                            }

                            ModelClass  Mod = new ModelClass(name , email , UID , photo , phone);
                            firebaseDatabase.child(UID).setValue(Mod, new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                    if (databaseReference.equals(databaseError)){
                                        progressDialog.dismiss();
                                        //Toast.makeText(RegistrationActivity.this , "Error in Saving" , Toast.LENGTH_SHORT).show();
                                    }else {


                                        progressDialog.dismiss();
                                        Intent i = new Intent(LoginActivity.this , Home.class);
                                        startActivity(i);
                                    }

                                }
                            });




//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    ///// LOGIN WITH LINKDIN //////

    private void handleLogin(){
        LISessionManager.getInstance(getApplicationContext()).init(this, buildScope(), new AuthListener() {
            @Override
            public void onAuthSuccess() {
                // Authentication was successful.  You can now do
                // other calls with the SDK.
//                imgLogin.setVisibility(View.GONE);
//                btnLogout.setVisibility(View.VISIBLE);
//                imgProfile.setVisibility(View.VISIBLE);
//                txtDetails.setVisibility(View.VISIBLE);
                fetchPersonalInfo();
            }

            @Override
            public void onAuthError(LIAuthError error) {
                // Handle authentication errors
                Log.e("NIKHIL",error.toString());
            }
        }, true);
    }

    // Build the list of member permissions our LinkedIn session requires
    private static Scope buildScope() {
        return Scope.build(Scope.R_BASICPROFILE, Scope.W_SHARE, Scope.R_EMAILADDRESS);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // Add this line to your existing onActivityResult() method
//        LISessionManager.getInstance(getApplicationContext()).onActivityResult(this, requestCode, resultCode, data);
//    }

    private void fetchPersonalInfo(){
        String url = "https://api.linkedin.com/v1/people/~:(id,first-name,last-name,public-profile-url,picture-url,email-address,picture-urls::(original))";

        APIHelper apiHelper = APIHelper.getInstance(getApplicationContext());
        apiHelper.getRequest(this, url, new ApiListener() {
            @Override
            public void onApiSuccess(ApiResponse apiResponse) {
                // Success!
                try {
                    JSONObject jsonObject = apiResponse.getResponseDataAsJson();
                    String firstName = jsonObject.getString("firstName");
                    String lastName = jsonObject.getString("lastName");
                    String pictureUrl = jsonObject.getString("pictureUrl");
                    String id = jsonObject.getString("id");
                    String emailAddress = jsonObject.getString("emailAddress");

                  //  Picasso.with(getApplicationContext()).load(pictureUrl).into(imgProfile);

//                    StringBuilder sb = new StringBuilder();
//                    sb.append("First Name: "+firstName);
//                    sb.append("\n\n");
//                    sb.append("Last Name: "+lastName);
//                    sb.append("\n\n");
//                    sb.append("Email: "+emailAddress);
                   // txtDetails.setText(sb);

                   Log.d("CHECK" , id+ " "+ firstName + lastName + pictureUrl + emailAddress);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onApiError(LIApiError liApiError) {
                // Error making GET request!
                Log.e("NIKHIL",liApiError.getMessage());
            }
        });
    }





    ///////// ******* SIGN IN WITH EMAIL **********///////////////

    public void LoginUser(){

        String email = e1.getText().toString().trim();
        String pass = e2.getText().toString().trim();
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email , pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

              //  Toast.makeText(LoginActivity.this , "Successfully login" , Toast.LENGTH_LONG).show();

                UID =  firebaseAuth.getCurrentUser().getUid();
                //CheckUser();

            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {


                Intent intent = new Intent(LoginActivity.this , Home.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this , "Successfully login" , Toast.LENGTH_LONG).show();
                progressDialog.cancel();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this , "Failed login" , Toast.LENGTH_LONG).show();
                progressDialog.cancel();


            }
        });



    }

    @Override
    public void onClick(View view) {
        if (view == fb) {
            loginButton.performClick();
        }else if (view == twitter){

            loginButton2.performClick();
        }else if (view == google){

            signIn();
        }else if ( view == Linkedin){

            handleLogin();
        }
    }
}
