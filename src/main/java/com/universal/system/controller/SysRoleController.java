package com.universal.system.controller;

import com.universal.system.base.BaseController;
import com.universal.system.common.page.TableDataInfo;
import com.universal.system.model.SysRole;
import com.universal.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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







}
