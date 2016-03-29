package com.elbbbird.android.dagger2.view.dagger.module;

import android.content.Context;

import com.elbbbird.android.dagger2.base.DaggerApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */

@Module
public class DaggerModule {

    private final DaggerApplication mApplication;

    public DaggerModule(DaggerApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication;
    }

}
