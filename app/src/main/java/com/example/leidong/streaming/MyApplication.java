package com.example.leidong.streaming;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by leido on 2018/3/7.
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
     *
     * @return
     */
    public static Context getContext(){
        return mContext;
    }
}
