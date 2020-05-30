package com.test.netmartdeliverer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText emailRegister, usernameRegister, passRegister, phoneNumRegister;
    TextView loginBtn, googleLoginRegister;
    Button btnRegister;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    String Userid;
    FirebaseFirestore fStore;

    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailRegister       = findViewById(R.id.emailRegister);
        usernameRegister    = findViewById(R.id.usernameRegister);
        passRegister        = findViewById(R.id.passRegister);
        phoneNumRegister    = findViewById(R.id.phoneNumRegister);
        loginBtn            = findViewById(R.id.loginBtn);
        googleLoginRegister = findViewById(R.id.googleLoginRegister);
        btnRegister         = findViewById(R.id.btnRegister);
        progressBar         = findViewById(R.id.progressBarRegister);


        firebaseAuth = FirebaseAuth.getInstance();


        //if user is logged in, redirect them to mainactivity
        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailRegister.getText().toString().trim();
                String password = usernameRegister.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailRegister.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passRegister.setError("Password is Required");
                    return;
                }

                if(password.length() < 6){
                    passRegister.setError("Password Must Be At Least 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                //register the user in firebase
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            //send verification link
                            FirebaseUser forgotuser = firebaseAuth.getCurrentUser();
                            forgotuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(RegisterActivity.this, "Verification Email Link Is Sent", Toast.LENGTH_SHORT).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Email is not Sent " + e.getMessage());
                                }
                            });


                            Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            Userid = firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("Users").document(Userid);
                            Map<String, Object> user = new HashMap<>();
                            user.put("Username", usernameRegister);
                            user.put("Email", emailRegister);
                            user.put("Phone", phoneNumRegister);
                          
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: User profile is created" + Userid);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });


        //login button for registered user
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        //login/signup with google instead
        googleLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GoogleLoginActivity.class));
            }
        });
    }
}
