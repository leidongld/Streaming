package com.example.leidong.streaming.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.leidong.streaming.R;
import com.example.leidong.streaming.fragments.BaseFragment;
import com.example.leidong.streaming.models.Channel;
import com.example.leidong.streaming.utils.LoadUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements OnTabSelectListener {
    private static final String TAG = "MainActivity";

    @BindView(R.id.content_container)
    LinearLayout mContainer;

    @BindView(R.id.bottom_bars)
    BottomBar mBottomBars;

    private FragmentManager mFragmentManager;
    private Channel[] mChannels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initWidgets();

        initActions();
    }

    /**
     * 初始化动作
     */
    private void initActions() {
        mBottomBars.setOnTabSelectListener(this);
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mFragmentManager = getFragmentManager();
        mChannels = LoadUtils.loadChannels();
        BaseFragment baseFragment = new BaseFragment(mChannels);
        mFragmentManager.beginTransaction().replace(R.id.content_container, baseFragment).commit();
    }

    @Override
    public void onTabSelected(int tabId) {
        switch(tabId){
            case R.id.tab_channels:
                mFragmentManager = getFragmentManager();
                mChannels = LoadUtils.loadChannels();
                BaseFragment baseFragment1 = new BaseFragment(mChannels);
                mFragmentManager.beginTransaction().replace(R.id.content_container, baseFragment1).commit();
                break;
            case R.id.tab_movies:
                mFragmentManager = getFragmentManager();
                mChannels = LoadUtils.loadMovies();
                BaseFragment baseFragment2 = new BaseFragment(mChannels);
                mFragmentManager.beginTransaction().replace(R.id.content_container, baseFragment2).commit();
                break;
            case R.id.tab_foods:
                mFragmentManager = getFragmentManager();
                mChannels = LoadUtils.loadFoods();
                BaseFragment baseFragment3 = new BaseFragment(mChannels);
                mFragmentManager.beginTransaction().replace(R.id.content_container, baseFragment3).commit();
                break;
            case R.id.tab_games:
                mFragmentManager = getFragmentManager();
                mChannels = LoadUtils.loadGames();
                BaseFragment baseFragment4 = new BaseFragment(mChannels);
                mFragmentManager.beginTransaction().replace(R.id.content_container, baseFragment4).commit();
                break;
            default:
                break;
        }
    }
}
