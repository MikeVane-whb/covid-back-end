package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.mapper.TeacherMapper;
import com.mikevane.covid.mapper.TeacherStudentMapper;
import com.mikevane.covid.service.TeacherStudentService;
import com.mikevane.covid.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* @author MikeV
* @description 针对表【teacher_student】的数据库操作Service实现
* @createDate 2023-03-07 10:58:59
*/
@Service
public class TeacherStudentServiceImpl extends ServiceImpl<TeacherStudentMapper, TeacherStudent>
    implements TeacherStudentService {
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
        teacherStudentQueryWrapper.eq("teacher_id",teacherId);
        // 查询老师管理的学生 id
        List<TeacherStudent> teacherStudentList = teacherStudentMapper.selectList(teacherStudentQueryWrapper);
        if (teacherStudentList == null || teacherStudentList.size() < 1){
            return new Page<>();
        }
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

    @Override
    @Transactional
    public boolean deleteRelation(Integer teacherId, Integer studentId) {
        QueryWrapper<TeacherStudent> queryWrapper = new QueryWrapper();
        queryWrapper.eq("teacher_id",teacherId);
        queryWrapper.eq("student_id",studentId);
        if (teacherStudentMapper.delete(queryWrapper) == 1){
            throw new ServiceException(ErrorCodeEnum.DELETE_ERROR.getCode(), ErrorCodeEnum.DELETE_ERROR.getMsg());
        }
        return true;
    }

    @Override
    @Transactional
    public boolean deleteBatchRelation(Integer teacherId, List<Integer> studentIds) {
        QueryWrapper<TeacherStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id",teacherId);
        queryWrapper.in("student_id",studentIds);
        return teacherStudentMapper.delete(queryWrapper) >= 1 ? true : false;
    }
}




