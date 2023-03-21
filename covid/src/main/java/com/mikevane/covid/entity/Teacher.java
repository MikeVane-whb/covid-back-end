package com.mikevane.covid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @TableName teacher
 */
@TableName(value ="teacher")
@Data
public class Teacher implements Serializable {
    /**
     * 老师 id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 老师姓名
     */
    private String username;

    /**
     * 性别
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



    /**
     * 老师的 userId
     */
    private Integer userId;

    /**
     * 老师用户创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    /**
     * 老师用户更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}