package com.example.leidong.streaming.views;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by leidong on 2018/3/7
 * 自定义VideoView
 */

public class MyVideoView extends VideoView {
    //最终的视频资源宽度
    private int mVideoWidth = 480;
    //最终视频资源高度
    private int mVideoHeight = 480;
    //视频资源原始宽度
    private int videoRealW = 1;
    //视频资源原始高度
    private int videoRealH = 1;

    public MyVideoView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void setVideoPath(String path) {
        super.setVideoPath(path);

        MediaMetadataRetriever retr = new MediaMetadataRetriever();
        retr.setDataSource(path);
        String height = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT); // 视频高度
        String width = retr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH); // 视频宽度
        try {
            videoRealH=Integer.parseInt(height);
            videoRealW=Integer.parseInt(width);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        //屏蔽触摸点击事件
//        return true;
//    }
}

