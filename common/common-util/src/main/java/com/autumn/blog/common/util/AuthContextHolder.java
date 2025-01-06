package com.autumn.blog.common.util;

/**
 * 获取当前用户信息帮助类
 */
public class AuthContextHolder {

    private static ThreadLocal<Long> userContext = new ThreadLocal<Long>();

    public static void setUser(Long userId) {
        userContext.set(userId);
    }

    public static Long getUserId() {
        return userContext.get();
    }

    public static void clear() {
        userContext.remove();
    }
}
