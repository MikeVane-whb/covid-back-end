package com.mikevane.covid.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.service.TeacherService;
import com.mikevane.covid.service.TeacherStudentService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TeacherController {
    private TeacherService teacherService;
    private StudentService studentService;
    private TeacherStudentService tsService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setTsService(TeacherStudentService tsService) {
        this.tsService = tsService;
    }

    @GetMapping(value = "/manage/findStuPage.do")
    public Result<IPage> findStuPage(@RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "studentName",required = false) String studentName){
        IPage<Student> pages = teacherService.getPagesByTeacherId(5,pageNum,pageSize,studentName);
        return pages == null
                ? Result.error(ErrorCodeEnum.PAGE_ERROR.getCode(),ErrorCodeEnum.PAGE_ERROR.getMsg())
                : Result.success(pages);
    }

    @GetMapping("/manage/selectStudents.do/{teacherId}")
    public Result selectStudents(@PathVariable Integer teacherId){
        List<Student> students = teacherService.getOthersStuByTeacherId(teacherId);
        return students == null
                ? Result.error(ErrorCodeEnum.SELECT_ERROR.getCode(), ErrorCodeEnum.SELECT_ERROR.getMsg())
                : Result.success(students);
    }

    @PostMapping("/manage/updateStudent.do")
    public Result update(@RequestBody Student student){
        return studentService.updateById(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }

    /**
     * 绑定老师与学生的关系
     * @param teacherStudent 里面存放了学生 id
     * @return
     */
    @PostMapping("/manage/addStudent.do")
    public Result addStuToTeacher(@RequestBody TeacherStudent teacherStudent){
        log.info(teacherStudent.getStudentId().toString());
        teacherStudent.setTeacherId(5);
        return tsService.save(teacherStudent)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(),ErrorCodeEnum.INSERT_ERROR.getMsg());
    }
}
