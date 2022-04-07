package com.example.declutters_userdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserDashboardActivity extends AppCompatActivity {

    Button profile;
    Button requestToAdmin;
    Button paymentConf;
    Button askHelp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        profile = (Button) findViewById(R.id.buttonProfile1);
        requestToAdmin = (Button) findViewById(R.id.buttonrequestAdmin);
        paymentConf = (Button) findViewById(R.id.buttonPaymentConf);
        askHelp = (Button) findViewById(R.id.buttonHelp);

        requestToAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RequestToAdminActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),UserProfileActivity.class));
            }
        });


        paymentConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TrackRequestActivity.class));
            }
        });
    }
}
