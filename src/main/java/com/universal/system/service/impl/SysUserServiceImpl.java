package com.universal.system.service.impl;

import com.universal.system.common.exception.UniversalException;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.common.utils.SecurityUtil;
import com.universal.system.common.utils.StringUtils;
import com.universal.system.mapper.SysUserMapper;
import com.universal.system.mapper.SysUserRoleMapper;
import com.universal.system.model.SysUser;
import com.universal.system.model.SysUserRole;
import com.universal.system.service.SysUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 姓陈的
 * 2023/10/30 10:38
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper userMapper;
    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public List<SysUser> selectUserList(SysUser sysUser) {
        return userMapper.selectUserList(sysUser);
    }

    @Override
    public List<SysUser> selectAllocatedList(SysUser user) {
        return null;
    }

    @Override
    public List<SysUser> selectUnallocatedList(SysUser user) {
        return null;
    }

    @Override
    public SysUser selectUserByUserName(String userName) {
        return null;
    }

    @Override
    public SysUser selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Transactional
    @Override
    public int insertUser(SysUser user) {
        user.setCreateBy(SecurityUtil.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int i = userMapper.insertUser(user);
        insertUserRole(user.getUserId(), user.getRoleIds());
        return i;
    }

    @Transactional
    @Override
    public int updateUser(SysUser user) {

        int i = userMapper.updateUser(user);
        userRoleMapper.deleteUserRoleByUserId(user.getUserId());
        insertUserRole(user.getUserId(), user.getRoleIds());
        return i;
    }

    @Override
    public int updateUserStatus(SysUser user) {

        if (user.isAdmin()){
            throw new UniversalException(HttpStatus.ERROR,"此用户不允许修改状态");
        }

        return userMapper.updateUserStatus(user);
    }

    @Override
    public int updateUserAvatar(String userName, String avatar) {
        return 0;
    }

    @Override
    public int resetUserPwd(String userName, String password) {
        return 0;
    }

    @Override
    public int deleteUserById(Long userId) {
        return 0;
    }

    @Transactional
    @Override
    public int deleteUserByIds(Long[] userIds) {

        for (Long userId : userIds)
        {
            checkUserAllowed(new SysUser(userId));
        }

        userRoleMapper.deleteUserRole(userIds);

        return userMapper.deleteUserByIds(userIds);
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean checkUserNameUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkUserNameUnique(user.getUserName());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return false;
        }
        return true;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean checkPhoneUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return false;
        }
        return true;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean checkEmailUnique(SysUser user) {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUser info = userMapper.checkEmailUnique(user.getEmail());
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue()) {
            return false;
        }
        return true;
    }

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    @Override
    public void checkUserAllowed(SysUser user) {
        if (StringUtils.isNotNull(user.getUserId()) && user.isAdmin()) {
            throw new UniversalException(HttpStatus.ERROR, "不允许操作超级管理员用户");
        }
    }


    /**
     * 添加用户角色信息
     *
     * @param userId
     * @param roleIds
     */
    public void insertUserRole(Long userId, Long[] roleIds) {
        if (StringUtils.isNotEmpty(roleIds)) {
            List<SysUserRole> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                list.add(new SysUserRole(userId, roleId));
            }
            //添加角色信息
            userRoleMapper.batchUserRole(list);
        }
    }
}
