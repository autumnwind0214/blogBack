package com.autumn.blog.model.vo;

import lombok.Data;

/**
 * @ClassName UserRoleInfoVO
 * @Author sz
 * @Date 2024/4/9 11:00
 * @Version 1.0
 */
@Data
public class UserRoleVo {

    // 用户ID
    private Long userId;

    // 角色信息,多个逗号分隔
    private String roleInfos;

    // 角色ID
    private String roleIds;

}
