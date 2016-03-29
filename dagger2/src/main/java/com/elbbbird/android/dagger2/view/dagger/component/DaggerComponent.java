package com.elbbbird.android.dagger2.view.dagger.component;

import android.content.Context;

import com.elbbbird.android.dagger2.view.dagger.module.DaggerModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */

@Singleton
@Component(modules = DaggerModule.class)
public interface DaggerComponent {

    Context context();
}
