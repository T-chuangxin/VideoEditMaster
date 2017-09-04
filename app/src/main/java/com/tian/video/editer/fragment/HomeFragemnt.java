package com.tian.video.editer.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwzt.shian.R;


public class HomeFragemnt extends Fragment {


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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragemnt_home, container, false);
    }



}
