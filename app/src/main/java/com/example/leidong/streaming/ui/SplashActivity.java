package com.example.leidong.streaming.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leidong.streaming.R;
import com.example.leidong.streaming.constants.Constants;
import com.example.leidong.streaming.utils.FontUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by leidong on 2018/3/7
 */

public class SplashActivity extends Activity {
    private static final String TAG = "SplashActivity";

    private LinearLayout splashLayout;

    private TextView appName;
    private TextView appAuthor;
    private TextView appDesc;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        initWidgets();

        initActions();

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(Constants.SPLASH_DURATION);
        splashLayout.setAnimation(alphaAnimation);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask, Constants.SPLASH_DURATION);
    }

    /**
     * 初始化动作
     */
    private void initActions() {

    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        splashLayout = findViewById(R.id.splash_layout);

        appName = findViewById(R.id.app_name);
        appAuthor = findViewById(R.id.app_author);
        appDesc = findViewById(R.id.app_desc);

        FontUtils.setFontFromAssets(appName, "fonts/Boltis.ttf");
        FontUtils.setFontFromAssets(appAuthor, "fonts/Boltis.ttf");
        FontUtils.setFontFromAssets(appDesc, "fonts/Boltis.ttf");
    }
}
