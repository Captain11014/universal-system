package com.universal.system;

import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.utils.RedisCache;
import com.universal.system.mapper.SysUserMapper;
import com.universal.system.model.SysUser;
import com.universal.system.model.login.LoginUser;
import com.universal.system.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class UniversalSystemApplicationTests {

//    @Resource
//    private SysUserMapper sysUserMapper;
//
//    @Autowired
//    private RedisCache redisCache;
//
//    @Resource
//    private ObjectMapper mapper;
//
//    @Resource
//    private EmailService emailService;
//
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {

        String encode = passwordEncoder.encode("@chen$captain_2001");
        System.out.println(encode);
    }


    @Test
    void redisCacheTest() throws JsonProcessingException {


//        String s = "{\"sysUser\":{\"userId\":1,\"userName\":\"admin\",\"nickName\":\"若依\",\"email\":\"2109276571@qq.com\",\"phonenumber\":\"15888888888\",\"gender\":\"1\",\"avatar\":\"\",\"password\":\"$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2\",\"status\":\"0\",\"delFlag\":\"0\",\"loginIp\":\"\",\"loginDate\":1697700445000,\"roles\":[],\"createBy\":\"admin\",\"createTime\":1695475502000,\"remark\":\"超级管理员\",\"params\":{}},\"expireTime\":90000000,\"username\":\"admin\",\"authorities\":[],\"accountNonExpired\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"enabled\":true}\n";
//
//        LoginUser loginUser = mapper.readValue(s, LoginUser.class);
//        System.out.println(loginUser);
//        String key = Constants.LOGIN_TOKENS + UUID.randomUUID().toString();
//        SysUser sysUser = sysUserMapper.selectUserById(1L);
//        redisCache.setString(key,sysUser);
//
//
//        System.out.println(redisCache.getJsonStr(key));
    }


}
