package com.universal.system.service.impl;

import com.universal.system.mapper.SysRoleMapper;
import com.universal.system.model.SysRole;
import com.universal.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 姓陈的
 * 2023/10/27 15:49
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectRoleList(SysRole role) {
        return sysRoleMapper.selectRoleList(role);
    }

    @Override
    public List<SysRole> selectRolePermissionByUserId(Long userId) {
        return sysRoleMapper.selectRolePermissionByUserId(userId);
    }

    @Override
    public List<SysRole> selectRoleAll() {
        return sysRoleMapper.selectRoleAll();
    }

    @Override
    public List<Long> selectRoleListByUserId(Long userId) {
        return sysRoleMapper.selectRoleListByUserId(userId);
    }

    @Override
    public SysRole selectRoleById(Long roleId) {
        return sysRoleMapper.selectRoleById(roleId);
    }

    @Override
    public List<SysRole> selectRolesByUserName(String userName) {
        return sysRoleMapper.selectRolesByUserName(userName);
    }

    @Override
    public SysRole checkRoleNameUnique(String roleName) {
        return sysRoleMapper.checkRoleNameUnique(roleName);
    }

    @Override
    public SysRole checkRoleKeyUnique(String roleKey) {
        return sysRoleMapper.checkRoleKeyUnique(roleKey);
    }

    @Override
    public int updateRole(SysRole role) {
        return sysRoleMapper.updateRole(role);
    }

    @Override
    public int insertRole(SysRole role) {
        return sysRoleMapper.insertRole(role);
    }

    @Override
    public int deleteRoleById(Long roleId) {
        return sysRoleMapper.deleteRoleById(roleId);
    }

    @Override
    public int deleteRoleByIds(Long[] roleIds) {
        return deleteRoleByIds(roleIds);
    }
}
