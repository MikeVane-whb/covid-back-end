package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.StudentClock;
import com.mikevane.covid.utils.ListUtil;
import com.mikevane.covid.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author: whb
 * @date: 2023-03-07-17-13
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void insertTest(){
        Student student = new Student();
        student.setUserId(3);
        student.setUsername("mike");
        studentMapper.insert(student);
        log.error(student.getId().toString());
    }

    @Test
    public void updateTest(){
        Student student = new Student();
        student.setId(5);
        student.setGradeClass("340719031");
    }

    @Test
    public void selectDistinctGradesTest(){
        List<String> stringList = studentMapper.selectDistinctGrades();
        ListUtil.replaceElement(stringList,"","default");
        log.info(Arrays.toString(stringList.toArray()));
    }



}
