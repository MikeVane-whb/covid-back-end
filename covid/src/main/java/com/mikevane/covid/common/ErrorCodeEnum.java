package com.mikevane.covid.common;

/**
 * 定义返回状态码
 * @author: whb
 * @date: 2023-03-01-14-21
 * @version: 1.0
 */
public enum ErrorCodeEnum {
    /**
     *  登录成功状态码
     */
    SUCCESS("200","success"),
    /**
     * 用户密码错误状态码
     */
    PASSWORD_ERROR("1001","帐号或密码错误"),
    /**
     * 非法输入状态码
     */
    ILLEGAL_ERROR("1002","非法输入"),
    /**
     * 用户已存在错误
     */
    USER_IS_EXIST("1003","用户已存在"),
    /**
     * 分页查询失败
     */
    PAGE_ERROR("1004","分页查询失败"),
    /**
     * 更新失败状态码
     */
    UPDATE_ERROR("1005","编辑失败"),
    /**
     * 查询失败
     */
    SELECT_ERROR("1006","查询失败"),
    /**
     * 插入失败
     */
    INSERT_ERROR("1007","添加失败"),
    /**
     * 服务器错误状态码
     */
    SERVER_ERROR("500","系统错误");

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    @Override
    public java.lang.String toString() {
        return "ErrorCodeEnum{" + "code='" + code + '\'' + ", msg='" + msg + '\'' + '}';
    }
}
