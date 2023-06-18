package com.mikevane.covid.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;


/**
 * @author: whb
 * @date: 2023-03-23-11-21
 * @version: 1.0
 */
@Data
@ToString
public class StudentGradeDto {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 学号
     */
    private String stuNumber;

    /**
     * 学生姓名
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 学生年级以及班级
     */
    private String gradeClass;

    /**
     * 学生手机
     */
    private String phone;
}
