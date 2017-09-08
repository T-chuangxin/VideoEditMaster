package com.tian.video.editer.skin.attr;

import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.tian.video.editer.skin.factory.SkinManager;


/**
 * Created by TCX
 * Time:13:52
 */
public class FabButtonAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof FloatingActionButton) {
            FloatingActionButton fb = (FloatingActionButton) view;
            if (RES_TYPE_NAME_COLOR.equals(attrValueTypeName)) {
                int color = SkinManager.getInstance().getColor(attrValueRefId);
                fb.setBackgroundTintList(ColorStateList.valueOf(color));
            } else if (RES_TYPE_NAME_DRAWABLE.equals(attrValueTypeName)) {
                //  tv.setDivider(SkinManager.getInstance().getDrawable(attrValueRefId));
            }
        }
    }
}
