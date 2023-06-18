package com.mikevane.covid.controller.student;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentGradeDto;
import com.mikevane.covid.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: whb
 * @date: 2023-03-23-11-17
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/student/grade")
public class StudentGradeController {
    @Resource
    private StudentService studentService;

    @GetMapping("/select")
    public Result<IPage> select(@RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("pageSize") Integer pageSize,
                                                @RequestParam(required = false) String studentName,
                                                @RequestParam String gradeClass){
        IPage<StudentGradeDto> studentGradeDtoIPage = studentService.selectPageByGradeClass(pageNum,pageSize,gradeClass,studentName);
        return Result.success(studentGradeDtoIPage);
    }
}
