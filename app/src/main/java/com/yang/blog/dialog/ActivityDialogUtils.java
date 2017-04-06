package com.yang.blog.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by YangShuang
 * on 2017/4/6.
 */

public class ActivityDialogUtils {

    public static final int ANIMATION_TYPE_ALPHA = 1;

    private Intent intent;

    private int animationType = -1;

    private Context context;

    private ActivityDialogUtils(Context context){
        this.context = context;
        if(intent == null){
            intent = new Intent(context,YDialogActivity.class);
        }
    }

    public ActivityDialogUtils getInstance(Context context){
        return new ActivityDialogUtils(context);
    }


    public void putExtra(String key,int value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,float value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,String value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,long value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,double value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,Bundle value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,boolean value){
        intent.putExtra(key,value);
    }
    public void putExtra(String key,Serializable value){
        intent.putExtra(key,value);
    }


    public void show(){
        if(animationType != -1){

        }
        context.startActivity(intent);
    }

    public void dimiss(){
//        context.
    }

    public void setShownAnimationType(){

    }

}
