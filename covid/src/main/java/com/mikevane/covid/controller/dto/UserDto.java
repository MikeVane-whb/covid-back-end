package com.mikevane.covid.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 用于接收前端请求的参数
 * @author: whb
 * @date: 2023-03-01-14-32
 * @version: 1.0
 */
@Data
public class UserDto {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户身份
     */
    private String identity;
    /**
     * token
     */
    private String token;
}
