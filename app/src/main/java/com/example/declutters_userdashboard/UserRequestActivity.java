package com.example.declutters_userdashboard;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserRequestActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_request);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyleview_users);
        new firebaseDatabaseHelper().readUser(new firebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<RequestedUser> users, List<String> keys) {
                new RecycleView_Config().setConfig(mRecyclerView,UserRequestActivity.this,users,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });




    }
}