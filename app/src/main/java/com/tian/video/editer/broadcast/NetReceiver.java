package com.tian.video.editer.broadcast;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.tian.video.editer.constant.NetConstant;
import com.tian.video.editer.inter.OnNetStateChangeListener;


/**
 * 网络状态监听
 */
public class NetReceiver extends BroadcastReceiver {
	private ConnectivityManager mConnectivityManager;
	private NetworkInfo netInfo;

	private OnNetStateChangeListener mOnNetStateChangeListener;

	private static final String  LOG="NetReceiver";


	@SuppressWarnings("unused")
	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
			mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			netInfo = mConnectivityManager.getActiveNetworkInfo();
			if (netInfo != null && netInfo.isAvailable()) {
				//网络连接
				String name = netInfo.getTypeName();
				if (netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
					//WiFi网络
					if (mOnNetStateChangeListener!=null){
						mOnNetStateChangeListener.OnNetStateChange(NetConstant.NET_WIFI);
					}

				} else if (netInfo.getType() == ConnectivityManager.TYPE_ETHERNET) {
					//有线网络
					if (mOnNetStateChangeListener!=null){
						mOnNetStateChangeListener.OnNetStateChange(NetConstant.NET_ETHERNET);
					}

				} else if (netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
					//2g 3g 4g网络
					if (mOnNetStateChangeListener!=null){
						mOnNetStateChangeListener.OnNetStateChange(NetConstant.NET_MOBILE);
					}
				}
				
			} else {
				 //网络断开
				if (mOnNetStateChangeListener!=null){
					mOnNetStateChangeListener.OnNetStateChange(NetConstant.NET_NO);
				}

			}
		}
	}


	/**
	 * 网络监听回调接口
	 * @param onNetStateChangeListener
	 */
	public void setNetStateChangeListener(OnNetStateChangeListener onNetStateChangeListener){
		if (onNetStateChangeListener!=null){
			mOnNetStateChangeListener=onNetStateChangeListener;
		}else{
			Log.e(LOG,"OnNetStateChangeListener is null!");
		}

	}



}
