package com.tian.video.editer.http;

import android.util.Log;

import com.tian.video.editer.bean.CodeConfigBean;
import com.tian.video.editer.entity.HttpResult;
import com.tian.video.editer.inter.ConfigInterface;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class HttpMethods {

    public static final String BASE_URL = "http://ce.51yaoshi.com/";
    public static final String BASE_URL1 = "http://cache1.51yaoshi.com/";
    public static final String BASE_URL2 = " http://ce-exam.51yaoshi.com/";//考试
    public static final String COOKIE = "JXJYSSO=";
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private   static OkHttpClient.Builder builder;
    private  volatile static  HttpMethods INSTANCE;
    private String cookieStr="";


    private HttpMethods(final String cookie) {

        builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }




    public static HttpMethods getInstance(final String cookie) {
        if (INSTANCE == null) {
            synchronized (HttpMethods.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpMethods(cookie);
                }
            }
            return INSTANCE;
        }else{
            if (cookie!=null){
                    builder.addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                    .newBuilder()
                                    .header("Cookie", COOKIE + cookie)
                                    .build();
                            return chain.proceed(request);
                        }
                    }).build();

            }
            return INSTANCE;

        }

    }





    /**
     * 获取配置信息
     *
     * @param subscriber
     */
    public void getConfig(Subscriber<CodeConfigBean> subscriber) {

        RefrofitGsonParse();
        ConfigInterface mConfigInterface = retrofit.create(ConfigInterface.class);
        Observable observable = mConfigInterface.getConfigInfo()
                .map(new HttpResultFunc<CodeConfigBean>());
        toSubscribe(observable, subscriber);

    }





    /**
     * rxjava进行数据回调显示
     * @param o
     * @param s
     * @param <T>
     */
    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


    /**
     * 返回数据对象
     *
     * @param <T>
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            Log.e("httpResult=",httpResult.toString());
            if (httpResult == null || "".equals(httpResult)) {
                throw new ApiException(100);
            }
                return httpResult.getContent();
        }



    }



    /**
     * 返回不同类型的数据模型
     */
    private class HttpResultFunc1<SubHttpResult> implements Func1<SubHttpResult, SubHttpResult> {

        @Override
        public SubHttpResult call(SubHttpResult httpResult) {
            Log.e("=courseReturn=", httpResult.toString());
            if (httpResult == null || "".equals(httpResult)) {
                throw new ApiException(100);
            }
            return httpResult;
        }
    }


    /**
     * 返回结果解析结果
     */
    private void RefrofitGsonParse() {
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }


}
