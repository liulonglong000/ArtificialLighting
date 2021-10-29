package com.face.common;

/**
 * 常量
 */
public class FaceConstants {
    // 抓拍图片，当前时间之前 AVAILABLE_TIME 毫秒可见
    public static final int AVAILABLE_TIME = 5 * 60 * 1000;

    // 抓拍图片，过期删除时间（默认90天自动删除）
    public static final int CAPTURE_PHOTO_EXPIRE = 90;

    // session过期时间（默认1小时，单位秒）
    public static final int SESSION_EXPIRE = 3600;

}
