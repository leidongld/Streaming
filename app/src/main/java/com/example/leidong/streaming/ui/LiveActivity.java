package com.example.leidong.streaming.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.leidong.streaming.R;
import com.example.leidong.streaming.constants.Constants;
import com.example.leidong.streaming.views.MyVideoView;

/**
 * Created by leido on 2018/3/7.
 */

public class LiveActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "LiveActivity";

    private String mTitleStr;
    private String mUrlStr;
    private String mTimeStr;

    private MyVideoView mMyVideoView;
    private RelativeLayout mLoadingLayout;

    private ImageButton mBackBtn;
    private TextView mTitleTv;
    private TextView mTimeTv;
    private ImageButton mPlayBtn;

    private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        obtainDatas();

        initWidgets();

        initActions();

        initPlayer();
    }

    /**
     * 初始化播放器
     */
    private void initPlayer() {
        mMyVideoView.setVideoURI(Uri.parse(mUrlStr));

        mMyVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                mLoadingLayout.setVisibility(View.GONE);
            }
        });

        mMyVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                if(count > Constants.RETRY_TIMES){
                    new AlertDialog.Builder(LiveActivity.this)
                            .setTitle(getString(R.string.warning))
                            .setMessage(getString(R.string.warning_detail))
                            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    LiveActivity.this.finish();
                                }
                            })
                            .setCancelable(false)
                            .create()
                            .show();

                }
                else{
                    mMyVideoView.stopPlayback();
                    mMyVideoView.setVideoURI(Uri.parse(mUrlStr));
                }
                count++;
                return false;
            }
        });

        mMyVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {
                switch(i){
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        mLoadingLayout.setVisibility(View.VISIBLE);
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                        mLoadingLayout.setVisibility(View.GONE);
                        break;
                    case MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
                        mLoadingLayout.setVisibility(View.GONE);
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 初始化事件
     */
    private void initActions() {
        mPlayBtn.setOnClickListener(this);
        mBackBtn.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mMyVideoView = findViewById(R.id.video_view);

        mLoadingLayout = findViewById(R.id.rl_loading_layout);

        mPlayBtn = findViewById(R.id.ib_play);
        mBackBtn = findViewById(R.id.ib_back);

        mTitleTv = findViewById(R.id.tv_title);
        mTitleTv.setText(mTitleStr);
        mTimeTv = findViewById(R.id.tv_time);
        mTitleTv.setText(getCurrentSysTime());
    }

    /**
     * 接受数据
     */
    private void obtainDatas() {
        Intent intent = getIntent();
        mTitleStr = intent.getStringExtra(Constants.KEY_TITLE);
        mUrlStr = intent.getStringExtra(Constants.KEY_URL);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_play:
                clickPlayBtn();
                break;
            case R.id.ib_back:
                clickBackBtn();
                break;
            default:
                break;
        }
    }

    /**
     * 点击返回按钮
     */
    private void clickBackBtn() {
        finish();
    }

    /**
     * 点击播放按钮
     */
    private void clickPlayBtn() {
        if(mMyVideoView.isPlaying()){
            mMyVideoView.stopPlayback();
            mPlayBtn.setImageResource(R.drawable.pause);
        }
        else{
            mMyVideoView.setVideoURI(Uri.parse(mUrlStr));
            mMyVideoView.start();
            mPlayBtn.setImageResource(R.drawable.play);
        }
    }

    /**
     * 获取当前的系统时间
     * @return
     */
    public String getCurrentSysTime() {
        return mTimeStr;
    }

    @Override
    public void onPause(){
        super.onPause();
        if(mMyVideoView.isPlaying()){
            mMyVideoView.stopPlayback();
        }
    }
}
