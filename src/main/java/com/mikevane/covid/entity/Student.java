package com.mikevane.covid.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
* @TableName student
*/
@Data
public class Student implements Serializable {

    /**
    * id
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 学生姓名
    */
    @NotBlank(message="[学生姓名]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("学生姓名")
    @Length(max= 50,message="编码长度不能超过50")
    private String username;
    /**
    * 学生班级
    */
    @NotBlank(message="[学生班级]不能为空")
    @Size(max= 10,message="编码长度不能超过10")
    @ApiModelProperty("学生班级")
    @Length(max= 10,message="编码长度不能超过10")
    private String gradeClass;
    /**
    * 学号
    */
    @NotBlank(message="[学号]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("学号")
    @Length(max= 20,message="编码长度不能超过20")
    private String stuNumber;
    /**
    * 电子邮箱
    */
    @NotBlank(message="[电子邮箱]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    @ApiModelProperty("电子邮箱")
    @Length(max= 50,message="编码长度不能超过50")
    private String email;
    /**
    * 出生日期
    */
    @ApiModelProperty("出生日期")
    private Date birthday;
    /**
    * 性别
    */
    @NotBlank(message="[性别]不能为空")
    @Size(max= 8,message="编码长度不能超过8")
    @ApiModelProperty("性别")
    @Length(max= 8,message="编码长度不能超过8")
    private String sex;
    /**
    * 民族
    */
    @NotBlank(message="[民族]不能为空")
    @Size(max= 8,message="编码长度不能超过8")
    @ApiModelProperty("民族")
    @Length(max= 8,message="编码长度不能超过8")
    private String nation;
    /**
     * 手机号码
     */
    @NotBlank(message="[手机]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("手机")
    @Length(max= 20,message="编码长度不能超过20")
    private String phone;
    /**
    * 入学日期
    */
    @ApiModelProperty("入学日期")
    private Date admissionDate;
    /**
    * 专业
    */
    @NotBlank(message="[专业]不能为空")
    @Size(max= 10,message="编码长度不能超过10")
    @ApiModelProperty("专业")
    @Length(max= 10,message="编码长度不能超过10")
    private String major;
    /**
    * 学院
    */
    @NotBlank(message="[学院]不能为空")
    @Size(max= 10,message="编码长度不能超过10")
    @ApiModelProperty("学院")
    @Length(max= 10,message="编码长度不能超过10")
    private String college;
    /**
    * 学生对应的 userid
    */
    @NotNull(message="[学生对应的 userid]不能为空")
    @ApiModelProperty("学生对应的 userid")
    private Integer userId;
    /**
    * 创建时间
    */
    @NotNull(message="[创建时间]不能为空")
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    @NotNull(message="[更新时间]不能为空")
    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;
}
