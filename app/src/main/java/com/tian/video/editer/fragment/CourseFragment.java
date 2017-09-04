package com.tian.video.editer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwzt.shian.R;
import com.jwzt.shian.activity.CourseDetialActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {


    private View view;

    public CourseFragment() {
        // Required empty public constructor
    }

    public static CourseFragment newInstance() {
        CourseFragment fragment = new CourseFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_course, container, false);

        initView();

        return view;
    }

    /**
     * 初始化页面控件
     */
    private void initView() {

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), CourseDetialActivity.class);
                startActivity(intent);
            }
        });




    }

}
