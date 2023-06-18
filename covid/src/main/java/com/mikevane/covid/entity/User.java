package com.mikevane.covid.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@NoArgsConstructor
public class User implements Serializable {

    public User(Integer id,String phone, String identity){
        this.id = id;
        this.phone = phone;
        this.identity = identity;
    }

    /**
     * 用户 id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户身份
     */
    private String identity;

    /**
     * 用户创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    /**
     * 用户更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}