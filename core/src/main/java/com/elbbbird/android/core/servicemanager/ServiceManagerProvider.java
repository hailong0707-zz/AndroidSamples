package com.elbbbird.android.core.servicemanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */
public class ServiceManagerProvider extends ContentProvider {

    private static final String TAG = ServiceManagerProvider.class.getSimpleName();

    private static final int URL_MATCH_SERVICE_MANAGER = 0;
    private static final UriMatcher URI_MATCHER;

    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(ServiceManager.AUTHORITY, ServiceManager.PATH_SERVICE_MANAGER, URL_MATCH_SERVICE_MANAGER);
    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int code = URI_MATCHER.match(uri);
        switch (code) {
            case URL_MATCH_SERVICE_MANAGER:
                return ServiceManagerNative.sServiceManagerCursor;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
