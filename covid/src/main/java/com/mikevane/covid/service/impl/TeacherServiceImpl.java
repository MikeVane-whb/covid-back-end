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
import com.mikevane.covid.utils.StringUtil;
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
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public IPage<Student> getPagesByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize, String studentName) {
        QueryWrapper<TeacherStudent> teacherStudentQueryWrapper = new QueryWrapper<>();
        List<Integer> list = new ArrayList<>();
        // 设置查询的teacher_id
        teacherStudentQueryWrapper.eq("teacher_id",5);
        // 查询老师管理的学生 id
        List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectList(teacherStudentQueryWrapper);
        teacherStudentList.forEach((teacherStudent) -> {list.add(teacherStudent.getStudentId());});
        // 通过学生 id 进行分页查询学生信息
        IPage<Student> studentIPage = new Page<>(pageNum,pageSize);
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in("id",list);
        // 模糊查询 studentName
        if (!StringUtil.isNull(studentName)){
            studentQueryWrapper.like("username",studentName);
        }
        return studentMapper.selectPage(studentIPage, studentQueryWrapper);
    }

    @Override
    public List<Student> getOthersStuByTeacherId(Integer teacherId) {
        return teacherMapper.selectOthersStudents(teacherId);
    }
}




