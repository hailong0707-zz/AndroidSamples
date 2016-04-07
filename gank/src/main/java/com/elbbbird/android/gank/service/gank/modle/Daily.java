package com.elbbbird.android.gank.service.gank.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hailong Zhang on 2016/4/6.
 */
public class Daily {

    @SerializedName("category")
    private List<String> category;
    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private Group results;

    public Daily() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Group getResults() {
        return results;
    }

    public void setResults(Group results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class Group {
        @SerializedName("Android")
        private List<News> androids;
        @SerializedName("App")
        private List<News> apps;
        @SerializedName("iOS")
        private List<News> iOS;
        @SerializedName("休息视频")
        private List<News> videos;
        @SerializedName("前端")
        private List<News> webs;
        @SerializedName("瞎推荐")
        private List<News> others;
        @SerializedName("福利")
        private List<News> arts;

        public List<News> getAndroids() {
            return androids;
        }

        public void setAndroid(List<News> androids) {
            this.androids = androids;
        }

        public List<News> getApp() {
            return apps;
        }

        public void setApp(List<News> apps) {
            this.apps = apps;
        }

        public List<News> getIOS() {
            return iOS;
        }

        public void setIOS(List<News> iOS) {
            this.iOS = iOS;
        }

        public List<News> getVideos() {
            return videos;
        }

        public void setVideos(List<News> videos) {
            this.videos = videos;
        }

        public List<News> getWebs() {
            return webs;
        }

        public void setWebs(List<News> webs) {
            this.webs = webs;
        }

        public List<News> getOthers() {
            return others;
        }

        public void setOthers(List<News> others) {
            this.others = others;
        }

        public List<News> getArt() {
            return arts;
        }

        public void setArt(List<News> arts) {
            this.arts = arts;
        }

    }
}
