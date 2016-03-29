package com.elbbbird.android.core.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */
public class SystemUtil {

    private static final String TAG = SystemUtil.class.getSimpleName();

    /**
     * 获取外部存储目录即 SDCard
     *
     * @param context context
     * @return SDCARD
     */
    public static String getExternalStoragePath(Context context) {
        String result = null;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Object storageManager = context.getApplicationContext().getSystemService(Context.STORAGE_SERVICE);
                Method getVolumeList = storageManager.getClass().getMethod(
                        "getVolumeList", (Class[]) null);
                Method getVolumeState = storageManager.getClass().getMethod(
                        "getVolumeState", String.class);
                Object[] storageVolumes = (Object[]) getVolumeList.invoke(
                        storageManager, (Object[]) null);
                Object storageVolume = storageVolumes[0];
                Method getPath = storageVolume.getClass().getMethod("getPath",
                        (Class[]) null);
                for (int i = 0; i < storageVolumes.length; i++) {
                    storageVolume = storageVolumes[i];
                    String path = (String) getPath.invoke(storageVolume,
                            (Object[]) null);
                    if (Environment.MEDIA_MOUNTED.equals(getVolumeState.invoke(
                            storageManager, path))) {
                        result = path;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        if (result == null) {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                result = Environment.getExternalStorageDirectory().getAbsolutePath();
            }
        }

        return result;
    }

    public static long checkDiskFreeSize(String path) {
        long freeSize = 0;
        if (path == null) {
            return freeSize;
        }
        try {
            StatFs statFs = new StatFs(path);
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            freeSize = availableBlocks * blockSize;
            Log.d(TAG, "Check " + path + " free size:" + freeSize);
        } catch (Exception e) {
            Log.e(TAG, "Check free size error:" + path, e);
            freeSize = 0;
        }
        return freeSize;
    }
}
