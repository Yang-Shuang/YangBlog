package com.yang.blog.base;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by YangShuang
 * on 2017/3/27.
 */

public class BaseRecyclerViewHolder extends BaseViewHolder {
    public BaseRecyclerViewHolder(View view) {
        super(view);
    }

    public TextView getTextView(int id){
        return getView(id);
    }

    public Button getButton(int id){
        return getView(id);
    }

    public ImageView getImageView(int id){
        return getView(id);
    }
}
