package com.universal.system.common.interceptor;

import com.universal.system.common.constant.Constants;
import com.universal.system.common.utils.RedisCache;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.common.utils.jwt.JwtUtil;
import com.universal.system.model.login.LoginUser;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 姓陈的
 * 2023/10/21 17:16
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //获取登录用户tokenKey
        String tokenKey = jwtUtil.getTokenKey(request);
        if (StringUtils.isEmpty(tokenKey)) {
            //如果token解析为空则放行
            filterChain.doFilter(request, response);
            return;
        }

        //获取redis缓存对象
        String key = Constants.LOGIN_TOKENS + tokenKey;
//        LoginUser loginUser = redisCache.getCacheObject(key);
        LoginUser loginUser = redisCache.getLoginUser(key);


        if (StringUtils.isNull(loginUser)) {
            //redis获取当前用户为空则放行
            filterChain.doFilter(request, response);
            return;
        }
        redisCache.verifyToken(loginUser,key);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);

    }
}
