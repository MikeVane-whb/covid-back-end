package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.controller.dto.StudentClockDto;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.entity.StudentClock;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.StudentClockMapper;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.service.StudentClockService;
import com.mikevane.covid.utils.ListUtil;
import com.mikevane.covid.utils.ObjectUtil;
import com.mikevane.covid.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-22-18-00
 * @version: 1.0
 */
@Service
public class StudentClockServiceImpl extends ServiceImpl<StudentClockMapper, StudentClock>
        implements StudentClockService {
    @Autowired
    private StudentClockMapper studentClockMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public StudentClockDto checkIsClocked(Integer studentId) {
        if (studentId == null){
            throw new NullPointerException("studentId为空");
        }
        StudentClock clock = studentClockMapper.findCurClockedById(studentId);
        if (clock == null){
            return null;
        }
        if (!TimeUtil.equalsCurrentTime(clock.getClockTime(),"yyyy-MM-dd")){
            return null;
        }
        StudentClockDto studentClockDto = new StudentClockDto();
        BeanUtils.copyProperties(clock,studentClockDto);
        return studentClockDto;
    }

    @Override
    @Transactional
    public boolean insertClock(Integer studentId, StudentClockDto studentClockDto) {
        if (!ObjectUtil.checkObjAllFieldsIsNotNull(studentClockDto)){
            throw new ServiceException(ErrorCodeEnum.NULL_POINTER_ERROR.getCode(), ErrorCodeEnum.NULL_POINTER_ERROR.getMsg());
        }
        StudentClock studentClock = new StudentClock();
        try {
            BeanUtils.copyProperties(studentClockDto,studentClock);
            studentClock.setStudentId(studentId);
            studentClock.setClockTime(LocalDateTime.now());
        }catch (Exception e){
            throw new ServiceException(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());
        }
        return save(studentClock);
    }

    @Override
    public List<String> getGrade() {
        List<String> stringList = studentMapper.selectDistinctGrades();
        ListUtil.replaceElement(stringList,"","default");
        return stringList;
    }

    @Override
    public List<TeacherClockDto> selectStudentsByGradeClass(String gradeClass) {
        if (gradeClass.equals("default")){
            gradeClass = "";
        }
        return studentClockMapper.selectClockStudent(gradeClass);
    }

    @Override
    public Page selectPageByStudentId(Integer studentId, Integer pageNum, Integer pageSize) {
        Page page = this.page(new Page(pageNum, pageSize), new QueryWrapper<StudentClock>().eq("student_id", studentId).orderByDesc("id"));
        List<StudentClock> studentClocks = page.getRecords();
        if (studentClocks == null || studentClocks.size() == 0){
            throw new ServiceException(ErrorCodeEnum.SELECT_ERROR.getCode(), "打卡记录为空");
        }
        List<StudentClockDto> studentClockDtos = new ArrayList<>();
        ListUtil.copyProperties(studentClocks,studentClockDtos, StudentClockDto.class);
        page.setRecords(studentClockDtos);
        return page;
    }

}
