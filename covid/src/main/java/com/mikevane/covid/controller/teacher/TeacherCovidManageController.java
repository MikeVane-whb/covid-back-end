package com.mikevane.covid.controller.teacher;

import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.controller.dto.TeacherGradeDto;
import com.mikevane.covid.service.StudentClockService;
import com.mikevane.covid.service.TeacherGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-30-14-59
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher/covidManage")
public class TeacherCovidManageController {
    @Resource
    private StudentClockService studentClockService;
    @Resource
    private TeacherGradeService teacherGradeService;

    @GetMapping("/getGrade")
    public Result selectGrade(HttpSession session){
        List<TeacherGradeDto> teacherGradeDtos = teacherGradeService.selectGrades((Integer) session.getAttribute("teacherId"));
        return Result.success(teacherGradeDtos);
    }

    @GetMapping("/getStudents/{gradeClass}")
    public Result selectStudents(@PathVariable String gradeClass){
        List<TeacherClockDto> students = studentClockService.selectStudentsByGradeClass(gradeClass);
        return Result.success(students);
    }
}
