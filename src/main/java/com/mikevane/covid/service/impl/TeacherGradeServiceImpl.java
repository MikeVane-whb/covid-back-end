package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherGrade;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.mapper.TeacherGradeMapper;
import com.mikevane.covid.service.TeacherGradeService;
import com.mikevane.covid.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-19-01-41
 * @version: 1.0
 */
@Service
public class TeacherGradeServiceImpl extends ServiceImpl<TeacherGradeMapper, TeacherGrade>
        implements TeacherGradeService {

    @Autowired
    private TeacherGradeMapper teacherGradeMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Page getGradePageByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize, String gradeClass) {
        if (gradeClass.length() == 0) gradeClass = null;
        Page page = new Page(pageNum,pageSize);
        page.setTotal(this.teacherGradeMapper.selectGradeByTeacherId(teacherId,gradeClass).size());
        List<TeacherGradeDto> teacherGradeDtos = teacherGradeMapper.selectGradeDtoPage(teacherId, (Integer)(pageNum - 1)*pageSize, pageSize, gradeClass);
        page.setRecords(teacherGradeDtos);
        return page;
    }

    @Transactional
    @Override
    public boolean insertGrade(Integer teacherId, String gradeClass) {
        // 如果已存在班级号
        if (this.getOne(new QueryWrapper<TeacherGrade>().eq("grade_class", gradeClass)) != null) {
            throw new ServiceException(ErrorCodeEnum.GRADE_CLASS_IS_EXIST.getCode(), ErrorCodeEnum.GRADE_CLASS_IS_EXIST.getMsg());
        }
        TeacherGrade teacherGrade = new TeacherGrade();
        teacherGrade.setTeacherId(teacherId);
        teacherGrade.setGradeClass(gradeClass);
        return this.save(teacherGrade);
    }

    @Transactional
    @Override
    public boolean deleteGrade(Integer teacherId, String gradeClass) {
        this.remove(new QueryWrapper<TeacherGrade>()
                .eq("teacher_id",teacherId)
                .eq("grade_class",gradeClass));
        Student student = new Student();
        student.setGradeClass("");
        studentMapper.update(student, new QueryWrapper<Student>().eq("grade_class", gradeClass));
        return true;
    }

    @Transactional
    @Override
    public boolean deleteBatchGrade(Integer teacherId, List<String> gradeClass) {
        return this.remove(new QueryWrapper<TeacherGrade>()
                .in("grade_class",gradeClass)
                .eq("teacher_id",teacherId));
    }

    @Override
    public Page<Student> getStuPage(Integer teacherId, Integer pageNum, Integer pageSize, String studentName, String gradeClass) {
        Page page = new Page(pageNum,pageSize);
        page.setTotal(this.teacherGradeMapper.selectStuCount(teacherId,studentName,gradeClass).size());
        List<Student> students = teacherGradeMapper.selectStuPage(teacherId, (Integer)(pageNum - 1)*pageSize, pageSize, studentName ,gradeClass);
        page.setRecords(students);
        return page;
    }

    @Override
    public List<Student> getOtherStu(Integer teacherId) {
        return teacherGradeMapper.selectOtherStu(teacherId);
    }

    @Override
    @Transactional
    public Boolean updateStuGrade(Student student, String gradeClass) {
        student.setGradeClass(gradeClass);
        return studentMapper.updateById(student) == 1 ? true : false;
    }

    @Override
    public List<TeacherGradeDto> selectGrades(Integer teacherId) {
        List<TeacherGrade> teacherGrades = this.list(
                new QueryWrapper<TeacherGrade>()
                        .eq("teacher_id", teacherId).orderByAsc(new String[]{"grade_class"}));
        List<TeacherGradeDto> teacherGradeDtos = new ArrayList<>();
        ListUtil.copyProperties(teacherGrades,teacherGradeDtos,TeacherGradeDto.class);
        return teacherGradeDtos;
    }

    @Override
    @Transactional
    public boolean deleteStuGrade(Student student) {
        student.setGradeClass("");
        int updateById = studentMapper.updateById(student);
        if (updateById == 1){
            return true;
        }
        else{
            throw new ServiceException(ErrorCodeEnum.DELETE_ERROR.getCode(), ErrorCodeEnum.DELETE_ERROR.getMsg());
        }
    }

    @Override
    public boolean deleteBatchRelation(List<Integer> studentIds) {
        Integer updateCount = studentMapper.updateGradeClass(studentIds);
        if (updateCount >= 1){
            return true;
        }
        else{
            throw new ServiceException(ErrorCodeEnum.DELETE_ERROR.getCode(), ErrorCodeEnum.DELETE_ERROR.getMsg());
        }
    }

}
