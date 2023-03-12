package com.mikevane.covid.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.service.TeacherService;
import com.mikevane.covid.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-10-17-32
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;
    private StudentService studentService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/findStuPage.do")
    public Result<IPage> findStuPage(@RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "studentName",required = false) String studentName){
        IPage<Student> pages = teacherService.getPagesByTeacherId(5,pageNum,pageSize);
        return pages == null
                ? Result.error(ErrorCodeEnum.PAGE_ERROR.getCode(),ErrorCodeEnum.PAGE_ERROR.getMsg())
                : Result.success(pages);
    }

    @GetMapping("selectStudents.do/{teacherId}")
    public Result selectStudents(@PathVariable Integer teacherId){
        List<Student> students = teacherService.getOthersStuByTeacherId(teacherId);
        return Result.success(students);
    }

    @PostMapping("/manage/update.do")
    public Result update(@RequestBody Student student){
        return studentService.updateById(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }
}
