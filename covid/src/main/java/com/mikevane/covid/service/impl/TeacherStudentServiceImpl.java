package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.mapper.TeacherStudentMapper;
import com.mikevane.covid.service.TeacherStudentService;
import org.springframework.stereotype.Service;

/**
* @author MikeV
* @description 针对表【teacher_student】的数据库操作Service实现
* @createDate 2023-03-07 10:58:59
*/
@Service
public class TeacherStudentServiceImpl extends ServiceImpl<TeacherStudentMapper, TeacherStudent>
    implements TeacherStudentService {

}




