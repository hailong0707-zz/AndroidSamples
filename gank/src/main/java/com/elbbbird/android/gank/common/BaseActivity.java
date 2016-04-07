package com.elbbbird.android.gank.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Hailong Zhang on 2016/4/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();
        initData();
        initViews();
    }

    public abstract void setContentView();

    public abstract void initData();

    public abstract void initViews();

    public abstract void initToolbar(Toolbar toolbar);
}
