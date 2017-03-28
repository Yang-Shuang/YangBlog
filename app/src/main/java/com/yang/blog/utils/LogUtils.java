package com.yang.blog.utils;

import android.util.Log;

/**
 * Created by YangShuang
 * on 2017/3/27.
 */

public class LogUtils {
    private static final String TAG = "LogUtils";

    public static void e(String msg) {
        e(TAG,msg);
    }

    public static void e(String tag, String msg){
        Log.e(tag,msg);
    }

    public static void w(String msg) {
        w(TAG,msg);
    }

    public static void w(String tag, String msg){
        Log.w(tag,msg);
    }

    public static void d(String msg) {
        d(TAG,msg);
    }

    public static void d(String tag, String msg){
        Log.d(tag,msg);
    }

    public static void i(String msg) {
        i(TAG,msg);
    }

    public static void i(String tag, String msg){
        Log.i(tag,msg);
    }


}
