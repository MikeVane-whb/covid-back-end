package com.mikevane.covid.entity;

/**
 * @author: whb
 * @date: 2023-04-13-19-41
 * @version: 1.0
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 *
 * @TableName student_leave
 */
@Data
public class StudentLeave implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @NotNull(message = "[]不能为空")
    @ApiModelProperty("id")
    private Integer id;
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
     * 班级
     */
    @NotBlank(message = "[班级]不能为空")
    @Size(max = 20, message = "编码长度不能超过20")
    @ApiModelProperty("班级")
    @Length(max = 20, message = "编码长度不能超过20")
    private String gradeClass;
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
    /**
     * 创建时间
     */
    @NotNull(message = "[创建时间]不能为空")
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
