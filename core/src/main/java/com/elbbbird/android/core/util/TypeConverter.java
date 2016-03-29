package com.elbbbird.android.core.util;

import android.text.TextUtils;

/**
 * 类型转换工具类
 * <p/>
 * Created by zhanghailong-ms on 2015/5/27.
 */
public class TypeConverter {

    public static long str2Long(String str, long defValue) {
        long ret = defValue;
        try {
            if (!TextUtils.isEmpty(str))
                ret = Long.parseLong(str.trim());
        } catch (Exception ex) {
        }
        return ret;
    }

    /**
     * Converts a byte array into a String hexidecimal characters
     * <p/>
     * null returns null
     */
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null)
            return null;
        String table = "0123456789abcdef";
        StringBuilder ret = new StringBuilder(2 * bytes.length);

        for (byte aByte : bytes) {
            int b;
            b = 0x0f & (aByte >> 4);
            ret.append(table.charAt(b));
            b = 0x0f & aByte;
            ret.append(table.charAt(b));
        }

        return ret.toString();
    }
}
