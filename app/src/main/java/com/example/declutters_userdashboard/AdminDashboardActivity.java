package com.example.declutters_userdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {
    Button btn_Profile,btn_userRequest,btn_frwdRequest,btn_manageData,btn_paymentPending,btn_weeklyReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        btn_Profile = (Button)findViewById(R.id.buttonProfile1);
        btn_userRequest = (Button)findViewById(R.id.buttonProfile2);
        btn_frwdRequest = (Button)findViewById(R.id.buttonProfile3);
        btn_manageData = (Button)findViewById(R.id.buttonProfile4);
        btn_paymentPending = (Button)findViewById(R.id.buttonProfile5);
        btn_weeklyReport = (Button)findViewById(R.id.buttonProfile6);

        btn_userRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),UserRequestActivity.class));
            }
        });

    }
}
