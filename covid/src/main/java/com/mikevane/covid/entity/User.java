package com.mikevane.covid.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String identity;
    @TableField(value = "create_time" ,fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableField(value = "update_time" ,fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;

}
