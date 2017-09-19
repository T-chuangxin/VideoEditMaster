package com.tian.video.editer.activity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import com.tian.video.editer.R;
import com.tian.video.editer.broadcast.NetReceiver;
import com.tian.video.editer.fragment.VideoFragment;
import com.tian.video.editer.fragment.HomeFragemnt;
import com.tian.video.editer.fragment.NewsFragment;
import com.tian.video.editer.fragment.ProfilFragment;
import com.tian.video.editer.skin.base.SkinBaseActivity;
import com.tian.video.editer.widget.BottomNavigationViewHelper;


public class MainActivity extends SkinBaseActivity {

    private static final String KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID = "KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(mHomeFragment);
                    break;
                case R.id.navigation_dashboard:
                    showFragment(mVideoFragment);
                    break;
                case R.id.navigation_notifications:
                    showFragment(mNewsFragment);
                    break;
                case R.id.navigation_my:
                    showFragment(mProfilFragment);
                    break;
            }
            ft.commit();
            return true;
        }

    };
    private HomeFragemnt mHomeFragment;
    private VideoFragment mVideoFragment;
    private NewsFragment mNewsFragment;
    private ProfilFragment mProfilFragment;
    private BottomNavigationView navigation;
    private NetReceiver mNetReceiver;//网络状态监听广播
    private DisplayMetrics metrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        initView();
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        initFragments(savedInstanceState);

        if (savedInstanceState != null) {
            int id = savedInstanceState.getInt(KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID, R.id.navigation_home);
            switch (id) {
                case R.id.navigation_home:
                    showFragment(mHomeFragment);
                    break;
                case R.id.navigation_dashboard:
                    showFragment(mVideoFragment);
                    break;
                case R.id.navigation_notifications:
                    showFragment(mNewsFragment);
                    break;
                case R.id.navigation_my:
                    showFragment(mProfilFragment);
                    break;
            }
        } else {
            showFragment(mHomeFragment);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID, navigation.getSelectedItemId());
        FragmentManager fm = getSupportFragmentManager();
        if (mHomeFragment.isAdded()) {
            fm.putFragment(outState, HomeFragemnt.class.getSimpleName(), mHomeFragment);
        }
        if (mVideoFragment.isAdded()) {
            fm.putFragment(outState, VideoFragment.class.getSimpleName(), mVideoFragment);
        }
        if (mNewsFragment.isAdded()) {
            fm.putFragment(outState, NewsFragment.class.getSimpleName(), mNewsFragment);
        }
        if (mProfilFragment.isAdded()) {
            fm.putFragment(outState, ProfilFragment.class.getSimpleName(), mProfilFragment);
        }

    }

    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        if (fragment instanceof HomeFragemnt) {
            fm.beginTransaction()
                    .show(mHomeFragment)
                    .hide(mVideoFragment)
                    .hide(mNewsFragment)
                    .hide(mProfilFragment)
                    .commit();

        } else if (fragment instanceof VideoFragment) {
            fm.beginTransaction()
                    .show(mVideoFragment)
                    .hide(mHomeFragment)
                    .hide(mNewsFragment)
                    .hide(mProfilFragment)
                    .commit();
        } else if (fragment instanceof NewsFragment) {
            fm.beginTransaction()
                    .show(mNewsFragment)
                    .hide(mHomeFragment)
                    .hide(mVideoFragment)
                    .hide(mProfilFragment)
                    .commit();
        }else if(fragment instanceof ProfilFragment){
            fm.beginTransaction()
                    .show(mProfilFragment)
                    .hide(mHomeFragment)
                    .hide(mVideoFragment)
                    .hide(mNewsFragment)
                    .commit();
        }
    }




    /**
     * 初始化Fragemnt
     * @param savedInstanceState
     */
    private void initFragments(Bundle savedInstanceState) {

        FragmentManager fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            mHomeFragment = HomeFragemnt.newInstance();
            mVideoFragment = VideoFragment.newInstance();
            mNewsFragment= NewsFragment.newInstance();
            mProfilFragment = ProfilFragment.newInstance();
        } else {
            mHomeFragment = (HomeFragemnt) fm.getFragment(savedInstanceState, HomeFragemnt.class.getSimpleName());
            mVideoFragment = (VideoFragment) fm.getFragment(savedInstanceState, VideoFragment.class.getSimpleName());
            mNewsFragment = (NewsFragment) fm.getFragment(savedInstanceState, NewsFragment.class.getSimpleName());
            mProfilFragment = (ProfilFragment) fm.getFragment(savedInstanceState, ProfilFragment.class.getSimpleName());
        }

        if (!mHomeFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mHomeFragment, HomeFragemnt.class.getSimpleName())
                    .commit();
        }

        if (!mVideoFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mVideoFragment, VideoFragment.class.getSimpleName())
                    .commit();

        }

        if (!mNewsFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mNewsFragment, NewsFragment.class.getSimpleName())
                    .commit();
        }

        if (!mProfilFragment.isAdded()) {
            fm.beginTransaction()
                    .add(R.id.container, mProfilFragment, ProfilFragment.class.getSimpleName())
                    .commit();
        }


    }

    /**
     * 初始化页面控件
     */
    private void initView() {
        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked}
        };

        int[] colors = new int[]{getResources().getColor(R.color.common_unselect_color),
                getResources().getColor(R.color.common_select_color)
        };
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ColorStateList csl = new ColorStateList(states, colors);
        navigation.setItemTextColor(csl);
        navigation.setItemIconTintList(csl);
        LinearLayout rootView=(LinearLayout)this.findViewById(R.id.ll_main_root_view);
        FrameLayout contenterView=(FrameLayout)this.findViewById(R.id.container);

//        dynamicAddSkinEnableView(navigation, "background", R.color.colorPrimary);
        dynamicAddSkinEnableView(rootView, "background", R.color.common_color);
        dynamicAddSkinEnableView(contenterView, "background", R.color.colorPrimary);



    }












}
