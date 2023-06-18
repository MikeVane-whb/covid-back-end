package com.mikevane.covid.utils;

/**
 * @author: whb
 * @date: 2023-03-13-23-18
 * @version: 1.0
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @title: TokenService
 * @Author gjt
 * @Date: 2020-12-21
 * @Description：
 */
@Service
public class TokenUtil {
    /**
     * 过期时间2小时
     */
    private static final long EXPIRE_TIME = 2 * 60 * 60 * 1000;

    /**
     * 生成 token
     * @param id
     * @param password
     * @return
     */
    public static String getToken(String id, String password) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        String token="";
        token= JWT.create().withAudience(id) // 将 user id 保存到 token 里面
                .withExpiresAt(date) //两小时后token过期
                .sign(Algorithm.HMAC256(password)); // 以 password 作为 token 的密钥
        return token;
    }
}
