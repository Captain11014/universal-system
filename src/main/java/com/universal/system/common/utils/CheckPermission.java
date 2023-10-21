package com.universal.system.common.utils;

import com.universal.system.model.login.LoginUser;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author 姓陈的
 * 2023/10/21 22:48
 * 校验用户是否拥有权限
 */
@Service("cp")
public class CheckPermission {

    /** 所有权限标识 */
    private static final String ALL_PERMISSION = "*:*:*";

    /** 管理员角色权限标识 */
    private static final String SUPER_ADMIN = "admin";

    private static final String ROLE_DELIMETER = ",";

    private static final String PERMISSION_DELIMETER = ",";

    /**
     * 校验用户是否有权限
     * @param permission 权限字符
     * @return
     */
    public boolean hasPerm(String permission){

        if(StringUtils.isEmpty(permission)) return false;
        LoginUser loginUser = SecurityUtil.getLoginUser();
        Set<String> permissions = loginUser.getPermissions();
        if(StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(permissions)) return false;

        return permissions.contains(permission) || permissions.contains(ALL_PERMISSION);
    }



}
