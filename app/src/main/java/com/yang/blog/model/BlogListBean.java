package com.yang.blog.model;

import com.yang.blog.base.BaseBean;

/**
 * Created by YangShuang on 2017/3/27.
 */

public class BlogListBean extends BaseBean{

    private String title;
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
