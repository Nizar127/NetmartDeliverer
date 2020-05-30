package com.test.netmartdeliverer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class LoginActivity extends AppCompatActivity {

    EditText usernameLogin, passLogin;
    TextView resetPassBtn, registerBtn, googleLogin;
    Button btnLogin;
    ProgressBar progressBarLogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLogin    = findViewById(R.id.usernameLogin);
        passLogin        = findViewById(R.id.passLogin);
        resetPassBtn     = findViewById(R.id.resetPassBtn);
        registerBtn      = findViewById(R.id.registerBtn);
        googleLogin      = findViewById(R.id.googleLogin);
        btnLogin         = findViewById(R.id.btnLogin);
        progressBarLogin = findViewById(R.id.progressBarLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = usernameLogin.getText().toString().trim();
                String password = passLogin.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    usernameLogin.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    passLogin.setError("Password is Required");
                    return;
                }

                if(password.length() < 6){
                    passLogin.setError("Password Must Be At Least 6 Characters");
                    return;
                }

                progressBarLogin.setVisibility(View.VISIBLE);

                //login activity
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class))  ;
                        }else{
                            Toast.makeText(LoginActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBarLogin.setVisibility(View.GONE);

                        }
                    }
                });



            }
        });


        //forgot password
        resetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetEmail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Forgot Password ? Reset it here");
                passwordResetDialog.setMessage("Enter your email address to received link");
                passwordResetDialog.setView(resetEmail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract email link

                        String email = resetEmail.getText().toString();
                        fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(LoginActivity.this,"Reset Link To Your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this,"Error! Reset Link Not Sent " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });

        //go to register button for first time user
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        //go to google login instead
        googleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GoogleLoginActivity.class));
            }
        });
    }
}
