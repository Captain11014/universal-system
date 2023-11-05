package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.SecurityUtil;
import com.universal.system.model.SysMenu;
import com.universal.system.model.SysUser;
import com.universal.system.model.login.LoginBody;
import com.universal.system.service.SysMenuService;
import com.universal.system.service.impl.SysLogService;
import com.universal.system.service.impl.SysPermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author 姓陈的
 * 2023/10/17 16:17
 */
@RestController
public class LoginController extends BaseController {

    @Resource
    private SysLogService sysLogService;
    @Resource
    private SysPermissionService permissionService;
    @Resource
    private SysMenuService menuService;

    /**
     * 登录接口
     *
     * @param loginBody
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        System.out.println(loginBody);
        AjaxResult ajax = AjaxResult.success();
        String token = sysLogService.login(loginBody);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    @GetMapping("/getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtil.getLoginUser().getSysUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }


    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters()
    {
        Long userId = SecurityUtil.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }


}
