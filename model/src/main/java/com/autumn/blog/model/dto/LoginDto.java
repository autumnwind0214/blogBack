package com.autumn.blog.model.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * @author autumn
 * @description 登录表单
 * @date 2024年11月09日
 * @version: 1.0
 */
@Data
public class LoginDto {

    // 用户名
    String username;

    // 密码
    String password;

    // 手机号
    String cellphone;

    // 验证码
    String checkCode;

    // 验证码key
    String checkCodeKey;
    // 认证的类型   password:用户名密码模式类型    sms:短信模式类型
    String authType;

    // 附加数据，作为扩展，不同认证类型可拥有不同的附加数据。如认证类型为短信时包含smsKey : sms:3d21042d054548b08477142bbca95cfa;
    // 所有情况下都包含clientId
    Map<String, Object> payload = new HashMap<>();
}
