package com.elbbbird.android.common.util;

/**
 * 类型转换工具类
 * <p/>
 * Created by zhanghailong-ms on 2015/5/27.
 */
public class TypeConverter {

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
