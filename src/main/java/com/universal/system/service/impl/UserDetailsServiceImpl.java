package com.universal.system.service.impl;

import com.universal.system.common.enums.UserStatus;
import com.universal.system.common.exception.UniversalException;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.mapper.SysUserMapper;
import com.universal.system.model.SysUser;
import com.universal.system.model.login.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author 姓陈的
 * 2023/10/20 16:18
 * 登录验证
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserMapper.selectUserByUserName(username);

        if(StringUtils.isNull(sysUser)){
            log.info("用户{}不存在",username);
            throw new UniversalException(HttpStatus.ERROR,"用户不存在");
        }

        if(UserStatus.DISABLE.getCode().equals(sysUser.getStatus())){
            log.info("用户{}已停用",username);
            throw new UniversalException(HttpStatus.ERROR,"用户已停用，请联系管理员");
        }

        if(UserStatus.DELETED.getCode().equals(sysUser.getDelFlag())){
            log.info("用户{}已删除",username);
            throw new UniversalException(HttpStatus.ERROR,"用户已注销！");
        }

        return new LoginUser(sysUser, permissionService.getMenuPermission(sysUser));
    }



}
