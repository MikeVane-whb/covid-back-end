package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.controller.dto.StudentClockDto;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.StudentClock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author MikeV
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-03-07 10:59:02
* @Entity com.mikevane.covid.entity.Student
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 查询非重复的班级号
     * @return
     */
    List<String> selectDistinctGrades();

    /**
     * 根据 id 更新密码
     * @param studentId
     * @param password
     * @return
     */
    int updatePasswordByid(@Param("studentId") Integer studentId, @Param("password")String password);

    /**
     * 根据 id 更新手机号
     * @param studentId
     * @param phone
     * @return
     */
    int updatePhoneById(@Param("studentId") Integer studentId, @Param("phone")String phone);
}




