package com.android.baseproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.android.baselibrary.adapter.ViewHolder;
import com.android.baseproject.R;
import com.android.baseproject.adapter.AppBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by 15596 on 2016/10/21.
 * 测试 baseadapter
 *
 */

public class TestAdapterActivity extends AppBaseActivity {
    @Bind(R.id.lv_testadpter)
    ListView lvTestadpter;

    private List<String> listData = new ArrayList<String>();

    @Override
    public int getLayoutResId() {
        return R.layout.activity_listview;
    }

    public static void intentActivity(Context context) {
        Intent intent = new Intent(context, TestAdapterActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void initData() {
        super.initData();
        initListData();
    }

    private void initListData() {
        for (int i = 0 ;i<10 ;i++){
            String str = "我是item";
            listData.add(str);
        }
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        AppBaseAdapter<String>  appAdapter = new AppBaseAdapter<String>(this,R.layout.item ,listData) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                viewHolder.setText(R.id.tv_item , listData.get(position));
            }
        };

        lvTestadpter.setAdapter(appAdapter);
    }
}
