package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Presenters;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces.HomeView;
import com.example.rednone.androidmvpincludingmoxy.R;

/**
 * Created by RedNone on 21.01.2018.
 */

@InjectViewState
public class HomePresenter extends MvpPresenter<HomeView>{

    public HomePresenter() {
        getViewState().replacePostsFragment();
    }

    public void itemSelected(final int itemId) {
        switch (itemId) {
            case R.id.navigation_posts:
                getViewState().replacePostsFragment();
                break;
            case R.id.navigation_users:
                getViewState().replaceUsersFragment();
                break;
            default:
                break;
        }
    }
}
