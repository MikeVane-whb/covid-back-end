package com.mikevane.covid.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * 字符串工具类
 * @author: whb
 * @date: 2023-03-02-11-12
 * @version: 1.0
 */
public class StringUtil {
    /**
     * 判断字符串是否为空
     * @param string
     * @return 如果字符串为空字符串 或者为 null 则返回 true
     *         否则返回 false
     */
    public static boolean isNull(String string){
        if (string == null || StringUtils.isBlank(string)){
            return true;
        }
        return false;
    }
}
