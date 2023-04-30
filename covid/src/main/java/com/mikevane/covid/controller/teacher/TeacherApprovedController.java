package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.StudentLeave;
import com.mikevane.covid.service.StudentClockService;
import com.mikevane.covid.service.StudentLeaveService;
import com.mikevane.covid.service.TeacherGradeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-27-12-16
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher/approved")
public class TeacherApprovedController {
    @Resource
    private StudentLeaveService studentLeaveService;
    @Resource
    private TeacherGradeService teacherGradeService;
    @GetMapping("/getGrade")
    public Result selectGrade(HttpSession session){
        List<TeacherGradeDto> teacherGradeDtos = teacherGradeService.selectGrades((Integer) session.getAttribute("teacherId"));
        return Result.success(teacherGradeDtos);
    }

    /**
     * 查询老师管理的学生请假已审批名单
     * @param session 里面存储老师 id
     * @param pageNum
     * @param pageSize
     * @param studentName 学生姓名
     * @return
     */
    @GetMapping("/getApproved")
    public Result<IPage> getApproved(HttpSession session,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "studentName",required = false) String studentName,
                                     @RequestParam(value = "gradeClass",required = false) String gradeClass){
        Integer teacherId = (Integer) session.getAttribute("teacherId");
//        log.warn("============teacherId:"+teacherId+"============");
        IPage<StudentLeave> pages = studentLeaveService.getApproved(teacherId,pageNum,pageSize,studentName,gradeClass);
        return pages == null
                ? Result.error(ErrorCodeEnum.PAGE_ERROR.getCode(),ErrorCodeEnum.PAGE_ERROR.getMsg())
                : Result.success(pages);
    }
}
