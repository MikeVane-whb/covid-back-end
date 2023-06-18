package com.mikevane.covid.controller.student;

import com.mikevane.covid.common.Result;
import com.mikevane.covid.service.NationNoticeService;
import com.mikevane.covid.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: whb
 * @date: 2023-05-03-12-30
 * @version: 1.0
 */
@RestController
@RequestMapping("/student/notice")
public class StudentNoticeController {
    @Resource
    private NoticeService noticeService;
    @Resource
    private NationNoticeService nationNoticeService;
    @GetMapping("/getNotice")
    public Result<List> getNotice(){
        return Result.success(noticeService.getNoticeByStudent());
    }

    @GetMapping("/getNationNotice")
    public Result<List> getNationNotice(){
        return Result.success(nationNoticeService.getNationNoticeByStudent());
    }

}
