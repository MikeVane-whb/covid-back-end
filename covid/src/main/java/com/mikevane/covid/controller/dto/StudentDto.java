package com.mikevane.covid.controller.dto;

import lombok.Data;

/**
 * @author: whb
 * @date: 2023-03-10-17-34
 * @version: 1.0
 */
@Data
public class StudentDto {
    /**
     * 学生姓名
     */
    private String username;

    /**
     * 学号
     */
    private String stuNumber;

    /**
     * 学生邮箱
     */
    private String email;

    /**
     * 学生地址
     */
    private String address;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学生年级以及班级
     */
    private String gradeClass;
}
