package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.dto.StudentClockDto;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.entity.StudentClock;

import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-22-18-00
 * @version: 1.0
 */
public interface StudentClockService extends IService<StudentClock> {
    /**
     * 确认是否已打卡
     * @param studentId
     * @return
     */
    StudentClockDto checkIsClocked(Integer studentId);

    /**
     * 插入打卡信息
     * @param studentId
     * @param studentClockDto
     * @return
     */
    boolean insertClock(Integer studentId, StudentClockDto studentClockDto);

    /**
     * 查询班级信息
     * @return
     */
    List<String> getGrade();

    /**
     * 通过 gradeClass 查询班级的打卡信息（包含未打卡的人）
     * @param gradeClass
     * @return
     */
    List<TeacherClockDto> selectStudentsByGradeClass(String gradeClass);

    /**
     * 通过 学生id 进行分页查询
     * @param studentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page selectPageByStudentId(Integer studentId,Integer pageNum, Integer pageSize);
}
