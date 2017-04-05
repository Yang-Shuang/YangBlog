package com.yang.blog.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by YangShuang
 * on 2017/4/5.
 */

public class YDialogActivity extends Activity{

    private Intent intent;

    private YDialogActivity(){}

    private void build(Context context){
        if(intent == null){
            intent = new Intent(context,YDialogActivity.class);
        }
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
    }

    public void setShownAnimationType(){
    }
}
