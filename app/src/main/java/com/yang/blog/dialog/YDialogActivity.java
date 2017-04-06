package com.yang.blog.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;


/**
 * Created by YangShuang
 * on 2017/4/5.
 */

public abstract class YDialogActivity extends Activity{

    private int mLayoutId = -1;

    private DialogLifeCycleListener mDialogLifeCycleListener;

    public void setContentViewId(@LayoutRes int id){
        this.mLayoutId = id;
    }

    public interface DialogLifeCycleListener {
        void onCreate();
        void onResume();
        void onDestory();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutId = getIntent().getIntExtra("layoutId",-1);
        if(mLayoutId == -1){
            finish();
            throw new NullPointerException("the layout id is -1,please set layout id before show.");
        }
        setContentView(mLayoutId);

        initView();

        if(mDialogLifeCycleListener != null){
            mDialogLifeCycleListener.onCreate();
        }
    }

    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();

        if(mDialogLifeCycleListener != null){
            mDialogLifeCycleListener.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mDialogLifeCycleListener != null){
            mDialogLifeCycleListener.onDestory();
        }
    }
}
