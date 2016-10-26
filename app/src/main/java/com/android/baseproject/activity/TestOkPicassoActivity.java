package com.android.baseproject.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.android.baselibrary.utils.ToastUtil;
import com.android.baseproject.R;
import com.android.baseproject.domain.SpalshImgBean;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by 15596 on 2016/10/25.
 */

public class TestOkPicassoActivity extends AppBaseActivity {
    @Bind(R.id.iv_showiv)
    ImageView ivShowiv;
    @Bind(R.id.tv_showtv)
    TextView tvShowtv;
    

    private SpalshImgBean mSpalshImgBean = new SpalshImgBean();

    @Override
    public int getLayoutResId() {
        return R.layout.activity_okpicasso;
    }

    @Override
    public void initData() {
        super.initData();

        showSplashImg();

    }

    private void showSplashImg() {
        String strImgUrl = "http://news-at.zhihu.com/api/4/start-image/1080*1776";
        OkHttpUtils
                .get()
                .url(strImgUrl)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showLongToast(TestOkPicassoActivity.this,"出错了"+ e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        mSpalshImgBean = gson.fromJson(response,SpalshImgBean.class);
                        Picasso.with(TestOkPicassoActivity.this)
                                .load(mSpalshImgBean.getImg())
                                .into(ivShowiv);
                    }
                });
    }
}
