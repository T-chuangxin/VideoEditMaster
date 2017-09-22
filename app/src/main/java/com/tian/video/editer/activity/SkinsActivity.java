package com.tian.video.editer.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tian.video.editer.R;
import com.tian.video.editer.adapter.SkinListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 项目名称：VideoEditMaster
 * 类描述：
 * 创建人：TCX
 * 创建时间：2017/9/19 17:17
 * 修改人：TCX
 * 修改备注：
 */

class SkinsActivity extends BaseActivity{

    @InjectView(R.id.rlv_skin_list)
    RecyclerView mRecyclerView;
    @InjectView(R.id.tv_title_title)
    TextView mTitle;

    private List<String> mItemList=new ArrayList<String>();



    @Override
    public int getLayoutId() {
        return R.layout.activity_skins_list;
    }

    @Override
    public void getInitData() {

        ButterKnife.inject(this);
        mTitle.setText("主题设置");

        mItemList.add("蓝色");
        mItemList.add("棕色");


        //设置默认的条目分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //设置布局的样式（单列或者网格）
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

        //默认动画样式
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(new SkinListAdapter(this,mItemList));


    }


    @OnClick(R.id.ll_title_left_btn)
    public void actions(View view){
        switch (view.getId()){
            case R.id.ll_title_left_btn:
                finish();
                break;


        }
    }





}
