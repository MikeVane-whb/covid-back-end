package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.dto.StudentLeaveDto;
import com.mikevane.covid.entity.StudentLeave;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @author MikeV
* @description 针对表【student_leave】的数据库操作Service
* @createDate 2023-04-13 21:08:52
*/
public interface StudentLeaveService extends IService<StudentLeave> {

    /**
     * 通过学生 id 获取前几次的打卡记录
     * @param studentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page getRecordsByStudentId(Integer studentId, Integer pageNum, Integer pageSize);

    /**
     * 通过学生 id 插入打卡记录
     * @param studentId
     * @return
     */
    boolean saveRecordByStudentId(Integer studentId, StudentLeave studentLeave);
}
