package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mikevane.covid.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

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
        student.setAddress("重庆邮电大学");
        student.setGradeClass("340719031");
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateByStudent(student);
    }
}
