package com.tian.video.editer.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tian.video.editer.R;
import com.tian.video.editer.activity.MainActivity;
import com.tian.video.editer.activity.SettingActivity;
import com.tian.video.editer.skin.base.SkinBaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.tian.video.editer.R.id.ctl_title;


public class ProfilFragment extends SkinBaseFragment {


    @InjectView(R.id.ctl_title)
    CollapsingToolbarLayout ctlTitle;
    @InjectView(R.id.tl_title)
    Toolbar toolTitle;




    private View view;


    public ProfilFragment() {
        // Required empty public constructor
    }


    public static ProfilFragment newInstance() {
        ProfilFragment fragment = new ProfilFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profil, container, false);
        ButterKnife.inject(this,view);
        initData();
        return view;
    }





    @OnClick(R.id.iv_profile_setting)
    public void setting(View view){
//        switch (view.getId()){
//            case R.id.iv_profile_setting:
                startActivity(new Intent(getActivity(),SettingActivity.class));
//                break;
//
//
//        }
    }






    private void initData(){
//        mTitle.setText(R.string.title_my);
//        ((MainActivity)getActivity()).setSupportActionBar(toolTitle);
//
//        ctlTitle.setCollapsedTitleGravity(Gravity.CENTER);
//        ctlTitle.setExpandedTitleGravity(Gravity.CENTER);
//        ctlTitle.setTitle("标题");
//        ctlTitle.setExpandedTitleColor(Color.BLACK);
//        ctlTitle.setCollapsedTitleTextColor(Color.BLACK);
    }



}
