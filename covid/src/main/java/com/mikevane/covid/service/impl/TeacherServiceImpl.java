package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.mapper.TeacherMapper;
import com.mikevane.covid.mapper.TeacherStudentMapper;
import com.mikevane.covid.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author MikeV
* @description 针对表【teacher】的数据库操作Service实现
* @createDate 2023-03-07 10:58:56
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService {

    @Autowired
    private TeacherStudentMapper teacherStudentMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage<Student> getPagesByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize) {
        QueryWrapper<TeacherStudent> teacherStudentQueryWrapper = new QueryWrapper<>();
        List<Integer> list = new ArrayList<>();
        teacherStudentQueryWrapper.eq("teacher_id",5);
        List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectList(teacherStudentQueryWrapper);
        teacherStudentList.forEach((teacherStudent) -> {
            list.add(teacherStudent.getStudentId());
        });
        IPage<Student> studentIPage = new Page<>(pageNum,pageSize);
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in("id",list);
        return studentMapper.selectPage(studentIPage, studentQueryWrapper);
    }
}




