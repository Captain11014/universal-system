package com.universal.system.common.handel;

import cn.hutool.json.JSONUtil;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.RedisCache;
import com.universal.system.common.utils.ServletUtil;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.common.utils.jwt.JwtUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 姓陈的
 * 自定义退出处理类 返回成功
 * 2023/10/23 9:39
 */
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Resource
    private RedisCache redisCache;

    @Resource
    private JwtUtil jwtUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        //获取token
        String tokenKey = jwtUtil.getTokenKey(request);
        if(StringUtils.isNotEmpty(tokenKey)){
            String userKey = Constants.LOGIN_TOKENS + tokenKey;
            redisCache.delCache(userKey);
        }

        ServletUtil.renderString(response, JSONUtil.toJsonStr(AjaxResult.success("退出成功")));

    }
}
