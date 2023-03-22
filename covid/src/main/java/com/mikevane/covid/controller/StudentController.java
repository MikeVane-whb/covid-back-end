package com.mikevane.covid.controller;

import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author: whb
 * @date: 2023-03-07-08-55
 * @version: 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @GetMapping("/select.do")
    public Result<StudentDto> select(HttpSession session){
        StudentDto studentDto = new StudentDto();
        Student student = studentService.getById((Integer) session.getAttribute("studentId"));
        BeanUtils.copyProperties(student,studentDto);
        return Result.success(studentDto);
    }

    @PutMapping("/update.do")
    public Result update(HttpSession session,
                         @RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        student.setId((Integer) session.getAttribute("studentId"));
        return studentService.updateById(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }
}
