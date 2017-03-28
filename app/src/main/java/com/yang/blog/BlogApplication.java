package com.yang.blog;

import android.app.Application;

import com.yang.blog.net.NetWorkUtils;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */

public class BlogApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkUtils.initNetWork("http://192.168.1.117/");
    }
}
