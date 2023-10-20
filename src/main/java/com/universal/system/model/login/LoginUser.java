package com.universal.system.model.login;

import com.universal.system.model.SysUser;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author 姓陈的
 * 2023/10/20 15:50
 */
@ToString
public class LoginUser extends User {

    private static final long serialVersionUID = 1L;

    private SysUser sysUser;

    public LoginUser(SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {
        super(sysUser.getUserName(), sysUser.getPassword(), authorities);
        this.sysUser = sysUser;
    }


    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
