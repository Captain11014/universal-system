package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.page.TableDataInfo;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.common.utils.annotation.Log;
import com.universal.system.model.SysRole;
import com.universal.system.model.SysUser;
import com.universal.system.service.SysRoleService;
import com.universal.system.service.SysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 姓陈的
 * 2023/10/30 10:33
 */
@RestController
@RequestMapping("/system/user")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService userService;
    @Resource
    private SysRoleService roleService;

    /**
     * 获取用户列表
     * @param user
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysUser user){
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出用户excel数据
     * @param response
     * @param user
     */
    @PreAuthorize("@cp.hasPerm('system:user:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUser user){
        //查询数据
        List<SysUser> list = userService.selectUserList(user);
        //构建导出数据
        List<List<Object>> writerData = list.stream().map(u -> {
            List<Object> data = new ArrayList<>();
            data.add(u.getUserName());
            data.add(u.getNickName());
            data.add(u.getEmail());
            data.add(u.getPhonenumber());
            data.add(u.getGender().equals("0")?"男":"女");
            data.add(u.getStatus().equals("0")?"正常":"停用");
            return data;
        }).collect(Collectors.toList());
        //文件名如果前端不设置则使用后端设置的文件名
        exportNoModelExcel(response,buildExcelHead(List.of("用户名","昵称","邮箱","电话号码","性别","用户状态")),writerData);
    }



    /**
     * 根据用户Id获取详细信息
     * @param userId
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:user:select')")
    @GetMapping(value = { "/", "/{userId}" })
    public AjaxResult selectUserById(@PathVariable(value = "userId", required = false) Long userId){

        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        ajax.put("roles",SysUser.isAdmin(userId)?roles:roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        if(StringUtils.isNotNull(userId)){
            SysUser sysUser = userService.selectUserById(userId);
            ajax.put("data",sysUser);
            ajax.put("roleIds",sysUser.getRoles().stream().map(SysRole::getRoleId).collect(Collectors.toList()));
        }
        return ajax;

    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:user:add')")
    @Log(title = "用户管理",operate = Constants.OPERATE_INSERTE)
    @PostMapping
    public AjaxResult addUser(@RequestBody SysUser user){

        if (!userService.checkUserNameUnique(user))
        {
            return error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
        {
            return error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
        {
            return error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }

        return toAjax(userService.insertUser(user));

    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:user:edid')")
    @Log(title = "用户管理",operate = Constants.OPERATE_UPDATE)
    @PutMapping
    public AjaxResult updateUser(@RequestBody SysUser user){

        userService.checkUserAllowed(user);
        if (!userService.checkUserNameUnique(user))
        {
            return error("修改用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
        {
            return error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
        {
            return error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }

        return toAjax(userService.updateUser(user));

    }

    /**
     * 删除用户
     * @param userIds
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:user:remove')")
    @Log(title = "用户管理",operate = Constants.OPERATE_DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult deleteUser(@PathVariable Long[] userIds){
        if (ArrayUtils.contains(userIds, getUserId()))
        {
            return error("当前用户不能删除");
        }
        return toAjax(userService.deleteUserByIds(userIds));
    }

    /**
     * 更新用户状态
     * @param user
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:user:edit')")
    @Log(title = "用户管理",operate = Constants.OPERATE_UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysUser user){
        return toAjax(userService.updateUserStatus(user));
    }


    /**
     * 根据用户编号获取授权角色
     */
    @GetMapping("/authRole/{userId}")
    public AjaxResult authRole(@PathVariable("userId") Long userId)
    {
        AjaxResult ajax = AjaxResult.success();
        SysUser user = userService.selectUserById(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        ajax.put("user", user);
        ajax.put("roles", SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()));
        return ajax;
    }

    /**
     * 用户授权角色
     */
    @PreAuthorize("@cp.hasPerm('system:user:edit')")
    @Log(title = "用户管理",operate = Constants.OPERATE_UPDATE)
    @PutMapping("/authRole")
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds)
    {
        userService.insertUserAuth(userId, roleIds);
        return success();
    }

}
