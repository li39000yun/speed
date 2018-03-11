package com.lyq.common.utils;

import java.util.UUID;

/**
 * UUID工具类
 * Created by 云强 on 2018/3/9.
 */
public class UUIDUtils {

    // 生成UUID
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }
}
