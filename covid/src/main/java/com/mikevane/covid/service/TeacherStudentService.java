package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherStudent;

import java.util.List;

/**
* @author MikeV
* @description 针对表【teacher_student】的数据库操作Service
* @createDate 2023-03-07 10:58:59
*/
public interface TeacherStudentService extends IService<TeacherStudent> {
    /**
     * 通过 teacherId 进行分页查询
     * @param teacherId 老师 id
     * @param pageNum 页码
     * @param pageSize 一页中有多少条数据
     * @param studentName 模糊查询 studentName
     * @return 查询成功则返回 IPage 对象
     */
    public IPage<Student> getPagesByTeacherId(Integer teacherId, Integer pageNum, Integer pageSize, String studentName);

    /**
     * 查找与 teacherId 没有关系的学生
     * @param teacherId
     * @return 如果查找到学生则返回学生集合，否则抛出异常
     */
    List<Student> getOthersStuByTeacherId(Integer teacherId);

    /**
     * 删除老师与学生的关系
     * @param teacherId
     * @param studentId
     * @return
     */
    boolean deleteRelation(Integer teacherId, Integer studentId);

    /**
     * 批量删除老师与学生的关系
     * @param teacherId
     * @param studentIds
     * @return
     */
    boolean deleteBatchRelation(Integer teacherId, List<Integer> studentIds);
}
