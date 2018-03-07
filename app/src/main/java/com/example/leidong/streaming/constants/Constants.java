package com.example.leidong.streaming.constants;

import com.example.leidong.streaming.models.Channel;

/**
 * Created by leido on 2018/3/7.
 */

public class Constants {
    public static final Channel[] channels = {
            //央视
            new Channel("新闻资讯", "http://116.66.222.46:8082/TV4020.m3u8"),
            new Channel("宫廷剧场", "http://116.66.222.46:8082/TV4002.m3u8"),
            new Channel("王牌综艺", "http://116.66.222.46:8082/TV4005.m3u8"),
            new Channel("精品大剧", "http://116.66.222.46:8082/TV4007.m3u8"),
            new Channel("CCTV-2财经", "http://116.66.222.46:8082/TV4013.m3u8"),
            new Channel("美国中文电视", "http://live.italkdd.com/ts142/channel_068.m3u8"),
            new Channel("文物宝库", "http://116.66.222.46:8082/TV3008.m3u8"),
            new Channel("动画王国", "http://116.66.222.46:8082/TV4009.m3u8"),
            new Channel("戏曲名段", "http://116.66.222.46:8082/TV4019.m3u8"),
            new Channel("天元围棋", "http://116.66.222.46:8082/TV3003.m3u8"),

            //卫视
            new Channel("深圳卫视", "http://116.66.222.46:8082/TV2006.m3u8"),
            new Channel("浙江卫视", "http://icantv.cn/hls/zjtv/zjws.m3u8"),
            new Channel("湖南卫视", "http://116.66.222.46:8082/TV1002.m3u8"),
            new Channel("东方卫视", "http://116.66.222.46:8082/TV1006.m3u8"),
            new Channel("广东卫视", "http://116.66.222.46:8082/TV1008.m3u8"),
            new Channel("北京卫视", "http://116.66.222.46:8082/TV2003.m3u8"),
            new Channel("安徽卫视", "http://116.66.222.46:8082/TV1037.m3u8"),
            new Channel("湖北卫视", "http://116.66.222.46:8082/TV2002.m3u8"),
            new Channel("河北卫视", "http://weblive.hebtv.com/live/hbws_bq/index.m3u8"),
            new Channel("金鹰卡通", "http://116.66.222.46:8082/TV1003.m3u8"),
            new Channel("欢乐喜剧人", "http://rotation.vod.zlive.cc/channel/1925.m3u8"),
            new Channel("喜剧总动员", "http://rotation.vod.zlive.cc/channel/2270.m3u8"),
            new Channel("相声剧", "http://rotation.vod.zlive.cc/channel/1578.m3u8"),
            new Channel("天天向上", "http://rotation.vod.zlive.cc/channel/1083.m3u8"),
            new Channel("汽车频道", "http://rotation.vod.zlive.cc/channel/1227.m3u8"),
            new Channel("花儿与少年", "http://rotation.vod.zlive.cc/channel/1795.m3u8"),
            new Channel("游戏", "http://rotation.vod.zlive.cc/channel/1935.m3u8"),
            new Channel("东方Knews24新闻高清", "http://hls.live.kksmg.com/live/live24h/playlist.m3u8"),
            new Channel("旅游卫视", "http://stream1.hnntv.cn/lywsgq/sd/live.m3u8"),
            new Channel("Sky News", "http://skydvn-nowtv-atv-prod.skydvn.com/atv/skynews/1404/live/07.m3u8\n" +
                    "\n"),

            //娱乐


            //美食
            new Channel("太阳猫早餐", "http://rotation.vod.zlive.cc/channel/1426.m3u8"),
            new Channel("美食", "http://rotation.vod.zlive.cc/channel/1661.m3u8"),
            new Channel("厨娘物语", "http://rotation.vod.zlive.cc/channel/1428.m3u8"),

            //电影
            new Channel("最新电影", "http://rotation.vod.zlive.cc/channel/1201.m3u8"),
            new Channel("经典电影", "http://rotation.vod.zlive.cc/channel/1200.m3u8"),

            //音乐
            new Channel("音乐地带", "http://116.66.222.46:8082/TV4012.m3u8"),
            new Channel("蒙面唱将", "http://rotation.vod.zlive.cc/channel/2221.m3u8"),
            new Channel("音乐演唱会", "http://rotation.vod.zlive.cc/channel/1565.m3u8"),
            new Channel("天籁之战", "http://rotation.vod.zlive.cc/channel/2272.m3u8"),
    };


    public static final String KEY_URL = "url";
    public static final String KEY_TITLE = "title";
    public static final int RETRY_TIMES = 5;
}