package com.example.leidong.streaming;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by leidong on 2018/3/7
 */

@SuppressLint("Registered")
public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    public void onCreate(){
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * 获取全局Context对象
     * @return
     */
    public static Context getContext(){
        return mContext;
    }
}
