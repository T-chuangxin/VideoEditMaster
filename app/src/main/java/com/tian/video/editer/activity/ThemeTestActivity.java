package com.tian.video.editer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.tian.video.editer.R;
import com.tian.video.editer.skin.base.SkinBaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 项目名称：VideoEditMaster
 * 类描述：主题切换测试类
 * 创建人：TCX
 * 创建时间：2017/9/8 11:32
 * 修改人：TCX
 * 修改备注：
 */

public class ThemeTestActivity extends SkinBaseActivity {


    @InjectView(R.id.rl_root_view)
    RelativeLayout mRootView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_test);


    }

    @OnClick({R.id.theme1,R.id.theme2,R.id.theme3})
    public void onclick(View view){

        switch (view.getId()){
            case R.id.theme1:


                break;
            case R.id.theme2:


                break;
            case R.id.theme3:




                break;



        }



    }



}
