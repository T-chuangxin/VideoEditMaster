package com.tian.video.editer.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.tian.video.editer.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public  class PlaceholderFragment extends Fragment {


    @InjectView(R.id.section_img)
    ImageView mImageFlag;//中间图标


    @InjectView(R.id.section_label)
    AppCompatTextView mTextLabel;//文本标记


    @InjectView(R.id.section_intro)
    AppCompatTextView mTextDes;//文本描述

    @InjectView(R.id.fl_root_view)
    FrameLayout mRootView;//根布局


    private int mCurrentPagerNumber=0;

        public PlaceholderFragment() {
        }

        @SuppressLint("ValidFragment")
        public PlaceholderFragment(int pagerNumber){
            this.mCurrentPagerNumber=pagerNumber;

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_guide, container, false);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
//                localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//            }


            ButterKnife.inject(this,rootView);

            initData();
            return rootView;
        }

        /**
         * 初始化页面数据
         */
        private void initData() {

            switch (mCurrentPagerNumber){
                case 0:
                    mTextLabel.setText("当某天：");
                    mTextDes.setText("在你为自己踏踏实实的努力的时候！");
                    mImageFlag.setBackgroundResource(R.drawable.ic_home_black_24dp);
                    break;
                case 1:
                    mTextLabel.setText("你会发现：");
                    mTextDes.setText("那些你觉得从来不会看到的风景，那些你感觉从来不会遇到的人！");
                    mImageFlag.setBackgroundResource(R.drawable.ic_dashboard_black_24dp);
                    break;
                case 2:
                    mTextLabel.setText("悄悄的：");
                    mTextDes.setText("正一步步向你走来！");
                    mImageFlag.setBackgroundResource(R.drawable.ic_notifications_black_24dp);

                    break;
            }


        }
    }