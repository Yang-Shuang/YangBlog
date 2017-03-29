package com.yang.blog.net.listener;


import java.util.List;
import java.util.Map;

/**
 * Created by YangShuang
 * on 2017/3/29.
 */

public abstract class SimpleRequestListener<T> implements RequestListener<T> {
    @Override
    public void onError(int errorCode, String errorMsg) {

    }

    @Override
    public Map<String, String> requestHeaders() {
        return null;
    }

    @Override
    public void responseHeaders(Map<String, List<String>> headers) {

    }
}
