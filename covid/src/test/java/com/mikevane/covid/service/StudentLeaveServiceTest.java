package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-14-10-00
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class StudentLeaveServiceTest {
    @Autowired
    private StudentLeaveService studentLeaveService;
    @Test
    public void getRecordsByStudentIdTest(){
        Page studentLeaveDtos = studentLeaveService.getRecordsByStudentId(7,1,1);
        log.info(Arrays.toString(new List[]{studentLeaveDtos.getRecords()}));
    }
}
