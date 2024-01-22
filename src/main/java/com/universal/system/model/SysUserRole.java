package com.universal.system.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户和角色关联 sys_user_role
 * 
 *   @author 姓陈的
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRole
{
    /** 用户ID */
    private Long userId;
    
    /** 角色ID */
    private Long roleId;

}
