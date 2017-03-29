package com.yang.blog.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public interface BaseRequest {

    String getRequestUrl();

    Map<String, Object> getRequestParams();

    Class getResponseClass();

}
