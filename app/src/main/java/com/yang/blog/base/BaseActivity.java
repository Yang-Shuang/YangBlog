package com.yang.blog.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by YangShuang
 *      on 2017/3/23.
 */

public class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
}
