package com.mikevane.covid.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 登录功能
     * @param userDto 传入用户信息
     * @param session 请求
     * @return
     *      如果用户密码正确则返回 User对象
     *      如果用户密码错误则返回 空指针
     */
    public UserDto login(HttpSession session,
                         UserDto userDto);

    /**
     * 注册功能
     * @param userRegisterDto 传入注册用户信息
     * @return 如果注册成功则返回对象，否则返回 null
     *
     */
    public Object register(UserRegisterDto userRegisterDto);

}
