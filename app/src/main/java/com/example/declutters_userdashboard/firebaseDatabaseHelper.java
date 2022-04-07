package com.example.declutters_userdashboard;
import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class firebaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceUser;
    private List<RequestedUser> rqusers = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<RequestedUser> users, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public firebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceUser = mDatabase.getReference("Users");
    }

    public void readUser(final DataStatus dataStatus){
        mReferenceUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rqusers.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    RequestedUser rquser = keyNode.getValue(RequestedUser.class);
                    rqusers.add(rquser);
                }
                dataStatus.DataIsLoaded(rqusers,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
