package com.tian.video.editer.skin.inter;

/**
 * Created by TCX
 * Time:21:07
 * <p>
 * 加载皮肤时的回调接口
 */
public interface ILoaderListener {
    void onStart();

    void onSuccess();

    void onFailed();
}
