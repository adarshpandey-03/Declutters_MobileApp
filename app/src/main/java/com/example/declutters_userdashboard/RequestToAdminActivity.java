package com.example.declutters_userdashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestToAdminActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    double amountperkg;

    double totalweight;
    String type;

    Spinner garbagetypespinner;
    TextView amountperkgview;
    TextView totalamountview;
    EditText weight;

    Button btn_calculate;
    Button btn_sendrequest;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_to_admin);

        garbagetypespinner = (Spinner) findViewById(R.id.garbagetypespinner);
        amountperkgview = (TextView) findViewById(R.id.amountperkg);
        totalamountview = (TextView) findViewById(R.id.totalAmount);
        weight = (EditText) findViewById(R.id.weight);
        btn_calculate = (Button) findViewById(R.id.btnCalculate);
        btn_sendrequest = (Button) findViewById(R.id.btnsendrequest);
        databaseReference = FirebaseDatabase.getInstance().getReference("Request");
        firebaseAuth = FirebaseAuth.getInstance();

        garbagetypespinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(RequestToAdminActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.garbageType));

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        garbagetypespinner.setAdapter(spinnerAdapter);

        btn_calculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                totalweight = Double.parseDouble(weight.getText().toString().trim());
                totalamountview.setText(Double.toString(amountperkg*totalweight));
            }
        });


        btn_sendrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = "Pending";

                RequestData rqdata = new RequestData(String.valueOf(totalweight),String.valueOf(amountperkg*totalweight),type, status);

                FirebaseDatabase.getInstance().getReference("Request")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(rqdata).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(RequestToAdminActivity.this, "Your Request is send",Toast.LENGTH_LONG);
                        startActivity(new Intent(getApplicationContext(),UserDashboardActivity.class));
                    }


            });
        }

    });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        type = adapterView.getItemAtPosition(i).toString().trim().toLowerCase();
        if(type.equals("plastic")){
            amountperkg = 20.00;
            amountperkgview.setText(Double.toString(amountperkg));
        }
        if(type.equals("paper")){
            amountperkg = 10.00;
            amountperkgview.setText(Double.toString(amountperkg));
        }
        if(type.equals("steel")){
            amountperkg = 60.00;
            amountperkgview.setText(Double.toString(amountperkg));
        }
        if(type.equals("copper")){
            amountperkg = 80.00;
            amountperkgview.setText(Double.toString(amountperkg));
        }
        if(type.equals("rubber")){
            amountperkg = 20.00;
            amountperkgview.setText(Double.toString(amountperkg));
        }
        if(type.equals("other")){
            amountperkg = 10.00;
            amountperkgview.setText(Double.toString(amountperkg));
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(RequestToAdminActivity.this, "Please Fill Required Details",Toast.LENGTH_LONG);

    }
}
