package com.mikevane.covid.mapper;

import com.mikevane.covid.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author MikeV
* @description 针对表【notice】的数据库操作Mapper
* @createDate 2023-04-30 13:16:28
* @Entity com.mikevane.covid.entity.Notice
*/
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    List selectListByStudent();
}




