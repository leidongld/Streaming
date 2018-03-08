package com.example.leidong.streaming.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by leidong on 2018/3/8
 */

public class NetUtils {
    /**
     * 判断是否为WiFi环境
     * @param mContext
     * @return
     */
    public static boolean isWiFiEnvironment(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }
}
