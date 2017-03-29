package com.yang.blog.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by YangShuang
 * on 2017/3/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
