package com.tian.video.editer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tian.video.editer.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * 首页Fragment
 */
public class HomeFragemnt extends Fragment {


    @InjectView(R.id.tv_title_title)
    AppCompatTextView mTitle;



    public HomeFragemnt() {
        // Required empty public constructor
    }


    public static HomeFragemnt newInstance() {
        HomeFragemnt fragment = new HomeFragemnt();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this,view);
        initData();
        return view;
    }


    /**
     * 初始化页面控件
     */
    private void initData() {

        mTitle.setText(R.string.title_home);


    }


}
