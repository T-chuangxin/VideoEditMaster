package com.tian.video.editer.activity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tian.video.editer.R;
import com.tian.video.editer.skin.base.SkinBaseActivity;
import com.tian.video.editer.skin.factory.SkinManager;
import com.tian.video.editer.skin.inter.ILoaderListener;

import java.io.File;

import butterknife.ButterKnife;
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
    @InjectView(R.id.rl_title_root)
    RelativeLayout titleBg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_test);
        ButterKnife.inject(this);

//        RelativeLayout titleBg=(RelativeLayout)this.findViewById(R.id.rl_title_root);
//        RelativeLayout mRootView=(RelativeLayout)this.findViewById(R.id.rl_root_view);


        dynamicAddSkinEnableView(titleBg, "background", R.color.colorPrimary);
        dynamicAddSkinEnableView(mRootView, "background", R.color.colorPrimary);
//        dynamicAddSkinEnableView(mNavigationView, "navigationViewMenu", R.color.colorPrimary);




    }

    @OnClick({R.id.theme1,R.id.theme2,R.id.theme3})
    public void onclick(View view){

        switch (view.getId()){
            case R.id.theme1:
                String skinFullName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "skin_brown.skin";
//                FileUtils.moveRawToDir(getMContext(), "skin_brown.skin", skinFullName);//将根目录下的皮肤文件copy到sd卡
                File skin = new File(skinFullName);
                if (!skin.exists()) {
                    Toast.makeText(this, "请检查" + skinFullName + "是否存在", Toast.LENGTH_SHORT).show();
                    return;
                }
                SkinManager.getInstance().load(skin.getAbsolutePath(),
                        new ILoaderListener() {
                            @Override
                            public void onStart() {
                                Log.e("load_skin_start===", "loadSkinStart");
                            }

                            @Override
                            public void onSuccess() {
                                Log.i("load_skin_Success===", "loadSkinSuccess");
                                Toast.makeText(ThemeTestActivity.this, "切换成功", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailed() {
                                Log.i("load_skin_failed===", "loadSkinFail");
                                Toast.makeText(ThemeTestActivity.this, "切换失败", Toast.LENGTH_SHORT).show();
                            }
                        });

                break;
            case R.id.theme2:


                break;
            case R.id.theme3:




                break;



        }



    }



}
