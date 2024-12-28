package com.autumn.blog.model.dto;

import com.autumn.blog.model.base.PageQuery;
import lombok.Data;

/**
 * @author autumn
 * @description 用户查询
 * @date 2024年11月24日
 * @version: 1.0
 */
@Data
public class UserInfoDto extends PageQuery {

    // 用户名
    private String username;

    // 昵称
    private String nickname;

    // 手机号
    private String phone;
}
