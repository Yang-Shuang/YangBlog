package com.yang.blog.net;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by YangShuang
 * on 2017/3/28.
 */

public class StringConverter extends Converter.Factory{

    public static final StringConverter INSTANCE = new StringConverter();
    private StringConverter(){}
    @Override
    public Converter<String, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return RequestConverterBody.INSTANCE;
    }

    @Override
    public Converter<ResponseBody, String> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return ResponseConverterBody.INSTANCE;
    }

    static final class RequestConverterBody implements  Converter<String, RequestBody>{
        private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
        private static RequestConverterBody INSTANCE = new RequestConverterBody();
        private RequestConverterBody(){}
        @Override
        public RequestBody convert(String value) throws IOException {
            return RequestBody.create(MEDIA_TYPE, value);
        }
    }

    static final class ResponseConverterBody implements  Converter<ResponseBody, String>{
        static final ResponseConverterBody INSTANCE = new ResponseConverterBody();
        @Override
        public String convert(ResponseBody value) throws IOException {
            return value.string();
        }
    }
}
