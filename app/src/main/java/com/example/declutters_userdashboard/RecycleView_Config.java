package com.example.declutters_userdashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecycleView_Config {
    private Context mContext;
    private UsersAdapter mUserAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<RequestedUser> users, List<String> keys){
        mContext = context;
        mUserAdapter = new UsersAdapter(users, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mUserAdapter);
    }

    class UserView extends RecyclerView.ViewHolder {
        private TextView mUser;
        private TextView mfName;
        private TextView mlName;
        private TextView mstatus;
        private TextView garbagetype;
        private TextView weight;
        private TextView address;
        private TextView amount;

        private String key;

        public UserView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.user_list_item,parent,false));

            mUser = (TextView) itemView.findViewById(R.id.userNumber);
            mfName = (TextView) itemView.findViewById(R.id.fName);
            mlName = (TextView) itemView.findViewById(R.id.lName);
            mstatus = (TextView) itemView.findViewById(R.id.status);
            garbagetype = (TextView) itemView.findViewById(R.id.wasteType);
            weight = (TextView) itemView.findViewById(R.id.totalweight);
            address = (TextView) itemView.findViewById(R.id.address);
            amount = (TextView) itemView.findViewById(R.id.totalAmount);

        }

        public void bind(RequestedUser user, String key){
           mfName.setText(user.getfName());
           mlName.setText(user.getLastName());
           address.setText(user.getAddress());
            this.key = key;
        }



    }
    class UsersAdapter extends RecyclerView.Adapter<UserView> {
        private List<RequestedUser> mUserList;
        private List<String> mkeys;

        public UsersAdapter(List<RequestedUser> mUserList, List<String> mkeys) {
            this.mUserList = mUserList;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new UserView((parent));
        }

        @Override
        public void onBindViewHolder(@NonNull UserView holder, int position) {
            holder.bind(mUserList.get(position),mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mUserList.size();
        }
    }
}
