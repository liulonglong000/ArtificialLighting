package com.face.utils;

import java.util.UUID;

public class IdUtil {
    /**
     * 生成UUID
     * @return
     */
    public static String createId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
