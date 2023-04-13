package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.controller.dto.StudentGradeDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author MikeV
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-03-07 10:59:02
*/
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IPage selectPageByGradeClass(Integer pageNum, Integer pageSize, String gradeClass, String studentName) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        queryWrapper.eq("grade_class",gradeClass);
        if (studentName != null){
            queryWrapper.like("username",studentName);
        }
        // 分页查询班级人数以及信息
        IPage page = new Page<>(pageNum,pageSize);
        IPage studentIPage = this.page(page, queryWrapper);
        // 将 page 中的 records 重新设置为 StudentGradeDto
        List<Student> students = studentIPage.getRecords();
        List<StudentGradeDto> studentGradeDtos = new ArrayList<>();
        students.forEach(student -> {
            StudentGradeDto studentGradeDto = new StudentGradeDto();
            BeanUtils.copyProperties(student,studentGradeDto);
            studentGradeDtos.add(studentGradeDto);
        });
        studentIPage.setRecords(studentGradeDtos);
        return studentIPage;
    }

    @Override
    public List<String> getGrades() {
        List<String> grades = studentMapper.selectDistinctGrades();
        if (grades == null){
            throw new ServiceException(ErrorCodeEnum.SERVER_ERROR.getCode(),ErrorCodeEnum.SERVER_ERROR.getMsg());
        }
        return grades;
    }

    @Override
    @Transactional
    public boolean updatePassword(Integer studentId, UserRegisterDto userRegisterDto) {
        if (StringUtil.isNull(userRegisterDto.getPassword()) || StringUtil.isNull(userRegisterDto.getRePassword())){
            throw new ServiceException(ErrorCodeEnum.ILLEGAL_ERROR.getCode(),ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getRePassword())){
            throw new ServiceException(ErrorCodeEnum.ILLEGAL_ERROR.getCode(),ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        return studentMapper.updatePasswordByid(studentId, DigestUtils.md5DigestAsHex(userRegisterDto.getPassword().getBytes())) == 1
                ? true
                : false;
    }

    @Override
    @Transactional
    public boolean updatePhone(Integer studentId, UserRegisterDto userRegisterDto) {
        if (StringUtil.isNull(userRegisterDto.getPhone())){
            throw new ServiceException(ErrorCodeEnum.ILLEGAL_ERROR.getCode(),ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        if (studentMapper.selectOne(new QueryWrapper<Student>().eq("phone",userRegisterDto.getPhone())) != null){
            throw new ServiceException(ErrorCodeEnum.PHONE_IS_EXIST.getCode(),ErrorCodeEnum.PHONE_IS_EXIST.getMsg());
        }
        if (studentMapper.updatePhoneById(studentId, userRegisterDto.getPhone()) != 2){
            throw new ServiceException(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
        }
            return true;
    }
}




