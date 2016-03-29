package com.elbbbird.android.dagger2.presenter;

import android.content.Context;
import android.util.Log;

import com.elbbbird.android.dagger2.model.Student;
import com.elbbbird.android.dagger2.view.MainActivity;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */

interface IMainPresenter {

    String getStudentName(Student student);
    void getContext(Context context);
}

public class MainPresenter implements IMainPresenter {


    private MainActivity mActivity;

    public MainPresenter(MainActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public String getStudentName(Student student) {
        return student.getName();
    }

    @Override
    public void getContext(Context context) {
        Log.i("LEON-LONG", context.getClass().getName());
    }

}

