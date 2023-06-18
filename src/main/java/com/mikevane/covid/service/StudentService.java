package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.Student;

import java.util.List;

/**
* @author MikeV
* @description 针对表【student】的数据库操作Service
* @createDate 2023-03-07 10:59:02
*/
public interface StudentService extends IService<Student> {

    /**
     * 通过班级号与名字查询班级信息
     * @param gradeClass
     * @param studentName
     * @return
     */
    IPage selectPageByGradeClass(Integer pageNum, Integer pageSize , String gradeClass, String studentName);

    /**
     * 查询班级号
     * @return
     */
    List<String> getGrades();

    /**
     * 更新密码
     * @param studentId 学生 id
     * @param userRegisterDto 前端传入数据
     * @return
     */
    boolean updatePassword(Integer studentId, UserRegisterDto userRegisterDto);

    /**
     * 更新手机号
     * @param studentId 学生 id
     * @param userRegisterDto 前端传入数据
     * @return
     */
    boolean updatePhone(Integer studentId, UserRegisterDto userRegisterDto);
}
