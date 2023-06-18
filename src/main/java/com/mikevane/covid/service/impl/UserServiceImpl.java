package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.BaseContext;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.mapper.TeacherMapper;
import com.mikevane.covid.mapper.UserMapper;
import com.mikevane.covid.service.UserService;
import com.mikevane.covid.utils.ObjectUtil;
import com.mikevane.covid.utils.TokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
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
    public UserDto login(HttpSession session, UserDto userDto) {
        User user = new User();
        // 将密码加密
        userDto.setPassword(DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        BeanUtils.copyProperties(userDto,user);

        List<User> users = userMapper.findByUser(user);
        // 如果没有该用户，或者查询到的用户数量大于1，则抛出异常
        if(users == null || users.size() != 1){
            throw new ServiceException(ErrorCodeEnum.PASSWORD_ERROR.getCode(), ErrorCodeEnum.PASSWORD_ERROR.getMsg());
        }

        user = users.get(0);
        // 设置token
        BeanUtils.copyProperties(user,userDto);
        String token = TokenUtil.getToken(user.getId().toString(), user.getPassword());
        userDto.setToken(token);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",user.getId());
        if("学生".equals(user.getIdentity())){
            Student student = studentMapper.selectOne(queryWrapper);
            // 设置姓名到dto
            userDto.setUsername(student.getUsername());
            // 将id放到请求中
            session.setAttribute("studentId",student.getId());
            BaseContext.setCurrentId(student.getId());
            log.warn("登录成功，学生 id 为：" + student.getId());
        }
        else {
            Teacher teacher = teacherMapper.selectOne(queryWrapper);
            // 设置姓名到dto
            userDto.setUsername(teacher.getUsername());
            // 将id放到请求中
            session.setAttribute("teacherId",teacher.getId());
            log.warn("登录成功，老师 id 为：" + teacher.getId());
        }
        log.warn("token为：" + token);
        return userDto;
    }

    @Override
    @Transactional
    public Object register(UserRegisterDto userRegisterDto) {
        if (!ObjectUtil.checkObjAllFieldsIsNotNull(userRegisterDto)){
            throw new ServiceException(ErrorCodeEnum.ILLEGAL_ERROR.getCode(),ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        User user = new User();
        userRegisterDto.setPassword(DigestUtils.md5DigestAsHex(userRegisterDto.getPassword().getBytes()));
        // 属性拷贝
        BeanUtils.copyProperties(userRegisterDto,user);
        // 查找 user 信息
        List<User> users = userMapper.findByUser(new User(null,user.getPhone(),user.getIdentity()));
        // 用户已存在，拒绝注册
        if(users.size() > 0){
            throw new ServiceException(ErrorCodeEnum.USER_IS_EXIST.getCode(), ErrorCodeEnum.USER_IS_EXIST.getMsg());
        }
        // 用户为学生
        if(user.getIdentity().equals("学生")){
            Student student = new Student();
            BeanUtils.copyProperties(user,student);
            // 信息插入用户表
            userMapper.insert(user);
            // 设置 id 与 name
            student.setUserId(user.getId());
            student.setUsername(user.getPhone());
            // 信息插入学生表
            studentMapper.insert(student);
            return student;
        }
        // 用户为老师
        if(user.getIdentity().equals("老师")){
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(user,teacher);
            // 信息插入用户表
            userMapper.insert(user);
            // 设置 id 与 name
            teacher.setUserId(user.getId());
            teacher.setUsername(user.getPhone());
            // 信息插入老师表
            teacherMapper.insert(teacher);
            return teacher;
        }
        return null;
    }
}
