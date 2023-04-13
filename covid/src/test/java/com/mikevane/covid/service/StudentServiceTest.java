package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.controller.dto.StudentGradeDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-09-10-43
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class StudentServiceTest {
    @Resource
    private StudentService studentService;

    @Test
    public void selectListByGradeClassTest(){
        IPage<StudentGradeDto> iPage = studentService.selectPageByGradeClass(1,3,"34071903",null);
        List<StudentGradeDto> studentGradeDtos = iPage.getRecords();
        studentGradeDtos.forEach(studentGradeDto -> log.info(studentGradeDto.toString()));
    }

}
