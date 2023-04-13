package com.mikevane.covid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户打卡实体类
 * @author: whb
 * @date: 2023-03-22-16-55
 * @version: 1.0
 */
@Data
public class StudentClock implements Serializable {

    /**
     * id
     */
    @NotNull(message = "[id]不能为空")
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 学生姓名
     */
    @NotBlank(message = "[学生姓名]不能为空")
    @Size(max = 20, message = "编码长度不能超过20")
    @ApiModelProperty("学生姓名")
    @Length(max = 20, message = "编码长度不能超过20")
    private String username;
    /**
     * 学生班级
     */
    @NotBlank(message = "[学生班级]不能为空")
    @Size(max = 10, message = "编码长度不能超过10")
    @ApiModelProperty("学生班级")
    @Length(max = 10, message = "编码长度不能超过10")
    private String gradeClass;
    /**
     * 学生对应的id
     */
    @NotNull(message = "[学生对应的id]不能为空")
    @ApiModelProperty("学生对应的id")
    private Integer studentId;
    /**
     * 打卡地点
     */
    @NotBlank(message = "[打卡地点]不能为空")
    @Size(max = 50, message = "编码长度不能超过50")
    @ApiModelProperty("打卡地点")
    @Length(max = 50, message = "编码长度不能超过50")
    private String address;
    /**
     * 身体状态 0健康 1疑似病例 2确诊
     */
    @NotNull(message = "[身体状态 0健康 1疑似病例 2确诊]不能为空")
    @ApiModelProperty("身体状态 0健康 1疑似病例 2确诊")
    private Integer status;
    /**
     * 出行信息 0去过疫情高风险地区 1没有去过疫情高风险地区
     */
    @NotBlank(message = "[出行信息 0去过疫情高风险地区 1没有去过疫情高风险地区]不能为空")
    @Size(max = 30, message = "编码长度不能超过30")
    @ApiModelProperty("出行信息 0去过疫情高风险地区 1没有去过疫情高风险地区")
    @Length(max = 30, message = "编码长度不能超过30")
    private String travelInfo;
    /**
     * 是否接触疑似或确诊病例 0没有接触过 1接触过
     */
    @NotNull(message = "[是否接触疑似或确诊病例 0没有接触过 1接触过]不能为空")
    @ApiModelProperty("是否接触疑似或确诊病例 0没有接触过 1接触过")
    private Integer contactCase;
    /**
     * 打卡时间
     */
    @NotNull(message = "[打卡时间]不能为空")
    @ApiModelProperty("打卡时间")
    private LocalDateTime clockTime;
}
