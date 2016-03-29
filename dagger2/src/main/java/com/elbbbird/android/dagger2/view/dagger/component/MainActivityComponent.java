package com.elbbbird.android.dagger2.view.dagger.component;

import com.elbbbird.android.dagger2.view.MainActivity;
import com.elbbbird.android.dagger2.view.dagger.module.MainActivityModule;
import com.elbbbird.android.dagger2.view.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */

@ActivityScope
@Component(modules = MainActivityModule.class, dependencies = DaggerComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity activity); //the method name is casual, but must.
}
