package com.mikevane.covid.service;

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
 * @date: 2023-03-10-19-00
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class TeacherStudentServiceTest {
    @Autowired
    private TeacherStudentService teacherStudentService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

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

    @Test
    public void deleteBatchRelationTest(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        boolean deleteBatchRelation = teacherStudentService.deleteBatchRelation(5, list);
        if (deleteBatchRelation){
            log.info("删除成功");
        }else {
            log.info("删除失败");
        }
    }
}
