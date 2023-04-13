package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.TeacherClockDto;
import com.mikevane.covid.service.StudentClockService;
import com.mikevane.covid.service.TeacherStudentService;
import com.mikevane.covid.utils.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
