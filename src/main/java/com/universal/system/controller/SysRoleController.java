package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.constant.Constants;
import com.universal.system.common.page.TableDataInfo;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.common.utils.RedisCache;
import com.universal.system.common.utils.ServletUtil;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.common.utils.annotation.Log;
import com.universal.system.common.utils.jwt.JwtUtil;
import com.universal.system.model.SysRole;
import com.universal.system.model.SysUser;
import com.universal.system.model.SysUserRole;
import com.universal.system.model.login.LoginUser;
import com.universal.system.service.SysRoleService;
import com.universal.system.service.SysUserService;
import com.universal.system.service.impl.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.List;

/**
 * @author 姓陈的
 * 2023/10/27 15:58
 */
@Api(tags = "角色模块")
@RestController
@RequestMapping("/system/role")
public class SysRoleController extends BaseController {

    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysUserService userService;
    @Resource
    private SysPermissionService permissionService;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisCache redisCache;


    /**
     * 根据条件分页查询角色数据
     *
     * @param sysRole 角色信息
     * @return 角色数据集合信息
     */
    @PreAuthorize("@cp.hasPerm('system:role:list')")
    @ApiOperation(value = "角色列表")
    @GetMapping("/list")
    public TableDataInfo selectRoleList(SysRole sysRole){
        startPage();
        List<SysRole> sysRoles = sysRoleService.selectRoleList(sysRole);
        return getDataTable(sysRoles);
    }

    /**
     * 根据角色编号获取详细信息
     */
    @PreAuthorize("@cp.hasPerm('system:role:select')")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable Long roleId)
    {
        return success(sysRoleService.selectRoleById(roleId));
    }
    /**
     * 新增角色
     * @param role
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:role:add')")
    @Log(title = "角色管理",operate = Constants.OPERATE_INSERTE)
    @PostMapping("/addRole")
    public AjaxResult insertRole(@RequestBody SysRole role){

        if(!sysRoleService.checkRoleKeyUnique(role)){
            return error(role.getRoleKey()+"已存在");
        }
        if(!sysRoleService.checkRoleNameUnique(role)){
            return error(role.getRoleName()+"已存在");
        }

        return toAjax(sysRoleService.insertRole(role));


    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:role:edit')")
    @Log(title = "角色管理",operate = Constants.OPERATE_UPDATE)
    @PutMapping("updateRole")
    public AjaxResult updateRole(@RequestBody SysRole role){
        if(!sysRoleService.checkRoleKeyUnique(role)){
            return error(role.getRoleKey()+"已存在");
        }
        if(!sysRoleService.checkRoleNameUnique(role)){
            return error(role.getRoleName()+"已存在");
        }
        role.setUpdateBy(getUsername());

        if (sysRoleService.updateRole(role) > 0)
        {
            // 更新缓存用户权限
            LoginUser loginUser = getLoginUser();
            if (StringUtils.isNotNull(loginUser.getSysUser()) && !loginUser.getSysUser().isAdmin())
            {
                loginUser.setPermissions(permissionService.getMenuPermission(loginUser.getSysUser()));
                loginUser.setSysUser(userService.selectUserByUserName(loginUser.getSysUser().getUserName()));
                String tokenKey = Constants.LOGIN_TOKENS + jwtUtil.getTokenKey(ServletUtil.getRequest());
                redisCache.setLoginUser(tokenKey,loginUser);
            }
            return success();
        }
        return error("修改角色'" + role.getRoleName() + "'失败，请联系管理员");

    }

    /**
     * 删除角色
     * @param roleIds
     * @return
     */
    @PreAuthorize("@cp.hasPerm('system:role:remove')")
    @Log(title = "角色管理",operate = Constants.OPERATE_DELETE)
    @DeleteMapping("/{roleIds}")
    public AjaxResult deleteRole(@PathVariable Long[] roleIds){

        return toAjax(sysRoleService.deleteRoleByIds(roleIds));

    }

    /**
     * 修改角色状态
     * @param role
     * @return
     */
    @Log(title = "角色管理",operate = Constants.OPERATE_UPDATE)
    @PreAuthorize("@cp.hasPerm('system:role:edit')")
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody SysRole role){

        if(role.isAdmin()){
            return error("此角色状态不允许修改");
        }

        return toAjax(sysRoleService.updateRole(role));
    }


    /**
     * 查询已分配用户角色列表
     */
    @PreAuthorize("@cp.hasPerm('system:role:list')")
    @GetMapping("/authUser/allocatedList")
    public TableDataInfo allocatedList(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectAllocatedList(user);
        return getDataTable(list);
    }

    /**
     * 查询未分配用户角色列表
     */
    @PreAuthorize("@cp.hasPerm('system:role:list')")
    @GetMapping("/authUser/unallocatedList")
    public TableDataInfo unallocatedList(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectUnallocatedList(user);
        return getDataTable(list);
    }


    /**
     * 批量选择用户授权
     */
    @Log(title = "角色管理",operate = Constants.OPERATE_UPDATE)
    @PreAuthorize("@cp.hasPerm('system:role:edit')")
    @PutMapping("/authUser/selectAll")
    public AjaxResult selectAuthUserAll(Long roleId, Long[] userIds)
    {
        return toAjax(sysRoleService.insertAuthUsers(roleId, userIds));
    }


    /**
     * 取消授权用户
     */
    @Log(title = "角色管理",operate = Constants.OPERATE_UPDATE)
    @PreAuthorize("@cp.hasPerm('system:role:edit')")
    @PutMapping("/authUser/cancel")
    public AjaxResult cancelAuthUser(@RequestBody SysUserRole userRole)
    {
        return toAjax(sysRoleService.deleteAuthUser(userRole));
    }

    /**
     * 批量取消授权用户
     */
    @Log(title = "角色管理",operate = Constants.OPERATE_UPDATE)
    @PreAuthorize("@cp.hasPerm('system:role:edit')")
    @PutMapping("/authUser/cancelAll")
    public AjaxResult cancelAuthUserAll(Long roleId, Long[] userIds)
    {
        return toAjax(sysRoleService.deleteAuthUsers(roleId, userIds));
    }







}
