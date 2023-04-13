package com.mikevane.covid.controller.teacher;

import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.service.StudentClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: whb
 * @date: 2023-03-30-14-59
 * @version: 1.0
 */
@RestController
@RequestMapping("/teacher/clock")
public class TeacherClockController {
    @Autowired
    private StudentClockService studentClockService;

    @GetMapping("/getGrade.do")
    public Result selectGrade(){
        List<String> stringList = studentClockService.getGrade();
        return Result.success(stringList);
    }

    @GetMapping("/getStudents.do/{gradeClass}")
    public Result selectStudents(@PathVariable String gradeClass){
        List<TeacherClockDto> students = studentClockService.selectStudentsByGradeClass(gradeClass);
        return Result.success(students);
    }
}
