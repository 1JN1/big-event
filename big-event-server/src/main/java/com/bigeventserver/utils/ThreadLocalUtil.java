package com.bigeventserver.utils;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description
 **/
public class ThreadLocalUtil {


    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setUserId(Long userId) {
        threadLocal.set(userId);
    }

    public static Long getUserId() {
        return threadLocal.get();
    }
}
