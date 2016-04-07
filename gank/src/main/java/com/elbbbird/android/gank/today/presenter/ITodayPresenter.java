package com.elbbbird.android.gank.today.presenter;

import com.elbbbird.android.gank.service.gank.modle.Daily;

import rx.Observable;

/**
 * Created by Hailong Zhang on 2016/4/6.
 */
public interface ITodayPresenter {

    Observable<Daily> getDaily(int year, int month, int day);
}
