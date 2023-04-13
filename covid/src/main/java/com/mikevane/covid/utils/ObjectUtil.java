package com.mikevane.covid.utils;

import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.exception.ObjectException;

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

    /**
     * 根据 type 与 value 批量替换对象中的属性值
     * @param obj 对象
     * @param replaceType 需要被替换属性的 type
     * @param targetObj 需要被替换的属性值
     * @param replaceObj 替换的属性值
     * @throws IllegalAccessException
     */
    public static void replaceFieldValueByType(Object obj, Class replaceType, Object targetObj, Object replaceObj){
        if (obj == null){
            throw new NullPointerException("Obj can not be null");
        }
        if (replaceType == null){
            throw new NullPointerException("ReplaceClass can not be null");
        }
        if (replaceObj == null){
            throw new NullPointerException("ReplaceObj can not be null");
        }
        if (!replaceType.equals(replaceObj.getClass())){
            throw new ObjectException(ErrorCodeEnum.SERVER_ERROR.getCode(),ErrorCodeEnum.SERVER_ERROR.getMsg(), "替换类型不匹配");
        }
        Class<?> objClass = obj.getClass();
        for (Field declaredField : objClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            // 属性 type 相同
            if (replaceType.equals(declaredField.getType())){
                Object value;
                try {
                    value = declaredField.get(obj);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                // 属性 value 相同
                if (targetObj == null || value.equals(targetObj)){
                    // 替换值
                    try {
                        declaredField.set(obj,replaceObj);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    /**
     * 根据名称修改对象中的属性值
     * @param obj 被修改的对象
     * @param paramName 属性名
     * @param replaceObj 替换的属性值
     */
    public static void replaceFieldValueByName(Object obj,String paramName,Object replaceObj){
        if (obj == null){
            throw new NullPointerException("obj can not be null");
        }
        if (paramName == null){
            throw new NullPointerException("paramName can not be null");
        }
        if (replaceObj == null){
            throw new NullPointerException("replaceObj can not be null");
        }
        Class<?> objClass = obj.getClass();
        for (Field declaredField : objClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            if (declaredField.getName().equals(paramName)) {
                if (!declaredField.getType().equals(replaceObj.getClass())){
                    throw new ObjectException(ErrorCodeEnum.SERVER_ERROR.getCode(),ErrorCodeEnum.SERVER_ERROR.getMsg(),"属性名对应的类型与替换类型不匹配");
                }
                try {
                    declaredField.set(obj,replaceObj);
                    break;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
