package com.tian.video.editer.skin.inter;

import android.view.View;

import com.tian.video.editer.skin.attr.DynamicAttr;

import java.util.List;



/**
 * Created by TCX
 * Time:10:26
 */
public interface IDynamicNewView {
    void dynamicAddView(View view, List<DynamicAttr> pDAttrs);
}
