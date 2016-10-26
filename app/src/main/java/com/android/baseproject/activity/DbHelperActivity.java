package com.android.baseproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.baselibrary.utils.LogUtil;
import com.android.baseproject.R;
import com.android.baseproject.utils.DbHelper;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by 15596 on 2016/10/24.
 *
 * 测试 DataBaseHelper
 *
 */

public class DbHelperActivity extends AppBaseActivity {
    @Bind(R.id.btn_insert)
    Button btnInsert;
    @Bind(R.id.btn_delect)
    Button btnDelect;
    @Bind(R.id.btn_query)
    Button btnQuery;
    @Bind(R.id.btn_update)
    Button btnUpdate;

    DbHelper mDbHelper ;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_testsql;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mDbHelper = DbHelper.getInstance(this);
    }

    public static void intentActivity(Context context) {
        Intent intent = new Intent(context, DbHelperActivity.class);
        context.startActivity(intent);
    }


    @OnClick({R.id.btn_insert, R.id.btn_delect, R.id.btn_query, R.id.btn_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                mDbHelper.insert("user",new String[]{"name","gender","age"},new Object[]{"u_name","u_gender","u_age"});
                LogUtil.d("插入成功");
                break;
            case R.id.btn_delect:
                break;
            case R.id.btn_query:
                break;
            case R.id.btn_update:
                break;
        }
    }
}
