package com.elbbbird.android.gank.today.view;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.elbbbird.android.gank.R;
import com.elbbbird.android.gank.common.BaseActivity;
import com.elbbbird.android.gank.common.BaseFragment;
import com.elbbbird.android.gank.service.gank.modle.Daily;
import com.elbbbird.android.gank.today.presenter.ITodayPresenter;
import com.elbbbird.android.gank.today.presenter.TodayPresenter;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Hailong Zhang on 2016/4/5.
 */
public class TodayFragment extends BaseFragment implements ITodayFragment {

    private static final String TAG = TodayFragment.class.getSimpleName();

    private static BaseActivity mActivity;
    private static TodayFragment mInstance;

    private Toolbar mToolbar;
    private ITodayPresenter mPresenter;
    private Daily mDaily;

    public static TodayFragment getInstance(BaseActivity activity) {
        if (mInstance == null) {
            mInstance = new TodayFragment();
            mActivity = activity;
        }

        return mInstance;
    }

    @Override
    public View inflate(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.app_bar_today, container, false);
    }

    @Override
    public void initData() {
        mPresenter = new TodayPresenter(this);
    }

    @Override
    public void initViews(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mActivity.initToolbar(mToolbar);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_today, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            mPresenter.getDaily(2016, 4, 5)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Daily>() {
                        @Override
                        public void onCompleted() {
                            Timber.i("");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Timber.e(e.getMessage());
                        }

                        @Override
                        public void onNext(Daily daily) {
                            Timber.i(daily.getResults().getAndroids().get(0).getDesc());
                        }
                    });

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void test() {

    }
}
