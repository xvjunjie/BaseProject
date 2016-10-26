package com.android.baseproject.activity;

import android.os.Bundle;

import com.android.baselibrary.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by 15596 on 2016/10/19.
 */

public  abstract class AppBaseActivity extends BaseActivity {
    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
