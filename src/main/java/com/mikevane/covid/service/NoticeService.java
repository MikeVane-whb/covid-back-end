package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mikevane.covid.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MikeV
* @description 针对表【notice】的数据库操作Service
* @createDate 2023-04-30 13:16:28
*/
public interface NoticeService extends IService<Notice> {

    /**
     * 分页查询通知
     * @param teacherId
     * @param pageNum
     * @param pageSize
     * @param title
     * @return
     */
    IPage getNoticePage(Integer teacherId, Integer pageNum, Integer pageSize, String title);

    /**
     * 插入通知
     * @param teacherId
     * @param notice
     * @return
     */
    boolean insertNotice(Integer teacherId, Notice notice);

    /**
     * 更新通知
     * @param teacherId
     * @param notice
     * @return
     */
    boolean updateNotice(Integer teacherId, Notice notice);

    /**
     * 查询通知信息
     * @return
     */
    List getNoticeByStudent();

}
