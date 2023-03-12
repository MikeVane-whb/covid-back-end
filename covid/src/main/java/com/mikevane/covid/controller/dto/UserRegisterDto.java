package com.mikevane.covid.controller.dto;

import lombok.Data;

/**
 * @author: whb
 * @date: 2023-03-07-12-43
 * @version: 1.0
 */
@Data
public class UserRegisterDto {
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 第二次输入的密码
     */
    private String rePassword;
    /**
     * 用户身份
     */
    private String identity;
}
