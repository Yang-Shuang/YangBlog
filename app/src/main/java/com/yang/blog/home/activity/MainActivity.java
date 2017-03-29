package com.yang.blog.home.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.bezierlayout.BezierLayout;
import com.yang.blog.R;
import com.yang.blog.base.BaseActivity;
import com.yang.blog.base.BaseResponse;
import com.yang.blog.home.adapter.HomeBlogListAdapter;
import com.yang.blog.model.BlogListBean;
import com.yang.blog.net.listener.SimpleRequestListener;
import com.yang.blog.net.request.BlogListRequest;
import com.yang.blog.net.request.BlogListResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{

    private RecyclerView mRecyclerView;
    private TwinklingRefreshLayout mLayout;

    private List<BlogListResponse.BlogListElement> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Articles");

        mList = new ArrayList<>();
        HomeBlogListAdapter adapter = new HomeBlogListAdapter(R.layout.home_blog_list_item,mList);
        adapter.isFirstOnly(false);
        mRecyclerView.setAdapter(adapter);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        loadData();
//        for (int i = 0; i < 30;i++){
//            BlogListBean b = new BlogListBean();
//            b.setTitle("Title"+i*1111111111);
//            b.setTime("Time"+i*1111111111);
//            blogListBeens.add(b);
//        }
//        adapter.notifyDataSetChanged();
}

    @Override
    protected void findView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_blog_rv);
        mLayout = (TwinklingRefreshLayout) findViewById(R.id.main_blog_trl);
        mLayout.setHeaderView(new BezierLayout(this));
        mLayout.setMaxHeadHeight(140);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mLayout.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                loadmore = false;
                loadData();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                loadmore = true;
                loadData();
            }
        });
    }

    private boolean loadmore = false;

    private void loadData(){
        BlogListRequest request = new BlogListRequest();
        requestData(request, new SimpleRequestListener<BlogListResponse>() {
            @Override
            public void onSuccess(BlogListResponse response) {
                if(!loadmore)mList.clear();
                mList.addAll(response.getList());
                mRecyclerView.getAdapter().notifyDataSetChanged();
                mLayout.finishRefreshing();
                mLayout.finishLoadmore();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
