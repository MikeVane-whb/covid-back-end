package com.mikevane.covid.controller.student;

import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentClockDto;
import com.mikevane.covid.service.StudentClockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author: whb
 * @date: 2023-03-22-17-13
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/student/clock")
public class StudentClockController {
    @Resource
    private StudentClockService studentClockService;

    @GetMapping("/checkClock.do")
    public Result<StudentClockDto> checkClock(HttpSession session){
        StudentClockDto studentClockDto = studentClockService.checkIsClocked((Integer) session.getAttribute("studentId"));
        return studentClockDto != null
                ? Result.success(studentClockDto)
                : Result.error(ErrorCodeEnum.NOT_CLOCKED.getCode(), ErrorCodeEnum.NOT_CLOCKED.getMsg());
    }

    @PutMapping("/insert.do")
    public Result<String> insert(HttpSession session,
                         @RequestBody StudentClockDto studentClockDto){
        return studentClockService.insertClock((Integer) session.getAttribute("studentId"),studentClockDto)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());

    }
}
