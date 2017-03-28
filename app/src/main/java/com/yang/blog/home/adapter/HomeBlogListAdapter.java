package com.yang.blog.home.adapter;

import com.yang.blog.R;
import com.yang.blog.base.BaseRecyclerViewAdapter;
import com.yang.blog.base.BaseRecyclerViewHolder;
import com.yang.blog.model.BlogListBean;

import java.util.List;

/**
 * Created by YangShuang
 * on 2017/3/27.
 */

public class HomeBlogListAdapter extends BaseRecyclerViewAdapter<BlogListBean>{

    public HomeBlogListAdapter(int layoutResId, List<BlogListBean> data) {
        super(layoutResId, data);
    }

    public HomeBlogListAdapter(List<BlogListBean> data) {
        super(data);
    }

    public HomeBlogListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void bindData(BaseRecyclerViewHolder baseRecyclerViewHolder, BlogListBean baseBean) {

        baseRecyclerViewHolder.getTextView(R.id.home_bolg_list_item_title_tv).setText(baseBean.getTitle());
        baseRecyclerViewHolder.getTextView(R.id.home_bolg_list_item_time_tv).setText(baseBean.getTime());
    }
}
