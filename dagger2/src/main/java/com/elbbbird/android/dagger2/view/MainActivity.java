package com.elbbbird.android.dagger2.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.elbbbird.android.dagger2.R;
import com.elbbbird.android.dagger2.base.BaseActivity;
import com.elbbbird.android.dagger2.base.DaggerApplication;
import com.elbbbird.android.dagger2.model.Student;
import com.elbbbird.android.dagger2.presenter.MainPresenter;
import com.elbbbird.android.dagger2.view.dagger.component.DaggerMainActivityComponent;
import com.elbbbird.android.dagger2.view.dagger.module.MainActivityModule;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mPresenter;
    @Inject
    Student mStudent;
    @Inject
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, mPresenter.getStudentName(mStudent), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mPresenter.getContext(mContext);
            }
        });
    }

    @Override
    protected void setActivityComponent() {
        DaggerMainActivityComponent.builder()
                .daggerComponent(DaggerApplication.getDaggerComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
