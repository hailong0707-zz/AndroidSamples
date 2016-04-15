package com.elbbbird.android.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * 文件操作类
 * <p/>
 * Created by zhanghailong-ms on 2015/5/27.
 */
public class FileUtil {

    private static final String TAG = FileUtil.class.getSimpleName();

    /**
     * 计算文件 MD5，返回十六进制串
     */
    public static String getFileMD5(String filename) {
        byte[] digest = MD5(filename);
        if (digest == null) {
            return null;
        } else {
            return TypeConverter.bytesToHexString(digest);
        }
    }

    /**
     * 计算文件 MD5，返回 byte []. 如果文件不存在，返回 null.
     */
    public static byte[] MD5(String filename) {
        return MD5(new File(filename));
    }

    public static byte[] MD5(File file) {
        BufferedInputStream in = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            in = new BufferedInputStream(new FileInputStream(file));

            int theByte = 0;
            byte[] buffer = new byte[1024];
            while ((theByte = in.read(buffer)) != -1) {
                md.update(buffer, 0, theByte);
            }
            in.close();

            return md.digest();
        } catch (Exception e) {
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (Exception e) {
                }
        }

        return null;
    }

}
