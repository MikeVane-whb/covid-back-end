package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.TeacherGrade;
import com.mikevane.covid.service.StudentService;
import com.mikevane.covid.service.TeacherGradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-22-17-10
 * @version: 1.0
 */

@RequestMapping("/teacher/student")
@RestController
@Slf4j
public class TeacherStudentController {
    @Resource
    private TeacherGradeService teacherGradeService;
    @Resource
    private StudentService studentService;
    @GetMapping("/getGrades")
    public Result<List> getGrades(HttpSession session){
        List<TeacherGradeDto> teacherGradeDtos = teacherGradeService.selectGrades((Integer) session.getAttribute("teacherId"));
        return Result.success(teacherGradeDtos);
    }

    /**
     * 分页查询老师管理的学生
     * @param session 里面存储老师 id
     * @param pageNum
     * @param pageSize
     * @param studentName 学生姓名
     * @return
     */
    @GetMapping("/findStuPage")
    public Result<IPage> findStuPage(HttpSession session,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "studentName",required = false) String studentName,
                                     @RequestParam(value = "gradeClass",required = false) String gradeClass){
        Integer teacherId = (Integer) session.getAttribute("teacherId");
//        log.warn("============teacherId:"+teacherId+"============");
        IPage<Student> pages = teacherGradeService.getStuPage(teacherId,pageNum,pageSize,studentName,gradeClass);
        return pages == null
                ? Result.error(ErrorCodeEnum.PAGE_ERROR.getCode(),ErrorCodeEnum.PAGE_ERROR.getMsg())
                : Result.success(pages);
    }

    /**
     * 查询未被老师管理的学生
     * @param session
     * @return
     */
    @GetMapping("/findOtherStu")
    public Result<List> selectStudents(HttpSession session){
        List<Student> students = teacherGradeService.getOtherStu((Integer) session.getAttribute("teacherId"));
        return students == null
                ? Result.error(ErrorCodeEnum.SELECT_ERROR.getCode(), ErrorCodeEnum.SELECT_ERROR.getMsg())
                : Result.success(students);
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/updateStudent")
    @Transactional
    public Result update(@RequestBody Student student){
        return studentService.updateById(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }

    /**
     * 绑定老师与学生的关系
     * @param gradeClass 修改后的学生班级号
     * @param student 学生信息
     * @return
     */
    @PostMapping("/addRelation/{gradeClass}")
    public Result addRelation(@RequestBody Student student,
                              @PathVariable("gradeClass") String gradeClass){
        return teacherGradeService.updateStuGrade(student,gradeClass)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(),ErrorCodeEnum.INSERT_ERROR.getMsg());
    }

    /**
     * 删除老师和学生的关系
     * @param student
     * @return
     */
    @DeleteMapping("/deleteRelation")
    public Result deleteRelation(@RequestBody Student student){
        return teacherGradeService.deleteStuGrade(student)
                ? Result.success()
                : Result.error(ErrorCodeEnum.DELETE_ERROR.getCode(),ErrorCodeEnum.DELETE_ERROR.getMsg());
    }

    /**
     * 批量删除老师和学生的关系
     * @param studentIds
     * @return
     */
    @PostMapping("/batchDelRelation")
    public Result batchDeleteRelation(@RequestBody List<Integer> studentIds){
        return teacherGradeService.deleteBatchRelation(studentIds)
                ? Result.success()
                : Result.error(ErrorCodeEnum.DELETE_ERROR.getCode(),ErrorCodeEnum.DELETE_ERROR.getMsg());
    }
}
