package com.mikevane.covid.mapper;

import com.mikevane.covid.entity.NationNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author MikeV
* @description 针对表【nation_notice】的数据库操作Mapper
* @createDate 2023-04-30 13:17:03
* @Entity com.mikevane.covid.entity.NationNotice
*/
@Mapper
public interface NationNoticeMapper extends BaseMapper<NationNotice> {

    List selectListByStudent();
}




