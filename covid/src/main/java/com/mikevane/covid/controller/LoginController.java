package com.mikevane.covid.controller;


import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login.do")
    public Result<User> login(HttpServletRequest request,
                              HttpServletResponse response,
                              @RequestBody UserDto userDto){
        User user = userService.login(userDto);
        request.getSession().setAttribute("userId", user.getId());
        return Result.success();
    }

    @PostMapping("/register.do")
    public Result register(HttpServletRequest request,
                           HttpServletResponse response,
                           @RequestBody UserRegisterDto reUser){
        // 防止其他人使用接口直接发送注册请求
        if(!reUser.getPassword().equals(reUser.getRePassword())){
            return Result.error(ErrorCodeEnum.ILLEGAL_ERROR.getCode(), ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
        Object register = userService.register(reUser);
        if(register == null){
            return Result.error(ErrorCodeEnum.SERVER_ERROR.getCode(), ErrorCodeEnum.SUCCESS.getMsg());
        }
        return Result.success();
    }

}
