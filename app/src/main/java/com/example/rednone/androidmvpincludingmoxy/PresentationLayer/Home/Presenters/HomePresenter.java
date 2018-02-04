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
        getViewState().setActiveFragment(R.id.navigation_posts);
    }

    public void itemSelected(final int itemId) {
        getViewState().setActiveFragment(itemId);
    }
}
