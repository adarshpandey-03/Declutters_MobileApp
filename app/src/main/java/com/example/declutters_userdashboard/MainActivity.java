package com.example.declutters_userdashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    String loginId;
    String password;

    EditText loginInput;
    EditText passwordInput;
    private FirebaseAuth firebaseAuth;

    Button login_Btn;
    Button newUser_Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        loginInput = (EditText) findViewById(R.id.loginField);
        passwordInput = (EditText) findViewById(R.id.passwordField);
        login_Btn = (Button) findViewById(R.id.loginBtn);
        newUser_Btn = (Button) findViewById(R.id.newUserBtn);
        login_Btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                loginId = loginInput.getText().toString().trim();
                password = passwordInput.getText().toString().trim();

                if (TextUtils.isEmpty(loginId)) {
                    Toast.makeText(MainActivity.this, "Please Enter LoginId", Toast.LENGTH_LONG);
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_LONG);
                    return;
                }

                if (loginId.equals("admin@admin.com") && password.equals("admin123")) {
                    firebaseAuth.signInWithEmailAndPassword(loginId, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), AdminDashboardActivity.class));
                                    } else {
                                        Toast.makeText(MainActivity.this, "Please Enter Correct Credentials", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });


                } else {
                    firebaseAuth.signInWithEmailAndPassword(loginId, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
                                    } else {
                                        Toast.makeText(MainActivity.this, "Please Enter Correct Credentials", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }

                newUser_Btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                    }
                });
            }
        });
    }
}