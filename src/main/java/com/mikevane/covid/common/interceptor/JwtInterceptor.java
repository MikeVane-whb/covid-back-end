package com.mikevane.covid.common.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mikevane.covid.common.ErrorCodeEnum;
import com.mikevane.covid.entity.User;
import com.mikevane.covid.exception.ServiceException;
import com.mikevane.covid.service.UserService;
import com.mikevane.covid.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: whb
 * @date: 2023-03-14-00-17
 * @version: 1.0
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        if(StringUtil.isNull(token)){
            throw new ServiceException(ErrorCodeEnum.NULL_TOKEN.getCode(), ErrorCodeEnum.NULL_TOKEN.getMsg());
        }
        log.info("***********token***********"+token);
        // 获取 token 中的 userid
        String userId;
        try{
            userId = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j){
            throw new ServiceException(ErrorCodeEnum.VALID_ERROR_TOKEN.getCode(), ErrorCodeEnum.VALID_ERROR_TOKEN.getMsg());
        }
        // 根据 userid 查询数据库
        log.warn("===========token验证：查询数据库=============");
        User user = userService.getById(userId);
        if (user == null){
            throw new ServiceException(ErrorCodeEnum.NULL_TOKEN.getCode(), ErrorCodeEnum.NULL_TOKEN.getMsg());
        }
        // 用户加签验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTVerificationException e){
            throw new ServiceException(ErrorCodeEnum.VALID_ERROR_TOKEN.getCode(), ErrorCodeEnum.VALID_ERROR_TOKEN.getMsg());
        }
        return true;
    }
}
