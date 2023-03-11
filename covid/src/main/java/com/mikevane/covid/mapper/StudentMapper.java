package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author MikeV
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-03-07 10:59:02
* @Entity com.mikevane.covid.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    public Integer updateByStudent(@Param("student") Student student);
}




