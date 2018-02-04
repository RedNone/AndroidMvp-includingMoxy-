package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by RedNone on 21.01.2018.
 */

@StateStrategyType(SingleStateStrategy.class)
public interface HomeView extends MvpView {
    void setActiveFragment(int menuId);
}
