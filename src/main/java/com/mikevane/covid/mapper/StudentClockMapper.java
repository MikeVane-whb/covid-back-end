package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.entity.StudentClock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-22-17-57
 * @version: 1.0
 */
@Mapper
public interface StudentClockMapper extends BaseMapper<StudentClock> {
    /**
     * 根据id查询当天的打卡记录
     * @param studentId
     * @return
     */
    StudentClock findCurClockedById(@Param("studentId") Integer studentId);

    /**
     * 根据年级号查询所有学生的打卡信息
     * @param gradeClass
     * @return
     */
    List<TeacherClockDto> selectClockStudent(@Param("gradeClass") String gradeClass);
}
