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
@NoArgsConstructor
@AllArgsConstructor
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
    private Map<String,Object> map = new HashMap();

    /**
     * 响应成功
     * @param data 向前端返回的数据
     * @return  返回 Result 对象
     * @param <T>
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getMsg(),data,null);
    }

    public static <T> Result<T> success(){
        return new Result<T>(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getMsg(),null,null);
    }

    /**
     * 响应失败
     * @param code 错误状态码
     * @param msg 错误信息
     * @return 返回 Result 对象
     * @param <T>
     */
    public static <T> Result<T> error(String code,String msg){
        return new Result<T>(code,msg,null,null);
    }

    public static <T> Result<T> error(){
        return new Result<T>(ErrorCodeEnum.SERVER_ERROR.getCode(),ErrorCodeEnum.SERVER_ERROR.getMsg(),null,null);
    }

    public Result<T> add(String key, Object value){
        map.put(key,value);
        return this;
    }
}
