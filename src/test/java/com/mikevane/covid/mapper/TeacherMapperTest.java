package com.mikevane.covid.mapper;

import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-10-18-17
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class TeacherMapperTest {
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void insertTest(){
        Teacher teacher = new Teacher();
        teacher.setUsername("steven");
        teacher.setUserId(2);
//        teacherMapper.insert()
    }

    @Test
    public void selectOthersStudentsTest(){
        List<Student> list = teacherMapper.selectOthersStudents(5);
        list.forEach(student -> System.out.println(student));
    }
}
