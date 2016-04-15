package com.elbbbird.android.common.net;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hailong on 16-3-1.
 */
public class OkHttpSyncPoster extends OkHttpSync {

    public static final MediaType TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private String url;
    private String values;
    private MediaType type;

    private Call call;

    public OkHttpSyncPoster(String url, String values) {
        this(url, values, TYPE_JSON);
    }

    public OkHttpSyncPoster(String url, String values, MediaType type) {
        this(url, values, type, DEFAULT_HTTP_TIMEOUT);
    }

    public OkHttpSyncPoster(String url, String values, MediaType type, int timeout) {
        super(timeout);
        this.url = url;
        this.values = values;
        this.type = type;
    }

    public void post(IOkHttpCallback callback) {
        if (TextUtils.isEmpty(url)) {
            callback.onError(ERROR_CODE_ILLEGAL_URL, "Illegal url");
            return;
        }

        RequestBody body = RequestBody.create(type, values);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        call = getClientInstance(timeout).newCall(request);
        Response response;
        try {
            response = call.execute();
            if (200 == response.code()) {
                String result = response.body().string();
                callback.onSuccess(result);
            } else {
                callback.onError(response.code(), "OkHttp network error:" + response.message());
            }
        } catch (IOException e) {
            //一般的网络连接错误不会，包含在response里，不会执行到这里
            callback.onError(ERROR_CODE_IO_CALL_EXEC, "Call exec error");
        }
    }
}
