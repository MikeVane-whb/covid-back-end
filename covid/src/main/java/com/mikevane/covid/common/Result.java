package com.mikevane.covid.common;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 向前端返回的对象
 * @author: whb
 * @date: 2023-03-02-08-16
 * @version: 1.0
 */
@Data
public class Result<T> {
    /**
     * 响应码
     */
    private String code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 动态数据
     */
    private Map<String,Object> objectMap = new HashMap();

    /**
     * 响应成功
     * @param data 向前端返回的数据
     * @return  返回 Result 对象
     * @param <T>
     */
    public static <T> Result<T> success(T data){
        Result<T> result = new Result();
        result.data = data;
        result.code = ErrorCodeEnum.SUCCESS.getCode();
        result.msg = ErrorCodeEnum.SUCCESS.getMsg();
        return result;
    }

    public static <T> Result<T> success(){
        Result<T> result = new Result();
        result.code = ErrorCodeEnum.SUCCESS.getCode();
        result.msg = ErrorCodeEnum.SUCCESS.getMsg();
        return result;
    }

    /**
     * 响应失败
     * @param code 错误状态码
     * @param msg 错误信息
     * @return 返回 Result 对象
     * @param <T>
     */
    public static <T> Result<T> error(String code,String msg){
        Result<T> result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result();
        result.code = ErrorCodeEnum.SERVER_ERROR.getCode();
        result.msg = ErrorCodeEnum.SERVER_ERROR.getMsg();
        return result;
    }

    public void add(String key, Object value){
        this.objectMap.put(key,value);
    }
}
