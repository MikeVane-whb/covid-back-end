package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author MikeV
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2023-03-07 10:58:56
* @Entity generator.domain.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Student> selectOthersStudents(@Param("teacherId") Integer teacherId);
}




