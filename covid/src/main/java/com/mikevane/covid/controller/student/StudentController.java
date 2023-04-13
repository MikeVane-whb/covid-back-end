package com.mikevane.covid.controller.student;

import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.utils.ListUtil;
import com.mikevane.covid.utils.ObjectUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

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
        Student student = studentService.getById((Integer) session.getAttribute("studentId"));
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return Result.success(studentDto);
    }

    @PutMapping("/update.do")
    public Result<String> update(@RequestBody StudentDto studentDto){
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        return studentService.updateById(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }

    @PutMapping("/updatePassword.do")
    public Result<String> updatePassword(HttpSession session, @RequestBody UserRegisterDto userRegisterDto){
        return studentService.updatePassword((Integer) session.getAttribute("studentId"), userRegisterDto)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }

    @PutMapping("/updatePhone.do")
    public Result<String> updatePhone(HttpSession session, @RequestBody UserRegisterDto userRegisterDto){
        return studentService.updatePhone((Integer) session.getAttribute("studentId"), userRegisterDto)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }

}
