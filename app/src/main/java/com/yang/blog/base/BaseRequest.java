package com.yang.blog.base;

import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */

public interface BaseRequest {

    String getRequestUrl();

    Map<String, Object> getRequestParams();

    Class getResponseClass();

}
