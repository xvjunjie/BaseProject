package com.android.baseproject.adapter;

import android.content.Context;

import com.android.baselibrary.adapter.CommonAdapter;

import java.util.List;


/**
 * Created by 15596 on 2016/10/21.
 */

public abstract class AppBaseAdapter<T> extends CommonAdapter<T> {

    public AppBaseAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
    }
}
