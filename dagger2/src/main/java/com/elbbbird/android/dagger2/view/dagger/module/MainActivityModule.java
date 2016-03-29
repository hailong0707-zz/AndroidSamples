package com.elbbbird.android.dagger2.view.dagger.module;

import com.elbbbird.android.dagger2.model.Student;
import com.elbbbird.android.dagger2.presenter.MainPresenter;
import com.elbbbird.android.dagger2.view.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */

@Module
public class MainActivityModule {

    private MainActivity mActivity;

    public MainActivityModule(MainActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    MainPresenter provideMainPresenter() {
        return new MainPresenter(mActivity);
    }

    @Provides
    Student provideStudent() {
        return new Student("Hailong Zhang", 28);
    }
}
