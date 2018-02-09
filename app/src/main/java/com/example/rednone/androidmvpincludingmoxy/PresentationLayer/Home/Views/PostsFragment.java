package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Views;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PostModel;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Adapters.PostsAdapter;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces.PostsView;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Presenters.PostsPresenter;
import com.example.rednone.androidmvpincludingmoxy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends MvpAppCompatFragment implements PostsView, SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    PostsPresenter postsPresenter;

    @BindView(R.id.postsRecyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.contentView)
    SwipeRefreshLayout contentView;
    @BindView(R.id.errorView)
    TextView errorView;
    @BindView(R.id.loadingView)
    ProgressBar progressView;

    PostsAdapter adapter;

    public PostsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        contentView.setOnRefreshListener(this);

        adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(List<PostModel> data) {
        adapter.setPosts(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
       postsPresenter.loadPosts(true);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        errorView.setText(e.getLocalizedMessage());
        progressView.setVisibility(View.INVISIBLE);
        contentView.setRefreshing(false);
    }

    @Override
    public void showContent() {
        errorView.setText("");
        contentView.setRefreshing(false);
        progressView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        progressView.setVisibility(View.VISIBLE);
        errorView.setText("");
    }
}
