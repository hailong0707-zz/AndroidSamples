package com.elbbbird.android.common.net;

/**
 * Created by zhanghailong on 2016/2/29.
 */
public interface IOkHttpCallback {

    void onProgress(long progress, long total);

    void onError(int errorCode, String desc);

    void onSuccess(String result);
}
