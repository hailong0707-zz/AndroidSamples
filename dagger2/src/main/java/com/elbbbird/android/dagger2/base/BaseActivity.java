package com.elbbbird.android.dagger2.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityComponent();
    }

    protected abstract void setActivityComponent();
}
