package com.yang.blog.home.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.yang.blog.R;
import com.yang.blog.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void findView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_blog_rv);
    }


}
