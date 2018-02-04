package com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Interfaces.HomeView;
import com.example.rednone.androidmvpincludingmoxy.PresentationLayer.Home.Presenters.HomePresenter;
import com.example.rednone.androidmvpincludingmoxy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends MvpAppCompatActivity implements HomeView {

    @InjectPresenter
    HomePresenter homePresenter;

    @BindView(R.id.homeNavigation)
    BottomNavigationView bottomBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            homePresenter.itemSelected(item.getItemId());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void setActiveFragment(int menuId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment selectedFragment = null;
        switch (menuId) {
            case R.id.navigation_posts:
                selectedFragment = new PostsFragment();
                break;
            case R.id.navigation_users:
                selectedFragment = new UsersFragment();
                break;
        }
        transaction.replace(R.id.homeConteiner, selectedFragment);
        transaction.commit();
    }
}
