package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.SecurityUtil;
import com.universal.system.model.SysUser;
import com.universal.system.model.login.LoginBody;
import com.universal.system.service.impl.SysLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 姓陈的
 * 2023/10/17 16:17
 */
@RestController
public class LoginController extends BaseController {

    @Resource
    private SysLogService sysLogService;

    /**
     * 登录接口
     * @param loginBody
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        System.out.println(loginBody);
        AjaxResult ajax = AjaxResult.success();
        String token = sysLogService.login(loginBody);
        ajax.put(Constants.TOKEN,token);
        return ajax;
    }

    @PreAuthorize("@cp.hasPerm('test11')")
    @GetMapping("/getInfo")
    public AjaxResult getInfo(){

        AjaxResult ajax = AjaxResult.success();
        ajax.put("data","666666666666666666666666666");
        ajax.put("id", SecurityUtil.getUserId());
        return ajax;

    }



}
