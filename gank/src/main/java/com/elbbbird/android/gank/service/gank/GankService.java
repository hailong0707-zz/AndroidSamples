package com.elbbbird.android.gank.service.gank;

import com.elbbbird.android.gank.service.gank.modle.Daily;
import com.elbbbird.android.gank.service.gank.modle.News;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Hailong Zhang on 2016/4/6.
 */
public class GankService {

    private static final String URL_BASE = "http://gank.io/";

    public interface Gank {
        @GET("api/day/{year}/{month}/{day}")
        Observable<Daily> getDaily(@Path("year") int year, @Path("month") int month, @Path("day") int day);

        @GET("api/data/{type}/{num}/{page}")
        Observable<List<News>> getNews(@Path("type") String type, @Path("num") int num, @Path("page") int page);
    }

    private static Gank sGank;

    public synchronized static Gank getInstance() {
        if (sGank == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(interceptor);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            sGank = retrofit.create(Gank.class);
        }

        return sGank;
    }

}
