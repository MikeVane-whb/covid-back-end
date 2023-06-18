package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.MaterialManage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialMapper extends BaseMapper<MaterialManage> {
}
