package com.universal.system.model;


import lombok.Data;
import lombok.ToString;

/**
 * 用户和角色关联 sys_user_role
 * 
 * @author ruoyi
 */
@Data
@ToString
public class SysUserRole
{
    /** 用户ID */
    private Long userId;
    
    /** 角色ID */
    private Long roleId;

}