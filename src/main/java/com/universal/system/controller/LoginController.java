package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.model.SysUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 姓陈的
 * 2023/10/17 16:17
 */
@RestController
public class LoginController extends BaseController {

    /**
     * 登录接口
     * @param sysUser
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody SysUser sysUser){
        System.out.println(sysUser);
        AjaxResult ajax = AjaxResult.success();
        ajax.put(Constants.TOKEN,"admin1111111");
        return ajax;
    }



}
