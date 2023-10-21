package com.universal.system.service.impl;

import cn.hutool.core.lang.UUID;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.exception.UniversalException;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.common.utils.AuthenticationContextHolder;
import com.universal.system.common.utils.RedisCache;
import com.universal.system.common.utils.jwt.JwtUtil;
import com.universal.system.model.login.LoginBody;
import com.universal.system.model.login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 姓陈的
 * 2023/10/20 16:50
 */
@Service
public class SysLogService {


    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    @Resource
    private JwtUtil jwtUtil;

    /**
     * 登录认证
     * @param loginBody
     * @return
     */
    public String login(LoginBody loginBody){

        // 用户验证
        Authentication authentication = null;

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginBody.getUsername(),loginBody.getPassword());
            AuthenticationContextHolder.setContext(authenticationToken);
            authentication = authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            if (e instanceof BadCredentialsException)
            {
                throw new UniversalException(HttpStatus.ERROR,"账号或密码错误");
            }
            else
            {
                throw new UniversalException(HttpStatus.ERROR,e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }

        String tokenKey = UUID.randomUUID().toString();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        redisCache.setLoginUser(Constants.LOGIN_TOKENS+tokenKey,loginUser);

        return jwtUtil.createToken(tokenKey);

    }



}
