package com.mikevane.covid.controller.teacher;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.entity.NationNotice;
import com.mikevane.covid.entity.Notice;
import com.mikevane.covid.service.NationNoticeService;
import com.mikevane.covid.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author: whb
 * @date: 2023-05-03-11-02
 * @version: 1.0
 */

@RestController
@RequestMapping("/teacher/nationNotice")
public class TeacherNationNoticeController {
    @Resource
    private NationNoticeService nationNoticeService;
    @GetMapping("/getNotice")
    public Result<IPage> getNotice(HttpSession session,
                                   @RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize,
                                   @RequestParam(value = "title",required = false) String title){
        return Result.success(nationNoticeService.getNoticePage((Integer)session.getAttribute("teacherId"),pageNum,pageSize,title));
    }

    @PostMapping("/insertNotice")
    public Result<String> insertNotice(HttpSession session, @RequestBody NationNotice notice){
        return nationNoticeService.insertNotice((Integer) session.getAttribute("teacherId"), notice)
                ? Result.success()
                : Result.error(ErrorCodeEnum.INSERT_ERROR.getCode(), ErrorCodeEnum.INSERT_ERROR.getMsg());
    }

    @PostMapping("/updateNotice")
    public Result<String> updateNotice(HttpSession session, @RequestBody NationNotice notice){
        return nationNoticeService.updateNotice((Integer) session.getAttribute("teacherId"), notice)
                ? Result.success()
                : Result.error(ErrorCodeEnum.UPDATE_ERROR.getCode(), ErrorCodeEnum.UPDATE_ERROR.getMsg());
    }
}
