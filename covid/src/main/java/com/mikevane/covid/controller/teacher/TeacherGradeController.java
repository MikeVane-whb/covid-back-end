package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.service.TeacherGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-19-01-33
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher/grade")
public class TeacherGradeController {
    @Autowired
    private TeacherGradeService teacherGradeService;

    @GetMapping("/getGradePage")
    public Result<Page> getGradePage(HttpSession session,
                                     @RequestParam("pageNum") Integer pageNum,
                                     @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam(value = "gradeClass",required = false) String gradeClass){
        Page grades =  teacherGradeService.getGradePageByTeacherId((Integer) session.getAttribute("teacherId"),pageNum,pageSize,gradeClass);
        return Result.success(grades);
    }

    @PutMapping("/insertGrade/{gradeClass}")
    public Result<String> insertGrade(HttpSession session,
                                      @PathVariable("gradeClass") String gradeClass){
        return teacherGradeService.insertGrade((Integer)session.getAttribute("teacherId"), gradeClass)
               ? Result.success() : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());
    }

    @DeleteMapping("/deleteGrade/{gradeClass}")
    public Result<String> deleteGrade(HttpSession session,
                                      @PathVariable("gradeClass") String gradeClass){
        return teacherGradeService.deleteGrade((Integer)session.getAttribute("teacherId"), gradeClass)
               ? Result.success() : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());
    }

    @DeleteMapping("/deleteGrade")
    public Result<String> deleteBatchGrade(HttpSession session,
                                      @RequestBody List<String> gradeClass){
        return teacherGradeService.deleteBatchGrade((Integer)session.getAttribute("teacherId"), gradeClass)
               ? Result.success() : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());
    }
}
