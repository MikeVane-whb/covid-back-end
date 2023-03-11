package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.EmpIden;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.*;
import com.mikevane.covid.service.ChartService;
import com.mikevane.covid.service.UserService;
import com.mikevane.covid.utils.ObjectUtil;
import com.mikevane.covid.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private UserMapper userMapper;
    private StudentMapper studentMapper;
    private TeacherMapper teacherMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) { this.studentMapper = studentMapper; }

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper)  {this.teacherMapper = teacherMapper; }

    @Override
    public User login(UserDto userDto) {
        if (!ObjectUtil.checkObjAllFieldsIsNotNull(userDto)){
            throw new ServiceException(ErrorCodeEnum.ILLEGAL_ERROR.getCode(),ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        User user = new User();
        // 将密码加密
        userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        BeanUtils.copyProperties(userDto,user);
        List<User> users = userMapper.findByUser(user);
        if(users.size() == 0 || users.size() > 1){
            throw new ServiceException(ErrorCodeEnum.PASSWORD_ERROR.getCode(), ErrorCodeEnum.PASSWORD_ERROR.getMsg());
        }
        return users.get(0);
    }

    @Override
    @Transactional
    public Object register(UserRegisterDto userRegisterDto) {
        if (!ObjectUtil.checkObjAllFieldsIsNotNull(userRegisterDto)){
            throw new ServiceException(ErrorCodeEnum.ILLEGAL_ERROR.getCode(),ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        User user = new User();
        userRegisterDto.setPassword(DigestUtils.md5DigestAsHex(userRegisterDto.getPassword().getBytes()));
        BeanUtils.copyProperties(userRegisterDto,user);
        List<User> users = userMapper.findByUser(new User(null,user.getUsername(),user.getIdentity()));
        // 用户已存在，拒绝注册
        if(users.size() > 0){
            throw new ServiceException(ErrorCodeEnum.USER_IS_EXIST.getCode(), ErrorCodeEnum.USER_IS_EXIST.getMsg());
        }
        // 用户为学生
        if(user.getIdentity().equals("学生")){
            Student student = new Student();
            BeanUtils.copyProperties(user,student);
            userMapper.insert(user);
            student.setUserId(user.getId());
            student.setUsername(user.getUsername());
            studentMapper.insert(student);
            return student;
        }
        // 用户为老师
        if(user.getIdentity().equals("老师")){
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(user,teacher);
            userMapper.insert(user);
            teacher.setUserId(user.getId());
            teacher.setUsername(user.getUsername());
            teacherMapper.insert(teacher);
            return teacher;
        }
        return null;
    }
}
