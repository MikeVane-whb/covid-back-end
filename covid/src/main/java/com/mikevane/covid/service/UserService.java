package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 登录功能
     * @param userDto 传入用户信息
     * @return
     *      如果用户密码正确则返回 User对象
     *      如果用户密码错误则返回 空指针
     */
    public User login(UserDto userDto);

    /**
     * 注册功能
     * @param user 传入用户信息
     * @return
     *      如果用户信息为空则返回 "error" 信息
     *      如果用户已存在则返回 "repeat" 信息
     *      如果插入成功则返回 "success" 信息
     */
    public Object register(UserRegisterDto user);

}
