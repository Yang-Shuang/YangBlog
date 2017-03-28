package com.yang.blog.net;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */

public interface RequestService {
    @GET
    Call<String> GET(@Url String url, @QueryMap Map<String, String> params, @HeaderMap Map<String, String> headerMap);

    @FormUrlEncoded
    @POST
    Call<String> POST(@Url String url, @FieldMap Map<String, String> params, @HeaderMap Map<String, String> headerMap);

    @POST
    Call<String> POST(@Url String url, @Body String content, @HeaderMap Map<String, String> headerMap);
}
