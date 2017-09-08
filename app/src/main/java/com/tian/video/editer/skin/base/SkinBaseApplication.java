package com.tian.video.editer.skin.base;

import android.app.Application;

import com.tian.video.editer.skin.factory.SkinManager;


/**
 * Created TCX
 * Time:10:54
 * <p>
 * 换肤管理类在application中初始化
 * <p/>
 *
 */
public class SkinBaseApplication extends Application {

    public void onCreate() {
        super.onCreate();

        initSkinLoader();
    }

    /**
     * Must call init first
     */
    private void initSkinLoader() {
        SkinManager.getInstance().init(this);
        SkinManager.getInstance().load();
    }
}
