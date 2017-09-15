package com.tian.video.editer.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;


public class DensityUtil {

	private static float mPixels = 0.0F;
	private static float density = -1.0F;

	/**
	 * 
	 * @param context
	 * @param pixels 
	 * @return
	 */
	public static int getDisplayMetrics(Context context, float pixels) {
		if (mPixels == 0.0F)
			mPixels = context.getResources().getDisplayMetrics().density;
		return (int) (0.5F + pixels * mPixels);
	}
	
	
	public static int getImageWeidth(Context context , float pixels) {
//		LogUtil.e("screen width " + context.getResources().getDisplayMetrics().widthPixels);
		return context.getResources().getDisplayMetrics().widthPixels - 66 - getDisplayMetrics(context, pixels);
	}

	/**
	 * 
	 * @param context
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue){

		final float scale = context.getResources().getDisplayMetrics().density;

		return (int)(pxValue / scale + 0.5f);

	}



	/**
	 * 将px值转换为sp值，保证文字大小不变
	 *
	 * @param pxValue
	 * @param context
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 *
	 * @param spValue
	 * @param context
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * dip
	 *
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(float dipValue){
		final float scale = Resources.getSystem().getDisplayMetrics().density;
		return (int)(dipValue * scale + 0.5f);

	}
	
	/**
	 * @param context
	 * @param height
	 * @return
	 */
	public static int getMetricsDensity(Context context , float height) {
		DisplayMetrics localDisplayMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
				.getDefaultDisplay().getMetrics(localDisplayMetrics);
		return Math.round(height * localDisplayMetrics.densityDpi / 160.0F);
	}
	

}

