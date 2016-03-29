package com.elbbbird.android.dagger2.base;

import android.app.Application;

import com.elbbbird.android.dagger2.view.dagger.component.DaggerComponent;
import com.elbbbird.android.dagger2.view.dagger.component.DaggerDaggerComponent;
import com.elbbbird.android.dagger2.view.dagger.module.DaggerModule;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */
public class DaggerApplication extends Application {

    private static DaggerComponent sDaggerComponent;

    public static DaggerComponent getDaggerComponent() {
        return sDaggerComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        setComponent();
    }

    private void setComponent() {

        sDaggerComponent = DaggerDaggerComponent.builder()
                .daggerModule(new DaggerModule(this))
                .build();

    }
}
