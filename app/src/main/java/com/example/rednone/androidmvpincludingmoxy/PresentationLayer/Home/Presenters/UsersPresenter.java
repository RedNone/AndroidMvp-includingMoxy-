package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Managers.ApiManager;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.UserModel;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces.UsersView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RedNone on 27.01.2018.
 */
@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> {

    public UsersPresenter() {
        getViewState().showLoading(false);
        loadUsers(false);
    }

    public void loadUsers(final boolean pullToRefresh) {
        ApiManager.getInstance().getUsers(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, final Response<List<UserModel>> response) {
                getViewState().setData(response.body());
                getViewState().showContent();
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, final Throwable t) {
                getViewState().showError(t, pullToRefresh);
            }
        });
    }
}
