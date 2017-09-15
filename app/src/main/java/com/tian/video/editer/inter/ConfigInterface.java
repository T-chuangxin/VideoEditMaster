package com.tian.video.editer.inter;



import com.tian.video.editer.bean.CodeConfigBean;
import com.tian.video.editer.entity.HttpResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * app配置信息 回调接口
 * Created by TCX on 2016/9/21.
 */
public interface ConfigInterface {

    @GET("app/conf/index.shtml")
    Observable<HttpResult<CodeConfigBean>> getConfigInfo();

}
