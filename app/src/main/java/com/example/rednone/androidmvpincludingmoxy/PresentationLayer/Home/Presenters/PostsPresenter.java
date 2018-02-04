package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Managers.ApiManager;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PostModel;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces.PostsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by RedNone on 21.01.2018.
 */
@InjectViewState
public class PostsPresenter extends MvpPresenter<PostsView> {

    public PostsPresenter() {
        getViewState().showLoading(false);
        loadPosts(false);
    }

    public void loadPosts(final boolean pullToRefresh) {
        ApiManager.getInstance().getPosts(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, final Response<List<PostModel>> response) {
                getViewState().showContent();
                getViewState().setData(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, final Throwable t) {
                getViewState().showError(t, pullToRefresh);
            }
        });
    }


}
