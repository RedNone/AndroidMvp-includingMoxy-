package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.rednone.androidmvpincludingmoxy.DataLayer.Models.PostModel;

import java.util.List;

/**
 * Created by RedNone on 04.02.2018.
 */
@StateStrategyType(SingleStateStrategy.class)
public interface BaseLCEInterface<Model> extends MvpView {
    void showLoading(boolean pullToRefresh);
    void showError(Throwable t, boolean pullToRefresh);
    void setData(List<Model> data);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showContent();
}
