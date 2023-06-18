package com.mikevane.covid.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期相关的工具类
 * @author: whb
 * @date: 2023-03-22-16-02
 * @version: 1.0
 */
public class TimeUtil {
    /**
     * 根据指定格式返回时间
     * @param pattern 时间格式 ex:yyyy-MM-dd
     * @return 当前时间
     */
    public static String getLocalTimeDateByPattern(LocalDateTime localDateTime,String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;
    }

    /**
     * 根据指定格式判断源时间是否与现日期相同
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static boolean equalsCurrentTime(LocalDateTime localDateTime, String pattern){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return currentTime.format(formatter).equals(localDateTime.format(formatter));
    }

}
