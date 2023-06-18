package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.entity.Student;
import com.mikevane.covid.entity.StudentLeave;
import com.mikevane.covid.service.StudentClockService;
import com.mikevane.covid.service.StudentLeaveService;
import com.mikevane.covid.service.TeacherGradeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-27-12-20
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher/pendApproval")
public class TeacherPendApprovalController {
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
     * 查询老师管理的学生请假待审批名单
     * @param session 里面存储老师 id
     * @param pageNum
     * @param pageSize
     * @param studentName 学生姓名
     * @return
     */
    @GetMapping("/getPendApproval")
    public Result<Page> getPendApproval(HttpSession session,
                                        @RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam(value = "studentName",required = false) String studentName,
                                        @RequestParam(value = "gradeClass",required = false) String gradeClass){
        Integer teacherId = (Integer) session.getAttribute("teacherId");
        Page<StudentLeave> pages = studentLeaveService.getPendApproval(teacherId,pageNum,pageSize,studentName,gradeClass);
        return Result.success(pages);
    }

    /**
     * 更新审批状态
     * @param studentLeave
     * @return
     */
    @PostMapping("/updateStatus")
    public Result<String> updateStatus(@RequestBody StudentLeave studentLeave){
        return studentLeaveService.updateById(studentLeave)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }
}
