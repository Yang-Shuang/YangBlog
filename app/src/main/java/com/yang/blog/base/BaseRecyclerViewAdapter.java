package com.yang.blog.base;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * Created by YangShuang
 * on 2017/3/27.
 */

public abstract class BaseRecyclerViewAdapter<T extends BaseBean> extends BaseQuickAdapter<T,BaseRecyclerViewHolder>{
    public BaseRecyclerViewAdapter(int layoutResId, List<T> data) {
        super(layoutResId, data);
    }

    public BaseRecyclerViewAdapter(List<T> data) {
        super(data);
    }

    public BaseRecyclerViewAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseRecyclerViewHolder baseRecyclerViewHolder, T baseBean) {
        bindData(baseRecyclerViewHolder,baseBean);
    }

    protected abstract void bindData(BaseRecyclerViewHolder baseRecyclerViewHolder, T baseBean);
}
