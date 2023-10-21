package com.universal.system.common.utils;

import com.universal.system.common.exception.UniversalException;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.model.login.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 姓陈的
 * 2023/10/21 22:52
 */
public class SecurityUtil {

    /**
     * 获取当前用户ID
     * @return
     */
    public static Long getUserId(){

        try
        {
            return getLoginUser().getSysUser().getUserId();
        }
        catch (Exception e)
        {
            throw new UniversalException(HttpStatus.UNAUTHORIZED,"获取用户信息异常");
        }

    }

    /**
     * 获取用户名
     * @return
     */
    public static String getUserName(){

        try
        {
            return getLoginUser().getUsername();
        }
        catch (Exception e)
        {
            throw new UniversalException(HttpStatus.UNAUTHORIZED,"获取用户信息异常");
        }

    }


    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser()
    {
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            throw new UniversalException(HttpStatus.UNAUTHORIZED,"获取用户信息异常");
        }
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }

}
