package com.elbbbird.android.common.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by hailong on 16-3-1.
 */
public class OkHttpSync {

    protected static final int DEFAULT_HTTP_TIMEOUT = 60;
	protected static final int ERROR_CODE_IO_CREATE = 1700; // 路径读写权限
	protected static final int ERROR_CODE_IO_WRITE = 1701; // 网络连接读写超时
	protected static final int ERROR_CODE_IO_CALL_EXEC = 1702;
	protected static final int ERROR_CODE_ILLEGAL_URL = 1703;

	protected int timeout = 0;

	protected static OkHttpClient client;
	protected static OkHttpClient getClientInstance(int timeSeconds) {

		if (client == null) {
			client = new OkHttpClient.Builder().connectTimeout(timeSeconds, TimeUnit.SECONDS)
					.readTimeout(timeSeconds, TimeUnit.SECONDS)
					.writeTimeout(timeSeconds, TimeUnit.SECONDS).build();
		}
		return client;
	}

	public OkHttpSync(int timeout) {
		this.timeout = timeout;
	}
}
