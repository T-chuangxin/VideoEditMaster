package com.tian.video.editer.activity;


import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tian.video.editer.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 项目名称：VideoEditMaster
 * 类描述：
 * 创建人：TCX
 * 创建时间：2017/9/19 16:40
 * 修改人：TCX
 * 修改备注：
 */

public class SettingActivity extends BaseActivity{


    @InjectView(R.id.tv_title_title)
    TextView mTitle;
    @InjectView(R.id.ll_setting_root_view)
    LinearLayout mSettingRootView;
    @InjectView(R.id.rl_title_root)
    RelativeLayout mTitleRootView;
    @InjectView(R.id.ll_setting_container)
    LinearLayout mSettingContainer;



    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void getInitData() {
        ButterKnife.inject(this);


        mTitle.setText("设置");

        Toast.makeText(this,"设置界面",Toast.LENGTH_SHORT).show();
        dynamicAddSkinEnableView(mSettingRootView, "background", R.color.common_color);
        dynamicAddSkinEnableView(mTitleRootView, "background", R.color.common_color);
        dynamicAddSkinEnableView(mSettingContainer, "background", R.color.common_color);




    }


    @OnClick(R.id.rl_change_skin)
    public void changSkin(){
        startActivity(new Intent(this,SkinsActivity.class));
    }




}
