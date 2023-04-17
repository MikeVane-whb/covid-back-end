package com.mikevane.covid.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: whb
 * @date: 2023-04-13-21-14
 * @version: 1.0
 */
@Data
public class StudentLeaveDto {
    /**
     * 学号
     */
    @NotBlank(message = "[学号]不能为空")
    @Size(max = 20, message = "编码长度不能超过20")
    @ApiModelProperty("学号")
    @Length(max = 20, message = "编码长度不能超过20")
    private String stuNumber;
    /**
     * 姓名
     */
    @NotBlank(message = "[姓名]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("姓名")
    @Length(max = 255, message = "编码长度不能超过255")
    private String username;
    /**
     * 学院
     */
    @NotBlank(message = "[学院]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("学院")
    @Length(max = 255, message = "编码长度不能超过255")
    private String college;
    /**
     * 出入校类型
     */
    @NotNull(message = "[出入校类型]不能为空")
    @ApiModelProperty("出入校类型")
    private Integer type;
    /**
     * 外出地区
     */
    @NotBlank(message = "[区县]不能为空")
    @Size(max = 20, message = "编码长度不能超过20")
    @ApiModelProperty("区县")
    @Length(max = 20, message = "编码长度不能超过20")
    private String district;
    /**
     * 外出详细地点
     */
    @NotBlank(message = "[外出详细地点]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("外出详细地点")
    @Length(max = 255, message = "编码长度不能超过255")
    private String destination;
    /**
     * 出校理由
     */
    @NotBlank(message = "[出校理由]不能为空")
    @Size(max = 50, message = "编码长度不能超过50")
    @ApiModelProperty("出校理由")
    @Length(max = 50, message = "编码长度不能超过50")
    private String reason;
    /**
     * 出校时间
     */
    @NotNull(message = "[出校时间]不能为空")
    @ApiModelProperty("出校时间")
    private Date leaveTime;
    /**
     * 备注
     */
    @NotBlank(message = "[备注]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("备注")
    @Length(max = 255, message = "编码长度不能超过255")
    private String remark;
    /**
     * 学生id
     */
    @ApiModelProperty("学生id")
    private Integer studentId;
    /**
     * 状态 -1表示未通过 0表示待处理 1表示通过
     */
    @NotNull(message = "[状态 -1表示未通过 0表示待处理 1表示通过]不能为空")
    @ApiModelProperty("状态 -1表示未通过 0表示待处理 1表示通过")
    private Integer status;
}
