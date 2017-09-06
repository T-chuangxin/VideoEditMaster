package com.tian.video.editer.fragment;


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
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    @InjectView(R.id.tv_title_title)
    AppCompatTextView mTitle;

    private View view;

    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_course, container, false);

        ButterKnife.inject(this,view);

        initData();

        return view;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mTitle.setText(R.string.title_dashboard);


    }


}
