package com.mikevane.covid.controller.dto;

import lombok.Data;

/**
 * @author: whb
 * @date: 2023-03-21-12-48
 * @version: 1.0
 */
@Data
public class TeacherDto {
    /**
     * 老师姓名
     */
    private String username;
    /**
     * 老师性别
     */
    private String sex;
    /**
     * 老师邮箱
     */
    private String email;
    /**
     * 老师地址
     */
    private String address;
}
