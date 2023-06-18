package com.mikevane.covid.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 
 * @TableName notice
 */
@TableName(value ="notice")
@Data
public class Notice implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 通知的标题
     */
    private String title;

    /**
     * 通知发布的日期和时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date publishTime;

    /**
     * 发布通知的教师或工作人员的姓名
     */
    private String publisher;

    /**
     * 发布通知的教师或工作人员的id
     */
    private Integer publisherId;

    /**
     * 通知的具体内容
     */
    private String content;

    /**
     * 通知的接收者，班级 0 老师 1
     */
    private Integer receiver;

    /**
     * 通知的状态，已发布 0、已撤销 1、已过期 2
     */
    private Integer status;

    /**
     * 通知创建时间
     */
    @NotNull(message="[创建时间]不能为空")
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    /**
     * 通知更新时间
     */
    @NotNull(message="[更新时间]不能为空")
    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}