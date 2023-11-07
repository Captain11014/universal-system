package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.RedisCache;
import com.universal.system.common.utils.SecurityUtil;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.mapper.SysUserMapper;
import com.universal.system.model.SysMenu;
import com.universal.system.model.SysUser;
import com.universal.system.model.login.LoginBody;
import com.universal.system.model.login.RegisterBody;
import com.universal.system.service.SysMenuService;
import com.universal.system.service.impl.SysLoginService;
import com.universal.system.service.impl.SysPermissionService;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private SysLoginService sysLoginService;
    @Resource
    private SysPermissionService permissionService;
    @Resource
    private SysMenuService menuService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private RedisCache redisCache;

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
        String token = sysLoginService.login(loginBody);
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

    /**
     * 注册
     * @param registerBody
     * @return
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody registerBody){

        String str = redisCache.getCacheObject(Constants.REGISTER_EMAIL_CODE+registerBody.getUsername()).toString();

        System.out.println(Constants.REGISTER_EMAIL_CODE+registerBody.getUsername()+"======================="+str);
        System.out.println(registerBody);
        if(StringUtils.isEmpty(str)){
            return error("验证码已过期");
        }

        if(!registerBody.getCode().equals(str)){
            return error("验证码错误");
        }

        if(!registerBody.getPassword().equals(registerBody.getConfirmPassword())){
            return error("密码不一致");
        }
        //TODO 校验邮箱
        SysUser user = new SysUser();
        user.setPassword(passwordEncoder.encode(registerBody.getPassword()));
        user.setUserName(registerBody.getUsername());
        user.setEmail(registerBody.getUsername());
        user.setNickName(registerBody.getUsername());

        return toAjax(userMapper.insertUser(user));

    }


}
