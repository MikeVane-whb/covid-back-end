package com.mikevane.covid.controller.student;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.StudentLeaveDto;
import com.mikevane.covid.entity.StudentLeave;
import com.mikevane.covid.service.StudentLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-04-13-21-08
 * @version: 1.0
 */
@RestController
@RequestMapping("/studentLeave")
public class StudentLeaveController {
    @Autowired
    private StudentLeaveService studentLeaveService;

    @GetMapping("/getRecordPage")
    public Result<Page> selectRecordPage(HttpSession session,
                                         @RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize){
        Page page = studentLeaveService.getRecordsByStudentId(
                (Integer)session.getAttribute("studentId"),
                pageNum,
                pageSize);
        return Result.success(page);
    }

    @PostMapping("/insertRecord")
    public Result<String> insertRecord(HttpSession session, @RequestBody StudentLeave studentLeave){
        return studentLeaveService.saveRecordByStudentId((Integer) session.getAttribute("studentId"), studentLeave)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());
    }
}
