package com.mikevane.covid.service;

import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.mapper.StudentMapper;
import com.mikevane.covid.mapper.TeacherMapper;
import com.mikevane.covid.mapper.TeacherStudentMapper;
import com.mikevane.covid.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: whb
 * @date: 2023-03-07-17-30
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class LoginServiceTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherStudentMapper teacherStudentMapper;

    @Test
    public void registerTest(){
        User user = new User();
        UserDto userDto = new UserDto();
        Student student = new Student();
        Teacher teacher = new Teacher();
        userDto.setPhone("1832222");
        userDto.setPassword("123");
        userDto.setIdentity("学生");
        BeanUtils.copyProperties(userDto, user);
        System.out.println(user);
        System.out.println(student);
        Integer insertUser = userMapper.insert(user);
        if(insertUser == 0){
            log.error("插入失败");
        }
        if (userDto.getIdentity().equals("学生")){
            student.setUserId(user.getId());
            student.setUsername(user.getPhone());
            student.setPhone(userDto.getPhone());
            Integer insertByStudent = studentMapper.insert(student);
            if(insertByStudent == 0){
                log.error("插入失败");
            }
        }
        if(userDto.getIdentity().equals("老师")){
            teacher.setUserId(user.getId());
            teacher.setUsername(user.getPhone());
            Integer insertByTeacher = teacherMapper.insert(teacher);
            if(insertByTeacher == 0){
                log.error("插入失败");
            }
        }
    }
}
