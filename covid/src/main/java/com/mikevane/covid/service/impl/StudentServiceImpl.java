package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.service.StudentService;
import org.springframework.stereotype.Service;

/**
* @author MikeV
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-03-07 10:59:02
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

}




