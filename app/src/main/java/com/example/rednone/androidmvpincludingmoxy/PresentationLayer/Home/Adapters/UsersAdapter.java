package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.UserModel;
import com.example.rednone.androidmvpincludingmoxy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RedNone on 28.01.2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    List<UserModel> users;

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public List<UserModel> getData() {
        return users;
    }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_cell, parent, false);
        return new UsersAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserModel model = users.get(position);
        holder.emailView.setText(model.getEmail());
        holder.nameView.setText(model.getName());
        holder.phoneView.setText(model.getPhone());
        holder.websiteView.setText(model.getWebsite());
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewEmailContainer)
        TextView emailView;
        @BindView(R.id.textViewNameContainer)
        TextView nameView;
        @BindView(R.id.textViewPhoneContainer)
        TextView phoneView;
        @BindView(R.id.textViewWebsiteContainer)
        TextView websiteView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
