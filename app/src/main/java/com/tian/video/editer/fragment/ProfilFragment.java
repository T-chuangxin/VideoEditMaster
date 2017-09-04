package com.tian.video.editer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwzt.shian.R;
import com.jwzt.shian.activity.DownPagerActivity;
import com.jwzt.shian.activity.SettingActivity;


public class ProfilFragment extends Fragment implements View.OnClickListener {


    private View view;
    private CollapsingToolbarLayout ctl_title;
    private Toolbar tool_title;

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
        initView();
        initData();
        return view;
    }


    private void initView(){

        ctl_title = (CollapsingToolbarLayout)view.findViewById(R.id.ctl_title);
        tool_title = (Toolbar)view.findViewById(R.id.tl_title);

        view.findViewById(R.id.iv_setting).setOnClickListener(this);

        view.findViewById(R.id.rl_outline).setOnClickListener(this);



    }



    private void initData(){
        tool_title.setTitle("");
//        ((MainActivity)getActivity()).setSupportActionBar(tool_title);

//        ctl_title.setCollapsedTitleGravity(Gravity.CENTER);
//        ctl_title.setExpandedTitleGravity(Gravity.CENTER);
//        ctl_title.setTitle("标题");
//        ctl_title.setExpandedTitleColor(Color.BLACK);
//        ctl_title.setCollapsedTitleTextColor(Color.BLACK);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv_setting://设置
                Intent intent=new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_outline://离线缓存
                startActivity(new Intent(getActivity(),DownPagerActivity.class));

                break;
        }



    }
}
