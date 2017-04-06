package com.yang.blog.utils;

/**
 * Created by YangShuang
 * on 2017/4/6.
 */

public class StringUtils {

    public static boolean isEmpty(String str){
        return str == null || str.equals("") || str.equals("null");
    }
}
