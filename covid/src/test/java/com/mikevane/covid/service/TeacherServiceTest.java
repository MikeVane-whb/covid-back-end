package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-10-19-01
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class TeacherServiceTest {
    @Autowired
    private TeacherStudentService teacherStudentService;
    @Autowired
    private StudentService studentService;

    @Test
    public void getPagesByTeacherId(){
        QueryWrapper<TeacherStudent> teacherStudentQueryWrapper = new QueryWrapper<>();
        List<Integer> list = new ArrayList<>();
        teacherStudentQueryWrapper.eq("teacher_id",5);
        List<TeacherStudent> teacherStudentList = teacherStudentService.list(teacherStudentQueryWrapper);
        teacherStudentList.forEach((teacherStudent) -> {
            list.add(teacherStudent.getStudentId());
        });
        IPage<Student> studentIPage = new Page<>(2,2);
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in("id",list);
        IPage<Student> page = studentService.page(studentIPage, studentQueryWrapper);
    }
}
