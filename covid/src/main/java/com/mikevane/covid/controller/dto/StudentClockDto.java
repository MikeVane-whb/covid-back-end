package com.mikevane.covid.controller.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: whb
 * @date: 2023-03-22-16-53
 * @version: 1.0
 */
@Data
public class StudentClockDto {
    /**
     * id
     */
    private Integer id;
    /**
     * 学生姓名
     */
    private String username;
    /**
     * 学生班级
     */
    private String gradeClass;
    /**
     * 学生对应的id
     */
    private Integer studentId;
    /**
     * 打卡地点
     */
    private String address;
    /**
     * 身体状态 0健康 1疑似病例 2确诊
     */
    private Integer status;
    /**
     * 出行信息 0去过疫情高风险地区 1没有去过疫情高风险地区
     */
    private String travelInfo;
    /**
     * 是否接触疑似或确诊病例 0没有接触过 1接触过
     */
    private Integer contactCase;
    /**
     * 打卡时间
     */
    private Date clockTime;
}
