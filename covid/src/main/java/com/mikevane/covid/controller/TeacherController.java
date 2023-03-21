package com.mikevane.covid.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.BaseContext;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentDto;
import com.mikevane.covid.controller.dto.TeacherDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.Teacher;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.service.TeacherService;
import com.mikevane.covid.service.TeacherStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public void setTeacherService(TeacherService teacherService) { this.teacherService = teacherService;}
    @Autowired
    public void setStudentService(StudentService studentService) { this.studentService = studentService;}
    @Autowired
    public void setTsService(TeacherStudentService tsService) { this.tsService = tsService;}

    @GetMapping("/select.do")
    public Result<TeacherDto> select(HttpSession session){
        TeacherDto teacherDto = new TeacherDto();
        Teacher teacher = teacherService.getById((Integer) session.getAttribute("teacherId"));
        BeanUtils.copyProperties(teacher,teacherDto);
        return teacherDto != null ? Result.success(teacherDto) : Result.error();
    }

    @PutMapping("/update.do")
    public Result update(HttpSession session,
                         @RequestBody TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDto,teacher);
        teacher.setId((Integer) session.getAttribute("teacherId"));
        return teacherService.updateById(teacher) ? Result.success() : Result.error();
    }

    /**
     * 分页查询老师管理的学生
     * @param session 里面存储老师 id
     * @param pageNum
     * @param pageSize
     * @param studentName 学生姓名
     * @return
     */
    @GetMapping("/manage/findStuPage.do")
    public Result<IPage> findStuPage(HttpSession session,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "studentName",required = false) String studentName){
        Integer teacherId = (Integer) session.getAttribute("teacherId");
//        log.warn("============teacherId:"+teacherId+"============");
        IPage<Student> pages = teacherService.getPagesByTeacherId(teacherId,pageNum,pageSize,studentName);
        return pages == null
                ? Result.error(ErrorCodeEnum.PAGE_ERROR.getCode(),ErrorCodeEnum.PAGE_ERROR.getMsg())
                : Result.success(pages);
    }

    /**
     * 查询未被老师管理的学生
     * @param session
     * @return
     */
    @GetMapping("/manage/findOtherStu.do")
    public Result selectStudents(HttpSession session){
        List<Student> students = teacherService.getOthersStuByTeacherId((Integer) session.getAttribute("teacherId"));
        return students == null
                ? Result.error(ErrorCodeEnum.SELECT_ERROR.getCode(), ErrorCodeEnum.SELECT_ERROR.getMsg())
                : Result.success(students);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/manage/updateStudent.do")
    public Result update(@RequestBody Student student){
        return studentService.updateById(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }

    /**
     * 绑定老师与学生的关系
     * @param teacherStudent 里面存放了学生 id
     * @param session 里面存放了 teacher id
     * @return
     */
    @PostMapping("/manage/addRelation.do")
    public Result addRelation(HttpSession session,
                              @RequestBody TeacherStudent teacherStudent){
//        log.info(teacherStudent.getStudentId().toString());
        teacherStudent.setTeacherId((Integer) session.getAttribute("teacherId"));
        return tsService.save(teacherStudent)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(),ErrorCodeEnum.INSERT_ERROR.getMsg());
    }

    @DeleteMapping("/manage/deleteRelation.do/{studentId}")
    public Result deleteRelation(HttpSession session,
                                 @PathVariable Integer studentId){
        return teacherService.deleteByTeacherIdAndStuId((Integer) session.getAttribute("teacherId"), studentId)
                ? Result.success()
                : Result.error(ErrorCodeEnum.DELETE_ERROR.getCode(),ErrorCodeEnum.DELETE_ERROR.getMsg());
    }
}
