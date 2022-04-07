package com.example.declutters_userdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class UserProfileActivity extends AppCompatActivity {

    Button logout_btn;
    TextView firstNameV,lastNameV,addressView,loginIDView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    DatabaseReference dbref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        firstNameV = (TextView) findViewById(R.id.firstNameView);
        lastNameV = (TextView) findViewById(R.id.lastNameView);
        addressView = (TextView) findViewById(R.id.addressView);
        loginIDView = (TextView) findViewById(R.id.loginIDView);

        dbref = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String firstName = dataSnapshot.child("fName").getValue().toString();
            String lastName = dataSnapshot.child("lastName").getValue().toString();
            String address = dataSnapshot.child("address").getValue().toString();
            String emailID = dataSnapshot.child("emailId").getValue().toString();
            firstNameV.setText(firstName);
            lastNameV.setText(lastName);
            addressView.setText(address);
            loginIDView.setText(emailID);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        logout_btn = (Button) findViewById(R.id.logoutBtn);


    }




    }



