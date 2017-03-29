package com.yang.blog.net.listener;

import java.util.List;
import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/29.
 */

public interface RequestListener <T>{
    /**
     * 请求成功回调方法
     */
    void onSuccess(T response);
    /**
     * 请求出错回调方法（无网络连接、连接超时，网络错误，服务器错误，数据解析以及其他异常）
     */
    void onError(int errorCode, String errorMsg);

    Map<String, String> requestHeaders();

    void responseHeaders(Map<String, List<String>> headers);
}
