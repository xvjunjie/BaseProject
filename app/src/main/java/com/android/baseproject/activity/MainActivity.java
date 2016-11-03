package com.android.baseproject.activity;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.android.baselibrary.utils.NotifyUtil;
import com.android.baselibrary.widget.normaldialog.basedialog.BaseAnimatorSet;
import com.android.baselibrary.widget.normaldialog.BounceTopEnter;
import com.android.baselibrary.widget.normaldialog.NormalDialog;
import com.android.baselibrary.widget.normaldialog.SlideBottomExit;
import com.android.baseproject.R;

import butterknife.Bind;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;

public class MainActivity extends AppBaseActivity {


    @Bind(R.id.btn_loading)
    Button tvLoading;
    @Bind(R.id.btn_notify)
    Button btnNotify;
    @Bind(R.id.btn_textadapter)
    Button lvadpter;
    @Bind(R.id.btn_dbhelper)
    Button btndbhelper;
    @Bind(R.id.btn_picasso)
    Button btnpicasso;
    @Bind(R.id.btn_test_dialog)
    Button btn_dialog ;

    private Context mContext;
    private NotifyUtil currentNotify;
    private int requestCode = (int) SystemClock.uptimeMillis();

    private BaseAnimatorSet mBasIn;
    private BaseAnimatorSet mBasOut;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);


    }

    @OnClick({R.id.btn_loading, R.id.btn_notify,
            R.id.btn_textadapter,R.id.btn_dbhelper,
            R.id.btn_picasso,R.id.btn_test_dialog})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_loading:
                showDialog();
                break;
            case R.id.btn_notify:
                notify_normal_singLine();//通知
                break;
            case R.id.btn_textadapter :
                startActivity(this,TestAdapterActivity.class);
                break;
            case R.id.btn_dbhelper :
                startActivity(this,DbHelperActivity.class);
                break;
            case R.id.btn_picasso :
                startActivity(this,TestOkPicassoActivity.class);
                break;
            case R.id.btn_test_dialog :
                NormalDialogStyleTwo();//两个按钮的对话框

        }
    }

    private void NormalDialogStyleTwo() {
        mBasIn = new BounceTopEnter();
        mBasOut = new SlideBottomExit();
        NormalDialog mNormalDialog = new NormalDialog(this);
        mNormalDialog.content("我来了")
                .style(NormalDialog.STYLE_TWO)
                .titleTextSize(23)
                .showAnim(mBasIn)
                .dismissAnim(mBasOut)
                .show();
    }

    private void notify_normal_singLine() {
        //设置想要展示的数据内容
        Intent intent = new Intent(getApplicationContext(), OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(),
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.mipmap.ic_launcher;
        String ticker = "您有一条新通知";
        String title = "双十一大优惠！！！";
        String content = "仿真皮肤充气娃娃，女朋友带回家！";

        //实例化工具类，并且调用接口
        NotifyUtil notify1 = new NotifyUtil(getApplicationContext(), 1);
        notify1.notify_normal_singline(pIntent, smallIcon, ticker, title, content, true, true, false);
        currentNotify = notify1;
    }







    private void showDialog() {
        Handler  handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlertDialog dialog = new SpotsDialog(MainActivity.this,"登录");
                dialog.show();
            }
        },4000);



    }



}
