package com.mikevane.covid.utils;

import java.lang.reflect.Field;

/**
 * @author: whb
 * @date: 2023-03-03-13-33
 * @version: 1.0
 */
public class ObjectUtil {
    /**
     * 判断对象中所有字段是否都不为空
     * @param obj 传入对象
     * @return 如果存在字段为空的情况则返回 false，如果所有字段都不为空则返回 true
     */
    public static boolean checkObjAllFieldsIsNotNull(Object obj){
        if (obj == null) return false;
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null || StringUtil.isNull(field.get(obj).toString())){
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
