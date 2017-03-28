package com.yang.blog.net;

import com.yang.blog.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */

public class NetWorkUtils {

    public static final int CONNECT_TIMEOUT = 15000;
    public static final int READ_TIMEOUT = 30000;

    private NetWorkUtils(){}

    private static NetWorkUtils mNetWorktils;

    private Retrofit mRetrofit;

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

    public static void requestData(String url, Map<String,String> paramas){
        if(mNetWorktils.mRetrofit == null)return;
        Call<String> call = mNetWorktils.mRetrofit.create(RequestService.class).GET(url,paramas,new HashMap<String, String>());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LogUtils.w(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                LogUtils.w(t.toString());
            }
        });
    }

}
