package com.mikevane.covid.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.mikevane.covid.common.HttpConstant;
import com.mikevane.covid.common.Result;
import com.mikevane.covid.controller.dto.UserDto;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.service.UserService;
import com.mikevane.covid.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/userlogin")
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
        if (!ObjectUtil.checkObjAllFieldsIsNotNull(userDto)){
            return Result.error(HttpConstant.ILLEGAL_ERROR,"非法输入");
        }
        User user = userService.getOne(userDto);
        if (user == null){
            throw new ServiceException(HttpConstant.PASSWORD_ERROR,"帐号或密码错误");
        }
        String password= DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes());
        if (user.getPassword().equals(password)){
            request.getSession().setAttribute("userId", user.getId());
            return Result.success();
        }
        else {
            return Result.error(HttpConstant.PASSWORD_ERROR,"帐号或密码错误");
        }
    }

    @PostMapping("/register.do")
    public String register(@RequestBody User reUser){
        String message = userService.register(reUser);
        return message;
    }
}
