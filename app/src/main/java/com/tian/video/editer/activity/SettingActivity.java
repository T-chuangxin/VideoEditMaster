package com.tian.video.editer.activity;


import android.content.Intent;
import android.widget.TextView;

import com.tian.video.editer.R;

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


    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void getInitData() {
        mTitle.setText("设置");



    }


    @OnClick(R.id.rl_change_skin)
    public void changSkin(){
        startActivity(new Intent(this,SkinsActivity.class));
    }




}
