package com.universal.system.service.impl;

import com.universal.system.common.utils.StringUtils;
import com.universal.system.mapper.SysRoleMapper;
import com.universal.system.mapper.SysUserRoleMapper;
import com.universal.system.model.SysRole;
import com.universal.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private SysUserRoleMapper userRoleMapper;

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
    public boolean checkRoleNameUnique(SysRole role) {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = sysRoleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkRoleKeyUnique(SysRole role) {

        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = sysRoleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return false;
        }
        return true;

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

    @Transactional
    @Override
    public int deleteRoleByIds(Long[] roleIds) {

        userRoleMapper.deleteUserRoleByIds(roleIds);

        return sysRoleMapper.deleteRoleByIds(roleIds);
    }
}
