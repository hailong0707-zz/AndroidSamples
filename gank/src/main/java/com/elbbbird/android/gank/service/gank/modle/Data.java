package com.elbbbird.android.gank.service.gank.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hailong Zhang on 2016/4/7.
 */
public class Data {

    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private List<News> news;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
