package com.yang.blog.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by YangShuang
 * on 2017/3/27.
 */

public class ScreenUtil {
    /**屏幕宽度*/
    public static int screen_width;
    /**屏幕高度*/
    public static int screen_height;
    /**屏幕密度比例*/
    public static float screen_density;
    /**屏幕密度DPI*/
    public static float screen_densityDpi;

    public static void init(Context context){
        try {
            DisplayMetrics metric = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(metric);
            screen_width = metric.widthPixels;     // 屏幕宽度（像素）
            screen_height = metric.heightPixels;   // 屏幕高度（像素）
            screen_density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
            screen_densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    /**
     * dp 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        return (int) (dpValue * screen_density + 0.5f);
    }

    /**
     *  px(像素) 转成为 dp
     */
    public static int px2dp(float pxValue) {
        return (int) (pxValue / screen_density + 0.5f);
    }
}
