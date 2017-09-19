package com.tian.video.editer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tian.video.editer.R;
import com.tian.video.editer.skin.base.SkinBaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends SkinBaseFragment {



    @InjectView(R.id.tv_title_title)
    AppCompatTextView mTitle;
    @InjectView(R.id.ll_title_left_btn)
    LinearLayout leftBtn;
    @InjectView(R.id.rl_title_root)
    RelativeLayout titleBg;



    public NewsFragment() {
        // Required empty public constructor
    }


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.inject(this,view);

        initData();
        return view;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mTitle.setText(R.string.title_notifications);

        leftBtn.setVisibility(View.INVISIBLE);

        dynamicAddSkinView(titleBg,"background", R.color.common_color);//头部主题样式


    }

}
