package com.mikevane.covid.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-31-11-02
 * @version: 1.0
 */
@Slf4j
public class ListUtil {
    /**
     *
     * @param lists 替换的 list
     * @param sourceObject 被替换的元素
     * @param targetObject 替换元素
     * @param <T>
     */
    public static <T> void replaceElement(List<T> lists, T sourceObject, T targetObject){
        lists.replaceAll(list -> list.equals(sourceObject) ?  targetObject : list);
    }

    public static <T,S> void copyProperties(List<T> source, List<S> target, Class<?> objectClass){
        if (source == null || source.size() == 0 || target == null){
            throw new NullPointerException("ListUtil -> copyProperties -> List 不能为空");
        }
        // 赋值
        source.forEach(object -> {
            try {
                Object o = objectClass.newInstance();
                BeanUtils.copyProperties(object, o);
                target.add((S) o);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
