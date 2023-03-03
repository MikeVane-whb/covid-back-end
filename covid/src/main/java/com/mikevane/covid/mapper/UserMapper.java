package com.mikevane.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikevane.covid.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
