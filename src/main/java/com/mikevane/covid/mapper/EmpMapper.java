package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.EmpHealth;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMapper extends BaseMapper<EmpHealth> {
}
