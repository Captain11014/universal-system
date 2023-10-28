package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.page.TableDataInfo;
import com.universal.system.common.result.AjaxResult;
import com.universal.system.model.SysRole;
import com.universal.system.service.SysRoleService;
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


    /**
     * 根据条件分页查询角色数据
     *
     * @param sysRole 角色信息
     * @return 角色数据集合信息
     */
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
    @PutMapping("updateRole")
    public AjaxResult updateRole(@RequestBody SysRole role){
        if(!sysRoleService.checkRoleKeyUnique(role)){
            return error(role.getRoleKey()+"已存在");
        }
        if(!sysRoleService.checkRoleNameUnique(role)){
            return error(role.getRoleName()+"已存在");
        }

        return toAjax(sysRoleService.updateRole(role));
    }

    /**
     * 删除角色
     * @param roleIds
     * @return
     */
    @DeleteMapping("/{roleIds}")
    public AjaxResult deleteRole(@PathVariable Long[] roleIds){

        return toAjax(sysRoleService.deleteRoleByIds(roleIds));

    }







}
