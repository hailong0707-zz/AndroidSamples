package com.elbbbird.android.common.net;

import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by zhanghailong-ms on 2015/7/9.
 */
public class OkHttpSyncFetcher extends OkHttpSync {

    private File file;
    private String url;

    private Call call;

    public OkHttpSyncFetcher(File file, String url) {
        this(file, url, DEFAULT_HTTP_TIMEOUT);
    }

    public OkHttpSyncFetcher(File file, String url, int timeout) {
        super(timeout);
        this.file = file;
        this.url = url;
    }

    public void fetch(IOkHttpCallback callback) {
        if (TextUtils.isEmpty(url)) {
            callback.onError(ERROR_CODE_ILLEGAL_URL, "url is null");
            return;
        }

        Request request;
        try {
            request = new Request.Builder()
                    .url(url)
                    .build();
        } catch (Exception e) {
            callback.onError(ERROR_CODE_ILLEGAL_URL, e.getMessage());
            return;
        }

        call = getClientInstance(timeout).newCall(request);
        Response response;
        try {
            response = call.execute();
            if (200 == response.code()) {
                File parent = file.getParentFile();
                if (!parent.isDirectory()) {
                    parent.mkdirs();
                }
                if (file.isFile()) {
                    file.delete();
                }
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    callback.onError(ERROR_CODE_IO_CREATE, e.getMessage());
                    return;
                }

                OutputStream output = null;
                InputStream input = null;
                int read;
                int current = 0;
                long total = 0;
                try {
                    output = new FileOutputStream(file);
                    input = response.body().byteStream();
                    total = response.body().contentLength();

                    byte[] buffer = new byte[4096];

                    while ((read = input.read(buffer)) > 0) {
                        output.write(buffer, 0, read);
                        current += read;

                        callback.onProgress(current, total);
                    }
                    output.flush();
                } catch (IOException e) {
                    callback.onError(ERROR_CODE_IO_WRITE, e.getMessage());
                    return;
                } finally {
                    if (input != null)
                        input.close();
                    if (output != null)
                        output.close();
                }
                callback.onSuccess("SUCCESS");
            } else {
                callback.onError(response.code(), "OkHttp network error:" + response.message());
            }
        } catch (IOException e) {
            //一般的网络连接错误不会，包含在response里，不会执行到这里
            callback.onError(ERROR_CODE_IO_CALL_EXEC, "Call exec error");
        }
    }


    /**
     * 取消下载
     */
    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
