package com.autumn.blog.common.constant;

/**
 * @author autumn
 * @description
 * @date 2024年11月14日
 * @version: 1.0
 */
public class RedisConstant {
    // 用户 token 缓存前缀
    public static final String USER_LOGIN_KEY_PREFIX = "user:login:";
    // token 过期时间
    public static final int USER_LOGIN_KEY_TIMEOUT = 60 * 60 * 24 * 100;

    /**
     * 字典信息
     */
    public static final String SYS_DICT = "sys_dict";
    public static final int SYS_DICT_KEY_TIMEOUT = 2;

}
