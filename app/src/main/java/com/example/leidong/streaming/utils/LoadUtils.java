package com.example.leidong.streaming.utils;

import com.example.leidong.streaming.constants.Constants;
import com.example.leidong.streaming.models.Channel;

public class LoadUtils {
    /**
     * 加载电视节目
     * @return
     */
    public static Channel[] loadChannels() {
        return Constants.channels;
    }

    /**
     * 加载电影
     * @return
     */
    public static Channel[] loadMovies() {
        return Constants.movies;
    }

    /**
     * 加载电影
     * @return
     */
    public static Channel[] loadFoods() {
        return Constants.foods;
    }

    /**
     * 加载游戏
     * @return
     */
    public static Channel[] loadGames() {
        return Constants.games;
    }
}
