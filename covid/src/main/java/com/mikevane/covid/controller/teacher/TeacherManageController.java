package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherStudent;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.service.TeacherService;
import com.mikevane.covid.service.TeacherStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-22-17-10
 * @version: 1.0
 */

@RequestMapping("/teacher/manage")
@RestController
@Slf4j
public class TeacherManageController {
    private TeacherStudentService teacherStudentService;
    private StudentService studentService;
    private TeacherStudentService tsService;
    @Autowired
    public void setTeacherStudentService(TeacherStudentService teacherStudentService) { this.teacherStudentService = teacherStudentService;}
    @Autowired
    public void setStudentService(StudentService studentService) { this.studentService = studentService;}
    @Autowired
    public void setTsService(TeacherStudentService tsService) { this.tsService = tsService;}

    /**
     * 分页查询老师管理的学生
     * @param session 里面存储老师 id
     * @param pageNum
     * @param pageSize
     * @param studentName 学生姓名
     * @return
     */
    @GetMapping("/findStuPage.do")
    public Result<IPage> findStuPage(HttpSession session,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "studentName",required = false) String studentName){
        Integer teacherId = (Integer) session.getAttribute("teacherId");
//        log.warn("============teacherId:"+teacherId+"============");
        IPage<Student> pages = teacherStudentService.getPagesByTeacherId(teacherId,pageNum,pageSize,studentName);
        return pages == null
                ? Result.error(ErrorCodeEnum.PAGE_ERROR.getCode(),ErrorCodeEnum.PAGE_ERROR.getMsg())
                : Result.success(pages);
    }

    /**
     * 查询未被老师管理的学生
     * @param session
     * @return
     */
    @GetMapping("/findOtherStu.do")
    public Result selectStudents(HttpSession session){
        List<Student> students = teacherStudentService.getOthersStuByTeacherId((Integer) session.getAttribute("teacherId"));
        return students == null
                ? Result.error(ErrorCodeEnum.SELECT_ERROR.getCode(), ErrorCodeEnum.SELECT_ERROR.getMsg())
                : Result.success(students);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/updateStudent.do")
    @Transactional
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
    @PostMapping("/addRelation.do")
    @Transactional
    public Result addRelation(HttpSession session,
                              @RequestBody TeacherStudent teacherStudent){
//        log.info(teacherStudent.getStudentId().toString());
        teacherStudent.setTeacherId((Integer) session.getAttribute("teacherId"));
        return tsService.save(teacherStudent)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(),ErrorCodeEnum.INSERT_ERROR.getMsg());
    }

    /**
     * 删除老师和学生的关系
     * @param session
     * @param studentId
     * @return
     */
    @DeleteMapping("/deleteRelation.do/{studentId}")
    public Result deleteRelation(HttpSession session,
                                 @PathVariable Integer studentId){
        return teacherStudentService.deleteRelation((Integer) session.getAttribute("teacherId"), studentId)
                ? Result.success()
                : Result.error(ErrorCodeEnum.DELETE_ERROR.getCode(),ErrorCodeEnum.DELETE_ERROR.getMsg());
    }

    /**
     * 批量删除老师和学生的关系
     * @param session
     * @param studentIds
     * @return
     */
    @PostMapping("/batchDelRelation.do")
    public Result batchDeleteRelation(HttpSession session, @RequestBody List<Integer> studentIds){
        return teacherStudentService.deleteBatchRelation((Integer) session.getAttribute("teacherId"),studentIds)
                ? Result.success()
                : Result.error(ErrorCodeEnum.DELETE_ERROR.getCode(),ErrorCodeEnum.DELETE_ERROR.getMsg());
    }
}
