package com.yang.blog.home.adapter;

import com.yang.blog.R;
import com.yang.blog.base.BaseRecyclerViewAdapter;
import com.yang.blog.base.BaseRecyclerViewHolder;
import com.yang.blog.model.BlogListBean;
import com.yang.blog.net.request.BlogListResponse;

import java.util.List;

/**
 * Created by YangShuang
 * on 2017/3/27.
 */

public class HomeBlogListAdapter extends BaseRecyclerViewAdapter<BlogListResponse.BlogListElement>{

    public HomeBlogListAdapter(int layoutResId, List<BlogListResponse.BlogListElement> data) {
        super(layoutResId, data);
    }

    public HomeBlogListAdapter(List<BlogListResponse.BlogListElement> data) {
        super(data);
    }

    public HomeBlogListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void bindData(BaseRecyclerViewHolder baseRecyclerViewHolder, BlogListResponse.BlogListElement baseBean) {

        baseRecyclerViewHolder.getTextView(R.id.home_bolg_list_item_title_tv).setText(baseBean.getArticleTitle());
        baseRecyclerViewHolder.getTextView(R.id.home_bolg_list_item_time_tv).setText(baseBean.getArticleTime());
    }
}
