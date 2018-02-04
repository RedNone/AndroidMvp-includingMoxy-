package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Adapters;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PostModel;
import com.example.rednone.androidmvpincludingmoxy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RedNone on 21.01.2018.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    List<PostModel> posts;

    public void setPosts(List<PostModel> posts) {
        this.posts = posts;
    }

    public List<PostModel> getData() {
        return posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel model = posts.get(position);

        holder.titleView.setText(model.getTitle());
        holder.descriptionView.setText(model.getBody());
    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.postsCell)
        ConstraintLayout layoutView;
        @BindView(R.id.postTitleView)
        TextView titleView;
        @BindView(R.id.postDescriptionView)
        TextView descriptionView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
