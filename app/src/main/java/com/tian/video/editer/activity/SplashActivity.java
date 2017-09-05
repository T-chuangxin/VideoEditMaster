package com.tian.video.editer.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.AppCompatImageView;

import com.tian.video.editer.R;
import com.tian.video.editer.constant.SPConstants;
import com.tian.video.editer.utils.BitmapUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 项目名称：VideoEditMaster
 * 类描述：
 * 创建人：TCX
 * 创建时间：2017/9/5 9:20
 * 修改人：TCX
 * 修改备注：
 */

public class SplashActivity extends BaseActivity {


    private static final int JUMP_INTENT=0;

    private boolean isFirstLogin=true;


    private Handler mHandler=new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            switch (msg.what){
                case JUMP_INTENT:
                    if (isFirstLogin){
                        //跳转到引导界面
                    }else{
                        //跳转到主界面

                    }

//                    startActivity(new Intent(SplashActivity.this,));


                    break;




            }


        }
    };






    @InjectView(R.id.iv_splash_bg)
    AppCompatImageView sp_bg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void getInitData() {
        ButterKnife.inject(this);
        isFirstLogin=getSharedPreferences(SPConstants.SP_NAME_ISLOGIN_FIRST,MODE_PRIVATE).getBoolean(SPConstants.SP_ISLOGIN_FIRST_KEY,true);
        sp_bg.setImageBitmap(BitmapUtils.readBitMap(this,R.mipmap.ic_spash_bg));

        getConfigData();



    }

    /**
     * 配置数据接入
     */
    private void getConfigData() {







    }


}
