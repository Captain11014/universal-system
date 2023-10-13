package com.universal.system;

import com.universal.system.mapper.SysUserMapper;
import com.universal.system.model.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UniversalSystemApplicationTests {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {

        SysUser sysUser = sysUserMapper.selectById(1);
        System.out.println(sysUser);

    }

}
