package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
* @author MikeV
* @description 针对表【teacher】的数据库操作Service
* @createDate 2023-03-07 10:58:56
*/
public interface TeacherService extends IService<Teacher> {

}
