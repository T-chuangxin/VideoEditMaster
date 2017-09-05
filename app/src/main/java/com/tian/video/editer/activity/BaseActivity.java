package com.tian.video.editer.activity;

import android.app.Dialog;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tian.video.editer.R;
import com.tian.video.editer.broadcast.NetReceiver;
import com.tian.video.editer.constant.NetConstant;
import com.tian.video.editer.inter.OnNetStateChangeListener;

import butterknife.ButterKnife;

/**
 * 项目名称：VideoEditMaster
 * 类描述：
 * 创建人：TCX
 * 创建时间：2017/9/1 9:32
 * 修改人：TCX
 * 修改备注：
 */
public abstract class BaseActivity extends AppCompatActivity implements OnNetStateChangeListener {

    private NetReceiver mNetReceiver;
    private IntentFilter mFilter;
    private Dialog dialog1;
    private DisplayMetrics mMetrics;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        super.setContentView(getLayoutId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }


        mNetReceiver = new NetReceiver();
        mNetReceiver.setNetStateChangeListener(this);
        mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        mMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);



        getInitData();
    }

    /**
     * 布局文件的
     * @return
     */
    public abstract int getLayoutId();

//    /**
//     * 初始化页面控件
//     */
//    public abstract void getInitView();



    /**
     * 初始化数据
     */
    public abstract void getInitData();







    /**
     * 获取焦点注册广播
     */
    @Override
    protected void onResume() {
        super.onResume();
       registerReceiver(mNetReceiver,mFilter);

    }


    /**
     * 失去焦点注销广播
     */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mNetReceiver);

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 网络状态监听回掉接口
     * @param netState
     */
    @Override
    public void OnNetStateChange(int netState) {
        switch (netState){
            case NetConstant.NET_NO:
                //无网的状态
                showNetErrorDialog(NetConstant.NET_NO);
                break;
            case NetConstant.NET_ETHERNET:
                //有线网络
                break;
            case NetConstant.NET_MOBILE:
                //移动网络
                showNetErrorDialog(NetConstant.NET_MOBILE);
                break;
            case NetConstant.NET_WIFI:
                //WiFi网络
                Toast.makeText(this,"当前为WIFI状态！",Toast.LENGTH_SHORT).show();

                break;

        }

    }

    /**
     * 网络状态异常dialog
     */
    private void showNetErrorDialog(final int netTpye) {
        dialog1 = new Dialog(this, R.style.dialog_style_default);
        View dialogView= View.inflate(this, R.layout.dialog_re_login, null);
        TextView title=(TextView)dialogView.findViewById(R.id.common_dialog_title) ;
        LinearLayout bottom=(LinearLayout)dialogView.findViewById(R.id.common_dialog_btn_layout);
        TextView leftBtn=(TextView)dialogView.findViewById(R.id.common_dialog_btn_left);
        TextView rightBtn=(TextView)dialogView.findViewById(R.id.common_dialog_btn_right);
        TextView centerBtn=(TextView)dialogView.findViewById(R.id.common_dialog_btn_center);


        switch (netTpye){
            case NetConstant.NET_NO:
                title.setText("网络连接异常");
                bottom.setVisibility(View.GONE);
                centerBtn.setVisibility(View.VISIBLE);
                centerBtn.setText("我知道了");
                break;
            case NetConstant.NET_MOBILE:
                title.setText("当前为移动网络状态！");
                bottom.setVisibility(View.VISIBLE);
                centerBtn.setVisibility(View.GONE);
                rightBtn.setText("继续");
                break;
        }
        /**
         * 左边按钮
         */
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //
                System.exit(0);
                dialog1.dismiss();
                dialog1.cancel();
                dialog1 =null;
            }
        });

        /**
         * 右边按钮
         */
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog1.dismiss();
                dialog1.cancel();
                dialog1 =null;
            }
        });

        /**
         * 底边一个按钮
         */
        centerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
                dialog1.cancel();
                dialog1 =null;
            }
        });

        dialog1.show();
        WindowManager.LayoutParams params = dialog1.getWindow().getAttributes();
        params.width = (int) (getWidth()*0.5);
        dialog1.getWindow().setAttributes(params);
        dialog1.setCanceledOnTouchOutside(false);
        dialog1.setContentView(dialogView);



    }


    /**
     * 获取系统屏幕的宽
     * @return
     */
    public int getWidth(){
        return mMetrics.widthPixels;
    }


    /**
     * 获取系统屏幕的高
     * @return
     */
    public int getHeight(){
        return  mMetrics.heightPixels;
    }








}
