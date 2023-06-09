package com.mikevane.covid.controller;

import com.mikevane.covid.entity.User;
import com.mikevane.covid.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;


@SpringBootTest
public class LoginControllerTest {
    @Autowired
    private UserMapper mapper;
    @Test
    public void register(){
        User user=new User();
        String pw=DigestUtils.md5DigestAsHex("99409".getBytes());
//        user.setUsername("994091246");
        user.setPassword(pw);
        int message= mapper.insert(user);
        System.out.println(message);
    }

}