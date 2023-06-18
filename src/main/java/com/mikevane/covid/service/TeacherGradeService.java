package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherGrade;

import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-19-01-41
 * @version: 1.0
 */
public interface TeacherGradeService extends IService<TeacherGrade> {

    /**
     * 通过老师 id 获取我的班级page
     * @param teacherId
     * @param pageNum
     * @param pageSize
     * @param gradeClass
     * @return
     */
    Page getGradePageByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize, String gradeClass);

    /**
     * 插入班级信息
     * @param teacherId
     * @param gradeClass
     * @return
     */
    boolean insertGrade(Integer teacherId, String gradeClass);

    /**
     * 删除班级信息
     * @param teacherId
     * @param gradeClass
     * @return
     */
    boolean deleteGrade(Integer teacherId, String gradeClass);

    /**
     * 批量删除班级信息
     * @param teacherId
     * @param gradeClass
     * @return
     */
    boolean deleteBatchGrade(Integer teacherId, List<String> gradeClass);

    /**
     * 分页查询老师管理的学生
     * @param teacherId
     * @param pageNum
     * @param pageSize
     * @param studentName
     * @param gradeClass
     * @return
     */
    Page<Student> getStuPage(Integer teacherId, Integer pageNum, Integer pageSize, String studentName, String gradeClass);

    /**
     * 分页查询未被老师管理的学生
     * @param teacherId
     * @return
     */
    List<Student> getOtherStu(Integer teacherId);

    /**
     * 更新学生的班级号
     * @param student
     * @param gradeClass
     * @return
     */
    Boolean updateStuGrade(Student student, String gradeClass);

    /**
     * 查找班级号信息
     * @param teacherId
     * @return
     */
    List<TeacherGradeDto> selectGrades(Integer teacherId);


    /**
     * 删除学生的班级号信息
     * @param student
     * @return
     */
    boolean deleteStuGrade(Student student);

    /**
     * 批量删除学生的班级号信息
     * @param studentIds
     * @return
     */
    boolean deleteBatchRelation(List<Integer> studentIds);
}
