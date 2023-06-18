package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.entity.NationNotice;
import com.mikevane.covid.entity.Notice;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.service.NationNoticeService;
import com.mikevane.covid.mapper.NationNoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author MikeV
* @description 针对表【nation_notice】的数据库操作Service实现
* @createDate 2023-04-30 13:17:03
*/
@Service
public class NationNoticeServiceImpl extends ServiceImpl<NationNoticeMapper, NationNotice>
    implements NationNoticeService{
    @Resource
    private NationNoticeMapper nationNoticeMapper;
    @Override
    public IPage getNoticePage(Integer teacherId, Integer pageNum, Integer pageSize, String title) {
        IPage<NationNotice> page = this.page(new Page<>(pageNum,pageSize), new LambdaQueryWrapper<NationNotice>()
                .eq(NationNotice::getPublisherId, teacherId)
                .like(NationNotice::getTitle, title));
        if (page.getRecords() == null || page.getRecords().size() == 0){
            throw new ServiceException(ErrorCodeEnum.SELECT_ERROR.getCode(), "通知消息为空");
        }
        return page;
    }

    @Override
    @Transactional
    public boolean insertNotice(Integer teacherId, NationNotice notice) {
        notice.setPublisherId(teacherId);
        notice.setPublishTime(new Date());
        return this.save(notice);
    }

    @Override
    public boolean updateNotice(Integer teacherId, NationNotice notice) {
        notice.setPublisherId(teacherId);
        return this.updateById(notice);
    }

    @Override
    public List getNationNoticeByStudent() {
        return nationNoticeMapper.selectListByStudent();
    }
}




