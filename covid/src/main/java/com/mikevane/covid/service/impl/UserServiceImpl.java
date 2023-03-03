package com.mikevane.covid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikevane.covid.common.HttpConstant;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.mapper.UserMapper;
import com.mikevane.covid.service.UserService;
import com.mikevane.covid.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper userMapper) {
        this.mapper = userMapper;
    }

    @Override
    public User getOne(UserDto userDto) {
        QueryWrapper<User> userQueryWrapper = Wrappers.query();
        if (!StringUtil.isNull(userDto.getUsername())){
            userQueryWrapper.eq("username", userDto.getUsername());
        }
        if (!StringUtil.isNull(userDto.getPassword())){
            userQueryWrapper.eq("password", DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes()));
        }
        if (!StringUtil.isNull(userDto.getIdentity())){
            userQueryWrapper.eq("identity", userDto.getIdentity());
        }
        return mapper.selectOne(userQueryWrapper);
    }

    @Override
    public String register(User user) {
        // 防空指针处理
        if (user == null){
            return "error";
        }
        // 用户名重复处理，防止重复插入
        for (User list:mapper.selectList(null)){
            if (list.getUsername().equals(user.getUsername()))
                return "repeat";
        }
        // md5加密
        String pw = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pw);
        // 插入数据
        int index = mapper.insert(user);
        if (index == 1) {
            return "success";
        }
        else {
            return "error";
        }
    }
}
