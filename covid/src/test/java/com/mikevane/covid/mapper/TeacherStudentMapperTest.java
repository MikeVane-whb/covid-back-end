package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherStudent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-07-17-26
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class TeacherStudentMapperTest {
    @Autowired
    private TeacherStudentMapper teacherStudentMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void insertTest(){
        TeacherStudent teacherStudent = new TeacherStudent();
        teacherStudent.setStudentId(10);
        teacherStudent.setTeacherId(5);
        Integer insert = teacherStudentMapper.insert(teacherStudent);
        log.error(insert.toString());
    }

}
