package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-19-01-36
 * @version: 1.0
 */
@Mapper
public interface TeacherGradeMapper extends BaseMapper<TeacherGrade> {
    List<String> selectGradeByTeacherId(@Param("teacherId") Integer teacherId,@Param("gradeClass") String gradeClass);

    List<TeacherGradeDto> selectGradeDtoPage(@Param("teacherId") Integer teacherId,
                                             @Param("currIndex") Integer currIndex,
                                             @Param("pageSize") Integer pageSize,
                                             @Param("gradeClass") String gradeClass);

    List<Integer> selectStuCount(@Param("teacherId")Integer teacherId, @Param("studentName")String studentName, @Param("gradeClass")String gradeClass);

    List<Student> selectStuPage(@Param("teacherId")Integer teacherId,
                                @Param("currIndex") Integer currIndex,
                                @Param("pageSize")Integer pageSize,
                                @Param("studentName")String studentName,
                                @Param("gradeClass")String gradeClass);

    List<Student> selectOtherStu(@Param("teacherId") Integer teacherId);

}
