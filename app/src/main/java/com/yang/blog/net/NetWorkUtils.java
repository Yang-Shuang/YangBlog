package com.yang.blog.net;

import com.yang.blog.base.BaseRequest;
import com.yang.blog.net.listener.RequestListener;
import com.yang.blog.utils.JsonParser;
import com.yang.blog.utils.LogUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.R.attr.path;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */

public class NetWorkUtils {

    public static final int EOORO_CODE_JSON_PRASR = -3;
    public static final int EOORO_CODE_NO_CONNECT = -2;
    public static final int EOORO_CODE_NO_CONTENT= -1;

    public static final int CONNECT_TIMEOUT = 15000;
    public static final int READ_TIMEOUT = 30000;

    private static NetWorkUtils mNetWorktils;

    private Retrofit mRetrofit;

    private Map<Object, List<Call>> requestQueue;

    private NetWorkUtils(){}

    public static void initNetWork(String baseUrl){
        if(mNetWorktils == null){
            mNetWorktils = new NetWorkUtils();
        }
        if(mNetWorktils.mRetrofit != null)return;

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        builder.addConverterFactory(StringConverter.INSTANCE);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        //添加https 支持
        Https.SSLParams sslParams = Https.getSslSocketFactory(null, null, null);
        if (sslParams.sSLSocketFactory != null && sslParams.trustManager != null) {
            clientBuilder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
        }
        //添加拦截器
//        clientBuilder.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                if (manager.requestHandler != null) {
//                    return manager.requestHandler.handleRequest(chain);
//                }
//                return chain.proceed(chain.request());
//            }
//        });

        clientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);
        OkHttpClient client = clientBuilder.build();
        builder.client(client);
        mNetWorktils.mRetrofit = builder.build();
    }

    public static NetWorkUtils getInstance(){
        if(mNetWorktils == null){
            throw new NullPointerException("Please call initNetWork(String baseUrl) before this");
        }else {
            return mNetWorktils;
        }
    }

    public static <T> void requestData(Object tag, final BaseRequest request, final RequestListener<T> requestListener){
        if(mNetWorktils.mRetrofit == null)return;
        String param = JsonParser.bean2Json(request);
        Call<String> call = mNetWorktils.mRetrofit.create(RequestService.class).POST(request.getRequestUrl(),param,new HashMap<String, String>());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (requestListener == null) return;
                String s = "";
                try {
                    if (response == null) {
                        String errorMsg = "返回的response为空";
                        requestListener.onError(EOORO_CODE_NO_CONTENT, errorMsg);
                        return;
                    }
                    if (response.headers() != null) {
                        requestListener.responseHeaders(response.headers().toMultimap());
                    }
                    if (response.isSuccessful()) {
                        String responseString = response.body();
//                        if (requestHandler != null) {
//                            responseString = requestHandler.handleResponse(responseString);
//                        }
                        requestListener.onSuccess((T) JsonParser.json2Bean(responseString,request.getResponseClass()));
                    } else {
                        requestListener.onError(response.code(), response.message());
                    }
                } catch (Exception e) {
                    String errorMsg = "解析数据出错: " + e.getMessage();
                    requestListener.onError(EOORO_CODE_JSON_PRASR, errorMsg);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                requestListener.onError(EOORO_CODE_NO_CONNECT,t.getMessage());
            }
        });
        addRequestToQueue(tag,call);
    }

    public static void addRequestToQueue(Object tag,Call call){
        if(mNetWorktils == null || mNetWorktils.mRetrofit == null)return;
        if(mNetWorktils.requestQueue == null){
            mNetWorktils.requestQueue = new HashMap<Object,List<Call>>();
        }
        List<Call> calls = mNetWorktils.requestQueue.get(tag);
        if(calls == null){
            calls = new ArrayList<>();
            mNetWorktils.requestQueue.put(tag,calls);
        }
        calls.add(call);
    }

    public void cancelAll() {
        try {
            if (mNetWorktils.requestQueue == null || mNetWorktils.requestQueue.isEmpty()) {
                return;
            }

            Collection<List<Call>> collection = mNetWorktils.requestQueue.values();
            for (List<Call> list : collection) {
                for (Call call : list) {
                    if (call != null && call.isExecuted()) {
                        call.cancel();
                    }
                }
                list.clear();
            }
            mNetWorktils.requestQueue.clear();
        } catch (Exception e) {
            LogUtils.e("取消请求出错");
            LogUtils.e(e.toString());
        }
    }

    private void removeRequest(Object tag) {
        cancelOrRemove(tag, false);
    }

    private void cancelOrRemove(Object tag, boolean isCancel) {
        try {
            if (mNetWorktils.requestQueue == null) {
                return;
            }
            List<Call> list = mNetWorktils.requestQueue.get(tag);
            if (list == null || list.isEmpty()) {
                return;
            }
            if (isCancel) {
                for (Call call : list) {
                    if (call != null && call.isExecuted()) {
                        call.cancel();
                    }
                }
            }
            list.clear();
            mNetWorktils.requestQueue.remove(tag);
        } catch (Exception e) {
            LogUtils.e("取消请求出错");
            LogUtils.e(e.toString());
        }
    }

    /**
     * 取消tag 对应的请求操作
     */
    public void cancelRequest(Object tag) {
        cancelOrRemove(tag, true);
    }

}
