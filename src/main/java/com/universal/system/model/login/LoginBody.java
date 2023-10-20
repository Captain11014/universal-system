package com.universal.system.model.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 姓陈的
 * 2023/10/20 16:53
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LoginBody {

    private String username;

    private String password;

    private String code;

    private String uuid;

}
