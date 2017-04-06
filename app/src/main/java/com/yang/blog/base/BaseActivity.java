package com.yang.blog.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yang.blog.R;
import com.yang.blog.net.NetWorkUtils;
import com.yang.blog.net.listener.RequestListener;
import com.yang.blog.net.listener.SimpleRequestListener;
import com.yang.blog.utils.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */

public class BaseActivity extends FragmentActivity {

    private FrameLayout contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_simple_bar_root);
        contentView = (FrameLayout) findViewById(R.id.layout_root_content);
    }

    @Override
    public void setContentView(int layoutResID) {
        getLayoutInflater().inflate(layoutResID, contentView, true);
        init();
    }


    protected void init() {
        findView();
        initListener();
        getData();
    }

    protected void findView() {

    }

    protected void initListener() {

    }

    protected void getData() {

    }

    protected void setTitle(@NonNull String title) {
        if (getTitleBar() == null) return;
        ((TextView) getTitleBar().findViewById(R.id.tvTitle)).setText(title);
    }

    protected void showTitleBar(boolean visible) {
        if (getTitleBar() == null) return;
        getTitleBar().setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    protected void showLeftButton(int image,String text){
        Button left = (Button) getTitleBar().findViewById(R.id.btnTitleLeft);
        if(image != 0)
            left.setBackgroundResource(image);
        if(!StringUtils.isEmpty(text))
            left.setText(text);
        left.setVisibility(View.VISIBLE);
    }

    protected void showRightButton(int image,String text){
        Button right = (Button) getTitleBar().findViewById(R.id.btnRight);
        if(image != 0)
            right.setBackgroundResource(image);
        if(!StringUtils.isEmpty(text))
            right.setText(text);
        right.setVisibility(View.VISIBLE);
    }

    protected FrameLayout getTitleBar() {
        FrameLayout linearLayout = null;
        linearLayout = (FrameLayout) findViewById(R.id.barTitle);
        return linearLayout;
    }

    public <T> void requestData(BaseRequest request, final RequestListener<T> listener) {

        NetWorkUtils.requestData(this, request, new SimpleRequestListener<T>() {
            @Override
            public void onSuccess(T response) {
                listener.onSuccess(response);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                listener.onError(errorCode, errorMsg);
            }
        });
    }

    @Override
    public void finish() {
        NetWorkUtils.getInstance().cancelRequest(getClass());
        super.finish();
    }

    @Override
    protected void onDestroy() {
        NetWorkUtils.getInstance().cancelRequest(getClass());
//        if (errorRequestMap != null) {
//            errorRequestMap.clear();
//        }
        super.onDestroy();
    }
}
