package com.yang.blog.net.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yang.blog.base.BaseRequest;

import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/29.
 */

public class BlogListRequest implements BaseRequest{
    @JsonIgnore
    public String getRequestUrl() {
        return "/yblog/getList";
    }

    @JsonIgnore
    public Map<String, Object> getRequestParams() {
        return null;
    }

    @JsonIgnore
    public Class getResponseClass() {
        return BlogListResponse.class;
    }
}
