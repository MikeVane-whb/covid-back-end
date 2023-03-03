package com.mikevane.covid.common;

/**
 * 定义返回状态码
 * @author: whb
 * @date: 2023-03-01-14-21
 * @version: 1.0
 */
public interface HttpConstant {
    /**
     *  登录成功状态码
     */
    String SUCCESS_CODE = "200";

    /**
     * 用户密码错误状态码
     */
    String PASSWORD_ERROR = "401";

    /**
     * 非法输入
     */
    String ILLEGAL_ERROR = "410";

    /**
     * 服务器错误状态码
     */
    String SERVER_ERROR = "500";

}
