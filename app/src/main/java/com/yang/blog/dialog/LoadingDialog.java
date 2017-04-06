package com.yang.blog.dialog;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.yang.blog.R;

/**
 * Created by YangShuang
 * on 2017/4/5.
 */

public class LoadingDialog extends BaseDialog{

    public LoadingDialog(@NonNull Context context, @LayoutRes int layout) {
        super(context, R.style.DialogTransparent,layout);
    }

    public LoadingDialog(@NonNull Context context, @LayoutRes int layout,@StyleRes int themeResId) {
        super(context, themeResId,layout);
    }


}
