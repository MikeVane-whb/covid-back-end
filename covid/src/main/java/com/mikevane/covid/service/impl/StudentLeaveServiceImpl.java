package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;

import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.StudentLeave;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.StudentLeaveMapper;
import com.mikevane.covid.service.StudentLeaveService;
import com.mikevane.covid.utils.ListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author MikeV
* @description 针对表【student_leave】的数据库操作Service实现
* @createDate 2023-04-13 21:08:52
*/
@Service
public class StudentLeaveServiceImpl extends ServiceImpl<StudentLeaveMapper, StudentLeave>
    implements StudentLeaveService {

    @Resource
    private StudentLeaveMapper studentLeaveMapper;

    @Override
    public Page getRecordsByStudentId(Integer studentId, Integer pageNum, Integer pageSize) {
        if (studentId == null || studentId.equals(0)){
            throw new ServiceException(ErrorCodeEnum.SERVER_ERROR.getCode(), ErrorCodeEnum.SERVER_ERROR.getMsg());
        }
        QueryWrapper<StudentLeave> queryWrapper = new QueryWrapper<StudentLeave>().eq("student_id", studentId);
        Page studentLeavePage = this.page(new Page<>(pageNum,pageSize), queryWrapper);
        List<StudentLeave> studentLeaves = studentLeavePage.getRecords();
        if (studentLeaves == null || studentLeaves.size() == 0){
            throw new ServiceException(ErrorCodeEnum.SELECT_ERROR.getCode(), "没有请假记录");
        }
        return studentLeavePage;
    }

    @Override
    public boolean saveRecordByStudentId(Integer studentId, StudentLeave studentLeave) {
        studentLeave.setStudentId(studentId);
        studentLeave.setStatus(0);
        return this.save(studentLeave);
    }

    @Override
    public Page<StudentLeave> getPendApproval(Integer teacherId, Integer pageNum, Integer pageSize, String studentName, String gradeClass) {
        Page page = new Page(pageNum,pageSize);
        int total = studentLeaveMapper.selectPendApprovalId(teacherId, studentName, gradeClass).size();
        page.setTotal(total);
        if (total == 0){
            page.setRecords(new ArrayList());
            return page;
        }
        List<StudentLeave> studentLeaves = studentLeaveMapper.selectPendApprovalStudent(teacherId, (Integer)(pageNum - 1)*pageSize, pageSize, studentName, gradeClass);
        page.setRecords(studentLeaves);
        return page;
    }

    @Override
    public IPage<StudentLeave> getApproved(Integer teacherId, Integer pageNum, Integer pageSize, String studentName, String gradeClass) {
        Page page = new Page(pageNum,pageSize);
        int total = studentLeaveMapper.selectApprovedId(teacherId, studentName, gradeClass).size();
        page.setTotal(total);
        if (total == 0){
            page.setRecords(new ArrayList());
            return page;
        }
        List<StudentLeave> studentLeaves = studentLeaveMapper.selectApprovedStudent(teacherId, (Integer)(pageNum - 1)*pageSize, pageSize, studentName, gradeClass);
        page.setRecords(studentLeaves);
        return page;
    }
}




