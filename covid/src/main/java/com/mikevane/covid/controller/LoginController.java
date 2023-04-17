package com.mikevane.covid.controller;


import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.controller.dto.UserRegisterDto;
import com.mikevane.covid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result<UserDto> login(HttpServletResponse response,
                                 HttpSession session,
                              @RequestBody UserDto userDto){
        UserDto user = userService.login(session,userDto);
        String sessionId = session.getId();
        Cookie cookie = new Cookie("JSESSIONID",sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
        Result<UserDto> success = Result.success(user);
        return user == null ? Result.error() : success;
    }

    @PostMapping("/register")
    public Result register(HttpSession session,
                           @RequestBody UserRegisterDto reUser){
        // 防止其他人使用接口直接发送注册请求
        if(!reUser.getPassword().equals(reUser.getRePassword())){
            return Result.error(ErrorCodeEnum.ILLEGAL_ERROR.getCode(), ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
        }
//        if(!StringUtil.isValidPhoneNumber(reUser.getPhone())){
//            return Result.error(ErrorCodeEnum.ILLEGAL_ERROR.getCode(), ErrorCodeEnum.ILLEGAL_ERROR.getMsg());
//        }
        Object register = userService.register(reUser);
        // 注册失败，发送错误信息
        if(register == null){
            return Result.error(ErrorCodeEnum.SERVER_ERROR.getCode(), ErrorCodeEnum.SUCCESS.getMsg());
        }
        return Result.success();
    }

}
