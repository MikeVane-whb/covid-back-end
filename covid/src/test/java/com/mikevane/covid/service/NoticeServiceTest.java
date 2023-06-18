package com.mikevane.covid.service;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mikevane.covid.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: whb
 * @date: 2023-04-30-13-22
 * @version: 1.0
 */
@SpringBootTest
public class NoticeServiceTest {
    @Resource
    private NoticeService noticeService;

    @Test
    public void getTest(){
        noticeService.getOne(null);
    }

    @Test
    public void listTest(){
        noticeService.list(null);
    }

    @Test
    public void updateTest(){
        Notice notice = new Notice();
        notice.setId(1);
        notice.setTitle("测试");
        notice.setPublishTime(new Date());
        notice.setPublisher("123");
        notice.setPublisherId(8);
        notice.setContent("测试");
        notice.setReceiver(0);
        notice.setStatus(0);
        notice.setCreateTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());
        noticeService.updateById(notice);
    }

    @Test
    public void removeTest(){
        System.out.println(noticeService.removeById(1) ? "删除成功" : "删除失败");
    }

    @Test
    public void saveTest(){
        Notice notice = new Notice();
        notice.setTitle("2022年校运动会安排的通知\n");
        notice.setPublishTime(new Date(2022-1900,3,14));
        notice.setPublisher("123");
        notice.setPublisherId(8);
        notice.setContent("各位同学：\n" +
                "      根据校办本周工作安排，2022年春季运动会时间为四月十五、十六日（第七周周五、周六）。四月十四日（第七周周四）正常行课。若因天气或其他特殊原因造成运动会无法正常进行，四月十五、十六日按照课表安排正常行课。");
        notice.setReceiver(0);
        notice.setStatus(0);
        notice.setCreateTime(LocalDateTime.now());
        notice.setUpdateTime(LocalDateTime.now());

        noticeService.save(notice);
    }

    @Test
    public void getNoticeByGradeClassTest(){
        List noticeByGradeClass = noticeService.getNoticeByStudent();
        System.out.println(noticeByGradeClass.size());
        noticeByGradeClass.forEach(System.out::println);
    }
}
