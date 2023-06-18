package com.mikevane.covid.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mikevane.covid.entity.NationNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.entity.Notice;

import java.util.List;

/**
* @author MikeV
* @description 针对表【nation_notice】的数据库操作Service
* @createDate 2023-04-30 13:17:03
*/
public interface NationNoticeService extends IService<NationNotice> {
    IPage getNoticePage(Integer teacherId, Integer pageNum, Integer pageSize, String title);

    boolean insertNotice(Integer teacherId, NationNotice notice);

    boolean updateNotice(Integer teacherId, NationNotice notice);

    /**
     * 查询国内通知信息
     * @return
     */
    List getNationNoticeByStudent();
}
