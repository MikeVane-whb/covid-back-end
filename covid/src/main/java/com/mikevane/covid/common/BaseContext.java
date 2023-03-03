package com.mikevane.covid.common;

/**
 * 基于ThreadLocal封装工具类，用户保存和获取当前登录用户id
 * @author: whb
 * @date: 2023-02-28-23-13
 * @version: 1.0
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
