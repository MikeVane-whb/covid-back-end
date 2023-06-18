package com.mikevane.covid.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: whb
 * @date: 2023-03-31-17-16
 * @version: 1.0
 */
@Data
public class TeacherClockDto {
    private Integer studentId;
    private String username;
    private String stuNumber;
    private String address;
    private Integer status;
    private Integer contactCase;
    private LocalDateTime clockTime;
}
