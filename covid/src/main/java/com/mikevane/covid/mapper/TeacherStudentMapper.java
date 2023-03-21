package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.TeacherStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author MikeV
* @description 针对表【teacher_student】的数据库操作Mapper
* @createDate 2023-03-07 10:58:59
* @Entity generator.domain.TeacherStudent
*/
@Mapper
public interface TeacherStudentMapper extends BaseMapper<TeacherStudent> {
}




