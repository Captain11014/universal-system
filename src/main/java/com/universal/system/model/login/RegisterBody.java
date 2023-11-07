package com.universal.system.model.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 姓陈的
 * 2023/11/6 23:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegisterBody {

    private String username;
    private String password;
    private String confirmPassword;
    private String code;

}
