package com.mikevane.covid.controller.student;

import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentLeaveDto;
import com.mikevane.covid.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-13-21-08
 * @version: 1.0
 */
@RestController
public class StudentLeaveController {
    @Autowired
    private StudentLeaveService studentLeaveService;

    @GetMapping("getRecent")
    public Result<List<StudentLeaveDto>> selectRecent(HttpSession session){
        studentLeaveService.getRecordsByStudentId();
    }
}
