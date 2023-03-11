package com.mikevane.covid.mapper;

import com.mikevane.covid.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: whb
 * @date: 2023-03-07-13-15
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        User user = new User();
        user.setUsername("123");
        user.setPassword("123456");
        user.setIdentity("学生");
        userMapper.insert(user);
        System.out.println("*************"+user.getId());
        //log.error("id = ",user.getId().toString());
    }

}
