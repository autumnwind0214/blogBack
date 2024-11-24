package com.autumn.blog.model.form;

import com.autumn.blog.common.base.PageQuery;
import lombok.Data;

/**
 * @author autumn
 * @description UserInfoForm
 * @date 2024年11月24日
 * @version: 1.0
 */
@Data
public class UserInfoForm extends PageQuery {

    // 用户名
    private String username;

    // 昵称
    private String nickname;

    // 手机号
    private String phone;
}
