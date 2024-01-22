package com.universal.system.model;


import lombok.Data;
import lombok.ToString;

/**
 * 角色和菜单关联 sys_role_menu
 * 
 *   @author 姓陈的
 */
@Data
@ToString
public class SysRoleMenu
{
    /** 角色ID */
    private Long roleId;
    
    /** 菜单ID */
    private Long menuId;




}
