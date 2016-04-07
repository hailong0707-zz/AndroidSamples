package com.elbbbird.android.gank.today.presenter;

import com.elbbbird.android.gank.service.gank.GankService;
import com.elbbbird.android.gank.service.gank.modle.Daily;
import com.elbbbird.android.gank.today.view.ITodayFragment;

import rx.Observable;

/**
 * Created by Hailong Zhang on 2016/4/6.
 */
public class TodayPresenter implements ITodayPresenter {

    ITodayFragment mFragment;

    public TodayPresenter(ITodayFragment fragment) {
        this.mFragment = fragment;
    }

    @Override
    public Observable<Daily> getDaily(int year, int month, int day) {
        return GankService.getInstance().getDaily(year, month, day);
    }
}
