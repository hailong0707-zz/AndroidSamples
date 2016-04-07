package com.elbbbird.android.gank.common;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Hailong Zhang on 2016/4/6.
 */
public class GankApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
    }

    private void initTimber() {
        Timber.plant(new Timber.DebugTree());
    }

}
