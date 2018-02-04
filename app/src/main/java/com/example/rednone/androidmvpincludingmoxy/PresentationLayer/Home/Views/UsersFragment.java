package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Views;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.UserModel;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Adapters.UsersAdapter;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces.UsersView;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Presenters.UsersPresenter;
import com.example.rednone.androidmvpincludingmoxy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends MvpAppCompatFragment implements UsersView, SwipeRefreshLayout.OnRefreshListener {

    @InjectPresenter
    UsersPresenter usersPresenter;

    @BindView(R.id.contentView)
    SwipeRefreshLayout contentView;
    @BindView(R.id.errorView)
    TextView errorView;
    @BindView(R.id.loadingView)
    ProgressBar progressView;
    @BindView(R.id.usersRecyclerView)
    RecyclerView recyclerView;

    UsersAdapter adapter;

    public UsersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        contentView.setOnRefreshListener(this);

        adapter = new UsersAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        usersPresenter.loadUsers(true);
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

    @Override
    public void setData(List<UserModel> data) {
        adapter.setUsers(data);
        adapter.notifyDataSetChanged();
    }
}
