package com.yang.blog.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yang.blog.R;

/**
 * Created by YangShuang
 *      on 2017/3/23.
 */

public class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        init();
    }

    protected void init(){
        findView();
        initListener();
        getData();
    }

    protected void findView(){

    }

    protected void initListener(){

    }

    protected void getData(){

    }
    protected void setTitle(@NonNull String title){
        if(getTitleBar() == null)return;
        ((TextView)getTitleBar().findViewById(R.id.titlebar_title_tv)).setText(title);
    }

    protected void showTitleBar(boolean visible){
        if(getTitleBar() == null)return;
        getTitleBar().setVisibility(visible ? View.VISIBLE : View.GONE);
    }
    protected LinearLayout getTitleBar(){
        LinearLayout linearLayout = null;
        if(findViewById(R.id.titlebar_layout_ll) == null){
            linearLayout = (LinearLayout) findViewById(R.id.titlebar_layout);
        }else {
            linearLayout = (LinearLayout) findViewById(R.id.titlebar_layout_ll);
        }
        return linearLayout;
    }
}
