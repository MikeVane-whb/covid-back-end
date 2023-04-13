package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-30-17-02
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class StudentClockServiceTest {
    @Autowired
    private StudentClockService studentClockService;
    @Autowired
    private StudentService studentService;

    @Test
    public void getGrade(){

    }
}
