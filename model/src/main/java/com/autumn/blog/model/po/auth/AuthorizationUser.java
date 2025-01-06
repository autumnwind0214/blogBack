package com.autumn.blog.model.po.auth;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("authorization_user")
public class AuthorizationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    Long id;

    // 用户名
    String username;

    // 密码
    String password;

    // 手机号
    String phone;

    // 昵称
    String nickname;

    // 邮箱
    String email;

    // 头像地址
    String avatarUrl;

    // 生日
    LocalDateTime birthday;

    // 性别
    Byte sex;

    // 最后登录时间
    LocalDateTime lastLoginTime;



    /**
     * 创建时间 自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新时间 自动填充
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     **/
    @TableLogic
    private Byte flag;


}
