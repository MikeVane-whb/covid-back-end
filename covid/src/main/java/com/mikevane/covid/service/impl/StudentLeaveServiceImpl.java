package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.entity.StudentLeave;
import com.mikevane.covid.mapper.StudentLeaveMapper;
import com.mikevane.covid.service.StudentLeaveService;
import org.springframework.stereotype.Service;

/**
* @author MikeV
* @description 针对表【student_leave】的数据库操作Service实现
* @createDate 2023-04-13 21:08:52
*/
@Service
public class StudentLeaveServiceImpl extends ServiceImpl<StudentLeaveMapper, StudentLeave>
    implements StudentLeaveService {

}




