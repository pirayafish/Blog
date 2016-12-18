package com.moli.core;

import java.util.Date;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * 常量类.
 * @author Lo&Wang
 */
public class Const {
    public static final String username = "zhengmo";
    public static final String password = "zhengmo";
    public static final String SESSION_USER = "SESSION_USER";
    /**
     * fastJSON序列化,配置.
     */
    public static SerializeConfig mapping = new SerializeConfig();
    /**
     * fastJSON时间格式化.
     */
    private static String dateFormat;
    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }
}
