package com.example.leidong.streaming.utils;

import android.graphics.Typeface;
import android.widget.TextView;

import com.example.leidong.streaming.MyApplication;

/**
 * Created by leidong on 2018/3/8
 */

public class FontUtils {
    public static void setFontFromAssets(TextView textView, String fontPath) {
        Typeface typeface = Typeface.createFromAsset(MyApplication.getContext().getAssets(), fontPath);
        textView.setTypeface(typeface);
    }
}
