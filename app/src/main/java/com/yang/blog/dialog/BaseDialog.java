package com.yang.blog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by YangShuang
 * on 2017/4/6.
 */

public class BaseDialog extends Dialog{

    @LayoutRes
    protected int contentLayoutId = -1;

    public BaseDialog(@NonNull Context context) {
        super(context);
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId,@LayoutRes int layout) {
        super(context, themeResId);
        this.contentLayoutId = layout;
        init(context);
    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void init(Context context){
        if(contentLayoutId == -1){
            throw new NullPointerException("contentLayoutId == -1,please set id");
        }

        LayoutInflater inflater  = LayoutInflater.from(context);
        View view = inflater.inflate(contentLayoutId,null);
        setContentView(view);
        setToastLevel();
    }

    private void setToastLevel(){
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        getWindow().setAttributes(params);
    }
    private void setWithHeight(int widthPx,int heightPx){
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = widthPx;
        params.height = heightPx;
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        getWindow().setAttributes(params);
    }




}
